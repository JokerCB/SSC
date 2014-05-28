<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=9">
<title>杏彩游戏平台 - 增加用户</title>
<link href="../a_data/base.css" rel="stylesheet" type="text/css" media="all">
<link href="../a_data/subpage.css" rel="stylesheet" type="text/css" media="all">
<script type="text/javascript" src="../a_data/jquery-1.js"></script>
<script type="text/javascript" src="../a_data/tab.js"></script>
<script type="text/javascript" src="../a_data/jquery_005.js"></script>
<script type="text/javascript" src="../a_data/jquery_003.js"></script>
<link href="../a_data/dialogUI.css" media="all" type="text/css"
	rel="stylesheet">
<script type="text/javascript" src="../a_data/main.js"></script>
</head>
<body>
	<a name="topall"></a>
	<!--消息框代码开始-->
	<script type="text/javascript" src="../a_data/jquery_002.js"></script>
	<script type="text/javascript" src="../jquery_003.js"></script>
	<link href="../a_data/dialogUI.css" media="all" type="text/css" rel="stylesheet">
	<!--消息框代码结束-->
	 <form action="" method="post" name="updateform" style="height: auto;">
		<input name="flag" value="insert" type="hidden">
		<input name="controller" value="user" type="hidden">
		<input name="action" value="adduser" type="hidden">
		<table class="formTable" cellpadding="0" cellspacing="0" border="0"
			width="100%">

			<tbody>
				<tr>
					<td colspan="2">
						用户类型：
						<input name="mtype" value="1" checked="checked" type="radio">代理 &nbsp; &nbsp; &nbsp;
						<input name="mtype" value="0" type="radio">会员用户
					</td>

				</tr>
				<tr>
					<td width="11%">用户名：</td>
					<td colspan="2">
						<input name="mname" id="mname" onblur="checkUser(this.value)" onclick="$('#userchk').html('')" type="text">
						<span class="red">(由字母或数字组成的6-16个字符,不能连续四位相同的字符,首字不能以0或者o开头)</span>
					<p id="userchk"></p></td>
				</tr>
			</tbody>
		</table>
		<div id="lotteriesform">
			<h4 class="dotTitle">
				<span class="st">·</span>快速返点设置
			</h4>
			<table class="formTable" cellpadding="0" cellspacing="0" border="0"
				width="100%">
				<tbody>
					<tr>
						<th width="40%">自身保留返点：</th>
						<td>
							<input type="text" class="fandianinput" size="4" name="keeppoint" id="keeppoint" />
								<!-- onkeyup="clearNoNum(this);onekey_keeppoint_unalert()" 
								onchange="clearNoNum(this)" onblur="checkNum(this)"-->
							(自身最高保留 <span style="display: none" id="keeppoint_min">0.1</span>
							<span style="display: none" id="keeppoint_max">9.6</span> )
							<input type="button" onclick="checkRapid();" class="formWord" value="确认返点" id="keeppoint_submit" />
								<!-- onclick="return(onekey_keeppoint());" > -->
						</td>
					</tr>
				</tbody>
			</table>
			<div class="line10px"></div>
			<div id="allbackset" class="overflowHidden" style="display: block;">
				<!--span style="float:right"><a href='#' onclick="kuaijiexuanxiang1();return(false);" class="underline">返点全满</a> | <a href="#" class="underline" onclick='kuaijiexuanxiang3();return(false);'>返点清零</a></span-->
				<table class="grayTable" cellpadding="0" cellspacing="0" border="0"
					width="100%">
					<tbody>
						<tr>
							<th style="border-left: 1px solid rgb(213, 216, 222);">彩种</th>
							<th>赔率</th>
							<th>
								<!--input type="text" class="fandianinput" size="4" value="0" name="accord_lottery_point" id="accord_lottery_point">% 
                    <input type="button" name="accordbutton" id="accord_lottery_button" class="formWord" value="统一设置"-->
							</th>
							<th>
								<!--input type="text" class="fandianinput" value="0" size="4" name="accord_indefinite_point" id="accord_indefinite_point">% 
                    <input type="button" name="accordbutton" class="formWord" id="accord_indefinite_button" class="buttonnormal_01" value="统一设置"-->
							</th>
						</tr>
						<script language="javascript">
			                var lotteryinfo = [];
			            </script>
						<tr>
							<td style="padding: 3px; font-size: 14px; font-weight: bold;"
								bgcolor="#CCCCCC" height="37">时时彩</td>
							<td style="padding: 3px;" bgcolor="#CCCCCC">&nbsp;</td>
							<td style="padding: 3px; font-size: 14px; font-weight: bold;"
								align="left" bgcolor="#CCCCCC">所有玩法返点</td>
							<td style="padding: 3px; font-size: 14px; font-weight: bold;"
								align="left" bgcolor="#CCCCCC">不定位返点</td>
						</tr>
						<tr>
							<td class="left_noindent" style="border-left: 1px solid rgb(239, 239, 239);"><label>
							<input size="4" style="display: none;" checked="checked"
									name="lottery[]" id="lottery_1" value="1" type="checkbox">重庆时时彩</label></td>
							<td class="left_noindent">&nbsp; <input name="pg_1"
								value="37" type="hidden"> 1800
							</td>
							<td class="left_noindent">&nbsp;
								<input style="border: none;" size="20" onblur="checkFandian(this);" id="mfandian_cqssc" name="mfandian" type="text">%
								<span id="fd_span_cqssc"></span>
							</td>
							<td class="left_noindent" style="padding: 3px;" bgcolor="#CCCCCC">&nbsp;
								<input style="border: none; size="20" onblur="checkFandian(this);" id="mfandianbdw_cqssc" name="mfandianbdw" type="text">%
								<span id="fdbdw_span_cqssc"></span>

							</td>
						</tr>
						<tr>
							<td style="padding: 3px; font-size: 14px; font-weight: bold;"
								bgcolor="#CCCCCC" height="37">11选5</td>
							<td style="padding: 3px;" bgcolor="#CCCCCC">&nbsp;</td>
							<td style="padding: 3px; font-size: 14px; font-weight: bold;"
								align="left" bgcolor="#CCCCCC">所有玩法返点</td>
							<td style="padding: 3px; font-size: 14px; font-weight: bold;"
								align="left" bgcolor="#CCCCCC"></td>
						</tr>
						<tr>
							<td style="padding: 3px; font-size: 14px; font-weight: bold;"
								bgcolor="#CCCCCC" height="37">快乐彩</td>
							<td style="padding: 3px;" bgcolor="#CCCCCC">&nbsp;</td>
							<td style="padding: 3px; font-size: 14px; font-weight: bold;"
								align="left" bgcolor="#CCCCCC">所有玩法返点</td>
							<td style="padding: 3px; font-size: 14px; font-weight: bold;"
								align="left" bgcolor="#CCCCCC"></td>
						</tr>
					</tbody>
				</table>
			</div>
			<!--/form-->
		</div>
	</form>
