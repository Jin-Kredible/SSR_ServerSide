package com.sinc.ssr.vo;
/*
 * SAVINGS TABLE
 * */
public class SavingsVO {
	int sa_id, user_id, sa_am;
	String sa_dt;
	
	public SavingsVO() {
		super();
	}

	public SavingsVO(int sa_id, int user_id, int sa_am, String sa_dt) {
		super();
		this.sa_id = sa_id;
		this.user_id = user_id;
		this.sa_am = sa_am;
		this.sa_dt = sa_dt;
	}
	
	public int getSa_id() {
		return sa_id;
	}
	public void setSa_id(int sa_id) {
		this.sa_id = sa_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getSa_am() {
		return sa_am;
	}
	public void setSa_am(int sa_am) {
		this.sa_am = sa_am;
	}
	public String getSa_dt() {
		return sa_dt;
	}
	public void setSa_dt(String sa_dt) {
		this.sa_dt = sa_dt;
	}
	
	@Override
	public String toString() {
		return "SavingsVO [sa_id=" + sa_id + ", user_id=" + user_id + ", sa_am=" + sa_am + ", sa_dt=" + sa_dt + "]";
	}
	
	
}
