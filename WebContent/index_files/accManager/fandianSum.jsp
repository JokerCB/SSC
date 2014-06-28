<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=9">
<title>杏彩游戏平台  - 返点总额 </title>
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
	function checkForm(obj) {
		if (jQuery.trim(obj.ordertime_min.value) != "") {
			if (false == validateInputDate(obj.ordertime_min.value)) {
				$.alert("时间格式不正确");
				obj.ordertime_min.focus();
				return false;
			}
		}
		if (jQuery.trim(obj.ordertime_max.value) != "") {
			if (false == validateInputDate(obj.ordertime_max.value)) {
				$.alert("时间格式不正确");
				obj.ordertime_max.focus();
				return false;
			}
		}
	}
</script>
<div style="_height:400px; min-height:400px;">
<form id="getForm">
<input name="controller" value="report" type="hidden">
<input name="action" value="userpoint" type="hidden">
            <table class="formTable" border="0" cellpadding="0" cellspacing="0" width="100%">
              <tbody><tr>
                <th width="20%">投注日期：</th>
                <td>
                    <input value="" style="width:150px;" name="searchdate" id="starttime" class="input_02" type="text">
                    <img style="cursor:pointer" src="../index_files/a_data/icon_06.jpg" height="17" width="20">
                </td>
              </tr>
               <tr>
              <td colspan="2" align="center"><input name="" value="查询" class="formCheck" style="margin:0px" type="submit"></td>
              </tr> 
            </tbody></table>
           
</form>

<table class="grayTable" border="0" cellpadding="0" cellspacing="0" width="100%">
<tbody><tr>
<th>用户名</th>
<th>日期</th>
<th>返点总额</th>
</tr>
<tr align="center">
<td>sb1234a</td>
<td>2014-05-20 02:00:00</td>
<td>0.0000&nbsp;元</td>
</tr>
</tbody></table>

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
        </script>
</div></body></html>