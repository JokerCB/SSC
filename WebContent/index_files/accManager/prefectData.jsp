<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=9">
<title>杏彩游戏平台  - 完善资料 </title>
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
<script type="text/javascript" src="../index_files/jquery_006.js"></script>
<script type="text/javascript" src="../index_files/jquery_003.js"></script>
<link href="../index_files/a_data/dialogUI.css" media="all" type="text/css" rel="stylesheet">
<!--消息框代码结束-->
<script type="text/javascript">
function checkform(obj)
{
  if( !validateNickName(obj.nickname.value) )
  {
  	$.alert("昵称不符合规则，请重新输入");
	obj.nickname.focus();
	return false;
  }
  return true;
}
</script>
<form action="index.php" method="post" name="updateform" onsubmit="return checkform(this)">
<input name="flag" value="update" type="hidden">
<input name="controller" value="user" type="hidden">
<input name="action" value="changename" type="hidden">
<input name="flag" value="update" type="hidden">
<input name="pre" value="preinfo" type="hidden">
            <table class="formTable" border="0" cellpadding="0" cellspacing="0" width="100%">
              <tbody><tr>
                <th width="20%">用户昵称：</th>
                <td><input name="nickname" value="ni" type="text"> <span class="red">(由2至6个字符组成)</span></td>
              </tr>
			<tr>
				<!--
				增加预留信息：2014年4月2日：julian
				-->
				<th width="20%">预留信息：</th>
				<td><input name="preinfo" value="你好" type="text"><span class="red">(为防止钓鱼网站骗取您的钱财，请务必填写此信息，由1至6个汉字组成)</span></td>
			</tr>
            </tbody></table>
            <div align="center">
            <input name="" value="修改" class="formChange" type="submit"><input name="" value="重置" class="formReset" onclick="form.reset()" type="reset"></div>
        </form>
<br><br><br><br><br>


</body></html>