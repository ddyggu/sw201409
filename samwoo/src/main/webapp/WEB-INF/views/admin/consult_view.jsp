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
<script>

$(function() {
	$("#answerForm").submit(function() {
		var a_answer = $("#a_answer").val();
	
		if(a_answer == '') {
			alert("답변을 입력하여 주십시오");
			return false;
		}
	});
});
</script>
</head>
<body>

<div id="wrap">

	<%@ include file="include/admin_head.jsp" %>
			
			<div class="title_area">
				<img src="/admin/img/title05.gif"/>
			</div>
			
			<table class="aborad01_view">
				<colgroup>
					<col width="10%">
					<col width="20%">
					<col width="10%">
					<col width="20%">
					<col width="10%">
					<col width="10%">
					<col width="10%">
					<col width="*%">
				</colgroup>
				<tr>
					<th class="onb">번호</th>
					<th>${consultRecord.num}</th>
					<th class="onb">작성자</th>
					<th>${consultRecord.name}</th>
					<th class="onb">작성일</th>
					<th>${consultRecord.date}</th>
					<th class="onb">조회수</th>
					<th>${consultRecord.readCounts}</th>
				</tr>
				<tr>
					<th class="onb">이메일</th>
					<th>${consultRecord.email1}@${consultRecord.email2}</th>
					<th class="onb">전화번호</th>
					<th>${consultRecord.tel1}-${consultRecord.tel2}-${consultRecord.tel3}</th>
					<th class="onb">업체명</th>
					<th>${consultRecord.company}</th>
					<th class="onb"></th>
					<th></th>
				</tr>
				<tr>
					<td class="onb">제목</td>
					<td colspan="7" class="subject">${consultRecord.title}</td>
				</tr>
				<tr>
					<td colspan="8">
						<div class="content001">
						${consultRecord.contents}
						</div>
					</td>
				</tr>
				<c:forEach var="file" items="${consult_fileList}">
				<tr>
					<td style="font-weight:bold;">첨부파일</td>
					<td colspan="7" style="text-align:left;"><a href="/admin/download?name=${file.encodedFileName}">${file.fileName}</a></td>
				</tr>
				</c:forEach>
				<c:if test="${consultRecord.a_answer != null}">
				<tr>
					<th class="onb">답변</th>
					<th>${consultRecord.a_writer}</th>
					<th class="onb">등록일</th>
					<th colspan="6">${consultRecord.a_date}</th>
				</tr>
				<tr>
					<td colspan="8">
						<div class="content001">
						${consultRecord.a_answer}
						</div>
					</td>
				</tr>
				</c:if>
				
			</table>

			<form name="answerForm" id="answerForm" method="post" action="/admin/answerConsult">
			<table class="aborad01_write">
				<colgroup>
					<col width="12%">
					<col width="*">
					<col width="12%">
				</colgroup>
				<tr>
					<th>답변달기</th>
					<td style="background:#FBFBFB;">
						<textarea type="text" name="a_answer" id="a_answer" class="ainp03"></textarea>
						<input type="hidden" name="num" value="${consultRecord.num}"/>													
					</td>
					<td><input type="submit" style="background-image:url('/admin/img/btn_confirm.gif'); width:55px; height:24px; cursor:pointer;" value=""/></td>
				</tr>
				
			</table>
			</form>
			
			<div class="btn_wrap">
				<a href="/admin/consult?pageNum=${page}"><img src="/admin/img/btn_list.gif"></a>
			</div>
			
			<div class="tip_wrap"></div>

		</div>

	</div>

	<div id="footwrap">

	</div>

</div>

</body>
</html>