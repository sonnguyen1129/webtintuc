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

	<% int count = (Integer) request.getAttribute("countUsers"); %>
	
		<h2>Danh sách người dùng</h2>
		<table id="example" class="table table-striped table-bordered"
			style="width: 100%">
			<thead>
				<tr>
					<th>Username</th>
					<th>Họ tên</th>
					<th>Số bài đăng</th>
					<th style="color: red">Remove</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${listUsers}" var="user">
					<tr class="list-item">
						<td> ${user.username } </td>
						<td> ${user.hoten } </td>
						<td> ${user.quyen } </td>
						<td><a style="margin-left: 40%; color: red; font-size: 20px;"
							class="fa fa-remove confirmation" href="delete-user?username=${user.username }"></a></td>
					</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<th>Username</th>
					<th>Họ tên</th>
					<th>Số bài đăng</th>
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

	<script
		src="<%=request.getContextPath()%>/resources/js/jquery.twbsPagination.js"></script>
		
	<script type="text/javascript">
		$('.confirmation').on('click', function () {
	        return confirm('Xóa thành viên sẽ xóa tât cả bài viết của thành viên. Xác nhận?');
	    });
	</script>

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