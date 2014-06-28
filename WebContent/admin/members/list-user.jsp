<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<header>
		<h3 class="tabs_involved">用户列表
			<div class="submit_link wz">
			<form action="" method="get" name="formTable">

			会员<input type="text" class="alt_btn" id="mname" style="width:70px;"/>&nbsp;&nbsp;
			
			<input type="button" value="查询" class="alt_btn" onclick="deskSearch();">
		</form>
		</div>
	</h3>
</header>
<table class="tablesorter" id="userTab" cellspacing="0"> 
<thead> 
    <tr> 
        <th>用户名</th> 
        <th>UserID</th> 
        <th>类型</th> 
        <th>余额</th> 
        <th>返点|分红</th> 
        <th>投注|中奖</th> 
        <th>返点|不定点</th> 
        <th>状态</th> 
        <th>最后登录</th> 
        <th>操作</th> 
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


<script type="text/javascript" src="../index_files/a_data/main.js"></script>
<script type="text/javascript" src="../index_files/a_data/page.js"></script>
<script type="text/javascript">

deskSearch(); 

function deskSearch(pIndex,pTag,uid){

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
	  $(formDate).attr("ALL","ALL");
	  if(uid != undefined)
		  $(formDate).attr("uid",uid);
	  $(formDate).attr("mname",mname.value);
	  $(formDate).attr("pageIndex",pIndex);
	  var userTab = document.getElementById("userTab");
	  while(userTab.rows.length>2)
		  userTab.deleteRow(1);
	  
	  $.ajax({
		  type:"POST",
		  url:"../members/findByPage",
		  contentType:"application/x-www-form-urlencoded",
		  data:formDate,
		  success:function(dataMap){
			  var pageInfo = dataMap.pageInfo;
			  queryList = pageInfo.dataList;
			    if(queryList!=undefined){			
			       for(var i=0;i<queryList.length;i++){
			        var list=queryList[i];
			        var row = userTab.insertRow(userTab.rows.length-1);
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
			        cell1.innerHTML = list.mname;
			        cell2.innerHTML = list.uid;
			        cell3.innerHTML = (list.mtype == 1 ? "代理":"会员"); //moneyFormat(list.mcoin);
			        cell4.innerHTML =moneyFormat(list.mcoin); //list.mfandian+"%"; //formatFloat(list.mfandian)+"%"
			        cell5.innerHTML ="";
			        cell6.innerHTML ="";
			        cell7.innerHTML = list.mfandian + " | " + list.mfandianbdw;
			        cell8.innerHTML ="离线";
			        cell9.innerHTML = "";
			        cell10.innerHTML ="<a style='cursor:pointer;' onclick='editMember("+list.uid+");'>编辑</a> | "+
			        				  "<a style='cursor:pointer;' onclick='deskSearch(1,undefined,"+list.uid+");'>下级</a> | "+
			        				  "<a style='cursor:pointer;' onclick='delMember("+list.uid+");'>删除</a>";
			        
			        					
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
