package com.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.PostDao;
import com.entities.Post;

@WebServlet("/baiviet")
public class BaiVietController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String tieuDe= req.getParameter("id");
		
		PostDao postDao = new PostDao();
		try {
			Post post = postDao.getPostByTieuDe(tieuDe);
			String id = post.getId();
			int view = post.getView();
			view ++;
			postDao.updateView(id, view);
			
			req.setAttribute("post", post);
			req.setAttribute("listNews", postDao.getListByUsername(post.getId(), post.getUsername()));
			req.setAttribute("listTheloai", postDao.getListCungTheloai(post.getId(), post.getTheLoai()));
			req.getRequestDispatcher("views/baiviet.jsp").forward(req, resp);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
