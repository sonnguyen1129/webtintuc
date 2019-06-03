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
	href="<%=request.getContextPath()%>/resources/css/style1.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/fontawesome.css">
</head>

<body id="body">

	<jsp:include page="header.jsp"></jsp:include>


	<div class="container left_content" id="content">
		<h2 class="title-style">Thông báo</h2>

		<c:forEach items="${listThongBao}" var="item">
		<button class="accordion btn btn-primary">
			<span style="font-size: 15px;">Người gửi: <b> ${item.userGui}</b></span> <br>
			<span style="font-size: 10px;">Ngày: ${item.ngayGui}</span>
		</button>
		<div class="panel">
			<p>${item.noiDung}</p>
		</div>
		</c:forEach>
		
	</div>

	<script src="<%=request.getContextPath()%>/resources/js/jquery.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
	<script>
      var acc = document.getElementsByClassName("accordion");
      var i;

      for (i = 0; i < acc.length; i++) {
        acc[i].addEventListener("click", function() {
          this.classList.toggle("active");
          var panel = this.nextElementSibling;
          if (panel.style.maxHeight){
            panel.style.maxHeight = null;
          } else {
            panel.style.maxHeight = panel.scrollHeight + "px";
          } 
        });
      }
      </script>
</body>
</html>