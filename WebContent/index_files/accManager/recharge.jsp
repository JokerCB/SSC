<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=9">
<title>杏彩游戏平台  - 易宝支付充值 </title>
<link href="../a_data/base.css" rel="stylesheet" type="text/css" media="all">
<link href="../a_data/subpage.css" rel="stylesheet" type="text/css" media="all">
<script type="text/javascript" src="../a_data/jquery-1.js"></script>
<script type="text/javascript" src="../a_data/tab.js"></script>

<script type="text/javascript" src="../a_data/jquery_005.js"></script>
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
<a name="topall"></a>
<div style="display:none;"><a href="http://www.live800.com/">客服</a></div>
<div style="display:none;"><a href="http://en.live800.com/">live chat</a></div><!--消息框代码开始-->
<script type="text/javascript" src="../a_data/jquery_005.js"></script>
<script type="text/javascript" src="../jquery_003.js"></script>
<link href="../a_data/dialogUI.css" media="all" type="text/css" rel="stylesheet">

<!--消息框代码结束-->

<script type="text/javascript">
	var result = 0;
	function checkForm(obj)
	{
		if (obj.bid.value <= 0){
			$.alert("请选择充值银行");
			return false;
		}
		if (result > 0){
			if (result == 1){
				$.alert("您现有建行卡为重复绑定，请更换存款银行或绑定新的建行卡");
				return false;
			} else if (result == 2){
				alert("您尚未绑定建行银行卡，请绑定");
				gotolink("卡号绑定");
				self.location="/?controller=security&action=userbankinfo";
				return false;
			}
		}
		if (obj.amount.value == ""){
			$.alert("请输入限定内金额！");
			obj.amount.focus();
			return false;
		}
		var loadmin = document.getElementById("alertmin").value;
		if(parseInt(obj.amount.value,10) < parseInt(loadmin,10))
		{
			alert("充值金额不能低于最低充值限额 ");
			$("#amount").val(loadmin);
			$("#chineseMoney").html( changeMoneyToChinese(loadmin) );
			return false;
		}
		
		if( $("#2tips").attr('data') == '1')
		{
			alert('如果您的浏览器提示充值跳转页面存在未经证实信息网站或非法网站等类似信息，请您不要关闭页面，忽略警告，放心点击继续访问');
		}
	}

	function changeInfo(obj){
		var bankinfo = new Array();
		bankinfo = {"espay":{"loadmax":"40000","loadmin":"10","id":"24","logo":"espay"}};
		var loadmax = document.getElementById("loadmax");
		var loadmin = document.getElementById("loadmin");
		var alertmin = document.getElementById("alertmin");
		var bid		= document.getElementById("bid");
		
		loadmax.innerHTML = bankinfo[obj.value]['loadmax'];
		loadmin.innerHTML = bankinfo[obj.value]['loadmin'];
		alertmin.value = bankinfo[obj.value]['loadmin'];
		bid.value = bankinfo[obj.value]['id'];
		
		document.getElementById("amount").onkeyup = function(){
			checkemailWithdraw(this,'chineseMoney',bankinfo[obj.value]['loadmax']);
		}
		var bank_name="";
		if(obj.value =='ccb'){
			
			bank_name='建行卡';
		}
		else
			bank_name='农行卡';
		// 只有建行才显示用户选卡下拉框
		if (obj.value == "ccb" || obj.value== 'abc'){
			var allexist = 1;
			// 是否全部重复
			if (allexist == 1){
				alert("您现有"+bank_name+"为重复绑定，请更换存款银行或绑定新的建行卡");
				result = 1;
				return false;
			}
			var isHave = 0;
			if (isHave == 0){
				alert("您尚未绑定"+bank_name+"，请绑定");
				gotolink("卡号绑定");
				self.location="/?controller=security&action=userbankinfo";
				result = 2;
				return false;
			}
			//document.getElementById("selectbank").style.display = "";
		} else {
			//document.getElementById("selectbank").style.display = "none";
		}
	}

	function checkbindin(obj){
		var banklist = new Array();
		var tbids =$("#bid").val();
		banklist = null;
		if(tbids == 9){
		if (banklist[obj.value] == 1){
			alert("您选择的建行卡重复绑定，请选择另一张");
			obj[0].selected = true;
		}
		}
	}
	
	function gotolink(string){
		var t = window.top;
	    $.each(t.$("#leftframe").contents().find(".menu_05"),function(){
	        if($(this).find("a").html() == string){
	            t.$("#leftframe").contents().find(".menu_05_05").attr("class",'menu_05');
	            $(this).addClass('menu_05_05');
	        }
	    });
	}

