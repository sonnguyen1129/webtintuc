<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<title>Log in</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/style1.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/login.css">
</head>

<body>

	<jsp:include page="header.jsp"></jsp:include>

	<div class="wrapper">
        <form class="form-signin" action="<%=request.getContextPath()%>/login" method="POST">
          <h2 class="form-signin-heading">Login</h2>
          <input type="text" class="form-control" name="username" placeholder="Username" required="" autofocus="" />
          <input type="password" class="form-control" name="matkhau" placeholder="Password" required=""/>
          <label class="checkbox">
            <input type="checkbox" value="remember-me" id="rememberMe" name="rememberMe"> Remember me
          </label>
          <button class="btn btn-lg btn-primary btn-block" type="submit">Login</button>
        </form>
      </div>
</body>
</html>