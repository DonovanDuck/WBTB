package com.TB.TBox.topic.sevlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.TB.TBox.topic.bean.Topic;
import com.TB.TBox.topic.service.TopicService;
import com.TB.TBox.user.bean.User;
import com.TB.TBox.user.interfaceTo.ToNodeInterface;
import com.TB.TBox.user.service.UserService;
import com.TB.base.page.PageBean;
import com.TB.base.page.SystemContext;
import com.google.gson.Gson;

@Controller
@RequestMapping("/topic")
@Scope("prototype")
public class TopicServlet {
	@Autowired
	private ToNodeInterface toNodeInterface ;
	@Autowired
	private TopicService topicService;
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/addTopic")
	public void addTopic(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		// 从前台接收数据
		User user = new User();
		User user2 = new User();
		int uid = Integer.parseInt(request.getParameter("uid"));
		user = userService.selectUserByID(uid);
		user2.setUfacing(user.getUfacing());
		user2.setUsername(user.getUsername());
		String topicContent = request.getParameter("topicContent");
		SimpleDateFormat sdt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String title = request.getParameter("title");
		String time = sdt.format(new Date());
		Topic topic = new Topic(topicContent, time, user2, title);


		//保存到数据库
		topicService.addTopic(topic);
		
		// 数据响应到前台
		response.setContentType("text/json");
		PrintWriter out = response.getWriter();
		out.print(topic.toJson());
		out.flush();
		out.close();
	}
	
	/**
	 * 显示用户讨论
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	@RequestMapping(value="/showtopic")
	public void showtopic(HttpServletRequest request,HttpServletResponse response) throws IOException{
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		/*
		 * 获得查询题目
		 */
		String title = request.getParameter("title");
		//获得List
		List<Topic> topicList = new ArrayList<>();
		topicList = topicService.schTopicbytitle(title);
//		int uid = topicService.finduid(topicList.get(0).getTopicId());
//		for(Topic t : topicList){ 
//			User user = new User();
//			User user2 = new User();
////			user = userService.selectUserByID(t.getUid());
//			user2.setUfacing(t.getUser().getUfacing());
//			user2.setUsername(t.getUser().getUsername());
//			t.setUser(user2);
//		}
		
		/*
		 * 数据响应到前台
		 */
		Gson gson = new Gson();
		response.setContentType("text/json");
		PrintWriter out = response.getWriter();
		out.print(gson.toJson(topicList));
		out.flush();
		out.close();
	}
}
