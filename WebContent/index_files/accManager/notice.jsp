<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=9">
<title>杏彩游戏平台 - 我的团队</title>
<link href="../index_files/a_data/base.css" rel="stylesheet" type="text/css" media="all">
<link href="../index_files/a_data/subpage.css" rel="stylesheet" type="text/css" media="all">
<link href="../index_files/a_data/dialogUI.css" media="all" type="text/css" rel="stylesheet">
</head>

<body>
	<div class="list-div" id="listDiv">
		<table class="formTable" id="list-table" align="center" cellpadding="3" cellspacing="1" style="width: 99%;">
			<tbody>
				<c:forEach var="list" items="${list }">
					<tr>
						<td align="right" style="width: 80px;"><fmt:formatDate value="${list.createDate}" pattern="yyyy-MM-dd"/></td>
						<td>${list.content }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>