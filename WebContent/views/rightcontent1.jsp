<%@page import="com.dao.PostDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.entities.Post"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<% 
	List<Post> list = new ArrayList<>();
	PostDao postDao = new PostDao();
	list = postDao.getList3Post();
	
%>


	<div class="container right_content">
		<div class="list-group">
            <h2 class="title-style"> Bài viết xem nhiều</h2>
			<c:forEach items= "${listNews}" var="post">
    	        <div class="list-group-item  list-group-item-success">
              		<a class = "" href="baiviet?id=${post.tieuDe}" > ${post.tieuDe} </a>
              		<p style="text-align: right;" > ${post.view } lượt xem </p>
            	</div>
            </c:forEach>          
         </div>
    </div>
	
	
