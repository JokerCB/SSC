<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="manager-edit">
<form action="/admin.php/manage/changeManagerPwd/';echo $args[0];echo '" target="ajax" method="post" call="manageChangePwd" onajax="manageBeforeChangePwd">
<table class="tablesorter left" cellspacing="0"> 
	<tbody> 
		<tr> 
			<td>用户名</td> 
			<td></td> 
		</tr> 
		<tr> 
			<td>原始密码</td> 
			<td><input type="password" value="" name="oldpwd"/></td> 
		</tr> 
		<tr> 
			<td>更改密码</td> 
			<td><input type="password" value="" name="password"/></td> 
		</tr> 
		<tr> 
			<td>再次输入密码</td> 
			<td><input type="password" value="" class="cpwd"></td> 
		</tr> 
	</tbody> 
</table>
</form>
</div>