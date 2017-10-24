package com.TB.analytic;

public class ReturnValue {
private String document;//提取到的关键句子
private double value;//整个句子的情感
private String hobby;//提取出来的兴趣爱好

public String getHobby() {
	return hobby;
}
public void setHobby(String hobby) {
	this.hobby = hobby;
}
public String getDocument() {
	return document;
}
public void setDocument(String document) {
	this.document = document;
}
public double getValue() {
	return value;
}
public void setValue(double value) {
	this.value = value;
}
@Override
public String toString() {
	return "ReturnValue [document=" + document + ", value=" + value + ", hobby=" + hobby + "]";
}


}
