<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- header admin -->

	<nav class="navbar navbar-dark bg-dark" style="background-color: #23282e; color:white;">
      <div class="container-fluid">
        <div class="navbar-header">
          <a class="navbar-brand" href="#">Admin Page</a>
        </div>

        <ul class="nav navbar-nav navbar-right">
          <li><a href="<%=request.getContextPath()%>/home"><span class=""></span> Home Page</a></li>
          <li><a href="<%=request.getContextPath()%>/logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
        </ul>
      </div>
    </nav>

<!-- side bar -->

	<div class="nav-side-menu">
      <i class="fa fa-bars fa-2x toggle-btn" data-toggle="collapse" data-target="#menu-content"></i>

          <div class="menu-list">

              <ul id="menu-content" class="menu-content collapse out">
                  <li>
                    <a href="<%=request.getContextPath()%>/admin">
                    <i class="fa fa-dashboard fa-lg"></i> Dashboard
                    </a>
                  </li>

                  <li>
                    <a href="<%=request.getContextPath()%>/list-users">
                    <i class="fa fa-users"></i> Users
                    </a>
                  </li>


                  <li data-toggle="collapse" data-target="#service" class="collapsed">
                    <a href="#"><i class="fa fa-calendar-o"></i> Posts <span class="arrow"></span></a>
                  </li>
                  <ul class="sub-menu collapse" id="service">
                    <li><a href="<%=request.getContextPath()%>/list-posts?theloai=all">Danh sách bài viết</a></li>

                    <li><a href="<%=request.getContextPath()%>/list-wait?theloai=all">Bài viết chờ duyệt</a></li>
                  </ul>

              </ul>
       </div>
  </div>