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
	var division = "${division}";
	var category = "${category}";

	$(function() {
		document.getElementById("division").value = division;
		document.getElementById("category").value = category;
		
		$("#division").on("change", function() {
			var value = $(this).val();
			if(value=='All') {
				$("#category").val("All");
			}
		});
		
		$("#category").on("change", function() {
			
			var division = $("#division").val();
			if(division=='All') {
				alert("분류를 먼저 선택하여 주십시오");
				$(this).val("All");
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
				<img src="/admin/img/title03.gif"/>
			</div>
			
			<form name="listAlign" id="listAlign" method="get" action="/admin/result">
				<span style="display:inline-block; width:200px; margin-right:5px;">
					분류 :
					<select id="division" name="division" class="ainp05">
						<option value="All" selected>전체</option>
						<option value="A">건설사업관리</option>
						<option value="B">설계</option>
						<option value="C">미디어 사업</option>
						<option value="D">기술연구소</option>
					</select>
				</span>
				<span style="display:inline-block; width:230px;">
					세부분류 : 
					<select id="category" name="category" class="ainp05">
						<option id="All" value="All">전체</option>
						<option id="RD" value="RD">주거시설</option>
						<option id="EDLA" value="EDLA">교육/연구시설</option>
						<option id="MEWE" value="MEWE">의료/복지시설</option>
						<option id="OF" value="OF">업무시설</option>
						<option id="MICO" value="MICO">군사/교정시설</option>
						<option id="CA" value="CA">문화/집회시설</option>
						<option id="ETC" value="ETC">기타</option>	
					</select>
				</span>
			<input type="text" name="searchWord" id="searchWord" value="" class="ainp01" style="width:130px;"/>
			<input type="submit" value="검색" style="width:50px; height:25px; cursor:pointer; border-radius:4px; color:white; background-color:#FFE400; font-weight:bold; "/>
			<span style="display:inline-block; width:250px; text-align:right;"><a href="/admin/resultWrite"><img src="img/btn_apply.gif"/></a></span>
			</form>
			
			<form name="listForm" id="listForm" method="post" action="/admin/delete">
			<table class="aborad01">
				<colgroup>
					<col width="4%">
					<col width="6%">
					<col width="10%">
					<col width="12%">
					<col width="10%">
					<col width="*">
					<col width="10%">
				</colgroup>
				<tr>
					<th class="tip01"><input type="checkbox" id="checKAll" onclick="CheckAll(this)"/></th>
					<th>번호</th>
					<th>분류</th>
					<th>세부분류</th>
					<th>이미지</th>
					<th>사업명</th>
					<th class="tip02">작성일</th>
				</tr>
				<c:forEach var="resultRecord"  items="${resultList}" >
				<tr>
					<td><input type="checkbox" name="boardNum" value="result&${resultRecord.num}"/></td>
					<td>${resultRecord.num}</td>
					<td>${resultRecord.division}</td>
					<td>${resultRecord.category_name}</td>
					<td>
						<a href="/admin/resultView?num=${resultRecord.num}&pageNum=${page}">
							<c:choose>
								<c:when test="${resultRecord.encodedFileName != null}"><img src="/resources/upload/thumbnail/${resultRecord.thumbUrl}" class="spic" alt="${resultRecord.fileName}"/></c:when>
								<c:when test="${resultRecord.encodedFileName == null}">없음</c:when>
							</c:choose>	
						  </a>
					</td>
					<td class="tleft"><a href="/admin/resultView?num=${resultRecord.num}&pageNum=${page}">${resultRecord.title}</a></td>
					<td>${resultRecord.date}</td>
				</tr>
				</c:forEach>
			</table>
			

			<div class="btn_area">
				<input type="submit" style="background-image:url('/admin/img/btn_delete.gif'); width:55px; height:23px; cursor:pointer; border-radius:6px; " value="" />
				<div class="pagging">
					<ul>
						${paging}
					</ul>
				</div>
			</div>
			</form>
		</div>

	</div>

	<div id="footwrap">

	</div>

</div>
<c:if test="${respon != null}">
	<script>
	    var status = "${respon.status}", message = "${respon.message}";
		if (status == false) { 
			status="오류"; 
			alert(status +  " : " + message);
		} else {
			alert(message);
		}
</script>
</c:if>
</body>
</html>