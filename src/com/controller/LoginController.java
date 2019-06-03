package com.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.PostDao;
import com.dao.UserDao;
import com.entities.User;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
		String username = req.getParameter("username");
		String matkhau = req.getParameter("matkhau");
		UserDao userDao = new UserDao();
		User user = new User();
		
		try {
			if(userDao.checkLogin(username, matkhau)) {
				user = userDao.getUser(username, matkhau);
				int numberWaitList = new PostDao().getCountNoDuyet(username);
				HttpSession session = req.getSession();
				session.setAttribute("numberWait", numberWaitList);
				session.setAttribute("user", user);
				resp.sendRedirect(req.getContextPath() + "/home");
			}
			else {
				req.setAttribute("error", "Incorrect");
				req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
			}
				
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
