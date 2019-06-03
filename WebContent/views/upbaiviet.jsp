<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://cksource.com/ckfinder" prefix="ckfinder" %>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/style1.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/upImg.css">
</head>

<body>
	<jsp:include page="header.jsp"></jsp:include>
	
	<div class="container" style="width:90%;">
        <h2 class="title-style">Đăng bài viết</h2>



        <form class="form-horizontal" onsubmit="return checkUpPost()" action="<%=request.getContextPath()%>/up-post" method="POST">
          <div style="margin-bottom:2%;" class="form-group">
            <label class="control-label col-sm-2" for="">Danh mục :</label>
            <div class="col-sm-10">
              <label class="radio-inline">
                <input type="radio" name="optradio" checked="checked" value="giaitri">Giải trí
              </label>
              <label class="radio-inline">
                <input type="radio" name="optradio" value="vanhoa">Văn hóa
              </label>
              <label class="radio-inline">
                <input type="radio" name="optradio" value="doisong">Đời sống
              </label>
              <label class="radio-inline">
                <input type="radio" name="optradio" value="thethao">Thể thao
              </label>
              <label class="radio-inline">
                <input type="radio" name="optradio" value="congnghe">Công nghệ
              </label>
            </div>
          </div>
          
          <div class="form-group">
            <label class="control-label col-sm-2" for="">Tiêu đề :</label>
            <div class="col-sm-10">
            <textarea class="form-control" rows="2" id="tieude" name="tieude"></textarea>
            </div>
          </div>
          <div class="form-group">
            <label class="control-label col-sm-2" for="">Ảnh đại diện :</label>
            <div class="input-group col-sm-10">
            <span class="input-group-btn">
                <span class="btn btn-default btn-file">
                    Chọn ảnh <input type="file" id="imgInp" name = "hinhanh" >
                </span>
            </span>
            <input type="text" id="img" class="form-control" readonly >
        </div>
        <div style="margin:auto, width:50%;">
        <img id="img-upload" name = "hinhanh" >
        </div>
          </div>
          <div class="form-group">
            <label class="control-label col-sm-2" for="">Mô tả :</label>
            <div class="col-sm-10">
            <textarea class="form-control" rows="2" id="tomtat" name="tomtat"></textarea>
            </div>
          </div>


          <div class="form-group">
            <label class="control-label col-sm-2" for="">Nội dung :</label>
            <div class="col-sm-10">
	            <textarea class="form-textarea" rows = "200" id="noiDung" name="noidung"></textarea>
            </div>
          </div>
          
          <div>
          <div class="col-sm-2"></div>
          <div class="col-sm-2">
	          <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">Hướng dẫn đăng ảnh, video</button>
	
	          <div id="myModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	            <div class="modal-dialog">
	              <div class="modal-content">
	                  <div class="modal-body">
	                      <img src="<%=request.getContextPath()%>/resources/img/img/huong-dan.png" class="img-responsive">
	                  </div>
	              </div>
	            </div>
	          </div>
	         </div>
	     </div>
          
          <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
            <br>	
              <button type="submit" class="btn btn-success">Đăng bài</button>
              <button type="reset" class="btn btn-warning">Tạo mới</button>
            </div>
          </div>
        </form>
      </div>
      

    <script	src="<%=request.getContextPath()%>/resources/js/jquery.js"></script>
	<script	src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/upImg2.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/checkUpPost.js"></script>
	<script src="<%=request.getContextPath()%>/resources/ckeditor1/ckeditor.js"></script>
	<script src="<%=request.getContextPath()%>/resources/ckfinder/ckfinder.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/huong-dan.js"></script>
	<script>  
		var editor = CKEDITOR.replace('noiDung');
		CKFinder.setupCKEditor(editor,'resources/ckfinder/');
	</script>
	
</body>
</html>