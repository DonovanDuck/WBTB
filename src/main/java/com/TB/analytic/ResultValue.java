package com.TB.analytic;

public class ResultValue {
private String type;
private double value;
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public double getValue() {
	return value;
}
public void setValue(double value) {
	System.out.println("保存了"+value+"===================");
	this.value = value;
}
@Override
public String toString() {
	return "ResultValue [type=" + type + ", value=" + value + "]";
}

}
