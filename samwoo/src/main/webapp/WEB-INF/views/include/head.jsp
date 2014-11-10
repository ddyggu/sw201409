<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd" />
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="ko" lang="ko" />
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title> 삼우공간 건축사사무소</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<link rel="stylesheet" type="text/css" href="/css/style.css"/>

<script type="text/javascript" src="/js/jquery-1.7.min.js"></script>
<script type="text/javascript" src="/js/script.js"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="/js/common.js"></script>

<script type="text/javascript" src="/js/jquery-ui.min.js"></script>
<link rel="stylesheet" type="text/css" href="/css/jquery-ui.min.css"/>
<style>
	.twitter-share-button {
		width:88px !important;
	}
</style>
<script>
// 페이스북 연동모듈 스크립트
window.fbAsyncInit = function() {
    FB.init({
      appId      : '1702835989941532',
      xfbml      : true,
      version    : 'v2.1'
    });
  };

  (function(d, s, id){
     var js, fjs = d.getElementsByTagName(s)[0];
     if (d.getElementById(id)) {return;}
     js = d.createElement(s); js.id = id;
     js.src = "//connect.facebook.net/en_US/sdk.js";
     fjs.parentNode.insertBefore(js, fjs);
   }(document, 'script', 'facebook-jssdk'));
</script>
</head>
<body>

<div id="topwrap">
	<div class="head">
		<div class="top_navi">
			<a href="/"><img src="/img/menu_home.png"></a>
			<!--a href="#"><img src="/img/menu_sitemap.png"></a-->
			<a href="/admin/index" target="_blank"><img src="/img/menu_intranet.png"></a>
		</div>
		<a href="/"><img src="/img/logo.png" class="mt20"></a>
		<div class="top_menu">
			<div id="topNav">
				<ul class="mainmenu">
					<li class="menu01">
						<a href="/about01"><span>about us</span></a>
						<div class="submenu">
							<ul>
								<li><a href="/about01">CEO 인사말</a></li>
								<li><a href="/about02">회사개요</a></li>
								<li><a href="/about03">연혁</a></li>
								<li><a href="/about04">조직도</a></li>
								<li><a href="/about05">보유인력현황</a></li>
								<li><a href="/about07?menu=A">특허</a></li>
								<li><a href="/about07?menu=B">신기술</a></li>
								<li><a href="/about08">찾아오시는 길</a></li>
							</ul>
						</div>
					</li>
					<li class="menu02">
						<a href="service01"><span>service</span></a>
						<div class="submenu">
							<ul>
								<li><a href="/service01">건설사업관리부</a></li>
								<li><a href="/service02">설계부</a></li>
								<li><a href="/service03">미디어 사업부</a></li>
								<li><a href="/service04">기술연구소</a></li>
							</ul>
						</div>
					</li>
					<li class="menu03">
					<a href="project"><span>project</span></a>
						<div class="submenu">
							<ul>
								<li><a href="/project?division=A">건설사업관리</a></li>
								<li><a href="/project?division=B">설계</a></li>
								<li><a href="/project?division=C">미디어 사업</a></li>
							</ul>
						</div>
					<li class="menu04">
						<a href="career01"><span>career</span></a>
						<div class="submenu">
							<ul>
								<li><a href="/career01">채용공고</a></li>
								<li><a href="/career02">채용절차</a></li>
								<li><a href="/career03">인재상/복리후생</a></li>
							</ul>
						</div>
					</li>
					</li>
					<li class="menu05">
						<a href="community01"><span>community</span></a>
						<div class="submenu">
							<ul>
								<li><a href="/community01">공지사항</a></li>
								<li><a href="/community03">FAQ</a></li>
								<li><a href="/community04">고객문의</a></li>
								<li><a href="/community05">동호회</a></li>
							</ul>
						</div>
					</li>      
					
				</ul>
				<script src='/js/controller.js' language='JavaScript'></script>
			</div>
		</div>
	</div>
</div>

<!-- <div class="topwrap_roll" id="drag1"></div> -->
<div class="topwrap_on" id="drag2"></div>