package com.TB.TBox.topic.bean;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.TB.TBox.user.bean.User;
import com.google.gson.Gson;

@Component
public class Topic {
	private int topicId;
	private String topicContent;
	private String time;
	private User user;
	private int uid;
	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	private int goodNum;
	private int opinionNumber;
	private String title;
	
	private static Gson gson = new Gson(); 
	public Topic(){};
	
	public Topic(String topicContent, String time, User user, String title) {
		super();
		this.topicContent = topicContent;
		this.time = time;
		this.user = user;
		this.title = title;
	}
	public int getGoodNum() {
		return goodNum;
	}
	public void setGoodNum(int goodNum) {
		this.goodNum = goodNum;
	}
	public int getOpinionNumber() {
		return opinionNumber;
	}
	public void setOpinionNumber(int opinionNumber) {
		this.opinionNumber = opinionNumber;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getTopicId() {
		return topicId;
	}
	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}
	public String getTopicContent() {
		return topicContent;
	}
	public void setTopicContent(String topicContent) {
		this.topicContent = topicContent;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	/**
	 * 转化数据为json
	 * @return
	 */
	public String toJson(){
		return gson.toJson(this);
	}
}
