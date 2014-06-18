<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=9">
<title>杏彩游戏平台  - 我的团队 </title>
<link href="../a_data/base.css" rel="stylesheet" type="text/css" media="all">
<link href="../a_data/subpage.css" rel="stylesheet" type="text/css" media="all">
<script type="text/javascript" src="../a_data/jquery-1.js"></script>
<script type="text/javascript" src="../a_data/tab.js"></script>

<script type="text/javascript" src="../jquery_006.js"></script>
<script type="text/javascript" src="../jquery_003.js"></script>
<link href="../a_data/dialogUI.css" media="all" type="text/css" rel="stylesheet">

<script type="text/javascript" src="../a_data/main.js"></script>
</head>

<body>
<script type="text/javascript">
//删除遮罩
if($("#laybox",parent.parent.document).length){
	$("#laybox",parent.parent.document).remove();
}
jQuery("document").ready( function(){
	$("#chineseMoney").html(changeMoneyToChinese(0.0000));
});
</script>
<div class="list-div" id="listDiv">
  <table class="formTable" id="list-table" align="center" cellpadding="3" cellspacing="1">
    <tbody><tr>
      <td align="right" width="150">帐号:</td>
      <td id="mname">sb1234a</td>
    </tr>
    <tr>
      <td align="right" width="150">团队余额:</td>
      <td colspan="3" id="totalMoney">0.0000&nbsp;&nbsp;元</td>
    </tr>
    <tr>
      <td align="right" width="150">团队余额(大写):</td>
      <td colspan="3"><span id="chineseMoney"></span></td>
    </tr>
  </tbody></table>
</div>


</body></html>
<script type="text/javascript">
init();
function init(lotteryid,groupid){
	var rq_post={};
	$.ajax({
		type:"POST",
		url:"../../members/getTotalMoney",
		contentType:"application/x-www-form-urlencoded;charset=UTF-8",
		success:function(data){
			mname.innerHTML = data.mname;
			totalMoney.innerHTML = moneyFormat(data.totalMoney);
			$("#chineseMoney").html(changeMoneyToChinese(data.totalMoney));
		}
	});
	}
</script>