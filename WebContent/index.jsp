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
            <li><a class="show" title="报表管理" url-data="index/userMain?type=3" href="javascript:void(0)">报表管理</a></li>
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
                <span class="addMoney"><a url-data="index/userMain?type=4" class="show" href="javascript:void(0)" title="账户充提">充值</a></span> 
                <span class="decMoney"><a url-data="index/userMain?type=5" class="show" href="javascript:void(0)" title="账户充提">提款</a></span>               
                </li>
            </ul>
      </div>
    </div>
    <div class="left_menu">
    	<div class="menu_title">彩种选择</div>
		<div id="lotty_type">
			<ul class="menu_list ui-sortable">
				<li><a href="index/getCqsscPage" target="main">
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
		<iframe id="main" name="main" src="index/getCqsscPage" frameborder="0"></iframe>
	</div>
</div>

<script type="text/javascript" src="index_files/jquery_left.js"></script>
<script type="text/javascript" src="index_files/a_data/main.js"></script>
<script type="text/javascript" src="index_files/ttjquery_g.js"></script>
<script type="text/javascript" src="index_files/frame.js"></script>
<script type="text/javascript" src="index_files/jquery.js"></script>
<script type="text/javascript" src="index_files/layer.js"></script>
<script type="text/javascript" src="index_files/index.js"></script>

