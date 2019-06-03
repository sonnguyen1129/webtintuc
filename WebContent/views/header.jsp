<%@page import="com.entities.User"%>
<%@page import="com.dao.UserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- header -->

	<%
		int count = 0;
		if(session.getAttribute("countStatus") != null){
			count = (int) session.getAttribute("countStatus");
		}
		UserDao userDao = new UserDao();
		User user = null;
		if(session.getAttribute("user") != null){
			user =(User) session.getAttribute("user");
			
		}
	%>

      

      <nav class="navbar navbar-inverse">
        <div class="container-fluid">
          <div class="navbar-header">
            <a class="navbar-brand" href="<%=request.getContextPath()%>/home">Homepage</a>
          </div>
          <ul class="nav navbar-nav">
            <li><a href="<%=request.getContextPath()%>/theloai?theloai=<%="giaitri"%>">Giải trí</a></li>
            <li><a href="<%=request.getContextPath()%>/theloai?theloai=<%="vanhoa"%>">Văn hóa</a></li>
            <li><a href="<%=request.getContextPath()%>/theloai?theloai=<%="doisong"%>">Đời sống</a></li>
            <li><a href="<%=request.getContextPath()%>/theloai?theloai=<%="thethao"%>">Thể thao</a></li>
            <li><a href="<%=request.getContextPath()%>/theloai?theloai=<%="congnghe"%>">Công nghệ</a></li>
          </ul>
          <ul class="nav navbar-nav navbar-right">
          	<%if(user == null){%>
            <li><a href="<%=request.getContextPath()%>/signup"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
            <li><a href="<%=request.getContextPath()%>/login"><span class="glyphicon glyphicon-log-in"></span> Log in</a></li>
           <%} else if(user.getQuyen() == 0){%>
            <li class="dropdown">
		      <a class="dropdown-toggle" data-toggle="dropdown" href="">Bài viết
		      <span class="caret"></span></a>
		      <ul class="dropdown-menu">
		        <li><a href="<%=request.getContextPath()%>/up-post">Đăng bài viết</a></li>
		        <li><a href="<%=request.getContextPath()%>/ds-chua-duyet">Danh sách chờ phê duyệt</a></li>
		        <li><a href="<%=request.getContextPath()%>/ds-duyet">Danh sách đã duyệt</a></li>
		        </ul>
		     </li>
		     <li><a class="notification" href="<%=request.getContextPath()%>/thong-bao">
                  <span class="fa fa-envelope"><b> Thông báo </b></span>
                  <% if(count != 0){ %>
                  <span class="badge"> ${countStatus} </span>
                  <%} %>
                </a>
            </li>
		     <li class="dropdown">
		      <a class="dropdown-toggle" data-toggle="dropdown" href="">${user.hoten}
		      <span class="caret"></span></a>
		      <ul class="dropdown-menu">
		        <li><a href="<%=request.getContextPath()%>/logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
		        </ul>
		     </li>
           <%} else{%>
           	<li><a href="<%=request.getContextPath()%>/admin"><span class=""></span>Quản lý</a></li>
            <li class="dropdown">
		      <a class="dropdown-toggle" data-toggle="dropdown" href="">${user.hoten}
		      <span class="caret"></span></a>
		      <ul class="dropdown-menu">
		        <li><a href="<%=request.getContextPath()%>/logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
		        </ul>
		     </li>
           <%} %>
          </ul>
        </div>
      </nav>