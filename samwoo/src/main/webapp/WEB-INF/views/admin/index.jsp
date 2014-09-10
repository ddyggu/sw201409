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
<script>

	function formSubmit() {
		var id = document.getElementById('id').value;
		var pass = document.getElementById('pass').value;
		
		if(id == "") { alert("아이디를 입력하여 주십시오"); return false; }
		if(pass == "") { alert("패스워드를 입력하여 주십시오"); return false; }
	}

</script>
</head>
<body>

<div id="login_wrap">
	<div class="login">
		<form name="loginForm" id="loginForm" method="post" action="/admin/loginConfirm" onsubmit="return formSubmit();">
		<div class="id_area">
			<input type="text" name="id" id="id" class="ipt" onfocus="this.value==this.defaultValue?this.value='':void(0);" onblur="this.value==''?this.value=this.defaultValue:void(0);" placeholder="아이디 입력">
		</div>
		<div class="pw_area">
			<input type="password" name="pass" id="pass" class="ipt" onfocus="this.value==this.defaultValue?this.value='':void(0);" onblur="this.value==''?this.value=this.defaultValue:void(0);" placeholder="비밀번호 입력">
		</div>
		<div style="position:absolute; top:290px; left:85px;">
			<input type="submit" style="background-image:url('/admin/img/btn_login.png'); 
			width:250px; height:40px; cursor:pointer; border-radius:5px;" value=""/>
		</div>
		</form>
	</div>
</div>
<c:if test="${check.isCheck() == false}">
	<script>
		var message = "${check.getMessage()}";
		alert(message);
	</script>
</c:if>
</body>
</html>