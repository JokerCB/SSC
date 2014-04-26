var thespeed = 5;
var navIE = document.all && navigator.userAgent.indexOf("Firefox") == -1;
var myspeed=0;

jQuery(function(){
		
		//快捷菜单
		bindQuickMenu();
		
		//左侧菜单开关
		LeftMenuToggle();
		
		//全部功能开关

		//取消菜单链接虚线
		//jQuery(".head").find("a").click(function(){jQuery(this).blur()});
		//jQuery(".menu").find("a").click(function(){jQuery(this).blur()});
		
	}).keydown(function(event){//快捷键
		if(event.keyCode ==116 ){
		}
		if(event.keyCode ==27 ){
			jQuery("#qucikmenu").slideToggle("fast")
		}
});
	
function bindQuickMenu(){//快捷菜单
		jQuery("#ac_qucikmenu").bind("mouseenter",function(){
			jQuery("#qucikmenu").slideDown("fast");
		}).dblclick(function(){
			jQuery("#qucikmenu").slideToggle("fast");
		}).bind("mouseleave",function(){
			hidequcikmenu=setTimeout('jQuery("#qucikmenu").slideUp("fast");',700);
			jQuery(this).bind("mouseenter",function(){clearTimeout(hidequcikmenu);});
		});
		jQuery("#qucikmenu").bind("mouseleave",function(){
			hidequcikmenu=setTimeout('jQuery("#qucikmenu").slideUp("fast");',700);
			jQuery(this).bind("mouseenter",function(){clearTimeout(hidequcikmenu);});
		}).find("a").click(function(){
			jQuery(this).blur();
			jQuery("#qucikmenu").slideUp("fast");
		});
}
	
function LeftMenuToggle(){//左侧菜单开关
		jQuery("#togglemenu").click(function(){
			if(jQuery("body").attr("class")=="showmenu"){
				jQuery("body").attr("class","hidemenu");
				jQuery(this).html("<img src='images/sincai/open.jpg'>");
			}else{
				jQuery("body").attr("class","showmenu");
				jQuery(this).html("<img src='images/sincai/hide.jpg'>");
			}
		});
	}
	
	
function AllMenuToggle(){//全部功能开关
		mask = jQuery(".pagemask,.iframemask,.allmenu");
		jQuery("#allmenu").click(function(){
			//mask.show();
		});
		//mask.mousedown(function(){alert("123");});
		mask.click(function(){mask.hide();});
}

/*********************
 * 滚动按钮设置
*********************/

function scrollwindow()
{
	parent.frames['menu'].scrollBy(0,myspeed);
}

function initializeIT()
{
	if (myspeed!=0) {
		scrollwindow();
	}
}

function getUrlPar(strName) {
    var svalue = location.search.match(new RegExp("[\?\&]" + strName + "=([^\&]*)(\&?)", "i"));
    return svalue ? svalue[1] : svalue;
};


function SetWinHeight(obj){
 var win=obj;
 if (document.getElementById){
  if (win && !window.opera){
   if (win.contentDocument && win.contentDocument.body.offsetHeight) 
    win.height = win.contentDocument.body.offsetHeight; 
   else if(win.Document && win.Document.body.scrollHeight)
    win.height = win.Document.body.scrollHeight;
  }
 }
}

function SetIframeHeight(flag){
	if (flag == 1) {
		var h = $("#xubox_iframe").contents().find("#subContent_bet_re").contents().find("#mainFrame").contents().height();
		$("#xubox_iframe").contents().find("#subContent_bet_re").contents().find("#mainFrame").height(h);
	} else if (flag == 2) {
		$("#xubox_iframe").contents().find("#subContent_bet_re").contents().find("#mainFrame").height("400");
	} else {
		$("#xubox_iframe").contents().find("#subContent_bet_re").contents().find("#mainFrame").height("");
	}
	SetWinHeight(document.getElementById('mainFrame'));
}