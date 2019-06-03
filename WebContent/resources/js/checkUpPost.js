/**
 * 
 */

function checkUpPost() {
	  var r = confirm("Xác nhận.");
	  if (r == true) {
		  var tieuDe = document.getElementById("tieude").value;
		  var hinhAnh = document.getElementById("img").value;
		  var tomTat = document.getElementById("tomtat").value;
		  var noiDung = document.getElementById("noiDung").value;

			if (tieuDe == "") {
				document.getElementById("tieude").style.border = "2px solid red";
				alert("Chưa nhập tiêu đề");
				return false;
			} else {
				document.getElementById("tieude").style.border = "2px solid #66FF66";
			}

			if (hinhAnh == "") {
				document.getElementById("img").style.border = "2px solid red";
				alert("Chưa chọn ảnh đại diện");
				return false;
			} else {
				document.getElementById("img").style.border = "2px solid #66FF66";
			}
			
			if (tomTat == "") {
				document.getElementById("tomtat").style.border = "2px solid red";
				alert("Chưa nhập tóm tắt");
				return false;
			} else {
				document.getElementById("tomtat").style.border = "2px solid #66FF66";
			}
			
			alert("Thành công!");
	  } else
	    return false;
};

$(document).ready(function(){
	  
	  $(".btn-delete").click(function(){
		    alert("Xóa bài thành công!");
		  });
	});
