<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="include/head.jsp" %>
<div class="location">
	<div class="map_navi">
		Home<img src="img/arrow.png" class="ar"/>Community<img src="img/arrow.png" class="ar"/>공지사항
	</div>
</div>

<div id="contents_wrap">
	<img src="img/notice_title.jpg">
	<div class="sub06">

		<table class="borad02_view">
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
				<th>${noticeRecord.num}</th>
				<th class="onb">등록일</th>
				<th>${noticeRecord.date}</th>
				<th class="onb">조회수</th>
				<th>${noticeRecord.readCounts}</th>
			</tr>
			<tr>
				<td class="onb">제목</td>
				<td colspan="5" class="subject">${noticeRecord.title}</td>
			</tr>
			<tr>
				<td colspan="6" style="padding:30px 0;">
					<div class="content001">
						${noticeRecord.contents}
					</div>
				</td>
			</tr>
		</table>

		<div class="btn_wrap">
			<a href="/community01?pageNum=${page}"><img src="img/btn_list.gif"></a>
		</div>

	</div>

	
</div>


<%@ include file="include/bottom.jsp" %>

</body>
</html>