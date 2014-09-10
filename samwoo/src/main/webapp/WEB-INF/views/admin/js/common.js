/* number comma add*/
function numCommaAdd(_num){
	 str = String(_num);
	 return str.replace(/(\d)(?=(?:\d{3})+(?!\d))/g, '$1,');
}


var product_nav = new Array();
var main_nav = new Array();
var scrollTop = 0;
var scroll_act = 0;
var bannerFlag = false;
var menuFlag = false;
var bannerH = 140;
$(function(){		
	var windowW = $(window).width();
	var windowH = $(window).height();
	var scrollFlag = false;
	//초기실행함수	
		
	$(".main_menu > li, .main_other_menu > li").bind("mouseover focusin" , function(){								
		$(this).addClass("current").find(".snb").show();										
		$(this).find(" > a > img").attr("src" , $(this).find("> a > img").attr("src").replace("_off.png", "_on.png") );
	}).bind("mouseleave focusOut" , function(){		
		$(".main_menu > li, .main_other_menu > li").removeClass("current");				
		$(".main_menu > li > .snb, .main_other_menu > li > .snb").hide();	
		$(this).find(" > a > img").attr("src" , $(this).find("> a > img").attr("src").replace("_on.png", "_off.png") );
	});
	



	/**
	 @ Hearder > Menu
	**/
	$(window).scroll(function(){
		scrollTop = $(document).scrollTop();
		
		if (bannerFlag)
		{
			if (scrollTop > 262)
			{
				menuFlag = true;
				$(".location").addClass("on");
			}
			else
			{
				menuFlag = false;
				$(".location").removeClass("on");
			}
		}
		else
		{
			if (scrollTop > 122)
			{				
				menuFlag = true;
				$(".location").addClass("on");		
			}
			else
			{
				menuFlag = false;
				$(".location").removeClass("on");						
			}
		}
		
	});	


	$(".cate-sort > ul > li > a").bind("mouseover focusin" , function(){
		$(this).next("ul").show();
	}).bind("mouseleave focusout" , function(){
		$(this).next("ul").hide();
	});	
	
	$("#cartLayer").live("mouseover",function(){
		clearTimeout(cartLayer);	
	});
	$("#wishLayer").live("mouseover",function(){
		clearTimeout(wishLayer);	
	});
	$("#couponLayer").live("mouseover",function(){
		clearTimeout(couponLayer);	
	});
});



	/**
	 탭
	**/

function initTabMenu(tabContainerID) {
	var tabContainer = document.getElementById(tabContainerID);
	var tabAnchor = tabContainer.getElementsByTagName("a");
	var i = 0;

	for(i=0; i<tabAnchor.length; i++) {
		if (tabAnchor.item(i).className == "tab")
			thismenu = tabAnchor.item(i);
		else
			continue;

		thismenu.container = tabContainer;
		thismenu.targetEl = document.getElementById(tabAnchor.item(i).href.split("#")[1]);
		thismenu.targetEl.style.display = "none";
		thismenu.imgEl = thismenu.getElementsByTagName("img").item(0);
		thismenu.onclick = function tabMenuClick() {
			currentmenu = this.container.current;
			if (currentmenu == this)
				return false;

			if (currentmenu) {
				currentmenu.targetEl.style.display = "none";
				if (currentmenu.imgEl) {
					currentmenu.imgEl.src = currentmenu.imgEl.src.replace("_ov.gif", ".gif");
				} else {
					currentmenu.className = currentmenu.className.replace(" ov", "");
				}
			}
			this.targetEl.style.display = "";
			if (this.imgEl) {
				this.imgEl.src = this.imgEl.src.replace(".gif", "_ov.gif");
			} else {
				this.className += " ov";
			}
			this.container.current = this;

			return false;
		};

		if (!thismenu.container.first)
			thismenu.container.first = thismenu;
	}
	if (tabContainer.first)
		tabContainer.first.onclick();
}


/*FAQ*/
jQuery(function($){
	// Frequently Asked Question
	var article = $('.faq>.faqBody>.article');
	article.addClass('hide');
	article.find('.a').hide();
	article.eq(0).removeClass('hide');
	article.eq(0).find('.a').show();
	$('.faq>.faqBody>.article>.q>a').click(function(){
		var myArticle = $(this).parents('.article:first');
		if(myArticle.hasClass('hide')){
			article.addClass('hide').removeClass('show');
			article.find('.a').slideUp(100);
			myArticle.removeClass('hide').addClass('show');
			myArticle.find('.a').slideDown(100);
		} else {
			myArticle.removeClass('show').addClass('hide');
			myArticle.find('.a').slideUp(100);
		}
		return false;
	});
	$('.faq>.faqHeader>.showAll').click(function(){
		var hidden = $('.faq>.faqBody>.article.hide').length;
		if(hidden > 0){
			article.removeClass('hide').addClass('show');
			article.find('.a').slideDown(100);
		} else {
			article.removeClass('show').addClass('hide');
			article.find('.a').slideUp(100);
		}
	});
});

