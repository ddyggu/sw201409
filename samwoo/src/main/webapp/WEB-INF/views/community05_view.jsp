<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="include/head.jsp" %>
<div class="location">
	<div class="map_navi">
		Home<img src="img/arrow.png" class="ar"/>Community<img src="img/arrow.png" class="ar"/>동호회
	</div>
</div>

<div id="contents_wrap">
	<img src="img/customer_title02.jpg">
	<div class="sub06">
		<p align="right">
			<img src="img/share.gif">
			<c:if test="${record.facebook.length() > 0}">
			<a href="/redirectTo?url=http://${record.facebook}"><img src="img/facebook_ico.gif"></a>
			</c:if>
			<c:if test="${record.twitter.length() > 0}">
			<a href="/redirectTo?url=http://${record.twitter}"><img src="img/twitter_ico.gif"></a>
			</c:if>
		</p>
		<div class="group_sub">
			<strong class="f24">${record.title}</strong>
			<br/><br/>
			<c:if test="${fileList.size() > 0 }">
				<c:forEach var="file" items="${fileList}">
					<p><img src="/resources/upload/${file.encodedFileName}"/></p>
				</c:forEach>
			</c:if>
		</div>
		<div class="mt57">
			${record.contents}
		</div>

	</div>
</div>

<%@ include file="include/bottom.jsp" %>

</body>
</html>