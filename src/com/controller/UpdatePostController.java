package com.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.PostDao;
import com.entities.Post;

@WebServlet("/sua-bai-viet")
public class UpdatePostController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		String id = req.getParameter("id");
		String tieuDe = req.getParameter("tieude");
		String tomTat = req.getParameter("tomtat");
		String hinhAnh = req.getParameter("hinhanh");
		String noiDung = req.getParameter("noidung");
		String theLoai = req.getParameter("optradio");
		
		PostDao postDao = new PostDao();
		Post post = new Post();
		try {
			post = postDao.getPostByid(Integer.valueOf(id));
			post.setTieuDe(tieuDe);
			post.setTomTat(tomTat);
			post.setHinhAnh(hinhAnh);
			post.setNoiDung(noiDung);
			post.setTheLoai(theLoai);
			if(postDao.updatePost(post)) {
				System.out.println("update success");
			}
			else {
				System.out.println("update fail");
			}
			req.setAttribute("post", post);
			req.getRequestDispatcher("views/updatePost.jsp").forward(req, resp);
			
			
		} catch (NumberFormatException | ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String tieuDe= req.getParameter("tieuDe");
		PostDao postDao = new PostDao();
		
		try {
			Post post = postDao.getPostByTieuDe(tieuDe);
			req.setAttribute("post", post);
			req.getRequestDispatcher("views/updatePost.jsp").forward(req, resp);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
