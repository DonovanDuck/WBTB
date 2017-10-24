package com.TB.analytic;

public class Modle {
private String word;
private int address;
private int emotionalTendenc;//情感倾向
private double emotionalIntensity;//情感权值
public int getAddress() {
	return address;
}
public void setAddress(int address) {
	this.address = address;
}
public int getEmotionalTendenc() {
	return emotionalTendenc;
}
public void setEmotionalTendenc(int emotionalTendenc) {
	this.emotionalTendenc = emotionalTendenc;
}
public double getEmotionalIntensity() {
	return emotionalIntensity;
}
public void setEmotionalIntensity(double d) {
	this.emotionalIntensity = d;
}
public String getWord() {
	return word;
}
public void setWord(String word) {
	this.word = word;
}
public Modle(String word, int address, int emotionalTendenc, double emotionalIntensity) {
	super();
	this.word = word;
	this.address = address;
	this.emotionalTendenc = emotionalTendenc;
	this.emotionalIntensity = emotionalIntensity;
}
public Modle(){}
@Override
public String toString() {
	return "Modle [word=" + word + ", address=" + address + ", emotionalTendenc=" + emotionalTendenc
			+ ", emotionalIntensity=" + emotionalIntensity + "]";
}


}
