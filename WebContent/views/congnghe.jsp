<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/style1.css">
</head>

<body id = "body">
	<jsp:include page="header.jsp"></jsp:include>
	
	<div id = "content" class="container left_content">
        <div>
          <h2 class="title-style"><a href="theloai?theloai=<%="congnghe"%>">Công nghệ</a></h2>
        </div>
		
		<% int count = (Integer) request.getAttribute("count"); %>

		
		
		<div>
	       	<c:forEach items="${listCongnghe}" var = "post">
	       		<div class="list-item1">
		          <a href="baiviet?id=${post.tieuDe}"><img class="img-size1 img-thumbnail" src="<%=request.getContextPath()%>/resources/img/img/${post.hinhAnh}" alt=""></a>
		          <div>
		            <h3 class="a-text"><a id="${post.id}" class = "btn-baiviet" style="font-size: 15px;"
		             								href="baiviet?id=${post.tieuDe}" >${post.tieuDe }</a></h3>
		            <p style="font-size: 12px;">${post.ngayDuyet}</p>
		            <p style="font-size: 12px;">${post.view} lượt xem</p>
		          </div>
		        </div>
	       	</c:forEach>
	  	</div>

       <div style="margin:auto; width:60%;">
        <ul  id="pagination"></ul>
      </div>

      </div>
      
    <jsp:include page="rightcontent1.jsp"></jsp:include>
    
    

    <script	src="<%=request.getContextPath()%>/resources/js/jquery.js"></script>
	<script	src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/jquery-carousel.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/jquery.twbsPagination.js"></script>
	<script type="text/javascript">
    $(function () {
        var pageSize = 6; // Hiển thị 6 sản phẩm trên 1 trang
        showPage = function (page) {
            $(".list-item1").hide();
            $(".list-item1").each(function (n) {
                if (n >= pageSize * (page - 1) && n < pageSize * page)
                    $(this).show();
            });
        }
        showPage(1);
               
        
        var totalRows =  <%=count%>;
        var btnPage = 5; // Số nt bấm hiển thị di chuyển trang
        var iTotalPages = Math.ceil(totalRows / pageSize);

        var obj = $('#pagination').twbsPagination({
            totalPages: iTotalPages,
            visiblePages: btnPage,
            onPageClick: function (event, page) {
                console.info(page);
                showPage(page);
            }
        });
        console.info(obj.data());
    });

    </script>
	
	
</body>
</html>