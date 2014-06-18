<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=9">
<title></title>
<link href="../a_data/base.css" rel="stylesheet" type="text/css" media="all">
<link href="../a_data/subpage.css" rel="stylesheet" type="text/css" media="all">
<script type="text/javascript" src="../a_data/jquery-1.js"></script>
<script type="text/javascript" src="../a_data/tab.js"></script>
<script type="text/javascript" src="../jquery_006.js"></script>
<script type="text/javascript" src="../jquery_003.js"></script>
<link href="../a_data/dialogUI.css" media="all" type="text/css" rel="stylesheet">

<script type="text/javascript" src="../a_data/main.js"></script>
</head>

<body>
<script type="text/javascript">
//删除遮罩
if($("#laybox",parent.parent.document).length){
	$("#laybox",parent.parent.document).remove();
}
</script>
<a name="topall"></a>
<script type="text/javascript" src="../a_data/iepngfix_tilebg.js"></script>

<div class="right_02 d5d8de"> 请点击彩种查看数据</div>
<div class="right_02 d5d8de" id="menus">
 <div class="sblsbb lsbb fronted" style="float:left; cursor:pointer" id="tabbar_1_37" onclick="testfunc(1,37);">  重庆时时彩 </div>
 <div class="sblsbb lsbb kpbb" style="float:left; cursor:pointer" id="tabbar_11_220" onclick="testfunc(11,220);">  福彩3D </div>
 
</div>

<div style="clear:left">
</div>    

<div class="right_02 d5d8de">


<table class="formTable" border="0" cellpadding="4" cellspacing="1" width="100%">

    <tbody><tr class="ttf">
      <td align="center" bgcolor="#67686b" width="20%">玩法类型
      </td><td align="center" bgcolor="#67686b" width="20%">赔率
      </td><td id="point_284" align="center" bgcolor="#67686b" width="20%">返点
    </td></tr>
</tbody><tbody id="method-detail">
</tbody>
  </table>
</div>
<script>
//生成玩法列表
function create_method(data,x)
{
	$("#method-detail").html("");

	if(data.length > 1)
	{
    	jQuery.each(data,function(i,v){

    		html = "<tr align='center'>";
    		html = html+"<td bgcolor=\"#F6F6F6\">"+v.name+"</td>";

    		html = html+"<td bgcolor=\"#F6F6F6\"><span>"+v.bonusPropMin+"</span></td>";
    		
    		if(v.name.indexOf("不定胆") != -1)
    			html = html+"<td bgcolor=\"#F6F6F6\">"+top.fandianbdw+"</td>";
    		else
    			html = html+"<td bgcolor=\"#F6F6F6\">"+top.fandian+"</td>";
    		html = html+"</tr>";
			
    		jQuery("#method-detail").append(html);	
    	});
	
	}
	else
	{
       // jQuery("#lottery_"+x).remove();
	}
}

function testfunc(lotteryid,groupid){
	var rq_post={};
    rq_post['type']= lotteryid;
	$.ajax({
		type:"POST",
		url:"../../test/findByType",
		data:rq_post,
		contentType:"application/x-www-form-urlencoded;charset=UTF-8",
		success:function(data){
			create_method(eval("("+data+")"),lotteryid);
		}
	});
	top.SetIframeHeight();
	}
$(function (){	
	testfunc(1,37);
});
</script>

</body></html>