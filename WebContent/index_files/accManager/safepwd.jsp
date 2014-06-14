<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=9">
<title>杏彩游戏平台  - 资金密码检查 </title>
<link href="../index_files/a_data/base.css" rel="stylesheet" type="text/css" media="all">
<link href="../index_files/a_data/subpage.css" rel="stylesheet" type="text/css" media="all">
<script type="text/javascript" src="../index_files/a_data/jquery-1.js"></script>
<script type="text/javascript" src="../index_files/a_data/tab.js"></script>

<script type="text/javascript" src="../index_files/a_data/jquery_006.js"></script>
<script type="text/javascript" src="../index_files/a_data/jquery_003.js"></script>
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


<!-- 增加模拟键盘 开始 -->
<script type="text/javascript" src="../index_files/jquery_002.js"></script>
<script type="text/javascript" src="../index_files/jQuery-MD5.js"></script>
<link rel="stylesheet" type="text/css" media="all" href="../index_files/a_data/keypad.css">
<!-- 增加模拟键盘 结束 -->

<form action="../members/validsafepwd" method="post" name="updateform">
<input name="flag" value="check" type="hidden">
<input name="controller" value="security" type="hidden">
<input name="action" value="checkpass" type="hidden">
<input name="nextcon" value="user" type="hidden">
<input name="nextact" value="userbankinfo" type="hidden">
            <table class="formTable" border="0" cellpadding="0" cellspacing="0" width="100%">
              <tbody><tr>
                <th width="20%">输入提款密码：</th>
                <td><input readonly2="" class="hasKeypad" name="secpass" id="secpass" type="password">
                	<img class="keypad-trigger" src="../index_files/a_data/keyboard.png" alt="打开/关闭软键盘" title="打开/关闭软键盘"></td>
                <input name="nextcon" id="nextcon" value="user" type="hidden">
				<input name="nextact" id="nextact" value="userbankinfo" type="hidden">
				<input name="flag" id="flag" value="check" type="hidden">
              </tr>
            </tbody></table>
            <div align="center"><input name="" value="提交" onclick="" class="formSubmit" type="submit"><input name="" value="重置" class="formReset" onclick="this.form.reset()" type="reset"></div>
</form>

 <script language="javascript">
	jQuery(function(){
		jQuery("#secpass").keypad({
		layout: [
				$.keypad.SPACE + $.keypad.SPACE + $.keypad.SPACE + '1234567890',
				'cdefghijklmab', 
                                "stuvwxyznopqr"/*+ $.keypad.CLEAR*/,
                                $.keypad.SPACE + $.keypad.SPACE + $.keypad.SHIFT + $.keypad.CLEAR + $.keypad.BACK + $.keypad.CLOSE,
         		],
         // 软键盘按键布局 
		buttonImage:'./js/keypad/keyboard.png',	// 弹出(关闭)软键盘按钮图片地址
		buttonImageOnly: true,	// True 表示已图片形式显示, false 表示已按钮形式显示
		buttonStatus: '打开/关闭软键盘', // 打开/关闭软键盘按钮说明文字
		showOn: 'button', // 'focus'表示已输入框焦点弹出, 
			// 'button'通过按钮点击弹出,或者 'both' 表示两者都可以弹出 
			
		keypadOnly: false, // True 表示只接受软件盘输入, false 表示可以通过键盘和软键盘输入  
			
		randomiseNumeric: true, // True 表示对所以数字位置进行随机排列, false 不随机排列
		randomiseAlphabetic: true, // True 表示对字母进行随机排列, false 不随机排列 
		
                clearText: '清空', // Display text for clear link 
                clearStatus: '', // Status text for clear l
                
		shiftText: '大小写', // SHIFT 按键功能的键的显示文字 
		shiftStatus: '转换字母大小写', // SHIFT按键功能的TITLE说明文字 
		
		closeText: '关闭', // 关闭按键功能的显示文字 
		closeStatus: '关闭软键盘', // 关闭按键功能的TITLE说明文字 
		
		backText: '退格', // 退格功能键的显示文字 
		backStatus: '退格', // 退格功能键的说明文字
			   
		onClose: null	// 点击软键盘关闭是调用的函数
		});
	});
</script>

<!-- 增加模拟键盘 结束 --><div id="keypad-div" style="display: none;"></div></body></html>
<!-- 增加模拟键盘 开始 -->