package com.programmingfree.springservice.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MyRequest {
	
	String p1;
	int p2;
	boolean p3;
	double p4;
	
	Address add;
	
	public Address getAdd() {
		return add;
	}
	public void setAdd(Address add) {
		this.add = add;
	}
	public String getP1() {
		return p1;
	}
	public void setP1(String p1) {
		this.p1 = p1;
	}
	public int getP2() {
		return p2;
	}
	public void setP2(int p2) {
		this.p2 = p2;
	}
	public boolean isP3() {
		return p3;
	}
	public void setP3(boolean p3) {
		this.p3 = p3;
	}
	public double getP4() {
		return p4;
	}
	public void setP4(double p4) {
		this.p4 = p4;
	}
	@Override
	public String toString() {
		return "MyRequest [p1=" + p1 + ", p2=" + p2 + ", p3=" + p3 + ", p4=" + p4 + "]";
	}
	
	

}
