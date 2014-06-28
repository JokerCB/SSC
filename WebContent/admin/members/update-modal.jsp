<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div>

<form action="../members/memberUpdate" method="post" target="ajax" onajax="userDataBeforeSubmitCode" call="userDataSubmitCode">

	<input type="hidden" name="uid" value="${uid}"/>
      
	<table cellpadding="2" cellspacing="2" class="popupModal">
		<tr>
			<td class="title" width="180">上级关系：</td>
			<td>${parent}</td>
		</tr>
		<tr>
			<td class="title" width="180">用户名：</td>
			<td><input type="text" name="username" readonly="readonly" value="${mname}"/></td>
		</tr>
		<tr>
			<td class="title">密码：</td>
			<td><input type="text" name="password" value=""/>&nbsp;<span class="spn9">置空为不修改</span></td>
		</tr>
		<tr>
			<td class="title">资金密码：</td>
			<td><input type="text" name="coinPassword" value=""/>&nbsp;<span class="spn9">置空为不修改</span></td>
		</tr>
		<tr>
			<td class="title">返点：</td>
			<td><input type="text" name="fanDian" value="${fanDian}" max="${fanDianMax}" min="0" >%&nbsp;&nbsp;&nbsp;&nbsp;<span style="color:#999">0-${fanDianMax}%</span></td>
		</tr>
		<tr>
			<td class="title">不定返点：</td>
			<td><input type="text" name="fanDianBdw" value="${fanDianBdw}" max="${fanDianBdwMax}" min="0"/>%&nbsp;&nbsp;&nbsp;&nbsp;<span style="color:#999">0-${fanDianBdw}%</span></td>
		</tr>
        <tr>
        	<td class="title">加入时间：</td>
			<td>${createDate}</td>
        </tr>
      </table>
</form>
</div>
