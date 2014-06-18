<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="module width_full">
    <header>
    	<h3 class="tabs_involved">登录日志
            <form action="/admin.php/member/loginLog" target="ajax" dataType="html" call="defaultSearch" class="submit_link wz">
                会员名：<input type="text" class="alt_btn" style="width:60px;" name="username"/>&nbsp;&nbsp;
                IP地址：<input type="text" class="alt_btn" style="width:60px;" name="loginIP"/>&nbsp;&nbsp;
                时间：从 <input type="date" class="alt_btn" name="fromTime"/> 到 <input type="date" class="alt_btn" name="toTime"/>&nbsp;&nbsp;
                <input type="submit" value="查找" class="alt_btn">
            </form>
        </h3>
    </header>
	<table class="tablesorter" cellspacing="0">
	<thead>
		<tr>
			<td>ID</td>
			<td>用户名</td>
			<td>IP</td>

			<td>浏览器</td>
			<td>操作系统</td>
			<td>移动设备</td>
			<td>登录时间</td>
			<td>操作</td>
		</tr>
	</thead>
	<tbody>
	<tr>
			
		</tr>
	</tbody>
    </table>
	
</div>