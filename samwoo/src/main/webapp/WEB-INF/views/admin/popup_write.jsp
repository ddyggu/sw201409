<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd" />
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="ko" lang="ko" />
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>SAMWOO ADMIN</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<link rel="stylesheet" type="text/css" href="/admin/css/style.css"/>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" media="all" />
<script type="text/javascript" src="/admin/js/jquery-1.7.min.js"></script>
<script type="text/javascript" src="/admin/js/script.js"></script>
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js" type="text/javascript"></script>
<script type="text/javascript" src="/admin/js/ajaxRequest.js"></script>
<c:if test="${popupRecord.expose != null}">
<script>
var mainExpose = "${popupRecord.expose}";

window.onload = function() {
	if(mainExpose == 'Y') {
		document.getElementById('Yes').checked = true;
	} else {
		document.getElementById('No').checked = true;
	}
};
</script>
</c:if>

<script>
$(function() {
	$("#startDate, #endDate").datepicker({
		dateFormat: 'yy-mm-dd',
		prevText: '이전 달',
		nextText: '다음 달',
		monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
		monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
		dayNames: ['일','월','화','수','목','금','토'],
		dayNamesShort: ['일','월','화','수','목','금','토'],
		dayNamesMin: ['일','월','화','수','목','금','토'],
		showMonthAfterYear: true,
		yearSuffix: '년'
	});
	
});
</script>

</head>
<body>

<div id="wrap">

		<%@ include file="include/admin_head.jsp" %>
		
		<div class="title_area">
				<img src="/admin/img/title08.gif"/>
		</div>
		
		<form name="popForm" id="popForm" action="/admin/popupWrite" method="post" encType="multipart/form-data">
		<table class="aborad01_write">
			<colgroup>
				<col width="17%">
				<col width="*">
			</colgroup>
			<tr>
				<th>팝업 제목</th>
				<td><input type="text" name="title" class="ainp01" value="${popupRecord.title}"/></td>
			</tr>
			<tr>
				<th>노출 기간</th>
				<td><input type="text" id="startDate" name="startDate" class="ainp04" value="${popupRecord.startDate}"/> - <input type="text" id="endDate" name="endDate" class="ainp04" value="${popupRecord.endDate}"/></td>
			</tr>
			<tr>
				<th>노출 여부</th>
				<td>
					<input type="radio" name="expose" id="Yes" value="Y" checked/>노출&nbsp; 
					<input type="radio" name="expose" id="No" value="N" />숨김
				</td>
			</tr>
			<tr>
				<th>팝업 크기</th>
				<td>가로 : <input type="text" id="popWidth" name="width" class="ainp04" value="${popupRecord.width}"/>&nbsp;&nbsp;세로 : <input type="text" id="popHeight" name="height" class="ainp04" value="${popupRecord.height}"/></td>
			</tr>
			<tr>
				<th>팝업 위치</th>
				<td>상단 : <input type="text" id="popTop" name="positionTop" class="ainp04" value="${popupRecord.positionTop}"/>&nbsp;&nbsp;좌측 : <input type="text" id="popLeft" name="positionLeft" class="ainp04" value="${popupRecord.positionLeft}"/></td>
			</tr>
			<tr>
				<th>첨부파일</th>
				<td>
					<input type="file" name="multiPart1" class="ainp06" />
					<div class="file_txt">
					<c:forEach var="file"  items="${popup_fileList}">
							<p id="fileItem${file.num}">	
								<span style="font-weight:bold; color:red;">* 현재 첨부된 파일은 <b>${file.fileName}</b>입니다.</span>
								<span style="display:inline-block; margin-left:20px; color:black; font-weight:bold;"><a href="javascript:deleteFile(${file.num},'club')">x</a></span>
							</p>
					</c:forEach>
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
				<a href="/admin/popup"><img src="/admin/img/btn_cancle.gif" /></a>
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