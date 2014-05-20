<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<script language="javascript">
function cashFalse(){
	$('.cashFalseSM').css('display','block');
}
function cashTrue(){
	$('.cashFalseSM').css('display','none');
	//$('.cashFalseSM').val()=false;
}
</script>
	<div class="module width_full">
	<header><h3 class="tabs_involved">提现请求</h3></header>
	
	<table class="tablesorter" cellspacing="0">
		<thead>
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
		</thead>
		<tbody>
		</tbody>
	</table>
	<footer></footer>
</div>