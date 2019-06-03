package com.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.PostDao;
import com.entities.Post;
import com.entities.User;

@WebServlet("/ds-duyet")
public class DuyetController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = (User) req.getSession().getAttribute("user");
		PostDao postDao = new PostDao();
		try {
			List<Post> listDuyet = postDao.getListDuyet(user.getUsername());
			if(postDao.isEmpty(listDuyet)) {
				req.setAttribute("message", "Chưa có bài viết");
			}
			req.setAttribute("listDuyet",listDuyet);
			req.setAttribute("count", postDao.getCountDuyet(user.getUsername()));
			req.getRequestDispatcher("views/postduyet1.jsp").forward(req, resp);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
