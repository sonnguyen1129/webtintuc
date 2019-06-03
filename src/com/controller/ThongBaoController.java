package com.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.PostDao;
import com.dao.ThongBaoDao;
import com.entities.Post;
import com.entities.ThongBao;
import com.entities.User;

@WebServlet("/thong-bao")
public class ThongBaoController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ThongBaoDao thongBaoDao = new ThongBaoDao();
		ThongBao thongBao = new ThongBao();
		User user = (User)	req.getSession().getAttribute("user");
		try {
			if(req.getSession().getAttribute("countStatus") != null) {
				
				thongBaoDao.updateStatus(user.getUsername());
				req.getSession().removeAttribute("countStatus");
			}
			
			List<ThongBao> list = new ArrayList<>();
			list = thongBaoDao.getListThongBao(user.getUsername());
			
			req.setAttribute("listThongBao", list);
			req.getRequestDispatcher("/views/thongbao.jsp").forward(req, resp);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
