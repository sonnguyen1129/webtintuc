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

@WebServlet("/ds-chua-duyet")
public class NoDuyetController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = (User) req.getSession().getAttribute("user");
		
		try {
			List<Post> listChuaDuyet = new PostDao().getListNoDuyet(user.getUsername());
			if(new PostDao().isEmpty(listChuaDuyet)) {
				req.setAttribute("message", "Chưa có bài viết");
			}
			req.setAttribute("listChuaDuyet",listChuaDuyet);
			req.setAttribute("count", new PostDao().getCountNoDuyet(user.getUsername()));
			req.getRequestDispatcher("views/postchuaduyet1.jsp").forward(req, resp);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
