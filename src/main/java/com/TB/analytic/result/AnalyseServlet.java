package com.TB.analytic.result;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.TB.TBox.note.bean.Authority;
import com.TB.TBox.note.bean.Evaluate;
import com.TB.TBox.note.bean.Note;
import com.TB.TBox.note.service.AuthorityService;
import com.TB.TBox.note.service.EvaluateService;
import com.TB.TBox.note.service.NoteService;
import com.TB.TBox.user.bean.Friends;
import com.TB.TBox.user.bean.User;
import com.TB.TBox.user.service.FriendService;
import com.TB.TBox.user.service.UserService;
import com.TB.analytic.library.Advice;
import com.TB.analytic.library.Library;
import com.google.gson.Gson;


/**
 * Servlet implementation class UserServlet
 */

@Controller
@RequestMapping("/analyse")
@Scope("prototype")
public class AnalyseServlet {
	static DecimalFormat df = new DecimalFormat("0.00");
	@Autowired
	FriendService friends = new FriendService();
	@Autowired
	private EvaluateService evaluateService;
	@Autowired
	private AuthorityService authorityService;
	@Autowired
	private NoteService noteService;
	@Autowired
	AnalyseService analyseService;
	Gson gson = new Gson();
	/**
	 * 为后边的折线图做准备
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "selectAllmoodValue")
	public void selectAllmoodValue(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String number = request.getParameter("userNumber");
		List<Library> lib = new ArrayList<>();
		List<Library> newLib = new ArrayList<>();
		lib = analyseService.selectValue(number);
		// 如果返回太多分析数据，则截取最新的10个
		if (lib.size() > 10) {
			for (int i = 0; i < 10; i++) {
				newLib.add(lib.get(i));
			}
		} else {
			newLib = lib;
		}
		response.setContentType("text/json");
		PrintWriter out = response.getWriter();
		out.print(gson.toJson(newLib));
		out.flush();
		out.close();
	}
	@RequestMapping(value = "/selectValue")
	public void selectValue(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String userNumber = request.getParameter("number");
		UserService userService = new UserService();
		List<Library> lib = new ArrayList<>();
		lib = AnalyseService.selectValue(userNumber);
		User user = userService.selectUserByNumber(userNumber);
		double moodValue = getMood(lib);// 情感值(目前还不是百分比)
		double stability = getStability(lib);// 得到稳定性
		double interaction = getInteraction(lib,user.getUid());// 得到互动情况
		double rational = getRational(lib);// 得到感性
		double secrate = getSecrate(lib, user.getUid());// 得到开放程度
		Map<String,Double> map =new HashMap<String,Double>();
		map = getmoodAnalyse(user.getUid()); 
		ReturnPro pro = new ReturnPro(moodValue, stability, interaction, rational, secrate,map.get("happy"),map.get("veryhappy"), map.get("sad"), map.get("scard"), map.get("commen"));//构造返回对象
		
		response.setContentType("text/json");
		PrintWriter out = response.getWriter(); 
		out.print(gson.toJson(pro));
		out.flush();
		out.close();
	}
	
	/**
	 * 由心情给出建议
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/getAdvice")
	public void getAdvice(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		// 得到情绪值
		String userNumber = request.getParameter("number");
		UserService userService = new UserService();
		List<Library> lib = new ArrayList<>();
		lib = AnalyseService.selectValue(userNumber);
		User user = userService.selectUserByNumber(userNumber);
		double moodValue = getMood(lib);// 情感值(目前还不是百分比)
		double stability = getStability(lib);// 得到稳定性
		double interaction = getInteraction(lib, user.getUid());// 得到互动情况
		double secrate = getSecrate(lib, user.getUid());// 得到开放程度
		// 建议
		String advice = advice(moodValue, stability, interaction, secrate);

		Map<String, String> advicemap = new HashMap<>();
		advicemap.put("diet", analyseService.dietselect());
		advicemap.put("point", analyseService.pointselect());

		response.setContentType("text/json");
		PrintWriter out = response.getWriter();
		out.print(gson.toJson(advicemap));
		out.flush();
		out.close();
	}

	/**
	 * 得到具体建议
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "getMoodAdvice")
	public void getMoodAdvice(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		// 得到情绪值
		String userNumber = request.getParameter("number");
		UserService userService = new UserService();
		List<Library> lib = new ArrayList<>();
		lib = AnalyseService.selectValue(userNumber);
		User user = userService.selectUserByNumber(userNumber);
		double moodValue = getMood(lib);// 情感值(目前还不是百分比)
		double stability = getStability(lib);// 得到稳定性
		double interaction = getInteraction(lib, user.getUid());// 得到互动情况
		double secrate = getSecrate(lib, user.getUid());// 得到开放程度
		// 建议
		String advice = advice(moodValue, stability, interaction, secrate);
		Advice ad = new Advice();
		ad.setAdvice(advice);
		response.setContentType("text/json");
		PrintWriter out = response.getWriter();
		out.print(gson.toJson(ad));
		out.flush();
		out.close();
	}

	private String advice(double moodValue, double stability, double interaction, double secrate) {
		String advice = null;
		if (moodValue == 0 && stability == 0 && interaction == 0 && secrate == 0) {
			advice = "您还没有任何可以让我们分析的内容，快去加几个好友，分享你们之间的事吧";
		} else {
			if (moodValue <= 0) {
				// 如果情绪值偏低
				if (stability < 0.5) {
					// 情绪值偏低，情绪不稳定
					if (interaction < 0.5 || secrate < 0.5) {
						// 情绪值偏低，情绪不稳定,内向
						advice = "根据您最近的情况来看，情绪总体处于消极状态，您最近可以找一找要好的朋友或亲近的人沟通倾诉一下。您的数据"
								+ "显示您的性格偏内向，内向的人善于单独思考、比较喜欢独处，但在情绪频繁处于低落情况下，和他人沟通倾诉是缓解"
								+ "低落情绪，为此时的状况找到新出口的有效途径。在您独处时，可选择冥想、听音乐、或是看书来提升自己的心境，控制自己的情绪。";
					} else {
						// 情绪值偏低，情绪不稳定,外向
						advice = "根据您最近的情况来看，情绪总体处于消极状态，您可以找一个安静，能让自己静下心来的地方度过一段独处的时间。"
								+ "您的数据显示您的性格偏外向，外向的人愿意交流和展现自己，因此也容易再与他人的交流中意见不合而受挫、情绪低落。"
								+ "这时回归自身内心是一个不错的选择，静下心来思考自己，也许会发现事情没那么糟糕。";
					}
				} else {
					// 情绪值偏低,情绪稳定
					if (interaction < 0.5 || secrate < 0.5) {
						// 情绪值偏低，情绪稳定,内向
						advice = "根据您最近的情况来看，情绪总体处于消极状态，您最近可以找一找要好的朋友或亲近的人沟通倾诉一下。您的数据"
								+ "显示您的性格偏内向，内向的人善于单独思考、比较喜欢独处，但在情绪频繁处于低落情况下，和他人沟通倾诉是缓解"
								+ "低落情绪，为此时的状况找到新出口的有效途径。在您独处时，可选择冥想、听音乐、或是看书来提升自己的心境，控制自己的情绪。";
					} else {
						// 情绪值偏低，情绪稳定,外向
						advice = "根据您最近的情况来看，情绪总体处于消极状态，您可以找一个安静，能让自己静下心来的地方度过一段独处的时间。"
								+ "您的数据显示您的性格偏外向，外向的人愿意交流和展现自己，因此也容易再与他人的交流中意见不合而受挫、情绪低落。"
								+ "这时回归自身内心是一个不错的选择，静下心来思考自己，也许会发现事情没那么糟糕。";
					}
				}
			} else {
				// 情绪值高
				if (stability < 0.5) {
					// 情绪值高，情绪不稳定
					if (interaction < 0.5 || secrate < 0.5) {
						// 情绪值高，情绪不稳定,内向
						advice = "近来您的情绪状态比较好，但不太稳定。应该多锻炼，注意饮食。这样更有利于再压力中"
								+ "调节自己的心态。";
					} else {
						// 情绪值偏低，情绪不稳定,外向
						advice = "近来您的情绪状态比较好，但不太稳定。应该多锻炼，注意饮食。这样更有利于再压力中"
								+ "调节自己的心态。";
					}
				} else {
					// 情绪值高,情绪稳定
					if (interaction < 0.5 || secrate < 0.5) {
						// 情绪值高，情绪稳定,内向
						advice = "近来您的情绪状态比较好，且比较稳定，应当继续保持，记住此时对待事物的心态与情绪变化"
								+ "能为今后低落的自己树立榜样哦。";
					} else {
						// 情绪值高，情绪稳定,外向
						advice = "近来您的情绪状态比较好，且比较稳定。应当继续保持，记住此时对待事物的心态与情绪变化"
								+ "能为今后低落的自己树立榜样哦。";
					}
				}
			}
		}
		return advice;
	}

	
	private Map<String,Double> getmoodAnalyse(int uid){
		Map<String,Double> map =new HashMap<String,Double>();
		//查找所有的纸条，并统计数量
		List<Note> noteList = new ArrayList<>();
		noteList = noteService.schAllNote();
		int noteSize = noteList.size();
		//将纸条分类，得到每类的数量
		double happy = 0;
		double veryhappy = 0;
		double sad = 0;
		double scard = 0;
		double commen = 0;
		for(Note n : noteList){
			switch (n.getMood()) {
			case 1 :{++sad;break;}
			case 2 :{++scard;break;}
			case 3 :{++commen;break;}
			case 4 :{++happy;break;}
			case 5 :{++veryhappy;break;}
			}
		}
		//返回每类的百分比
		if(happy!=0){
			happy = Double.parseDouble(df.format(happy/noteSize));
		}
	 if(sad!=0){
		 sad = Double.parseDouble(df.format(sad/noteSize));
	 }
	 if(scard!=0){
		 scard = Double.parseDouble(df.format(scard/noteSize));
	 }
	 if(commen!=0){
		 commen = Double.parseDouble(df.format(commen/noteSize)); 
	 }
	 if(veryhappy!=0){
		 veryhappy = Double.parseDouble(df.format(veryhappy/noteSize));
	 }
	 
	 map.put("sad", sad);
	 map.put("scard", scard);
	 map.put("commen", commen);
	 map.put("happy", happy);
	 map.put("veryhappy",veryhappy);
	
	 return map;
	}
	
	/**
	 * 得到一个list的情感值
	 *得到起伏较大的数据，为以后分析做准备（没有实现）
	 * @param lib
	 * @return
	 */
	public double getMood(List<Library> lib) {
		double avg = 0;
		int size = lib.size();
		if(lib.size()!=0){
			for (Library l : lib) {
				avg = avg + l.getValue();
			}
			avg = Double.parseDouble(df.format(avg / lib.size()));
			if(avg < 0){
				avg = Math.abs(avg);
			}
			else {
				avg = avg + 10;
			}
			System.out.println(avg);
			if(avg!=0){
				avg = Double.parseDouble(df.format(avg/23));
			}
			
		}
		return avg;
	}

