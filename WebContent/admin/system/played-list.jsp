<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="module width_full">
	<header>
		<h3 class="tabs_involved">玩法设置
			<ul class="tabs" style="margin-right:25px;">
			<li><a style="cursor: pointer;" onclick="click();">重庆时时彩</a></li>
			<li><a style="cursor: pointer;" onclick="click();">福彩3D</a></li>
			</ul>
		</h3>
	</header>
	<table id="formTab" class="tablesorter" cellspacing="0">

		<tbody>
		<tr>
			<td width="15%"></td>
			<td width="25%">最高奖金：<input type="text" name="bonusProp" value=""></td>
			<td width="25%">最低奖金：<input type="text" name="bonusPropBase" value=""></td>
			<td> <a href="" target="ajax" method="post" onajax="sysBeforeUpdatePlayed" call="reloadPlayed">保存修改</a></td>
		</tr>

		</tbody>
	</table>
</div>
<script type="text/javascript">
	init();
	function init(){
		var formTab = document.getElementById("formTab");
		  while(formTab.rows.length>1)
			  formTab.deleteRow(0);
		 $.ajax({
			  type:"POST",
			  url:"../played/getPlayedList",
			  contentType:"application/x-www-form-urlencoded",
			  success:function(data){		
				       for(var i=0;i<data.length;i++){
				        var list=data[i];
				        var row = formTab.insertRow(formTab.rows.length-1);
				        var cell1 = document.createElement("td");
				        var cell2 = document.createElement("td");
				        var cell3 = document.createElement("td");
				        var cell4 = document.createElement("td");
				       
				        cell1.innerHTML = list.name;
				        cell2.innerHTML = "最高奖金：<input type='text' name='bonusProp' value='"+list.bonusPropMax+"''>";
				        cell3.innerHTML = "最低奖金：<input type='text' name='bonusProp' value='"+list.bonusPropMin+"''>";
				        cell4.innerHTML =  "<a style='cursor: pointer;' onclick='click();' >保存修改</a>";
				       
				        
				        					
				        row.appendChild(cell1);
				        row.appendChild(cell2);
				        row.appendChild(cell3);
				        row.appendChild(cell4);
				       

				       
				      }
				    }
		  });
	}
</script>