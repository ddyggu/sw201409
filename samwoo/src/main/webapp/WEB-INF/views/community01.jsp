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
			<div class="select_area">
				<select name="" class="inp01">
					<option value="">제목</option>
					<option value="">내용</option>
				</select>
			</div>
			<div class="search_area">
				<input type="text" name="" class="inp">
				<a href="#"><img src="img/btn_search.gif"></a>
			</div>
		</div>

		<table class="borad02">
			<colgroup>
				<col width="*">
				<col width="8%">
			</colgroup>
			<c:forEach var="record" items="${noticeRecord}">
			<tr>
				<td style="text-align:left;">
					<a href="/community01_view?num=${record.num}"><strong class="c05">${record.title}</strong></a>
					<div class="memo"></div>
				</td>
				<td valign="top"><span class="c04">${record.date}</span></td>
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