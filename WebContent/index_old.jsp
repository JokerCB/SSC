<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>AAA</title>
<link href="index_files/frame.css" rel="stylesheet" type="text/css">
<link href="index_files/default_style.css" rel="stylesheet" type="text/css">
<link href="index_files/gb_styles.css" rel="stylesheet" type="text/css" media="all">
<link href="index_files/layer.css" rel="stylesheet" type="text/css">
</head>
<body class="showmenu">
<div class="head">
	<div class="top">
		<div class="top_logo">
			<img src="index_files/logo.jpg" alt="AAA" title="AAASS">
		</div>
           		<div class="top_link_us">
        <ul id="nav">
            <li class="ser_ico"><a onclick="return isclient('http://kf1.learnsaas.com/chat/chatClient/chatbox.jsp?companyID=26088&amp;configID=49018&amp;jid=3387893259');" title="在线客服">在线客服</a></li>
        </ul>

		</div>
		<div class="top_link">
        <ul>
            <li><a class="show" title="账户管理" url-data="index/userMain?type=1" href="javascript:void(0)">账户管理</a></li>
            <li><a class="show" title="投注记录" url-data="index/userMain?type=2" href="javascript:void(0)">投注记录</a></li>
            <li><a class="show" title="报表管理" url-data="/?controller=report&amp;action=main" href="javascript:void(0)">报表管理</a></li>
            <li><a class="show" title="网站公告" url-data="/?nav=notice" href="javascript:void(0)">网站公告</a></li>
            <li><a class="show" title="热门活动" url-data="/?controller=promotions&amp;action=main" href="javascript:void(0)">热门活动</a></li>
        </ul>
		</div>
	</div>
<div>
  </div>
</div>

<div class="left">
	<div class="menu" id="menu">
    <div class="left_msg">
    <div class="left_ico">
    <ul id="TT_news_g">
        <!--foreach from=$publish_list item=notice key=k-->
        
        <!--/foreach-->
        
    <li><a url-data="/?nav=notice&amp;tag=notice&amp;nid=" class="show" href="javascript:void(0)" title="网站公告">杏彩四月活动火爆出击：踏青迎春心情爽，精</a></li></ul>
    </div></div>
    <div class="left_detail">
    	<div class="detail_left"><img src="index_files/detail_ico.jpg"> <p>[ <a href="logout">退出</a> ]</p></div>
        <div class="detail_right">
        	<ul>
            	<li><label>您好，</label><span>${mname}</span></li>
                <li><label>余额：</label><span class="bal" id="availabalances"><a class="sx" id="refff" href="#" title="刷新余额">0.0000</a></span></li>
                <li><a url-data="/?controller=user&amp;action=main&amp;tag=messages" class="show" href="javascript:void(0)" title="账户管理"><img src="index_files/emailNone.gif"></a>
                <span class="mail"><a url-data="/?controller=user&amp;action=main&amp;tag=messages" class="show" href="javascript:void(0)" title="账户管理">( <strong class="white">0</strong> )</a></span> 
                <span class="addMoney"><a url-data="/?controller=emaildeposit&amp;action=main" class="show" href="javascript:void(0)" title="账户充提">充值</a></span> 
                <span class="decMoney"><a url-data="/?controller=emaildeposit&amp;action=main&amp;tag=platwithdraw" class="show" href="javascript:void(0)" title="账户充提">提款</a></span>               
                </li>
            </ul>
      </div>
    </div>
    <div class="left_menu">
    	<div class="menu_title">彩种选择</div>
		<div id="lotty_type">
			<ul class="menu_list ui-sortable">
				<li><a href="index_files/a.jsp" target="main">
				<img src="index_files/ico01_01.jpg"><p class="lhover">重庆时时彩</p></a></li>
				<!-- 
				
				<li><a href="http://www.luckyssc.net/?nav=ssc&amp;curmid=119" target="main">
				<img src="index_files/ico01_02.jpg"><p>江西时时彩</p></a></li>
				<li><a href="http://www.luckyssc.net/?nav=ssc&amp;curmid=220" target="main">
				<img src="index_files/ico01_03.jpg"><p>新疆时时彩</p></a></li>
                				<li><a href="http://www.luckyssc.net/?nav=11y" target="main">
				<img src="index_files/ico02_01.jpg"><p>广东11选5</p></a></li>
				<li><a href="http://www.luckyssc.net/?nav=11y&amp;curmid=355" target="main">
				<img src="index_files/ico02_02.jpg"><p>重庆11选5</p></a></li>
				<li><a href="http://www.luckyssc.net/?nav=11y&amp;curmid=256" target="main">
				<img src="index_files/ico02_03.jpg"><p>江西11选5</p></a></li>
				<li><a href="http://www.luckyssc.net/?nav=11y&amp;curmid=174" target="main">
				<img src="index_files/ico02_04.jpg"><p>山东11选5</p></a></li>
				<li><a href="http://www.luckyssc.net/?nav=dipin" target="main">
				<img src="index_files/ico03_01.jpg"><p>3D福彩</p></a></li>
				<li><a href="http://www.luckyssc.net/?nav=dipin&amp;curmid=615" target="main">
				<img src="index_files/ico04_01.jpg"><p>排列三</p></a></li>
				<li><a href="http://www.luckyssc.net/?nav=klc" target="main">
				<img src="index_files/ico05_01.jpg"><p>北京快乐8</p></a><em></em></li>
				
				 -->
                			</ul>
		</div>
       </div>
       <!--<div class="down_ad"><a href="/down.html" target="_blank"><img src="/images/sincai/download_s.jpg" border="0" /></a></div>-->
      <div class="online_service"><a class="show online" title="新手帮助" url-data="/?controller=help&amp;action=main&amp;tag=wfjs" href="javascript:void(0)">新手帮助</a></div>
      
