package com.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.PostDao;
import com.dao.ThongBaoDao;
import com.entities.Post;
import com.entities.ThongBao;


@WebServlet("/delete-post")
public class DeletePostController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String check = req.getParameter("check");
		PostDao postDao = new PostDao();
		Post post;
		try {
			post = postDao.getPostByid(Integer.valueOf(id));
			Date date  = new Date();//Today Date
			SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd"); 
			String ngayGui = format.format(date);
			
			String noiDung = "Bài viết \"" +post.getTieuDe() +  "\" của bạn đã xóa";
			ThongBao thongBao = new ThongBao("admin", post.getUsername(),ngayGui, noiDung,0);
			ThongBaoDao thongBaoDao = new ThongBaoDao();
			thongBaoDao.addThongBao(thongBao);
			
		} catch (NumberFormatException | ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			if (postDao.deletePost(id)) {
				System.out.println("delete success");
				
			}
			else {
				System.out.println("delete failed");
			}
			if(check.equals("duyet"))
				resp.sendRedirect(req.getContextPath() + "/list-posts");
			else if(check.equals("wait"))
				resp.sendRedirect(req.getContextPath() + "/list-wait");
			else 
				resp.sendRedirect(req.getContextPath() + "/ds-chua-duyet");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
