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
				<img src="/admin/img/title05.gif"/>
			</div>
			<form name="listForm" id="listForm" method="post" action="/admin/delete">
			<table class="aborad01">
				<colgroup>
					<col width="6%">
					<col width="8%">
					<col width="*">
					<col width="12%">
					<col width="12%">
					<col width="12%">
				</colgroup>
				<tr>
					<th class="tip01"><input type="checkbox" id="checKAll" onclick="CheckAll(this)"/></th>
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>작성일</th>
					<th class="tip02">처리결과</th>
				</tr>
				<c:forEach var="consultRecord"  items="${consultList}">
				<tr>
					<td><input type="checkbox" name="boardNum" value="consult&${consultRecord.num}"/></td>
					<td>${consultRecord.num}</td>
					<td class="tleft"><a href="/admin/consultView?num=${consultRecord.num}&pageNum=${page}">${consultRecord.title}</a></td>
					<td>${consultRecord.name}</td>
					<td>${consultRecord.date}</td>
					<td>
						<c:choose>
							<c:when test="${consultRecord.a_answer !=null }">답변완료</c:when>
							<c:when test="${consultRecord.a_answer==null }">대기중</c:when>
						</c:choose>
						
					</td>
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

		</div>
		</form>
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