<div style="width: 100%; position: absolute; top: 20px;z-index: 1000;">
	<div id="popupad" style="width: 590px; margin: 0px auto; background: none repeat scroll 0% 0% rgb(255, 255, 255); border: 6px solid rgb(255, 255, 255); color: red; border-radius: 5px; display: none;">
		<div
			style="background: url(images/sincai/popupbg.jpg) repeat-x top; height: 29px; width: 575px; color: #FFFFFF; font-size: 14px; padding-left: 15px;">
			杏彩平台最新公告<span
				style="cursor: pointer; float: right; padding-right: 10px; padding-top: 7px;"
				onclick="opoupad();"><img
				src="index_files/a_data/popupclose.jpg" border="0"></span>
		</div>
		<div
			style="width: 554px; margin: 0px auto; padding: 10px; background: #e0e0e0; border-left: 8px solid #800001; border-right: 8px solid #800001; border-bottom: 8px solid #800001; color: #4f4f4f;">
			<p></p>
			<p>
				<span id="docs-internal-guid-db367ef0-1b1d-850e-07e1-3b8adcd77cb5">
				</span>
			</p>
			<p dir="ltr"
				style="line-height: 1.15; margin-top: 0pt; margin-bottom: 0pt; text-align: center;">
				<span style="color: rgb(0, 0, 255);"><span
					style="font-size: 15px; font-family: Arial; background-color: transparent; font-weight: bold; vertical-align: baseline; white-space: pre-wrap;">活动一、杏彩迎春，彩王再现</span></span>
			</p>
			<p>&nbsp;</p>
			<p dir="ltr"
				style="line-height: 1.15; margin-top: 0pt; margin-bottom: 0pt;">
				<span
					style="font-size: 15px; font-family: Arial; background-color: transparent; vertical-align: baseline; white-space: pre-wrap;">又到一年春暖花开时，又一期杏彩彩王争霸赛强势开启！本次彩王大礼又将花落谁家，众位玩家们快快投注勇夺彩王吧！</span>
			</p>
			<p>&nbsp;</p>
			<p dir="ltr"
				style="line-height: 1.15; margin-top: 0pt; margin-bottom: 0pt;">
				<span
					style="font-size: 15px; font-family: Arial; background-color: transparent; vertical-align: baseline; white-space: pre-wrap;">活动规则：每三天系统会自动计算所有玩家的投注量，投注量最高的前五名即可在第二天点击领取彩王现金奖励！（获奖用户会以平台公告形式公布。）</span>
			</p>
			<p dir="ltr"
				style="line-height: 1.15; margin-top: 0pt; margin-bottom: 0pt; text-align: center;">&nbsp;</p>
			<p dir="ltr"
				style="line-height: 1.15; margin-top: 0pt; margin-bottom: 0pt; text-align: center;">
				<span style="color: rgb(255, 0, 0);"><span
					style="font-size: 15px; font-family: Arial; background-color: transparent; vertical-align: baseline; white-space: pre-wrap;">第一名
						—— 38888元</span></span>
			</p>
			<p dir="ltr"
				style="line-height: 1.15; margin-top: 0pt; margin-bottom: 0pt; text-align: center;">
				<span style="color: rgb(255, 0, 0);"><span
					style="font-size: 15px; font-family: Arial; background-color: transparent; vertical-align: baseline; white-space: pre-wrap;">第二名
						—— 28888元</span></span>
			</p>
			<p dir="ltr"
				style="line-height: 1.15; margin-top: 0pt; margin-bottom: 0pt; text-align: center;">
				<span style="color: rgb(255, 0, 0);"><span
					style="font-size: 15px; font-family: Arial; background-color: transparent; vertical-align: baseline; white-space: pre-wrap;">第三名
						—— 18888元</span></span>
			</p>
			<p dir="ltr"
				style="line-height: 1.15; margin-top: 0pt; margin-bottom: 0pt; text-align: center;">
				<span style="color: rgb(255, 0, 0);"><span
					style="font-size: 15px; font-family: Arial; background-color: transparent; vertical-align: baseline; white-space: pre-wrap;">第四名
						—— 5888元</span></span>
			</p>
			<p dir="ltr"
				style="line-height: 1.15; margin-top: 0pt; margin-bottom: 0pt; text-align: center;">
				<span style="color: rgb(255, 0, 0);"><span
					style="font-size: 15px; font-family: Arial; background-color: transparent; vertical-align: baseline; white-space: pre-wrap;">第五名
						—— 3888元</span></span>
			</p>
			<p dir="ltr"
				style="line-height: 1.15; margin-top: 0pt; margin-bottom: 0pt; text-align: center;">
				<span style="color: rgb(255, 0, 0);"><span
					style="font-size: 15px; font-family: Arial; background-color: transparent; vertical-align: baseline; white-space: pre-wrap;">第六名
						—— 888元</span></span>
			</p>
			<p>&nbsp;</p>
			<p dir="ltr"
				style="line-height: 1.15; margin-top: 0pt; margin-bottom: 0pt;">
				<span
					style="font-size: 15px; font-family: Arial; background-color: transparent; vertical-align: baseline; white-space: pre-wrap;">活动时间：4月1日至4月30日</span>
			</p>
			<p>&nbsp;</p>
			<p dir="ltr"
				style="line-height: 1.15; margin-top: 0pt; margin-bottom: 0pt;">
				<span
					style="font-size: 15px; font-family: Arial; background-color: transparent; vertical-align: baseline; white-space: pre-wrap;">活动注意事项：</span>
			</p>
			<p dir="ltr"
				style="line-height: 1.15; margin-top: 0pt; margin-bottom: 0pt;">
				<span
					style="font-size: 15px; font-family: Arial; background-color: transparent; vertical-align: baseline; white-space: pre-wrap;">1、三天累计投注量达到10000元才有资格参与本活动。</span>
			</p>
			<p dir="ltr"
				style="line-height: 1.15; margin-top: 0pt; margin-bottom: 0pt;">
				<span
					style="font-size: 15px; font-family: Arial; background-color: transparent; vertical-align: baseline; white-space: pre-wrap;">2、任何的对冲等刷量行为不计入有效投注，【杏彩娱乐】保留取消、收回该帐号赠送礼金的权利。</span>
			</p>
			<p dir="ltr"
				style="line-height: 1.15; margin-top: 0pt; margin-bottom: 0pt;">
				<span
					style="font-size: 15px; font-family: Arial; background-color: transparent; vertical-align: baseline; white-space: pre-wrap;">3、【杏彩娱乐】保留对此次活动做出更改、终止权利，并享有最终解释权。</span>
			</p>
			<p>&nbsp;</p>
			<p dir="ltr"
				style="line-height: 1.15; margin-top: 0pt; margin-bottom: 0pt;">&nbsp;</p>
			<p>&nbsp;</p>
			<p dir="ltr"
				style="line-height: 1.15; margin-top: 0pt; margin-bottom: 0pt; text-align: center;">
				<span style="color: rgb(0, 0, 255);"><span
					style="font-size: 15px; font-family: Arial; background-color: transparent; font-weight: bold; vertical-align: baseline; white-space: pre-wrap;">活动二、杏彩四月，驷马难追</span></span>
			</p>
			<p dir="ltr"
				style="line-height: 1.15; margin-top: 0pt; margin-bottom: 0pt; text-align: center;">&nbsp;</p>
			<p>&nbsp;</p>
			<p dir="ltr"
				style="line-height: 1.15; margin-top: 0pt; margin-bottom: 0pt;">
				<span
					style="font-size: 15px; font-family: Arial; background-color: transparent; vertical-align: baseline; white-space: pre-wrap;">为了让大家熟悉业界领先的追号系统，配合在线双通道给大家带来的畅快淋漓的到账速度。本次特意推出追号打码大返利活动！</span>
			</p>
			<p dir="ltr"
				style="line-height: 1.15; margin-top: 0pt; margin-bottom: 0pt;">
				<span
					style="font-size: 15px; font-family: Arial; background-color: transparent; vertical-align: baseline; white-space: pre-wrap;">点击选择以下追号任务之后，开始累积您的追号金额，只要您当天休市前追号完成金额达到任务要求金额，即可点击领取属于您的追号礼金！</span>
			</p>
			<p dir="ltr"
				style="line-height: 1.15; margin-top: 0pt; margin-bottom: 0pt;">&nbsp;</p>
			<p dir="ltr"
				style="line-height: 1.15; margin-top: 0pt; margin-bottom: 0pt;">
				<span
					style="font-size: 15px; font-family: Arial; background-color: transparent; vertical-align: baseline; white-space: pre-wrap;">

					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><span
					style="color: rgb(255, 0, 0);"><span
					style="font-size: 15px; font-family: Arial; background-color: transparent; vertical-align: baseline; white-space: pre-wrap;">&nbsp;
						追号完成金额
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						礼金</span></span>
			</p>
			<p dir="ltr"
				style="line-height: 1.15; margin-top: 0pt; margin-bottom: 0pt;">
				<span style="color: rgb(255, 0, 0);"><span
					style="font-size: 15px; font-family: Arial; background-color: transparent; vertical-align: baseline; white-space: pre-wrap;">

						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;888
						元
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;8
						元</span></span>
			</p>
			<p dir="ltr"
				style="line-height: 1.15; margin-top: 0pt; margin-bottom: 0pt;">
				<span style="color: rgb(255, 0, 0);"><span
					style="font-size: 15px; font-family: Arial; background-color: transparent; vertical-align: baseline; white-space: pre-wrap;">

						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;8888
						元
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;88
						元</span></span>
			</p>
			<p dir="ltr"
				style="line-height: 1.15; margin-top: 0pt; margin-bottom: 0pt;">
				<span style="color: rgb(255, 0, 0);"><span
					style="font-size: 15px; font-family: Arial; background-color: transparent; vertical-align: baseline; white-space: pre-wrap;">

						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						88888 元
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						888元</span></span>
			</p>
			<p>&nbsp;</p>
			<p dir="ltr"
				style="line-height: 1.15; margin-top: 0pt; margin-bottom: 0pt;">&nbsp;</p>
			<p dir="ltr"
				style="line-height: 1.15; margin-top: 0pt; margin-bottom: 0pt;">
				<span
					style="font-size: 15px; font-family: Arial; background-color: transparent; vertical-align: baseline; white-space: pre-wrap;">活动注意事项：</span>
			</p>
			<p dir="ltr"
				style="line-height: 1.15; margin-top: 0pt; margin-bottom: 0pt;">
				<span
					style="font-size: 15px; font-family: Arial; background-color: transparent; vertical-align: baseline; white-space: pre-wrap;">1、如果当天无法完成设定的追号要求或者没有自行领取礼金，则自动视为放弃挑战。</span>
			</p>
			<p dir="ltr"
				style="line-height: 1.15; margin-top: 0pt; margin-bottom: 0pt;">
				<span
					style="font-size: 15px; font-family: Arial; background-color: transparent; vertical-align: baseline; white-space: pre-wrap;">2、同一帐号、同一银行帐号、同一ip地址每天只可以参与一次挑战，任何的对冲等刷量行为不计入有效投注，【杏彩娱乐】保留取消、收回该帐号赠送礼金的权利。</span>
			</p>
			<p dir="ltr"
				style="line-height: 1.15; margin-top: 0pt; margin-bottom: 0pt;">
				<span
					style="font-size: 15px; font-family: Arial; background-color: transparent; vertical-align: baseline; white-space: pre-wrap;">3、【杏彩娱乐】保留对此次活动做出更改、终止权利，并享有最终解释权。
				</span>
			</p>
			<p>
				<br> <br>
			</p>
			<p dir="ltr"
				style="line-height: 1.15; margin-top: 0pt; margin-bottom: 0pt; text-align: center;">
				<span style="color: rgb(0, 0, 255);"><span
					style="font-size: 15px; font-family: Arial; background-color: transparent; font-weight: bold; vertical-align: baseline; white-space: pre-wrap;">活动三、时时陪伴，日日签到</span></span>
			</p>
			<p>&nbsp;</p>
			<p dir="ltr"
				style="line-height: 1.15; margin-top: 0pt; margin-bottom: 0pt;">
				<span
					style="font-size: 15px; font-family: Arial; background-color: transparent; vertical-align: baseline; white-space: pre-wrap;">杏彩为了答谢玩家们的日夜支持与陪伴，继续推出出每日签到优惠活动。活动期间，只要每日登陆平台并投注588元，即可完成每日任务，点击“签到”即可参与每日签到抽奖环节，有机会抽取到<span
					style="color: rgb(255, 0, 0);">现金红包（100%中奖）</span>！完成累积签到15天的玩家可以额外获得58元连续活跃奖金！领取15天奖金后可以重新开始累计签到日数！
				</span>
			</p>
			<p>&nbsp;</p>
			<p dir="ltr"
				style="line-height: 1.15; margin-top: 0pt; margin-bottom: 0pt;">
				<span
					style="font-size: 15px; font-family: Arial; background-color: transparent; vertical-align: baseline; white-space: pre-wrap;">活动时间：4月1日至4月30日</span>
			</p>
			<p>
				<br> <br>
			</p>
			<p dir="ltr"
				style="line-height: 1.15; margin-top: 0pt; margin-bottom: 0pt; text-align: center;">
				<span style="color: rgb(0, 0, 255);"><span
					style="font-size: 15px; font-family: Arial; background-color: transparent; font-weight: bold; vertical-align: baseline; white-space: pre-wrap;">活动四、开中有奖，零点礼金大放送</span></span>
			</p>
			<p>&nbsp;</p>
			<p dir="ltr"
				style="line-height: 1.15; margin-top: 0pt; margin-bottom: 0pt;">
				<span
					style="font-size: 15px; font-family: Arial; background-color: transparent; vertical-align: baseline; white-space: pre-wrap;">每日<span
					style="color: rgb(255, 0, 0);">重庆时时彩第120期</span>结果会在零点时分开出，只要您<span
					style="color: rgb(255, 0, 0);">第120期</span>有
					下注并且中奖，即有资格申请零点奖金。只要当期开奖结果后四位与您最近绑定的银行卡号后四位存在一致位置（个、十、百、千位）与数值，即可与在线客服联系
					领取零点特别礼金！个、十位数字吻合可获得88元礼金，个、十、百位数字吻合可获得888元礼金，个、十、百、千位数字都吻合可获得8888元礼金！
				</span>
			</p>
			<p>&nbsp;</p>
			<p dir="ltr"
				style="line-height: 1.15; margin-top: 0pt; margin-bottom: 0pt;">
				<span
					style="font-size: 15px; font-family: Arial; background-color: transparent; vertical-align: baseline; white-space: pre-wrap;">活动时间：4月1日至4月30日</span>
			</p>
			<p>&nbsp;</p>
			<p>&nbsp;</p>
			<p>杏彩娱乐公司</p>
			<p>2014年4月1日</p>
			<p dir="ltr"
				style="line-height: 1.15; margin-top: 0pt; margin-bottom: 0pt;">&nbsp;</p>
			<div>
				<span
					style="font-size: 15px; font-family: Arial; background-color: transparent; vertical-align: baseline; white-space: pre-wrap;"><br></span>
			</div>
			<p>&nbsp;</p>
			<p></p>
		</div>
	</div>
</div>


<script type="text/javascript">
var basePath = '<%=request.getContextPath()%>';

var var_cur_issue = "${cur_issue}";
var var_servertime = "${servertime}";
var Iss_today = "${Iss_today}";
Iss_today = Iss_today.split("|");

var Iss_tomorrow = "${Iss_tomorrow}";
Iss_tomorrow = Iss_tomorrow.split("|");

var moneyMap = eval('(' + '${moneyMap}' + ')');
var fandian = "${fandian}";
var fandianbdw = "${fandianbdw}";

function SetCookie(name,value,expire) {   
    var exp  = new Date();   
    exp.setTime(exp.getTime() + expire);   
    document.cookie = name + "="+ escape (value) + ";expires=" + exp.toGMTString();   
}

SetCookie("sincailotterytips","",86400);
    
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

$(document).ready(function(){
	$("#popupad").show("slow");
	/* if(getCookie("nalert")!=1)
    {
        $("#popupad").show("slow");
        setCookie("nalert",1);
    } */
});
function opoupad()
{
    $("#popupad").hide("slow");
}
</script>


</body></html>