<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<article class="module width_full">
	<header>
		<h3 class="tabs_involved">帐变明细
		<form action="/admin.php/business/coinLog" class="submit_link wz" target="ajax" call="defaultSearch" dataType="html">
			会员：<input type="text" class="alt_btn" name="username" style="width:60px;"/>&nbsp;&nbsp;
			类型：<select style="width:100px" name="liqType">
					<option value="">所有帐变类型</option>
                    <option value="1">充值</option>
                    <option value="2">返点</option><!--3,分红-->
                    <!--<option value="4">抽水金额</option>-->
                    <option value="5">停止追号</option>
                    <option value="6">中奖金额</option>
                    <option value="7">撤单</option>
                    <option value="8">提现失败返回冻结金额</option>
                    <option value="9">管理员充值</option>
                    <option value="10">解除抢庄冻结金额</option>
                    <!--<option value="11">收单金额</option>-->
                    <option value="50">签到赠送</option>
                    <option value="51">首次绑定工行卡赠送</option>
                    <option value="52">充值佣金</option>
                    <option value="53">消费佣金</option>
                    <option value="100">抢庄冻结金额</option>
                    <option value="101">投注</option>
                    <option value="102">追号投注</option>
                    <option value="103">抢庄返点金额</option>
                    <!--<option value="104">抢庄抽水金额</option>-->
                    <option value="105">抢庄赔付金额</option>
                    <option value="106">提现冻结</option>
                    <option value="107">提现成功扣除冻结金额</option>
                    <option value="108">开奖扣除冻结金额</option>
				</select>&nbsp;&nbsp;
			时间：从<input type="date" class="alt_btn" name="fromTime"/> 到 <input type="date" class="alt_btn" name="toTime"/>&nbsp;&nbsp;
			<select style="width:90px;" name="type">
				<option value="">全部彩种</option>
			</select>&nbsp;&nbsp;
			<input type="submit" value="查找" class="alt_btn">
			<input type="reset" value="重置条件">
		</form>
		</h3>
	</header>
	<table class="tablesorter" cellspacing="0">
	<thead>
		<tr>
			<th>时间</th>
			<th>用户名</th>
			<th>帐变类型</th>
			<th>单号</th>
			<th>游戏</th>
			<th>玩法</th>
			<th>期号</th>
			<th>模式</th>
			<th>资金</th>
			<th>余额</th>
			
		</tr>
	</thead>
	<tbody>
		<tr>
			
		</tr>
		<tr>
			<td colspan="10">暂时没有帐变记录</td>
		</tr>
	</tbody>
	</table>
	<footer></footer>
</article>