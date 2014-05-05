<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=9">
<title>杏彩游戏平台 </title>
<link href="../index_files/a_data/base.css" rel="stylesheet" type="text/css" media="all">
<link href="../index_files/a_data/layout.css" rel="stylesheet" type="text/css" media="all">
<link href="../index_files/a_data/subpage.css" rel="stylesheet" type="text/css" media="all">
<script src="../index_files/a_data/tab.js" type="text/javascript"></script>

<script src="../index_files/a_data/jquery-1.js" type="text/javascript"></script>
<script src="../index_files/a_data/jquery_005.js" type="text/javascript"></script>
<script src="../index_files/a_data/jquery_003.js" type="text/javascript"></script>
<link href="../index_files/a_data/dialogUI.css" media="all" type="text/css" rel="stylesheet">
<script src="../index_files/a_data/main.js" type="text/javascript"></script>
</head>

<body style="background: none repeat scroll 0 0 #D5D8DE">
<script type="text/javascript">
//删除遮罩
if($("#laybox",parent.parent.document).length){
	$("#laybox",parent.parent.document).remove();
}
</script>
<a name="topall"></a>
<div style="display:none;"><a href="http://www.live800.com/">客服</a></div>
<div style="display:none;"><a href="http://en.live800.com/">live chat</a></div> 
 <script type="text/javascript">
	jQuery("#loadhtml").hide(); //去掉loading界面
	jQuery(document).ready(function(){
		
    });	
    function checkForm(obj)
    {
        if( obj.username.value != "" && obj.usergroup.value == 0 )
        {
            alert("请选择用户组");
            return false;
        }
    }
</script>
<div id="mainContent">
	<table width="100%" class="topName"><tbody><tr><td>
	        <div class="bg clearfix">
	        	<div id="siderbar">
	                <ul class="list clearfix">
	                   	<li><a href="">用户列表</a></li>
	                   	<li><a href="">注册管理</a></li>
	                   	<li><a href="">绑定卡号</a></li>
	                   	<li><a href="">完善资料</a></li>
	                   	<li><a href="">消息管理</a></li>
	                   	<li><a href="">团队余额</a></li>
	                   	<li><a href="">密码修改</a></li>
	                   	<li><a href="">密保设定</a></li>
					</ul>
<script type="text/javascript">
$("#siderbar li").click(function(){
	$("#siderbar li").removeClass("current");
	$(this).addClass("current");
	//$("#subtitle").html($(this).text());
});
</script>
	            </div>
	
	</div></td><td align="right">
	<script>
	var setCookie=function(name,value,expire,path){
		//expire=expire||30*24*60*60*1000;
		var curdate=new Date();
		var cookie=name+"="+encodeURIComponent(value)+"; ";
		if(expire!=undefined||expire==0){
			if(expire==-1){
				expire=366*86400*1000;//保存一年
			}else{
				expire=parseInt(expire);
			}
			curdate.setTime(curdate.getTime()+expire);
			cookie+="expires="+curdate.toUTCString()+"; ";
		}
		path=path||"/";
		cookie+="path="+path;
		//alert(cookie);
		document.cookie=cookie;
		//alert(document.cookie);
	};
	var getCookie=function(name) {
		var re = "(?:; )?" + encodeURIComponent(name) + "=([^;]*);?";
		re = new RegExp(re);
		if (re.test(document.cookie)) {
			return decodeURIComponent(RegExp.$1);
		}
		return '';
	};
	//*url=getCookie('last_lottery_url');
	//*udocument.write("&lt;a href='"+url+"'&gt;返回游戏&lt;/a&gt;");
	</script>
	</td></tr></tbody></table>
</div>
<form action="" method="get" name="search" onsubmit="return checkForm(this)">
    <input name="controller" value="user" type="hidden">
    <input name="action" value="list" type="hidden">
    <input name="frame" value="show" type="hidden">
    <input name="flag" value="search" type="hidden">
    <table class="formTable" cellpadding="0" cellspacing="0" border="0" width="100%">
        <tbody><tr>
            <th>用户名：</th>
            <td><input name="username" id="username" type="text"></td>
            <th>用户余额：</th>
            <td><input name="bank_min" onkeyup="checkMoney(this)" size="10" type="text"> 至 <input name="bank_max" onkeyup="checkMoney(this)" size="10" type="text"></td>
        </tr>
        <tr>

            <td colspan="4" align="center"><input name="" style="margin:0px" value="查询" class="formCheck" type="submit"></td>
        </tr>
    </tbody></table>

</form>
<div class="line10px"></div>
<form action="" method="get">
    <table class="grayTable" id="userlistDL" cellpadding="0" cellspacing="0" border="0" width="100%">
        <tbody><tr>
            <th>用户名</th>
            <th>用户类型</th>
            <th>余额</th>
            <th>返点级别</th>
            <th>用户操作</th>
        </tr>
        
                <tr>
            <td>
            	<strong><a href="http://www.luckyssc.net/?controller=user&amp;action=list&amp;frame=show&amp;uid=206546" target="mainFrame">t098765</a></strong>
            </td>
            <td>一级代理</td>
            <td>0.0000</td>
            <td>0%</td>
            <td> 
                <a href="">团队余额</a>
				<a href="">下级充值</a>
                <a href="">返点设定</a>
				<a href="">投注记录</a>
			</td>
        </tr>
                <tr>
            <td colspan="6" height="20">
                <table cellpadding="0" cellspacing="0" border="0" width="100%">
                    <tbody><tr>
                        <td align="left">共有  1  会员 共1/1 页 每页20会员</td>
                        <td align="right">  <strong>1</strong>
   &nbsp;&nbsp;</td>
                    </tr>
                </tbody></table>
            </td>
        </tr>
    </tbody></table>
</form>
<script type="text/javascript">
    $("#userlistDL a").click(function(){
        var userstring = "用户列表 > "+$(this).text();
        parent.$("#addressDetail").text(userstring)
    });
</script>

</body></html>