<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<style>
.subLength{
  width:100px;
  overflow: hidden;
  white-space: nowrap;
  text-overflow: ellipsis;
}

</style>

<article class="module width_full">
	<header>
		<h3 class="tabs_involved">投注记录
			<div class="submit_link wz">
			<form action="" method="get" name="formTable">
				订单编号<input type="text" class="alt_btn" id="orderId" style="width:70px;"/>&nbsp;&nbsp;		
				期号<input type="text" class="alt_btn" id="issue" style="width:70px;"/>&nbsp;&nbsp;
				会员<input type="text" class="alt_btn" id="mname" style="width:70px;"/>&nbsp;&nbsp;
				时间从 <input type="date" class="alt_btn" id="starttime"/> 到 <input type="date" id="endtime" class="alt_btn"/>&nbsp;&nbsp;
				<select style="width:90px;" name="lotteryid" id="lotteryid">
					<option selected="selected" value="0">全部彩种</option>
					<option value="1">重庆时时彩</option>	
				</select>&nbsp;&nbsp;

				<input type="button" value="查询" class="alt_btn" onclick="deskSearch();">
				<input type="reset" value="重置条件">
			</form>
			</div>
		</h3>
	</header>
	<table class="tablesorter" id="orderManager" cellspacing="0">
		<thead>
			<tr>	
			<th width="150">会员名</th>
			<th width="150">投注时间</th>
			<th class="line_03" align="center">订单编号</th>
			<th class="line_03" align="center" width="150">玩法</th>
			<th class="line_03" align="center" width="130">投注期号</th>
			<th class="line_03" align="center" width="80">投注内容</th>
			<th class="line_03" align="center" width="80">投注金额</th>
			<th class="line_03" align="center" width="80">奖金</th>
			<th class="line_03" align="center" width="80">开奖号码</th>
			<th class="line_03" align="center" width="60">状态</th>
			<th class="line_03" align="center" width="80">追号订单</th>
			<th class="line_03" align="center" width="80">追号编号</th>
			<th class="line_03" align="center" width="80">中奖后停止</th>
			</tr>
		</thead>
		<tbody>
			<tr>
	            <td colspan="13" height="20">
	            	<div class="pages_o" id="pageDiv"></div>
	            </td>
	        </tr>
		</tbody>
	</table>
	<footer></footer>
</article>

<script type="text/javascript" src="../index_files/a_data/main.js"></script>
<script type="text/javascript" src="../index_files/a_data/page.js"></script>
 <script type="text/javascript">
 
    deskSearch();
    function deskSearch(pIndex,pTag){
    //	var obj = $(".formTable");
    //	var formDate = top.getFieldValues(obj);

    var formDate= {};
    	  if ((pIndex != undefined)&&(pIndex.length>6))
    		{
    		 pIndex = 1;
    		}
    	  $(".news_uldetail").html('');
    	  var orderManager = document.getElementById("orderManager");
    	  while(orderManager.rows.length>2)
    		  orderManager.deleteRow(1);
    	  if(pIndex == undefined)
    	  {
    		  pIndex = 1;
    	  }

    	 formDate["pageIndex"]=pIndex;
    	 formDate["all"] = "all";
    	 formDate['mname'] = mname.value;
		 formDate['orderId'] = orderId.value;
		 formDate['lotteryid'] = lotteryid.value;
		 formDate['issue'] = issue.value;
		 formDate['starttime'] = starttime.value;
		 formDate['endtime'] = endtime.value;
		 
    	  $.ajax({
    		  type:"POST",
    		  url:"../order/findDetailsByPage",
    		  contentType:"application/x-www-form-urlencoded",
    		  data:formDate,
    		  success:function(dataMap){
    			  var pageInfo = dataMap.pageInfo;
    			  queryList = pageInfo.dataList;
    			    if(queryList!=undefined){
    			      for(var i=0;i<queryList.length;i++){
    			        var list=queryList[i];
    			        var mdata = list.map;
    			        var row = orderManager.insertRow(orderManager.rows.length-1);
    			        var cell1 = document.createElement("td");
    			        var cell2 = document.createElement("td");
    			        var cell3 =  document.createElement("td");
    			        var cell4 =  document.createElement("td");
    			        var cell5 =  document.createElement("td");
    			        var cell6 =  document.createElement("td");
    			        var cell7 =  document.createElement("td");
    			        var cell8 =  document.createElement("td");
    			        var cell9 =  document.createElement("td");
    			        var cell10 =  document.createElement("td");
    			        var cell11 =  document.createElement("td");
    			        var cell12 =  document.createElement("td");
    			        var cell13 =  document.createElement("td");
    			        
    			        cell1.innerHTML = mdata.mname;
    			        cell2.innerHTML = list.createDate;
    			        cell3.innerHTML = list.orderId;
    			        cell4.innerHTML = mdata.playedName;
    			        cell5.innerHTML = mdata.issue;
    			        cell6.title = list.actionData;
    			        cell6.innerHTML = "<div class='subLength' >"+list.actionData+"</span>";   			       
    			        cell7.innerHTML = moneyFormat(list.actionMoney);
    			        if(list.bonus == null)
    			        	list.bonus = 0;
    			        cell8.innerHTML = moneyFormat(list.bonus);
    			        if(list.lotteryNo == null)
    			        	list.lotteryNo = "";
    			        cell9.innerHTML = list.lotteryNo;    			
    			        cell10.innerHTML = mdata.state;
    			        cell11.innerHTML = mdata.zhuiHao==1?"是":"否";
    			        cell12.innerHTML = mdata.zhuiHaoId;
    			        cell13.innerHTML = mdata.isStop==1?"是":"否";
    			        
    			        
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
    			        row.appendChild(cell11);
    			        row.appendChild(cell12);
    			        row.appendChild(cell13);
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