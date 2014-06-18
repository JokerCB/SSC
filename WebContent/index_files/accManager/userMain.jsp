<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" style="height: 100%;"><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link href="../index_files/a_data/base.css" rel="stylesheet" type="text/css" media="all">
<link href="../index_files/a_data/layout.css" rel="stylesheet" type="text/css" media="all">
<link href="../index_files/a_data/lottery_frame.css" media="all" type="text/css" rel="stylesheet">
<title></title>

<script type="text/javascript" src="../index_files/a_data/iepngfix_tilebg.js"></script>
<script type="text/javascript" src="../index_files/a_data/jquery-1.js"></script>


<script type="text/javascript" src="../index_files/a_data/iframe.js"></script>
<!--消息框代码开始-->
<script type="text/javascript" src="../index_files/a_data/jquery.js"></script>
<script type="text/javascript" src="../index_files/a_data/jquery_002.js"></script>
<link href="../index_files/a_data/dialogUI.css" media="all" type="text/css" rel="stylesheet">
<!--消息框代码结束-->
<script type="text/javascript" src="../index_files/a_data/main.js"></script>

</head>
<body style="height: 100%;">
            <div id="mainContent" style="height: 100%;">
<table class="topName" width="100%"><tbody><tr><td>
        <div class="bg clearfix">
        	<div id="siderbar">
                <ul class="list clearfix">
					<!-- <li class="current"><a page="userList" target="mainFrame">用户列表</a></li>
					<li><a page="userAdd" target="mainFrame">注册管理</a></li>
					<li><a page="orderList" target="mainFrame">彩种信息</a></li>
					<li><a href="" target="mainFrame">绑定卡号</a></li>
					<li><a href="" target="mainFrame">完善资料</a></li>
					<li><a href="" target="mainFrame">消息管理</a></li>
					<li><a href="" target="mainFrame">团队余额</a></li>
					<li><a href="" target="mainFrame">密码修改</a></li>
					<li><a href="" target="mainFrame">密保设定</a></li> -->
					<c:forEach items="${menus}" var="menu">
						<li style="cursor:pointer;"><a page="${menu.code }" target="mainFrame">${menu.name }</a></li>
					</c:forEach>
				</ul>
        
            </div>

</div></td></tr></tbody></table>
                <div id="contentBox" style="height: 100%;">
	                 <iframe allowtransparency="true" name="mainFrame" id="mainFrame" border="0" noresize="noresize" framespacing="0" 
	                 	frameborder="0" height="100%" scrolling="no" width="100%"></iframe>
                </div>
            </div>
        </div>
</body></html>


 <script type="text/javascript">
	$("#siderbar li").click(function(){
		$("#siderbar li").removeClass("current");
		$(this).addClass("current");
		$("#subtitle").html($(this).text());
		
		if($(this).find("a").attr("page")=="bindCard"){
			var pagePath = "/test/members/"+$(this).find("a").attr("page");
			$("#mainFrame").attr("src", pagePath);
		} else if($(this).find("a").attr("page")=="platwithdraw"){
			var pagePath = "/test/members/"+$(this).find("a").attr("page");
			$("#mainFrame").attr("src", pagePath);
		} else {
			var pagePath = top.basePath+"/index_files/accManager/"+$(this).find("a").attr("page")+".jsp";
			$("#mainFrame").attr("src", pagePath);
		}
		
	});
	$("#siderbar li")[0].click();
</script>