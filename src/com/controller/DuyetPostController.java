package com.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.PostDao;
import com.dao.ThongBaoDao;
import com.entities.Post;
import com.entities.ThongBao;

@WebServlet("/duyet")
public class DuyetPostController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		String id = req.getParameter("id");

		Date date  = new Date();//Today Date
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd"); 
		String ngayDuyet = format.format(date);
		
		PostDao postDao = new PostDao();
		try {
			if(postDao.duyetPost(id, ngayDuyet)) {
				Post post = postDao.getPostByid(Integer.valueOf(id));
				String noiDung = "Bài viết \"" +post.getTieuDe() +  "\" của bạn đã được đăng";
				ThongBao thongBao = new ThongBao("admin", post.getUsername(),ngayDuyet, noiDung,0);
				ThongBaoDao thongBaoDao = new ThongBaoDao();
				thongBaoDao.addThongBao(thongBao);
			}
			
			resp.sendRedirect(req.getContextPath() + "/list-wait");
		} catch (NumberFormatException | ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
