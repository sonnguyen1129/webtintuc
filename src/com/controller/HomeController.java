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
import com.dao.ThongBaoDao;
import com.entities.User;

@WebServlet("/home")
public class HomeController extends HttpServlet{

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PostDao postDao = new PostDao();
		int number = 0;
		if(req.getSession().getAttribute("numberWait") != null ){
			if( (int) req.getSession().getAttribute("numberWait") != 0 ) {
				number = (int) req.getSession().getAttribute("numberWait");
				req.getSession().removeAttribute("numberWait");
			}
			
		}
		
		if(req.getSession().getAttribute("user") != null) {
			User user = (User) req.getSession().getAttribute("user");
		
			ThongBaoDao thongBaoDao = new ThongBaoDao();
			try {
				int countStatus = thongBaoDao.countStatus(user.getUsername());
				HttpSession session = req.getSession();
				session.setAttribute("countStatus", countStatus);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		try {
			req.setAttribute("newGiaitri", postDao.getNewGiaitri());
			req.setAttribute("newVanhoa", postDao.getNewVanhoa());
			req.setAttribute("newDoisong", postDao.getNewDoisong());
			req.setAttribute("newThethao", postDao.getNewThethao());
			req.setAttribute("newCongnghe", postDao.getNewCongnghe());
			req.setAttribute("listNews", postDao.getList3Post());
			req.setAttribute("newBaiviet", postDao.getNewBaiviet());
			req.setAttribute("list2News", postDao.getList2Post());
			req.setAttribute("numberWait", number);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		req.getRequestDispatcher("/views/home.jsp").forward(req, resp);
		}
}
