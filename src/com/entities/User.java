package com.entities;

public class User {
	private String username;
	private String matkhau;
	private String hoten;
	private int quyen;

	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public User(String username, String matkhau, String hoten, int quyen) {
		this.username = username;
		this.matkhau = matkhau;
		this.hoten = hoten;
		this.quyen = quyen;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getMatkhau() {
		return matkhau;
	}

	public void setMatkhau(String matkhau) {
		this.matkhau = matkhau;
	}

	public String getHoten() {
		return hoten;
	}

	public void setHoten(String hoten) {
		this.hoten = hoten;
	}

	public int getQuyen() {
		return quyen;
	}

	public void setQuyen(int quyen) {
		this.quyen = quyen;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", matkhau=" + matkhau + ", hoten=" + hoten + ", quyen=" + quyen + "]";
	}

	
}
