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
		
		<div class="group_area">
			<dl>
				<dt><img src="img/group_pic_top.jpg" alt="Social Club 삼우공간 건축사무소의 유쾌한 모임"></dt>
				<dd>
					<ul class="clearfix">
					
						<% int num = 1; %>
						<c:forEach var="record" items="${InfoList}" begin="0" end="2">
							<li class="club_background">
								<c:choose>
									<c:when test="${record.encodedFileName != null}"><img src="/resources/upload/${record.encodedFileName}" class="spic" style="width:390px; height:390px;"/></c:when>
									<c:when test="${record.encodedFileName == null}">없음</c:when>
								</c:choose>
								<div class="bg_pattern"></div>
								<div class="group_desc">
									<div class="txt_title">
										<a href="/community05_list?num=${record.num}"><strong class="f18">${record.clubname}</strong></a>
										<div class="txt_ct"><a href="/community05_list?num=${record.num}">${record.description}</a></div>
									</div>
								</div>
							</li>
							<% num++; %>
						</c:forEach>
						<li class="club_background"><div class="bg_pattern"></div></li>
					</ul>
				</dd>
			</dl>
		</div>


	</div>
</div>

<%@ include file="include/bottom.jsp" %>

</body>
</html>