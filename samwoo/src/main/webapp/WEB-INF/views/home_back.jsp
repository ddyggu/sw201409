<%@ include file="include/main_head.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="main_contents">
	<div class="main_pic">
		<a href="/about07" rel="ov"><img src="img/main_banner01.gif" class="p01"></a>
		<a href="/project" rel="ov"><img src="img/main_banner02.gif" class="p02"></a>
		<a href="/about02" rel="ov"><img src="img/main_banner03.gif" class="p03"></a>
		<a href="/about08" rel="ov"><img src="img/main_banner04.gif" class="p04"></a>
		<a href="/about05" rel="ov"><img src="img/main_banner05.gif" class="p05"></a>
		<a href="/service01" rel="ov"><img src="img/main_banner06.gif" class="p06"></a>
		<a href="/community05" rel="ov"><img src="img/main_banner07.gif" class="p07"></a>
		<div class="p08">
			<div class="mainbox">
				<a href="#"><img src="img/main_banner08.gif" onmouseover="txt_show('01')" onmouseout="txt_hide('01')"></a>
				<div class="main_txt" id="txt_num01" onmouseover="txt_show('01')" onmouseout="txt_hide('01')">
					<a href="#">울산과학기술대학교 기숙사</a>
				</div>
			</div>
		</div>
		<div class="p09">
			<div class="mainbox">
				<a href="#"><img src="img/main_banner09.gif" onmouseover="txt_show('02')" onmouseout="txt_hide('02')"></a>
				<div class="main_txt" id="txt_num02" onmouseover="txt_show('02')" onmouseout="txt_hide('02')">
					<a href="#">울산과학기술대학교 기숙사</a>
				</div>
			</div>
		</div>
		<div class="p10">
			<div class="mainbox">
				<a href="#"><img src="img/main_banner10.gif" onmouseover="txt_show('03')" onmouseout="txt_hide('03')"></a>
				<div class="main_txt" id="txt_num03" onmouseover="txt_show('03')" onmouseout="txt_hide('03')">
					<a href="#">울산과학기술대학교 기숙사</a>
				</div>
			</div>
		</div>
		<div class="p11">
			<div class="mainbox">
				<a href="#"><img src="img/main_banner11.gif" onmouseover="txt_show('04')" onmouseout="txt_hide('04')"></a>
				<div class="main_txt" id="txt_num04" onmouseover="txt_show('04')" onmouseout="txt_hide('04')">
					<a href="#">울산과학기술대학교 기숙사</a>
				</div>
			</div>
		</div>
		<img src="img/main_txt.png" class="p12">
	</div>
</div>
<script>
function txt_show(uid){
	$("#txt_num"+uid).show();
}
function txt_hide(uid){
	$("#txt_num"+uid).hide();
}
</script>

<%@ include file="include/bottom.jsp" %>

</body>
</html>