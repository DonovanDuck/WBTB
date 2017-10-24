package com.TB.TBox.driftBottle.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.TB.TBox.driftBottle.bean.Drift_evaluate;
import com.TB.TBox.driftBottle.bean.Drift_note;
import com.TB.TBox.driftBottle.service.Drift_noteService;
import com.TB.TBox.user.bean.User;
import com.TB.TBox.user.service.UserService;
import com.google.gson.Gson;

@Controller
@RequestMapping("/driftBottle")
@Scope("prototype")
public class Drift_noteServlet {
	@Autowired
	private Drift_note drift_note;
	@Autowired
	private Drift_evaluate drift_evaluate;
	@Autowired
	private Drift_noteService drift_noteService;

	private UserService userService = new UserService();
	
	
	DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private Logger log = Logger.getLogger(Drift_noteServlet.class);
	Gson gson = new Gson();

	/**
	 * 
	 * 添加漂流瓶
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/addDrift_note", method = RequestMethod.POST)
	public void addDrift_note(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String formuid = request.getParameter("uid");
		int sendId = Integer.parseInt(formuid);
		String title = request.getParameter("title");
		String driftContent = request.getParameter("driftContent");
		int identifier = Integer.parseInt(request.getParameter("identifier"));
		drift_note.setTitle(title);
		drift_note.setSendId(sendId);
		drift_note.setDriftContent(driftContent);
		drift_note.setIdentifier(identifier);
		Date date = new Date();
		String driftTime = format.format(date);
		System.out.println(driftTime);
		drift_note.setDriftTime(driftTime);
		drift_note.setCheckTheQuantity(0);
		drift_note.setHate(0);
		drift_noteService.addDrift_note(drift_note);
		response.setContentType("text/json");
		PrintWriter out = response.getWriter();
		out.print("发送成功！");
		out.flush();
		out.close();
	}

	/**
	 * 添加评论 修改漂流瓶的查看量
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/addDrift_evaluate_discuss", method = RequestMethod.POST)
	public void addDrift_evaluate_discuss(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String userName = request.getParameter("userName");
		String formdriftId = request.getParameter("driftId");
		int driftId = Integer.parseInt(formdriftId);
		drift_evaluate.setDriftId(driftId);
		String formdrifCommentId = request.getParameter("drifCommentId");
		int drifCommentId = Integer.parseInt(formdrifCommentId);
		drift_evaluate.setDrifCommentId(drifCommentId);
		String formdrifIfObv = request.getParameter("drifIfObv");
		int drifIfObv = Integer.parseInt(formdrifIfObv);
		drift_evaluate.setDrifIfObv(drifIfObv);
		String drifContent = request.getParameter("drifContent");
		drift_evaluate.setDrifContent(drifContent);
		Date date = new Date();
		String dirfCommentTime = format.format(date);
		System.out.println(dirfCommentTime);
		drift_evaluate.setDirfCommentTime(dirfCommentTime);
		// 查找到漂流瓶
		drift_note = drift_noteService.selectDrift_noteByID(driftId);
		// 修改查看量
		drift_note.setCheckTheQuantity(drift_note.getCheckTheQuantity() + 1);
		drift_noteService.updateDrift_note(drift_note);
		drift_noteService.addDrift_evaluate(drift_evaluate);
		//设置评论用户的名字
		drift_evaluate.setUserName(userName);
		response.setContentType("text/json");
		PrintWriter out = response.getWriter();
		out.print(gson.toJson(drift_evaluate));
		out.flush();
		out.close();

	}

	/**
	 * 扔回大海
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/atSea", method = RequestMethod.POST)
	public void atSea(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String formdriftId = request.getParameter("driftId");
		int driftId = Integer.parseInt(formdriftId);
		// 查找到漂流瓶
		drift_note = drift_noteService.selectDrift_noteByID(driftId);
		// 修改查看量
		drift_note.setCheckTheQuantity(drift_note.getCheckTheQuantity() + 1);
		drift_noteService.updateDrift_note(drift_note);
		response.setContentType("text/json");
		PrintWriter out = response.getWriter();
		out.print("已经成功返回大海！");
		out.flush();
		out.close();
	}

	/**
	 * 厌恶此漂流瓶，这个漂流瓶将沉入大海，不被拾起
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/hate", method = RequestMethod.POST)
	public void hate(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String formdriftId = request.getParameter("driftId");
		int driftId = Integer.parseInt(formdriftId);
		// 查找到漂流瓶
		drift_note = drift_noteService.selectDrift_noteByID(driftId);
		// 修改查看量
		drift_note.setCheckTheQuantity(drift_note.getCheckTheQuantity() + 1);
		drift_note.setHate(1);
		drift_noteService.updateDrift_note(drift_note);
		response.setContentType("text/json");
		PrintWriter out = response.getWriter();
		out.print("此漂流瓶已经沉入海底！");
		out.flush();
		out.close();
	}

	/**
	 * 随机抽取一条漂流记录
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/randomSelectDrift_note", method = RequestMethod.POST)
	public void randomSelectDrift_note(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String formuid = request.getParameter("uid");
		int uid = Integer.parseInt(formuid);
		User u = new User();
		List<Drift_note> drift_noteList = new ArrayList<Drift_note>();
		drift_noteList = drift_noteService.randomSelectDrift_note(0);
		// 初始化随机数
		Random rand = new Random();
		int myRand = 0;
		// 遍历整个drift_noteList数组

		while (true) {
			// 任意取一个0~size的整数，注意此处的items.size()是变化的，所以不能用前面的size会发生数组越界的异常
			myRand = rand.nextInt(drift_noteList.size());
			// 看这条漂流记录是不是此用户的，如果不是则终止循环
			if (!(drift_noteList.get(myRand).getSendId() == uid)) {
				System.out.println(gson.toJson(drift_noteList.get(myRand)));
				break;
			}
		}
		List<Drift_evaluate> driftEvaluateList = new  ArrayList<>();
		
		drift_note = drift_noteList.get(myRand);
		driftEvaluateList = drift_noteService.selectAllDrift_note_evaluate(drift_noteList.get(myRand).getDriftId());
		//将评论封装到漂流瓶中
		drift_note.setDrift_evaluateList(driftEvaluateList);
		User user = userService.selectUserByID(drift_noteList.get(myRand).getSendId());
		drift_note.setUserName(user.getUsername());
		response.setContentType("text/json");
		PrintWriter out = response.getWriter();
		out.print(gson.toJson(drift_note));
		out.flush();
		out.close();

	}
	/**
	 * 用户查询个人的所有漂流瓶和评论过的漂流瓶
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/selectDriftByUid", method = RequestMethod.POST)
	public  void selectDriftByUid(HttpServletRequest request, HttpServletResponse response) throws IOException{
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String uuid = request.getParameter("uid");
		int uid = Integer.parseInt(uuid);
		User user = userService.selectUserByID(uid);
		Drift_note  driftNote=new  Drift_note(); 
		List<Drift_note> driftNoteList = new ArrayList<>();
		List<Drift_evaluate> driftEvaluateList = new  ArrayList<>();
		User u =new User();
		//查询属于用户的漂流瓶
		driftNoteList = drift_noteService.selectDriftByUid(uid);
		if(driftNoteList.size()!=0){
			for(Drift_note drift:driftNoteList){
				//根据漂流瓶的id得到这个漂流瓶的所有评论
				driftEvaluateList = drift_noteService.selectAllDrift_note_evaluate(drift.getDriftId());
				drift.setDrift_evaluateList(driftEvaluateList);
				//设置用户名
				drift.setUserName(user.getUsername());
			}
		}
		//查询用户评论过的漂流瓶
//		driftEvaluateList = drift_noteService.selectDrift_evaluateBydrifCommentId(uid);
//		if(driftEvaluateList.size()!=0){
//			for(Drift_evaluate driftEvaluate:driftEvaluateList){
//				List<Drift_evaluate> drifteva = new  ArrayList<>();
//				//根据用户的评论查到某一条漂流瓶
//				driftNote = drift_noteService.selectDrift_noteByID(driftEvaluate.getDriftId());
//				//根据漂流瓶的发送者查到漂流瓶的作者
//				driftNote.setUserName(driftEvaluate.getUserName());
//			//	查询这条漂流瓶的所有评论
//				drifteva = drift_noteService.selectAllDrift_note_evaluate(driftEvaluate.getDriftId());
//				driftNote.setDrift_evaluateList(drifteva);
//				//添加到漂流瓶List中
//				driftNoteList.add(driftNote);
//			}
//		}
		
		response.setContentType("text/json");
		PrintWriter out = response.getWriter();
		out.print(gson.toJson(driftNoteList));
		out.flush();
		out.close();
	}

	@RequestMapping(value="selectOneDriftEvaluate", method = RequestMethod.POST)
	public void selectAllDrift_note_evaluate(HttpServletRequest request, HttpServletResponse response) throws IOException{
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String driftId1 = request.getParameter("driftId");
		int driftId = Integer.parseInt(driftId1);
		List<Drift_evaluate> evaluateList = new ArrayList<>();
		evaluateList = drift_noteService.selectAllDrift_note_evaluate(driftId);
		
		response.setContentType("text/json");
		PrintWriter out = response.getWriter();
		out.print(gson.toJson(evaluateList));
		out.flush();
		out.close();
	}
	
	@Test
	public void test() {
		Drift_note drift_note = new Drift_note();
		Drift_noteService drift_noteService = new Drift_noteService();
		Drift_evaluate drift_evaluate = new Drift_evaluate();
		List<Drift_note> drift_noteList = new ArrayList<Drift_note>();
		drift_noteList = drift_noteService.randomSelectDrift_note(0);
		System.out.println(drift_noteList.size() + "=================================");
		for (Drift_note drift_note1 : drift_noteList) {
			log.info(gson.toJson(drift_note1));
		}

		// 初始化随机数
		Random rand = new Random();
		// 取得集合的长度，for循环使用
		int size = drift_noteList.size();
		int i = 0;
		int myRand = 0;
		while (true) {
			i++;
			// 任意取一个0~size的整数，注意此处的items.size()是变化的，所以不能用前面的size会发生数组越界的异常
			myRand = rand.nextInt(drift_noteList.size());
			// 将取出的这个元素放到存放结果的集合中
			if (!(drift_noteList.get(myRand).getSendId() == 1)) {
				System.out.println(gson.toJson(drift_noteList.get(myRand)));
				break;
			}
		}
		drift_note = drift_noteList.get(myRand);
		drift_note.setDrift_evaluateList(
				drift_noteService.selectAllDrift_note_evaluate(drift_noteList.get(myRand).getDriftId()));

		System.out.println(i + "=================================");
		log.info(gson.toJson(drift_note));
	}

}
