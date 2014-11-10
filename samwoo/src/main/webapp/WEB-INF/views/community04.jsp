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
	
	
	var agree = document.getElementById("agree").checked;
	
	if(agree == false) {
		alert("개인정보제공에 동의하여 주십시오");
		return false;
	}
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
			“삼우공간 건축사사무소”(이하 ‘회사’)는 고객님의 개인정보를 중요시하며, “정보통신망 이용촉진 및 정보보호에 관한 법률”을 준수하고 있습니다.<br/>
			또한 개인정보취급방침을 제정하여 이를 준수하고 있으며, 본 취급방침을 홈페이지에 공개하여 고객께서 언제나 쉽게 열람하실 수 있도록 하고 있습니다.<br/>
			회사는 개인정보취급방침을 통하여 고객님께서 제공하시는 개인정보가 어떠한 용도와 방식으로 이용되고 있으며, 개인정보보호를 위해 어떠한 조치가 취해지고 있는지 알려드립니다.<br/>
			회사는 개인정보취급방침을 개정하는 경우 웹사이트 공지사항(또는 개별공지)을 통화여 공지할 것입니다.<br/>
			수집하는 개인정보 항목<br/>
			회사는 고객상담을 위하여 인터넷 홈페이지, 전화, Fax 등을 통해 아래와 같은 개인정보를 수집하고 있습니다.<br/>
			- 성명, 주소, 휴대전화번호, 이메일<br/>
			개인정보 수집 및 이용목적<br/>
			회사는 수집한 개인정보를 다음의 목적을 위해 활용합니다.<br/>
			- 서비스 제공관련 안내<br/>
			- 불만처리/민원처리<br/>
			<br/>
			개인정보의 보유 및 이용기간<br/>
			<br/>
			원칙적으로 개인정보 수집 및 이용목적이 달성된 후에는 해당 정보를 지체 없이 파기합니다.<br/>
			단, 관계법령의 규정에 의하여 보존할 필요가 있는 경우 회사는 아래와 같이 관계법령에서 정한 일정한 기간 동안 회원정보를 보관합니다.<br/>
			보존 항목: 성명, 주소, 휴대전화번호, 이메일<br/>
			보존 근거: 소비자의 불만 또는 분쟁처리<br/>
			보존 기간: 3년<br/>
			소비자의 불만 또는 분쟁처리에 관한 기록 : 3년 ((전자상거래 등에서의 소비자보호에 관한 법률)<br/>
			개인정보의 파기절차 및 방법 회사는 원칙적으로 개인정보 수집 및 이용목적이 달성된 후에는 해당 정보를 지체없이 파기합니다.<br/> 
			파기절차 및 방법은 다음과 같습니다. <br/>
			- 전자적 파일형태로 저장된 개인정보는 기록을 재생할 수 없는 기술적 방법을 사용하여 삭제합니다.<br/> 
			- 종이에 출력된 개인정보는 분쇄기로 소각을 통하여 파기합니다. 개인정보 제공 회사는 이용자의 개인정보를 원칙적으로 외부에 제공하지 않습니다. 다만, 아래의 경우에는 예외로 합니다.<br/> 
			- 이용자들이 사전에 동의한 경우<br/> 
			- 법령의 규정에 의거하거나, 수사 목적으로 법령에 정해진 절차와 방법에 따라 수사기관의 요구가 있는 경우 또한, 고객님의 동의없이 고객님의 정보를 외부 업체에 위탁하지 않으며,<br/> 
			쿠키 등 인터넷 서비스 이용 시 자동 생성되는 개인정보를 수집하는 장치를 운영하지 않습니다. 개인정보에 관한 민원서비스 회사는 고객의 개인정보를 보호하고 개인정보와 관련한 불만을<br/> 
			처리하기 위하여 아래와 같이 관련 부서 및 개인정보관리 책임자를 지정하고 있습니다.<br/> 
            <br/>                                                  
		</div>
		<p align="center"><input type="checkbox" name="agree" id="agree"> <span class="f13">개인정보제공에 동의합니다.</a></p>
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