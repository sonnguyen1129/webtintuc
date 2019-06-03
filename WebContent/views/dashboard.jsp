<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/admin.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/fontawesome.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/sidebar.css">
</head>

<body id = "body">


	<jsp:include page="sidebar.jsp"></jsp:include>
	
	<div class="content ">

		<h2>Dashboard</h2>
	    <table class="table table-striped">
	
	        <tr>
	          <td><b>Thành viên</b></td>
	          <td> ${countUsers } </td>
	        </tr>
	        <tr>
	          <td><b>Số bài viết</b></td>
	          <td> ${countDuyet } </td>
	        </tr>
	        <tr>
	          <td><b>Số bài viết chưa phê duyệt</b></td>
	          <td>${countNoDuyet }</td>
	
	        </tr>
	      </tbody>
	    </table>
	</div>
	

    <script	src="<%=request.getContextPath()%>/resources/js/jquery.js"></script>
	<script	src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
	
</body>
</html>