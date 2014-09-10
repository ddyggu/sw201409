<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd" />
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="ko" lang="ko" />
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>SAMWOO ADMIN</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<link rel="stylesheet" type="text/css" href="/admin/css/style.css"/>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" media="all" />
<script type="text/javascript" src="/admin/js/jquery-1.7.min.js"></script>
<script type="text/javascript" src="/admin/js/script.js"></script>
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js" type="text/javascript"></script>
<script type="text/javascript" src="js/ajaxRequest.js"></script>
<script type="text/javascript" src="/se_editor/js/HuskyEZCreator.js"></script>
<c:if test="${recruitRecord.division != null}">
<script>
window.onload = function() {
	var division = "${recruitRecord.division}", career = "${recruitRecord.career}", mainExpose = "${recruitRecord.mainExpose}";

	document.getElementById("division").value = division;
	document.getElementById("career").value = career;
	if(mainExpose == "N") {
		document.getElementById("No").checked = true;
	} else {
		document.getElementById("Yes").checked = true;
	}
}

</script>
</c:if>
<script>
var oEditors = [];
createEditor1 = function(holder, id) {
	if(holder.length == 0 || !holder.getById[id]) {
		nhn.husky.EZCreator.createInIFrame({
			oAppRef: holder,
			elPlaceHolder: id,
			sSkinURI: "/se_editor/SmartEditor2Skin.html",	
			htParams : {
				bUseToolbar : true,					// 툴바 사용 여부 (true:사용/ false:사용하지 않음)
				bUseVerticalResizer : true,			// 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
				bUseModeChanger : true,			// 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
				//aAdditionalFontList : aAdditionalFontSet,		// 추가 글꼴 목록
				fOnBeforeUnload : function(){
					//alert("완료!");
				}
			}, //boolean
			fOnAppLoad : function(){
				//예제 코드
				//oEditors.getById["notice_content"].exec("PASTE_HTML", ["로딩이 완료된 후에 본문에 삽입되는 text입니다."]);
			},
			fCreator: "createSEditor2"
		});
	}
}



$(function() {
	$("#startDate, #endDate").datepicker({
		dateFormat: 'yy-mm-dd',
		prevText: '이전 달',
		nextText: '다음 달',
		monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
		monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
		dayNames: ['일','월','화','수','목','금','토'],
		dayNamesShort: ['일','월','화','수','목','금','토'],
		dayNamesMin: ['일','월','화','수','목','금','토'],
		showMonthAfterYear: true,
		yearSuffix: '년'
	});
	
	createEditor1(oEditors, "contents");
});


function pasteHTML() {
	var sHTML = "<span style='color:#FF0000;'>이미지도 같은 방식으로 삽입합니다.<\/span>";
	oEditors.getById["contents"].exec("PASTE_HTML", [sHTML]);
}

function showHTML() {
	var sHTML = oEditors.getById["contents"].getIR();
	alert(sHTML);
}
	
function submitContents(elClickedObj) {
	oEditors.getById["contents"].exec("UPDATE_CONTENTS_FIELD", []);	// 에디터의 내용이 textarea에 적용됩니다.
	
	if(document.getElementById("title").value=="") {
		alert("제목을 입력하여 주십시오");
		return false;
	}
	if(document.getElementById("contents").value=="") {
		alert("내용을 입력하여 주십시오");
		return false;
	}
	try {
		elClickedObj.form.submit();
	} catch(e) {}
}

function setDefaultFont() {
	var sDefaultFont = '궁서';
	var nFontSize = 24;
	oEditors.getById["contents"].setDefaultFont(sDefaultFont, nFontSize);
}
</script>
</head>
<body>

<div id="wrap">

		<%@ include file="include/admin_head.jsp" %>
		
		<div class="title_area">
				<img src="/admin/img/title04.gif"/>
			</div>
		
		<form name="recForm" id="recForm" action="/admin/recruitWrite" method="post" enctype="Multipart/form-data" onsubmit="javascript:submitContents(this);">
		<table class="aborad01_write">
			<colgroup>
				<col width="17%"/>
				<col width="*"/>
			</colgroup>
			<tr>
				<th>모집부분</th>
				<td>
					<select name="division" id="division" class="ainp05">
						<option value="감리" selected>감리</option>
						<option value="설계">설계</option>
						<option value="미디어 사업">미디어 사업</option>
					</select>
				</td>
			</tr>
			<tr>
				<th>경력</th>
				<td>
					<select name="career" id="career" class="ainp05">
						<option value="신입">신입</option>
						<option value="신입/경력" selected>신입/경력</option>
						<option value="경력">경력</option>
					</select>
				</td>
			</tr>
			<tr>
				<th>모집기간</th>
				<td><input type="text" id="startDate" name="startDate" class="ainp04" value="${recruitRecord.startDate}"/> - <input type="text" id="endDate" name="endDate" class="ainp04" value="${recruitRecord.endDate}"/></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" name="title" class="ainp01" value="${recruitRecord.title}"/></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea name="contents" id="contents" class="ainp02">${recruitRecord.contents}</textarea></td>
			</tr>
			<tr>
				<th>이미지</th>
				<td>
					<input type="file" name="multiPart1" class="ainp06"/>
					<div class="file_txt">
					<c:if test="${recruit_fileList != null}">
						<c:forEach var="file"  items="${recruit_fileList}">
								<p id="fileItem${file.num}">	
									<span style="font-weight:bold; color:red;">* 현재 첨부된 파일은 <b>${file.fileName}</b>입니다.</span>
									<span style="display:inline-block; margin-left:20px; color:black; font-weight:bold;"><a href="javascript:deleteFile(${file.num},'recruit')">x</a></span>
								</p>
						</c:forEach>
					</c:if>
					첨부파일은 10MB이하 jpg, gif, png만 첨부 가능합니다.<br/>
					이미지 사이즈는 680*400(가로*세로)이 최적화입니다.
					</div>
				</td>
			</tr>
			<tr>
				<th>메인이미지 등록</th>
				<td>
					<input type="radio" name="mainExpose" id="Yes" value="Y" checked/> 등록&nbsp; 
					<input type="radio" name="mainExpose" id="No" value="N" /> 미등록
				</td>
			</tr>
			<c:if test="${sqlType != null}">
				<input type="hidden" name="num" value="${num}"/>
				<input type="hidden" name="sqlType" value="${sqlType}"/>
			</c:if>
		</table>
			

			<div class="btn_wrap">
				<input type="submit"  style="background-image:url('/admin/img/btn_confirm.gif'); width:100px; height:45px; cursor:pointer;" value=""/>  
				<a href="/admin/recruit"><img src="/admin/img/btn_cancle.gif" /></a>
			</div>

		</div>
		</form>
	</div>

	<div id="footwrap">

	</div>

</div>

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