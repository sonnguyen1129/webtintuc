<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
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
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/fontawesome.css">
</head>

<body id = "body">

	<%	
		Post post1 = (Post) request.getAttribute("newBaiviet");
		if(post1.getTheLoai().equals("giaitri")){
			post1.setNoiDung("Giải trí");
		}
		else if(post1.getTheLoai().equals("vanhoa")){
			post1.setNoiDung("Văn hóa");
		}
		else if(post1.getTheLoai().equals("doisong")){
			post1.setNoiDung("Đời sống");
		}
		else if(post1.getTheLoai().equals("congnghe")){
			post1.setNoiDung("Công nghệ");
		}
		else{
			post1.setNoiDung("Thể thao");
		}
		
		List<Post> listNew = (List<Post>) request.getAttribute("list2News");
		for(Post post: listNew){
			if(post.getTheLoai().equals("giaitri")){
				post.setNoiDung("Giải trí");
			}
			else if(post.getTheLoai().equals("vanhoa")){
				post.setNoiDung("Văn hóa");
			}
			else if(post.getTheLoai().equals("doisong")){
				post.setNoiDung("Đời sống");
			}
			else if(post1.getTheLoai().equals("congnghe")){
				post1.setNoiDung("Công nghệ");
			}
			else{
				post.setNoiDung("Thể thao");
			}
		}

		
		int count = (int) request.getAttribute("numberWait");
		request.setAttribute("listNew", listNew);
		request.setAttribute("post1", post1);
	%>

	<jsp:include page="header.jsp"></jsp:include>
	
	
	<div class="container left_content" id = "content">
        <h2 class="title-style">Tin mới</h2>
        <div id="myCarousel" class="carousel slide" data-ride="carousel">

          <!-- Wrapper for slides -->
          <div class="carousel-inner">
          
            <div class="item active">
              <a  href="baiviet?id=${post1.tieuDe}"><img src="<%=request.getContextPath()%>/resources/img/img/${post1.hinhAnh}" alt="" style="width:100%; height:auto;"></a>
              <div class="text-block">
                <a href="theloai?theloai=${post1.theLoai}" class="btn btn-success" >${post1.noiDung }</a>
                <h3><a href="baiviet?id=${post1.tieuDe}" class="white-color" >${post1.tieuDe }</a> </h3>
                <p class="date-color"> ${post1.ngayDuyet} </p>
                <p class="date-color">${post1.view} lượt xem</p>
              </div>
            </div>
 
		<c:forEach items="${listNew}" var = "post">
			<div class="item">
              <a  href="baiviet?id=${post.tieuDe}"><img src="<%=request.getContextPath()%>/resources/img/img/${post.hinhAnh}" alt="" style="width:100%; height:auto;"></a>
              <div class="text-block">
                <a href="theloai?theloai=${post.theLoai}" class="btn btn-success" >${post.noiDung }</a>
                <h3><a href="baiviet?id=${post.tieuDe}" class="white-color" >${post.tieuDe }</a> </h3>
                <p class="date-color"> ${post.ngayDuyet} </p>
                <p class="date-color">${post.view} lượt xem</p>
              </div>
            </div>
		</c:forEach>
		</div>

          <!-- Left and right controls -->
          <a class="left carousel-control" href="#myCarousel" data-slide="prev">
            <span class="glyphicon glyphicon-chevron-left"></span>
            <span class="sr-only">Previous</span>
          </a>
          <a class="right carousel-control" href="#myCarousel" data-slide="next">
            <span class="glyphicon glyphicon-chevron-right"></span>
            <span class="sr-only">Next</span>
          </a>
        </div>

        <div class="list-item">
          <div class="">
            <h2 class="title-style"><a href="<%=request.getContextPath()%>/theloai?theloai=<%="giaitri"%>">Giải trí</a></h2>
          </div>
          <a href="baiviet?id=${newGiaitri.tieuDe}"><img class="img-thumbnail" src="<%=request.getContextPath()%>/resources/img/img/${newGiaitri.hinhAnh}" alt=""></a>
          <div style = "padding:5%;">
            <p class="a-text"><a href="baiviet?id=${newGiaitri.tieuDe}"><b>${newGiaitri.tieuDe }</b></a></p>
            <p>${newGiaitri.ngayDuyet}</p>
            <p>${newGiaitri.view} lượt xem</p>
          </div>
        </div>

        <div class="list-item">
          <div class="">
            <h2 class="title-style"><a href="<%=request.getContextPath()%>/theloai?theloai=<%="vanhoa"%>">Văn hóa</a></h2>
          </div>
          <a href="baiviet?id=${newVanhoa.tieuDe}"><img class="img-thumbnail" src="<%=request.getContextPath()%>/resources/img/img/${newVanhoa.hinhAnh}" alt=""></a>
          <div style = "padding:5%;">
            <p class="a-text"><a href="baiviet?id=${newVanhoa.tieuDe}"><b>${newVanhoa.tieuDe }</b></a></p>
            <p>${newVanhoa.ngayDuyet}</p>
            <p>${newVanhoa.view} lượt xem</p>
          </div>
        </div>

        <div class="list-item">
          <div class="">
            <h2 class="title-style"><a href="<%=request.getContextPath()%>/theloai?theloai=<%="doisong"%>">Đời sống</a></h2>
          </div>
          <a href="baiviet?id=${newDoisong.tieuDe}"><img class="img-thumbnail" src="<%=request.getContextPath()%>/resources/img/img/${newDoisong.hinhAnh}" alt=""></a>
          <div style = "padding:5%;">
            <p class="a-text"><a href="baiviet?id=${newDoisong.tieuDe}"><b>${newDoisong.tieuDe }</b></a></p>
            <p>${newDoisong.ngayDuyet}</p>
            <p>${newDoisong.view} lượt xem</p>
          </div>
        </div>

        <div class="list-item">
          <div class="">
            <h2 class="title-style"><a href="<%=request.getContextPath()%>/theloai?theloai=<%="thethao"%>">Thể thao</a></h2>
          </div>
          <a href="baiviet?id=${newThethao.tieuDe}"><img class="img-thumbnail" src="<%=request.getContextPath()%>/resources/img/img/${newThethao.hinhAnh}" alt=""></a>
          <div style = "padding:5%;">
            <p class="a-text"><a href="baiviet?id=${newThethao.tieuDe}"><b>${newThethao.tieuDe }</b></a></p>
            <p>${newThethao.ngayDuyet }</p>
            <p>${newThethao.view} lượt xem</p>
          </div>
        </div>
        
        <div class="list-item">
          <div class="">
            <h2 class="title-style"><a href="<%=request.getContextPath()%>/theloai?theloai=<%="congnghe"%>">Công nghệ</a></h2>
          </div>
          <a href="baiviet?id=${newCongnghe.tieuDe}"><img class="img-thumbnail" src="<%=request.getContextPath()%>/resources/img/img/${newCongnghe.hinhAnh}" alt=""></a>
          <div style = "padding:5%;">
            <p class="a-text"><a href="baiviet?id=${newCongnghe.tieuDe}"><b>${newCongnghe.tieuDe }</b></a></p>
            <p>${newCongnghe.ngayDuyet }</p>
            <p>${newCongnghe.view} lượt xem</p>
          </div>
        </div>

      </div>
      
      
     <jsp:include page="rightcontent1.jsp"></jsp:include>

    <script	src="<%=request.getContextPath()%>/resources/js/jquery.js"></script>
	<script	src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/jquery-carousel.js"></script>
	
	<script type="text/javascript">
	$(function () {
		var number =  <%=count%>;
		if(number != 0){
			setTimeout(function(){ 
				alert("Bạn có " + number + " bài viết chờ phê duyệt"); 
			}, 1000);
		}
	});
	</script>
	
</body>
</html>