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
				<!-- 동호회 게시물 관리 -->
				<img src="/admin/img/title07.gif"/>
			</div>
			
			<table class="aborad01_view">
				<colgroup>
					<col width="12%">
					<col width="20%">
					<col width="15%">
					<col width="*">
					<col width="10%">
					<col width="10%">
				</colgroup>
				<tr>
					<th class="onb01">번호</th>
					<th>${clubRecord.num}</th>
					<th class="onb01">동호회이름</th>
					<th>${clubRecord.clubname}</th>
					<th class="onb01">작성일</th>
					<th>${clubRecord.date}</th>
				</tr>
				<tr>
					<td class="onb01">FACEBOOK</td>
					<td class="subject" colspan="5">${clubRecord.facebook}</td>
					
				</tr>
				<tr>
					<td class="onb01">TWITTER</td>
					<td class="subject" colspan="5">${clubRecord.twitter}</td>
				</tr>
				<tr>
					<td class="onb01">제목</td>
					<td colspan="5" class="subject">${clubRecord.title}</td>
				</tr>
				<tr>
					<td class="onb01">이미지</td>
					<td colspan="5" class="subject"><img src="/resources/upload/${clubRecord.encodedFileName}" style="width:600px; height:400px;"/></td>
				</tr>
				<tr>
					<td colspan="6" style="padding:30px 0;">
						<div class="content001">
						<br/>
						${clubRecord.contents}
						</div>
					</td>
				</tr>
			</table>

			<div class="btn_wrap">
				<a href="/admin/clubWrite?bbsId=club&num=${clubRecord.num}"><img src="/admin/img/btn_modify.gif"></a>
				<a href="/admin/club?pageNum=${page}"><img src="/admin/img/btn_list.gif"></a>
			</div>

		</div>

	</div>

	<div id="footwrap">

	</div>

</div>

</body>
</html>