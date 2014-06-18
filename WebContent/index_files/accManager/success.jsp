<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=9">
<title>杏彩游戏平台</title>
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
		if ($("#laybox", parent.parent.document).length) {
			$("#laybox", parent.parent.document).remove();
		}
	</script>
	<a name="topall"></a>
	<div style="display: none;">
		<a href="http://www.live800.com/">客服</a>
	</div>
	<div style="display: none;">
		<a href="http://en.live800.com/">live chat</a>
	</div>
	<div id="success">
		<h3 class="title">
			<font color="#669900">
				<c:choose>
					<c:when test="${empty noticeWord}">
						操作成功！
					</c:when>
					<c:otherwise>
						${noticeWord}
					</c:otherwise>
				</c:choose>
			</font>
		</h3>
		<p>
			<c:choose>
				<c:when test="${empty noticeHref}">
					<a href="javascript:history.back(-1);"
						target="_self" class="underline">返回上一步</a>
				</c:when>
				<c:otherwise>
					<a href="${noticeHref}"
						target="_self" class="underline">${noticeButton}</a>
				</c:otherwise>
			</c:choose>
		</p>
	</div>

</body>
</html>