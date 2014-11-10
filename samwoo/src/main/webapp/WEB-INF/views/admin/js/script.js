$(function(){
	var obj = $("a[rel=ov]");

	obj.bind("mouseover focus mouseout blur",function(){
		var t = $(this);
		var img = t.find(">img");
		var src = img.attr("src");

		src = src.substr(src.lastIndexOf("_"));

		if(src != "_on.gif"){
			img.attr("src",img.attr("src").replace(".gif","_on.gif"));
		}else{
			img.attr("src",img.attr("src").replace("_on.gif",".gif"));
		}
	});
});

var myAnchors=document.getElementsByTagName("A");
function allblur() {
    try{
    	for (i=0;i<myAnchors.length;i++) {
    		myAnchors[i].onfocus=new Function("blur()");
    	}
	}catch(e){}
}
allblur();
var bii = 0;
function bluring(){
    try{
        if(event.srcElement.tagName=="A"||event.srcElement.tagName=="IMG") document.body.focus();
    }catch(e){}
}
document.onfocusin=bluring;

$(function(){
	var obj = $("a[rel=on]");

	obj.bind("mouseover focus mouseout blur",function(){
		var t = $(this);
		var img = t.find(">img");
		var src = img.attr("src");

		src = src.substr(src.lastIndexOf("_"));

		if(src != "_on.png"){
			img.attr("src",img.attr("src").replace(".png","_on.png"));
		}else{
			img.attr("src",img.attr("src").replace("_on.png",".png"));
		}
	});
	
	$("#listForm").submit(function(e) {
		
		if($("#listForm input:checked").length == 0) {
			alert("삭제할 게시물을 선택하여 주십시오");
			e.preventDefault();
		}
		
	});
	
});

var ver = 0; // Browser Version
var browser="";
 if(navigator.appName.charAt(0) == "N"){
  if(navigator.userAgent.indexOf("Chrome") != -1){
   ver = getInternetVersion("Chrome");
   browser="C";

  }else if(navigator.userAgent.indexOf("Firefox") != -1){
   ver = getInternetVersion("Firefox");
   browser="F";

  }else if(navigator.userAgent.indexOf("Safari") != -1){
   ver = getInternetVersion("Safari");
   browser="S";
  }
 }else if(navigator.appName.charAt(0) == "M"){
  ver = getInternetVersion("MSIE");
  browser="M";

  if (ver < "7"){
   alert("Please update to Internet Explorer version 7.0 or later.");
  }
 }
function getInternetVersion(ver) {
 var rv = -1; // Return value assumes failure.
 var ua = navigator.userAgent;
 var re = null;

 if(ver == "MSIE"){
  re = new RegExp("MSIE ([0-9]{1,}[\.0-9]{0,})");
 }else{
  re = new RegExp(ver+"/([0-9]{1,}[\.0-9]{0,})");
 }

 if (re.exec(ua) != null){
  rv = parseFloat(RegExp.$1);
 }
 return rv;
}

function CheckAll(source) {
	checkboxes = document.getElementsByName("boardNum");
	for(var i=0; i<=checkboxes.length; i++) {
		checkboxes[i].checked = source.checked;
	}
}

function deleteConfirm() {
	confirm("삭제하시겠습니까?")
	
}

