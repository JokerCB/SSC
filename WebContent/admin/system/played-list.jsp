<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="module width_full">
	<header>
		<h3 class="tabs_involved">玩法设置
			<ul class="tabs" style="margin-right:25px;">
			<li><a href="system/played/';echo $key;echo '"></a></li>
			</ul>
		</h3>
	</header>
	<table class="tablesorter" cellspacing="0">
		<thead>
			<tr>
				<th colspan="5" style="text-align:left;">
					<span style="float:right; margin-right:20px"><a href="/admin.php/system/switchPlayedGroupStatus/';echo $group['id'];echo '" target="ajax" call="reloadPlayed">';echo $this->iff($group['enable'],'关闭','开启');echo '</a></span>
					';echo $group['groupName'];echo '&nbsp;&nbsp;&nbsp;&nbsp;
					<span class="spn1">[状态：<span class="state1">';echo $this->iff($group['enable'],'开启','关闭');echo '</span>]</span>
				</th>
			</tr>
		</thead>
		<tbody>
		<tr>
				<td width="15%"></td>
				<td width="25%">最高奖金：<input type="text" name="bonusProp" value="';echo $played['bonusProp'];echo '"></td>
				<td width="25%">最低奖金：<input type="text" name="bonusPropBase" value="';echo $played['bonusPropBase'];echo '"></td>
				<td width="15%"><span class="state2">';echo $this->iff($played['enable'],'开启','关闭');echo '</span></td>
				<td><a href="/admin.php/system/switchPlayedStatus/';echo $played['id'];echo '" target="ajax" call="reloadPlayed">';echo $this->iff($played['enable'],'关闭','开启');echo '</a> | <a href="/admin.php/system/updatePlayed/';echo $played['id'];echo '" target="ajax" method="post" onajax="sysBeforeUpdatePlayed" call="reloadPlayed">保存修改</a></td>
			</tr>
		<tr>
				<td colspan="5">暂时没有玩法</td>
			</tr>
		</tbody>
	</table>
	</div>