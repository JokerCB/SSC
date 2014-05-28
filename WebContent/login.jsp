<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="login_files/dialogUI.css" media="all" type="text/css" rel="stylesheet">
        <link href="login_files/login_style.css" media="all" type="text/css" rel="stylesheet">
            
		<script type="text/javascript" src="login_files/jquery-1.js"></script>
		<script language="javascript" type="text/javascript" src="login_files/jquery_002.js"></script>
		<script type="text/javascript" src="login_files/jquery_003.js"></script>   
		<link rel="stylesheet" type="text/css" media="all" href="login_files/keypad.css">
           
          
            
        <!--消息框代码结束-->
        <title>杏彩娱乐平台</title>
    </head>
        <body style="overflow:hidden;">
            <div id="wrap">
                <div id="login_box_top"></div>
                <div id="login_box">
                    <ul>
                        <li><label>用户名称</label> <input name="userName" id="userName" class="login_un" type="text"></li>
                        <li><label>用户密码</label> <input readonly2="" name="password" id="password" class="login_ps hasKeypad" type="password"><img class="keypad-trigger" src="login_files/keyboard.png" alt="打开/关闭软键盘" title="打开/关闭软键盘"></li>
                       
                        <li style="padding-left:15px;"><label>验证码</label>
                            <input name="code" id="code" class="login_code" type="text">
                            <span class="code_img"><img valign="bottom" onclick="refreshimg()" title="点击刷新" style="cursor:pointer; border: 0px solid #999" id="validate" name="validate" src="login_files/a.png" align="absbottom"></span>
                        </li>
                    </ul>
                    <div class="s_bin"><input id="submit" value="" onclick="LoginNow();" class="login_btn" type="submit"><a href="http://www.luckyssc.net/forgotpasswd" class="forget_ps" target="_blank">忘记密码?</a></div>
                </div>
                <div class="bottom_text">温馨提醒：本站最佳浏览器分辨率为(1024×768)请使用IE7.0以上或谷歌/火狐浏览器<br>Copyright©2012-2014 SinCai 版权所有 杏彩娱乐 </div>
                <div style="clear:both; margin:0 auto; width:401px; height:92px;"><a href="http://www.luckyssc.net/down.html" target="_blank"><img src="login_files/download.jpg" border="0"></a></div>
            </div>
            <div></div>
           

            <!--消息框代码开始-->
            <script type="text/javascript" src="login_files/jquery_004.js"></script>
            <script type="text/javascript" src="login_files/jquery.js"></script>
            <script type="text/javascript" src="login_files/login.js"></script>
            <script type="text/javascript">
                function LoginNow() {
                     var loginuser = $("#userName").val();
                     var typepw = $("#password").val();

					 					var randnum = $("#code").val().toUpperCase();
										 //var randnum = $("#code").val().toUpperCase();
                   
				   
                        if (loginuser == ''){
                            $.alert('请填写用户名称');
                            $("#userName").focus();
                            return false;
                        }
                        if  (typepw == '') {
                            $.alert('请填写登录密码');
                            $("#password").focus();
                            return false;
                        }
						
                                                     if (randnum == '') {
                                $.alert('请填写数字验证码');
                                $("#code").focus();
                                return false;
                            }
                        						

                        var submitvc = $.md5(randnum);
                        var submitpw = $.md5( submitvc + $.md5(typepw) );
                        var url='./loging';
                        var rq_post={};
                        rq_post['flag']='login';
                        rq_post['username']=loginuser;
                    //    rq_post['password']=submitpw;
                    	rq_post['password']=typepw;
												rq_post['valiCode']=randnum;
						 						rq_post['Submit']='json';

                        $.post(url,rq_post,function(data,textStatus){                        	
                         //   var json=jsonParse(data);
                      		 var json = eval('(' + data + ')');
							
                            var url=json['aLinks'];
                            if(json['sMsg'] > "") {
                                $.alert(json['sMsg'],'提示',function(){//暂时为原生ALERT
                                    if(json['sError']=='555'){//johnson
                                        location.href="http://www.baidu.com";
                                        return false;
                                    }else if(json['sMsg']=='用户名和密码错误, 请重新登陆'){
                                        $('#password').focus();
                                        $('#password').select();
                                    }
                                if(url > ""){
                                    location.href=(url[0]['url']);
                                }
                            });
                        }else{
                            if(url>""){
                                location.href=(url[0]['url']);
                            }
                        }
                    });
                }
            </script>
        
 <script language="javascript">
	jQuery(function(){
		jQuery("#password").keypad({
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
</script><div id="keypad-div" style="display: none;"></div></body></html>