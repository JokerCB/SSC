<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=9">
<title>杏彩游戏平台  - 购彩查询 </title>
<link href="../index_files/a_data/base.css" rel="stylesheet" type="text/css" media="all">
<link href="../index_files/a_data/subpage.css" rel="stylesheet" type="text/css" media="all">
<script type="text/javascript" src="../index_files/a_data/jquery-1.js"></script>
<script type="text/javascript" src="../index_files/a_data/tab.js"></script>

<script type="text/javascript" src="../index_files/a_data/jquery_005.js"></script>
<script type="text/javascript" src="../index_files/a_data/jquery_003.js"></script>
<link href="../index_files/a_data/dialogUI.css" media="all" type="text/css" rel="stylesheet">

<script type="text/javascript" src="../index_files/a_data/main.js"></script>
<script type="text/javascript" src="../index_files/a_data/page.js"></script>
</head>

<body>
<script type="text/javascript">
//删除遮罩
if($("#laybox",parent.parent.document).length){
	$("#laybox",parent.parent.document).remove();
}
</script>
<a name="topall"></a>
<script type="text/javascript" src="../index_files/a_data/jquery_004.js"></script>
<script type="text/javascript" src="../index_files/a_data/calendar-utf8.js"></script>
<link rel="stylesheet" type="text/css" media="all" href="../index_files/a_data/calendar-win2k-cold-1.css">
<script>
function show_no(id)
{
	$("#code_"+id).show("slow");
}
function show_nocode(id)
{
	$("#ncode_"+id).show("slow");
}
function close_no(id)
{
	$("#code_"+id).hide("slow");
}
function nclose_no(id)
{
	$("#ncode_"+id).hide("slow");
}
jQuery(document).ready(function() {
	jQuery("#starttime").dynDateTime({
		ifFormat: "%Y-%m-%d %H:%M:00",
		daFormat: "%l;%M %p, %e %m,  %Y",
		position:Array(309,30),//johnson
		electric: true,
		singleClick: false,
		button: ".next()", //next sibling
		onUpdate:function(){
			$("#starttime").change();
		},
		showOthers: true,
		weekNumbers: true,
		showsTime: true
	});
	jQuery("#starttime").change(function(){
            jQuery("#recentproject").attr('value','0');
		if(! validateInputDate(jQuery("#starttime").val()) )
		{
			jQuery("#starttime").val('');
			$.alert("时间格式不正确,正确的格式为:2009-06-10 10:59");
		}
		if($("#endtime").val()!="")
		{
			if($("#starttime").val()>$("#endtime").val())
			{
				$("#starttime").val("");
				$.alert("输入的时间不符合逻辑.");
			}
		}
	});
	jQuery("#endtime").dynDateTime({
		ifFormat: "%Y-%m-%d %H:%M:00",
		daFormat: "%l;%M %p, %e %m,  %Y",
		align: "Br",
		position:Array(380,30),
		electric: true,
		singleClick: false,
		button: ".next()", //next sibling
		onUpdate:function(){
			$("#endtime").change();
		},
		showOthers: true,
		weekNumbers: true,
		showsTime: true
	});
	jQuery("#endtime").change(function(){
            jQuery("#recentproject").attr('value','0');
		if(! validateInputDate(jQuery("#endtime").val()) )
		{
			jQuery("#endtime").val('');
			$.alert("时间格式不正确,正确的格式为:2009-06-10 10:59");
		}
		if($("#starttime").val()!="")
		{
			if($("#starttime").val()>$("#endtime").val())
			{
				$("#endtime").val("");
				$.alert("输入的时间不符合逻辑.");
			}
		}
	});
	
	var data_method = eval('(' + '${data_method}' + ')');
	console.log(data_method);
	
	jQuery("#lotteryid").change(function(){
	
	//	var data_method = {"1":{"2":{"lotteryid":"1","methodid":"2","methodname":"\u524d\u4e09\u76f4\u9009"},"3":{"lotteryid":"1","methodid":"3","methodname":"\u524d\u4e09\u76f4\u9009_\u548c\u503c"},"5":{"lotteryid":"1","methodid":"5","methodname":"\u540e\u4e09\u76f4\u9009"},"6":{"lotteryid":"1","methodid":"6","methodname":"\u540e\u4e09\u76f4\u9009_\u548c\u503c"},"8":{"lotteryid":"1","methodid":"8","methodname":"\u524d\u4e09\u7ec4\u9009_\u7ec4\u4e09"},"9":{"lotteryid":"1","methodid":"9","methodname":"\u524d\u4e09\u7ec4\u9009_\u7ec4\u516d"},"10":{"lotteryid":"1","methodid":"10","methodname":"\u524d\u4e09\u7ec4\u9009_\u6df7\u5408"},"11":{"lotteryid":"1","methodid":"11","methodname":"\u524d\u4e09\u7ec4\u9009_\u548c\u503c"},"13":{"lotteryid":"1","methodid":"13","methodname":"\u540e\u4e09\u7ec4\u9009_\u7ec4\u4e09"},"14":{"lotteryid":"1","methodid":"14","methodname":"\u540e\u4e09\u7ec4\u9009_\u7ec4\u516d"},"15":{"lotteryid":"1","methodid":"15","methodname":"\u540e\u4e09\u7ec4\u9009_\u6df7\u5408"},"16":{"lotteryid":"1","methodid":"16","methodname":"\u540e\u4e09\u7ec4\u9009_\u548c\u503c"},"18":{"lotteryid":"1","methodid":"18","methodname":"\u540e\u4e09\u4e00\u7801\u4e0d\u5b9a\u80c6"},"20":{"lotteryid":"1","methodid":"20","methodname":"\u540e\u4e09\u4e8c\u7801\u4e0d\u5b9a\u80c6"},"22":{"lotteryid":"1","methodid":"22","methodname":"\u524d\u4e8c\u76f4\u9009"},"24":{"lotteryid":"1","methodid":"24","methodname":"\u540e\u4e8c\u76f4\u9009"},"26":{"lotteryid":"1","methodid":"26","methodname":"\u524d\u4e8c\u7ec4\u9009"},"28":{"lotteryid":"1","methodid":"28","methodname":"\u540e\u4e8c\u7ec4\u9009"},"30":{"lotteryid":"1","methodid":"30","methodname":"\u4e07\u4f4d"},"31":{"lotteryid":"1","methodid":"31","methodname":"\u5343\u4f4d"},"32":{"lotteryid":"1","methodid":"32","methodname":"\u767e\u4f4d"},"33":{"lotteryid":"1","methodid":"33","methodname":"\u5341\u4f4d"},"34":{"lotteryid":"1","methodid":"34","methodname":"\u4e2a\u4f4d"},"36":{"lotteryid":"1","methodid":"36","methodname":"\u524d\u4e8c\u5927\u5c0f\u5355\u53cc"},"38":{"lotteryid":"1","methodid":"38","methodname":"\u540e\u4e8c\u5927\u5c0f\u5355\u53cc"},"453":{"lotteryid":"1","methodid":"453","methodname":"\u524d\u4e09\u7ec4\u9009_\u5305\u80c6"},"463":{"lotteryid":"1","methodid":"463","methodname":"\u540e\u4e09\u7ec4\u9009_\u5305\u80c6"},"472":{"lotteryid":"1","methodid":"472","methodname":"\u524d\u4e8c\u76f4\u9009\u548c\u503c"},"474":{"lotteryid":"1","methodid":"474","methodname":"\u540e\u4e8c\u76f4\u9009\u548c\u503c"},"476":{"lotteryid":"1","methodid":"476","methodname":"\u524d\u4e8c\u7ec4\u9009\u548c\u503c"},"478":{"lotteryid":"1","methodid":"478","methodname":"\u540e\u4e8c\u7ec4\u9009\u548c\u503c"},"512":{"lotteryid":"1","methodid":"512","methodname":"\u524d\u4e09\u4e00\u7801\u4e0d\u5b9a\u80c6"},"513":{"lotteryid":"1","methodid":"513","methodname":"\u524d\u4e09\u4e8c\u7801\u4e0d\u5b9a\u80c6"},"2265":{"lotteryid":"1","methodid":"2265","methodname":"\u56db\u661f\u76f4\u9009"},"2267":{"lotteryid":"1","methodid":"2267","methodname":"\u56db\u661f\u7ec4\u5408"},"2269":{"lotteryid":"1","methodid":"2269","methodname":"\u7ec4\u900924"},"2270":{"lotteryid":"1","methodid":"2270","methodname":"\u7ec4\u900912"},"2271":{"lotteryid":"1","methodid":"2271","methodname":"\u7ec4\u90096"},"2272":{"lotteryid":"1","methodid":"2272","methodname":"\u7ec4\u90094"},"2274":{"lotteryid":"1","methodid":"2274","methodname":"\u4e94\u661f\u76f4\u9009"},"2276":{"lotteryid":"1","methodid":"2276","methodname":"\u4e94\u661f\u7ec4\u5408"},"2278":{"lotteryid":"1","methodid":"2278","methodname":"\u4e94\u661f\u7ec4\u9009120"},"2279":{"lotteryid":"1","methodid":"2279","methodname":"\u4e94\u661f\u7ec4\u900960"},"2280":{"lotteryid":"1","methodid":"2280","methodname":"\u4e94\u661f\u7ec4\u900930"},"2281":{"lotteryid":"1","methodid":"2281","methodname":"\u4e94\u661f\u7ec4\u900920"},"2282":{"lotteryid":"1","methodid":"2282","methodname":"\u4e94\u661f\u7ec4\u900910"},"2283":{"lotteryid":"1","methodid":"2283","methodname":"\u4e94\u661f\u7ec4\u90095"},"2285":{"lotteryid":"1","methodid":"2285","methodname":"\u4e00\u5e06\u98ce\u987a"},"2286":{"lotteryid":"1","methodid":"2286","methodname":"\u597d\u4e8b\u6210\u53cc"},"2287":{"lotteryid":"1","methodid":"2287","methodname":"\u4e09\u661f\u62a5\u559c"},"2288":{"lotteryid":"1","methodid":"2288","methodname":"\u56db\u5b63\u53d1\u8d22"},"2291":{"lotteryid":"1","methodid":"2291","methodname":"\u4e2d\u4e09\u76f4\u9009"},"2292":{"lotteryid":"1","methodid":"2292","methodname":"\u4e2d\u4e09\u76f4\u9009_\u548c\u503c"},"2293":{"lotteryid":"1","methodid":"2293","methodname":"\u4e2d\u4e09\u7ec4\u9009_\u7ec4\u4e09"},"2294":{"lotteryid":"1","methodid":"2294","methodname":"\u4e2d\u4e09\u7ec4\u9009_\u7ec4\u516d"},"2295":{"lotteryid":"1","methodid":"2295","methodname":"\u4e2d\u4e09\u7ec4\u9009_\u6df7\u5408"},"2296":{"lotteryid":"1","methodid":"2296","methodname":"\u4e2d\u4e09\u7ec4\u9009_\u548c\u503c"}},"3":{"126":{"lotteryid":"3","methodid":"126","methodname":"\u524d\u4e09\u76f4\u9009"},"127":{"lotteryid":"3","methodid":"127","methodname":"\u524d\u4e09\u76f4\u9009_\u548c\u503c"},"129":{"lotteryid":"3","methodid":"129","methodname":"\u540e\u4e09\u76f4\u9009"},"130":{"lotteryid":"3","methodid":"130","methodname":"\u540e\u4e09\u76f4\u9009_\u548c\u503c"},"132":{"lotteryid":"3","methodid":"132","methodname":"\u524d\u4e09\u7ec4\u9009_\u7ec4\u4e09"},"133":{"lotteryid":"3","methodid":"133","methodname":"\u524d\u4e09\u7ec4\u9009_\u7ec4\u516d"},"134":{"lotteryid":"3","methodid":"134","methodname":"\u524d\u4e09\u7ec4\u9009_\u6df7\u5408"},"135":{"lotteryid":"3","methodid":"135","methodname":"\u524d\u4e09\u7ec4\u9009_\u548c\u503c"},"137":{"lotteryid":"3","methodid":"137","methodname":"\u540e\u4e09\u7ec4\u9009_\u7ec4\u4e09"},"138":{"lotteryid":"3","methodid":"138","methodname":"\u540e\u4e09\u7ec4\u9009_\u7ec4\u516d"},"139":{"lotteryid":"3","methodid":"139","methodname":"\u540e\u4e09\u7ec4\u9009_\u6df7\u5408"},"140":{"lotteryid":"3","methodid":"140","methodname":"\u540e\u4e09\u7ec4\u9009_\u548c\u503c"},"142":{"lotteryid":"3","methodid":"142","methodname":"\u4e00\u7801\u4e0d\u5b9a\u80c6"},"144":{"lotteryid":"3","methodid":"144","methodname":"\u4e8c\u7801\u4e0d\u5b9a\u80c6"},"146":{"lotteryid":"3","methodid":"146","methodname":"\u524d\u4e8c\u76f4\u9009"},"148":{"lotteryid":"3","methodid":"148","methodname":"\u540e\u4e8c\u76f4\u9009"},"150":{"lotteryid":"3","methodid":"150","methodname":"\u524d\u4e8c\u7ec4\u9009"},"152":{"lotteryid":"3","methodid":"152","methodname":"\u540e\u4e8c\u7ec4\u9009"},"154":{"lotteryid":"3","methodid":"154","methodname":"\u4e07\u4f4d"},"155":{"lotteryid":"3","methodid":"155","methodname":"\u5343\u4f4d"},"156":{"lotteryid":"3","methodid":"156","methodname":"\u767e\u4f4d"},"157":{"lotteryid":"3","methodid":"157","methodname":"\u5341\u4f4d"},"158":{"lotteryid":"3","methodid":"158","methodname":"\u4e2a\u4f4d"},"160":{"lotteryid":"3","methodid":"160","methodname":"\u524d\u4e8c\u5927\u5c0f\u5355\u53cc"},"162":{"lotteryid":"3","methodid":"162","methodname":"\u540e\u4e8c\u5927\u5c0f\u5355\u53cc"}},"5":{"220":{"lotteryid":"5","methodid":"220","methodname":"\u524d\u4e09\u76f4\u9009"},"222":{"lotteryid":"5","methodid":"222","methodname":"\u524d\u4e09\u7ec4\u9009"},"224":{"lotteryid":"5","methodid":"224","methodname":"\u524d\u4e8c\u76f4\u9009"},"226":{"lotteryid":"5","methodid":"226","methodname":"\u524d\u4e8c\u7ec4\u9009"},"228":{"lotteryid":"5","methodid":"228","methodname":"\u524d\u4e09\u4f4d"},"230":{"lotteryid":"5","methodid":"230","methodname":"\u7b2c\u4e00\u4f4d"},"231":{"lotteryid":"5","methodid":"231","methodname":"\u7b2c\u4e8c\u4f4d"},"232":{"lotteryid":"5","methodid":"232","methodname":"\u7b2c\u4e09\u4f4d"},"234":{"lotteryid":"5","methodid":"234","methodname":"\u5b9a\u5355\u53cc"},"236":{"lotteryid":"5","methodid":"236","methodname":"\u731c\u4e2d\u4f4d"},"238":{"lotteryid":"5","methodid":"238","methodname":"\u4efb\u9009\u4e00\u4e2d\u4e00"},"240":{"lotteryid":"5","methodid":"240","methodname":"\u4efb\u9009\u4e8c\u4e2d\u4e8c"},"243":{"lotteryid":"5","methodid":"243","methodname":"\u4efb\u9009\u4e09\u4e2d\u4e09"},"246":{"lotteryid":"5","methodid":"246","methodname":"\u4efb\u9009\u56db\u4e2d\u56db"},"249":{"lotteryid":"5","methodid":"249","methodname":"\u4efb\u9009\u4e94\u4e2d\u4e94"},"252":{"lotteryid":"5","methodid":"252","methodname":"\u4efb\u9009\u516d\u4e2d\u4e94"},"255":{"lotteryid":"5","methodid":"255","methodname":"\u4efb\u9009\u4e03\u4e2d\u4e94"},"258":{"lotteryid":"5","methodid":"258","methodname":"\u4efb\u9009\u516b\u4e2d\u4e94"}},"6":{"265":{"lotteryid":"6","methodid":"265","methodname":"\u524d\u4e09\u76f4\u9009"},"266":{"lotteryid":"6","methodid":"266","methodname":"\u524d\u4e09\u76f4\u9009_\u548c\u503c"},"268":{"lotteryid":"6","methodid":"268","methodname":"\u540e\u4e09\u76f4\u9009"},"269":{"lotteryid":"6","methodid":"269","methodname":"\u540e\u4e09\u76f4\u9009_\u548c\u503c"},"271":{"lotteryid":"6","methodid":"271","methodname":"\u524d\u4e09\u7ec4\u9009_\u7ec4\u4e09"},"272":{"lotteryid":"6","methodid":"272","methodname":"\u524d\u4e09\u7ec4\u9009_\u7ec4\u516d"},"273":{"lotteryid":"6","methodid":"273","methodname":"\u524d\u4e09\u7ec4\u9009_\u6df7\u5408"},"274":{"lotteryid":"6","methodid":"274","methodname":"\u524d\u4e09\u7ec4\u9009_\u548c\u503c"},"276":{"lotteryid":"6","methodid":"276","methodname":"\u540e\u4e09\u7ec4\u9009_\u7ec4\u4e09"},"277":{"lotteryid":"6","methodid":"277","methodname":"\u540e\u4e09\u7ec4\u9009_\u7ec4\u516d"},"278":{"lotteryid":"6","methodid":"278","methodname":"\u540e\u4e09\u7ec4\u9009_\u6df7\u5408"},"279":{"lotteryid":"6","methodid":"279","methodname":"\u540e\u4e09\u7ec4\u9009_\u548c\u503c"},"281":{"lotteryid":"6","methodid":"281","methodname":"\u4e00\u7801\u4e0d\u5b9a\u80c6"},"283":{"lotteryid":"6","methodid":"283","methodname":"\u4e8c\u7801\u4e0d\u5b9a\u80c6"},"285":{"lotteryid":"6","methodid":"285","methodname":"\u524d\u4e8c\u76f4\u9009"},"287":{"lotteryid":"6","methodid":"287","methodname":"\u540e\u4e8c\u76f4\u9009"},"289":{"lotteryid":"6","methodid":"289","methodname":"\u524d\u4e8c\u7ec4\u9009"},"291":{"lotteryid":"6","methodid":"291","methodname":"\u540e\u4e8c\u7ec4\u9009"},"293":{"lotteryid":"6","methodid":"293","methodname":"\u4e07\u4f4d"},"294":{"lotteryid":"6","methodid":"294","methodname":"\u5343\u4f4d"},"295":{"lotteryid":"6","methodid":"295","methodname":"\u767e\u4f4d"},"296":{"lotteryid":"6","methodid":"296","methodname":"\u5341\u4f4d"},"297":{"lotteryid":"6","methodid":"297","methodname":"\u4e2a\u4f4d"},"299":{"lotteryid":"6","methodid":"299","methodname":"\u524d\u4e8c\u5927\u5c0f\u5355\u53cc"},"301":{"lotteryid":"6","methodid":"301","methodname":"\u540e\u4e8c\u5927\u5c0f\u5355\u53cc"}},"7":{"303":{"lotteryid":"7","methodid":"303","methodname":"\u524d\u4e09\u76f4\u9009"},"305":{"lotteryid":"7","methodid":"305","methodname":"\u524d\u4e09\u7ec4\u9009"},"307":{"lotteryid":"7","methodid":"307","methodname":"\u524d\u4e8c\u76f4\u9009"},"309":{"lotteryid":"7","methodid":"309","methodname":"\u524d\u4e8c\u7ec4\u9009"},"311":{"lotteryid":"7","methodid":"311","methodname":"\u524d\u4e09\u4f4d"},"313":{"lotteryid":"7","methodid":"313","methodname":"\u7b2c\u4e00\u4f4d"},"314":{"lotteryid":"7","methodid":"314","methodname":"\u7b2c\u4e8c\u4f4d"},"315":{"lotteryid":"7","methodid":"315","methodname":"\u7b2c\u4e09\u4f4d"},"317":{"lotteryid":"7","methodid":"317","methodname":"\u5b9a\u5355\u53cc"},"319":{"lotteryid":"7","methodid":"319","methodname":"\u731c\u4e2d\u4f4d"},"321":{"lotteryid":"7","methodid":"321","methodname":"\u4efb\u9009\u4e00\u4e2d\u4e00"},"323":{"lotteryid":"7","methodid":"323","methodname":"\u4efb\u9009\u4e8c\u4e2d\u4e8c"},"325":{"lotteryid":"7","methodid":"325","methodname":"\u4efb\u9009\u4e09\u4e2d\u4e09"},"327":{"lotteryid":"7","methodid":"327","methodname":"\u4efb\u9009\u56db\u4e2d\u56db"},"329":{"lotteryid":"7","methodid":"329","methodname":"\u4efb\u9009\u4e94\u4e2d\u4e94"},"331":{"lotteryid":"7","methodid":"331","methodname":"\u4efb\u9009\u516d\u4e2d\u4e94"},"333":{"lotteryid":"7","methodid":"333","methodname":"\u4efb\u9009\u4e03\u4e2d\u4e94"},"335":{"lotteryid":"7","methodid":"335","methodname":"\u4efb\u9009\u516b\u4e2d\u4e94"}},"8":{"337":{"lotteryid":"8","methodid":"337","methodname":"\u524d\u4e09\u76f4\u9009"},"339":{"lotteryid":"8","methodid":"339","methodname":"\u524d\u4e09\u7ec4\u9009"},"341":{"lotteryid":"8","methodid":"341","methodname":"\u524d\u4e8c\u76f4\u9009"},"343":{"lotteryid":"8","methodid":"343","methodname":"\u524d\u4e8c\u7ec4\u9009"},"345":{"lotteryid":"8","methodid":"345","methodname":"\u524d\u4e09\u4f4d"},"347":{"lotteryid":"8","methodid":"347","methodname":"\u7b2c\u4e00\u4f4d"},"348":{"lotteryid":"8","methodid":"348","methodname":"\u7b2c\u4e8c\u4f4d"},"349":{"lotteryid":"8","methodid":"349","methodname":"\u7b2c\u4e09\u4f4d"},"351":{"lotteryid":"8","methodid":"351","methodname":"\u5b9a\u5355\u53cc"},"353":{"lotteryid":"8","methodid":"353","methodname":"\u731c\u4e2d\u4f4d"},"355":{"lotteryid":"8","methodid":"355","methodname":"\u4efb\u9009\u4e00\u4e2d\u4e00"},"357":{"lotteryid":"8","methodid":"357","methodname":"\u4efb\u9009\u4e8c\u4e2d\u4e8c"},"359":{"lotteryid":"8","methodid":"359","methodname":"\u4efb\u9009\u4e09\u4e2d\u4e09"},"361":{"lotteryid":"8","methodid":"361","methodname":"\u4efb\u9009\u56db\u4e2d\u56db"},"363":{"lotteryid":"8","methodid":"363","methodname":"\u4efb\u9009\u4e94\u4e2d\u4e94"},"365":{"lotteryid":"8","methodid":"365","methodname":"\u4efb\u9009\u516d\u4e2d\u4e94"},"367":{"lotteryid":"8","methodid":"367","methodname":"\u4efb\u9009\u4e03\u4e2d\u4e94"},"369":{"lotteryid":"8","methodid":"369","methodname":"\u4efb\u9009\u516b\u4e2d\u4e94"}},"9":{"385":{"lotteryid":"9","methodid":"385","methodname":"\u548c\u503c\u5355\u53cc"},"387":{"lotteryid":"9","methodid":"387","methodname":"\u548c\u503c\u5927\u5c0f"},"389":{"lotteryid":"9","methodid":"389","methodname":"\u4e0a\u4e0b\u76d8"},"391":{"lotteryid":"9","methodid":"391","methodname":"\u5947\u5076\u76d8"},"427":{"lotteryid":"9","methodid":"427","methodname":"\u548c\u503c\u5927\u5c0f\u5355\u53cc"},"2304":{"lotteryid":"9","methodid":"2304","methodname":"\u4efb\u9009\u4e00"},"2305":{"lotteryid":"9","methodid":"2305","methodname":"\u4efb\u9009\u4e8c"},"2306":{"lotteryid":"9","methodid":"2306","methodname":"\u4efb\u9009\u4e09"},"2307":{"lotteryid":"9","methodid":"2307","methodname":"\u4efb\u9009\u56db"},"2308":{"lotteryid":"9","methodid":"2308","methodname":"\u4efb\u9009\u4e94"},"2309":{"lotteryid":"9","methodid":"2309","methodname":"\u4efb\u9009\u516d"},"2310":{"lotteryid":"9","methodid":"2310","methodname":"\u4efb\u9009\u4e03"}},"10":{"393":{"lotteryid":"10","methodid":"393","methodname":"\u524d\u4e09\u76f4\u9009"},"395":{"lotteryid":"10","methodid":"395","methodname":"\u524d\u4e09\u7ec4\u9009"},"397":{"lotteryid":"10","methodid":"397","methodname":"\u524d\u4e8c\u76f4\u9009"},"399":{"lotteryid":"10","methodid":"399","methodname":"\u524d\u4e8c\u7ec4\u9009"},"401":{"lotteryid":"10","methodid":"401","methodname":"\u524d\u4e09\u4f4d"},"403":{"lotteryid":"10","methodid":"403","methodname":"\u7b2c\u4e00\u4f4d"},"404":{"lotteryid":"10","methodid":"404","methodname":"\u7b2c\u4e8c\u4f4d"},"405":{"lotteryid":"10","methodid":"405","methodname":"\u7b2c\u4e09\u4f4d"},"407":{"lotteryid":"10","methodid":"407","methodname":"\u5b9a\u5355\u53cc"},"409":{"lotteryid":"10","methodid":"409","methodname":"\u731c\u4e2d\u4f4d"},"411":{"lotteryid":"10","methodid":"411","methodname":"\u4efb\u9009\u4e00\u4e2d\u4e00"},"413":{"lotteryid":"10","methodid":"413","methodname":"\u4efb\u9009\u4e8c\u4e2d\u4e8c"},"415":{"lotteryid":"10","methodid":"415","methodname":"\u4efb\u9009\u4e09\u4e2d\u4e09"},"417":{"lotteryid":"10","methodid":"417","methodname":"\u4efb\u9009\u56db\u4e2d\u56db"},"419":{"lotteryid":"10","methodid":"419","methodname":"\u4efb\u9009\u4e94\u4e2d\u4e94"},"421":{"lotteryid":"10","methodid":"421","methodname":"\u4efb\u9009\u516d\u4e2d\u4e94"},"423":{"lotteryid":"10","methodid":"423","methodname":"\u4efb\u9009\u4e03\u4e2d\u4e94"},"425":{"lotteryid":"10","methodid":"425","methodname":"\u4efb\u9009\u516b\u4e2d\u4e94"}},"11":{"1189":{"lotteryid":"11","methodid":"1189","methodname":"\u76f4\u9009"},"1190":{"lotteryid":"11","methodid":"1190","methodname":"\u76f4\u9009_\u548c\u503c"},"1192":{"lotteryid":"11","methodid":"1192","methodname":"\u7ec4\u4e09"},"1193":{"lotteryid":"11","methodid":"1193","methodname":"\u7ec4\u516d"},"1194":{"lotteryid":"11","methodid":"1194","methodname":"\u6df7\u5408\u7ec4\u9009"},"1195":{"lotteryid":"11","methodid":"1195","methodname":"\u7ec4\u9009\u548c\u503c"},"1197":{"lotteryid":"11","methodid":"1197","methodname":"\u4e00\u7801\u4e0d\u5b9a\u80c6"},"1199":{"lotteryid":"11","methodid":"1199","methodname":"\u524d\u4e8c\u76f4\u9009"},"1201":{"lotteryid":"11","methodid":"1201","methodname":"\u540e\u4e8c\u76f4\u9009"},"1203":{"lotteryid":"11","methodid":"1203","methodname":"\u524d\u4e8c\u7ec4\u9009"},"1205":{"lotteryid":"11","methodid":"1205","methodname":"\u540e\u4e8c\u7ec4\u9009"},"1261":{"lotteryid":"11","methodid":"1261","methodname":"\u767e\u4f4d"},"1262":{"lotteryid":"11","methodid":"1262","methodname":"\u5341\u4f4d"},"1263":{"lotteryid":"11","methodid":"1263","methodname":"\u4e2a\u4f4d"}},"12":{"2189":{"lotteryid":"12","methodid":"2189","methodname":"\u76f4\u9009"},"2190":{"lotteryid":"12","methodid":"2190","methodname":"\u76f4\u9009_\u548c\u503c"},"2192":{"lotteryid":"12","methodid":"2192","methodname":"\u7ec4\u4e09"},"2193":{"lotteryid":"12","methodid":"2193","methodname":"\u7ec4\u516d"},"2194":{"lotteryid":"12","methodid":"2194","methodname":"\u6df7\u5408\u7ec4\u9009"},"2195":{"lotteryid":"12","methodid":"2195","methodname":"\u7ec4\u9009\u548c\u503c"},"2197":{"lotteryid":"12","methodid":"2197","methodname":"\u4e00\u7801\u4e0d\u5b9a\u80c6"},"2199":{"lotteryid":"12","methodid":"2199","methodname":"\u524d\u4e8c\u76f4\u9009"},"2201":{"lotteryid":"12","methodid":"2201","methodname":"\u540e\u4e8c\u76f4\u9009"},"2203":{"lotteryid":"12","methodid":"2203","methodname":"\u524d\u4e8c\u7ec4\u9009"},"2205":{"lotteryid":"12","methodid":"2205","methodname":"\u540e\u4e8c\u7ec4\u9009"},"2261":{"lotteryid":"12","methodid":"2261","methodname":"\u767e\u4f4d"},"2262":{"lotteryid":"12","methodid":"2262","methodname":"\u5341\u4f4d"},"2263":{"lotteryid":"12","methodid":"2263","methodname":"\u4e2a\u4f4d"}},"13":{"2324":{"lotteryid":"13","methodid":"2324","methodname":"\u524d\u4e09\u76f4\u9009"},"2325":{"lotteryid":"13","methodid":"2325","methodname":"\u524d\u4e09\u76f4\u9009_\u548c\u503c"},"2326":{"lotteryid":"13","methodid":"2326","methodname":"\u540e\u4e09\u76f4\u9009"},"2327":{"lotteryid":"13","methodid":"2327","methodname":"\u540e\u4e09\u76f4\u9009_\u548c\u503c"},"2328":{"lotteryid":"13","methodid":"2328","methodname":"\u524d\u4e09\u7ec4\u9009_\u7ec4\u4e09"},"2329":{"lotteryid":"13","methodid":"2329","methodname":"\u524d\u4e09\u7ec4\u9009_\u7ec4\u516d"},"2330":{"lotteryid":"13","methodid":"2330","methodname":"\u524d\u4e09\u7ec4\u9009_\u6df7\u5408"},"2331":{"lotteryid":"13","methodid":"2331","methodname":"\u524d\u4e09\u7ec4\u9009_\u548c\u503c"},"2332":{"lotteryid":"13","methodid":"2332","methodname":"\u540e\u4e09\u7ec4\u9009_\u7ec4\u4e09"},"2333":{"lotteryid":"13","methodid":"2333","methodname":"\u540e\u4e09\u7ec4\u9009_\u7ec4\u516d"},"2334":{"lotteryid":"13","methodid":"2334","methodname":"\u540e\u4e09\u7ec4\u9009_\u6df7\u5408"},"2335":{"lotteryid":"13","methodid":"2335","methodname":"\u540e\u4e09\u7ec4\u9009_\u548c\u503c"},"2336":{"lotteryid":"13","methodid":"2336","methodname":"\u4e00\u7801\u4e0d\u5b9a\u80c6"},"2337":{"lotteryid":"13","methodid":"2337","methodname":"\u4e8c\u7801\u4e0d\u5b9a\u80c6"},"2338":{"lotteryid":"13","methodid":"2338","methodname":"\u524d\u4e8c\u76f4\u9009"},"2339":{"lotteryid":"13","methodid":"2339","methodname":"\u540e\u4e8c\u76f4\u9009"},"2340":{"lotteryid":"13","methodid":"2340","methodname":"\u524d\u4e8c\u7ec4\u9009"},"2341":{"lotteryid":"13","methodid":"2341","methodname":"\u540e\u4e8c\u7ec4\u9009"},"2342":{"lotteryid":"13","methodid":"2342","methodname":"\u4e07\u4f4d"},"2343":{"lotteryid":"13","methodid":"2343","methodname":"\u5343\u4f4d"},"2344":{"lotteryid":"13","methodid":"2344","methodname":"\u767e\u4f4d"},"2345":{"lotteryid":"13","methodid":"2345","methodname":"\u5341\u4f4d"},"2346":{"lotteryid":"13","methodid":"2346","methodname":"\u4e2a\u4f4d"},"2347":{"lotteryid":"13","methodid":"2347","methodname":"\u524d\u4e8c\u5927\u5c0f\u5355\u53cc"},"2348":{"lotteryid":"13","methodid":"2348","methodname":"\u540e\u4e8c\u5927\u5c0f\u5355\u53cc"}}};	
		i =  $("#lotteryid").val();
		if(i>0)
		{
			html = "<div class='margin_2px' style='float:left'>游戏玩法：</div><div style='float:left' class=\"margin_2px\" style=\"width:110px;\"><select name='methodid' id='methodid' style='width:100px;'><option value='0'>所有玩法</option>";			
			$.each(data_method[i],function(j,k){
				html = html +"<option value='"+k.methodid+"'>"+k.methodname+"</option>";
			});
			html = html +"</select></div>";
		
		}
		else
		{
			html = "<div class='margin_2px' style='float:left'>游戏玩法：</div><div  style='float:left' class=\"margin_2px\" style=\"width:110px;\"><select name='methodid' id='methodid' style='width:100px;'><option value='0'>所有玩法</option></select></div>";	
		}
		$("#game_info").html(html);
	});
	$("#lotteryid").val(0);
	$("#lotteryid").change();
	$("#methodid").val('0');
	$("#issue").val('');
});
</script>
<style type="text/css">
.task_div {
  background-color: #1B5C84;
  border: 1px double #1B5C84;
  color: #FFFFFF;
  overflow: hidden;
  padding: 0;
  position: absolute;
  text-align: left;
  width: 290px !important;
}
.code {
  -moz-border-bottom-colors: none;
  -moz-border-image: none;
  -moz-border-left-colors: none;
  -moz-border-right-colors: none;
  -moz-border-top-colors: none;
  background: none repeat scroll 0 0 #FFFFFF;
  border-color: #1B5C84 #1B5C84 #1B5C84 -moz-use-text-color;
  border-style: double double double none;
  border-width: 1px 1px 1px 0;
  color: #000000;
  height: 150px;
  overflow-y: auto;
  text-align: left;
  width: 290px !important;
}
TEXTAREA {
  font: 12px "courier new";
  vertical-align: middle;
}

