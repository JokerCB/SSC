<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=9">
<title>杏彩游戏平台 - 报表查询</title>
<link href="../index_files/a_data/base.css" rel="stylesheet" type="text/css" media="all">
<link href="../index_files/a_data/subpage.css" rel="stylesheet" type="text/css" media="all">
<script type="text/javascript" src="../index_files/a_data/jquery-1.js"></script>
<script type="text/javascript" src="../index_files/a_data/tab.js"></script>

<script type="text/javascript" src="../index_files/a_data/jquery_005.js"></script>
<script type="text/javascript" src="../index_files/jquery_003.js"></script>
<link href="../index_files/a_data/dialogUI.css" media="all" type="text/css" rel="stylesheet">

<script type="text/javascript" src="../index_files/a_data/main.js"></script>
<script type="text/javascript" src="../index_files/a_data/page.js"></script>
</head>

<body>
<script type="text/javascript">
	//删除遮罩
	if ($("#laybox", parent.parent.document).length) {
		$("#laybox", parent.parent.document).remove();
	}
</script>
<a name="topall"></a>
<div style="display: none;">
	<a href="http://en.live800.com/">live chat</a>
</div>
<script src="../index_files/a_data/jquery_004.js" type="text/javascript"></script>
<script src="../index_files/a_data/calendar-utf8.js" type="text/javascript"></script>
<link href="../index_files/a_data/calendar-win2k-cold-1.css" media="all" type="text/css" rel="stylesheet">

	<div style="_height: 400px; min-height: 400px;">
		<form action="" method="GET" class="list-form">
			<input name="controller" value="report" type="hidden"> <input
				name="action" value="list" type="hidden"> <input
				name="isgetdata" value="1" type="hidden">
			<table class="formTable" border="0" cellpadding="0" cellspacing="0"
				width="100%">

				<tbody>
					<tr>

						<th width="20%">时间：</th>
						<td><input value="2014-05-20 02:20:00" style="width: 150px;"
							name="starttime" id="starttime" class="input_02" type="text">
							<img style="cursor: pointer" src="../index_files/a_data/icon_06.jpg" height="17"
							width="20"> 至： <input value="2014-05-21 02:20:00"
							style="width: 150px;" id="endtime" name="endtime"
							class="input_02" type="text"> <img
							style="cursor: pointer" src="../index_files/a_data/icon_06.jpg" height="17"
							width="20"></td>
					</tr>

					<tr>
						<th>彩种名称：</th>
						<td colspan="3">
							<select name="lottery" id="lottery">
								<option selected="selected" value="0">所有游戏</option>
								<option value="1">重庆时时彩</option>								
							</select>
						</td>
					</tr>
					<tr>
						<td colspan="4" align="center">
							<input onclick="deskSearch();" style="margin:0px" value="查询" class="formCheck" type="botton"></td>
					</tr>
				</tbody>
			</table>

		</form>
		<table class="grayTable" id="reportTab" border="0" cellpadding="0" cellspacing="0"
			width="100%">
			<thead>
				<tr>
					<th>用户名</th>
					<th>销售总额</th>
					<th>中奖总额</th>					
					<th>返奖总额</th>
					<th>充值</th>
					<th>提现</th>
					<th>余额</th>
					<th>总盈亏</th>
				</tr>			
			</thead>
			<tbody>
				<tr>
		            <td colspan="8" height="20">
		            	<div class="pages_o" id="pageDiv"></div>
		            </td>
		        </tr>
			</tbody>
		</table>
		<script type="text/javascript">
			jQuery("#starttime").dynDateTime({
				ifFormat : "%Y-%m-%d %H:%M:00",
				daFormat : "%l;%M %p, %e %m,  %Y",
				align : "Br",
				electric : true,
				singleClick : false,
				button : ".next()", //next sibling
				onUpdate : function() {
					$("#starttime").change();
				},
				showOthers : true,
				weekNumbers : true,
				showsTime : true
			});
			jQuery("#starttime").change(function() {
				jQuery("#recentproject").attr('value', '0');

				if (!validateInputDate(jQuery("#starttime").val())) {
					jQuery("#starttime").val('');
					alert("时间格式不正确,正确的格式为:2009-06-10 10:59");
				}
				if ($("#endtime").val() != "") {
					if ($("#starttime").val() > $("#endtime").val()) {
						$("#starttime").val("");
						alert("输入的时间不符合逻辑");
					}
				}
			});
			jQuery("#endtime").dynDateTime({
				ifFormat : "%Y-%m-%d %H:%M:00",
				daFormat : "%l;%M %p, %e %m,  %Y",
				align : "Br",
				electric : true,
				singleClick : false,
				button : ".next()", //next sibling
				onUpdate : function() {
					$("#endtime").change();
				},
				showOthers : true,
				weekNumbers : true,
				showsTime : true
			});
			jQuery("#endtime").change(function() {
				jQuery("#recentproject").attr('value', '0');
				if (!validateInputDate(jQuery("#endtime").val())) {
					jQuery("#endtime").val('');
					alert("时间格式不正确,正确的格式为:2009-06-10 10:59");
				}
				if ($("#starttime").val() != "") {
					if ($("#starttime").val() > $("#endtime").val()) {
						$("#endtime").val("");
						alert("输入的时间不符合逻辑");
					}
				}
			});
		</script>
	</div>
</body>
</html>
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
	  var reportTab = document.getElementById("reportTab");
	  while(reportTab.rows.length>2)
		  reportTab.deleteRow(1);
	  if(pIndex == undefined)
	  {
		  pIndex = 1;
	  }
	 
	  $(formDate).attr("pageIndex",pIndex);
	
	  $.ajax({
		  type:"POST",
		  url:"../coinLog/findReportByPage",
		  contentType:"application/x-www-form-urlencoded",
		  data:formDate,
		  success:function(dataMap){
			  var pageInfo = dataMap.pageInfo;
			  queryList = pageInfo.dataList;
			    if(queryList!=undefined){
			      for(var i=0;i<queryList.length;i++){
			        var list=queryList[i];
			        var row = reportTab.insertRow(reportTab.rows.length-1);
			        var cell1 = document.createElement("td");
			        var cell2 =  document.createElement("td");
			        var cell3 =  document.createElement("td");
			        var cell4 =  document.createElement("td");
			        var cell5 =  document.createElement("td");
			        var cell6 =  document.createElement("td");
			        var cell7 =  document.createElement("td");
			        var cell8 =  document.createElement("td");

			        cell1.innerHTML = list.m_name;
			        cell2.innerHTML = moneyFormat(list.TZ);			        
			        cell3.innerHTML =moneyFormat(list.JJ); 
			        cell4.innerHTML =moneyFormat(list.FD); 
			        cell5.innerHTML =moneyFormat(list.CZ);
			        cell6.innerHTML =moneyFormat(list.TX);
			        cell7.innerHTML =moneyFormat(list.m_coin);
			        cell8.innerHTML =moneyFormat(list.YK);
				           			        
			        row.appendChild(cell1);
			        row.appendChild(cell2);
			        row.appendChild(cell3);
			        row.appendChild(cell4);
			        row.appendChild(cell5);
			        row.appendChild(cell6);
			        row.appendChild(cell7);
			        row.appendChild(cell8);
	
			      }
			    }
			    if(pTag == undefined)
			    {
			    	$("#pageDiv").attr("pCount",pageInfo.pageCount);
			    	initPage(1);
			    }
		  }
	  });
  }
</script>