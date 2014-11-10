<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${popup.title}</title>
<script>
function setCookie(name,value,expiredays)
{
        var todayDate = new Date();
        todayDate.setDate( todayDate.getDate() + expiredays );
        document.cookie = name + "=" + escape( value ) + "; path=/; expires=" + todayDate.toGMTString() + ";"
}

function closeWin(){
    setCookie("popup${popup.num}","popup${popup.num}",1);
    window.close();
}

</script>
</head>
<body>
	<div style="font-size:12px;">
	
	</div>
	<img src="/resources/upload/${file.encodedFileName}"/>
	<div style="background-color:#EAEAEA; height:25px; font-size:11px; text-align:right; padding-top:5px;">
		<input TYPE="checkbox" NAME="Notice" onClick="closeWin()">오늘 하루 동안 열지 않음
	</div>
</body>
</html>