.subLength{
  width:100px;
  overflow: hidden;
  white-space: nowrap;
  text-overflow: ellipsis;
}

</style>
<script>

$(function (){
					
top.SetIframeHeight();
			
})	
</script>


<form action="" method="get" name="formTable">

<input name="controller" value="gameinfo" type="hidden">
<input name="action" value="gamelist" type="hidden">
<input name="isgetdata" value="1" type="hidden">

            <table class="formTable" border="0" cellpadding="0" cellspacing="0">
              <tbody>
              <tr>
                <th width="20%">投注时间：</th>
                <td>
                <input  style="width:150px;" name="starttime" id="starttime" class="input_02" type="text">
                <img style="cursor:pointer" src="../index_files/a_data/icon_06.jpg" height="17" width="20">
                	至：
                <input  style="width:150px;" id="endtime" name="endtime" class="input_02" type="text">
                <img style="cursor:pointer" src="../index_files/a_data/icon_06.jpg" height="17" width="20">
             
                </td>
              </tr>
             
              <tr>
                <th>彩种名称：</th>
                <td sytle="float:left">
				<select style="float:left" name="lotteryid" id="lotteryid">
						<option selected="selected" value="0">所有游戏</option>
						<option value="1">重庆时时彩</option>											
				</select>
                <span id="game_info">
	                <div class="margin_2px" style="float:left">游戏玩法：</div>
	                <div style="float:left" class="margin_2px">
		                <select name="methodid" id="methodid" style="width:100px;">
		                <option selected="selected" value="0">所有玩法</option>
		                </select>
	                </div>
                </span>
			</td></tr>
	
			<tr>
                <th>用户名称：</th>
                <td sytle="float:left">
                 <div style="float:left" class="margin_2px">
                <input name="mname" id="mname" size="16" class="input_02" style="margin-left:4px;" type="text">
                </div>
	
                <span id="game_info">
	                <div class="margin_2px" style="float:left">投注期号：</div>
	                <div style="float:left" class="margin_2px">
		                 <input name="issue" id="issue" value="" type="text">
	                </div>               
                </span>
			</td></tr>
           <tr>                
                <td colspan="2" align="center"><input onclick="deskSearch();" style="margin:0px" value="查询" class="formCheck" type="botton"></td>
            </tr>
            </tbody></table>          
        </form>
        
		<table class="grayTable" id="orderManager" style="font-size: 12px;" border="0" cellpadding="0" cellspacing="0">
			<thead>
				<tr>
					<th width="150">投注时间</th>
					<th class="line_03" align="center">订单编号</th>
					<th class="line_03" align="center" width="170">玩法</th>
					<th class="line_03" align="center" width="130">投注期号</th>
					<th class="line_03" align="center" width="80">投注内容</th>
					<th class="line_03" align="center" width="80">投注金额</th>
					<th class="line_03" align="center" width="80">奖金</th>
					<th class="line_03" align="center" width="80">开奖号码</th>
					<th class="line_03" align="center" width="60">状态</th>
					
					<th class="line_03" align="center" width="80">追号订单</th>
					<th class="line_03" align="center" width="80">追号编号</th>
					<th class="line_03" align="center" width="80">中奖后停止</th>
					<th class="line_03" align="center" width="60">操作</th>
				</tr>
			</thead>
			<tbody>
			<tr>
	            <td colspan="13" height="20">
	            	<div class="pages_o" id="pageDiv"></div>
	            </td>
	        </tr>
			</tbody>
		</table>
    </body></html>
    
    
    <script type="text/javascript">
    deskSearch();
    function deskSearch(pIndex,pTag){
    	var obj = $(".formTable");
    	var formDate = top.getFieldValues(obj);
    	  if ((pIndex != undefined)&&(pIndex.length>6))
    		{
    		 pIndex = 1;
    		}
    	  $(".news_uldetail").html('');
    	  var orderManager = document.getElementById("orderManager");
    	  while(orderManager.rows.length>2)
    		  orderManager.deleteRow(1);
    	  if(pIndex == undefined)
    	  {
    		  pIndex = 1;
    	  }
    	 
    	  $(formDate).attr("pageIndex",pIndex);
    	
    	  $.ajax({
    		  type:"POST",
    		  url:"../order/findDetailsByPage",
    		  contentType:"application/x-www-form-urlencoded",
    		  data:formDate,
    		  success:function(dataMap){
    			  var pageInfo = dataMap.pageInfo;
    			  queryList = pageInfo.dataList;
    			    if(queryList!=undefined){
    			      for(var i=0;i<queryList.length;i++){
    			        var list=queryList[i];
    			        var mdata = list.map;
    			        var row = orderManager.insertRow(orderManager.rows.length-1);
    			        var cell1 = document.createElement("td");
    			        var cell2 =  document.createElement("td");
    			        var cell3 =  document.createElement("td");
    			        var cell4 =  document.createElement("td");
    			        var cell5 =  document.createElement("td");
    			        var cell6 =  document.createElement("td");
    			        var cell7 =  document.createElement("td");
    			        var cell8 =  document.createElement("td");
    			        var cell9 =  document.createElement("td");
    			        
    			        var cell10 =  document.createElement("td");
    			        var cell11 =  document.createElement("td");
    			        var cell12 =  document.createElement("td");
    			        var cell13 =  document.createElement("td");
    			        
    			        cell1.innerHTML = list.createDate;
    			        cell2.innerHTML = list.orderId;
    			        cell3.innerHTML = mdata.playedName;
    			        cell4.innerHTML = mdata.issue;
    			        cell5.title = list.actionData;
    			        cell5.innerHTML = "<div class='subLength' >"+list.actionData+"</span>";   			       
    			        cell6.innerHTML = moneyFormat(list.actionMoney);
    			        if(list.bonus == null)
    			        	list.bonus = 0;
    			        cell7.innerHTML = moneyFormat(list.bonus);
    			        if(list.lotteryNo == null)
    			        	list.lotteryNo = "";
    			        cell8.innerHTML = list.lotteryNo;   			 
    			        cell9.innerHTML = mdata.state;    			       
    			        cell10.innerHTML = mdata.zhuiHao==1?"是":"否";
    			        cell11.innerHTML = mdata.zhuiHaoId;
    			        cell12.innerHTML = mdata.isStop==1?"是":"否";   	
    			        if(mdata.cancel == 1){
    			        	cell13.innerHTML = "<a style='cursor:pointer' onclick='cancel("+list.orderId+")'>撤单</a>";
    			        }
    			           			        
    			        row.appendChild(cell1);
    			        row.appendChild(cell2);
    			        row.appendChild(cell3);
    			        row.appendChild(cell4);
    			        row.appendChild(cell5);
    			        row.appendChild(cell6);
    			        row.appendChild(cell7);
    			        row.appendChild(cell8);
    			        row.appendChild(cell9);
    			        
    			        row.appendChild(cell10);
    			        row.appendChild(cell11);
    			        row.appendChild(cell12);
    			        row.appendChild(cell13);
    			      }
    			    }
    			    if(pTag == undefined)
    			    {
    			    	$("#pageDiv").attr("pCount",pageInfo.pageCount);
    			    	initPage(1);
    			    }
    		  }
    	  });
    	  var mainFrame = parent.document.getElementById("mainFrame");
    	  mainFrame.style.width = '1200px';
    	  $(".formTable").css({width:"1200px"});
    	  $(mainFrame).parent().siblings(".topName").css({width:"1210px"});
    	  $(mainFrame).closest("body").css({width:"1210px"});
    	  //SetWinHeight(parent.document.getElementById("mainFrame"));
      }
    
    function cancel(orderId){
    	var formDate = {};
    	$(formDate).attr("orderId",orderId);
    	$.confirm("确定要撤销此订单?",function(){
    		
    		$.ajax({
      		  type:"POST",
      		  url:"../order/cancel",
      		  contentType:"application/x-www-form-urlencoded",
      		  data:formDate,
      		  success:function(data){
      			deskSearch();
    			$.alert(data);
      		  }
    		});
			
		});
    }
    </script>