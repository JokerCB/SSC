<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=9">
<title>杏彩游戏平台  - 卡号绑定 </title>
<link href="../index_files/a_data/base.css" rel="stylesheet" type="text/css" media="all">
<link href="../index_files/a_data/subpage.css" rel="stylesheet" type="text/css" media="all">
<script type="text/javascript" src="../index_files/a_data/jquery-1.js"></script>
<script type="text/javascript" src="../index_files/a_data/tab.js"></script>

<script type="text/javascript" src="../index_files/jquery_006.js"></script>
<script type="text/javascript" src="../index_files/jquery_003.js"></script>
<link href="../index_files/a_data/dialogUI.css" media="all" type="text/css" rel="stylesheet">

<script type="text/javascript" src="../index_files/a_data/main.js"></script>
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
jQuery("document").ready(function () {

	addclik();
	$("#bank").change(addclik);
	// 检查呢称
	test = function () {
		var nickname = $("#nickname").val();
		if (nickname != "") { // 如果呢称不为空时才检查
			$("#msg").html("正在提交检查，请等待...");
			$.ajax({
				type : "POST",
				url : '?controller=security&action=adduserbank',
				data : 'flag=checkname&nickname=' + nickname + "&id=193391",
				success : function (data) {
					if (data == -1) {
						$("#msg").html("<font color='red'>您填写的别名不正确，别名由1至4个字符或汉字组成，不能使用特殊字符</font>");
					} else if (data) {
						$("#msg").html("<font color='red'>您填写的别名已存在，请更换一个</font>");
					} else {
						$("#msg").html("<font color='green'>您填写的别名还未使用过，请放心使用，别名由1至4个字符或汉字组成，不能使用特殊字符</font>");
					}
				}
			});
		} else {
			$("#msg").html("(由1至4个字符或汉字组成)");
		}
	}
});

// 获取对应的城市列表
function changeCity() {
	var ProvinceId = document.getElementById("province").value;
	var bank_args = $("#bank").val().indexOf('财付通');
	if (bank_args == 3) {
		return true;
	}
	$.ajax({
		type : "POST",
		url : '../members/getCity',
		data : 'provinceId=' + ProvinceId,
		success : function (data) {
			$("#city").empty();
			var cityhtml="";
			$.each(data.pageInfo.dataList, function(i, v){
				cityhtml += "<option value='"+v.fid+"'>"+v.fname+"</option>";
			});
			$("#city").html(cityhtml);
		}
	});
}

