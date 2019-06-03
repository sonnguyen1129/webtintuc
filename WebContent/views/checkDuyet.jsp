<%@page import="com.dao.PostDao"%>
<%@page import="com.entities.Post"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">

<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/admin.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/fontawesome.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/sidebar.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/style1.css">
</head>

<body>

	<jsp:include page="sidebar.jsp"></jsp:include>
	<%
		Post post1 = (Post) request.getAttribute("post");
		String theLoai = new PostDao().getTheloai(post1.getTheLoai());
		String user = new PostDao().getFullName(post1.getUsername());
		request.setAttribute("theLoai", theLoai);
		request.setAttribute("fullName", user);
	%>

	<div class="container left_content">
	
	<button class="btn btn-light" onclick="goBack()">Quay lại</button>
	
		<h2 class="title-style">${theLoai}</h2>
		<h2>
			<b>${post.tieuDe }</b>
		</h2>
		<p>${post.ngayDuyet }</p>
		<div class="share_the_story">
			<span>Share: </span> <a href="#" class="facebook"><i
				class="fa fa-facebook"></i>Facebook</a> <a href="#" class="twitter"><i
				class="fa fa-twitter"></i>Twitter</a> <a href="#" class="google"><i
				class="fa fa-google-plus"></i>Google+</a> <a href="#" class="pinterest"><i
				class="fa fa-pinterest"></i>Pinterest</a>
		</div>

		<div class="">
			<p style="font-style: italic;">
				<b>${post.tomTat }</b>
			</p>
		</div>

		<div class="" style="width: 100%">${post.noiDung }</div>

		<div style="text-align: right;">-- ${fullName} --</div>
		
		<div>
			<a class="btn btn-success confirmation" href="duyet?id=${post.id }"> Duyệt bài</a>
			<a class="btn btn-danger confirmation" href="delete-post?id=${post.id }&check=wait">Xóa bài</a>
		</div>
	</div>

	<script src="<%=request.getContextPath()%>/resources/js/jquery.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
	<script type="text/javascript">
		function goBack() {
		  window.history.back();
		}
	</script>
	<script type="text/javascript">
		$('.confirmation').on('click', function () {
	        return confirm('Xác nhận?');
	    });
	</script>

</body>
</html>