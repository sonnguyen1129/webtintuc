package com.entities;

public class Post {
	private String id;
	private String tieuDe;
	private String username;
	private String theLoai;
	private String tomTat;
	private String noiDung;
	private String hinhAnh;
	private String ngayDang;
	private int duyet;
	private String ngayDuyet;
	private int view;

	public Post() {
		super();
	}

	public Post(String id, String tieuDe, String username, String theLoai, String tomTat, String noiDung,
			String hinhAnh, String ngayDang, int duyet, String ngayDuyet) {
		super();
		this.id = id;
		this.tieuDe = tieuDe;
		this.username = username;
		this.theLoai = theLoai;
		this.tomTat = tomTat;
		this.noiDung = noiDung;
		this.hinhAnh = hinhAnh;
		this.ngayDang = ngayDang;
		this.duyet = duyet;
		this.ngayDuyet = ngayDuyet;
	}
	
	

	public Post(String tieuDe, String username, String theLoai, String tomTat, String noiDung, String hinhAnh,
			String ngayDang, int duyet, String ngayDuyet, int view) {
		super();
		this.tieuDe = tieuDe;
		this.username = username;
		this.theLoai = theLoai;
		this.tomTat = tomTat;
		this.noiDung = noiDung;
		this.hinhAnh = hinhAnh;
		this.ngayDang = ngayDang;
		this.duyet = duyet;
		this.ngayDuyet = ngayDuyet;
		this.view = view;
	}



	

	public String getTieuDe() {
		return tieuDe;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setTieuDe(String tieuDe) {
		this.tieuDe = tieuDe;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getTheLoai() {
		return theLoai;
	}

	public void setTheLoai(String theLoai) {
		this.theLoai = theLoai;
	}

	public String getTomTat() {
		return tomTat;
	}

	public void setTomTat(String tomTat) {
		this.tomTat = tomTat;
	}

	public String getNoiDung() {
		return noiDung;
	}

	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}

	public String getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

	public String getNgayDang() {
		return ngayDang;
	}

	public void setNgayDang(String ngayDang) {
		this.ngayDang = ngayDang;
	}

	public int getDuyet() {
		return duyet;
	}

	public void setDuyet(int duyet) {
		this.duyet = duyet;
	}

	public String getNgayDuyet() {
		return ngayDuyet;
	}

	public void setNgayDuyet(String ngayDuyet) {
		this.ngayDuyet = ngayDuyet;
	}

	public String getId() {
		return id;
	}
	

	public int getView() {
		return view;
	}

	public void setView(int view) {
		this.view = view;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", tieuDe=" + tieuDe + ", username=" + username + ", theLoai=" + theLoai + ", tomTat="
				+ tomTat + ", noiDung=" + noiDung + ", hinhAnh=" + hinhAnh + ", ngayDang=" + ngayDang + ", duyet="
				+ duyet + ", ngayDuyet=" + ngayDuyet + ", view = " + view + "]";
	}

}
