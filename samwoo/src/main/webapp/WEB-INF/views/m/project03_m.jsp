<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta name="viewport" content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, width=device-width" /> 
<link rel="stylesheet" type="text/css" href="/m/css/style.css"/>
<title> SAMWOO 모바일 </title>
</head>
<body>

<div id="wrap">
	<div class="topwrap">
		<a href="/index"><img src="/m/img/logo.jpg"></a>
	</div>
	<div class="naviwrap">
		<a href="/about01"><img src="/m/img/menu01.jpg"></a><a href="/service01"><img src="/m/img/menu02.jpg"></a><a href="/project01"><img src="/m/img/menu03.jpg"></a><a href="/career01"><img src="/m/img/menu04.jpg"></a>
	</div>
	<div class="submenu03">
		<ul>
			<li><a href="/project01">건설사업관리</a></li>
			<li><a href="/project02">설계</a></li>
			<li><a href="/project03"><strong class="fc01">미디어 사업</strong></a></li>
			<li class="noneli">&nbsp;</li>
		</ul>
	</div>
	
	<div class="contents">
		<h2 class="subtitle">
		<span class="bullet_vline"></span>수행실적
			<!--  
			<div class="sel_area">
				<select class="select">
					<option value="">전체보기</option>
				</select>
			</div>
			-->
		</h2>

		<c:forEach var="record" items="${resultList}">
		<div class="sub03">
			<img src="/resources/upload/${record.encodedFileName}">
			<div class="sub03_txt">
				<strong class="ml20">${record.title}</strong>
			</div>
		</div>	
		</c:forEach>
		
		<div class="pagging">
			<ul>
				${paging}
			</ul>
		</div>
	</div>

	<div class="footer">
		<img src="/m/img/copy.jpg">
	</div>

</div>


</body>
</html>