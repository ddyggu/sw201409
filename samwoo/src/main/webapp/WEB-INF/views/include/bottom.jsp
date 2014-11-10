<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="footwrap">
	<div class="bottom">
		<img src="/img/footer_copy.jpg" class="copy">
		<div class="selecting">
			<img src="/img/up_relate.jpg" id="relate_select" style="cursor:pointer" onclick="relate_toggle()" />
		</div>
		<div id="relate_list" class="choose" style="display:none;">
			<p class="mt5"><a href="http://www.kira.or.kr/index.do" target="_blank">건축사 협회</a></p>
			<p class="mt5"><a href="http://www.gamri.or.kr/" target="_blank">감리 기술인 협회</a></p>
			<p class="mt5"><a href="http://www.lh.or.kr/" target="_blank">LH공사</a></p>
			<p class="mt5"><a href="http://www.i-sh.co.kr/" target="_blank">SH공사</a></p>
			<p class="mt5"><a href="http://www.fmc.mil.kr/" target="_blank">국군재정 관리단</a></p>
			<p class="mt5"><a href="http://www.dia.mil.kr/user/indexMain.action?siteId=dia" target="_blank">국방시설본부</a></p>
			<p class="mt5"><a href="http://www.pps.go.kr/kor/index.do" target="_blank">조달청</a></p>
			<p class="mt5"><a href="http://www.g2b.go.kr/index.jsp" target="_blank">나라장터</a></p>
		</div>
	</div>
</div>

<script type="text/javascript" src="/js/jquery.easing.js"></script>
<script>
function relate_toggle(){
	$("#relate_list").toggle();
}

// $(document).bind('scroll',function(event){
//  if(document.getElementById("drag1").style.display=="") document.getElementById("drag1").style.display="none";
//  if(document.getElementById("drag2").style.display=="none") {document.getElementById("drag2").style.display="";}
// });

/*
$(function(){


	var drag1 = $('#drag1');
	var drag2 = $('#drag2');


	var pNum = location.href.substr(location.href.lastIndexOf('=') + 1);


	if (pNum == 1) {

		$(window).one('scroll', function(){
			
			drag1.stop().animate({height:154},1000,'easeInOutQuad',function(){

				drag1.css('display','none');
				// drag2.css('display','block');
				$("html, body").stop().animate({scrollTop:0},300,'easeInOutQuad');
			});

			drag2.stop().animate({height:154},1000,'easeInOutQuad',function(){

			});
		});

	} else{

		drag1.css('display','none');
		drag2.css({'height':'154px'});
		$("html, body").stop().animate({scrollTop:0},200);

		// drag1.stop().animate({height:154},1000,'easeInOutQuad',function(){
		// 	drag1.css('display','none');
		// 	drag2.css('display','block');
		// });

	}
	
});
*/
</script>