<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="module width_full">
	<header>
		<h3 class="tabs_involved">系统公告
			<div class="submit_link wz">
			<input type="submit" value="添加公告" onclick="sysAddNotice()" class="alt_btn">
			</div>
		</h3>
	</header>
	<table id="noticeTab" class="tablesorter" cellspacing="0">
	<thead>
		<tr>
			<td>日期</td>
			<td>内容</td>
			<td>是否显示</td>
			<td>操作</td>
		</tr>
	</thead>
	<tbody>
	<tr>
				<td colspan="4" height="20">
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
function deskSearch(pIndex,pTag){
	  var formDate = {};
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
	  var noticeTab = document.getElementById("noticeTab");
	  while(noticeTab.rows.length>2)
		  noticeTab.deleteRow(1);
	  
	  $.ajax({
		  type:"POST",
		  url:"../system/findNoticesByPage",
		  contentType:"application/x-www-form-urlencoded",
		  data:formDate,
		  success:function(dataMap){
			  var pageInfo = dataMap.pageInfo;
			  queryList = pageInfo.dataList;
			    if(queryList!=undefined){			
			       for(var i=0;i<queryList.length;i++){
			        var list=queryList[i];
			        var row = noticeTab.insertRow(noticeTab.rows.length-1);
			        var cell1 = document.createElement("td");
			        var cell2 = document.createElement("td");
			        var cell3 = document.createElement("td");
			        var cell4 = document.createElement("td");
			       
			        cell1.innerHTML = list.createDate;
			        cell2.innerHTML = list.content;
			        var temp=0;
			        if(list.visible) {
			        	temp=1;
			        	cell3.innerHTML ="<input type='checkbox' onclick='changeEnableVal(this);' name='enable' name='enable' value='1' checked/>";//list.visible; //moneyFormat(list.mcoin);
			        } else {
			        	temp=0;
			        	cell3.innerHTML ="<input type='checkbox' onclick='changeEnableVal(this);' name='enable' value='0'/>";
			        }
			    	//console.log($('#enable')[i].val());
			        cell4.innerHTML = "<a href='../system/updateNotice?id="+list.id+"&enable="+temp+"'; target='ajax' method='post' onajax='sysBeforeUpdateNotice' call='sysReloadNotice'>修改保存</a> | <a href='../system/deleteNotice/?id="+list.id+"' target='ajax' call='sysReloadNotice'>删除</a>";
			        
			        					
			        row.appendChild(cell1);
			        row.appendChild(cell2);
			        row.appendChild(cell3);
			        row.appendChild(cell4);
			       

			       
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
  function changeEnableVal(obj){
	  var hrefvalue = $(obj).closest("td").next("td").find("a:first").attr("href");
	  hrefvalue=hrefvalue.substring(0, hrefvalue.length-1);
	  $(obj).closest("td").next("td").find("a:first").attr("href", hrefvalue+""+(obj.checked?1:0));
  }
</script>
