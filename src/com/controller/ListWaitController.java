package com.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.PostDao;

@WebServlet("/list-wait")
public class ListWaitController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PostDao postDao = new PostDao();
		
		try {
			if(req.getParameter("theloai") == null) {
				req.setAttribute("listPosts", postDao.getListNoDuyet());
				req.setAttribute("count", postDao.countNoDuyet());
			}
			else {
				String theloai = req.getParameter("theloai");
				if(theloai.equals("all")) {
					req.setAttribute("listPosts", postDao.getListNoDuyet());
					req.setAttribute("count", postDao.countNoDuyet());
				}
				else if(theloai.equals("giaitri")) {
					req.setAttribute("listPosts", postDao.getWaitList("giaitri"));
					req.setAttribute("count", postDao.getCountWaitList("giaitri"));
				}
				else if(theloai.equals("vanhoa")) {
					req.setAttribute("listPosts", postDao.getWaitList("vanhoa"));
					req.setAttribute("count", postDao.getCountWaitList("vanhoa"));
				}
				else if(theloai.equals("doisong")) {
					req.setAttribute("listPosts", postDao.getWaitList("doisong"));
					req.setAttribute("count", postDao.getCountWaitList("doisong"));
				}
				else if(theloai.equals("thethao")) {
					req.setAttribute("listPosts", postDao.getWaitList("thethao"));
					req.setAttribute("count", postDao.getCountWaitList("thethao"));
				}
				else if(theloai.equals("congnghe")) {
					req.setAttribute("listPosts", postDao.getWaitList("congnghe"));
					req.setAttribute("count", postDao.getCountWaitList("congnghe"));
				}
			}
			
			req.getRequestDispatcher("views/waitList.jsp").forward(req, resp);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
