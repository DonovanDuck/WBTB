package com.TB.analytic.result;

public class ReturnPro {
private double moodValue;//情感值
private double stability;//情感稳定性
private double interaction;//被关注度
private double rational;//理性程度
private double secrate;//权限开放度
private double happy;//开心
private double veryhappy;//生气
private double sad;//伤心
private double scard;//害怕
private double commen;//一般





public double getHappy() {
	return happy;
}
public void setHappy(double happy) {
	this.happy = happy;
}
public double getveryhappy() {
	return veryhappy;
}
public void setveryhappy(double veryhappy) {
	this.veryhappy = veryhappy;
}
public double getSad() {
	return sad;
}
public void setSad(double sad) {
	this.sad = sad;
}
public double getScard() {
	return scard;
}
public void setScard(double scard) {
	this.scard = scard;
}
public double getCommen() {
	return commen;
}
public void setCommen(double commen) {
	this.commen = commen;
}
public double getMoodValue() {
	return moodValue;
}
public void setMoodValue(double moodValue) {
	this.moodValue = moodValue;
}
public double getStability() {
	return stability;
}
public void setStability(double stability) {
	this.stability = stability;
}
public double getInteraction() {
	return interaction;
}
public void setInteraction(double interaction) {
	this.interaction = interaction;
}
public double getRational() {
	return rational;
}
public void setRational(double rational) {
	this.rational = rational;
}
public double getSecrate() {
	return secrate;
}
public void setSecrate(double secrate) {
	this.secrate = secrate;
}
public ReturnPro(double moodValue, double stability, double interaction, double rational, double secrate, double happy,
		double veryhappy, double sad, double scard, double commen) {
	super();
	this.moodValue = moodValue;
	this.stability = stability;
	this.interaction = interaction;
	this.rational = rational;
	this.secrate = secrate;
	this.happy = happy;
	this.veryhappy = veryhappy;
	this.sad = sad;
	this.scard = scard;
	this.commen = commen;
}
}
