<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=9">
<title>杏彩游戏平台  - 易宝支付充值 </title>
<link href="../index_files/a_data/base.css" rel="stylesheet" type="text/css" media="all">
<link href="../index_files/a_data/subpage.css" rel="stylesheet" type="text/css" media="all">
<script type="text/javascript" src="../index_files/a_data/jquery-1.js"></script>
<script type="text/javascript" src="../index_files/a_data/tab.js"></script>

<script type="text/javascript" src="../index_files/a_data/jquery_005.js"></script>
<script type="text/javascript" src="../index_files/a_data/jquery_003.js"></script>
<link href="../index_files/a_data/dialogUI.css" media="all" type="text/css" rel="stylesheet">

<script type="text/javascript" src="../index_files/a_data/main.js"></script>
</head>

<body>

<a name="topall"></a>
<div style="display:none;"><a href="http://www.live800.com/">客服</a></div>
<div style="display:none;"><a href="http://en.live800.com/">live chat</a></div><!--消息框代码开始-->
<script type="text/javascript" src="../index_files/a_data/jquery_005.js"></script>
<script type="text/javascript" src="../index_files/jquery_003.js"></script>
<link href="../index_files/a_data/dialogUI.css" media="all" type="text/css" rel="stylesheet">

<!--消息框代码结束-->


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
                <td><a id="bankHome" href="https://mybank.icbc.com.cn/" target="_blank"><img id="bankLogo" alt="" src="../images/bank-icons/bank-gh.jpg" ></a></td>
              </tr>
              
              <tr>
			  	<th width="20%">收款人户名：</th></td>
			    <td align="left">
					<span id="username">张三</span>
					<button id="copy">复制</button>
			    </td>
			    
			  </tr>
			   <tr>
			  	<th width="20%">收款人帐号：</th></td>
			    <td align="left">
					<span id="bankNum">6666666666666</span>
					<button id="copy">复制</button>
			    </td>
			  </tr>
              <tr>
                <th>充值金额：</th>
                <td>
	                <span id="money">0.00</span>
	                <button id="copy">复制</button>
                </td>               
              </tr>
               <tr>
                <th>充值编号：</th>
                <td>
	                <span id="rechargeNo"></span>
	                <button id="copy">复制</button>
                </td>               
              </tr>

            </tbody></table>
        </div>
   
<script  type="text/javascript">

$(function(){
    $("#copy").click(function(){

    }); 
}); 

init();
function init(){
	var bank = document.getElementById("bank");
	bank.options.length=0; 
//	bank.options.add(new Option("中国工商银行",1)); 
//	bank.options.add(new Option("中国招商银行",2)); 
//	bank.options.add(new Option("中国建设银行",3)); 

	$.ajax({
		type:"POST",
		url:"../recharge/findAdminBanks",
		contentType:"application/x-www-form-urlencoded;charset=UTF-8",
		success:function(data){
			var arr = data.list;
			var len = arr.length;
			for (var i = 0; i < len; i++) {
					$("#bank").append("<option value='" + arr[i].id+ "' username='"+arr[i].username+"' account='"+arr[i].account+"' home='"+arr[i].home+"'  logo='"+arr[i].logo+"'>" + arr[i].name + "</option>");

			}
		}
	});

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
		url:"../recharge/save",
		data:rq_post,
		contentType:"application/x-www-form-urlencoded;charset=UTF-8",
		success:function(data){
			rechargeNo.innerHTML = data;			
		}
	});

	var bank = document.getElementById("bank");
	var index = bank.selectedIndex; // 选中索引

	drawform.style.display = "none";
	bankDiv.style.display = "block";
	//bankName.innerHTML = bank.options[index].text;
	bankLogo.src = $(bank.options[index]).attr("logo");
	bankHome.href = $(bank.options[index]).attr("home");
	username.innerHTML = $(bank.options[index]).attr("username");
	bankNum.innerHTML = $(bank.options[index]).attr("account");
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

var copyCode = function (id) {

	try {
		var clipBoardContent = jQuery("#" + id).html();
		window.clipboardData.setData("Text", clipBoardContent);
		var title = jQuery("#" + id).html();

		alert("【" + title + "】复制成功!");
	} catch (e) {
		alert('您的firefox安全限制限制您进行剪贴板操作，请打开’about:config’将signed.applets.codebase_principal_support’设置为true’之后重试！');
	}
};
</script>
   
 
</body></html>