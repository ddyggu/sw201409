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
				<!-- 동호회 정보 관리 -->
				<img src="/admin/img/title07.gif"/>
			</div>
	
			<p align="right"><a href="/admin/clubInfoWrite"><img src="/admin/img/btn_club.gif"></a></p>

			<form name="listForm" id="listForm" method="post" action="/admin/delete">
			<table class="aborad01">
				<colgroup>
					<col width="10%">
					<col width="10%">
					<col width="*">
				</colgroup>
				<tr>
					<th class="tip01"><input type="checkbox" id="checKAll" onclick="CheckAll(this)"/></th>
					<th>썸네일</th>
					<th>동호회 이름</th>
				</tr>
				<c:forEach var="record"  items="${clubInfoList}" >
				<tr class="onc">
					<td><input type="checkbox" name="boardNum" value="clubInfo&${record.num}"/></td>
					<td>
						<a href="/admin/clubInfoView?num=${record.num}&pageNum=${page}">
						<c:choose>
							<c:when test="${record.thumbUrl != null}"><img src="/resources/upload/thumbnail/${record.thumbUrl}" class="spic"/></c:when>
							<c:when test="${record.thumbUrl == null}">없음</c:when>
						</c:choose>
						</a>
					</td>
					<td class="tleft"><a href="/admin/clubInfoView?&num=${record.num}&pageNum=${page}">${record.clubname}</a></td>
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