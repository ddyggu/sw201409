<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="include/head.jsp" %>

<div class="location">
	<div class="map_navi">
		Home<img src="img/arrow.png" class="ar"/>Community<img src="img/arrow.png" class="ar"/>채용공고
	</div>
</div>

<div id="contents_wrap">
	<img src="img/career_title01.jpg">
	<div class="sub06">

		<table class="borad02_view">
			<colgroup>
				<col width="10%">
				<col width="10%">
				<col width="10%">
				<col width="10%">
				<col width="10%">
				<col width="10%">
				<col width="10%">
				<col width="*">
			</colgroup>
			<tr>
				<th class="onb">업무</th>
				<th>${recruitRecord.division}</th>
				<th class="onb">경력</th>
				<th>${recruitRecord.career}</th>
				<th class="onb">진행상태</th>
				<th>${recruitRecord.isEnd}</th>
				<th class="onb">모집기간</th>
				<th>${recruitRecord.startDate} ~ ${recruitRecord.endDate}</th>
			</tr>
			<tr>
				<td class="onb">제목</td>
				<td colspan="7" class="subject">${recruitRecord.title}</td>
			</tr>
			<tr>
				<td colspan="8" style="padding:30px 0;">
					<div class="content001">
					${recruitRecord.contents}
					</div>
				</td>
			</tr>
			<c:forEach var="file" items="${recruit_fileList}">
				<tr>
					<td style="font-weight:bold;">첨부파일</td>
					<td colspan="5" style="text-align:left;"><a href="/admin/download?name=${file.encodedFileName}">${file.fileName}</a></td>
				</tr>
				</c:forEach>
		</table>

		<div class="btn_wrap">
			<a href="/career01?pageNum=${page}&m=1"><img src="/admin/img/btn_list.gif"></a>
		</div>

	</div>

	
</div>


<%@ include file="include/bottom.jsp" %>

</body>
</html>