<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=9">
<title>杏彩游戏平台  - 账户提款 </title>
<link href="../index_files/a_data/base.css" rel="stylesheet" type="text/css" media="all">
<link href="../index_files/a_data/subpage.css" rel="stylesheet" type="text/css" media="all">
<script type="text/javascript" src="../index_files/a_data/jquery-1.js"></script>
<script type="text/javascript" src="../index_files/a_data/tab.js"></script>

<script type="text/javascript" src="../index_files/jquery_006.js"></script>
<script type="text/javascript" src="../index_files/a_data/jquery.js"></script>
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
var minmoney=100,maxmoney=10000;
function checkForm(obj)
{
	var isok = true;
	if(obj.money<minmoney){
		jQuery("#money").siblings("span").html("※您提款金额小于100");
		isok = false;
	} else{
		jQuery("#money").siblings("span").html("");
	}

	if(obj.money>maxmoney){
		jQuery("#money").siblings("span").html("※您提款金额大于10000");
		isok = false;
	} else{
		jQuery("#money").siblings("span").html("");
	}

	if(obj.money>$("#coin").html()){
		jQuery("#money").siblings("span").html("※您提款金额大于可提款金额");
		isok = false;
	} else{
		jQuery("#money").siblings("span").html("");
	}
	
	if( obj.bankinfo.value <= 0 ){
		jQuery("#bankinfo").siblings("span").html("※您忘记了选择银行卡信息");
		isok = false;
	} else{
		jQuery("#bankinfo").siblings("span").html("");
	}
	return false;
	//return isok;
}
$(document).ready(function(){
	chagefunc();			
    $("#bankinfo").change(function (){
	chagefunc();
	
	});
});

 var chagefunc=function(){
							
        $("#minmoney").html(0);
		$("#maxmoneys").html(10000);
    };
    function bindKeyUp(iMax, available, i){
        $("#money").removeAttr("onkeyup");
        $("#money").unbind();
        $("#money").keyup(function(){
            checkWithdraw2(this,'chineseMoney',iMax,available);
        });
    }
    function checkWithdraw2(obj, chineseid, maxnum, available) {
    	obj.value = formatFloat(obj.value);
    	var temp = 0.00;
    	if (parseFloat(available) > parseFloat(maxnum)) {
    		temp = maxnum;
    	} else {
    		temp = available;
    	}
    	if (parseFloat(obj.value) > parseFloat(maxnum) && parseFloat(maxnum) < parseFloat(available)) {
    		top.$.alert("提现金额不能超过系统设定值");
    		obj.value = temp;
    	}
    	if (parseFloat(obj.value) > parseFloat(available)) {
    		top.$.alert("提现金额超出了可提现限额");
    		obj.value = temp;
    	}
    	jQuery("#" + chineseid).html(changeMoneyToChinese(obj.value));
    }

</script>
<form action="../members/saveplatwithdraw" method="post" name="drawform" onsubmit="return checkForm(this)">
<input name="controller" value="security" type="hidden">
<input name="action" value="platwithdraw" type="hidden">
<input name="flag" value="withdraw" type="hidden">
<input name="check" value="569" type="hidden">
<div class="right_02 d5d8de">

<div class="right_02_02"></div>
<div class="right_02_03">
<div>
        <span class="tab-front" id="general_tab_1">
		 <span id="notice2" style="color:red"> 
		</span><!--
		<span class="tab-back"  id="general_tab_0">
		  <span class="menu_01"></span>
		  <span class="menu_02" onclick="window.location.href='?controller=security&action=withdraw&check=569'">向上级提现</span>
		  <span class="menu_03"></span>
		</span>
-->
</span></div>
</div>
<div class="right_02_04 floatright"></div>
</div>
<div><table class="formTable" border="0" cellpadding="4" cellspacing="1" width="100%">
    
	<tbody><tr>
      <td style="color:#FF3300;" align="right" bgcolor="#CCCCCC" width="200">注意:</td>
      <td align="left" bgcolor="#CCCCCC">
      	每天限制提款 
      	<font style="font-size:16px;color:#FF3300;font-weight:bold;">3</font> 次，
      	您已成功提款 <font style="font-size:16px;color:#FF3300;font-weight:bold;" id="cashNo">0</font> 次 &nbsp;
      	提款时间为 <font style="font-size:16px;color:#FF3300;font-weight:bold;">10:00</font>至 <font style="font-size:16px;color:#FF3300;font-weight:bold;">02:00</font></td>
    </tr>
      <tr>    
      <td align="right" bgcolor="#CCCCCC">收款银行卡：</td>
      <td align="left" bgcolor="#CCCCCC">
      	<select name="bankinfo" id="bankinfo">
    		<option selected="selected" value="">请选择</option>
    	</select>&nbsp;&nbsp;<span style="color:red;"></span></td>

    </tr>
    <tr>
      <td align="right" bgcolor="#CCCCCC" width="200">用户名:</td>
      <td align="left" bgcolor="#CCCCCC" id="mname"></td>
      
    </tr>
    <tr>   
      <td align="right" bgcolor="#CCCCCC">可提款金额:</td>
      <td align="left" bgcolor="#CCCCCC" id="coin">0.00</td>

    </tr>
    <tr>
      <td align="right" bgcolor="#CCCCCC">提款金额:</td>
      <td align="left" bgcolor="#CCCCCC">
<input name="money" id="money" size="20" autocomplete="off" type="text">
(单笔最低提现金额：<font style="color:red;" id="minmoney">100</font>元，最高：<font id="maxmoneys" style="color:red;">100000</font>元)
<span style="color:red;"></span></td>
    </tr>
    <tr>  
      <td align="right">&nbsp;</td>
      <td align="left"><input name="submit" value="下一步" class="formNext" type="submit"></td>

    </tr>
    
  </tbody></table></div>
<div style="height:5px;">
<div class="right_02_24"></div>
<div class="right_02_25"></div>
</div>

</form>

</body></html>
<script type="text/javascript">
init();
	function init(){
		
		$.ajax({
			type:"POST",
			url:"../members/getBanks",
			contentType:"application/x-www-form-urlencoded;charset=UTF-8",
			success:function(data){
				mname.innerHTML = data.memberName;
				coin.innerHTML = data.coin;
				cashNo.innerHTML = data.cashNo;
				
				var arr = data.list;
				$("#bankinfo").find("option").remove();
				var len = arr.length;
				for (var i = 0; i < len; i++) {
						$("#bankinfo").append("<option value='" + arr[i].id+ "'>" + arr[i].bankName+"---******"+arr[i].account.substring(arr[i].account.length - 4) + "</option>");

				}
			}
		});
	}
</script>