	/**
	 * 得到稳定性
	 * 
	 * @param lib
	 */
	public double getStability(List<Library> lib) {
		List<Double> list = new ArrayList<>();
		double[] d = new double[lib.size()];
		double m = 0;
		if(lib.size()!=0){
			for (int i = 0; i < lib.size(); i++) {
				d[i] = lib.get(i).getValue();
			}
			m = Double.parseDouble(df.format(m));
		}
		System.out.println(m + "===============================================");
		return m;
	}

	/**
	 * 获取感性
	 * 
	 * @param lib
	 * @return
	 */
	public double getRational(List<Library> lib) {
		double n = 0, m = 0;// n为理性，m为感性
		int size = lib.size();
		
		if(size!=0){
			System.out.println("进入小于10");
			for (Library l : lib) {
				if (l.getValue() < 5 && l.getValue() > -5) {
					n += 1;
				}
			}
			System.out.println("n:" + n);
			n = n / size;
		}

		return n;
	}

	/**
	 * 互动情况 由字条的评论可以评判
	 * 
	 * @param lib
	 * @return
	 */
	public double getInteraction(List<Library> lib,int uid) {
		double n = 0, interaction = 0;
		List<Evaluate> evaluatesList = new ArrayList<>();
		int size = lib.size();
		if(size!=0){
			System.out.println("进入小于10");
			for (Library l : lib) {
				evaluatesList = evaluateService.showEva(l.getNoteId());
				n = evaluatesList.size() + n;
			}
			System.out.println("n:" + n);
			//interaction  = 
			Map<String, Object> m = new HashMap<>();
			m.put("uid", uid);
			m.put("recoverFriend", 0);
			int ftatol;
			List<Friends> f = new ArrayList<>();
			f = friends.selectAllFriends(m);
			ftatol = f.size();
			if(ftatol==0){
				interaction  = 0;
			}else{
				if(n<ftatol){//当评论小于朋友数量
					interaction = n/ftatol;
				}else if(n>=ftatol&&n<ftatol*2){//当评论大于朋友数量且小于朋友数量的两倍时
					interaction = 0.8;
				}else{
					interaction = 0.9;//当评论非常多时
				}
			}
		}
		return interaction;
	}

