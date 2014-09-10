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

</head>
<body>

<div id="wrap">

			<%@ include file="include/admin_head.jsp" %>
	
			<div class="title_area">
				<img src="/admin/img/title08.gif"/>
			</div>
	
			<p align="right"><a href="/admin/popup_write"><img src="/admin/img/btn_apply.gif"></a></p>

			<form name="listForm" id="listForm" method="post" action="/admin/delete">
			<table class="aborad01">
				<colgroup>
					<col width="6%">
					<col width="8%">
					<col width="*">
					<col width="15%">
					<col width="12%">
					<col width="12%">
					<col width="12%">
				</colgroup>
				<tr>
					<th class="tip01"><input type="checkbox" id="checKAll" onclick="CheckAll(this)"/></th>
					<th>번호</th>
					<th>팝업제목</th>
					<th>노출기간</th>
					<th>노출여부</th>
					<th>팝업크기</th>
					<th class="tip02">팝업위치</th>
				</tr>
				<c:forEach var="popupRecord" items="${popupList}" >
				<tr>
					<td><input type="checkbox" name="boardNum" value="popup&${popupRecord.num}"/></td>
					<td>${popupRecord.num}</td>
					<td class="tleft"><a href="/admin/popupWrite?num=${popupRecord.num}">${popupRecord.title}</a></td>
					<td>${popupRecord.startDate} ~ ${popupRecord.endDate}</td>
					<td>${popupRecord.expose}</td>
					<td>${popupRecord.width}Ｘ${popupRecord.height}</td>
					<td>상단여백 - ${popupRecord.positionTop} <br/> 좌측여백 - ${popupRecord.positionLeft}</td>
				</tr>
				</c:forEach>
			</table>

			<div class="btn_area">
				<input type="submit" style="background-image:url('/admin/img/btn_delete.gif'); width:55px; height:23px; cursor:pointer; border-radius:6px; " value="" />
				<div class="pagging">
					<ul>
						${paging}
					</ul>
				</div>
			</div>
			<div class="tip_wrap"></div>
			</form>
		</div>

	</div>

	<div id="footwrap">

	</div>

</div>
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
</body>
</html>