// 不允许输入特殊字符
function exceptSpecial(obj) {
	obj.value = obj.value.replace(/[\<\>\~\!\@\#\$\%\^\&\*\-\+\=\|\\\'\?\,\.\/\[\]\{}\(\)\"]{1,}/, '');
}
//姓名特殊字符过滤
function exceptSpecialName(obj) {
	obj.value = obj.value.replace(/[\<\>\~\!\@\#\$\%\^\&\*\-\+\=\|\\\'\?\,\/\[\]\{}\(\)\"]{1,}/, '');
}

function checkform(obj) {

	var repSpecial = /[\<\>\~\!\@\#\$\%\^\&\*\-\+\=\|\\\'\"\?\,\.\/\[\]\{}\(\)]{1,}/;
	var bank = document.getElementById("bank");
	if (bank.value == "") {
		$("#bank_msg").html("您忘记了选择开户银行！");
		bank.focus();
		return false;
	}
	var province = document.getElementById("province");
	if (province.value == "") {
		$("#province_msg").html("您忘记了选择开户银行！");
		province.focus();
		return false;
	}
	var city = document.getElementById("city");
	if (city.value == "") {
		$("#city_msg").html("您忘记了选择开户银行城市！");
		city.focus();
		return false;
	}
	var re = /^(.){1,20}$/;
	if (!re.test(obj.branch.value) || repSpecial.test(obj.branch.value)) {
		$("#branch_msg").html("支行名称不符合规则，请重新输入！");
		$("#branch_msg").attr("style", "color:#ff3300");
		obj.branch.focus();
		return false;
	}
	//var re = /[^\u4e00-\u9fa5]/;
	var re = /^[\u4e00-\u9fa5]+[·|.|。]?[\u4e00-\u9fa5]+$/;
	if (!re.test(obj.account_name.value)) {
		$("#account_name_msg").html("您填写的开户人姓名不符合规则，请重新输入！");
		$("#account_name_msg").attr("style", "color:#ff3300");
		obj.account_name.focus();
		return false;
	}
	var account = document.getElementById("account");
	if (account.value == "") {
		$("#account_msg").html("您忘记了填写银行账号！");
		$("#account_msg").attr("style", "color:#ff3300");
		account.focus();
		return false;
	}
	var re = /^\d{16}$|^\d{19}$/;
	var account = document.getElementById("account");
	if (!re.test(account.value)) {
		$("#account_msg").html("您填写的卡号格式不正确，请检查！");
		$("#account_msg").attr("style", "color:#ff3300");
		account.focus();
		return false;
	}
	var account_again = document.getElementById("account_again");
	if (account.value != account_again.value) {
		$("#account_again_msg").html("您两次填写的银行账号不相同，请核对后重新提交！");
		$("#account_again_msg").attr("style", "color:#ff3300");
		account_again.focus();
		return false;
	}
}
function checkform2(obj) {

	var repSpecial = /[\<\>\~\!\@\#\$\%\^\&\*\-\+\=\|\\\'\"\?\,\.\/\[\]\{}\(\)]{1,}/;

	var bank = document.getElementById("bank");
	if (bank.value == "") {
		$("#bank_msg").html("您忘记了选择开户银行！");
		bank.focus();
		return false;
	}
	//var re = /^(.){1,10}$/;
	//var re = /^[\u4e00-\u9fa5]{2,9}$/ig;
	var re = /[^\u4e00-\u9fa5]/;
	//if( re.test(obj.account_name.value) || repSpecial.test(obj.account_name.value) || obj.account_name == ""){
	if (re.test(obj.account_name.value)) {
		$("#account_name_msg").html("您填写的财付通姓名不符合规则，请重新输入！");
		$("#account_name_msg").attr("style", "color:#ff3300");
		obj.account_name.focus();
		return false;
	}
	var account = document.getElementById("account");
	if (account.value == "") {
		$("#account_msg").html("您忘记了填写财付通账号！");
		$("#account_msg").attr("style", "color:#ff3300");
		account.focus();
		return false;
	}

	//var re= /^\d{5,15}$|^([a-zA-Z0-9-]+)\@([a-zA-Z0-9]+)\.([\w]+)$/;
	var re = /^\d{5,15}$/;
	var account = document.getElementById("account");
	if (!re.test(account.value)) {
		$("#account_msg").html("您填写的财付通账号格式不正确，请检查！");
		$("#account_msg").attr("style", "color:#ff3300");
		account.focus();
		return false;
	}
	var account_again = document.getElementById("account_again");
	if (account.value != account_again.value) {
		$("#account_again_msg").html("您两次填写的财付通账不相同，请核对后重新提交！");
		$("#account_again_msg").attr("style", "color:#ff3300");
		account_again.focus();
		return false;
	}
}
</script>
	<form action="" method="post" name="addform">
		<input name="flag" value="add" type="hidden">
		<input name="controller" value="security" type="hidden">
		<input name="action" value="adduserbank" type="hidden">
		<input name="oldid" value="" type="hidden">
		<div class="right_02 d5d8de" style="width: 98%;">
			<div class="height5">
				<div class="right_02_28"></div>
				<div class="right_02_29"></div>
			</div>
			<div>
				<table class="formTable" border="0" cellpadding="4" cellspacing="1"
					width="100%">
					<tbody>
						<tr>
							<td class="narrow-label" style="color: #FF3300" align="right">提示:</td>
							<td style="color: #FF3300" align="left">*为必填信息,银行卡绑定后需要删除或者解绑请提供充值截图,联系您的上级,由上级提交平台申请解绑！</td>
						</tr>
						<tr>
							<td class="narrow-label" align="right" bgcolor="#CCCCCC"><font
								style="color: #FF3300; font-size: 18px; font-family: Arial, Helvetica, sans-serif;">*</font>开户银行:</td>
							<td align="left" bgcolor="#CCCCCC">
								<select name="bank" id="bank">
									<option selected="selected" value="">请选择...</option>
									<c:forEach var="bankList" items="${bankList}">
										<option value="${bankList.id }">${bankList.name }</option>
									</c:forEach>
								</select>&nbsp;&nbsp;&nbsp;
								<span id="bank_msg" style="color: #ff3300"></span>
							</td>
						</tr>

						<tr>
							<td class="narrow-label" align="right" bgcolor="#CCCCCC"><font
								style="color: #FF3300; font-size: 18px; font-family: Arial, Helvetica, sans-serif;">*</font>开户银行省份:</td>

							<td align="left" bgcolor="#CCCCCC">
								<select name="province" id="province" onchange="changeCity();">
									<option selected="selected" value="">请选择</option>
									<c:forEach var="provinceList" items="${provinceList}">
										<option value="${provinceList.fid }">${provinceList.fname }</option>
									</c:forEach>
								</select> &nbsp;&nbsp;
								<span style="color: red;" id="province_msg"></span>
							</td>
						</tr>
						<tr>
							<td class="narrow-label" align="right" bgcolor="#CCCCCC">
								<font style="color: #FF3300; font-size: 18px; font-family: Arial, Helvetica, sans-serif;">*</font>开户银行城市:</td>
							<td align="left" bgcolor="#CCCCCC">
								<select name="city" id="city">
									<option selected="selected" value="">请选择</option>
								</select>&nbsp;&nbsp;
								<span style="color: red;" id="city_msg"></span></td>
						</tr>

						<tr>
							<td class="narrow-label" align="right" bgcolor="#CCCCCC">
								<font style="color: #FF3300; font-size: 18px; font-family: Arial, Helvetica, sans-serif;">*</font>支行名称:</td>
							<td align="left" bgcolor="#CCCCCC">
								<input name="branch" maxlength="20" id="branch" onkeyup="exceptSpecial(this);"
									onchange="exceptSpecial(this);" type="text">
								<span id="branch_msg">(由1至20个字符或汉字组成，不能使用特殊字符)</span></td>
						</tr>
						<tr>
							<td class="narrow-label" align="right" bgcolor="#CCCCCC">
								<font style="color: #FF3300; font-size: 18px; font-family: Arial, Helvetica, sans-serif;">*</font>
								<span id="khxm">开户人姓名</span>:</td>
							<td align="left" bgcolor="#CCCCCC">
								<input name="account_name" maxlength="10" id="account_name" onkeyup="exceptSpecialName(this);"
									onchange="exceptSpecialName(this);" type="text">
								<span id="account_name_msg">（请填写您的真实姓名，只能是中文字符，支持以下姓名分隔符"·"".""。"）</span>
							</td>
						</tr>
						<tr>
							<td class="narrow-label" align="right" bgcolor="#CCCCCC">
								<font style="color: #FF3300; font-size: 18px; font-family: Arial, Helvetica, sans-serif;">*</font>
								<span id="khzh">银行卡号</span>:</td>
							<td align="left" bgcolor="#CCCCCC">
								<input name="account" id="account" style="width: 200px;" type="text">
								<span id="account_msg">(银行卡卡号由16位或19位数字组成)</span></td>
						</tr>
						<tr>
							<td class="narrow-label" align="right" bgcolor="#CCCCCC">
								<font style="color: #FF3300; font-size: 18px; font-family: Arial, Helvetica, sans-serif;">*</font>确认账号:</td>
							<td align="left" bgcolor="#CCCCCC">
								<input name="account_again" id="account_again" onpaste="return false" style="width: 200px;" type="text">
								<span id="account_again_msg">(银行账号只能手动输入，不能粘贴)</span></td>
						</tr>
						<tr>
							<td align="right" bgcolor="#CCCCCC"></td>
							<td align="left" bgcolor="#CCCCCC">
								<input name="submit" value="下一步" class="buttonnormal" type="submit">
								<input value="返回" onclick="history.back();" class="buttonnormal" type="button"></td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="height5">
				<div class="right_02_24"></div>
				<div class="right_02_25"></div>
			</div>
		</div>
	</form>
<script type="text/javascript">
var addclik = function () {
	var bank_args = $("#bank").val().indexOf('财付通');
	var Trobj = $(".formTable tr");
	if (bank_args == 3) {
		$("#khxm").html("财付通姓名");
		$("#khzh").html("财付通帐号");
		$("#account_msg").html("");
		$("#account_again_msg").html("");

		$("form").unbind("submit");
		$("form").bind("submit", function () {
			return checkform2(this);
		});
		Trobj.each(function (i) {

			if (i == 2 || i == 3 || i == 4)
				$(this).hide();
		});
	} else {
		$("#khxm").html("开户人姓名");
		$("#khzh").html("银行卡号");
		$("#account_msg").html("(银行卡卡号由16位或19位数字组成)");
		$("#account_again_msg").html("(银行账号只能手动输入，不能粘贴)");

		$("form").unbind("submit");
		$("form").bind("submit", function () {
			return checkform(this);

		});
		//  $("form").bind("submit",checkform2($(this)))
		Trobj.each(function (i) {

			if (i == 2 || i == 3 || i == 4)
				$(this).show();
		});
	}
};
</script>
</body></html>