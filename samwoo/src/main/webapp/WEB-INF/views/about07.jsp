<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="include/head.jsp" %>
<div class="location">
	<div class="map_navi">
		Home<img src="img/arrow.png" class="ar"/>About us<img src="img/arrow.png" class="ar" />
	<c:if test="${menu=='A'}">
	특허
	</c:if>
	<c:if test="${menu=='B'}">
	신기술
	</c:if>
	</div>
</div>

<div id="contents_wrap">

	<c:if test="${menu=='A'}">
	<h1><img src="img/title01_6.jpg" alt="특허"></h1>
	</c:if>
	<c:if test="${menu=='B'}">
	<h1><img src="img/title01_7.jpg" alt="신기술"></h1>
	</c:if>
	
	
	<div class="sub05">
		<ul>
			<c:forEach var="record" items="${techList}" end="2">
				<li>	
					<div class="gl_box01" style="cursor:pointer">
					<p style="display:none">${record.num}</p>
					<img src="/resources/upload/${record.encodedFileName}" alt="${record.fileName}"/>
					</div>	
					<p class="gl_txt">${record.title}</p>
				</li>
			</c:forEach>
		</ul>
		<c:if test="${techList.size() > 3}" >
		<ul>
			<c:forEach var="record" items="${techList}" begin="3" end="5">
				<li>	
					<div class="gl_box01" style="cursor:pointer">
					<p style="display:none">${record.num}</p>
					<img src="/resources/upload/${record.encodedFileName}" alt="${record.fileName}"/>
					</div>
					<p class="gl_txt">${record.title}</p>
				</li>
			</c:forEach>
		</ul>
		</c:if>
		<c:if test="${techList.size() >  6}">
		<ul>
			<c:forEach var="record" items="${techList}" begin="6" end="8">
				<li>	
					<div class="gl_box01" style="cursor:pointer">
					<p style="display:none">${record.num}</p>
					<img src="/resources/upload/${record.encodedFileName}" alt="${record.fileName}"/>
					</div>
					<p class="gl_txt">${record.title}</p>
				</li>
			</c:forEach>
		</ul>
		</c:if>
	</div>
	<div class="pagging_wrap02">
		<div class="pagging">
			<ul>
				${paging}
			</ul>
		</div>
	</div>
	
		<c:forEach var="record" items="${techList}">
	
		<div id="light${record.num}" class="white_content" style="width:1100px; height:1500px;">
			<div class="pop_box" style="width:1100px; height:1500px;">
				<p style="display:none;">${record.num}</p>
				<img src="img/btn_close.png" class="close" style="right:0px;"/>
				<img src="/resources/upload/${record.encodedFileName}" class="pop_pic" style="width:1100px; height:1500px;">
			</div>
		</div>
	
		</c:forEach>
	<div id="backgroundPopup"></div>
<script>
$(document).ready(function(){

	$(".gl_box01 img").click(function() {	
		
		var num = $(this).prev("p").text();
		var top=$(window).scrollTop()+$(window).height()/2-135;
		var left=50;
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
	
	
	
	
	
</div>

<%@ include file="include/bottom.jsp" %>

</body>
</html>