<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="include/head.jsp" %>
<script>
function formSubmit() {
	
	var name = document.getElementById("name").value;
	
	var tel2 = document.getElementById("tel2").value;
	var tel3 = document.getElementById("tel3").value;
	
	var email1 = document.getElementById("email1").value;
	var email2 = document.getElementById("email2").value;
	var title = document.getElementById("title").value;
	var contents = document.getElementById("contents").value;
	
	if(name=="") {
		alert("성명을 입력하여 주십시오");
		return false;
	} else if(tel2=="" || tel3 == "") {
		alert("연락처를 입력하여 주십시오");
		return false;	
	} else if(email1 == "" || email2 == "") {
		alert("이메일을 입력하여 주십시오");
		return false;
	} else if(title == "") {
		alert("제목을 입력하여 주십시오");
		return false;
	} else if(contents == "") {
		alert("내용을 입력하여 주십시오");
		return false;
	}
	
}

</script>

<div class="location">
	<div class="map_navi">
		Home<img src="img/arrow.png" class="ar"/>Community<img src="img/arrow.png" class="ar"/>고객문의
	</div>
</div>

<div id="contents_wrap">
	<img src="img/customer_title.jpg">
	<div class="sub06">
		<strong >개인정보 수집 및 이용에 대한 안내</strong>
		<div class="perm">
			개인정보 수집내용이 들어갑니다. 
		</div>
		<p align="center"><input type="checkbox" name=""> <span class="f13">개인정보제공에 동의합니다.</a></p>
		<p align="right"><img src="img/star01.gif" class="mt45"></p>
		<form name="consultForm" id="consultForm" method="post" action="/admin/questionWrite" enctype="multipart/form-data" onsubmit="return formSubmit(this);">
		<table class="borad03">
			<colgroup>
				<col width="17%">
				<col width="*">
			</colgroup>
			<tr>
				<th class="star">고객(업체)명</th>
				<td><input type="text" name="company" id="company" class="inp02"></td>
			</tr>
			<tr>
				<th class="star">성명</th>
				<td><input type="text" name="name" id="name" class="inp02"></td>
			</tr>
			<tr>
				<th class="star">연락처</th>
				<td>
					<select name="tel1" class="inp01">
						<option value="010">010</option>
						<option value="011">011</option>
						<option value="016">016</option>
						<option value="017">017</option>
						<option value="018">018</option>
						<option value="019">019</option>
					</select> - 
					<input type="text" name="tel2" id="tel2" class="inp03"> - <input type="text" name="tel3" id="tel3" class="inp03">
				</td>
			</tr>
			<tr>
				<th class="star">이메일</th>
				<td>
					<input type="text" name="email1" id="email1" class="inp04"> @ <input type="text" name="email2" id="email2" class="inp04">
					<select name="email2" class="inp01" onchange="setValue(this);">
						<option value="">직접선택</option>
						<option value="naver.com">네이버</option>
						<option value="hanmail.net">다음</option>
						<option value="nate.com">네이트</option>
						<option value="google.com">구글</option>
					</select>
				</td>
			</tr>
			<tr>
				<th class="star">제목</th>
				<td><input type="text" name="title" id="title" class="inp05"></td>
			</tr>
			<tr>
				<th class="star01">내용</th>
				<td><textarea type="text" name="contents" id="contents" class="inp06"></textarea></td>
			</tr>
			<tr>
				<th>첨부파일</th>
				<td>
					<input type="file" name="multiPart1" class="inp02">
					<div class="file_txt">
					* 파일용량은 10MB이하로만 가능<br>
					* 파일명은 영문만 가능 (한글, 특수기호 불가)
					</div>
				</td>
			</tr>
		</table>
		<div class="btn_wrap">
			<input type="submit"  style="background-image:url('/img/btn_confirm.gif'); width:100px; height:45px; cursor:pointer;" value=""/>  
			<a href="#"><img src="img/btn_cancle.gif"></a>
		</div>
		
		
		<table class="borad02" style="margin-top:100px;">
			<colgroup>
				<col width="*">
				<col width="30%">
				<col width="30%">
				<col width="30%">
			</colgroup>
			<c:forEach var="record"  items="${consultRecord}" >
				<tr>
				<td valign="top" style="text-align:left;">
					<a href="/community04_view?num=${record.num}"><strong class="c05">${record.title}</strong></a>
					<div class="memo"></div>
				</td>
				
				<td valign="top"><span class="c04">${record.name}</span></td>
				<td valign="top"><span class="c04">${record.date}</span></td>
				<td valign="top">
					<c:choose>
						<c:when test="${record.a_answer !=null }">답변완료</c:when>
						<c:when test="${record.a_answer==null }">대기중</c:when>
					</c:choose>	
				</td>
			</tr>
			</c:forEach>
		</table>
		
		
		
		
		</form>
	</div>

	
</div>


<%@ include file="include/bottom.jsp" %>

</body>
<c:if test="${respon != null}">
	<script>
	    var status = "${respon.status}", message = "${respon.message}";
		if (status == false) { 
			status="오류"; 
			alert(status +  " : " + message);
		} else {
			alert(message);
		}
</script>
</c:if>
</html>