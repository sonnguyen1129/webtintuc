<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<title>Đăng ký thành viên</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/style1.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/login.css">

<script	src="<%=request.getContextPath()%>/resources/js/jquery.js"></script>
<script	src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/validate.js"></script>

</head>

<body>

	<jsp:include page="header.jsp"></jsp:include>

	<div class="wrapper">
		<form class="form-signin" onsubmit="return validate()" action="<%=request.getContextPath()%>/signup"
			method="POST">
			<h2 class="form-signin-heading">Sign up</h2>
			<div>
				<span><input type="text" class="form-control" id="username" name="username"
					placeholder="Username" required="" /></span>
				<span id = "user-result"></span>
			</div>
				<input id = "matkhau" type="password" class="form-control" name="matkhau"
					placeholder="Password" required="" /> 
			<div>
				<span>
					<input type="text" id = "hoten" class="form-control" name="hoten" placeholder="Your full name"
						required="" /> 
				</span>
				<span id = "hoten-result"></span>
			</div>
			<button class="btn btn-lg btn-primary btn-block" type="submit">Sign	up</button>
				
		</form>
	</div>
	
	
</body>
</html>