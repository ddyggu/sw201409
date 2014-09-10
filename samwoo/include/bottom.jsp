<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<div id="footwrap">
	<div class="bottom">
		<img src="/img/footer_copy.jpg" class="copy">
		<div class="selecting">
			<img src="/img/up_relate.jpg" id="relate_select" style="cursor:pointer" onclick="relate_toggle()" />
		</div>
		<div id="relate_list" class="choose" style="display:none;">
			<p class="mt5"><a href="#">관련기간 1</a></p>
			<p class="mt5"><a href="#">관련기간 2</a></p>
			<p class="mt5"><a href="#">관련기간 3</a></p>
			<p class="mt5"><a href="#">관련기간 4</a></p>
			<p class="mt5"><a href="#">관련기간 5</a></p>
		</div>
	</div>
</div>
<script>
function relate_toggle(){
	$("#relate_list").toggle();
}

$(document).bind('scroll',function(event){
 if(document.getElementById("drag1").style.display=="") document.getElementById("drag1").style.display="none";
 if(document.getElementById("drag2").style.display=="none") {document.getElementById("drag2").style.display="";}
});
</script>