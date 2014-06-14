<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form name="system_addBank"  class="submit_link" onsubmit="return checkValid(this);" >
<input type="hidden" name="id" value=""/>
<table class="tablesorter left" cellspacing="0" width="100%">
	<thead> 
		<tr> 
			<td>项目</td> 
			<td>值</td> 
		</tr> 
	</thead>
	<tbody>
	<tr> 
			<td>开户行省份</td> 
			<td>
				<select name="provinceId" id="provinceId" onchange="getCityList(this)">
					<option value=""></option>
				</select>
			</td>
		</tr>
		<tr> 
			<td>开户行城市</td> 
			<td>
				<select name="cityId" id="cityId" >
					<option value=""></option>
				</select>
			</td>
		</tr>
		<tr> 
			<td>银行名称</td> 
			<td>
				<select name="bankId" id="bankId">
					<option value=""></option>
				</select>
			</td>
		</tr>
		<tr> 
			<td>账号</td> 
			<td><input type="text" name="account"  id="account" /></td>
		</tr>
		<tr> 
			<td>持卡人</td> 
			<td><input type="text" name="username"  id="username" /></td>
		</tr>
			<tr> 
			<td>开户行名称</td> 
			<td><input type="text" name="bankCardName"  id="bankCardName" /></td>
		</tr>
		<!-- <tr> 
			<td>充值示意图</td> 
			<td><input type="file" name="rechargeDemo"/></td>
		</tr> 
		<tr> 
			<td>状态</td> 
			<td>
				<label><input type="radio" value="1" name="enable" checked="checked"/>开启</label>
				<label><input type="radio" value="0" name="enable"/>关闭</label>
			</td> 
		<tr> -->
	</tbody> 
</table>
</form>
</body>
<script type="text/javascript" src="../index_files/a_data/main.js"></script>
<script type="text/javascript" src="../index_files/a_data/page.js"></script>
<script type="text/javascript" src="../skin/js/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="../skin/admin/function.js"></script>
<script type="text/javascript">
function getQueryString(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
    var r = window.location.search.substr(1).match(reg);
   
    if (r != null) return unescape(r[2]); return null;
    }
if (getQueryString("id")!="" && getQueryString("id")!=undefined)
	{
	editAdminBank(getQueryString("id"));
	}


getBankList();
getProvinceList();
$("#provinceId").change(getCityList(provinceId));
function getBankList() {
	$.ajax({
		type : "post",
		url : "../../system/getBankList",
		dataType : "json",
		success : function (result) {
			bindDropDownList("#bankId", result.list);

		}
	});
}

function getProvinceList() {
		$.ajax({
		type : "post",
		url : "../../system/getProvinceList",
	    async:false,
		dataType : "json",
		success : function (result) {
			bindDropDownList("#provinceId", result.list);

		}
	});
}

function getCityList(Obj) {
	$.ajax({
		type : "post",
		url : "../../system/getCityList",
		data :  "provinceId=" + Obj.value + "",
		dataType : "json",
		success : function (result) {
			bindDropDownList("#cityId", result.list);

		}
	});
}
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
function editAdminBank(id){
	$.ajax({
		type : 'POST',
		url : "../../system/editAdminBank",
		async:false,
		timeout : 30000,
		data : "id=" + id + "",
		success : function(result) {//成功
			var json = eval('(' + result + ')');
		$("#provinceId").val(json.provinceid);
		$("#cityId").val(json.cityid);
		$("#bankId").val(json.bankid);
		$("#bankCardName").val(json.bankcardname);
		$("#account").val(json.account);
		$("#username").val(json.username);
	
	
		}
	});
}
 function saveAdminBank(){
	var obj = $(".submit_link");
	var formDate = getFieldValues(obj);
	if(!checkValid(obj[0])){
		return false;
	}
	 $.ajax({
			type : "POST",
			url : "../../system/saveAdminBank",
			contentType : "application/x-www-form-urlencoded",
			data : formDate,
			success : function(result) {
				alert(result);
				top.bankModal.dialog("destroy");
				parent.deskSearch();
			}
		}); 
	  
 }
 
 function checkValid(obj)
 {
	// alert(obj.account.value);
	 if(obj.account.value==null || obj.account.value==""){
		 alert("账号不能为空！");
		 obj.account.focus();
		 return false;
	 }
	 if(obj.username.value==null || obj.username.value==""){
		 alert("持卡人不能为空！")
		 obj.username.focus();
		 return false;
	 }
	 if(obj.bankCardName.value==null || obj.bankCardName.value==""){
		 alert("开户行名称不能为空！")
		 obj.bankCardName.focus();
		 return false;
	 }
	return true;
 }
 function updateAdminBank(id){
		var obj = $(".submit_link");
		var formDate = getFieldValues(obj);
		$(formDate).attr("id",id);
		if(!checkValid(obj[0])){
			return false;
		}
		 $.ajax({
				type : "POST",
				url : "../../system/updateAdminBank",
				contentType : "application/x-www-form-urlencoded",
				data : formDate,
				success : function(result) {
					alert(result);
					top.bankModal.dialog("destroy");
					parent.deskSearch();
				}
			}); 
		  
	 }



</script>
</html>