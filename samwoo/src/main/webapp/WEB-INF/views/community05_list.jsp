<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="include/head.jsp" %>

<div class="location">
	<div class="map_navi">
		Home<img src="img/arrow.png" class="ar"/>Community<img src="img/arrow.png" class="ar"/>동호회<img src="img/arrow.png" class="ar"/>삼우산악회
	</div>
</div>

<div id="contents_wrap">

	<div class="container group clearfix">
		<div class="ctn_aside">
			<!-- <img src="img/customer_title02.jpg"> -->
			
			<div class="group_summary">
				<h3 class="title">${ClubInfo.clubname}</h3>
				<dl class="clearfix">
					<dt>대상 : </dt><dd>${ClubInfo.targetGroup}</dd>
					<dt>활동 : </dt><dd>${ClubInfo.activityGroup}</dd>
					<dt>회장 : </dt><dd>${ClubInfo.president}</dd>
				</dl>
			</div>

			<a href="/redirectTo?url=http://${ClubInfo.facebook}" class="btn_group">동호회 홈페이지</a>
		</div>

		<div class="ctn_contents">
			<div class="contents">

				<div class="thumbnail_list">
					<ul class="clearfix">
						<c:set value="1" var="index"/>
						<c:forEach var="record" items="${ClubList}">
						<c:choose>
							<c:when test="${index == '1' || index == '4' || index == '7'}">
							<li class="margin_left_0">
							</c:when>
							<c:otherwise>
							<li>
							</c:otherwise>
						</c:choose>
								<a href="/community05_view?num=${record.num}">
									<c:choose>
										<c:when test="${record.encodedFileName != null}"><img src="/resources/upload/${record.encodedFileName}" class="spic"/></c:when>
										<c:when test="${record.encodedFileName == null}">없음</c:when>
									</c:choose>
									<div class="thumb_title">
										<div class="bg"></div>
										<p class="tit">${record.title}</p>
									</div>
								</a>
							</li>
						<c:set value="${index+1}" var="index"/>
						</c:forEach>
					</ul>
					
					<div class="pagging_wrap">
						<div class="pagging">
							<ul>
							${paging}
							</ul>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>



</div>

<%@ include file="include/bottom.jsp" %>

</body>
</html>