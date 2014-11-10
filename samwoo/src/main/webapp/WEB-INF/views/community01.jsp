<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="include/head.jsp" %>
<div class="location">
	<div class="map_navi">
		Home<img src="img/arrow.png" class="ar"/>Community<img src="img/arrow.png" class="ar"/>공지사항
	</div>
</div>

<div id="contents_wrap">
	<img src="img/notice_title.jpg">
	<div class="sub06">
		<div class="gallery_area">
			<form id="searchForm" name="searchForm" action="/community01" method="get">
			<div class="select_area">
				<select name="searchType_notice" class="inp01">
					<option value="title">제목</option>
					<option value="contents">내용</option>
				</select>
			</div>
			<div class="search_area">
				<input type="text" name="searchWord_notice" class="inp">
				<input type="submit" value="" style="cursor:pointer; width:20px; background-image:url('img/btn_search.gif');"/>
			</div>
			</form>
		</div>

		<table class="borad02">
			<colgroup>
				<col width="10%">
				<col width="*">
				<col width="10%">
				<col width="10%">
			</colgroup>
			<tr>
				<th>번호</th>		
				<th>제목</th>		
				<th>등록일</th>
				<th>조회수</th>	
			</tr>
			<c:forEach var="record" items="${noticeRecord}">
			<tr>
				<td>${record.num}</td>
				<td style="text-align:left;">
					<a href="/community01_view?num=${record.num}"><strong class="c05">${record.title}</strong></a>
					<div class="memo"></div>
				</td>
				<td valign="top"><span class="c04">${record.date}</span></td>
				<td valign="top"><span class="c04">${record.readCounts}</span></td>
			</tr>
			</c:forEach>
		</table>

		<div class="pagging_wrap">
			<div class="pagging">
				<ul>
					${paging}
				</ul>
			</div>
		</div>

	</div>

	
</div>


<%@ include file="include/bottom.jsp" %>

</body>
</html>