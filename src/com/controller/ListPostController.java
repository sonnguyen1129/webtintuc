package com.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.PostDao;

@WebServlet("/list-posts")
public class ListPostController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PostDao postDao = new PostDao();
		
		try {
			if(req.getParameter("theloai") == null) {
				req.setAttribute("listPosts", postDao.getListDuyet());
				req.setAttribute("count", postDao.countDuyet());
			}
			else {
				String theloai= req.getParameter("theloai");
				if(theloai.equals("all")) {
					req.setAttribute("listPosts", postDao.getListDuyet());
					req.setAttribute("count", postDao.countDuyet());
				}
				else if(theloai.equals("giaitri")) {
					req.setAttribute("listPosts", postDao.getList("giaitri"));
					req.setAttribute("count", postDao.getCountList("giaitri"));
				}
				else if(theloai.equals("vanhoa")) {
					req.setAttribute("listPosts", postDao.getList("vanhoa"));
					req.setAttribute("count", postDao.getCountList("vanhoa"));
				}
				else if(theloai.equals("doisong")) {
					req.setAttribute("listPosts", postDao.getList("doisong"));
					req.setAttribute("count", postDao.getCountList("doisong"));
				}
				else if(theloai.equals("thethao")) {
					req.setAttribute("listPosts", postDao.getList("thethao"));
					req.setAttribute("count", postDao.getCountList("thethao"));
				}
				else if(theloai.equals("congnghe")) {
					System.out.println("congnghe");
					req.setAttribute("listPosts", postDao.getList("congnghe"));
					req.setAttribute("count", postDao.getCountList("congnghe"));
				}
			}
			
			req.getRequestDispatcher("views/duyetList.jsp").forward(req, resp);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
