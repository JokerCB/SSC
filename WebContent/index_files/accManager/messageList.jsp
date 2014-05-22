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
</script>
<a name="topall"></a>
  <table class="grayTable" border="0" cellpadding="0" cellspacing="0" width="100%">
          <tbody><tr>
            <th width="60%">标　　题</th>
            <th width="20%">日　　期</th>
            <th width="20%">操　　作</th>
          </tr>
		  		
          <tr>
            
            <td colspan="3">您暂时没有短消息</td>
            
          </tr>
       		           </tbody></table>
		总计 0 个记录,  分为 0 页, 当前第 0 页<span id="tPages">    </span>
转至 <script language="JAVASCRIPT">function keepKeyNum(obj,evt){var  k=window.event?evt.keyCode:evt.which; if( k==13 ){ goPage(obj.value);return false; }} function goPage( iPage ){if( !isNaN(parseInt(iPage)) ) {window.location.href="/?controller=user&action=messages&nav=&pn=10&p="+iPage;}}</script><input onkeypress="return keepKeyNum(this,event);" id="iGotoPage" name="iGotoPage" size="6" type="TEXT">页 <input onclick="javascript:goPage( document.getElementById('iGotoPage').value );return false;" class="button" value="GO" type="button">	</body></html>