package com.sinc.ssr.vo;
/*
 * MALLS TABLE + VISITS TABLE
 * */
public class MallsVO {
	int 	mall_id, mall_la, mall_long;
	String 	mall_nm;
	int 	user_id, vi_id, vi_wk;
	String 	vi_start, vi_end;
	
	public MallsVO() {
		super();
	}

	public MallsVO(int mall_id, int mall_la, int mall_long, String mall_nm, int vi_id, int vi_wk, String vi_start,
			String vi_end) {
		super();
		this.mall_id = mall_id;
		this.mall_la = mall_la;
		this.mall_long = mall_long;
		this.mall_nm = mall_nm;
		this.user_id = user_id;
		this.vi_id = vi_id;
		this.vi_wk = vi_wk;
		this.vi_start = vi_start;
		this.vi_end = vi_end;
	}

	public int getMall_id() {
		return mall_id;
	}

	public void setMall_id(int mall_id) {
		this.mall_id = mall_id;
	}

	public int getMall_la() {
		return mall_la;
	}

	public void setMall_la(int mall_la) {
		this.mall_la = mall_la;
	}

	public int getMall_long() {
		return mall_long;
	}

	public void setMall_long(int mall_long) {
		this.mall_long = mall_long;
	}

	public String getMall_nm() {
		return mall_nm;
	}

	public void setMall_nm(String mall_nm) {
		this.mall_nm = mall_nm;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getVi_id() {
		return vi_id;
	}

	public void setVi_id(int vi_id) {
		this.vi_id = vi_id;
	}

	public int getVi_wk() {
		return vi_wk;
	}

	public void setVi_wk(int vi_wk) {
		this.vi_wk = vi_wk;
	}

	public String getVi_start() {
		return vi_start;
	}

	public void setVi_start(String vi_start) {
		this.vi_start = vi_start;
	}

	public String getVi_end() {
		return vi_end;
	}

	public void setVi_end(String vi_end) {
		this.vi_end = vi_end;
	}

	@Override
	public String toString() {
		return "MallsVO [mall_id=" + mall_id + ", mall_la=" + mall_la + ", mall_long=" + mall_long + ", mall_nm="
				+ mall_nm + ", user_id=" + user_id + ", vi_id=" + vi_id + ", vi_wk=" + vi_wk + ", vi_start=" + vi_start
				+ ", vi_end=" + vi_end + "]";
	}

	

}
