<%@page import="com.dao.PostDao"%>
<%@page import="com.entities.Post"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/style1.css">
</head>

<body>
<div id="fb-root"></div>
<script async defer crossorigin="anonymous" src="https://connect.facebook.net/vi_VN/sdk.js#xfbml=1&version=v3.2"></script>
	<jsp:include page="header.jsp"></jsp:include>
	
	<%	Post post1 = (Post) request.getAttribute("post");
		String theLoai = new PostDao().getTheloai(post1.getTheLoai());
		String user = new PostDao().getFullName(post1.getUsername());
		request.setAttribute("theLoai", theLoai);
		request.setAttribute("fullName", user);
	%>
	
	<div class="container left_content">
	
		<button class="btn btn-light" onclick="goBack()">Quay lại</button>
        <h2 class="title-style"> ${theLoai} </h2>
        
        <h2><b>${post.tieuDe }</b></h2>
        <p>${post.ngayDuyet }</p>
        <p class = "glyphicon glyphicon-eye-open"> ${post.view} lượt xem</p>
        <div class="share_the_story">
            <span>Share: </span>
            <a href="#" class="facebook"><i class="fa fa-facebook"></i>Facebook</a>
            <a href="#" class="twitter"><i class="fa fa-twitter"></i>Twitter</a>
            <a href="#" class="google"><i class="fa fa-google-plus"></i>Google+</a>
            <a href="#" class="pinterest"><i class="fa fa-pinterest"></i>Pinterest</a>
        </div>

        <div class="">
        
          <p style="font-style:italic;"><b>${post.tomTat }</b></p>
        </div>

        <div class="" style="width:100%">
         ${post.noiDung }
        </div>

		<div style="text-align:right;">
			-- ${fullName} --
		</div>

        <div class="fb-comments" data-href="http://localhost:8080/Webtintuc/baiviet?id=${post.tieuDe }" data-width="560" data-numposts="5"></div>
        
        <div>
        	<h2 class="title-style"> Tin cùng chuyên mục </h2>
        	<c:forEach items= "${listTheloai}" var="post">
        	<div class = "style1">
	        	<a href="baiviet?id=${post.tieuDe}"><img class="img-thumbnail" src="<%=request.getContextPath()%>/resources/img/img/${post.hinhAnh}" alt=""></a>
		          <div style = "padding:5%;">
		            <p class="a-text"><a href="baiviet?id=${newThethao.tieuDe}"><b>${post.tieuDe }</b></a></p>
		            <p>${post.view} lượt xem</p>
		          </div>
	         </div>
	          </c:forEach>
        </div>
    </div>
    
  
	<div class="container right_content">
		<div class="list-group">
            <h2 class="title-style"> Bài viết cùng tác giả </h2>
			<c:forEach items= "${listNews}" var="post">
    	        <div class="list-group-item  list-group-item-success">
              		<a class = "" href="baiviet?id=${post.tieuDe}" > ${post.tieuDe} </a>
              		<p style="text-align: right;" > ${post.view } lượt xem </p>
            	</div>
            </c:forEach>          
         </div>
    </div>
        
	
      
    

    <script	src="<%=request.getContextPath()%>/resources/js/jquery.js"></script>
	<script	src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
	<script type="text/javascript">
		function goBack() {
		  window.history.back();
		}
	</script>	
</body>
</html>