</script>

<div id="point">平台填写金额应当与网银汇款金额完全一致，否则将无法即时到帐！<a href=""><span style="color:red;float:right;margin-right:20px;">点击查看存款帮助</span></a></div>
     
     <form action="" method="post" name="drawform" id="drawform" onsubmit="return checkForm(this)">
		<input name="controller" value="emaildeposit" type="hidden">
		<input name="action" value="chongzhi" type="hidden">
		<input name="flag" value="load" type="hidden">
		<input name="bid" id="bid" value="24" type="hidden">
       
            <table class="formTable" border="0" cellpadding="0" cellspacing="0" width="100%">
              <tbody>
              <tr>
                <th width="20%">充值银行：</th>
                <td><select name="bank" id="bank">
                			
    		    </select>&nbsp;&nbsp;&nbsp;<span id="bank_msg" style="color:#ff3300"></span></td>
              </tr>            
              <tr>
                <th>充值金额：</th>
                <td><input name="amount" id="amount" size="20" onblur="checkMoney(this);" autocomplete="off" type="text">
                <span class="red">&nbsp;&nbsp;(单笔充值限额：最低 <span id="loadmin">10</span>,最高 <span id="loadmax">40000</span>)
                <input name="alertmin" id="alertmin" value="10" type="hidden"></span></td>
              </tr>			

            </tbody></table>
				<div id="2tips" data="1"></div>
		          <div align="center"><input name="next" onclick="goNext();" value="下一步" class="formNext" type="bottom"></div>
       
        </form>
        
        <div id="bankDiv" style="display:none;">
        	<table class="formTable" border="0" cellpadding="0" cellspacing="0" width="100%">
              <tbody>
              <tr>
                <th width="20%">充值银行：</th>
                <td><a href="https://mybank.icbc.com.cn/" target="_blank"><img alt="" src="../../images/bank-icons/bank-gh.jpg" ></a></td>
              </tr>
              
              <tr>
			  	<th width="20%">收款人户名：</th></td>
			    <td align="left">
					<span id="bankName">张三</span>
					<button>复制</button>
			    </td>
			    
			  </tr>
			   <tr>
			  	<th width="20%">收款人帐号：</th></td>
			    <td align="left">
					<span id="bankNum">6666666666666</span>
					<button>复制</button>
			    </td>
			  </tr>
              <tr>
                <th>充值金额：</th>
                <td>
	                <span id="money">0.00</span>
	                <button>复制</button>
                </td>               
              </tr>
               <tr>
                <th>充值编号：</th>
                <td>
	                <span id="rechargeNo"></span>
	                <button>复制</button>
                </td>               
              </tr>

            </tbody></table>
        </div>
   
<script  type="text/javascript">

init();
function init(){
	var bank = document.getElementById("bank");
	bank.options.length=0; 
	bank.options.add(new Option("中国工商银行",1)); 
	bank.options.add(new Option("中国招商银行",2)); 
	bank.options.add(new Option("中国建设银行",3)); 
/**
	$.ajax({
		type:"POST",
		url:"../../members/addUser",
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
	**/
}

function goNext(){
	if(amount.value == ""){
		$.alert("充值金额金额不能为空");
		return false;
	}
	if(parseFloat(amount.value)<parseFloat(loadmin.innerHTML)){
		$.alert("充值金额金额不能低于最低金额");
		return false;
	}
	
	var rq_post={};
    rq_post['amount']= $("#amount").val();
    rq_post['banklistId']=$("#bank").val();
	$.ajax({
		type:"POST",
		url:"../../recharge/save",
		data:rq_post,
		contentType:"application/x-www-form-urlencoded;charset=UTF-8",
		success:function(data){
			console.log(data);
			rechargeNo.innerHTML = data;			
		}
	});
	
	drawform.style.display = "none";
	bankDiv.style.display = "block";
	money.innerHTML = moneyFormat(amount.value);
}

function checkMoney(obj){
	
	if(!checkNum(obj.value)){
		$.alert("请输入数字！");
		obj.value = 0;
		return false;
	}

	if(parseFloat(obj.value)>parseFloat(loadmax.innerHTML)){
		obj.value = loadmax.innerHTML;
		return false;
	}
	
	if(parseFloat(obj.value)<parseFloat(loadmin.innerHTML)){
		obj.value = loadmin.innerHTML;
		return false;
	}
}

function checkNum(num){
	return (/^[0-9]+(.[0-9]{1,2})?$/.test(num));
}
</script>
   
 
</body></html>