</div>
	
</div>
<div class="menuact">
    <a href="#" id="togglemenu"><img src="index_files/hide.jpg"></a>
</div>

<div class="right">
	<div class="main">
		<iframe id="main" name="main" src="index_files/a.jsp" frameborder="0"></iframe>
	</div>
</div>

<script type="text/javascript" src="index_files/jquery_left.js"></script>
<script type="text/javascript" src="index_files/a_data/main.js"></script>
<script type="text/javascript" src="index_files/ttjquery_g.js"></script>
<script type="text/javascript" src="index_files/frame.js"></script>
<script type="text/javascript" src="index_files/jquery.js"></script>
<script type="text/javascript" src="index_files/layer.js"></script>
<script type="text/javascript" src="index_files/index.js"></script>

<script type="text/javascript">
var var_cur_issue = "${cur_issue}";
var var_servertime = "${servertime}";
var Iss_today = "${Iss_today}";
Iss_today = Iss_today.split("|");

var Iss_tomorrow = "${Iss_tomorrow}";
Iss_tomorrow = Iss_tomorrow.split("|");
var basePath = '<%=request.getContextPath()%>';
var moneyMap = eval('(' + '${moneyMap}' + ')');
var fandian = "${fandian}";
var fandianbdw = "${fandianbdw}";

function SetCookie(name,value,expire) {   
    var exp  = new Date();   
    exp.setTime(exp.getTime() + expire);   
    document.cookie = name + "="+ escape (value) + ";expires=" + exp.toGMTString();   
}

SetCookie("sincailotterytips","",86400);
    
var _gaq = _gaq || [];
_gaq.push(['_setAccount', 'UA-34470891-1']);
_gaq.push(['_setAllowLinker', true]);
_gaq.push(['_trackPageview']);

function getFieldValues(obj){
	var $obj = $(obj);
	var field=$obj.find("input[type!=submit][type!=button][type!=image],textarea,select");
	 for (var val={}, i=0, max=field.length; i < max; i++) {
	        var el = field[i];
	       	 if($(el).attr("name")||$(el).attr("id")){
	    	    val[$(el).attr("name")||$(el).attr("id")] = $(el).val();
	       }
	    }
	    return val;
}

</script>


</body></html>