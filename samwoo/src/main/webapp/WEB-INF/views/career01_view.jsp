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
	<a href="https://twitter.com/share" class="twitter-share-button" data-url="http://www.samwoospace.co.kr/career01">Tweet</a>
	<script>!function(d,s,id){var js,fjs=d.getElementsByTagName(s)[0],p=/^http:/.test(d.location)?'http':'https';if(!d.getElementById(id)){js=d.createElement(s);js.id=id;js.src=p+'://platform.twitter.com/widgets.js';fjs.parentNode.insertBefore(js,fjs);}}(document, 'script', 'twitter-wjs');</script>
	<div class="fb-like" data-share="true" data-width="450" data-show-faces="true">
	</div>
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
				<col width="10%">
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
				<th class="onb">조회수</th>
				<th>${recruitRecord.readCounts}</th>
			</tr>
			<tr>
				<td class="onb">제목</td>
				<td colspan="9" class="subject">${recruitRecord.title}</td>
			</tr>
			<tr>
				<td colspan="10" style="padding:30px 0;">
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