<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="include/head.jsp" %>
<div class="location">
	<div class="map_navi">
		Home<img src="img/arrow.png" class="ar"/>Community<img src="img/arrow.png" class="ar"/>공지사항
	</div>
</div>

<div id="contents_wrap">
	<img src="img/customer_title.jpg">
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
					<th>${record.num}</th>
					<th class="onb">작성자</th>
					<th>${record.name}</th>
					<th class="onb">작성일</th>
					<th>${record.date}</th>
					<th class="onb">조회수</th>
					<th>${record.readCounts}</th>
				</tr>
				<tr>
					<th class="onb">이메일</th>
					<th>${record.email1}@${record.email2}</th>
					<th class="onb">전화번호</th>
					<th>${record.tel1}-${record.tel2}-${record.tel3}</th>
					<th class="onb">업체명</th>
					<th>${record.company}</th>
					<th class="onb"></th>
					<th></th>
				</tr>
			<tr>
				<td colspan="6" style="padding:30px 0;">
					<div class="content001">
						${record.contents}
					</div>
				</td>
			</tr>
			<c:forEach var="file" items="${consult_fileList}">
				<tr>
					<td style="font-weight:bold;">첨부파일</td>
					<td colspan="7" style="text-align:left;"><a href="/admin/download?name=${file.encodedFileName}">${file.fileName}</a></td>
				</tr>
				</c:forEach>
				<c:if test="${record.a_answer != null}">
				<tr>
					<th class="onb">답변</th>
					<th>${record.a_writer}</th>
					<th class="onb">등록일</th>
					<th colspan="6">${record.a_date}</th>
				</tr>
				<tr>
					<td colspan="8">
						<div class="content001">
						${record.a_answer}
						</div>
					</td>
				</tr>
				</c:if>
		
		</table>
		


		<div class="btn_wrap">
			<a href="/community04?pageNum=${page}"><img src="img/btn_list.gif"></a>
		</div>

	</div>

	
</div>


<%@ include file="include/bottom.jsp" %>

</body>
</html>