</body>
</html>
<script type="text/javascript">
var fandian = top.top.fandian;
var fandianbdw = top.top.fandianbdw;
// 提交验证
function checkRapid(){
	if(!this.mname.value){
		$.alert("用户名不能为空！");
		return false;
	}
	if(!this.mfandian_cqssc.value)
		{
		$.alert('返点不能为空！');
		return false;
		}
	if(!this.mfandianbdw_cqssc.value){
		$.alert('返点不能为空！');
		return false;
	}
	var rq_post={};
    rq_post['mname']= $("#mname").val();
    rq_post['mfandian']=$("#mfandian_cqssc").val();
    rq_post['mfandianbdw']=$("#mfandianbdw_cqssc").val();
	rq_post['Submit']='json'; 
	$.ajax({
		type:"POST",
		url:"../../members/addUser",
		data:rq_post,
		contentType:"application/x-www-form-urlencoded;charset=UTF-8",
		success:function(data){
			console.log(data);
			var json = eval('(' + data + ')');
			$.alert(json['sMsg']);			 
			$("#mname").val("");
		    $("#mfandian_cqssc").val("");
		    $("#mfandianbdw_cqssc").val("");
		}
	});
}

// 验证用户名
function checkUser(obj){
	
}
// 验证返点值
function checkFandian(obj){
	var minfd = top.top.fandian>top.top.fandianbdw ? top.top.fandianbdw : top.top.fandian;
	if(!checkNum(obj.value)){
		$.alert("请输入数字！");
		obj.value = 0;
		return false;
	}

	if(parseFloat(obj.value)>parseFloat(minfd)){
		$.alert("输入的返点值不能大于最高返点值！");
		return false;
	}
	
}

function checkNum(num){
	return (/^[0-9]+(.[0-9]{1,2})?$/.test(num));
}

$(document).ready(function(){
	$("span[id^=fd_span]").html("(范围：0～"+top.top.fandian+"%)");
	$("span[id^=fdbdw_span]").html("(范围：0～"+top.top.fandianbdw+"%)");
	$("#keeppoint").keyup(function(){
		var $this = $(this);
		var fandian = top.top.fandian;
		var fandianbdw = top.top.fandianbdw;
		if((!checkNum($this.val()))){
			$("#mfandian_cqssc").attr("value", fandian);
			$("#mfandianbdw_cqssc").attr("value", fandianbdw);
		} else {
			$("#mfandian_cqssc").attr("value", parseFloat($this.val()-fandian)>0 ? 0 : parseFloat(fandian-$this.val()).toFixed(1));
			$("#mfandianbdw_cqssc").attr("value", parseFloat($this.val()-fandianbdw)>0 ? 0 : parseFloat(fandianbdw-$this.val()).toFixed(1));
		}
	});
}); 
</script>
