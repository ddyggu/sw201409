<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="include/head.jsp" %>
<div class="location">
	<div class="map_navi">
		Home<img src="img/arrow.png" class="ar"/>Projects
	</div>
</div>

<div id="contents_wrap">
	<img src="img/project_title01.jpg">
	<div class="sub06">
		<div class="gallery_area">
			<!--  
			<div class="sort_area">
				<ul class="sort">
					<li><a href="/project?num=1">감리</a></li>
					<li><a href="/project?num=2">설계</a></li>
					<li><a href="/project?num=3">미디어 사업</a></li>
					<li><a href="/project?num=4">기술연구소</a></li>
					<li>
						<a href="#"><img src="img/sort_01.gif"></a>
						<a href="#"><img src="img/sort_02.gif"></a>
					</li>
				</ul>
			</div>
			<div class="search_area">
				<input type="text" name="" class="inp">
				<a href="#"><img src="img/btn_search.gif"></a>
			</div>
			-->
		</div>

		<div class="gallery_pop">	
			<ul>
				<c:forEach var="record" items="${resultList}" end="2">
					<li>
						<div class="gl_box02">
							<img src="/resources/upload/${record.encodedFileName}">
							<p class="gl_txt03"><a href="#">${record.title}</a></p>
						</div>
					</li>	
				</c:forEach>
			</ul>
			<c:if test="${resultList.size() > 3}">
			<ul>
				<c:forEach var="record" items="${resultList}" begin="3" end="5">
					<li>
						<div class="gl_box02">
							<img src="/resources/upload/${record.encodedFileName}">
							<p class="gl_txt03"><a href="#">${record.title}</a></p>
						</div>
					</li>	
				</c:forEach>
			</ul>
			</c:if>
			<c:if test="${resultList.size() >  6}">
			<ul>
				<c:forEach var="record" items="${resultList}" begin="6" end="8">
					<li>
						<div class="gl_box02">
							<img src="/resources/upload/${record.encodedFileName}">
							<p class="gl_txt03"><a href="#">${record.title}</a></p>
						</div>
					</li>	
				</c:forEach>
			</ul>
			</c:if>
		</div>
	</div>
	<div class="pagging_wrap02">
		<div class="pagging02">
			<ul>
				${paging}
			</ul>
		</div>
	</div>
	
</div>

	<div id="light" class="white_content">
		<div class="pop_box">
			<img id="btn_close" src="img/btn_close.png" class="close"/>
			<img src="img/sample05.jpg" class="pop_pic">
		</div>
	</div>
	<div id="backgroundPopup"></div>
<script>
$(document).ready(function(){

	$(".gl_box02 img").click(function (){
		var top=$(window).scrollTop()+$(window).height()/2-200;
		var left=$(window).width()/2-300;
		$("#light").css({"top":top+"px"});
		$("#light").css({"left":left+"px"});

		$("#backgroundPopup").css({
			"opacity": "0.7"
		});
		$("#backgroundPopup").fadeIn("slow");
		$("#light").show();
	});

	$("#btn_close").click(function(){
		$("#backgroundPopup").fadeOut("slow");
		$("#light").hide();
	});
});
</script>


<%@ include file="include/bottom.jsp" %>


</body>
</html>