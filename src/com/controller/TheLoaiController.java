package com.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.PostDao;

@WebServlet("/theloai")
public class TheLoaiController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PostDao postDao = new PostDao();
		
		String theloai = req.getParameter("theloai");
		
		try {
			if(theloai.equals("giaitri")) {
				req.setAttribute("listGiaitri", postDao.getList("giaitri"));
				req.setAttribute("listNews", postDao.getList3Post());
				req.setAttribute("count", postDao.getCountList("giaitri"));
				req.getRequestDispatcher("/views/giaitri.jsp").forward(req, resp);
			}
			else if(theloai.equals("vanhoa")) {
				req.setAttribute("listVanhoa", postDao.getList("vanhoa"));
				req.setAttribute("listNews", postDao.getList3Post());
				req.setAttribute("count", postDao.getCountList("vanhoa"));
				req.getRequestDispatcher("/views/vanhoa.jsp").forward(req, resp);
			}
			else if(theloai.equals("doisong")) {
				req.setAttribute("listDoisong", postDao.getList("doisong"));
				req.setAttribute("listNews", postDao.getList3Post());
				req.setAttribute("count", postDao.getCountList("doisong"));
				req.getRequestDispatcher("/views/doisong.jsp").forward(req, resp);
			}
			else if(theloai.equals("thethao")) {
				req.setAttribute("listThethao", postDao.getList("thethao"));
				req.setAttribute("listNews", postDao.getList3Post());
				req.setAttribute("count", postDao.getCountList("thethao"));
				req.getRequestDispatcher("/views/thethao.jsp").forward(req, resp);
			}
			else if(theloai.equals("congnghe")) {
				req.setAttribute("listCongnghe", postDao.getList("congnghe"));
				req.setAttribute("listNews", postDao.getList3Post());
				req.setAttribute("count", postDao.getCountList("congnghe"));
				req.getRequestDispatcher("/views/congnghe.jsp").forward(req, resp);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
