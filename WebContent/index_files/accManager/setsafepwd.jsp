<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=9">
<title>杏彩游戏平台  - 设置提款密码 </title>
<link href="../index_files/a_data/base.css" rel="stylesheet" type="text/css" media="all">
<link href="../index_files/a_data/subpage.css" rel="stylesheet" type="text/css" media="all">
<script type="text/javascript" src="../index_files/a_data/jquery-1.js"></script>
<script type="text/javascript" src="../index_files/a_data/tab.js"></script>
<link href="../index_files/a_data/dialogUI.css" media="all" type="text/css" rel="stylesheet">
<script type="text/javascript" src="../index_files/a_data/main.js"></script>
</head>
<body>
<script type="text/javascript">
//删除遮罩
if($("#laybox",parent.parent.document).length){
	$("#laybox",parent.parent.document).remove();
}
</script>
<a name="topall"></a>
<div style="display:none;"><a href="http://www.live800.com/">客服</a></div>
<div style="display:none;"><a href="http://en.live800.com/">live chat</a></div> 
<script language="javascript" type="text/javascript" src="../index_files/jQuery-MD5.js"></script>
<script type="text/javascript">
function checkform(obj)
{
  if( !validateUserPss(obj.secpass.value) )
  {
  	alert("提款密码不符合规则，请重新输入");
	obj.secpass.focus();
	return false;
  }
  var newMd5pass = $.md5(obj.secpass.value);
  obj.secpass.value = newMd5pass;
  return true;
}
</script>
<style type="text/css">
body{font-size:12px;}
</style>
<form action="../members/safepwd" method="post" name="updateform" onsubmit="return checkform(this)">
<input type="hidden" name="topage" value="${topage}"/>
	<h4 class="dotTitle">
		<span class="st"></span>设置提款密码
	</h4>
	<table class="formTable" border="0" cellpadding="0" cellspacing="0"
		width="100%">
		<tbody>
			<tr>
				<th width="20%">请输入您的提款密码：</th>
				<td><input name="secpass" id="secpass" value="" type="password">
					<br>(由字母和数字组成6-16个字符；且必须包含数字和字母
					，不能和登陆密码相同)</td>
			</tr>

		</tbody>
	</table>
	<div align="center">
		<input name="" value="修改" class="formChange" type="submit">
		<input name="" value="重置" class="formReset" type="reset">
	</div>
</form>

</body></html>