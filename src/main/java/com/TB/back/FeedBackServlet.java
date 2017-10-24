package com.TB.back;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;

@Controller
@RequestMapping("/feedBack")
@Scope("prototype")
public class FeedBackServlet {
	DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private FeedBackService feedBackService = new FeedBackService();
	Gson gson = new Gson();
	/**
	 * 保存反馈
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/addFeedBack")
	public void addFeedBack(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		FeedBack back = new  FeedBack();
		String uuid = request.getParameter("uid");
		int uid = Integer.parseInt(uuid);
		String content = request.getParameter("content");
		Date date = new Date();
		String time = format.format(date);
		System.out.println(uid+"================================");
		System.out.println(content+"==============================");
		back.setUid(uid);back.setContent(content);back.setFe_time(time);
		System.out.println(back.toString());
		feedBackService.addFeedBack(back);
		
		response.setContentType("text/json");
		PrintWriter out = response.getWriter();
		out.print("谢谢您的 反馈，我们将尽快处理！");
		out.flush();
		out.close();

	}
}
