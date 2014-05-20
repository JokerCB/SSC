<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div>
<form action="/admin.php/business/rechargeHandle" target="ajax" method="post" 
	call="rechargeSubmitCode" onajax="rechargeBeforeSubmit" dataType="html">
	<input type="hidden" name="id" value=""/>
	<table cellpadding="0" cellspacing="0" width="320" class="layout">
		<tr>
			<th>用户名：</th>
			<td><input type="text" value="" /></td>
		</tr>
		<tr>
			<th>充值金额：</th>
			<td><input type="text" name="amount" readonly="readonly" value="" /></td>
		</tr>
		<tr>
			<th>实际到账：</th>
			<td><input type="text" name="rechargeAmount" value=""/></td>
		</tr>
		<tr>
			<th><span class="spn9">提示：</span></th>
			<td><span class="spn9">实际到账默认为充值金额，可更改！</span></td>
		</tr>
	</table>
</form>
</div>