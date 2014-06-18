<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="module width_full">
    <header>
    	<h3 class="tabs_involved">银行信息
            <form action="/admin.php/member/bank" target="ajax" dataType="html" class="submit_link wz" call="defaultSearch" >
                会员名：<input type="text" class="alt_btn"  name="username" placeholder="会员名"/>&nbsp;&nbsp;
               <input type="submit" value="查找" class="alt_btn">
            </form>
        </h3>
    </header>
	<table class="tablesorter" cellspacing="0">
	<thead>
		<tr>
			<td>会员编号</td>
			<td>用户名</td>
			<td>银行名称</td>
			<td>银行账号</td>
			<td>开户姓名</td>
		</tr>
	</thead>
	<tbody>
	<tr>
			
		</tr>
	
	</tbody>
    </table>
	
</div>