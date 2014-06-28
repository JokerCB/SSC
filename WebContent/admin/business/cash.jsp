<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="module width_full">
<header>
</header>
  <table class="tablesorter " id="openDataTab" cellpadding="0" cellspacing="0" border="0" width="100%">
		<tbody>
			<tr>
				<th>UserID</th>
				<th>用户名</th>
				<th>提现金额</th>
				<th>银行类型</th>
				<th>开户姓名</th>
				<th>银行账号</th>
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
	  if ((pIndex != undefined)&&(pIndex.length>6))
		{
		 pIndex = 1;
		}
	 
	  if(pIndex == undefined)
	  {
		  pIndex = 1;
	  }

	  var openDataTab = document.getElementById("openDataTab");
	   while(openDataTab.rows.length>2)
		  openDataTab.deleteRow(1); 
	   var rq_post={};
		rq_post['pageIndex']= pIndex;
		rq_post['state']= 1;
		
	  $.ajax({
			type : "POST",
			url : "../memberCash/findCashByPage",
			contentType : "application/x-www-form-urlencoded",
			data : rq_post,
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
						var cell8 = document.createElement("td");
					
						cell1.innerHTML = list.uid;
						cell2.innerHTML = list.m_name;
						cell3.innerHTML = list.amount;
						cell4.innerHTML = list.name;
						cell5.innerHTML = list.username;
						cell6.innerHTML = list.account;
						cell7.innerHTML = list.createDate;
						
					
					    cell8.innerHTML ="<strong><a onclick='updateCash("+list.id+",3,"+list.uid+")'  >受理</a> | <a onclick='updateCash("+list.id+",2,"+list.uid+")'>拒绝</a></strong>";
												
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
				if (pTag == undefined) {
					$("#pageDiv").attr("pCount", pageInfo.pageCount);
					initPage(1);
				}
			}
		});

	}

	function updateCash(id,state,uid) {
		var rq_post={};
		rq_post['dataId']= id;
		rq_post['state']= state;
		rq_post['uid']= uid;
		$.ajax({
			type : 'POST',
			url : "../memberCash/updateCash",
			timeout : 30000,
			data : rq_post,
			success : function(result) {//成功
				alert(result);
				deskSearch();
			}
		});
	}
</script>