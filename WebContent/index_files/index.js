/**
 * Created with JetBrains WebStorm.
 * User: Robin
 * Date: 13-5-7
 * Time: 下午4:14
 * 合并的JS
 */
$(function(){
    $.ajax({
        type: "POST",
      //  url: "index.php?controller=default&action=start&ttt=1"
        url: "login"
    });

    $("#nav-one li").hover(function(){
        $("ul", this).fadeIn("fast");
    },function() {});

    if (document.all) {
        $("#nav-one li").each(function(){
            $(this).hover(function() {
                $(this).addClass(c);
            },function() {
                $(this).removeClass(c);
            });
        });
    }

    autoRefreshMoney();
    
    $(".show").bind("click", function(){
        flagShow = $(this).parents("li").index();
        $.layer({
            fix : true,
            title: $(this).attr("title"),
            type : 2,
            offset : ['', ''],
            iframe : {
                src : $(this).attr("url-data")
            },
            border : [10 , 0.3 , '#000', false],
            area : ['960px','600px']
        });
    });
    
    function inarray(str, array)
    {
        for(var i = 0; i < array.length; i++)
        {
            if(array[i] == str)
            {
                return true;
            }     
        }
        return false;
    }
    

    if (getCookie("play_mode")) {
        var value = getCookie("play_mode");
        var mode = value.split(",");
        var sincailotterytips = getCookie("sincailotterytips");
        var tips = sincailotterytips.split(",");
        var html = '';
        for (x in mode) {
            if (mode[x]) {
                if(x,tips)
                {
                    html += "<li>" + mode[x] + "<em></em></li>";
                } else {
                    html += "<li>" + mode[x] + "</li>";
                }
				
            }
        }
        $(".menu_list").html(html);
    }

    $('.menu_list').sortable({
        containment: "#lotty_type"
    });
    $('.menu_list').disableSelection();

    $('.menu_list li').each(function(){
        $(this).find("p").removeClass("lhover");
        if ($(this).find("p").html() == "重庆时时彩") {
            $(this).find("p").addClass("lhover");
        }
        $(this).find("a").bind("click", function(){
            $(this).find("p").addClass("lhover")
            .parents().siblings().find("a > p").removeClass("lhover");
        });
    });

    var _wrap=$('#zjtgul');
    var _interval=3500;
    var _moving;
    _wrap.hover(function(){
        clearInterval(_moving);
    },function(){
        _moving=setInterval(function(){
            var _field=_wrap.find("li:lt(2)");
            //var _field=_wrap.find('li');
            var _h= _field.height();
            _field.animate({
                marginTop:-_h+'px'
                },600,function(){
                _field.css('marginTop',0).appendTo(_wrap);
            })
        },_interval)
    }).trigger('mouseleave');
});

function cIsclient(sUrl){
    openweb(sUrl);
};

function isclient(Csurl){
    if(getCookie('isclient')){
        cIsclient(Csurl);
    }else{
        window.open(Csurl);
    }
};

function menuFix() {
    var sfEls = document.getElementById("nav").getElementsByTagName("li"); 
    for (var i=0; i<sfEls.length; i++) { 
        sfEls[i].onmouseover=function() { 
            this.className+=(this.className.length>0? " ": "") + "sfhover"; 
        } 
        sfEls[i].onMouseDown=function() { 
            this.className+=(this.className.length>0? " ": "") + "sfhover"; 
        } 
        sfEls[i].onMouseUp=function() { 
            this.className+=(this.className.length>0? " ": "") + "sfhover"; 
        } 
        sfEls[i].onmouseout=function() { 
            this.className=this.className.replace(new RegExp("( ?|^)sfhover\\b"), ""); 
        }
    }
};

function JumpFrame(url1, url2) {
    $('#menufra').get(0).src = url1;
    $('#main').get(0).src = url2;
};