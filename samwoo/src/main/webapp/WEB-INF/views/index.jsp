<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="include/main_head.jsp" %>
<script>
function getCookie( cookieName ) {
	 var search = cookieName + "=";
	 var cookie = document.cookie;
	 if( cookie.length > 0 ) {
	  startIndex = cookie.indexOf( cookieName );
	 if( startIndex != -1 ) {
	  startIndex += cookieName.length;
	  endIndex = cookie.indexOf( ";", startIndex );
	
		 if( endIndex == -1) endIndex = cookie.length;
			return unescape( cookie.substring( startIndex + 1, endIndex ) );
	  } else {
		 return false;
	 }
	 
	 } else {
	 	return false;
	 }
}
</script>


<c:if test="${popupList.size() > 0}">
	<% int i = 1; %>
	<c:forEach var="popup" items="${popupList}">
		<script>
		
		var startDate<%=i%> = new Date("${popup.startDate}");
		var endDate<%=i%> = new Date("${popup.endDate}");
		var now<%=i%> = new Date();
		
		var num<%=i%> = ${popup.num};
		var width<%=i%> = ${popup.width};
		var height<%=i%> = ${popup.height};
		var top<%=i%> = ${popup.positionTop};
		var left<%=i%> = ${popup.positionLeft}
		
		
		if(now<%=i%> <= endDate<%=i%> && now<%=i%> >= startDate<%=i%>) {
			if(!getCookie("popup${popup.num}")) {
			window.open("/popup?num="+num<%=i%>,"","scrollbars=no,toolbar=no,menubar=no,location=no,status=no,resizable=no"+
						",width="+width<%=i%>+",height="+height<%=i%>+",top="+top<%=i%>+",left="+left<%=i%>);
			}
		}
		
		</script>
	<% i++; %>
	</c:forEach>
</c:if>


<div class="main_contents">
	<div class="main_pic">
		<a href="/about07" rel="ov"><img src="img/main_banner01.gif" class="p01"></a>
		<a href="/project" rel="ov"><img src="img/main_banner02.gif" class="p02"></a>
		<a href="/about02" rel="ov"><img src="img/main_banner03.gif" class="p03"></a>
		<a href="/about08" rel="ov"><img src="img/main_banner04.gif" class="p04"></a>
		<a href="http://swp.samwoospace.co.kr/" target="_blank" rel="ov"><img src="img/main_banner05.gif" class="p05"></a>
		<a href="/career01" rel="ov"><img src="img/main_banner06.gif" class="p06"></a>
		<a href="/community05" rel="ov"><img src="img/main_banner07.gif" class="p07"></a>
		<div class="p08">
			<div class="mainbox">
				<a href="#">

					<div id="object01" class="slidorion">
						<div class="slider">
							<div class="slide"><img src="img/0101.jpg" /></div>
							<div class="slide"><img src="img/0102.jpg" /></div>
						</div>

						<div class="accordion">
							<div class="header"></div>
							<div class="content"></div>
							<div class="header"></div>
							<div class="content"></div>
						</div>
					</div>

				</a>
				<div class="main_txt" id="txt_num01">
					<a href="#">울산과학기술대학교 기숙사</a>
				</div>
			</div>
		</div>
		<div class="p09">
			<div class="mainbox">
				<a href="#">
					
					<div id="object02" class="slidorion">
						<div class="slider">
							<div class="slide"><img src="img/0201.jpg" /></div>
							<div class="slide"><img src="img/0202.jpg" /></div>
						</div>

						<div class="accordion">
							<div class="header"></div>
							<div class="content"></div>
							<div class="header"></div>
							<div class="content"></div>
						</div>
					</div>

				</a>
				<div class="main_txt" id="txt_num02">
					<a href="#">울산과학기술대학교 기숙사</a>
				</div>
			</div>
		</div>
		<div class="p10">
			<div class="mainbox">
				<a href="#">
					
					<div id="object03" class="slidorion">
						<div class="slider">
							<div class="slide"><img src="img/0301.jpg" /></div>
							<div class="slide"><img src="img/0302.jpg" /></div>
						</div>
						<div class="accordion">
							<div class="header"></div>
							<div class="content"></div>
							<div class="header"></div>
							<div class="content"></div>
						</div>
					</div>
				</a>
				<div class="main_txt" id="txt_num03">
					<a href="#">울산과학기술대학교 기숙사</a>
				</div>		
			</div>
		</div>
		<div class="p11">
			<div class="mainbox">
				<a href="#">
					
					<div id="object04" class="slidorion">
						<div class="slider">
							<div class="slide"><img src="img/0401.jpg" /></div>
							<div class="slide"><img src="img/0402.jpg" /></div>
						</div>

						<div class="accordion">
							<div class="header"></div>
							<div class="content"></div>
							<div class="header"></div>
							<div class="content"></div>
						</div>
					</div>

				</a>
				<div class="main_txt" id="txt_num04">
					<a href="#">울산과학기술대학교 기숙사</a>
				</div>
			</div>
		</div>
		<img src="img/main_txt.png" class="p12">	
		</div>
		
		
	</div>
</div>
<script>

// $(function() {
// 	var mainbox = $('.mainbox');

// 	mainbox.mouseover(function(e){
// 		e.preventDefault();
// 		var tg = $(this);
// 		tg.find('.main_txt').stop().animate({'opacity':'1'},200);
// 	});

// 	mainbox.mouseout(function(e){
// 		e.preventDefault();
// 		var tg = $(this);
// 		tg.find('.main_txt').stop().animate({'opacity':'0'},200);
// 	});
// });
</script>



<script src="/js/jquery.easing.js"></script>
<script src="/js/jquery.slidorion.min.js"></script>

<script>
$(function() {
	$('#object01').slidorion({
		interval: 2000,
		speed: 500,
		effect: 'overRandom'
	});

	$('#object02').slidorion({
		interval: 3000,
		speed: 500,
		effect: 'overRandom'
	});

	$('#object03').slidorion({
		interval: 2000,
		speed: 500,
		effect: 'overRandom'
	});

	$('#object04').slidorion({
		interval: 5000,
		speed: 500,
		effect: 'overRandom'
	});
});
</script>

<%@ include file="include/bottom.jsp" %>

</body>
</html>