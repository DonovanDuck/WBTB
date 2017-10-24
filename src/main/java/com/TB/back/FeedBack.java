package com.TB.back;

import org.springframework.stereotype.Component;

@Component
public class FeedBack {
private int fe_id;
private int uid;
private String content;
private String fe_time;
public int getFe_id() {
	return fe_id;
}
public void setFe_id(int fe_id) {
	this.fe_id = fe_id;
}
public int getUid() {
	return uid;
}
public void setUid(int uid) {
	this.uid = uid;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public String getFe_time() {
	return fe_time;
}
public void setFe_time(String fe_time) {
	this.fe_time = fe_time;
}

}
