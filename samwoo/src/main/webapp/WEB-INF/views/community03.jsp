<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="include/head.jsp" %>
<div class="location">
	<div class="map_navi">
		Home<img src="img/arrow.png" class="ar"/>Community<img src="img/arrow.png" class="ar"/>FAQ
	</div>
</div>

<div id="contents_wrap">
	<img src="img/faq_title.gif">
	<div class="sub06">
		<div class="faq">
			<ul class="faqBody">
				<c:forEach var="record" items="${faqRecord}">
				<li class="article" id="a1">
					<div class="q">
						<a href="#a1">${record.question}</a>
					</div>
					<div class="a">
						<div class="aq">${record.question}</div>
						<div class="aa">${record.answer}</div>
					</div>
				</li>
				</c:forEach>
			</ul>
		</div>
<script> 
	$( "div.qust" ).mouseover(function() {
		mouseover_alt($(this).attr('id'));
	});
</script>


	</div>
</div>
<%@ include file="include/bottom.jsp" %>
</body>
</html>