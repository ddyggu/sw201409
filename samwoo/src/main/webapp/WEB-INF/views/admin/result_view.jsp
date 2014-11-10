<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd" />
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="ko" lang="ko" />
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>SAMWOO ADMIN</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<link rel="stylesheet" type="text/css" href="css/style.css"/>
<script type="text/javascript" src="js/jquery-1.7.min.js"></script>
<script type="text/javascript" src="js/script.js"></script>
<script>
$(function() {
	var division = '${resultRecord.division}';
	
	if(division == '미디어 사업') {
		$(".aborad01_view tr").slice(2,6).css("display","none");
	} else {
		$(".aborad01_view tr:last-child").css("display","none");
	}
	
});
</script>
</head>
<body>

<div id="wrap">

			<%@ include file="include/admin_head.jsp" %>
		
			<div class="title_area">
				<img src="/admin/img/title03.gif"/>
			</div>

			<table class="aborad01_view">
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
					<th>${resultRecord.num}</th>
					<th class="onb">등록일</th>
					<th>${resultRecord.date}</th>
					<th class="onb">조회수</th>
					<th>${resultRecord.readCounts}</th>
				</tr>
				<tr>
					<td class="onb">사업명</td>
					<td colspan="5" class="subject">${resultRecord.title}</td>
				</tr>
				<tr>
					<td class="onb">위치</td>
					<td colspan="5" class="subject">${resultRecord.location}</td>
				</tr>
				<tr>
					<td class="onb">대지면적</td>
					<td colspan="5" class="subject">${resultRecord.lotArea}㎡</td>
				</tr>
				<tr>
					<td class="onb">연면적</td>
					<td colspan="5" class="subject">${resultRecord.totalArea}㎡</td>
				</tr>
				<tr>
					<td class="onb">규모</td>
					<td colspan="5" class="subject">${resultRecord.size}</td>
				</tr>
				<tr>
					<td colspan="6" style="padding:30px 0;">
						<c:choose>
							<c:when test="${resultRecord.encodedFileName == null}">업로드된 이미지가 존재하지 않습니다.</c:when>
							<c:when test="${resultRecord.encodedFileName != null}"><img src="/resources/upload/${resultRecord.encodedFileName}" alt="${resultRecord.fileName}" style="width:700px; height:400px;"/></c:when>
						</c:choose>
					</td>
				</tr>
				<tr>
					<td class="onb">내용</td>
					<td colspan="5" style="padding:30px 0;">
						${resultRecord.contents}
					</td>		
				</tr>
			</table>

			<div class="btn_wrap">
				<a href="/admin/resultWrite?bbsId=result&num=${resultRecord.num}"><img src="/admin/img/btn_modify.gif"></a>
				<a href="/admin/result?pageNum=${page}"><img src="img/btn_list.gif"/></a>
			</div>

		</div>

	</div>

	<div id="footwrap">

	</div>

</div>

</body>
</html>