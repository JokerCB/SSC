<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=9">
<title>杏彩游戏平台  - 充提记录 </title>
<link href="../index_files/a_data/base.css" rel="stylesheet" type="text/css" media="all">
<link href="../index_files/a_data/subpage.css" rel="stylesheet" type="text/css" media="all">
<script type="text/javascript" src="../index_files/a_data/jquery-1.js"></script>
<script type="text/javascript" src="../index_files/a_data/tab.js"></script>

<script type="text/javascript" src="../index_files/a_data/jquery_005.js"></script>
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
<div style="display:none;"><a href="http://www.live800.com/">客服</a></div>
<div style="display:none;"><a href="http://en.live800.com/">live chat</a></div>
<script src="../index_files/a_data/jquery_004.js" type="text/javascript"></script>
<script src="../index_files/a_data/calendar-utf8.js" type="text/javascript"></script>
<link href="../index_files/a_data/calendar-win2k-cold-1.css" media="all" type="text/css" rel="stylesheet">
<script>
function checkForm(obj)
{
	if( jQuery.trim(obj.ordertime_min.value) != "" )
	{
		if( false == validateInputDate(obj.ordertime_min.value) )
		{
			$.alert("时间格式不正确");
			obj.ordertime_min.focus();
			return false;
		}
	}
	if( jQuery.trim(obj.ordertime_max.value) != "" )
	{
		if( false == validateInputDate(obj.ordertime_max.value) )
		{
			$.alert("时间格式不正确");
			obj.ordertime_max.focus();
			return false;
		}
	}
}
</script>
<div style="_height:400px; min-height:400px;">
<form action="" method="get" name="search" onsubmit="return checkForm(this)">
<input name="controller" value="report" type="hidden">
<input name="action" value="bankreport" type="hidden">
            <table class="formTable" border="0" cellpadding="0" cellspacing="0" width="100%">
              <tbody><tr>
					<td>
					类型：<select name="ordertype">
						<option selected="selected" value="0">所有类型</option>
						<option value="40">[+]促销充值</option>
						<option value="39">[+]充值手续费</option>
						<option value="31">[+]在线充值</option>
						<option value="27">[+]提款失败</option>
						<option value="38">[+]现金充值</option>
						<option value="23">[+]理赔充值</option>
						<option value="4">[-]充值扣费</option>
						<option value="19">[-]小额扣除</option>
						<option value="26">[-]提款申请</option>
						<option value="24">[-]管理员扣减</option>
						<option value="28">[=]提款成功</option>
						<option value="22">特殊金额整理</option>
					</select>
                    <input value="" style="width:150px;" name="ordertime_min" id="starttime" class="input_02" type="text">
                    <img style="cursor:pointer" src="../index_files/a_data/icon_06.jpg" height="17" width="20">
                    至：
                    <input value="" style="width:150px;" id="endtime" name="ordertime_max" class="input_02" type="text">
                    <img style="cursor:pointer" src="../index_files/a_data/icon_06.jpg" height="17" width="20">
                </td>
              </tr>
              <tr>
		<td>用户名：<input name="username" size="10" type="text">&nbsp;   <label><input value="2" id="range" name="range" type="checkbox">包含下级</label>                </td>
              </tr>
               <tr>
              <td colspan="2" align="center">   <input name="" value="查询" class="formCheck" style="margin:0px" type="submit"></td>
              </tr> 
            </tbody></table>
            
        </form>
        <table class="grayTable" border="0" cellpadding="0" cellspacing="0" width="100%">
          <tbody><tr>
            <th>帐变编号</th>
            <th>用户名</th>
            <th>时间</th>
            <th>类型</th>
            <th>收入</th>
            <th>支出</th>
            <th>余额</th>
            <th>状态</th>
            <th>备注</th>
          </tr>
          <tr>
            <th colspan="4" class="left">小结: 本页变动金额: <strong class="red">0.00</strong></th>
            <th>+0.00</th>
            <th>-0.00</th>
            <th colspan="3"></th>
          </tr>
        </tbody></table>
        <div class="page">总计 0 个记录,  分为 0 页, 当前第 0 页<span id="tPages">    </span>
转至 <script language="JAVASCRIPT">function keepKeyNum(obj,evt){var  k=window.event?evt.keyCode:evt.which; if( k==13 ){ goPage(obj.value);return false; }} function goPage( iPage ){if( !isNaN(parseInt(iPage)) ) {window.location.href="/index.php?controller=report&action=bankreport&ordertype=0&ordertime_min=2014-05-20 02:20:00&ordertime_max=2014-05-21 02:20:00&username=&nav=&pn=20&p="+iPage;}}</script><input onkeypress="return keepKeyNum(this,event);" id="iGotoPage" name="iGotoPage" size="6" type="TEXT">页 <input onclick="javascript:goPage( document.getElementById('iGotoPage').value );return false;" class="button" value="GO" type="button"></div>
		<script type="text/javascript">
        
            jQuery("#starttime").dynDateTime({
                ifFormat: "%Y-%m-%d %H:%M:00",
                daFormat: "%l;%M %p, %e %m,  %Y",
                align: "Br",
                electric: true,
                singleClick: false,
                button: ".next()", //next sibling
                onUpdate:function(){
                    $("#starttime").change();
                },
                showOthers: true,
                weekNumbers: true,
                showsTime: true
            });
            jQuery("#starttime").change(function(){
                if(! validateInputDate(jQuery("#starttime").val()) )
                {
                    jQuery("#starttime").val('');
                    alert("时间格式不正确,正确的格式为:2009-06-10 10:59");
                }
                if($("#endtime").val()!="")
                {
                    if($("#starttime").val()>$("#endtime").val())
                    {
                        $("#starttime").val("");
                        alert("输入的时间不符合逻辑");
                    }
                }
            });
            jQuery("#endtime").dynDateTime({
                ifFormat: "%Y-%m-%d %H:%M:00",
                daFormat: "%l;%M %p, %e %m,  %Y",
                align: "Br",
                electric: true,
                singleClick: false,
                button: ".next()", //next sibling
                onUpdate:function(){
                    $("#endtime").change();
                },
                showOthers: true,
                weekNumbers: true,
                showsTime: true
            });
            jQuery("#endtime").change(function(){
                if(! validateInputDate(jQuery("#endtime").val()) )
                {
                    jQuery("#endtime").val('');
                    alert("时间格式不正确,正确的格式为:2009-06-10 10:59");
                }
                if($("#starttime").val()!="")
                {
                    if($("#starttime").val()>$("#endtime").val())
                    {
                        $("#endtime").val("");
                        alert("输入的时间不符合逻辑");
                    }
                }
            });
        </script>

</div>
</body></html>