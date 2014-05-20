<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<article class="module width_full">
	<header>
		<h3 class="tabs_involved">普通投注
			<form class="submit_link wz" action="/admin.php/business/betLog" target="ajax" call="defaultSearch" dataType="html">
				会员<input type="text" class="alt_btn" name="username" style="width:70px;"/>&nbsp;&nbsp;
				时间从 <input type="date" class="alt_btn" name="fromTime"/> 到 <input type="date" name="toTime" class="alt_btn"/>&nbsp;&nbsp;
				<select style="width:90px;" name="type">
					<option value="">全部彩种</option>
				</select>&nbsp;&nbsp;
                <select style="width:74px;" name="betType">
					<option value="">全部来源</option>
					<option value="0" title="web">web</option>
					<option value="1" title="web">手机</option>
				</select>&nbsp;&nbsp;
				<input type="submit" value="查找" class="alt_btn">
				<input type="reset" value="重置条件">
			</form>
		</h3>
	</header>
	<table class="tablesorter" cellspacing="0">
		<thead>
			<tr>
				<th>单号</th>
				<th>用户名</th>
				<th>投注时间</th>
				<th>彩种</th>
				<th>玩法</th>
				<th>期号</th>
				<th>倍数</th>
				<th>模式</th>
				<th>投注号码</th>
				<th>投注金额</th>
				<th>中奖金额</th>
				<th>返点</th>
				<th>抽水</th>
				<th>来源</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				
			</tr>
		</tbody>
	</table>
	<footer></footer>
</article>';