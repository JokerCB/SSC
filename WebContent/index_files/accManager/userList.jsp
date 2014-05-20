<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" style="height:100%;"><head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=9">
<title>游戏平台 </title>
<link href="../a_data/base.css" rel="stylesheet" type="text/css" media="all">
<link href="../a_data/subpage.css" rel="stylesheet" type="text/css" media="all">
<script type="text/javascript" src="../a_data/jquery-1.js"></script>
<script type="text/javascript" src="../a_data/tab.js"></script>

<script type="text/javascript" src="../a_data/jquery.js"></script>
<script type="text/javascript" src="../a_data/jquery_002.js"></script>
<link href="../a_data/dialogUI.css" media="all" type="text/css" rel="stylesheet">
<script type="text/javascript" src="../a_data/iframe.js"></script>
<script type="text/javascript" src="../a_data/main.js"></script>
<script type="text/javascript" src="../a_data/page.js"></script>


</head>

<body style="height:100%;">
<script type="text/javascript">
//删除遮罩
if($("#laybox",parent.parent.document).length){
	$("#laybox",parent.parent.document).remove();
}
</script>
<a name="topall"></a>
 <script type="text/javascript">
	jQuery("#loadhtml").hide(); //去掉loading界面
	jQuery(document).ready(function(){
		
    });	
    function checkForm(obj)
    {
        if( obj.username.value != "" && obj.usergroup.value == 0 )
        {
            alert("请选择用户组");
            return false;
        }
    }
</script>
<form action="" method="get" name="search">
    <input name="controller" value="user" type="hidden">
    <input name="action" value="list" type="hidden">
    <input name="frame" value="show" type="hidden">
    <input name="flag" value="search" type="hidden">
    <table class="formTable" cellpadding="0" cellspacing="0" border="0" width="100%">
        <tbody><tr>
            <th>用户名：</th>
            <td><input name="mname" id="username" type="text"></td>
            <th>用户余额：</th>
            <td><input name="bank_min" onkeyup="checkMoney(this)" size="10" type="text"> 至 <input name="bank_max" onkeyup="checkMoney(this)" size="10" type="text"></td>
        </tr>
        <tr>

            <td colspan="4" align="center"><input name="" style="margin:0px" value="查询" class="formCheck" type="button" onclick="deskSearch();"></td>
        </tr>
    </tbody></table>

</form>
<div class="line10px"></div>
<form action="" method="get">
<table class="grayTable" id="userlistTab" cellpadding="0" cellspacing="0" border="0" width="100%">
	<tbody>
        <tr>
            <th>用户名</th>
            <th>用户类型</th>
            <th>余额</th>
            <th>返点级别</th>
            <th>用户操作</th>
        </tr>
        <tr>
            <td colspan="6" height="20">
            	<div class="pages_o" id="pageDiv"></div>
            </td>
        </tr>
    </tbody>
</table>
</form>
<script type="text/javascript">
deskSearch();
function deskSearch(pIndex,pTag){
	var obj = $(".formTable");
	  var formDate = top.getFieldValues(obj);
	  if ((pIndex != undefined)&&(pIndex.length>6))
		{
		 pIndex = 1;
		}
	  $(".news_uldetail").html('');
	  var userlistTab = document.getElementById("userlistTab");
	  while(userlistTab.rows.length>2)
		  userlistTab.deleteRow(1);
	  if(pIndex == undefined)
	  {
		  pIndex = 1;
	  }
	 
	  $(formDate).attr("pageIndex",pIndex);
	
	  $.ajax({
		  type:"POST",
		  url:"../../members/findByPage",
		  contentType:"application/x-www-form-urlencoded",
		  data:formDate,
		  success:function(dataMap){
			  var pageInfo = dataMap.pageInfo;
			  queryList = pageInfo.dataList;
			    if(queryList!=undefined){			    	
			      for(var i=0;i<queryList.length;i++){
			        var list=queryList[i];
			        //alert(userlistTab.rows.length);
			        var row = userlistTab.insertRow(userlistTab.rows.length-1);
			        var cell1 = row.insertCell();
			        var cell2 = row.insertCell();
			        var cell3 = row.insertCell();
			        var cell4 = row.insertCell();
			        var cell5 = row.insertCell();
			        cell1.innerHTML = "<strong><a href='' target='mainFrame'>"+list.mname+"</a></strong>";
			        cell2.innerHTML = "一级代理";
			        cell3.innerHTML = moneyFormat(list.mcoin);
			        cell4.innerHTML = list.mfandian+"%"; //formatFloat(list.mfandian)+"%"
			        cell5.innerHTML = "<a href=''>&nbsp;团队余额&nbsp;</a>"+
			        					"<a href=''>&nbsp;下级充值&nbsp;</a>"+
			        					"<a href=''>&nbsp;返点设定&nbsp;</a>";
			       
			      }
			    }
			    if(pTag == undefined)
			    {
			    	$("#pageDiv").attr("pCount",pageInfo.pageCount);
			    	initPage(1);
			    }
		  }
	  });
	  SetWinHeight(parent.document.getElementById("mainFrame"));
  }
</script>

</body></html>