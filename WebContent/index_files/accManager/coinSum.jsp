<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=9">
<title>杏彩游戏平台  - 查询余额 </title>
<link href="../a_data/base.css" rel="stylesheet" type="text/css" media="all">
<link href="../a_data/subpage.css" rel="stylesheet" type="text/css" media="all">
<script type="text/javascript" src="../a_data/jquery-1.js"></script>
<!-- <script type="text/javascript" src="../a_data/tab.js"></script>

<script type="text/javascript" src="../a_data/jquery_005.js"></script>
<script type="text/javascript" src="../a_data/jquery_003.js"></script> -->
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
<div style="display:none;"><a href="http://en.live800.com/">live chat</a></div><script>
(function($){
$(document).ready(function(){
	totalmoney = Number(0.0000);
	$("#total").html(totalmoney);
	});
})(jQuery);
</script>
<div class="right_02 d5d8de" style="width:98%;" id="listDiv">
<div class="height5">
<div class="right_02_28"></div>
<div class="right_02_29"></div>
</div>
<div><table class="formTable" border="0" cellpadding="4" cellspacing="1" width="100%">
    

    <tr>
      <td align="right">当前余额</td>
      <td id="money" align="left"></td>

    </tr>

  </tbody></table></div>
<div class="height5">
<div class="right_02_24"></div>
<div class="right_02_25"></div>
</div>
</div>

</body></html>

<script type="text/javascript">
$.ajax({
	  type:"POST",
	  url:"../../test/getMoney",
	  contentType:"application/x-www-form-urlencoded",
	  success:function(data){
		  money.innerHTML = moneyFormat(data);
	  }
});
</script>