<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=9">
<title>杏彩游戏平台 - 报表查询</title>
<link href="../a_data/base.css" rel="stylesheet" type="text/css" media="all">
<link href="../a_data/subpage.css" rel="stylesheet" type="text/css" media="all">
<script type="text/javascript" src="../a_data/jquery-1.js"></script>
<script type="text/javascript" src="../a_data/tab.js"></script>

<script type="text/javascript" src="../a_data/jquery_005.js"></script>
<script type="text/javascript" src="../jquery_003.js"></script>
<link href="../a_data/dialogUI.css" media="all" type="text/css" rel="stylesheet">
<script type="text/javascript" src="../a_data/main.js"></script>
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
	<a href="http://en.live800.com/">live chat</a>
</div>
<script src="../a_data/jquery_004.js" type="text/javascript"></script>
<script src="../a_data/calendar-utf8.js" type="text/javascript"></script>
<link href="../a_data/calendar-win2k-cold-1.css" media="all" type="text/css" rel="stylesheet">
<script type="text/javascript">
jQuery(document).ready(function() {
	jQuery("#lottery").change(function(){
		var data_method = {"1":{"2281":"\u4e94\u661f\u7ec4\u900920","22":"\u524d\u4e8c\u76f4\u9009","453":"\u524d\u4e09\u7ec4\u9009_\u5305\u80c6","2283":"\u4e94\u661f\u7ec4\u90095","26":"\u524d\u4e8c\u7ec4\u9009","472":"\u524d\u4e8c\u76f4\u9009\u548c\u503c","3":"\u524d\u4e09\u76f4\u9009_\u548c\u503c","2286":"\u597d\u4e8b\u6210\u53cc","30":"\u4e07\u4f4d","476":"\u524d\u4e8c\u7ec4\u9009\u548c\u503c","2265":"\u56db\u661f\u76f4\u9009","6":"\u540e\u4e09\u76f4\u9009_\u548c\u503c","2288":"\u56db\u5b63\u53d1\u8d22","32":"\u767e\u4f4d","512":"\u524d\u4e09\u4e00\u7801\u4e0d\u5b9a\u80c6","2269":"\u7ec4\u900924","9":"\u524d\u4e09\u7ec4\u9009_\u7ec4\u516d","2292":"\u4e2d\u4e09\u76f4\u9009_\u548c\u503c","34":"\u4e2a\u4f4d","2271":"\u7ec4\u90096","11":"\u524d\u4e09\u7ec4\u9009_\u548c\u503c","2294":"\u4e2d\u4e09\u7ec4\u9009_\u7ec4\u516d","38":"\u540e\u4e8c\u5927\u5c0f\u5355\u53cc","2274":"\u4e94\u661f\u76f4\u9009","14":"\u540e\u4e09\u7ec4\u9009_\u7ec4\u516d","2296":"\u4e2d\u4e09\u7ec4\u9009_\u548c\u503c","2278":"\u4e94\u661f\u7ec4\u9009120","16":"\u540e\u4e09\u7ec4\u9009_\u548c\u503c","2280":"\u4e94\u661f\u7ec4\u900930","20":"\u540e\u4e09\u4e8c\u7801\u4e0d\u5b9a\u80c6","2282":"\u4e94\u661f\u7ec4\u900910","24":"\u540e\u4e8c\u76f4\u9009","463":"\u540e\u4e09\u7ec4\u9009_\u5305\u80c6","2":"\u524d\u4e09\u76f4\u9009","2285":"\u4e00\u5e06\u98ce\u987a","28":"\u540e\u4e8c\u7ec4\u9009","474":"\u540e\u4e8c\u76f4\u9009\u548c\u503c","5":"\u540e\u4e09\u76f4\u9009","2287":"\u4e09\u661f\u62a5\u559c","31":"\u5343\u4f4d","478":"\u540e\u4e8c\u7ec4\u9009\u548c\u503c","2267":"\u56db\u661f\u7ec4\u5408","8":"\u524d\u4e09\u7ec4\u9009_\u7ec4\u4e09","2291":"\u4e2d\u4e09\u76f4\u9009","33":"\u5341\u4f4d","513":"\u524d\u4e09\u4e8c\u7801\u4e0d\u5b9a\u80c6","2270":"\u7ec4\u900912","10":"\u524d\u4e09\u7ec4\u9009_\u6df7\u5408","2293":"\u4e2d\u4e09\u7ec4\u9009_\u7ec4\u4e09","36":"\u524d\u4e8c\u5927\u5c0f\u5355\u53cc","2272":"\u7ec4\u90094","13":"\u540e\u4e09\u7ec4\u9009_\u7ec4\u4e09","2295":"\u4e2d\u4e09\u7ec4\u9009_\u6df7\u5408","2276":"\u4e94\u661f\u7ec4\u5408","15":"\u540e\u4e09\u7ec4\u9009_\u6df7\u5408","2279":"\u4e94\u661f\u7ec4\u900960","18":"\u540e\u4e09\u4e00\u7801\u4e0d\u5b9a\u80c6"},"3":{"144":"\u4e8c\u7801\u4e0d\u5b9a\u80c6","148":"\u540e\u4e8c\u76f4\u9009","126":"\u524d\u4e09\u76f4\u9009","152":"\u540e\u4e8c\u7ec4\u9009","129":"\u540e\u4e09\u76f4\u9009","155":"\u5343\u4f4d","132":"\u524d\u4e09\u7ec4\u9009_\u7ec4\u4e09","157":"\u5341\u4f4d","134":"\u524d\u4e09\u7ec4\u9009_\u6df7\u5408","160":"\u524d\u4e8c\u5927\u5c0f\u5355\u53cc","137":"\u540e\u4e09\u7ec4\u9009_\u7ec4\u4e09","139":"\u540e\u4e09\u7ec4\u9009_\u6df7\u5408","142":"\u4e00\u7801\u4e0d\u5b9a\u80c6","146":"\u524d\u4e8c\u76f4\u9009","150":"\u524d\u4e8c\u7ec4\u9009","127":"\u524d\u4e09\u76f4\u9009_\u548c\u503c","154":"\u4e07\u4f4d","130":"\u540e\u4e09\u76f4\u9009_\u548c\u503c","156":"\u767e\u4f4d","133":"\u524d\u4e09\u7ec4\u9009_\u7ec4\u516d","158":"\u4e2a\u4f4d","135":"\u524d\u4e09\u7ec4\u9009_\u548c\u503c","162":"\u540e\u4e8c\u5927\u5c0f\u5355\u53cc","138":"\u540e\u4e09\u7ec4\u9009_\u7ec4\u516d","140":"\u540e\u4e09\u7ec4\u9009_\u548c\u503c"},"6":{"269":"\u540e\u4e09\u76f4\u9009_\u548c\u503c","295":"\u767e\u4f4d","272":"\u524d\u4e09\u7ec4\u9009_\u7ec4\u516d","297":"\u4e2a\u4f4d","274":"\u524d\u4e09\u7ec4\u9009_\u548c\u503c","301":"\u540e\u4e8c\u5927\u5c0f\u5355\u53cc","277":"\u540e\u4e09\u7ec4\u9009_\u7ec4\u516d","279":"\u540e\u4e09\u7ec4\u9009_\u548c\u503c","283":"\u4e8c\u7801\u4e0d\u5b9a\u80c6","287":"\u540e\u4e8c\u76f4\u9009","265":"\u524d\u4e09\u76f4\u9009","291":"\u540e\u4e8c\u7ec4\u9009","268":"\u540e\u4e09\u76f4\u9009","294":"\u5343\u4f4d","271":"\u524d\u4e09\u7ec4\u9009_\u7ec4\u4e09","296":"\u5341\u4f4d","273":"\u524d\u4e09\u7ec4\u9009_\u6df7\u5408","299":"\u524d\u4e8c\u5927\u5c0f\u5355\u53cc","276":"\u540e\u4e09\u7ec4\u9009_\u7ec4\u4e09","278":"\u540e\u4e09\u7ec4\u9009_\u6df7\u5408","281":"\u4e00\u7801\u4e0d\u5b9a\u80c6","285":"\u524d\u4e8c\u76f4\u9009","289":"\u524d\u4e8c\u7ec4\u9009","266":"\u524d\u4e09\u76f4\u9009_\u548c\u503c","293":"\u4e07\u4f4d"},"8":{"353":"\u731c\u4e2d\u4f4d","357":"\u4efb\u9009\u4e8c\u4e2d\u4e8c","361":"\u4efb\u9009\u56db\u4e2d\u56db","365":"\u4efb\u9009\u516d\u4e2d\u4e94","337":"\u524d\u4e09\u76f4\u9009","369":"\u4efb\u9009\u516b\u4e2d\u4e94","341":"\u524d\u4e8c\u76f4\u9009","345":"\u524d\u4e09\u4f4d","348":"\u7b2c\u4e8c\u4f4d","351":"\u5b9a\u5355\u53cc","355":"\u4efb\u9009\u4e00\u4e2d\u4e00","359":"\u4efb\u9009\u4e09\u4e2d\u4e09","363":"\u4efb\u9009\u4e94\u4e2d\u4e94","367":"\u4efb\u9009\u4e03\u4e2d\u4e94","339":"\u524d\u4e09\u7ec4\u9009","343":"\u524d\u4e8c\u7ec4\u9009","347":"\u7b2c\u4e00\u4f4d","349":"\u7b2c\u4e09\u4f4d"},"5":{"236":"\u731c\u4e2d\u4f4d","240":"\u4efb\u9009\u4e8c\u4e2d\u4e8c","246":"\u4efb\u9009\u56db\u4e2d\u56db","252":"\u4efb\u9009\u516d\u4e2d\u4e94","220":"\u524d\u4e09\u76f4\u9009","258":"\u4efb\u9009\u516b\u4e2d\u4e94","224":"\u524d\u4e8c\u76f4\u9009","228":"\u524d\u4e09\u4f4d","231":"\u7b2c\u4e8c\u4f4d","234":"\u5b9a\u5355\u53cc","238":"\u4efb\u9009\u4e00\u4e2d\u4e00","243":"\u4efb\u9009\u4e09\u4e2d\u4e09","249":"\u4efb\u9009\u4e94\u4e2d\u4e94","255":"\u4efb\u9009\u4e03\u4e2d\u4e94","222":"\u524d\u4e09\u7ec4\u9009","226":"\u524d\u4e8c\u7ec4\u9009","230":"\u7b2c\u4e00\u4f4d","232":"\u7b2c\u4e09\u4f4d"},"7":{"321":"\u4efb\u9009\u4e00\u4e2d\u4e00","325":"\u4efb\u9009\u4e09\u4e2d\u4e09","329":"\u4efb\u9009\u4e94\u4e2d\u4e94","333":"\u4efb\u9009\u4e03\u4e2d\u4e94","305":"\u524d\u4e09\u7ec4\u9009","309":"\u524d\u4e8c\u7ec4\u9009","313":"\u7b2c\u4e00\u4f4d","315":"\u7b2c\u4e09\u4f4d","319":"\u731c\u4e2d\u4f4d","323":"\u4efb\u9009\u4e8c\u4e2d\u4e8c","327":"\u4efb\u9009\u56db\u4e2d\u56db","331":"\u4efb\u9009\u516d\u4e2d\u4e94","303":"\u524d\u4e09\u76f4\u9009","335":"\u4efb\u9009\u516b\u4e2d\u4e94","307":"\u524d\u4e8c\u76f4\u9009","311":"\u524d\u4e09\u4f4d","314":"\u7b2c\u4e8c\u4f4d","317":"\u5b9a\u5355\u53cc"},"10":{"397":"\u524d\u4e8c\u76f4\u9009","401":"\u524d\u4e09\u4f4d","404":"\u7b2c\u4e8c\u4f4d","407":"\u5b9a\u5355\u53cc","411":"\u4efb\u9009\u4e00\u4e2d\u4e00","415":"\u4efb\u9009\u4e09\u4e2d\u4e09","419":"\u4efb\u9009\u4e94\u4e2d\u4e94","423":"\u4efb\u9009\u4e03\u4e2d\u4e94","395":"\u524d\u4e09\u7ec4\u9009","399":"\u524d\u4e8c\u7ec4\u9009","403":"\u7b2c\u4e00\u4f4d","405":"\u7b2c\u4e09\u4f4d","409":"\u731c\u4e2d\u4f4d","413":"\u4efb\u9009\u4e8c\u4e2d\u4e8c","417":"\u4efb\u9009\u56db\u4e2d\u56db","421":"\u4efb\u9009\u516d\u4e2d\u4e94","393":"\u524d\u4e09\u76f4\u9009","425":"\u4efb\u9009\u516b\u4e2d\u4e94"},"11":{"1199":"\u524d\u4e8c\u76f4\u9009","1203":"\u524d\u4e8c\u7ec4\u9009","1261":"\u767e\u4f4d","1263":"\u4e2a\u4f4d","1189":"\u76f4\u9009","1192":"\u7ec4\u4e09","1194":"\u6df7\u5408\u7ec4\u9009","1197":"\u4e00\u7801\u4e0d\u5b9a\u80c6","1201":"\u540e\u4e8c\u76f4\u9009","1205":"\u540e\u4e8c\u7ec4\u9009","1262":"\u5341\u4f4d","1190":"\u76f4\u9009_\u548c\u503c","1193":"\u7ec4\u516d","1195":"\u7ec4\u9009\u548c\u503c"},"13":{"2336":"\u4e00\u7801\u4e0d\u5b9a\u80c6","2338":"\u524d\u4e8c\u76f4\u9009","2340":"\u524d\u4e8c\u7ec4\u9009","2325":"\u524d\u4e09\u76f4\u9009_\u548c\u503c","2342":"\u4e07\u4f4d","2327":"\u540e\u4e09\u76f4\u9009_\u548c\u503c","2344":"\u767e\u4f4d","2329":"\u524d\u4e09\u7ec4\u9009_\u7ec4\u516d","2346":"\u4e2a\u4f4d","2331":"\u524d\u4e09\u7ec4\u9009_\u548c\u503c","2348":"\u540e\u4e8c\u5927\u5c0f\u5355\u53cc","2333":"\u540e\u4e09\u7ec4\u9009_\u7ec4\u516d","2335":"\u540e\u4e09\u7ec4\u9009_\u548c\u503c","2337":"\u4e8c\u7801\u4e0d\u5b9a\u80c6","2339":"\u540e\u4e8c\u76f4\u9009","2324":"\u524d\u4e09\u76f4\u9009","2341":"\u540e\u4e8c\u7ec4\u9009","2326":"\u540e\u4e09\u76f4\u9009","2343":"\u5343\u4f4d","2328":"\u524d\u4e09\u7ec4\u9009_\u7ec4\u4e09","2345":"\u5341\u4f4d","2330":"\u524d\u4e09\u7ec4\u9009_\u6df7\u5408","2347":"\u524d\u4e8c\u5927\u5c0f\u5355\u53cc","2332":"\u540e\u4e09\u7ec4\u9009_\u7ec4\u4e09","2334":"\u540e\u4e09\u7ec4\u9009_\u6df7\u5408"},"12":{"2205":"\u540e\u4e8c\u7ec4\u9009","2262":"\u5341\u4f4d","2190":"\u76f4\u9009_\u548c\u503c","2193":"\u7ec4\u516d","2195":"\u7ec4\u9009\u548c\u503c","2199":"\u524d\u4e8c\u76f4\u9009","2203":"\u524d\u4e8c\u7ec4\u9009","2261":"\u767e\u4f4d","2263":"\u4e2a\u4f4d","2189":"\u76f4\u9009","2192":"\u7ec4\u4e09","2194":"\u6df7\u5408\u7ec4\u9009","2197":"\u4e00\u7801\u4e0d\u5b9a\u80c6","2201":"\u540e\u4e8c\u76f4\u9009"},"15":{"2433":"\u4e8c\u540c\u53f7\u5355\u9009","2435":"\u4e09\u4e0d\u540c\u53f7","2437":"\u4e09\u4e0d\u540c\u53f7(\u548c\u503c)","2439":"\u4e09\u540c\u53f7\u5355\u9009","2441":"\u548c\u503c","2443":"\u4e8c\u4e0d\u540c\u53f7(\u80c6\u62d6)","2434":"\u4e8c\u540c\u53f7\u590d\u9009","2436":"\u4e09\u4e0d\u540c\u53f7(\u80c6\u62d6)","2438":"\u4e09\u8fde\u53f7\u901a\u9009","2440":"\u4e09\u540c\u53f7\u901a\u9009","2442":"\u4e8c\u4e0d\u540c\u53f7"},"4":{"193":"\u7ec4\u516d","195":"\u7ec4\u9009\u548c\u503c","199":"\u524d\u4e8c\u76f4\u9009","203":"\u524d\u4e8c\u7ec4\u9009","262":"\u5341\u4f4d","189":"\u76f4\u9009","192":"\u7ec4\u4e09","194":"\u6df7\u5408\u7ec4\u9009","197":"\u4e00\u7801\u4e0d\u5b9a\u80c6","201":"\u540e\u4e8c\u76f4\u9009","205":"\u540e\u4e8c\u7ec4\u9009","261":"\u767e\u4f4d","263":"\u4e2a\u4f4d","190":"\u76f4\u9009_\u548c\u503c"},"2":{"121":"\u5341\u4f4d","106":"\u524d\u4e09\u7ec4\u9009_\u6df7\u5408","123":"\u524d\u4e8c\u5927\u5c0f\u5355\u53cc","108":"\u540e\u4e09\u7ec4\u9009_\u7ec4\u4e09","110":"\u540e\u4e09\u7ec4\u9009_\u6df7\u5408","112":"\u4e00\u7801\u4e0d\u5b9a\u80c6","114":"\u524d\u4e8c\u76f4\u9009","116":"\u524d\u4e8c\u7ec4\u9009","92":"\u524d\u4e09\u76f4\u9009_\u548c\u503c","118":"\u4e07\u4f4d","103":"\u540e\u4e09\u76f4\u9009_\u548c\u503c","120":"\u767e\u4f4d","105":"\u524d\u4e09\u7ec4\u9009_\u7ec4\u516d","122":"\u4e2a\u4f4d","107":"\u524d\u4e09\u7ec4\u9009_\u548c\u503c","124":"\u540e\u4e8c\u5927\u5c0f\u5355\u53cc","109":"\u540e\u4e09\u7ec4\u9009_\u7ec4\u516d","111":"\u540e\u4e09\u7ec4\u9009_\u548c\u503c","113":"\u4e8c\u7801\u4e0d\u5b9a\u80c6","115":"\u540e\u4e8c\u76f4\u9009","89":"\u524d\u4e09\u76f4\u9009","117":"\u540e\u4e8c\u7ec4\u9009","102":"\u540e\u4e09\u76f4\u9009","119":"\u5343\u4f4d","104":"\u524d\u4e09\u7ec4\u9009_\u7ec4\u4e09"},"9":{"2308":"\u4efb\u9009\u4e94","2310":"\u4efb\u9009\u4e03","387":"\u548c\u503c\u5927\u5c0f","391":"\u5947\u5076\u76d8","2305":"\u4efb\u9009\u4e8c","427":"\u548c\u503c\u5927\u5c0f\u5355\u53cc","2307":"\u4efb\u9009\u56db","2309":"\u4efb\u9009\u516d","385":"\u548c\u503c\u5355\u53cc","389":"\u4e0a\u4e0b\u76d8","2304":"\u4efb\u9009\u4e00","2306":"\u4efb\u9009\u4e09"},"14":{"2387":"\u540e\u4e8c\u76f4\u9009","2419":"\u4e2d\u4e09\u76f4\u9009","2372":"\u524d\u4e09\u7ec4\u9009_\u7ec4\u4e09","2404":"\u7ec4\u900912","2389":"\u540e\u4e8c\u76f4\u9009\u548c\u503c","2421":"\u4e2d\u4e09\u7ec4\u9009_\u7ec4\u4e09","2374":"\u524d\u4e09\u7ec4\u9009_\u6df7\u5408","2406":"\u7ec4\u90094","2391":"\u540e\u4e8c\u7ec4\u9009","2423":"\u4e2d\u4e09\u7ec4\u9009_\u6df7\u5408","2376":"\u524d\u4e09\u7ec4\u9009_\u548c\u503c","2408":"\u4e94\u661f\u7ec4\u5408","2393":"\u540e\u4e8c\u7ec4\u9009\u548c\u503c","2378":"\u540e\u4e09\u7ec4\u9009_\u7ec4\u516d","2410":"\u4e94\u661f\u7ec4\u900960","2395":"\u5343\u4f4d","2380":"\u540e\u4e09\u7ec4\u9009_\u548c\u503c","2412":"\u4e94\u661f\u7ec4\u900920","2397":"\u5341\u4f4d","2382":"\u540e\u4e09\u4e00\u7801\u4e0d\u5b9a\u80c6","2414":"\u4e94\u661f\u7ec4\u90095","2399":"\u524d\u4e8c\u5927\u5c0f\u5355\u53cc","2384":"\u540e\u4e09\u4e8c\u7801\u4e0d\u5b9a\u80c6","2416":"\u597d\u4e8b\u6210\u53cc","2369":"\u524d\u4e09\u76f4\u9009_\u548c\u503c","2401":"\u56db\u661f\u76f4\u9009","2386":"\u524d\u4e8c\u76f4\u9009","2418":"\u56db\u5b63\u53d1\u8d22","2371":"\u540e\u4e09\u76f4\u9009_\u548c\u503c","2403":"\u7ec4\u900924","2388":"\u524d\u4e8c\u76f4\u9009\u548c\u503c","2420":"\u4e2d\u4e09\u76f4\u9009_\u548c\u503c","2373":"\u524d\u4e09\u7ec4\u9009_\u7ec4\u516d","2405":"\u7ec4\u90096","2390":"\u524d\u4e8c\u7ec4\u9009","2422":"\u4e2d\u4e09\u7ec4\u9009_\u7ec4\u516d","2375":"\u524d\u4e09\u7ec4\u9009_\u5305\u80c6","2407":"\u4e94\u661f\u76f4\u9009","2392":"\u524d\u4e8c\u7ec4\u9009\u548c\u503c","2424":"\u4e2d\u4e09\u7ec4\u9009_\u548c\u503c","2377":"\u540e\u4e09\u7ec4\u9009_\u7ec4\u4e09","2409":"\u4e94\u661f\u7ec4\u9009120","2394":"\u4e07\u4f4d","2379":"\u540e\u4e09\u7ec4\u9009_\u6df7\u5408","2411":"\u4e94\u661f\u7ec4\u900930","2396":"\u767e\u4f4d","2381":"\u540e\u4e09\u7ec4\u9009_\u5305\u80c6","2413":"\u4e94\u661f\u7ec4\u900910","2398":"\u4e2a\u4f4d","2383":"\u524d\u4e09\u4e00\u7801\u4e0d\u5b9a\u80c6","2415":"\u4e00\u5e06\u98ce\u987a","2368":"\u524d\u4e09\u76f4\u9009","2400":"\u540e\u4e8c\u5927\u5c0f\u5355\u53cc","2385":"\u524d\u4e09\u4e8c\u7801\u4e0d\u5b9a\u80c6","2417":"\u4e09\u661f\u62a5\u559c","2370":"\u540e\u4e09\u76f4\u9009","2402":"\u56db\u661f\u7ec4\u5408"}};
		var i = $("#lottery").val();
		if(i>0)
		{
			html ="游戏玩法：<select name='method' id='method'><option value='0'>所有玩法</option>";
			$.each(data_method[i],function(i,v){
				html = html + "<option value='"+i+"'>"+v+"</option>";
			});
		}
		else
		{
			html ="游戏玩法：<select name='method' id='method'><option value='0'>所有玩法</option>";
		}
		html = html+ "</select>";
		$("#method_show").html(html);
	});
	$("#lottery").val(0);
	$("#lottery").change();
	$("#method").val(0);
});
</script>
	<div style="_height: 400px; min-height: 400px;">
		<form action="" method="GET" class="list-form">
			<input name="controller" value="report" type="hidden"> <input
				name="action" value="list" type="hidden"> <input
				name="isgetdata" value="1" type="hidden">
			<table class="formTable" border="0" cellpadding="0" cellspacing="0"
				width="100%">

				<tbody>
					<tr>

						<th width="20%">时间：</th>
						<td><input value="2014-05-20 02:20:00" style="width: 150px;"
							name="starttime" id="starttime" class="input_02" type="text">
							<img style="cursor: pointer" src="../a_data/icon_06.jpg" height="17"
							width="20"> 至： <input value="2014-05-21 02:20:00"
							style="width: 150px;" id="endtime" name="endtime"
							class="input_02" type="text"> <img
							style="cursor: pointer" src="../a_data/icon_06.jpg" height="17"
							width="20"></td>
						<td style="float: left;"><select name="recentproject"
							id="recentproject">
								<option selected="selected" value="0">往期报表</option>
								<option value="2014-05-19">2014-05-19</option>
								<option value="2014-05-18">2014-05-18</option>
								<option value="2014-05-17">2014-05-17</option>
								<option value="2014-05-16">2014-05-16</option>
								<option value="2014-05-15">2014-05-15</option>
								<option value="2014-05-14">2014-05-14</option>
								<option value="2014-05-13">2014-05-13</option>
								<option value="2014-05-12">2014-05-12</option>
								<option value="2014-05-11">2014-05-11</option>
								<option value="2014-05-10">2014-05-10</option>
								<option value="2014-05-09">2014-05-09</option>
								<option value="2014-05-08">2014-05-08</option>
								<option value="2014-05-07">2014-05-07</option>
								<option value="2014-05-06">2014-05-06</option>
						</select></td>
					</tr>

					<tr>
						<th>彩种名称：</th>
						<td colspan="3">
							<select name="lottery" id="lottery">
								<option selected="selected" value="0">所有游戏</option>
								<option value="1">重庆时时彩</option>
								<option value="3">江西时时彩</option>
								<option value="6">新疆时时彩</option>
								<option value="8">广东11选5</option>
								<option value="5">山东11运</option>
								<option value="7">江西11选5</option>
								<option value="10">重庆11选5</option>
								<option value="11">福彩3D</option>
								<option value="13">天津时时彩</option>
								<option value="12">体彩P3</option>
								<option value="15">江苏快三</option>
								<option value="4">时时乐</option>
								<option value="2">龙江时时彩</option>
								<option value="9">北京快乐彩</option>
								<option value="14">印尼五分彩</option>
							</select>
						</td>
					</tr>
					<tr>

						<th>排序方式：</th>
						<td colspan="3"><select name="sort_type" id="sort_type">
								<option selected="selected" value="0">销售总额</option>
								<option value="1">返点</option>
								<option value="2">实际销售总额</option>
								<option value="3">返奖总额</option>
								<option value="4">总盈亏</option>

						</select></td>
					</tr>
					<tr>
						<td colspan="4" align="center">
							<input name="" value="查询" class="formCheck" style="margin: 0px" type="submit"></td>
					</tr>
				</tbody>
			</table>

		</form>
		<table class="grayTable" border="0" cellpadding="0" cellspacing="0"
			width="100%">
			<tbody>
				<tr>
					<th>用户名</th>
					<th>所属组</th>
					<th>销售总额</th>
					<th>返点</th>
					<th>实际销售总额</th>
					<th>返奖总额</th>
					<th>总盈亏</th>
					<th>操作</th>
				</tr>
				<tr>
					<td colspan="8" class="no-records">请选择查询条件之后进行查询</td>
				</tr>
			</tbody>
		</table>
		<script type="text/javascript">
			jQuery("#starttime").dynDateTime({
				ifFormat : "%Y-%m-%d %H:%M:00",
				daFormat : "%l;%M %p, %e %m,  %Y",
				align : "Br",
				electric : true,
				singleClick : false,
				button : ".next()", //next sibling
				onUpdate : function() {
					$("#starttime").change();
				},
				showOthers : true,
				weekNumbers : true,
				showsTime : true
			});
			jQuery("#starttime").change(function() {
				jQuery("#recentproject").attr('value', '0');

				if (!validateInputDate(jQuery("#starttime").val())) {
					jQuery("#starttime").val('');
					alert("时间格式不正确,正确的格式为:2009-06-10 10:59");
				}
				if ($("#endtime").val() != "") {
					if ($("#starttime").val() > $("#endtime").val()) {
						$("#starttime").val("");
						alert("输入的时间不符合逻辑");
					}
				}
			});
			jQuery("#endtime").dynDateTime({
				ifFormat : "%Y-%m-%d %H:%M:00",
				daFormat : "%l;%M %p, %e %m,  %Y",
				align : "Br",
				electric : true,
				singleClick : false,
				button : ".next()", //next sibling
				onUpdate : function() {
					$("#endtime").change();
				},
				showOthers : true,
				weekNumbers : true,
				showsTime : true
			});
			jQuery("#endtime").change(function() {
				jQuery("#recentproject").attr('value', '0');
				if (!validateInputDate(jQuery("#endtime").val())) {
					jQuery("#endtime").val('');
					alert("时间格式不正确,正确的格式为:2009-06-10 10:59");
				}
				if ($("#starttime").val() != "") {
					if ($("#starttime").val() > $("#endtime").val()) {
						$("#endtime").val("");
						alert("输入的时间不符合逻辑");
					}
				}
			});
		</script>
	</div>
</body>
</html>