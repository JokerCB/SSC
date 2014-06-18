<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div>
<form target="ajax" method="post" call="nothin" dataType="html">
	<input type="hidden" name="uid" value="';echo $uid;echo '" />
	<input type="hidden" name="teamCoin" value="';echo $son['teamCoin'];echo '" />
	<input type="hidden" name="teamFcoin" value="';echo $son['teamFcoin'];echo '" />
	 团队还有成员';echo $son['teamNum'];echo '人，团队资金';echo $this->ifs($son['teamCoin'],'0.00');echo '元,团队冻结';echo $this->ifs($son['teamFcoin'],'0.00');echo '元，请先删除团队成员。
</form>
<form action="/admin.php/Member/deleteed/';echo $uid;echo '" target="ajax" method="post" call="userDataSubmitCode" dataType="html">
	<input type="hidden" name="uid" value="';echo $uid;echo '" />
	<input type="hidden" name="teamCoin" value="';echo $son['teamCoin'];echo '" />
	<input type="hidden" name="teamFcoin" value="';echo $son['teamFcoin'];echo '" />
	无团队成员，个人资金';echo $this->ifs($son['teamCoin'],'0.00');echo '元,团队冻结';echo $this->ifs($son['teamFcoin'],'0.00');echo '元。<br />
	<span style="color:#F00; text-align:center; line-height:50px;">确定删除将不能恢复，是否确定？</span><br />
</form>
</div>