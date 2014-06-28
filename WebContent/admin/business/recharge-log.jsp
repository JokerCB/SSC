<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <!-- <script type="text/javascript">
$(function(){
	$('.tabs_involved input[name=username]')
	.focus(function(){
		if(this.value=='用户名') this.value='';
	})
	.blur(function(){
		if(this.value=='') this.value='用户名';
	})
	$('.tabs_involved input[name=rechargeId]')
	.focus(function(){
		if(this.value=='充值编号') this.value='';
	})
	.blur(function(){
		if(this.value=='') this.value='充值编号';
	})
	.keypress(function(e){
		if(e.keyCode==13) $(this).closest('form').submit();
	});
	
});


function rechargeLogList(err, data){
	if(err){
		alert(err);
	}else{
		$('.tab_content').html(data);
	}
}
</script>  -->
<div class="module width_full">
<header>
		<h3  class="tabs_involved">充值记录
            <form action="" class="submit_link" >
                用户名：<input type="text" class="alt_btn" style="width:60px;"  name="username"/>&nbsp;&nbsp;
              <!--   <input type="text" class="alt_btn" style="width:80px;" name="rechargeId" />&nbsp;&nbsp; -->
                时间：从<input type="date" class="alt_btn" name="fromTime"/> 到 <input type="date" class="alt_btn" name="toTime"/>&nbsp;&nbsp;
                状态类型：<select style="width:100px" name="state">
					<option value="">所有类型</option>                    
                    <option value="0">正在申请</option>
                    <option value="1">手动到账</option>
                    <option value="2">自动到账</option>
                    <option value="9">管理员充值</option>
				</select>&nbsp;&nbsp;
              <input type="button" value="查找" class="alt_btn" onclick="deskSearch();">
                <input type="reset" value="重置条件">
            </form>
			<div  class="submit_link wz">
				<input type="submit" onclick="rechargModal()" class="alt_btn" value="充值"/>
			</div>
		</h3>
	</header>
  <table class="tablesorter " id="openDataTab" cellpadding="0" cellspacing="0" border="0" width="100%">
		<tbody>
			<tr>
				<th>UserID</th>
				<th>用户名</th>
				<th>充值金额</th>
				<th>实际到账</th>
				<th>充值前资金</th>
                <th>充值编号</th>
				<th>充值银行</th>

				<th>状态</th>
				<th>备注</th>
				<th>时间</th>
				<th>操作</th>
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
	  var openDataTab = document.getElementById("openDataTab");
	   while(openDataTab.rows.length>2)
		  openDataTab.deleteRow(1); 
	  
	  $.ajax({
			type : "POST",
			url : "../recharge/findRechargeLogByPage",
			contentType : "application/x-www-form-urlencoded",
			data : formDate,
			success : function(dataMap) {
				var pageInfo = dataMap.pageInfo;
				queryList = pageInfo.dataList;
				if (queryList != undefined) {
					for (var i = 0; i < queryList.length; i++) {
						var list = queryList[i];
						var row = openDataTab
								.insertRow(openDataTab.rows.length - 1);
						var cell1 = document.createElement("td");
						var cell2 = document.createElement("td");
						var cell3 = document.createElement("td");
						var cell4 = document.createElement("td");
						var cell5 = document.createElement("td");
						var cell6 = document.createElement("td");
						var cell7 = document.createElement("td");
						var cell8= document.createElement("td");
						var cell9 = document.createElement("td");
						var cell10 = document.createElement("td");
						var cell11 = document.createElement("td");

						cell1.innerHTML = list.uid;
						cell2.innerHTML = list.m_name;
						cell3.innerHTML = list.amount;
						cell4.innerHTML = list.rechargeAmount;
						cell5.innerHTML = list.coin;
						cell6.innerHTML = list.rechargeNo;
						cell7.innerHTML = list.name;
						cell8.innerHTML = list.state;
					
						if (list.info==undefined)
						cell9.innerHTML ="";
						else
						cell9.innerHTML = list.info;
						cell10.innerHTML = list.create_date;
						if(list.state == "申请")
					    cell11.innerHTML ="<strong><a onclick='updateCoin("+list.id+",1)'  >受理</a> | <a onclick='updateCoin("+list.id+",2)'>拒绝</a></strong>";
					
							
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

					}
				}
				if (pTag == undefined) {
					$("#pageDiv").attr("pCount", pageInfo.pageCount);
					initPage(1);
				}
			}
		});

	}

	function updateCoin(id,state) {
		var rq_post={};
		rq_post['dataId']= id;
		rq_post['state']= state;
		$.ajax({
			type : 'POST',
			url : "../recharge/updateCoin",
			timeout : 30000,
			data : rq_post,
			success : function(result) {//成功
				alert(result);
				deskSearch();
			}
		});
	}
</script>