	/**
	 * 计算方差及百分比
	 * 
	 * @param x
	 * @return
	 */
	public static double Variance(double[] x) {
		int m = x.length;
		double sum = 0;
		for (int i = 0; i < m; i++) {// 求和
			sum += x[i];
		}
		double dAve = 0;// 求平均值
		double dVar = 0;
		for (int i = 0; i < m; i++) {// 求方差
			dVar += (x[i] - dAve) * (x[i] - dAve);
		}
		double variance = (dVar / m) / 110.25;// 方差所在百分比
		return variance;

	}
/**
 * 权限开放度
 * @param lib
 * @param uid
 * @return
 */
	public double getSecrate(List<Library> lib, int uid) {
		// 通过遍历纸条id查找权限表得到每条纸条的未开放权限数比重集合
		List<Double> bizhong = new ArrayList<>();
		List<Authority> aut = new ArrayList<>();
		Map<String, Object> m = new HashMap<>();
		double avg=0.0, ed = 0.0;
		m.put("uid", uid);
		m.put("recoverFriend", 0);
		for (Library l : lib) {
			aut = authorityService.schAutByid(l.getNoteId());
			if(aut.size()!=0){
				// 得到比重的平均值
				for (Authority a : aut) {
					// 如果friendNum为空
					if (a.getFriendNumber() == null) {
						// 如果标志位为0，则是所有人都不能看，比重为1
						if (a.getObvious() == 0) {
							bizhong.add(1.0);
						}
						// 否则，比重为0
						else {
							bizhong.add(0.0);
						}
						break;
					}
					// 如果不为空
					else {
						// 查找朋友的总数
						int ftatol;
						List<Friends> f = new ArrayList<>();
						f = friends.selectAllFriends(m);
						ftatol = f.size();
						if(ftatol!=0){
							// 如果标志为为0，则是可看到的人数
							if (a.getObvious() == 0) {
								bizhong.add(((double) ftatol - aut.size()) / ftatol);
							}
							// 否则则是不可见人数
							else {
								bizhong.add((double) aut.size() / ftatol);
							}
						}
						break;
					}
				}
				// 将得到的比重值集合做平均输出
				
				for (double d : bizhong) {
					ed = ed + d;
				}
				if(bizhong.size()!=0)
				avg = ed / bizhong.size();
				}
			}
			
		return avg;
	}

	@Test
	public void coment() {
		String number = "9429390675";
		List<Library> lib = new ArrayList<>();
		lib = com.TB.analytic.result.AnalyseService.selectValue(number);
		System.out.println(lib.size() + "===========================");
		double m = getMood(lib);
		double d = getRational(lib);
		System.out.println(m + "====================");
		System.out.println(d);
		getSecrate(lib, 20);
		double n = getStability(lib);

	}
}
