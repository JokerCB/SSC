<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="module width_full">
	<header>
		<h3 class="tabs_involved">重庆时时彩开奖数据
		<form action="" class="submit_link" >
			期数：<input name="actionNo" type="text"  />
			<!-- <label style="margin-left:30px;"><a class="item" href="data/index/';echo $this->type;echo '';echo $args[0]['id'];echo '?date=';echo date('Y-m-d',$date-24*3600);echo '">前一天</a></label>
			<label><a class="item" href="data/index/';echo $this->type;echo '';echo $args[0]['id'];echo '?date=';echo date('Y-m-d',$this->time);echo '">今天</a></label>
			<label><a class="item" href="data/index/';echo $this->type;echo '';echo $args[0]['id'];echo '?date=';echo date('Y-m-d',$date+24*3600);echo '">后一天</a></label> -->
			<label>日期：<input name="date"   type="date" /></label>
			<input type="button" value="查找" class="alt_btn" onclick="deskSearch();">
			<input type="reset" value="重置条件">
		</form>
		</h3>
	</header>
	<table class="tablesorter " id="openDataTab" cellpadding="0" cellspacing="0" border="0" width="100%">
		<tbody>
			<tr>
				<th>彩种</th>
				<th>期数</th>
				<th>开奖数据</th>
				<th>状态</th>
				<th>开奖时间</th>
				<th>手动开奖</th>
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
			url : "../data/findByPage",
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

						cell1.innerHTML = list.title;
						cell2.innerHTML = list.number;
						cell3.innerHTML = list.data;
						cell4.innerHTML = list.status;
						cell5.innerHTML = list.time;
						console.log(list.status);
						if (list.status == '未开奖') {
							cell6.innerHTML = "<strong><a onclick='calcBonus("
									+ list.id + ");' >添加</a></strong>";
						} else {
							cell6.innerHTML = "--";
						}

						row.appendChild(cell1);
						row.appendChild(cell2);
						row.appendChild(cell3);
						row.appendChild(cell4);
						row.appendChild(cell5);
						row.appendChild(cell6);

					}
				}
				if (pTag == undefined) {
					$("#pageDiv").attr("pCount", pageInfo.pageCount);
					initPage(1);
				}
			}
		});

	}

	function calcBonus(id) {
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
	}
</script>