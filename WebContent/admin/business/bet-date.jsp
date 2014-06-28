<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="module width_full">
	<header>
		<h3 class="tabs_involved">
			综合统计
			<form action="" class="submit_link" >
				会员：<input type="text" class="alt_btn" name="memberName" id="memberName"
					style="width: 60px;" />&nbsp;&nbsp; 
				 时间：从
				<input type="date" class="alt_btn" name="startDate"  id="startDate" />
				到 
				<input type="date" class="alt_btn" name="endDate"  id="endDate"  />&nbsp;&nbsp;
				<select style="width: 90px;" name="type">
					<option value="">全部彩种</option>
				</select>&nbsp;&nbsp;
				<input type="button" value="查找" class="alt_btn" onclick="deskSearch();">
			</form>
		</h3>
	</header>
	<table class="tablesorter" id="reportTab" cellspacing="0">
		<thead>
			<tr>
				<td>用户名</td>
				<td>投注总额</td>
				<td>中奖总额</td>
				<td>总返点</td>
				<td>充值</td>
				<td>提现</td>
				<td>余额</td>
				<td>盈亏</td>
				<td>团队盈亏</td>
				<td>查看下级</td>
			</tr>
		</thead>
		<tbody>
			<tr>
			<td colspan="10" height="20">
				<div class="pages_o" id="pageDiv"></div>
			</td>
			</tr>
		</tbody>
	</table>
</div>

<script type="text/javascript" src="../index_files/a_data/main.js"></script>
<script type="text/javascript" src="../index_files/a_data/page.js"></script>
<script type="text/javascript">

deskSearch(); 

function deskSearch(pIndex,pTag,uid){

	  var formDate = {};
	 
	  if ((pIndex != undefined)&&(pIndex.length>6))
		{
		 pIndex = 1;
		}
	 
	  if(pIndex == undefined)
	  {
		  pIndex = 1;
	  }
	  console.log(uid);
	  if (uid!=undefined)
		  {
		  formDate['uid']=uid;
		  }
	 
	  $(formDate).attr("pageIndex",pIndex);
	  var reportTab = document.getElementById("reportTab");
	  while(reportTab.rows.length>2)
		  reportTab.deleteRow(1);
	
	  formDate['memberName']=$("#memberName").val();
	  formDate['startDate']=$("#startDate").val();
	  formDate['endDate']=$("#endDate").val();
	  formDate['ALL']="ALL";
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
			        var cell2 = document.createElement("td");
			        var cell3 = document.createElement("td");
			        var cell4 = document.createElement("td");
			        var cell5 = document.createElement("td");
			        var cell6 = document.createElement("td");
			        var cell7 = document.createElement("td");
			        var cell8 = document.createElement("td");
			        var cell9 = document.createElement("td");
			        var cell10 = document.createElement("td");
			        cell1.innerHTML = list.m_name;
			        cell2.innerHTML = moneyFormat(list.TZ);
			        cell3.innerHTML =moneyFormat(list.JJ); 
			        cell4.innerHTML =moneyFormat(list.FD); 
			        cell5.innerHTML =moneyFormat(list.CZ);
			        cell6.innerHTML =moneyFormat(list.TX);
			        cell7.innerHTML =moneyFormat(list.m_coin);
			        cell8.innerHTML =moneyFormat(list.YK);
			        cell9.innerHTML =moneyFormat(list.TDYK);
			        cell10.innerHTML ="<a style='cursor:pointer;' onclick='deskSearch(1,undefined,"+list.uid+")' >查看下级</a>";
			     
			   		 row.appendChild(cell1);
			        row.appendChild(cell2);
			        row.appendChild(cell3);
			        row.appendChild(cell4);
			        row.appendChild(cell5);
			        row.appendChild(cell6);
			        row.appendChild(cell7);
			        row.appendChild(cell8);
			        row.appendChild(cell9);
			        row.appendChild(cell10);

			       
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