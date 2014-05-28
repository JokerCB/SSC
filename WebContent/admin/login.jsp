<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>后台管理员登陆</title>
<link rel="stylesheet" href="skin/admin/layout.css" type="text/css" />
<!--[if IE]>
	<link rel="stylesheet" href="skin/admin/ie.css" type="text/css" />
	<script src="skin/js/html5.js"></script>
<![endif]-->
<script src="skin/js/jquery-1.7.2.min.js"></script>
<script src="skin/admin/onload.js"></script>
<script src="skin/admin/config.js"></script>
<script>
function checkLogin(){
	if(!this.username.value) throw('用户名不能为空');
	if(!this.password.value) throw('密码不能为空');
	if(!this.vcode.value) throw('验证码不能为空');
}

function doLogin(){
	var loginuser = $("#username").val();
    var typepw = $("#password").val();
    var url='./loging';
    var rq_post={};
    rq_post['flag']='login';
    rq_post['username']=loginuser;

    rq_post['password']=typepw;

	  rq_post['Submit']='json';

	  $.post(url,rq_post,function(data,textStatus){                        	

  		 var json = eval('(' + data + ')');
			
        var url=json['aLinks'];
        if(json['sMsg'] > "") {            
        	alert(json['sMsg']);       
            if(url > ""){
                location.href=(url[0]['url']);
            }       
	    }else{
	        if(url>""){
	            location.href=(url[0]['url']);
	        }
	    }
	   });
	 
}


//window.attachEvent("onload", correctPNG);
</script>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	background-color: #1b365f;
}
-->
</style>
</head>

<body>
<table width="100%" height="166" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td height="42" valign="top"><table width="100%" height="42" border="0" cellpadding="0" cellspacing="0" class="login_top_bg">
      <tr>
        <td width="1%" height="21">&nbsp;</td>
        <td height="42">&nbsp;</td>
        <td width="17%">&nbsp;</td>
      </tr>
    </table></td>
  </tr>
  <tr class="login-center">
    <td valign="top"><table width="100%" height="532" border="0" cellpadding="0" cellspacing="0" class="login_bg">
      <tr>
        <td width="49%"><table width="91%" height="532" border="0" cellpadding="0" cellspacing="0" class="login_bg2">
            <tr>
              <td height="138" valign="top"><table width="89%" height="427" border="0" cellpadding="0" cellspacing="0">
                <tr>
                  <td height="149">&nbsp;</td>
                </tr>
                <tr>
                  <td height="80" valign="top"><img src="/skin/admin/images/logo.png" width="279" height="68" style="float:right; margin-right:30px;"></td>
                </tr>
                <tr>
                  <td height="198" align="right" valign="top"><table width="100%" border="0" cellpadding="0" cellspacing="0">
                    <tr>
                      <td width="35%">&nbsp;</td>
                      <td height="25" colspan="2" class="left_txt"><p>后台管理系统只能管理员使用</p></td>
                    </tr>
                    <tr>
                      <td>&nbsp;</td>
                      <td height="25" colspan="2" class="left_txt"><p>非管理员用户请勿在此尝试登录</p></td>
                    </tr>
                    <tr>
                      <td>&nbsp;</td>
                      <td height="25" colspan="2" class="left_txt"><p>尝试暴力登录后台将被永久屏蔽</p></td>
                    </tr>
                  </table></td>
                </tr>
              </table></td>
            </tr>
            
        </table></td>
        <td width="1%" >&nbsp;</td>
        <td width="50%" valign="bottom"><table width="100%" height="59" border="0" align="center" cellpadding="0" cellspacing="0">
            <tr>
              <td width="4%">&nbsp;</td>
              <td width="96%" height="38"><span class="login_txt_bt">后台管理员登陆</span></td>
            </tr>
            <tr>
              <td>&nbsp;</td>
              <td height="21"><table cellSpacing="0" cellPadding="0" width="100%" border="0" height="328">
                  <tr>
                    <td height="164" colspan="2" align="middle"><form target="ajax" onajax="checkLogin" call="doLogin" action="" method="post" >
                        <table cellSpacing="0" cellPadding="0" width="100%" border="0" height="143">
                          <tr>
                            <td width="13%" height="38" class="login_hui_text"><span class="login_txt">管理员：&nbsp;&nbsp; </span></td>
                            <td height="38" colspan="2" class="login_hui_text"><input type="text" id="username" class="editbox4" value="" size="20">                            </td>
                          </tr>
                          <tr>
                            <td width="13%" height="35" class="login_hui_text"><span class="login_txt"> 密 码： &nbsp;&nbsp; </span></td>
                            <td height="35" colspan="2" class="login_hui_text"><input class="editbox4" type="password" size="20" id="password">
                              <img src="/skin/admin/images/luck.gif" width="19" height="18"> </td>
                          </tr>
                          <tr>
                            <td width="13%" height="35" class="login_hui_text"><span class="login_txt">验证码：</span></td>
                            <td height="35" colspan="2" class="login_hui_text"><input class="wenbenkuang" name="vcode" type="text" maxLength="4" size="10"/>
								<img align="absmiddle" onClick="" title="看不清楚，换一张图片" src="" width="72" height="24"/>
                            </td>
                          </tr>
                          <tr>
                            <td height="35" >&nbsp;</td>
                            <td width="20%" height="35" class="login_hui_text"><input type="submit" class="button" value="登 陆"> </td>
                            <td width="67%" class="login_hui_text">&nbsp;</td>
                          </tr>
                        </table>
                        <br>
                    </form></td>
                  </tr>
                  <tr>
                    <td width="433" height="164" align="right" valign="bottom"><img src="skin/admin/images/login-wel.gif" width="242" height="138"></td>
                    <td width="57" align="right" valign="bottom">&nbsp;</td>
                  </tr>
              </table></td>
            </tr>
          </table>
          </td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td height="20"><table width="100%" border="0" cellspacing="0" cellpadding="0" class="login-buttom-bg">
      <tr>
        <td align="center"><span class="login-buttom-txt">Copyright &copy; 后台管理系统</span></td>
      </tr>
    </table></td>
  </tr>
</table>
</body>
</html>