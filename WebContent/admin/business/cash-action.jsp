<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="cash-modal" data="">
<form action="/admin.php/business/cashDealWith/"  target="ajax" method="post" call="rechargeSubmitCode" dataType="html">
	<ul>
		<li><input type="button" class="copy" value="复制" rel=""/> 银行类型：&nbsp;&nbsp;<a href="" style="color:#f00;">进入>></a></li>
		<li><input type="button" class="copy" value="复制" rel=""/> 开户姓名：</li>
		<li><input type="button" class="copy" value="复制" rel=""/> 银行帐号：</li>
		<li><input type="button" class="copy" value="复制" rel=""/> 提取金额：</li>
	</ul>
	<p>
		<label><input type="radio" name="type" value="0" checked onclick="cashTrue()"/>提现成功（扣除冻结款）</label>
		<label><input type="radio" name="type" value="1" onclick="cashFalse()"/>提现失败（返还冻结款）</label>
        <input type="text" class="cashFalseSM" name="info" style="display:none; overflow-y:auto; width:100%;"  value=""/>
	</p>
</form>
</div>
