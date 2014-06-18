<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="module width_full">
	<header>
		<h3 class="tabs_involved">
			综合统计
			<form action="" class="submit_link" >
				会员：<input type="text" class="alt_btn" name="memberName"
					style="width: 60px;" />&nbsp;&nbsp; 
				 时间：从
				<input type="date" class="alt_btn" name="startDate" />
				到 
				<input type="date" class="alt_btn" name="endDate" />&nbsp;&nbsp;
				<select style="width: 90px;" name="type">
					<option value="">全部彩种</option>
				</select>&nbsp;&nbsp;
				<input type="button" value="查找" class="alt_btn" onclick="deskSearch();">
			</form>
		</h3>
	</header>
	<table class="tablesorter" cellspacing="0">
		<thead>
			<tr>
				<td>用户名</td>
				<td>投注总额</td>
				<td>中奖总额</td>
				<td>总返点</td>
				<td>充值</td>
				<td>提现</td>
				<td>余额</td>
				<td>盈亏</td>
				<td>团队盈亏</td>
				<td>查看下级</td>
			</tr>
		</thead>
		<tbody>
			<tr></tr>
		</tbody>
	</table>
</div>
