<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="include/head.jsp" %>
<div class="location">
	<div class="map_navi">
		Home<img src="img/arrow.png" class="ar"/>
		${name}
	</div>
</div>

<div id="contents_wrap">
	<img src="img/project_title_${division}.jpg">

	<div class="gallery_area">
		<script>
			var division = "${division}";
			var category = "${category}";
			var defaultIndex;
			
			
			$(function(){
	
				switch(category) {
				case "All"  : defaultIndex=0; break; 
				case "RD"   : defaultIndex=1; break;
				case "EDLA" : defaultIndex=2; break; 
				case "MEWE" : defaultIndex=3; break;
				case "OF"   : defaultIndex=4; break;
				case "CA" 	: defaultIndex=5; break;
				case "MICO" : defaultIndex=6; break;
				case "ETC"  : defaultIndex=7; break;
			}
				
	
				$('a[href=#tabs-1]').click(function() {
					location.href="/project?division="+division+"&category=All&viewType=list";
				});
				$('a[href=#tabs-2]').click(function() {
					location.href="/project?division="+division+"&category=RD&viewType=list";
				});
				$('a[href=#tabs-3]').click(function() {
					location.href="/project?division="+division+"&category=EDLA&viewType=list";
				});
				$('a[href=#tabs-4]').click(function() {
					location.href="/project?division="+division+"&category=MEWE&viewType=list";
				});
				$('a[href=#tabs-5]').click(function() {
					location.href="/project?division="+division+"&category=OF&viewType=list";
				});
				$('a[href=#tabs-6]').click(function() {
					location.href="/project?division="+division+"&category=CA&viewType=list";
				});
				$('a[href=#tabs-7]').click(function() {
					location.href="/project?division="+division+"&category=MICO&viewType=list";
				});
				$('a[href=#tabs-8]').click(function() {
					location.href="/project?division="+division+"&category=ETC&viewType=list";
				});
				
			});
		</script>
					  
		<div class="sort_area">
			<ul class="sort">
				<li><a href="/project?division=A">건설사업관리</a></li>
				<li><a href="/project?division=B">건축설계</a></li>
				<li><a href="/project?division=C">미디어 사업</a></li>
				<!-- <li><a href="/project?division=4">기술연구소</a></li> -->
				<li>
					<a class="btn btn_cube ir" href="/project?division=${division}&category=${category}&viewType=cube">큐브 모양으로 보기</a>
					<a class="btn btn_list ir on" href="/project?division=${division}&category=${category}&viewType=list">리스트 모양으로 보기</a>
				</li>
			</ul>
		</div>
		<div class="search_area">
		<form name="searchForm" id="searchForm" method="get" action="/project">
			<input type="text" name="searchWord" class="inp">
			<input type="hidden" name="division" value="${division}">
			<input type="hidden" name="viewType" value="list">
			<input type="submit" value="" style="cursor:pointer; width:20px; background-image:url('img/btn_search.gif');"/>
		</form>
		</div>
		
	</div>

	<div id="tabs">

		<script>
			$(function() {
				$( "#tabs" ).tabs({active:defaultIndex});
			});
		</script>

		<ul>
			<li><a href="#tabs-1">전체보기</a></li>
			<li><a href="#tabs-2">주거시설</a></li>
			<li><a href="#tabs-3">교육/연구시설</a></li>
			<li><a href="#tabs-4">의료/복지시설</a></li>
			<li><a href="#tabs-5">업무시설</a></li>
			<li><a href="#tabs-6">문화/집회시설</a></li>
			<li><a href="#tabs-7">군사/교정시설</a></li>
			<li><a href="#tabs-8">기타시설</a></li>
		</ul>
		
		<div id="tabs-1">
			<!-- 전체 보기 -->
			<c:if test="${resultList.size() > 0 && category=='All'}">
				<table cellpadding="0" cellspacing="0" border="0" width="100%" class="borad04">
					<tr>
						<th scope="col" width="10%">번호</th>
						<th scope="col" width="20%">이미지</th>
						<th scope="col" >사업명</th>
						<th scope="col" ></th>
					</tr>
					<c:forEach var="record" items="${resultList}">
					<tr>
						<td>${record.num}</td>
						<td class="gl_box02" style="cursor:pointer;">
							<p style="display:none">${record.num}</p>
							<img src="/resources/upload/${record.encodedFileName}">
						</td>
						<td class="txleft">${record.title}</td>
						<td></td>
					</tr>
					</c:forEach>
				</table>
			
			
				<div class="pagging_wrap02">
					<div class="pagging02">
						<ul>
							${paging}
						</ul>
					</div>
				</div>
			</c:if>
			<!-- 전체 보기 끝-->
		</div>
		<div id="tabs-2">
			
			<!-- 주거 시설 -->
			<c:if test="${resultList.size() > 0 && category=='RD'}">
				<table cellpadding="0" cellspacing="0" border="0" width="100%" class="borad04">
					<tr>
						<th scope="col" width="10%">번호</th>
						<th scope="col" width="20%">이미지</th>
						<th scope="col" >사업명</th>
						<th scope="col" ></th>
					</tr>
					<c:forEach var="record" items="${resultList}">
					<tr>
						<td>${record.num}</td>
						<td class="gl_box02" style="cursor:pointer;">
							<p style="display:none">${record.num}</p>
							<img src="/resources/upload/${record.encodedFileName}">
						</td>
						<td class="txleft">${record.title}</td>
						<td></td>
					</tr>
					</c:forEach>
				</table>
			
			
				<div class="pagging_wrap02">
					<div class="pagging02">
						<ul>
							${paging}
						</ul>
					</div>
				</div>
			</c:if>
			<!--주거 시설 끝-->
			
		</div>
		<div id="tabs-3">
			
			<!-- 교육/연구시설 -->
			<c:if test="${resultList.size() > 0 && category=='EDLA'}">
				<table cellpadding="0" cellspacing="0" border="0" width="100%" class="borad04">
					<tr>
						<th scope="col" width="10%">번호</th>
						<th scope="col" width="20%">이미지</th>
						<th scope="col" >사업명</th>
						<th scope="col" ></th>
					</tr>
					<c:forEach var="record" items="${resultList}">
					<tr>
						<td>${record.num}</td>
						<td class="gl_box02" style="cursor:pointer;">
							<p style="display:none">${record.num}</p>
							<img src="/resources/upload/${record.encodedFileName}">
						</td>
						<td class="txleft">${record.title}</td>
						<td></td>
					</tr>
					</c:forEach>
				</table>
			
			
				<div class="pagging_wrap02">
					<div class="pagging02">
						<ul>
							${paging}
						</ul>
					</div>
				</div>
			</c:if>
			<!--교육/연구시설 끝-->
			
		</div>
		<div id="tabs-4">
			
			<!-- 의료/복지시설 -->
			<c:if test="${resultList.size() > 0 && category=='MEWE'}">
				<table cellpadding="0" cellspacing="0" border="0" width="100%" class="borad04">
					<tr>
						<th scope="col" width="10%">번호</th>
						<th scope="col" width="20%">이미지</th>
						<th scope="col" >사업명</th>
						<th scope="col" ></th>
					</tr>
					<c:forEach var="record" items="${resultList}">
					<tr>
						<td>${record.num}</td>
						<td class="gl_box02" style="cursor:pointer;">
							<p style="display:none">${record.num}</p>
							<img src="/resources/upload/${record.encodedFileName}">
						</td>
						<td class="txleft">${record.title}</td>
						<td></td>
					</tr>
					</c:forEach>
				</table>
			
			
				<div class="pagging_wrap02">
					<div class="pagging02">
						<ul>
							${paging}
						</ul>
					</div>
				</div>
			</c:if>
			<!--의료/복지시설 끝-->
			
		</div>
		
		<div id="tabs-5">
			<!-- 업무시설 -->
			<c:if test="${resultList.size() > 0 && category=='OF'}">
				<table cellpadding="0" cellspacing="0" border="0" width="100%" class="borad04">
					<tr>
						<th scope="col" width="10%">번호</th>
						<th scope="col" width="20%">이미지</th>
						<th scope="col" >사업명</th>
						<th scope="col" ></th>
					</tr>
					<c:forEach var="record" items="${resultList}">
					<tr>
						<td>${record.num}</td>
						<td class="gl_box02" style="cursor:pointer;">
							<p style="display:none">${record.num}</p>
							<img src="/resources/upload/${record.encodedFileName}">
						</td>
						<td class="txleft">${record.title}</td>
						<td></td>
					</tr>
					</c:forEach>
				</table>
			
			
				<div class="pagging_wrap02">
					<div class="pagging02">
						<ul>
							${paging}
						</ul>
					</div>
				</div>
			</c:if>
			<!--업무시설 끝-->
		</div>
		<div id="tabs-6">
			<!-- 문화/집회시설 -->
			<c:if test="${resultList.size() > 0 && category=='CA'}">
				<table cellpadding="0" cellspacing="0" border="0" width="100%" class="borad04">
					<tr>
						<th scope="col" width="10%">번호</th>
						<th scope="col" width="20%">이미지</th>
						<th scope="col" >사업명</th>
						<th scope="col" ></th>
					</tr>
					<c:forEach var="record" items="${resultList}">
					<tr>
						<td>${record.num}</td>
						<td class="gl_box02" style="cursor:pointer;">
							<p style="display:none">${record.num}</p>
							<img src="/resources/upload/${record.encodedFileName}">
						</td>
						<td class="txleft">${record.title}</td>
						<td></td>
					</tr>
					</c:forEach>
				</table>
			
			
				<div class="pagging_wrap02">
					<div class="pagging02">
						<ul>
							${paging}
						</ul>
					</div>
				</div>
			</c:if>
			<!--문화/집회시설 끝-->
		</div>
		<div id="tabs-7">
			
			<!-- 군사/교정시설 -->
			<c:if test="${resultList.size() > 0 && category=='MICO'}">
				<table cellpadding="0" cellspacing="0" border="0" width="100%" class="borad04">
					<tr>
						<th scope="col" width="10%">번호</th>
						<th scope="col" width="20%">이미지</th>
						<th scope="col" >사업명</th>
						<th scope="col" ></th>
					</tr>
					<c:forEach var="record" items="${resultList}">
					<tr>
						<td>${record.num}</td>
						<td class="gl_box02" style="cursor:pointer;">
							<p style="display:none">${record.num}</p>
							<img src="/resources/upload/${record.encodedFileName}">
						</td>
						<td class="txleft">${record.title}</td>
						<td></td>
					</tr>
					</c:forEach>
				</table>
			
			
				<div class="pagging_wrap02">
					<div class="pagging02">
						<ul>
							${paging}
						</ul>
					</div>
				</div>
			</c:if>
			<!--군사및교정시설 끝-->
			
		</div>
		<div id="tabs-8">
			
			<!-- 기타시설 -->
			<c:if test="${resultList.size() > 0 && category=='ETC'}">
				<table cellpadding="0" cellspacing="0" border="0" width="100%" class="borad04">
					<tr>
						<th scope="col" width="10%">번호</th>
						<th scope="col" width="20%">이미지</th>
						<th scope="col" >사업명</th>
						<th scope="col" ></th>
					</tr>
					<c:forEach var="record" items="${resultList}">
					<tr>
						<td>${record.num}</td>
						<td class="gl_box02" style="cursor:pointer;">
							<p style="display:none">${record.num}</p>
							<img src="/resources/upload/${record.encodedFileName}">
						</td>
						<td class="txleft">${record.title}</td>
						<td></td>
					</tr>
					</c:forEach>
				</table>
			
			
				<div class="pagging_wrap02">
					<div class="pagging02">
						<ul>
							${paging}
						</ul>
					</div>
				</div>
			</c:if>
			<!--기타시설 끝-->
			
		</div>
	</div>	
