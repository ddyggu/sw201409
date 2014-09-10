<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="include/head.jsp" %>
<div class="location">
	<div class="map_navi">
		Home<img src="img/arrow.png" class="ar"/>About us<img src="img/arrow.png" class="ar" />특허 / 신기술
	</div>
</div>

<div id="contents_wrap">
	<img src="img/title01_7.jpg">
	<div class="sub05">
		<ul>
			<c:forEach var="record" items="${techList}" end="2">
				<li>	
					<div class="gl_box01">
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
					<div class="gl_box01">
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
					<div class="gl_box01">
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
</div>

<%@ include file="include/bottom.jsp" %>

</body>
</html>