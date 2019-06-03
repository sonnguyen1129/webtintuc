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
	href="<%=request.getContextPath()%>/resources/css/admin.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/fontawesome.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/sidebar.css">
</head>

<body id="body">


	<jsp:include page="sidebar.jsp"></jsp:include>

	<div class="content ">

	<% int count = (Integer) request.getAttribute("count"); %>
	
		<div class="dropdown">
		    <button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown">Thể loại
		    <span class="caret"></span></button>
		    <ul class="dropdown-menu">
		      <li><a href="<%=request.getContextPath()%>/list-posts?theloai=giaitri">Giải trí</a></li>
		      <li><a href="<%=request.getContextPath()%>/list-posts?theloai=vanhoa">Văn hóa</a></li>
		      <li><a href="<%=request.getContextPath()%>/list-posts?theloai=doisong">Đời sống</a></li>
		      <li><a href="<%=request.getContextPath()%>/list-posts?theloai=thethao">Thể thao</a></li>
		      <li><a href="<%=request.getContextPath()%>/list-posts?theloai=congnghe">Công nghệ</a></li>
		      <li class="divider"></li>
		      <li><a href="<%=request.getContextPath()%>/list-posts?theloai=all">Tất cả</a></li>
		    </ul>
		  </div>
	
		<h2>Danh sách bài viết đã đăng</h2>
		<table id="example" class="table table-striped table-bordered"
			style="width: 100%">
			<thead>
				<tr>
					<th>Tiêu đề</th>
					<th>User đăng</th>
					<th>Thể loại</th>
					<th>Ngày duyệt</th>
					<th style="color: red">Remove</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${listPosts}" var="post">
					<tr class="list-item">
						<td><a href="baiviet?id=${post.tieuDe}"> ${post.tieuDe } </a></td>
						<td> ${post.username } </td>
						<td> ${post.theLoai } </td>
						<td> ${post.ngayDuyet } </td>
						<td><a style="margin-left: 40%; color: red; font-size: 20px;"
							class="fa fa-remove confirmation" href="delete-post?id=${post.id }&check=duyet"></a></td>
					</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<th>Tiêu đề</th>
					<th>User đăng</th>
					<th>Thể loại</th>
					<th>Ngày duyệt</th>
					<th style="color: red">Remove</th>
				</tr>
			</tfoot>
		</table>
		<div class="" style="margin: auto; width: 500px;">
			<ul id="pagination"></ul>
		</div>
	</div>

	<script src="<%=request.getContextPath()%>/resources/js/jquery.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
		
	<script type="text/javascript">
		$('.confirmation').on('click', function () {
	        return confirm('Xác nhận?');
	    });
	</script>

	<script
		src="<%=request.getContextPath()%>/resources/js/jquery.twbsPagination.js"></script>

	<script type="text/javascript">
		$(function() {
			var pageSize = 10; // Hiển thị 6 sản phẩm trên 1 trang
			showPage = function(page) {
				$(".list-item").hide();
				$(".list-item").each(function(n) {
					if (n >= pageSize * (page - 1) && n < pageSize * page)
						$(this).show();
				});
			}
			showPage(1);
			///** Cần truyền giá trị vào đây **///
			var totalRows = <%=count%>; // Tổng số sản phẩm hiển thị
			var btnPage = 5; // Số nt bấm hiển thị di chuyển trang
			var iTotalPages = Math.ceil(totalRows / pageSize);

			var obj = $('#pagination').twbsPagination({
				totalPages : iTotalPages,
				visiblePages : btnPage,
				onPageClick : function(event, page) {
					console.info(page);
					showPage(page);
				}
			});
			console.info(obj.data());
		});
	</script>
</body>
</html>