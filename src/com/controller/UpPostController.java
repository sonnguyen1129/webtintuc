package com.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.PostDao;
import com.entities.Post;
import com.entities.User;

@WebServlet("/up-post")
public class UpPostController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		String tieuDe = req.getParameter("tieude");
		String tomTat = req.getParameter("tomtat");
		String hinhAnh = req.getParameter("hinhanh");
		String noiDung = req.getParameter("noidung");
		String theLoai = req.getParameter("optradio");

		Date date  = new Date();//Today Date
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd"); 
		String ngayDang = format.format(date);
		
		User user = (User) req.getSession().getAttribute("user");

		PostDao postDao = new PostDao();
		Post post = new Post(tieuDe, user.getUsername(), theLoai, tomTat, noiDung, hinhAnh, ngayDang, 0, null,1);
		
		try {
			if(postDao.addPost(post));
			//System.out.println("success");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		resp.sendRedirect(req.getContextPath() + "/ds-chua-duyet");
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("views/upbaiviet.jsp").forward(req, resp);;
	}
}
