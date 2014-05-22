<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=9">
<title>杏彩游戏平台  - 修改密码 </title>
<link href="../a_data/base.css" rel="stylesheet" type="text/css" media="all">
<link href="../a_data/subpage.css" rel="stylesheet" type="text/css" media="all">
<script type="text/javascript" src="../a_data/jquery-1.js"></script>
<script type="text/javascript" src="../a_data/tab.js"></script>
<script type="text/javascript" src="../a_data/jquery_006.js"></script>
<script type="text/javascript" src="../a_data/jquery_003.js"></script>
<link href="../a_data/dialogUI.css" media="all" type="text/css" rel="stylesheet">
<script type="text/javascript" src="../a_data/main.js"></script>
</head>
<body>
<script type="text/javascript">
//删除遮罩
if($("#laybox",parent.parent.document).length){
	$("#laybox",parent.parent.document).remove();
}
</script>
<link rel="stylesheet" href="../jqueryUI.css">
<script src="../jqueryUI-1.8.17.js"></script>
<script src="../jquerUI-Widget-1.8.17.js"></script>
<script src="../jqueryUI-tab.js"></script>
<script language="javascript" type="text/javascript" src="../jQuery-MD5.js"></script>
<!--消息框代码结束-->
<script type="text/javascript">
function checkform(obj) {
	if (!validateUserPss(obj.newpass.value)) {
		$.alert("密码不符合规则，请重新输入");
		obj.newpass.focus();
		return false;
	}
	if (obj.newpass.value != obj.confirm_newpass.value) {
		$.alert("两次输入密码不相同");
		obj.newpass.focus();
		return false;
	}
	if (obj.oldpass == "") {
		$.alert("请输入原始密码");
		obj.oldpass.focus();
		return false;
	}
	var oldMd5pass = $.md5(obj.oldpass.value);
	var newMd5pass = $.md5(obj.newpass.value);
	var confirm_Md5newpass = $.md5(obj.confirm_newpass.value);
	obj.oldpass.value = oldMd5pass;
	obj.newpass.value = newMd5pass;
	obj.confirm_newpass.value = confirm_Md5newpass;
	return true;
}
function changefuncpass(obj) {
	var newMd5pass = $.md5(obj.value);
	obj.value = newMd5pass;
}
$(function () {
	$("#tabs").tabs();
});
</script>
<div id="changeloginpass">
	<div id="tabs">
		<ul>
			<li><a href="#tabs-1">修改登陆密码</a></li>
			<li><a href="#tabs-2">修改提款密码</a></li>
		</ul>
		<div id="tabs-1">
			<form action="index.php" method="post" name="changepass" onsubmit="return checkform(this)">
				<table class="formTable" border="0" cellpadding="0" cellspacing="0" width="100%">
					<tbody>
						<tr>
							<th width="20%">输入旧登陆密码：</th>
							<td><input name="oldpass" id="oldpass" type="password"></td>
						</tr>
						<tr>
							<th>输入新登陆密码：</th>
							<td><input name="newpass" id="newpass" type="password"><span
								class="red">（由字母和数字组成6-16个字符） </span></td>
						</tr>
						<tr>
							<th>确认新登陆密码：</th>
							<td><input name="confirm_newpass" id="confirm_newpass"
								type="password"></td>
						</tr>
					</tbody>
				</table>
				<div align="center">
					<input name="" value="修改" class="formChange" type="submit">
					<input name="" value="重置" class="formReset" type="reset">
				</div>
				<input name="controller" value="user" type="hidden">
				<input name="action" value="changeloginpass" type="hidden">
				<input name="check" value="" type="hidden">
				<input name="flag" value="changepass" type="hidden">
				<input name="changetype" value="loginpass" type="hidden">
			</form>
			<span style="color: red">备注：请妥善保管好您的登录密码，如遗忘请使用您的提款密码重置</span>
		</div>

		<div id="tabs-2">
			<form action="index.php" method="post" name="changepass" onsubmit="return checkform(this)">
				<table class="formTable" border="0" cellpadding="0" cellspacing="0" width="100%">
					<tbody>
						<tr>
							<th width="20%">输入旧提款密码：</th>
							<td><input name="oldpass" type="password"></td>
						</tr>
						<tr>
							<th>确认新提款密码：</th>
							<td><input name="newpass" type="password"><span
								class="red">（由字母和数字组成6-16个字符,提款密码不能与登录密码相同） </span></td>
						</tr>
						<tr>
							<th>确认新提款密码：</th>
							<td><input name="confirm_newpass" type="password"></td>
						</tr>
					</tbody>
				</table>
				<div align="center">
					<input name="" value="修改" class="formChange" type="submit"><input
						name="" value="重置" class="formReset" type="reset">
				</div>
				<input name="controller" value="user" type="hidden"> <input
					name="action" value="changeloginpass" type="hidden"> <input
					name="check" value="" type="hidden"> <input name="flag"
					value="changepass" type="hidden"> <input name="changetype"
					value="secpass" type="hidden">
			</form>
			<span style="color: red">备注：请妥善保管好您的提款密码，如遗忘请使用密保功能找回或联系在线客服处理</span>
		</div>
	</div>
</div>

	<script type="text/javascript">
	$(document).ready(function(){
				});
	$(window).unload( function () {
		top.SetIframeHeight(0);
	});
</script>
	
</body></html>