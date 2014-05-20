<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=9">
<title>杏彩游戏平台 </title>
<link href="../a_data/base.css" rel="stylesheet" type="text/css" media="all">
<link href="../a_data/subpage.css" rel="stylesheet" type="text/css" media="all">
<script type="text/javascript" src="../a_data/jquery-1.js"></script>
<script type="text/javascript" src="../a_data/tab.js"></script>

<script type="text/javascript" src="../a_data/jquery.js"></script>
<script type="text/javascript" src="../a_data/jquery_002.js"></script>
<link href="../a_data/dialogUI.css" media="all" type="text/css" rel="stylesheet">

<script type="text/javascript" src="../a_data/main.js"></script>

<script type="text/javascript" src="../a_data/page.js"></script>
</head>

<body>
<script type="text/javascript">
//删除遮罩
if($("#laybox",parent.parent.document).length){
	$("#laybox",parent.parent.document).remove();
}
</script>
<a name="topall"></a>
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
	<tbody>
        <tr>
            <th>用户名</th>
            <th>用户类型</th>
            <th>余额</th>
            <th>返点级别</th>
            <th>用户操作</th>
        </tr>
        <tr>
            <td><strong><a href="" target="mainFrame">chenJJ</a></strong></td>
            <td>一级代理</td>
            <td>0.0000</td>
            <td>0%</td>
            <td> 
                <a href="http://www.caissc.net/?controller=user&amp;action=userteam&amp;uid=206545">团队余额</a>
				<a href="http://www.caissc.net/?controller=user&amp;action=saveup&amp;uid=206545">下级充值</a>
				<a href="http://www.caissc.net/?controller=user&amp;action=upedituser&amp;uid=206545">返点设定</a>
				<a href="http://www.caissc.net/?controller=report&amp;action=orders&amp;username=chenJJ">投注记录</a>
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
    </tbody>
</table>
</form>
<script type="text/javascript">
    $("#userlistDL a").click(function(){
        var userstring = "用户列表 > "+$(this).text();
        parent.$("#addressDetail").text(userstring)
    });
</script>

</body></html>