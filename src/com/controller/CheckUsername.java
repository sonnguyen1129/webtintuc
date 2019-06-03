package com.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;
import com.entities.User;

@WebServlet("/checkusername")
public class CheckUsername extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("utf-8");
		UserDao userDao = new UserDao();
		
		try {
			if(req.getParameter("username").isEmpty()) {
				String check = "<p style = \"color:red;\"> Nhập tên tài khoản </p>";
			    resp.getWriter().write(check);
			}
			else if (!userDao.checkUsername(req.getParameter("username"))) {
					String check = "<p style = \"color:green;\"> Có thể dùng </p>";
					resp.getWriter().write(check);
			      
			 } else {
				 	String check = "<p style = \"color:red;\"> Tên đã tồn tại </p>";
				 	resp.getWriter().write(check);
			 }
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}