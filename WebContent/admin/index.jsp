<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>后台管理</title>
<link rel="stylesheet" href="skin/admin/layout.css" type="text/css" />
<link type="text/css" href="skin/js/jqueryui/skin/smoothness/jquery-ui-1.8.23.custom.css" rel="stylesheet" />
<!--[if IE]>
	<link rel="stylesheet" href="skin/admin/ie.css" type="text/css" />
	<script src="skin/js/html5.js"></script>
<![endif]-->
<script src="skin/js/jquery-1.8.0.min.js"></script>
<script src="skin/admin/onload.js"></script>
<script src="skin/admin/function.js"></script>
<script src="skin/admin/config.js"></script>
<script src="skin/js/Array.ext.js"></script>
<script src="skin/js/jqueryui/jquery-ui-1.8.23.custom.min.js"></script>
<script src="skin/js/jqueryui/i18n/jquery.ui.datepicker-zh-CN.js"></script>
<script src="skin/js/jquery.cookie.js"></script>

<script type="text/javascript">
$(function(){
	$('.quick_search input[name=username]')
	.focus(function(){
		if(this.value=='查找会员') this.value='';
	})
	.blur(function(){
		if(this.value=='') this.value='查找会员';
	})
	.keypress(function(e){
		if(e.keyCode==13) $(this).closest('form').submit();
	});
	
});

function searchUserSubmit(err,data){
	if(err){
		error(err);
	}else{
		$('#main').html(data);
	}
}
var TIP=true;
</script>
</head>
<body>

	<header id="header">
		<hgroup>
			<h1 class="site_title">后台管理系统</h1>
			<h2 class="section_title">
            	<a class="tjgk bq load" href="countData/index">统计概况</a><a class="txcl bq load" href="business/cashLog">提现处理</a>
            </h2>
            <div class="btn_view_site"><a href="logout">安全退出</a></div>
		</hgroup>
	</header>
	
	<section id="secondary_bar">
		<div class="user">
			<p>欢迎：<a href="#">管理设置</a></p>
		</div>
		<div class="breadcrumbs_container">
			<article class="breadcrumbs"><a>当前位置：<strong>首页</strong></a> <div class="breadcrumb_divider"></div> <span id="position"><a class="current">统计概况</a></span></article>
		</div>
	</section><!-- end of secondary bar -->
	
	<aside id="sidebar" class="column">
		<form action="" class="quick_search" call="searchUserSubmit" dataType="html" target="ajax">
			<input name="username" type="search" placeholder="查找会员" value="查找会员"/>
	    </form>
		<hr/>
		<h3>业务流水<a>＋</a></h3>
		<ul class="toggle" style="display:none;">
			<!---<li><a class="bq yw_b_1" href="business/test1">SERVER</a></li>--->
			<li><a class="bq yw_b_1" href="business/cash">提现请求</a></li>
			<li><a class="bq yw_b_2" href="business/cashLog">提现记录</a></li>
			<li><a class="bq yw_b_3" href="business/rechargeLog">充值记录</a></li>
			<li><a class="bq yw_b_4" href="business/betLog">普通投注</a></li>
			<li><a class="bq yw_b_7" href="business/coinLog">帐变明细</a></li>
		</ul>
		<h3>开奖数据<a>＋</a></h3>
		<ul class="toggle" style="display:none;">
			<li><a class="bq yw_b_1" href="business/index">重庆时时彩</a></li>
		</ul>
		<h3>数据统计<a>＋</a></h3>
		
		<ul class="toggle" style="display:none;">
			<li><a href="business/betDate" class="s_b_2 bq">综合统计</a></li>
		</ul>
		 
		<h3>用户管理<a>＋</a></h3>
		<ul class="toggle" style="display:none;">
			<li><a href="business/add_member" class="yh_b_1 bq">增加会员</a></li>
			<li><a href="business/index_member" class="yh_b_2 bq">用户列表</a></li>
            <li><a href="business/bank_member" class="yh_b_4 bq">银行信息</a></li>
            <li><a href="business/loginLog_member" class="yh_b_5 bq">登录日志</a></li>           
		</ul>
		
		<h3>管理人员<a>＋</a></h3>
		<ul class="toggle" style="display:none;">
			<li><a href="business/index_manage" class="g_b_1 bq">管理员列表</a></li>
            <li><a href="business/login-list" class="g_b_4 bq">登录日志</a></li>
		</ul>
		 
		<h3>系统设置<a>＋</a></h3>
		<ul class="toggle" style="display:none;">
		
			<li><a href="business/settings_sys" class="bq t_b_4">系统设置</a></li>
			<li><a href="business/notice_sys" class="bq t_b_3">系统公告</a></li>		
			<li><a href="business/bank_sys" class="bq t_b_5">银行设置</a></li>
			<li><a href="business/played_sys" class="bq t_b_9">玩法设置</a></li>

		</ul>
		<footer>
			<hr />
			<p><strong>Copyright &copy; 平台</strong></p>
		</footer>
	</aside>

	<section id="message-tip"></section>
	<section id="main" class="column"></section>
</body>
</html>

<script>
var fanDian = "${fanDian}";
var fanDianBdw = "${fanDianBdw}";


</script>