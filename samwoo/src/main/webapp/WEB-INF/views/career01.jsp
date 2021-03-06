<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ include file="include/head.jsp" %>
<div class="location">
	<div class="map_navi">
		Home<img src="img/arrow.png" class="ar"/>Career<img src="img/arrow.png" class="ar"/>채용공고
	</div>
</div>

<div id="contents_wrap">
	<img src="img/career_title01.jpg">
	<div class="sub06">
		<div class="gallery_area">
			<form id="careerSearch" name="careerSearch" action="/career01" method="get">
			<div class="select_area">
				<select name="searchType_career" class="inp01">
					<option value="title">제목</option>
					<option value="contents">내용</option>
				</select>
			</div>
		
			<div class="search_area">
				<input type="text" name="searchWord_career" class="inp">
				<input type="submit" value="" style="cursor:pointer; width:20px; background-image:url('img/btn_search.gif');"/>
			</div>
			</form>
		</div>

		<table class="borad01">
			<colgroup>
				<col width="10%">
				<col width="10%">
				<col width="15%">
				<col width="*">
				<col width="10%">
				<col width="20%">
				<col width="5%">
			</colgroup>
			<tr>
				<th>번호</th>
				<th>업무</th>
				<th>경력</th>		
				<th>제목</th>		
				<th>진행상태</th>		
				<th>모집기간</th>
				<th>조회수</th>	
			</tr>
			<c:forEach var="record" items="${recruitRecord}">
			<tr>
				<td>${record.num}</td>
				<td><strong class="c01">${record.division}</strong></td>
				<td><span class="c02">${record.career}</span></td>
				<td style="text-align:left;">
					<a href="/careerView?num=${record.num}&pageNum=${page}"><strong class="c01">${record.title}</strong></a>
				</td>
				<td><span class="c02">${record.isEnd}</span></td>
				<td><span class="c03">${record.startDate} ~ ${record.endDate}</span></td>			
				<td><span class="c02">${record.readCounts}</span></td>
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