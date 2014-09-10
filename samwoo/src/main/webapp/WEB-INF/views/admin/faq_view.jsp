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
			
			<table class="aborad01_view">
				<colgroup>
					<col width="10%">
					<col width="20%">
					<col width="10%">
					<col width="20%">
					<col width="10%">
					<col width="*%">
				</colgroup>
				<tr>
					<th class="onb">번호</th>
					<th>${faqRecord.num}</th>
					<th class="onb">작성일</th>
					<th></th>
					<th class="onb"></th>
					<th></th>
				</tr>
				<tr>
					<td class="onb">질문</td>
					<td colspan="5" class="subject">${faqRecord.question}</td>
				</tr>
				<tr style="background:#FBFBFB;">
					<td class="onb" valign="top">답변</td>
					<td colspan="5" class="subject">
						${faqRecord.answer}
					</td>
				</tr>
			</table>

			<div class="btn_wrap">
				<a href="/admin/faqWrite?num=${faqRecord.num}"><img src="/admin/img/btn_modify.gif"></a>
				<a href="/admin/faq?pageNum=${page}"><img src="/admin/img/btn_list.gif"></a>
			</div>

		</div>

	</div>

	<div id="footwrap">

	</div>

</div>

</body>
</html>