</div>

	<c:forEach var="record" items="${resultList}">
	
	<div id="light${record.num}" class="white_content">
		<div class="pop_box">
			<p style="display:none;">${record.num}</p>
			<img src="img/btn_close.png" class="close"/>
			<img src="/resources/upload/${record.encodedFileName}" class="pop_pic">
		</div>
		
		<div class="pop_desc">
		<table class="borad_pop">
			<colgroup>
				<col width="20%">
				<col width="*">
			</colgroup>
			<tr>
				<th>사업명</th>		
				<td>${record.title}</td>		
			</tr>
			<tr>
				<th>위치</th>		
				<td>${record.location}</td>
			</tr>
			<tr>
				<th>대지면적</th>		
				<td>${record.lotArea}㎡</td>		
			</tr>
			<tr>
				<th>연면적</th>		
				<td>${record.totalArea}㎡</td>		
			</tr>
			<tr>
				<th>규모</th>		
				<td>${record.size}</td>
			</tr>
		</table>
	</div>
		
		
	</div>
	
	</c:forEach>
	<div id="backgroundPopup"></div>
<script>
$(document).ready(function(){

	$(".gl_box02 img").click(function() {	
		
		var num = $(this).prev("p").text();
		var top=$(window).scrollTop()+$(window).height()/2-335;
		var left=$(window).width()/2-300;
		$("#light"+num).css({"top":top+"px"});
		$("#light"+num).css({"left":left+"px"});

		$("#backgroundPopup").css({
			"opacity": "0.7"
		});
		$("#backgroundPopup").fadeIn("slow");
		$("#light"+num).show();
	});

	
	$(".close").click(function(){
		var num = $(this).prev("p").text();
		$("#backgroundPopup").fadeOut("slow");
		$("#light"+num).hide();
	});
});
</script>


<%@ include file="include/bottom.jsp" %>


</body>
</html>