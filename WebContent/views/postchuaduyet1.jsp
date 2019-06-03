<%@page import="com.entities.Post"%>
<%@page import="java.util.List"%>
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
	
	<%	
		if(request.getAttribute("listChuaDuyet") != null){
			List<Post> listChuaDuyet1 = (List<Post>) request.getAttribute("listChuaDuyet");
			for(Post post: listChuaDuyet1){
				if(post.getTheLoai().equals("giaitri")){
					post.setNoiDung("Giải trí");
				}
				else if(post.getTheLoai().equals("vanhoa")){
					post.setNoiDung("Văn hóa");
				}
				else if(post.getTheLoai().equals("doisong")){
					post.setNoiDung("Đời sống");
				}
				else if(post.getTheLoai().equals("congnghe")){
					post.setNoiDung("Công nghệ");
				}
				else{
					post.setNoiDung("Thể thao");
				}
			}
			request.setAttribute("listChuaDuyet1", listChuaDuyet1);
		}
		
	%>
        
		<% int count = (Integer) request.getAttribute("count"); %>

	<h2> ${message } </h2>
		<div>
	       	<c:forEach items="${listChuaDuyet1}" var = "post">
	       		<div class="list-item1">
		          <a href="sua-bai-viet?tieuDe=${post.tieuDe}"><img class="img-size1 img-thumbnail" src="<%=request.getContextPath()%>/resources/img/img/${post.hinhAnh}" alt=""></a>
		          <div>
		            <h3 class="a-text " ><a id="${post.id}" class = "btn-baiviet" style="font-size: 15px;"
		             								href="sua-bai-viet?tieuDe=${post.tieuDe}" >${post.tieuDe }</a></h3>
		            <p style="font-size: 11px;">Ngày đăng: ${post.ngayDang}</p>
		            <p style="font-size: 11px;">Chuyên mục: ${post.noiDung }</p>
		            <p style="font-style:italic; font-size: 11px;">Tóm tắt: ${post.tomTat }</p>
		          </div>
		        </div>
	       	</c:forEach>
	  	</div>

       <div style="margin:auto; width:60%;">
        <ul  id="pagination"></ul>
      </div>

      </div>
      
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