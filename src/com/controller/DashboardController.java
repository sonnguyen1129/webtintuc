package com.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.PostDao;
import com.dao.UserDao;

@WebServlet("/admin")
public class DashboardController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PostDao postDao = new PostDao();
		UserDao userDao = new UserDao();
		
		try {
			req.setAttribute("countDuyet", postDao.countDuyet());
			req.setAttribute("countNoDuyet", postDao.countNoDuyet());
			req.setAttribute("countUsers", userDao.countUsers());
			req.getRequestDispatcher("views/dashboard.jsp").forward(req, resp);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
