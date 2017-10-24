package com.TB.TBox.topic.bean;

public class Topic_evaluate {
	private int tid; //评回id
	private int topicId; //被评纸条id
	private int replyId; //回复人id
	private int commentId; //评论人id
	private String commentTime; //评回时间
	private String econtent; //评回内容
	private int eflag; //标志位 1：为评价纸条 2：为回复评价的纸条 3：为回复回复的纸条
	private String commentNum; //评论人账号
	private String replyNum; // 回复人账号
	private int replyEid; //被回复的评回id
	
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public int getTopicId() {
		return topicId;
	}
	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}
	public int getReplyId() {
		return replyId;
	}
	public void setReplyId(int replyId) {
		this.replyId = replyId;
	}
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public String getCommentTime() {
		return commentTime;
	}
	public void setCommentTime(String commentTime) {
		this.commentTime = commentTime;
	}
	public String getEcontent() {
		return econtent;
	}
	public void setEcontent(String econtent) {
		this.econtent = econtent;
	}
	public int getEflag() {
		return eflag;
	}
	public void setEflag(int eflag) {
		this.eflag = eflag;
	}
	public String getCommentNum() {
		return commentNum;
	}
	public void setCommentNum(String commentNum) {
		this.commentNum = commentNum;
	}
	public String getReplyNum() {
		return replyNum;
	}
	public void setReplyNum(String replyNum) {
		this.replyNum = replyNum;
	}
	public int getReplyEid() {
		return replyEid;
	}
	public void setReplyEid(int replyEid) {
		this.replyEid = replyEid;
	}
	
	
}
