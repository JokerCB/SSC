<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="module width_full">
	<header>
		<h3 class="tabs_involved">
			帐变明细
			<form action="" class="submit_link" >
				会员：<input type="text" class="alt_btn" name="memberName"
					style="width: 60px;" />&nbsp;&nbsp; 类型：
				<select style="width: 100px" name="liqType">
					<option value="">所有帐变类型</option>
					<option value="1">充值</option>
					<option value="2">返点</option>
					<!--3,分红-->
					<option value="5">停止追号</option>
					<option value="6">中奖金额</option>
					<option value="7">撤单</option>
					<option value="8">提现失败返回冻结金额</option>
					<option value="9">管理员充值</option>
					<option value="10">解除抢庄冻结金额</option>
					<option value="50">签到赠送</option>
					<option value="51">首次绑定工行卡赠送</option>
					<option value="52">充值佣金</option>
					<option value="53">消费佣金</option>
					<option value="100">抢庄冻结金额</option>
					<option value="101">投注</option>
					<option value="102">追号投注</option>
					<option value="103">抢庄返点金额</option>
					<option value="105">抢庄赔付金额</option>
					<option value="106">提现冻结</option>
					<option value="107">提现成功扣除冻结金额</option>
					<option value="108">开奖扣除冻结金额</option>
				</select>
				&nbsp;&nbsp; 时间：从
				<input type="date" class="alt_btn" name="startDate" />
				到 
				<input type="date" class="alt_btn" name="endDate" />&nbsp;&nbsp;
				<select style="width: 90px;" name="type">
					<option value="">全部彩种</option>
				</select>&nbsp;&nbsp;
				<input type="button" value="查找" class="alt_btn" onclick="deskSearch();">
				<input type="reset" value="重置条件">
			</form>
		</h3>
	</header>
	<table class="tablesorter grayTable" id="coinloglistTab" cellpadding="0" cellspacing="0" border="0" width="100%">
		<tbody>
			<tr>
				<th>时间</th>
				<th>用户名</th>
				<th>帐变类型</th>
				<th>单号</th>
				<th>游戏</th>
				<th>玩法</th>
				<th>期号</th>
				<th>模式</th>
				<th>资金</th>
				<th>余额</th>
			</tr>
			<tr>
				<td colspan="10" height="20">
					<div class="pages_o" id="pageDiv"></div>
				</td>
			</tr>
			
		</tbody>
	</table>
	<footer></footer>
	
</div>	
<script type="text/javascript" src="../index_files/a_data/main.js"></script>
<script type="text/javascript" src="../index_files/a_data/page.js"></script>
<script type="text/javascript">
deskSearch(); 
function getFieldValues(obj){
	var $obj = $(obj);
	var field=$obj.find("input[type!=submit][type!=button][type!=image],textarea,select");
	 for (var val={}, i=0, max=field.length; i < max; i++) {
	        var el = field[i];
	       	 if($(el).attr("name")||$(el).attr("id")){
	    	    val[$(el).attr("name")||$(el).attr("id")] = $(el).val().trim();
	       }
	    }
	    return val;
}
function deskSearch(pIndex,pTag){
	var obj = $(".submit_link");
	  var formDate = getFieldValues(obj);
	  console.log(formDate);
	  if ((pIndex != undefined)&&(pIndex.length>6))
		{
		 pIndex = 1;
		}
	 
	  if(pIndex == undefined)
	  {
		  pIndex = 1;
	  }
	 
	  $(formDate).attr("pageIndex",pIndex);
	  $(formDate).attr("ALL","ALL");
	  var coinloglistTab = document.getElementById("coinloglistTab");
	  while(coinloglistTab.rows.length>2)
		  coinloglistTab.deleteRow(1);
	  
	  $.ajax({
		  type:"POST",
		  url:"../coinLog/findByPage",
		  contentType:"application/x-www-form-urlencoded",
		  data:formDate,
		  success:function(dataMap){
			  var pageInfo = dataMap.pageInfo;
			  queryList = pageInfo.dataList;
			    if(queryList!=undefined){			
			       for(var i=0;i<queryList.length;i++){
			        var list=queryList[i];
			        var row = coinloglistTab.insertRow(coinloglistTab.rows.length-1);
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
			        cell1.innerHTML = list.createDate;
			        cell2.innerHTML = list.m_name;
			        cell3.innerHTML =list.fname; //moneyFormat(list.mcoin);
			        cell4.innerHTML =list.orderId; //list.mfandian+"%"; //formatFloat(list.mfandian)+"%"
			        cell5.innerHTML =list.title==undefined?"":list.title;
			        cell6.innerHTML =list.name==undefined?"":list.name;
			        cell7.innerHTML =list.lt_issue_start==undefined?"":list.lt_issue_start;
			        cell8.innerHTML =list.mode;
			        cell9.innerHTML =moneyFormat(list.coin);
			        cell10.innerHTML =moneyFormat(list.userCoin);
			        
			        					
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