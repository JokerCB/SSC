<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="module width_full">
	<header>
	   <h3 class="tabs_involved">银行设置
			<div class="submit_link wz"><input type="submit" value="添加银行" onclick="sysEditBank()" class="alt_btn"></div>
		</h3>
	</header>
	<table class="tablesorter " id="openDataTab" cellpadding="0" cellspacing="0" border="0" width="100%">
		<tbody>
			<tr>
				<td>银行</td>
				<td>标识</td>
				<td>持卡人</td>
				<td>账号</td>
				<td>操作</td>
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
			url : "../system/findByPage",
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
			            cell1.innerHTML = list.name;
						cell2.innerHTML = "<img  src='"+list.logo+"' >";
						cell3.innerHTML = list.username;
						cell4.innerHTML = list.account;
				        cell5.innerHTML =  "<strong><a onclick='sysEditBank("+list.id+")'  >修改</a> | <a onclick='deleteAdminBank("+list.id+")'>删除</a></strong>";
						
						row.appendChild(cell1);
						row.appendChild(cell2);
						row.appendChild(cell3);
						row.appendChild(cell4);
						row.appendChild(cell5);
					
					
					}
				}
				if (pTag == undefined) {
					$("#pageDiv").attr("pCount", pageInfo.pageCount);
					initPage(1);
				}
			}
		});

	}

function deleteAdminBank(id){
	$.ajax({
		type : 'POST',
		url : "../system/deleteAdminBank",
		timeout : 30000,
		data : "id=" + id + "",
		success : function(result) {//成功
			alert(result);
			deskSearch();
		}
	});
	
}
	/* function calcBonus(id) {
		$.ajax({
			type : 'POST',
			url : "../data/calcBonus",
			timeout : 30000,
			data : "dataId=" + id + "",
			success : function(result) {//成功
				alert(result);
				deskSearch();
			}
		});
	} */
</script>