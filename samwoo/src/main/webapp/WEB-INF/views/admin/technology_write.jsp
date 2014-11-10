<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd" />
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="ko" lang="ko" />
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>SAMWOO ADMIN</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<link rel="stylesheet" type="text/css" href="/admin/css/style.css"/>
<script type="text/javascript" src="/admin/js/jquery-1.7.min.js"></script>
<script type="text/javascript" src="/admin/js/script.js"></script>
<script type="text/javascript" src="/admin/js/ajaxRequest.js"></script>
<script type="text/javascript" src="/se_editor/js/HuskyEZCreator.js"></script>
<c:if test="${techRecord.division != null}">

<script>
window.onload = function() {
	var division = "${techRecord.division}";
	document.getElementById("division").value = division;
}

$(function() {
	
	$("#techForm").submit(function() {
		if(document.getElementById("title").value=="") {
			alert("제목을 입력하여 주십시오");
			return false;
		}	
	});
});


</script>
</c:if>
</head>
<body>

<div id="wrap">

		<%@ include file="include/admin_head.jsp" %>
		
		<div class="title_area">
				<img src="/admin/img/title02.gif"/>
			</div>
		
		<form name="techForm" id="techForm" action="/admin/techWrite" method="post" encType="multipart/form-data">
		<table class="aborad01_write">
			<colgroup>
				<col width="17%">
				<col width="*">
			</colgroup>
			<tr>
				<th>분류</th>
				<td>
					<select id="division" name="division" class="ainp05">
						<option value="특허">특허</option>
						<option value="신기술">신기술</option>
					</select>
				</td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" name="title" class="ainp01" value="${techRecord.title}"/></td>
			</tr>
			<tr>
				<th>첨부파일</th>
				<td>
					<input type="file" name="multiPart1" class="ainp06" />
					<div class="file_txt">
					<c:if test="${tech_fileList != null}">
						<c:forEach var="file"  items="${tech_fileList}">
								<p id="fileItem${file.num}">	
									<span style="font-weight:bold; color:red;">* 현재 첨부된 파일은 <b>${file.fileName}</b>입니다.</span>
									<span style="display:inline-block; margin-left:20px; color:black; font-weight:bold;"><a href="javascript:deleteFile(${file.num},'technology')">x</a></span>
								</p>
						</c:forEach>
					</c:if>
					첨부파일은 10MB이하 jpg, gif, png만 첨부 가능합니다.<br/>
					이미지 사이즈는 270*400(가로*세로)이 최적화입니다.
					</div>
				</td>
			</tr>
		</table>
		<c:if test="${sqlType != null}">
				<input type="hidden" name="num" value="${num}"/>
				<input type="hidden" name="sqlType" value="${sqlType}"/>
		</c:if>
		

			<div class="btn_wrap">
				<input type="submit"  style="background-image:url('/admin/img/btn_confirm.gif'); width:55px; height:24px; cursor:pointer;" value=""/>  
				<a href="/admin/technology"><img src="/admin/img/btn_cancle.gif" /></a>
			</div>
		</form>	
		</div>

	</div>

	<div id="footwrap">

	</div>

</div>
</body>
<c:if test="${respon != null}">
	<script>
	    var status = "${respon.status}", message = "${respon.message}";
		if (status == false) { 
			status="오류"; 
			alert(status +  " : " + message);
		} else {
			alert(message);
		}
	</script>
</c:if>
</html>