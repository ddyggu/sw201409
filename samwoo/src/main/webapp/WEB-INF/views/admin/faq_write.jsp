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
				<img src="/admin/img/title06.gif"/>
			</div>
		
		<form action="/admin/faqWrite" name="faqForm" id="faqForm" method="post">	
		<table class="aborad01_write">
			<colgroup>
				<col width="17%">
				<col width="*">
			</colgroup>
			<tr>
				<th>질문</th>
				<td><input type="text" name="question" class="ainp01" value="${faqRecord.question}"/></td>
			</tr>
			<tr>
				<th>답변</th>
				<td><textarea name="answer" class="ainp02">${faqRecord.answer}</textarea></td>
			</tr>
		</table>
		<c:if test="${sqlType != null}">
				<input type="hidden" name="num" value="${num}"/>
				<input type="hidden" name="sqlType" value="${sqlType}"/>
		</c:if>	

			<div class="btn_wrap">
				<input type="submit"  style="background-image:url('/admin/img/btn_confirm.gif'); width:100px; height:45px; cursor:pointer;" value=""/>  
				<a href="/admin/faq"><img src="/admin/img/btn_cancle.gif" /></a>
			</div>
		</form>
		</div>
		
	</div>

	<div id="footwrap">

	</div>

</div>

</body>
</html>