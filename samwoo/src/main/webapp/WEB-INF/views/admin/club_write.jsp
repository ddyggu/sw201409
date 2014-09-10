<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd" />
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="ko" lang="ko" />
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>SAMWOO ADMIN</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<link rel="stylesheet" type="text/css" href="/admin/css/style.css"/>
<script type="text/javascript" src="/admin/js/jquery-1.7.min.js"></script>
<script type="text/javascript" src="/admin/js/script.js"></script>
<script type="text/javascript" src="/se_editor/js/HuskyEZCreator.js"></script>
<script type="text/javascript" src="/admin/js/ajaxRequest.js"></script>
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
			<img src="/admin/img/title07.gif"/>
		</div>
		<form name="clubForm" id="clubForm" action="/admin/clubWrite" method="post" enctype="multipart/form-data" onsubmit="return submitContents(this);">
		<table class="aborad01_write">
			<colgroup>
				<col width="17%">
				<col width="*">
			</colgroup>
			<tr>
				<th>이름</th>
				<td><input type="text" name="clubname" class="ainp01" value="${clubRecord.clubname}"/></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea type="text" name="contents" id="contents" class="ainp02">
				${clubRecord.contents}</textarea></td>
			</tr>
			<tr>
				<th>대표이미지</th>
				<td>
					<input type="file" name="multiPart1" class="ainp06"/>
					<div class="file_txt">
					<c:forEach var="file"  items="${club_fileList}">
							<p id="fileItem${file.num}">	
								<span style="font-weight:bold; color:red;">* 현재 첨부된 파일은 <b>${file.fileName}</b>입니다.</span>
								<span style="display:inline-block; margin-left:20px; color:black; font-weight:bold;"><a href="javascript:deleteFile(${file.num},'club')">x</a></span>
							</p>
					</c:forEach>
					첨부파일은 10MB이하 jpg, gif, png만 첨부 가능합니다.<br>
					이미지 사이즈는 270*400(가로*세로)이 최적화입니다.
					</div>
				</td>
			</tr>
			<tr>
				<th>SNS 링크</th>
				<td>
					<input type="text" name="facebook" class="ainp01" onfocus="this.value==this.defaultValue?this.value='':void(0);" onblur="this.value==''?this.value=this.defaultValue:void(0);" value='${clubRecord.facebook }' />
					<p class="mt5"><input type="text" name="twitter" class="ainp01" onfocus="this.value==this.defaultValue?this.value='':void(0);" onblur="this.value==''?this.value=this.defaultValue:void(0);" value=''${clubRecord.twitter}/></p>
				</td>
			</tr>
			<c:if test="${sqlType != null}">
					<input type="hidden" name="num" value="${num}"/>
					<input type="hidden" name="sqlType" value="${sqlType}"/>
				</c:if>
		</table>
		<div class="btn_wrap">
			<input type="submit" style="background-image:url('/admin/img/btn_confirm.gif'); width:100px; height:45px; cursor:pointer;" value=""/>  
			<a href="/admin/club"><img src="/admin/img/btn_cancle.gif" /></a>
		</div>

		</div>
		</form>	
	</div>

	<div id="footwrap">

	</div>

</div>
<c:if test="${respon!= null}">
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
</body>
</html>