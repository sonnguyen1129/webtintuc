package com.entities;

public class ThongBao {
	private int id;
	private String userGui;
	private String userNhan;
	private String ngayGui;
	private String noiDung;
	private int status;

	public ThongBao() {
		super();
	}

	public ThongBao(String userGui, String userNhan, String ngayGui, String noiDung, int status) {
		super();
		this.userGui = userGui;
		this.userNhan = userNhan;
		this.ngayGui = ngayGui;
		this.noiDung = noiDung;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserGui() {
		return userGui;
	}

	public void setUserGui(String userGui) {
		this.userGui = userGui;
	}

	public String getUserNhan() {
		return userNhan;
	}

	public void setUserNhan(String userNhan) {
		this.userNhan = userNhan;
	}

	public String getNgayGui() {
		return ngayGui;
	}

	public void setNgayGui(String ngayGui) {
		this.ngayGui = ngayGui;
	}

	public String getNoiDung() {
		return noiDung;
	}

	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ThongBao [id=" + id + ", userGui=" + userGui + ", userNhan=" + userNhan + ", ngayGui=" + ngayGui
				+ ", noiDung=" + noiDung + ", status=" + status + "]";
	}

}
