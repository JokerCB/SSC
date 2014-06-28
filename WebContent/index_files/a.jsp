<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="../index_files/a_data/base.css" rel="stylesheet" type="text/css" media="all">
<link href="../index_files/a_data/layout.css" rel="stylesheet" type="text/css" media="all">
<link href="../index_files/a_data/lottery_frame.css" media="all" type="text/css" rel="stylesheet">
<title>::::杏彩娱乐::::</title>

<script type="text/javascript" src="../index_files/a_data/iepngfix_tilebg.js"></script>
<script type="text/javascript" src="../index_files/a_data/jquery-1.js"></script>


<script type="text/javascript" src="../index_files/a_data/iframe.js"></script>
<!--消息框代码开始-->
<script type="text/javascript" src="../index_files/a_data/jquery_005.js"></script>
<script type="text/javascript" src="../index_files/a_data/jquery.js"></script>
<link href="../index_files/a_data/dialogUI.css" media="all" type="text/css" rel="stylesheet">
<!--消息框代码结束-->
<script type="text/javascript" src="../index_files/a_data/main.js"></script>
<script type="text/javascript">

var var_cur_issue = "${cur_issue}";
var var_servertime = "${servertime}";
var Iss_today = "${Iss_today}";
Iss_today = Iss_today.split("|");

var Iss_tomorrow = "${Iss_tomorrow}";
Iss_tomorrow = Iss_tomorrow.split("|");

var moneyMap = eval('(' + '${moneyMap}' + ')');
var fandian = "${fandian}";
var fandianbdw = "${fandianbdw}"; 

</script>

</head>
<body>
<div style="display:none;"><a href="http://www.live800.com/">客服</a></div>
<script type="text/javascript">
var _gaq = _gaq || [];
_gaq.push(['_setAccount', 'UA-41881199-8']);
_gaq.push(['_setDomainName', 'none']);
_gaq.push(['_setAllowLinker', true]);
_gaq.push(['_addOrganic', 'sogou', 'query']);
_gaq.push(['_addOrganic', 'youdao', 'q']);
_gaq.push(['_addOrganic', 'soso', 'w']);
_gaq.push(['_addOrganic', 'sina', 'q']);
_gaq.push(['_trackPageview']);
</script>
<div style="display:none;">
	<a href="http://en.live800.com/">live chat</a>
</div>
<script type="text/javascript" src="../index_files/a_data/app-host.htm"></script>
<script type="text/javascript" src="../index_files/a_data/tab.js"></script>
<script src="../index_files/a_data/jquery_004.js" type="text/javascript"></script>
<script src="../index_files/a_data/calendar-utf8.js" type="text/javascript"></script>
<link href="../index_files/a_data/calendar-win2k-cold-1.css" media="all" type="text/css" rel="stylesheet">
<!--------------------->
<script language="javascript" src="../index_files/a_data/common.js"></script>
<script language="javascript" src="../index_files/a_data/youxi_lang_zh.js"></script>

<script language="javascript">

function intval (mixed_var, base) {
	var tmp;
	var type = typeof(mixed_var);
	if (type === 'boolean') {
	return +mixed_var;
	} else if (type === 'string') {
	tmp = parseInt(mixed_var, base || 10);
	return (isNaN(tmp) || !isFinite(tmp)) ? 0 : tmp;    } else if (type === 'number' && isFinite(mixed_var)) {
	return mixed_var | 0;
	} else {
	return 0;
	}
}
function show_on()
{
	$("#lt_help_div").show("slow");
}
function close_on()
{
	$("#lt_help_div").hide("slow");
}
(function($){
	
	
$(document).ready(function(){
	$.gameInit({
	data_label: [
		{isnew:"0",isdefault:"0",title:"五星", label:[{gtitle:'五星直选', label:[{methoddesc:'从个、十、百、千、万位各选一个号码组成一注。',
methodhelp:'从万位、千位、百位、十位、个位中选择一个5位数号码组成一注，所选号码与开奖号码全部相同，且顺序一致，即为中奖。',
methodexample:'投注方案：23456；<br />开奖号码：23456，<br />即中五星直选',
selectarea:{
       type   : 'digital',
       layout : [
                   {title:'万位', no:'0|1|2|3|4|5|6|7|8|9', place:0, cols:1},
                   {title:'千位', no:'0|1|2|3|4|5|6|7|8|9', place:1, cols:1},
		   {title:'百位', no:'0|1|2|3|4|5|6|7|8|9', place:2, cols:1},
		   {title:'十位', no:'0|1|2|3|4|5|6|7|8|9', place:3, cols:1},
		   {title:'个位', no:'0|1|2|3|4|5|6|7|8|9', place:4, cols:1}
		  ],
       noBigIndex : 5,
       isButton   : true
      },
show_str : 'X,X,X,X,X',
code_sp : '',
	methodid : 2274,
	name:'复式',
	prize:{1:'180000.00'},
        nfdprize:{levs:moneyMap['2274'].split(",")[0],defaultprize:moneyMap['2274'].split(",")[1],userdiffpoint:fandian},
	modes:[{modeid:1,name:'元',rate:1},{modeid:2,name:'角',rate:0.1},{modeid:3,name:'分',rate:0.01}],
	desc:'复式',maxcodecount:0
},{methoddesc:'手动输入号码，至少输入1个五位数号码组成一注。',
methodhelp:'手动输入一个5位数号码组成一注，所选号码的万位、千位、百位、十位、个位与开奖号码相同，且顺序一致，即为中奖。',
methodexample:'投注方案：23456； 开奖号码：23456，即中五星直选一等奖',
selectarea:{type:'input',singletypetips:'三星123,234 五星12345'},
show_str : 'X',
code_sp : ' ',
	methodid : 2274,
	name:'单式',
	prize:{1:'180000.00'},
        nfdprize:{levs:moneyMap['2274'].split(",")[0],defaultprize:moneyMap['2274'].split(",")[1],userdiffpoint:fandian},
	modes:[{modeid:1,name:'元',rate:1},{modeid:2,name:'角',rate:0.1},{modeid:3,name:'分',rate:0.01}],
	desc:'单式',maxcodecount:0
},{methoddesc:'从个、十、百、千、万位各选一个号码组成五注。',
methodhelp:'从万位、千位、百位、十位、个位中至少各选一个号码组成1-5星的组合，共五注，所选号码的个位与开奖号码相同，则中1个5等奖；所选号码的个位、十位与开奖号码相同，则中1个5等奖以及1个4等奖，依此类推，最高可中5个奖。',
methodexample:'五星组合示例，如购买：4+5+6+7+8，该票共10元，由以下5注：45678(五星)、5678(四星)、678(三星)、78(二星)、8(一星)构成。开奖号码：45678，即可中五星、四星、三星、二星、一星的一等奖各1注。',
selectarea:{
       type   : 'digital',
       layout : [
		   {title:'万位', no:'0|1|2|3|4|5|6|7|8|9', place:0, cols:1},
		   {title:'千位', no:'0|1|2|3|4|5|6|7|8|9', place:1, cols:1},
		   {title:'百位', no:'0|1|2|3|4|5|6|7|8|9', place:2, cols:1},
		   {title:'十位', no:'0|1|2|3|4|5|6|7|8|9', place:3, cols:1},
		   {title:'个位', no:'0|1|2|3|4|5|6|7|8|9', place:4, cols:1}
		  ],
       noBigIndex : 5,
       isButton   : true
      },
show_str : 'X,X,X,X,X',
code_sp : '',
	methodid : 2276,
	name:'组合',
	prize:{1:'180000.00',2:'18000.00',3:'1800.00',4:'180.00',5:'18.00'},
        nfdprize:{},
	modes:[{modeid:1,name:'元',rate:1},{modeid:2,name:'角',rate:0.1},{modeid:3,name:'分',rate:0.01}],
	desc:'组合',maxcodecount:0
}]},{gtitle:'五星组选', label:[{methoddesc:'从0-9中选择5个号码组成一注。',
methodhelp:'从0-9中任意选择5个号码组成一注，所选号码与开奖号码的万位、千位、百位、十位、个位相同，顺序不限，即为中奖。',
methodexample:'投注方案：02568，开奖号码的五个数字只要包含0、2、5、6、8，即可中五星组选120一等奖。',
selectarea:{
    type   : 'digital',
    layout : [
               {title:'', no:'0|1|2|3|4|5|6|7|8|9', place:0, cols:1, minchosen:5}
             ],
             noBigIndex : 5,
             isButton   : true
},
show_str : 'X',
code_sp : ',',
	methodid : 2278,
	name:'组选120',
	prize:{1:'1500.00'},
        nfdprize:{levs:moneyMap['2278'].split(",")[0],defaultprize:moneyMap['2278'].split(",")[1],userdiffpoint:fandian},
	modes:[{modeid:1,name:'元',rate:1},{modeid:2,name:'角',rate:0.1},{modeid:3,name:'分',rate:0.01}],
	desc:'组选120',maxcodecount:0
},{methoddesc:'从“二重号”选择一个号码，“单号”中选择三个号码组成一注。',
methodhelp:'选择1个二重号码和3个单号号码组成一注，所选的单号号码与开奖号码相同，且所选二重号码在开奖号码中出现了2次，即为中奖。',
methodexample:'投注方案：二重号：8，单号：0、2、5，只要开奖的5个数字包括 0、2、5、8、8，即可中五星组选60一等奖。',
selectarea:{
       type   : 'digital',
       layout : [
		   {title:'二重号', no:'0|1|2|3|4|5|6|7|8|9', place:0, cols:1, minchosen: 1},
		   {title:'单　号', no:'0|1|2|3|4|5|6|7|8|9', place:1, cols:1, minchosen: 3}
		  ],
       noBigIndex : 5,
       isButton   : true
      },
show_str : 'X,X',
code_sp : '',
	methodid : 2279,
	name:'组选60 ',
	prize:{2:'3000.00'},
        nfdprize:{levs:moneyMap['2279'].split(",")[0],defaultprize:moneyMap['2279'].split(",")[1],userdiffpoint:fandian},
	modes:[{modeid:1,name:'元',rate:1},{modeid:2,name:'角',rate:0.1},{modeid:3,name:'分',rate:0.01}],
	desc:'组选60 ',maxcodecount:0
},{methoddesc:'从“二重号”选择两个号码，“单号”中选择一个号码组成一注。',
methodhelp:'选择2个二重号和1个单号号码组成一注，所选的单号号码与开奖号码相同，且所选的2个二重号码分别在开奖号码中出现了2次，即为中奖。',
methodexample:'投注方案：二重号：2、8，单号：0，只要开奖的5个数字包括 0、2、2、8、8，即可中五星组选30一等奖。',
selectarea:{
       type   : 'digital',
       layout : [
		   {title:'二重号', no:'0|1|2|3|4|5|6|7|8|9', place:0, cols:1, minchosen: 2},
		   {title:'单　号', no:'0|1|2|3|4|5|6|7|8|9', place:1, cols:1, minchosen: 1}
		  ],
       noBigIndex : 5,
       isButton   : true
      },
show_str : 'X,X',
code_sp : '',
	methodid : 2280,
	name:'组选30',
	prize:{3:'6000.00'},
        nfdprize:{levs:moneyMap['2280'].split(",")[0],defaultprize:moneyMap['2280'].split(",")[1],userdiffpoint:fandian},
	modes:[{modeid:1,name:'元',rate:1},{modeid:2,name:'角',rate:0.1},{modeid:3,name:'分',rate:0.01}],
	desc:'组选30',maxcodecount:0
},{methoddesc:'从“三重号”选择一个号码，“单号”中选择两个号码组成一注。',
methodhelp:'选择1个三重号码和2个单号号码组成一注，所选的单号号码与开奖号码相同，且所选三重号码在开奖号码中出现了3次，即为中奖。',
methodexample:'投注方案：三重号：8，单号：0、2，只要开奖的5个数字包括 0、2、8、8、8，即可中五星组选20一等奖。',
selectarea:{
       type   : 'digital',
       layout : [
		   {title:'三重号', no:'0|1|2|3|4|5|6|7|8|9', place:0, cols:1, minchosen: 1},
		   {title:'单　号', no:'0|1|2|3|4|5|6|7|8|9', place:1, cols:1, minchosen: 2}
		  ],
       noBigIndex : 5,
       isButton   : true
      },
show_str : 'X,X',
code_sp : '',
	methodid : 2281,
	name:'组选20',
	prize:{4:'9000.00'},
        nfdprize:{levs:moneyMap['2281'].split(",")[0],defaultprize:moneyMap['2281'].split(",")[1],userdiffpoint:fandian},
	modes:[{modeid:1,name:'元',rate:1},{modeid:2,name:'角',rate:0.1},{modeid:3,name:'分',rate:0.01}],
	desc:'组选20',maxcodecount:0
},{methoddesc:'从“三重号”选择一个号码，“二重号”中选择一个号码组成一注。',
methodhelp:'选择1个三重号码和1个二重号码，所选三重号码在开奖号码中出现3次，并且所选二重号码在开奖号码中出现了2次，即为中奖。',
methodexample:'投注方案：三重号：8，二重号：2，只要开奖的5个数字包括 2、2、8、8、8，即可中五星组选10一等奖。',
selectarea:{
       type   : 'digital',
       layout : [
		   {title:'三重号', no:'0|1|2|3|4|5|6|7|8|9', place:0, cols:1, minchosen: 1},
		   {title:'二重号', no:'0|1|2|3|4|5|6|7|8|9', place:1, cols:1, minchosen: 1}
		  ],
       noBigIndex : 5,
       isButton   : true
      },
show_str : 'X,X',
code_sp : '',
	methodid : 2282,
	name:'组选10',
	prize:{5:'18000.00'},
        nfdprize:{levs:moneyMap['2282'].split(",")[0],defaultprize:moneyMap['2282'].split(",")[1],userdiffpoint:fandian},
	modes:[{modeid:1,name:'元',rate:1},{modeid:2,name:'角',rate:0.1},{modeid:3,name:'分',rate:0.01}],
	desc:'组选10',maxcodecount:0
},{methoddesc:'从“四重号”选择一个号码，“单号”中选择一个号码组成一注。',
methodhelp:'选择1个四重号码和1个单号号码组成一注，所选的单号号码与开奖号码相同，且所选四重号码在开奖号码中出现了4次，即为中奖。',
methodexample:'投注方案：四重号：8，单号：2，只要开奖的5个数字包括 2、8、8、8、8，即可中五星组选5一等奖。',
selectarea:{
       type   : 'digital',
       layout : [
		   {title:'四重号', no:'0|1|2|3|4|5|6|7|8|9', place:0, cols:1, minchosen: 1},
		   {title:'单　号', no:'0|1|2|3|4|5|6|7|8|9', place:1, cols:1, minchosen: 1}
		  ],
       noBigIndex : 5,
       isButton   : true
      },
show_str : 'X,X',
code_sp : '',
	methodid : 2283,
	name:'组选5',
	prize:{6:'36000.00'},
        nfdprize:{levs:moneyMap['2283'].split(",")[0],defaultprize:moneyMap['2283'].split(",")[1],userdiffpoint:fandian},
	modes:[{modeid:1,name:'元',rate:1},{modeid:2,name:'角',rate:0.1},{modeid:3,name:'分',rate:0.01}],
	desc:'组选5',maxcodecount:0
}]}]},		{isnew:"0",isdefault:"0",title:"四星", label:[{gtitle:'四星直选', label:[{methoddesc:'从千位、百位、十位、个位中选择一个4位数号码组成一注',
methodhelp:'从千位、百位、十位、个位中选择一个4位数号码组成一注，所选号码与开奖号码相同，且顺序一致，即为中奖。',
methodexample:'投注方案：3456；开奖号码：*3456，即中四星直选。',
selectarea:{
       type   : 'digital',
       layout : [
                    {title:'千位', no:'0|1|2|3|4|5|6|7|8|9', place:0, cols:1},
                    {title:'百位', no:'0|1|2|3|4|5|6|7|8|9', place:1, cols:1},
                    {title:'十位', no:'0|1|2|3|4|5|6|7|8|9', place:2, cols:1},
		   {title:'个位', no:'0|1|2|3|4|5|6|7|8|9', place:3, cols:1}
		  ],
       noBigIndex : 5,
       isButton   : true
      },
show_str : '-,X,X,X,X',
code_sp : '',
	methodid : 2265,
	name:'复式',
	prize:{1:'18000.00'},
        nfdprize:{levs:moneyMap['2265'].split(",")[0],defaultprize:moneyMap['2265'].split(",")[1],userdiffpoint:fandian},
	modes:[{modeid:1,name:'元',rate:1},{modeid:2,name:'角',rate:0.1},{modeid:3,name:'分',rate:0.01}],
	desc:'复式',maxcodecount:0
},{methoddesc:'手动输入号码，至少输入1个四位数号码组成一注。',
methodhelp:'手动输入一个4位数号码组成一注，所选号码的千位、百位、十位、个位与开奖号码相同，且顺序一致，即为中奖。',
methodexample:'投注方案：3456； 开奖号码：3456，即中四星直选一等奖',
selectarea:{type:'input',singletypetips:'三星123,234 五星12345'},
show_str : 'X',
code_sp : ' ',
	methodid : 2265,
	name:'单式',
	prize:{1:'18000.00'},
        nfdprize:{levs:moneyMap['2265'].split(",")[0],defaultprize:moneyMap['2265'].split(",")[1],userdiffpoint:fandian},
	modes:[{modeid:1,name:'元',rate:1},{modeid:2,name:'角',rate:0.1},{modeid:3,name:'分',rate:0.01}],
	desc:'单式',maxcodecount:0
},{methoddesc:'在千位，百位，十位，个位任意位置上任意选择1个或1个以上号码。',
methodhelp:'从千位、百位、十位、个位任意位置上至少选择1个以上号码，所选号码与相同位置上的开奖号码一致，即为中奖。',
methodexample:'投注方案：1；开奖号码万位：1，即中定位胆万位一等奖。',
selectarea:{
       type   : 'digital',
       layout : [

		   {title:'千位', no:'0|1|2|3|4|5|6|7|8|9', place:0, cols:1},
		   {title:'百位', no:'0|1|2|3|4|5|6|7|8|9', place:1, cols:1},
		   {title:'十位', no:'0|1|2|3|4|5|6|7|8|9', place:2, cols:1},
		   {title:'个位', no:'0|1|2|3|4|5|6|7|8|9', place:3, cols:1}
		  ],
       noBigIndex : 5,
       isButton   : true
      },
show_str : '-,X,X,X,X',
code_sp : '',
	methodid : 2267,
	name:'组合',
	prize:{1:'18000.00',2:'1800.00',3:'180.00',4:'18.00'},
        nfdprize:{},
	modes:[{modeid:1,name:'元',rate:1},{modeid:2,name:'角',rate:0.1},{modeid:3,name:'分',rate:0.01}],
	desc:'组合',maxcodecount:0
}]},{gtitle:'四星组选', label:[{methoddesc:'从0-9中选择4个号码组成一注。',
methodhelp:'从0-9中任意选择4个号码组成一注，所选号码与开奖号码的千位、百位、十位、个位相同，且顺序不限，即为中奖。',
methodexample:'投注方案：0568，开奖号码的四个数字只要包含0、5、6、8，即可中四星组选24一等奖。',
selectarea:{
       type   : 'digital',
       layout : [
		   {title:'', no:'0|1|2|3|4|5|6|7|8|9', place:0, cols:1, minchosen:4}
		  ],
       noBigIndex : 5,
       isButton   : true
      },
show_str : 'X',
code_sp : ',',
	methodid : 2269,
	name:'组选24',
	prize:{1:'750.00'},
        nfdprize:{levs:moneyMap['2269'].split(",")[0],defaultprize:moneyMap['2269'].split(",")[1],userdiffpoint:fandian},
	modes:[{modeid:1,name:'元',rate:1},{modeid:2,name:'角',rate:0.1},{modeid:3,name:'分',rate:0.01}],
	desc:'组选24',maxcodecount:0
},{methoddesc:'从“二重号”选择一个号码，“单号”中选择两个号码组成一注。',
methodhelp:'选择1个二重号码和2个单号号码组成一注，所选单号号码与开奖号码相同，且所选二重号码在开奖号码中出现了2次，即为中奖。',
methodexample:'投注方案：二重号：8，单号：0、6，只要开奖的四个数字包括 0、6、8、8，即可中四星组选12一等奖。',
selectarea:{
       type   : 'digital',
       layout : [
		   {title:'二重号', no:'0|1|2|3|4|5|6|7|8|9', place:0, cols:1, minchosen:1},
		   {title:'单　号', no:'0|1|2|3|4|5|6|7|8|9', place:1, cols:1, minchosen:2}
		  ],
       noBigIndex : 5,
       isButton   : true
      },
show_str : 'X,X',
code_sp : '',
	methodid : 2270,
	name:'组选12',
	prize:{2:'1500.00'},
        nfdprize:{levs:moneyMap['2270'].split(",")[0],defaultprize:moneyMap['2270'].split(",")[1],userdiffpoint:fandian},
	modes:[{modeid:1,name:'元',rate:1},{modeid:2,name:'角',rate:0.1},{modeid:3,name:'分',rate:0.01}],
	desc:'组选12',maxcodecount:0
},{methoddesc:'从“二重号”选择两个号码组成一注。',
methodhelp:'选择2个二重号码组成一注，所选的2个二重号码在开奖号码中分别出现了2次，即为中奖。',
methodexample:'投注方案：二重号：6、8，只要开奖的四个数字从小到大排列为 6、6、8、8，即可中四星组选6。',
selectarea:{
       type   : 'digital',
       layout : [
		   {title:'二重号', no:'0|1|2|3|4|5|6|7|8|9', place:0, cols:1, minchosen:2}
		  ],
       noBigIndex : 5,
       isButton   : true
      },
show_str : 'X',
code_sp : ',',
	methodid : 2271,
	name:'组选6',
	prize:{3:'3000.00'},
        nfdprize:{levs:moneyMap['2271'].split(",")[0],defaultprize:moneyMap['2271'].split(",")[1],userdiffpoint:fandian},
	modes:[{modeid:1,name:'元',rate:1},{modeid:2,name:'角',rate:0.1},{modeid:3,name:'分',rate:0.01}],
	desc:'组选6',maxcodecount:0
},{methoddesc:'从“三重号”选择一个号码，“单号”中选择两个号码组成一注。',
methodhelp:'选择1个三重号码和1个单号号码组成一注，所选单号号码与开奖号码相同，且所选三重号码在开奖号码中出现了3次，即为中奖。',
methodexample:'投注方案：三重号：8，单号：2，只要开奖的四个数字从小到大排列为 2、8、8、8，即可中四星组选4。',
selectarea:{
       type   : 'digital',
       layout : [
		   {title:'三重号', no:'0|1|2|3|4|5|6|7|8|9', place:0, cols:1, minchosen:1},{title:'单　号', no:'0|1|2|3|4|5|6|7|8|9', place:1, cols:1, minchosen:1}
		  ],
       noBigIndex : 5,
       isButton   : true
      },
show_str : 'X,X',
code_sp : '',
	methodid : 2272,
	name:'组选4',
	prize:{4:'4500.00'},
        nfdprize:{levs:moneyMap['2272'].split(",")[0],defaultprize:moneyMap['2272'].split(",")[1],userdiffpoint:fandian},
	modes:[{modeid:1,name:'元',rate:1},{modeid:2,name:'角',rate:0.1},{modeid:3,name:'分',rate:0.01}],
	desc:'组选4',maxcodecount:0
}]}]},		{isnew:"0",isdefault:"1",title:"后三码", label:[{gtitle:'后三直选', label:[{methoddesc:'从个、十、百位各选一个号码组成一注。',
methodhelp:'从百位、十位、个位中选择一个3位数号码组成一注，所选号码与开奖号码后3位相同，且顺序一致，即为中奖。',
methodexample:'投注方案：345；<br />开奖号码：345，<br />即中后三直选一等奖',
selectarea:{
       type   : 'digital',
       layout : [
		   {title:'百位', no:'0|1|2|3|4|5|6|7|8|9', place:0, cols:1},
		   {title:'十位', no:'0|1|2|3|4|5|6|7|8|9', place:1, cols:1},
		   {title:'个位', no:'0|1|2|3|4|5|6|7|8|9', place:2, cols:1}
		  ],
       noBigIndex : 5,
       isButton   : true
      },
show_str : '-,-,X,X,X',
code_sp : '',
	methodid : 5,
	name:'复式',
	prize:{1:'1800.00'},
        nfdprize:{levs:moneyMap['5'].split(",")[0],defaultprize:moneyMap['5'].split(",")[1],userdiffpoint:fandian},
	modes:[{modeid:1,name:'元',rate:1},{modeid:2,name:'角',rate:0.1},{modeid:3,name:'分',rate:0.01}],
	desc:'复式',maxcodecount:0
},{methoddesc:'手动输入号码，至少输入1个三位数号码组成一注。',
methodhelp:'手动输入一个3位数号码组成一注，所选号码的百位、十位、个位与开奖号码相同，且顺序一致，即为中奖。',
methodexample:'投注方案：345； 开奖号码：345，即中后三直选一等奖',
selectarea:{type:'input'},
show_str : 'X',
code_sp : ' ',
	methodid : 5,
	name:'单式',
	prize:{1:'1800.00'},
        nfdprize:{levs:moneyMap['5'].split(",")[0],defaultprize:moneyMap['5'].split(",")[1],userdiffpoint:fandian},
	modes:[{modeid:1,name:'元',rate:1},{modeid:2,name:'角',rate:0.1},{modeid:3,name:'分',rate:0.01}],
	desc:'单式',maxcodecount:0
},{methoddesc:'从0-27中任意选择1个或1个以上号码',
methodhelp:'所选数值等于开奖号码的百位、十位、个位三个数字相加之和，即为中奖。',
methodexample:'投注方案：和值1；开奖号码后三位：001,010,100,即中后三直选一等奖',
selectarea:{
       type   : 'digital',
       layout : [
		   {title:'直选和值', no:'0|1|2|3|4|5|6|7|8|9|10|11|12|13', place:0, cols:1},
		   {title:'', no:'14|15|16|17|18|19|20|21|22|23|24|25|26|27', place:0, cols:1}
		 ],
       isButton   : false
      },
show_str : 'X',
code_sp : ',',
	methodid : 6,
	name:'直选和值',
	prize:{1:'1800.00'},
        nfdprize:{levs:moneyMap['6'].split(",")[0],defaultprize:moneyMap['6'].split(",")[1],userdiffpoint:fandian},
	modes:[{modeid:1,name:'元',rate:1},{modeid:2,name:'角',rate:0.1},{modeid:3,name:'分',rate:0.01}],
	desc:'直选和值',maxcodecount:0
}]},{gtitle:'后三组选', label:[{methoddesc:'从0-9中任意选择2个或2个以上号码。',
methodhelp:'从0-9中选择2个数字组成两注，所选号码与开奖号码的百位、十位、个位相同，且顺序不限，即为中奖。',
methodexample:'投注方案：5,8,8；开奖号码后三位：1个5，2个8 (顺序不限)，即中后三组选三一等奖。',
selectarea:{
       type   : 'digital',
       layout : [
		   {title:'组三', no:'0|1|2|3|4|5|6|7|8|9', place:0, cols:1}
		  ],
       noBigIndex : 5,
       isButton   : true
      },
show_str : 'X',
code_sp : ',',
	methodid : 13,
	name:'组三',
	prize:{1:'600.00'},
        nfdprize:{levs:moneyMap['13'].split(",")[0],defaultprize:moneyMap['13'].split(",")[1],userdiffpoint:fandian},
	modes:[{modeid:1,name:'元',rate:1},{modeid:2,name:'角',rate:0.1},{modeid:3,name:'分',rate:0.01}],
	desc:'组三',maxcodecount:0
},{methoddesc:'从0-9中任意选择3个或3个以上号码。',
methodhelp:'从0-9中任意选择3个号码组成一注，所选号码与开奖号码的百位、十位、个位相同，顺序不限，即为中奖。',
methodexample:'投注方案：2,5,8；开奖号码后三位：1个2、1个5、1个8 (顺序不限)，即中后三组选六一等奖。',
selectarea:{
       type   : 'digital',
       layout : [
		   {title:'组六', no:'0|1|2|3|4|5|6|7|8|9', place:0, cols:1}
		  ],
       noBigIndex : 5,
       isButton   : true
      },
show_str : 'X',
code_sp : ',',
	methodid : 14,
	name:'组六',
	prize:{2:'300.00'},
        nfdprize:{levs:moneyMap['14'].split(",")[0],defaultprize:moneyMap['14'].split(",")[1],userdiffpoint:fandian},
	modes:[{modeid:1,name:'元',rate:1},{modeid:2,name:'角',rate:0.1},{modeid:3,name:'分',rate:0.01}],
	desc:'组六',maxcodecount:0
},{methoddesc:'手动输入号码，至少输入1个三位数号码。',
methodhelp:'键盘手动输入购买号码，3个数字为一注，开奖号码的百位、十位、个位符合后三组三或组六均为中奖。',
methodexample:'投注方案：分別投注(0,0,1),以及(1,2,3)，开奖号码后三位包括：(1)0,0,1，顺序不限，即中得组三一等奖；或者(2)1,2,3，顺序不限，即中得组六一等奖。',
selectarea:{type:'input'},
show_str : 'X',
code_sp : ' ',
	methodid : 15,
	name:'混合',
	prize:{1:'600.00',2:'300.00'},
        nfdprize:{},
	modes:[{modeid:1,name:'元',rate:1},{modeid:2,name:'角',rate:0.1},{modeid:3,name:'分',rate:0.01}],
	desc:'混合组选',maxcodecount:0
},{methoddesc:'从0-9中选择1个号码。',
methodhelp:'所选数值等于开奖号码百位、十位、个位三个数字相加之和，即为中奖。',
methodexample:'投注方案：和值3；开奖号码后三位：(1)开出003号码，顺序不限，即中后三组选三一等奖；(2)开出012号码，顺序不限，即中后三组选六一等奖',
selectarea:{
       type   : 'digital',
       layout : [
		   {title:'组选和值', no:'1|2|3|4|5|6|7|8|9|10|11|12|13', place:0, cols:1},
		   {title:'', no:'14|15|16|17|18|19|20|21|22|23|24|25|26', place:0, cols:1}
		 ],
       isButton   : false
      },
show_str : 'X',
code_sp : ',',
	methodid : 16,
	name:'组选和值',
	prize:{1:'600.00',2:'300.00'},
        nfdprize:{},
	modes:[{modeid:1,name:'元',rate:1},{modeid:2,name:'角',rate:0.1},{modeid:3,name:'分',rate:0.01}],
	desc:'组选和值',maxcodecount:0
}]}]},		{isnew:"0",isdefault:"0",title:"前三码", label:[{gtitle:'前三直选', label:[{methoddesc:'从万、千、百位各选一个号码组成一注。',
methodhelp:'从万位、千位、百位中选择一个3位数号码组成一注，所选号码与开奖号码的前3位相同，且顺序一致，即为中奖。',
methodexample:'投注方案：345； 开奖号码：345，即中前三直选一等奖',
selectarea:{type:'digital',layout:[{title:'万位', no:'0|1|2|3|4|5|6|7|8|9', place:0, cols:1},{title:'千位', no:'0|1|2|3|4|5|6|7|8|9', place:1, cols:1},{title:'百位', no:'0|1|2|3|4|5|6|7|8|9', place:2, cols:1}],noBigIndex:5,isButton:true},
show_str : 'X,X,X,-,-',
code_sp  : '',
	methodid : 2,
	name:'复式',
	prize:{1:'1800.00'},
        nfdprize:{levs:moneyMap['2'].split(",")[0],defaultprize:moneyMap['2'].split(",")[1],userdiffpoint:fandian},
	modes:[{modeid:1,name:'元',rate:1},{modeid:2,name:'角',rate:0.1},{modeid:3,name:'分',rate:0.01}],
	desc:'复式',maxcodecount:0
},{methoddesc:'手动输入号码，至少输入1个三位数号码组成一注。',
methodhelp:'手动输入一个3位数号码组成一注，所选号码的万位、千位、百位与开奖号码相同，且顺序一致，即为中奖。',
methodexample:'投注方案：345； 开奖号码：345，即中前三直选一等奖',
selectarea:{type:'input'},
show_str : 'X',
code_sp : ' ',
	methodid : 2,
	name:'单式',
	prize:{1:'1800.00'},
        nfdprize:{levs:moneyMap['2'].split(",")[0],defaultprize:moneyMap['2'].split(",")[1],userdiffpoint:fandian},
	modes:[{modeid:1,name:'元',rate:1},{modeid:2,name:'角',rate:0.1},{modeid:3,name:'分',rate:0.01}],
	desc:'单式',maxcodecount:0
},{methoddesc:'从0-27中任意选择1个或1个以上号码',
methodhelp:'所选数值等于开奖号码的万位、千位、百位三个数字相加之和，即为中奖。',
methodexample:'投注方案：和值1；开奖号码前三位：001,010,100,即中前三直选一等奖',
selectarea:{
       type   : 'digital',
       layout : [
		   {title:'直选和值', no:'0|1|2|3|4|5|6|7|8|9|10|11|12|13', place:0, cols:1},
		   {title:'', no:'14|15|16|17|18|19|20|21|22|23|24|25|26|27', place:0, cols:1}
		 ],
       isButton   : false
      },
show_str : 'X',
code_sp : ',',
	methodid : 3,
	name:'直选和值',
	prize:{1:'1800.00'},
        nfdprize:{levs:moneyMap['3'].split(",")[0],defaultprize:moneyMap['3'].split(",")[1],userdiffpoint:fandian},
	modes:[{modeid:1,name:'元',rate:1},{modeid:2,name:'角',rate:0.1},{modeid:3,name:'分',rate:0.01}],
	desc:'直选和值',maxcodecount:0
}]},{gtitle:'前三组选', label:[{methoddesc:'从0-9中任意选择2个或2个以上号码。',
methodhelp:'从0-9中选择2个数字组成两注，所选号码与开奖号码的万位、千位、百位相同，且顺序不限，即为中奖。',
methodexample:'投注方案：5,8,8；开奖号码前三位：1个5，2个8 (顺序不限)，即中前三组选三一等奖。',
selectarea:{
       type   : 'digital',
       layout : [
		   {title:'组三', no:'0|1|2|3|4|5|6|7|8|9', place:0, cols:1}
		  ],
       noBigIndex : 5,
       isButton   : true
      },
show_str : 'X',
code_sp : ',',
	methodid : 8,
	name:'组三',
	prize:{1:'600.00'},
        nfdprize:{levs:moneyMap['8'].split(",")[0],defaultprize:moneyMap['8'].split(",")[1],userdiffpoint:fandian},
	modes:[{modeid:1,name:'元',rate:1},{modeid:2,name:'角',rate:0.1},{modeid:3,name:'分',rate:0.01}],
	desc:'组三',maxcodecount:0
},{methoddesc:'从0-9中任意选择3个或3个以上号码。',
methodhelp:'从0-9中任意选择3个号码组成一注，所选号码与开奖号码的万位、千位、百位相同，顺序不限，即为中奖。',
methodexample:'投注方案：2,5,8；开奖号码前三位：1个2、1个5、1个8 (顺序不限)，即中前三组选六一等奖。',
selectarea:{
       type   : 'digital',
       layout : [
		   {title:'组六', no:'0|1|2|3|4|5|6|7|8|9', place:0, cols:1}
		  ],
       noBigIndex : 5,
       isButton   : true
      },
show_str : 'X',
code_sp : ',',
	methodid : 9,
	name:'组六',
	prize:{2:'300.00'},
        nfdprize:{levs:moneyMap['9'].split(",")[0],defaultprize:moneyMap['9'].split(",")[1],userdiffpoint:fandian},
	modes:[{modeid:1,name:'元',rate:1},{modeid:2,name:'角',rate:0.1},{modeid:3,name:'分',rate:0.01}],
	desc:'组六',maxcodecount:0
},{methoddesc:'手动输入号码，至少输入1个三位数号码。',
methodhelp:'键盘手动输入购买号码，3个数字为一注，开奖号码的万位、千位、百位符合后三组三或组六均为中奖。',
methodexample:'投注方案：分別投注(0,0,1),以及(1,2,3)，开奖号码前三位包括：(1)0,0,1，顺序不限，即中得组三一等奖；或者(2)1,2,3，顺序不限，即中得组六一等奖。',
selectarea:{type:'input'},
show_str : 'X',
code_sp : ' ',
	methodid : 10,
	name:'混合',
	prize:{1:'600.00',2:'300.00'},
        nfdprize:{},
	modes:[{modeid:1,name:'元',rate:1},{modeid:2,name:'角',rate:0.1},{modeid:3,name:'分',rate:0.01}],
	desc:'混合组选',maxcodecount:0
},{methoddesc:'从1-26中任意选择1个以上号码。',
methodhelp:'所选数值等于开奖号码万位、千位、百位三个数字相加之和，即为中奖。',
methodexample:'投注方案：和值3；<br />开奖号码前三位：<br />(1)开出003号码，顺序不限，即中前三组选三一等奖；<br />(2)开出012号码，顺序不限，即中前三组选六一等奖',
selectarea:{
       type   : 'digital',
       layout : [
		   {title:'组选和值', no:'1|2|3|4|5|6|7|8|9|10|11|12|13', place:0, cols:1},
		   {title:'', no:'14|15|16|17|18|19|20|21|22|23|24|25|26', place:0, cols:1}
		 ],
       isButton   : false
      },
show_str : 'X',
code_sp : ',',
	methodid : 11,
	name:'组选和值',
	prize:{1:'600.00',2:'300.00'},
        nfdprize:{},
	modes:[{modeid:1,name:'元',rate:1},{modeid:2,name:'角',rate:0.1},{modeid:3,name:'分',rate:0.01}],
	desc:'组选和值',maxcodecount:0
}]}]},		{isnew:"0",isdefault:"0",title:"中三码", label:[{gtitle:'中三直选', label:[{methoddesc:'从千、百、十位各选一个号码组成一注。',
methodhelp:'从千位、百位、十位中选择一个3位数号码组成一注，所选号码与开奖号码的中间3位相同，且顺序一致，即为中奖。',
methodexample:'投注方案：456； 开奖号码：3456，即中中三直选一等奖',
selectarea:{type:'digital',layout:[{title:'千位', no:'0|1|2|3|4|5|6|7|8|9', place:0, cols:1},{title:'百位', no:'0|1|2|3|4|5|6|7|8|9', place:1, cols:1},{title:'十位', no:'0|1|2|3|4|5|6|7|8|9', place:2, cols:1}],noBigIndex:5,isButton:true},
show_str : '-,X,X,X,-',
code_sp  : '',
	methodid : 2291,
	name:'复式',
	prize:{1:'1800.00'},
        nfdprize:{levs:moneyMap['2291'].split(",")[0],defaultprize:moneyMap['2291'].split(",")[1],userdiffpoint:fandian},
	modes:[{modeid:1,name:'元',rate:1},{modeid:2,name:'角',rate:0.1},{modeid:3,name:'分',rate:0.01}],
	desc:'复式',maxcodecount:0
},{methoddesc:'手动输入号码，至少输入1个三位数号码组成一注。',
methodhelp:'手动输入一个3位数号码组成一注，所选号码的千位、百位、十位与开奖号码相同，且顺序一致，即为中奖。',
methodexample:'投注方案：345； 开奖号码：2345，即中中三直选一等奖',
selectarea:{type:'input'},
show_str : 'X',
code_sp : ' ',
	methodid : 2291,
	name:'单式',
	prize:{1:'1800.00'},
        nfdprize:{levs:moneyMap['2291'].split(",")[0],defaultprize:moneyMap['2291'].split(",")[1],userdiffpoint:fandian},
	modes:[{modeid:1,name:'元',rate:1},{modeid:2,name:'角',rate:0.1},{modeid:3,name:'分',rate:0.01}],
	desc:'单式',maxcodecount:0
},{methoddesc:'从0-27中任意选择1个或1个以上号码',
methodhelp:'所选数值等于开奖号码的千位、百位、十位三个数字相加之和，即为中奖。',
methodexample:'投注方案：和值1；开奖号码中间三位：01001,00010,00100,即中中三直选一等奖',
selectarea:{
       type   : 'digital',
       layout : [
		   {title:'直选和值', no:'0|1|2|3|4|5|6|7|8|9|10|11|12|13', place:0, cols:1},
		   {title:'', no:'14|15|16|17|18|19|20|21|22|23|24|25|26|27', place:0, cols:1}
		 ],
       isButton   : false
      },
show_str : 'X',
code_sp : ',',
	methodid : 2292,
	name:'直选和值',
	prize:{1:'1800.00'},
        nfdprize:{levs:moneyMap['2292'].split(",")[0],defaultprize:moneyMap['2292'].split(",")[1],userdiffpoint:fandian},
	modes:[{modeid:1,name:'元',rate:1},{modeid:2,name:'角',rate:0.1},{modeid:3,name:'分',rate:0.01}],
	desc:'直选和值',maxcodecount:0
}]},{gtitle:'中三组选', label:[{methoddesc:'从0-9中任意选择2个或2个以上号码。',
methodhelp:'从0-9中选择2个数字组成两注，所选号码与开奖号码的千位、百位、十位相同，且顺序不限，即为中奖。',
methodexample:'投注方案：5,8,8；开奖号码中间三位：1个5，2个8 (顺序不限)，即中中三组选三一等奖。',
selectarea:{
       type   : 'digital',
       layout : [
		   {title:'组三', no:'0|1|2|3|4|5|6|7|8|9', place:0, cols:1}
		  ],
       noBigIndex : 5,
       isButton   : true
      },
show_str : 'X',
code_sp : ',',
	methodid : 2293,
	name:'组三',
	prize:{1:'600.00'},
        nfdprize:{levs:moneyMap['2293'].split(",")[0],defaultprize:moneyMap['2293'].split(",")[1],userdiffpoint:fandian},
	modes:[{modeid:1,name:'元',rate:1},{modeid:2,name:'角',rate:0.1},{modeid:3,name:'分',rate:0.01}],
	desc:'组三',maxcodecount:0
},{methoddesc:'手动输入号码，至少输入1个三位数号码。',
methodhelp:'键盘手动输入购买号码，3个数字为一注，开奖号码的千位、百位、十位符合中三组三或组六均为中奖。',
methodexample:'投注方案：分別投注(0,0,1),以及(1,2,3)，开奖号码中间三位包括：(1)0,0,1，顺序不限，即中得组三一等奖；或者(2)1,2,3，顺序不限，即中得组六一等奖。',
selectarea:{type:'input'},
show_str : 'X',
code_sp : ' ',
	methodid : 2295,
	name:'混合',
	prize:{1:'600.00',2:'300.00'},
        nfdprize:{},
	modes:[{modeid:1,name:'元',rate:1},{modeid:2,name:'角',rate:0.1},{modeid:3,name:'分',rate:0.01}],
	desc:'混合',maxcodecount:0
},{methoddesc:'从0-9中任意选择3个或3个以上号码。',
methodhelp:'从0-9中任意选择3个号码组成一注，所选号码与开奖号码的千位、百位、十位相同，顺序不限，即为中奖。',
methodexample:'投注方案：2,5,8；开奖号码中间三位：1个2、1个5、1个8 (顺序不限)，即中中三组选六一等奖。',
selectarea:{
       type   : 'digital',
       layout : [
		   {title:'组六', no:'0|1|2|3|4|5|6|7|8|9', place:0, cols:1}
		  ],
       noBigIndex : 5,
       isButton   : true
      },
show_str : 'X',
code_sp : ',',
	methodid : 2294,
	name:'组六',
	prize:{2:'300.00'},
        nfdprize:{levs:moneyMap['2294'].split(",")[0],defaultprize:moneyMap['2294'].split(",")[1],userdiffpoint:fandian},
	modes:[{modeid:1,name:'元',rate:1},{modeid:2,name:'角',rate:0.1},{modeid:3,name:'分',rate:0.01}],
	desc:'组六',maxcodecount:0
},{methoddesc:'从0-9中选择1个号码。',
methodhelp:'所选数值等于开奖号码千位、百位、十位三个数字相加之和，即为中奖。',
methodexample:'投注方案：和值3；开奖号码中间三位：(1)开出003号码，顺序不限，即中中三组选三一等奖；(2)开出012号码，顺序不限，即中中三组选六一等奖',
selectarea:{
       type   : 'digital',
       layout : [
		   {title:'组选和值', no:'1|2|3|4|5|6|7|8|9|10|11|12|13', place:0, cols:1},
		   {title:'', no:'14|15|16|17|18|19|20|21|22|23|24|25|26', place:0, cols:1}
		 ],
       isButton   : false
      },
show_str : 'X',
code_sp : ',',
	methodid : 2296,
	name:'组选和值',
	prize:{1:'600.00',2:'300.00'},
        nfdprize:{},
	modes:[{modeid:1,name:'元',rate:1},{modeid:2,name:'角',rate:0.1},{modeid:3,name:'分',rate:0.01}],
	desc:'组选和值',maxcodecount:0
}]}]},		{isnew:"0",isdefault:"0",title:"二码", label:[{gtitle:'二星直选', label:[{methoddesc:'从十、个位各选一个号码组成一注。',
methodhelp:'从十位、个位中选择一个2位数号码组成一注，所选号码与开奖号码的十位、个位相同，且顺序一致，即为中奖。',
methodexample:'投注方案：58；开奖号码后二位：58，即中后二直选一等奖。',
selectarea:{
       type   : 'digital',
       layout : [
		   {title:'十位', no:'0|1|2|3|4|5|6|7|8|9', place:0, cols:1},
		   {title:'个位', no:'0|1|2|3|4|5|6|7|8|9', place:1, cols:1}
		  ],
       noBigIndex : 5,
       isButton   : true
      },
show_str : '-,-,-,X,X',
code_sp : '',
	methodid : 24,
	name:'后二直选(复式)',
	prize:{1:'180.00'},
        nfdprize:{levs:moneyMap['24'].split(",")[0],defaultprize:moneyMap['24'].split(",")[1],userdiffpoint:fandian},
	modes:[{modeid:1,name:'元',rate:1},{modeid:2,name:'角',rate:0.1},{modeid:3,name:'分',rate:0.01}],
	desc:'后二(复式)',maxcodecount:0
},{methoddesc:'手动输入号码，至少输入1个两位数号码。',
methodhelp:'手动输入一个2位数号码组成一注，所选号码的十位、个位与开奖号码相同，且顺序一致，即为中奖。',
methodexample:'投注方案：58；开奖号码后二位：58，即中后二直选一等奖。',
selectarea:{type:'input'},
show_str : 'X',
code_sp : ' ',
	methodid : 24,
	name:'后二直选(单式)',
	prize:{1:'180.00'},
        nfdprize:{levs:moneyMap['24'].split(",")[0],defaultprize:moneyMap['24'].split(",")[1],userdiffpoint:fandian},
	modes:[{modeid:1,name:'元',rate:1},{modeid:2,name:'角',rate:0.1},{modeid:3,name:'分',rate:0.01}],
	desc:'后二(单式)',maxcodecount:0
},{methoddesc:'从万、千位各选一个号码组成一注。',
methodhelp:'从万位、千位中选择一个2位数号码组成一注，所选号码与开奖号码的前2位相同，且顺序一致，即为中奖。',
methodexample:'投注方案：58；开奖号码前二位：58，即中前二直选一等奖。',
selectarea:{
       type   : 'digital',
       layout : [
		   {title:'万位', no:'0|1|2|3|4|5|6|7|8|9', place:0, cols:1},
		   {title:'千位', no:'0|1|2|3|4|5|6|7|8|9', place:1, cols:1}
		  ],
       noBigIndex : 5,
       isButton   : true
      },
show_str : 'X,X,-,-,-',
code_sp : '',
	methodid : 22,
	name:'前二直选(复式)',
	prize:{1:'180.00'},
        nfdprize:{levs:moneyMap['22'].split(",")[0],defaultprize:moneyMap['22'].split(",")[1],userdiffpoint:fandian},
	modes:[{modeid:1,name:'元',rate:1},{modeid:2,name:'角',rate:0.1},{modeid:3,name:'分',rate:0.01}],
	desc:'前二(复式)',maxcodecount:0
},{methoddesc:'手动输入号码，至少输入1个两位数号码。',
methodhelp:'手动输入一个2位数号码组成一注，所选号码的万位、千位与开奖号码相同，且顺序一致，即为中奖。',
methodexample:'投注方案：58；开奖号码前二位：58，即中前二直选一等奖。',
selectarea:{type:'input'},
show_str : 'X',
code_sp : ' ',
	methodid : 22,
	name:'前二直选(单式)',
	prize:{1:'180.00'},
        nfdprize:{levs:moneyMap['22'].split(",")[0],defaultprize:moneyMap['22'].split(",")[1],userdiffpoint:fandian},
	modes:[{modeid:1,name:'元',rate:1},{modeid:2,name:'角',rate:0.1},{modeid:3,name:'分',rate:0.01}],
	desc:'前二(单式)',maxcodecount:0
},{methoddesc:'从0-18中任意选择1个或1个以上的和值号码。',
methodhelp:'所选数值等于开奖号码的十位、个位二个数字相加之和，即为中奖。',
methodexample:'投注方案：和值1；开奖号码后二位：01,10，即中后二直选。',
selectarea:{
type : 'digital',
layout : [ {title:'', no:'0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18', place:0, cols:1}
],
noBigIndex : 5,
isButton : false
},
show_str : 'X',
code_sp : ',',
	methodid : 474,
	name:'后二直选和值',
	prize:{1:'180.00'},
        nfdprize:{levs:moneyMap['474'].split(",")[0],defaultprize:moneyMap['474'].split(",")[1],userdiffpoint:fandian},
	modes:[{modeid:1,name:'元',rate:1},{modeid:2,name:'角',rate:0.1},{modeid:3,name:'分',rate:0.01}],
	desc:'后二和值',maxcodecount:0
},{methoddesc:'从0-18中任意选择1个或1个以上的和值号码。',
methodhelp:'所选数值等于开奖号码的万位、千位二个数字相加之和，即为中奖。',
methodexample:'投注方案：和值1；开奖号码前二位：01,10，即中前二直选。',
selectarea:{
type : 'digital',
layout : [ {title:'', no:'0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18', place:0, cols:1}
],
noBigIndex : 5,
isButton : false
},
show_str : 'X',
code_sp : ',',
	methodid : 472,
	name:'前二直选和值',
	prize:{1:'180.00'},
        nfdprize:{levs:moneyMap['472'].split(",")[0],defaultprize:moneyMap['472'].split(",")[1],userdiffpoint:fandian},
	modes:[{modeid:1,name:'元',rate:1},{modeid:2,name:'角',rate:0.1},{modeid:3,name:'分',rate:0.01}],
	desc:'前二和值',maxcodecount:0
}]},{gtitle:'二星组选', label:[{methoddesc:'从0-9中任意选择2个或2个以上号码。',
methodhelp:'从0-9中选2个号码组成一注，所选号码与开奖号码的十位、个位相同，顺序不限，即中奖。',
methodexample:'投注方案：5,8；开奖号码后二位：1个5，1个8 (顺序不限)，即中后二组选一等奖。',
selectarea:{
       type   : 'digital',
       layout : [
		   {title:'组选', no:'0|1|2|3|4|5|6|7|8|9', place:0, cols:1}
		  ],
       noBigIndex : 5,
       isButton   : true
      },
show_str : 'X',
code_sp : ',',
	methodid : 28,
	name:'后二组选(复式)',
	prize:{1:'90.00'},
        nfdprize:{levs:moneyMap['28'].split(",")[0],defaultprize:moneyMap['28'].split(",")[1],userdiffpoint:fandian},
	modes:[{modeid:1,name:'元',rate:1},{modeid:2,name:'角',rate:0.1},{modeid:3,name:'分',rate:0.01}],
	desc:'后二(复式)',maxcodecount:0
},{methoddesc:'手动输入号码，至少输入1个两位数号码。',
methodhelp:'手动输入一个2位数号码组成一注，所选号码的十位、个位与开奖号码相同，顺序不限，即为中奖。',
methodexample:'投注方案：5,8；开奖号码后二位：1个5，1个8 (顺序不限)，即中后二组选一等奖。',
selectarea:{type:'input'},
show_str : 'X',
code_sp : ' ',
	methodid : 28,
	name:'后二组选(单式)',
	prize:{1:'90.00'},
        nfdprize:{levs:moneyMap['28'].split(",")[0],defaultprize:moneyMap['28'].split(",")[1],userdiffpoint:fandian},
	modes:[{modeid:1,name:'元',rate:1},{modeid:2,name:'角',rate:0.1},{modeid:3,name:'分',rate:0.01}],
	desc:'后二(单式)',maxcodecount:0
},{methoddesc:'从0-9中任意选择2个或2个以上号码。',
methodhelp:'从0-9中选2个号码组成一注，所选号码与开奖号码的万位、千位相同，顺序不限，即中奖。',
methodexample:'投注方案：5,8；开奖号码前二位：1个5，1个8 (顺序不限)，即中前二组选一等奖。',
selectarea:{
       type   : 'digital',
       layout : [
		   {title:'组选', no:'0|1|2|3|4|5|6|7|8|9', place:0, cols:1}
		  ],
       noBigIndex : 5,
       isButton   : true
      },
show_str : 'X',
code_sp : ',',
	methodid : 26,
	name:'前二组选(复式)',
	prize:{1:'90.00'},
        nfdprize:{levs:moneyMap['26'].split(",")[0],defaultprize:moneyMap['26'].split(",")[1],userdiffpoint:fandian},
	modes:[{modeid:1,name:'元',rate:1},{modeid:2,name:'角',rate:0.1},{modeid:3,name:'分',rate:0.01}],
	desc:'前二(复式)',maxcodecount:0
},{methoddesc:'手动输入号码，至少输入1个两位数号码。',
methodhelp:'手动输入一个2位数号码组成一注，所选号码的万位、千位与开奖号码相同，顺序不限，即为中奖。',
methodexample:'投注方案：5,8；开奖号码前二位：1个5，1个8 (顺序不限)，即中前二组选一等奖。',
selectarea:{type:'input'},
show_str : 'X',
code_sp : ' ',
	methodid : 26,
	name:'前二组选(单式)',
	prize:{1:'90.00'},
        nfdprize:{levs:moneyMap['26'].split(",")[0],defaultprize:moneyMap['26'].split(",")[1],userdiffpoint:fandian},
	modes:[{modeid:1,name:'元',rate:1},{modeid:2,name:'角',rate:0.1},{modeid:3,name:'分',rate:0.01}],
	desc:'前二(单式)',maxcodecount:0
},{methoddesc:'从1-17中任意选择1个或1个以上的和值号码。',
methodhelp:'所选数值等于开奖号码的十位、个位二个数字相加之和（不含对子号），即为中奖。',
methodexample:'投注方案：和值1；开奖号码后二位：10或01(顺序不限，不含对子号)，即中后二组选。',
selectarea:{
type : 'digital',
layout : [ {title:'', no:'1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17', place:0, cols:1}
],
noBigIndex : 5,
isButton : false
},
show_str : 'X',
code_sp : ',',
	methodid : 478,
	name:'后二组选和值',
	prize:{1:'90.00'},
        nfdprize:{levs:moneyMap['478'].split(",")[0],defaultprize:moneyMap['478'].split(",")[1],userdiffpoint:fandian},
	modes:[{modeid:1,name:'元',rate:1},{modeid:2,name:'角',rate:0.1},{modeid:3,name:'分',rate:0.01}],
	desc:'后二和值',maxcodecount:0
},{methoddesc:'从1-17中任意选择1个或1个以上号码',
methodhelp:'所选数值等于开奖号码的万位、千位二个数字相加之和（不含对子号），即为中奖。',
methodexample:'投注方案：和值1；开奖号码前二位：10或01 (顺序不限，不含对子号)，即中前二组选。',
selectarea:{
type : 'digital',
layout : [ {title:'', no:'1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17', place:0, cols:1}
],
noBigIndex : 5,
isButton : false
},
show_str : 'X',
code_sp : ',',
	methodid : 476,
	name:'前二组选和值',
	prize:{1:'90.00'},
        nfdprize:{levs:moneyMap['476'].split(",")[0],defaultprize:moneyMap['476'].split(",")[1],userdiffpoint:fandian},
	modes:[{modeid:1,name:'元',rate:1},{modeid:2,name:'角',rate:0.1},{modeid:3,name:'分',rate:0.01}],
	desc:'前二和值',maxcodecount:0
}]}]},		{isnew:"0",isdefault:"0",title:"定位胆", label:[{gtitle:'定位胆', label:[{methoddesc:'在万位，千位，百位，十位，个位任意位置上任意选择1个或1个以上号码。',
methodhelp:'从万位、千位、百位、十位、个位任意位置上至少选择1个以上号码，所选号码与相同位置上的开奖号码一致，即为中奖。',
methodexample:'投注方案：1；开奖号码万位：1，即中定位胆万位一等奖。',
selectarea:{
       type   : 'digital',
       layout : [
		   {title:'万位', no:'0|1|2|3|4|5|6|7|8|9', place:0, cols:1},
		   {title:'千位', no:'0|1|2|3|4|5|6|7|8|9', place:1, cols:1},
		   {title:'百位', no:'0|1|2|3|4|5|6|7|8|9', place:2, cols:1},
		   {title:'十位', no:'0|1|2|3|4|5|6|7|8|9', place:3, cols:1},
		   {title:'个位', no:'0|1|2|3|4|5|6|7|8|9', place:4, cols:1}
		  ],
       noBigIndex : 5,
       isButton   : true
      },
show_str : 'X,X,X,X,X',
code_sp : '',
	methodid : 30,
	name:'定位胆',
	prize:{1:'18.00'},
        nfdprize:{levs:moneyMap['30'].split(",")[0],defaultprize:moneyMap['30'].split(",")[1],userdiffpoint:fandian},
	modes:[{modeid:1,name:'元',rate:1},{modeid:2,name:'角',rate:0.1},{modeid:3,name:'分',rate:0.01}],
	desc:'定位胆',maxcodecount:0
}]}]},		{isnew:"0",isdefault:"0",title:"不定胆", label:[{gtitle:'三星不定胆', label:[{methoddesc:'从0-9中任意选择1个以上号码。',
methodhelp:'从0-9中选择1个号码，每注由1个号码组成，只要开奖号码的百位、十位、个位中包含所选号码，即为中奖。',
methodexample:'投注方案：1；开奖号码后三位：至少出现1个1，即中后三一码不定位一等奖。',
selectarea:{
       type   : 'digital',
       layout : [
		   {title:'不定胆', no:'0|1|2|3|4|5|6|7|8|9', place:0, cols:1}
		  ],
       noBigIndex : 5,
       isButton   : true
      },
show_str : 'X',
code_sp : ',',
	methodid : 18,
	name:'后三一码不定胆',
	prize:{1:'6.60'},
        nfdprize:{levs:moneyMap['18'].split(",")[0],defaultprize:moneyMap['18'].split(",")[1],userdiffpoint:fandianbdw},
	modes:[{modeid:1,name:'元',rate:1},{modeid:2,name:'角',rate:0.1},{modeid:3,name:'分',rate:0.01}],
	desc:'后三一码不定胆',maxcodecount:0
},{methoddesc:'从0-9中任意选择2个以上号码。',
methodhelp:'从0-9中选择2个号码，每注由2个不同的号码组成，开奖号码的百位、十位、个位中同时包含所选的2个号码，即为中奖。',
methodexample:'投注方案：1,2；开奖号码后三位：至少出现1和2各1个，即中后三一码不定位一等奖。',
selectarea:{
       type   : 'digital',
       layout : [
		   {title:'不定胆', no:'0|1|2|3|4|5|6|7|8|9', place:0, cols:1}
		  ],
       noBigIndex : 5,
       isButton   : true
      },
show_str : 'X',
code_sp : ',',
	methodid : 20,
	name:'后三二码不定胆',
	prize:{1:'33.00'},
        nfdprize:{levs:moneyMap['20'].split(",")[0],defaultprize:moneyMap['20'].split(",")[1],userdiffpoint:fandianbdw},
	modes:[{modeid:1,name:'元',rate:1},{modeid:2,name:'角',rate:0.1},{modeid:3,name:'分',rate:0.01}],
	desc:'后三二码不定胆',maxcodecount:0
},{methoddesc:'从0-9中任意选择1个以上号码。',
methodhelp:'从0-9中选择1个号码，每注由1个号码组成，只要开奖号码的万位、千位、百位中包含所选号码，即为中奖。',
methodexample:'投注方案：1；开奖号码前三位：至少出现1个1，即中前三一码不定位一等奖。',
selectarea:{
       type   : 'digital',
       layout : [
		   {title:'不定胆', no:'0|1|2|3|4|5|6|7|8|9', place:0, cols:1}
		  ],
       noBigIndex : 5,
       isButton   : true
      },
show_str : 'X',
code_sp : ',',
	methodid : 512,
	name:'前三一码不定胆',
	prize:{1:'6.60'},
        nfdprize:{levs:moneyMap['512'].split(",")[0],defaultprize:moneyMap['512'].split(",")[1],userdiffpoint:fandianbdw},
	modes:[{modeid:1,name:'元',rate:1},{modeid:2,name:'角',rate:0.1},{modeid:3,name:'分',rate:0.01}],
	desc:'前三一码不定胆',maxcodecount:0
},{methoddesc:'从0-9中任意选择2个以上号码。',
methodhelp:'从0-9中选择2个号码，每注由2个不同的号码组成，开奖号码的万位、千位、百位中同时包含所选的2个号码，即为中奖。',
methodexample:'投注方案：1,2；开奖号码前三位：至少出现1和2各1个，即中前三一码不定位一等奖。',
selectarea:{
       type   : 'digital',
       layout : [
		   {title:'不定胆', no:'0|1|2|3|4|5|6|7|8|9', place:0, cols:1}
		  ],
       noBigIndex : 5,
       isButton   : true
      },
show_str : 'X',
code_sp : ',',
	methodid : 513,
	name:'前三二码不定胆',
	prize:{1:'33.00'},
        nfdprize:{levs:moneyMap['513'].split(",")[0],defaultprize:moneyMap['513'].split(",")[1],userdiffpoint:fandianbdw},
	modes:[{modeid:1,name:'元',rate:1},{modeid:2,name:'角',rate:0.1},{modeid:3,name:'分',rate:0.01}],
	desc:'前三二码不定胆',maxcodecount:0
}]}]},		{isnew:"0",isdefault:"0",title:"大小单双", label:[{gtitle:'大小单双', label:[{methoddesc:'从十位、个位中的“大、小、单、双”中至少各选一个组成一注。',
methodhelp:'对十位和个位的“大（56789）小（01234）、单（13579）双（02468）”形态进行购买，所选号码的位置、形态与开奖号码的位置、形态相同，即为中奖。',
methodexample:'投注方案：大单；开奖号码十位与个位：大单，即中后二大小单双一等奖。',
selectarea:{
	type:'dxds',
	layout: [{title:'十位', no:'大|小|单|双', place:0, cols:1},
		 {title:'个位', no:'大|小|单|双', place:1, cols:1}]
      },
show_str : 'X,X',
code_sp : '',
	methodid : 38,
	name:'后二',
	prize:{1:'7.20'},
        nfdprize:{levs:moneyMap['38'].split(",")[0],defaultprize:moneyMap['38'].split(",")[1],userdiffpoint:fandian},
	modes:[{modeid:1,name:'元',rate:1},{modeid:2,name:'角',rate:0.1},{modeid:3,name:'分',rate:0.01}],
	desc:'后二大小单双',maxcodecount:0
},{methoddesc:'从万位、千位中的“大、小、单、双”中至少各选一个组成一注。',
methodhelp:'对百位、十位和个位的“大（56789）小（01234）、单（13579）双（02468）”形态进行购买，所选号码的位置、形态与开奖号码的位置、形态相同，即为中奖。',
methodexample:'投注方案：小双；开奖号码万位与千位：小双，即中前二大小单双一等奖。',
selectarea:{
	type:'dxds',
	layout: [{title:'万位', no:'大|小|单|双', place:0, cols:1},
		 {title:'千位', no:'大|小|单|双', place:1, cols:1}]
      },
show_str : 'X,X',
code_sp : '',
	methodid : 36,
	name:'前二',
	prize:{1:'7.20'},
        nfdprize:{levs:moneyMap['36'].split(",")[0],defaultprize:moneyMap['36'].split(",")[1],userdiffpoint:fandian},
	modes:[{modeid:1,name:'元',rate:1},{modeid:2,name:'角',rate:0.1},{modeid:3,name:'分',rate:0.01}],
	desc:'前二大小单双',maxcodecount:0
}]}]},		{isnew:"0",isdefault:"0",title:"趣味", label:[{gtitle:'特殊', label:[{methoddesc:'从0-9中任意选择1个以上号码。',
methodhelp:'从0-9中任意选择1个号码组成一注，只要开奖号码的万位、千位、百位、十位、个位中包含所选号码，即为中奖。',
methodexample:'投注方案：8；开奖号码：至少出现1个8，即中一帆风顺。',
selectarea:{
       type   : 'digital',
       layout : [
		   {title:'', no:'0|1|2|3|4|5|6|7|8|9', place:0, cols:1}
		  ],
       noBigIndex : 5,
       isButton   : true
      },
show_str : 'X',
code_sp : ',',
	methodid : 2285,
	name:'一帆风顺',
	prize:{1:'4.30'},
        nfdprize:{levs:moneyMap['2285'].split(",")[0],defaultprize:moneyMap['2285'].split(",")[1],userdiffpoint:fandian},
	modes:[{modeid:1,name:'元',rate:1},{modeid:2,name:'角',rate:0.1},{modeid:3,name:'分',rate:0.01}],
	desc:'一帆风顺',maxcodecount:0
},{methoddesc:'从0-9中任意选择1个以上的二重号码。',
methodhelp:'从0-9中任意选择1个号码组成一注，只要所选号码在开奖号码的万位、千位、百位、十位、个位中出现2次，即为中奖。',
methodexample:'投注方案：8；开奖号码：至少出现2个8，即中好事成双。',
selectarea:{
       type   : 'digital',
       layout : [
		   {title:'', no:'0|1|2|3|4|5|6|7|8|9', place:0, cols:1}
		  ],
       noBigIndex : 5,
       isButton   : true
      },
show_str : 'X',
code_sp : ',',
	methodid : 2286,
	name:'好事成双',
	prize:{2:'22.00'},
        nfdprize:{levs:moneyMap['2286'].split(",")[0],defaultprize:moneyMap['2286'].split(",")[1],userdiffpoint:fandian},
	modes:[{modeid:1,name:'元',rate:1},{modeid:2,name:'角',rate:0.1},{modeid:3,name:'分',rate:0.01}],
	desc:'好事成双',maxcodecount:0
},{methoddesc:'从0-9中任意选择1个以上的三重号码。',
methodhelp:'从0-9中任意选择1个号码组成一注，只要所选号码在开奖号码的万位、千位、百位、十位、个位中出现3次，即为中奖。',
methodexample:'投注方案：8；开奖号码：至少出现3个8，即中三星报喜。',
selectarea:{
       type   : 'digital',
       layout : [
		   {title:'', no:'0|1|2|3|4|5|6|7|8|9', place:0, cols:1}
		  ],
       noBigIndex : 5,
       isButton   : true
      },
show_str : 'X',
code_sp : ',',
	methodid : 2287,
	name:'三星报喜',
	prize:{3:'210.00'},
        nfdprize:{levs:moneyMap['2287'].split(",")[0],defaultprize:moneyMap['2287'].split(",")[1],userdiffpoint:fandian},
	modes:[{modeid:1,name:'元',rate:1},{modeid:2,name:'角',rate:0.1},{modeid:3,name:'分',rate:0.01}],
	desc:'三星报喜',maxcodecount:0
},{methoddesc:'从0-9中任意选择1个以上的四重号码。',
methodhelp:'从0-9中任意选择1个号码组成一注，只要所选号码在开奖号码的万位、千位、百位、十位、个位中出现4次，即为中奖。',
methodexample:'投注方案：8；开奖号码：至少出现4个8，即中四季发财。',
selectarea:{
       type   : 'digital',
       layout : [
		   {title:'', no:'0|1|2|3|4|5|6|7|8|9', place:0, cols:1}
		  ],
       noBigIndex : 5,
       isButton   : true
      },
show_str : 'X',
code_sp : ',',
	methodid : 2288,
	name:'四季发财',
	prize:{4:'3900.00'},
        nfdprize:{levs:moneyMap['2288'].split(",")[0],defaultprize:moneyMap['2288'].split(",")[1],userdiffpoint:fandian},
	modes:[{modeid:1,name:'元',rate:1},{modeid:2,name:'角',rate:0.1},{modeid:3,name:'分',rate:0.01}],
	desc:'四季发财',maxcodecount:0
}]}]}		],
//	cur_issue : {issue:'20140401-067',endtime:'2014-04-01 17:09:05'},	
	cur_issue : eval('(' + var_cur_issue + ')'),
	issues    : {//所有的可追号期数集合
	today: Iss_today,
	tomorrow: Iss_tomorrow
	},
	servertime: var_servertime,
	lotteryid : parseInt(1,10),
	//ajaxurl   : './?controller=game&action=play',
	ajaxurl   : 'getLeaveTime',
	ontimeout : function(){
		$.ajax({
		type: 'POST',
		url : '../test/getData',
		data: "empty=empty",
		//data: "lotteryid=1&flag=gethistory",
		success: function(data){
		
		var partn = /<script.*>.*<\/script>/;
		if( data == 'empty' && partn.test(data) ){
		return;
		}
		eval("data="+data);
		processCode(data[0].issue,data[0].code);
		}
		});
	},
	onfinishbuy : function(){
	$.ajax({
	type: 'POST',
	url : './?controller=game&action=play&curmid=50',
	data: "lotteryid=1&flag=getprojects",
	success: function(data){
	var partn = /<script.*>.*<\/script>/;
	if( data == 'empty' && partn.test(data) ){
	return;
	}
	eval("data="+data);
	$(".history_pro","#history_project").remove();
	var html = '';
	var selectedcss = '';
	$.each(data,function(i,n){
	html += '<tr class="history_pro">';
	if( i%2 == 0 ){
	selectedcss = ' class="odd" bgcolor="#CCCCCC" align="center"';
	}else{
	selectedcss = ' bgcolor="#CCCCCC" align="center"';
	}
	html += '<td'+selectedcss+' height="30"><a href="./index.php?controller=gameinfo&action=gamedetail&id='+n.projectid+'" target="_blank" title="查看注单详情" class="projectidarea">'+n.projectid+'</a></td>';
	html += '<td'+selectedcss+'>'+n.writetime+'</td>';
	html += '<td'+selectedcss+'>'+n.methodname+'</td>';
	html += '<td'+selectedcss+'>'+n.issue+'</td>';
	html += '<td'+selectedcss+'>'+n.modes+'</td>';
	if( n.code.length>20 ){
	html += '<td'+selectedcss+'><span class="project_more">号码详情</span><div style="display:none;">'+n.code+'</div></td>';
	}else{
	html += '<td'+selectedcss+'>'+n.code+'</td>';
	}
	html += '<td'+selectedcss+'>'+n.multiple+'</td>';
	html += '<td'+selectedcss+'>'+moneyFormat(n.totalprice)+'</td>';
	html += '<td'+selectedcss+'>'+(parseInt(n.taskid,10)>0 ? "是" : "否")+'</td>';
	html += '</tr>';
	});
	$(html).insertAfter("#project_title");
	}
	});
	}
	});
	if('23258' != ''){
	processCode('20140401-066','23258');
	}
	$('span[class="project_more"]',"#history_project").live("click",function(){
	var mme = this;
	var $h = $('<span style="display: block;" id="task_div">号码详情[<span class="close">关闭</span>]<br><textarea readonly="readonly" class="code1">'+$(mme).next().html()+'</textarea></span>');
	$(this).openFloat($h,"projects_more");
	$("span",$(this).parent()).filter(".close").click(function(){
	$(mme).closeFloat();
	});
	});    
	var iLid = parseInt(1,10);
	var position = -(iLid-1)*75;
	$("#right_top_01_02").css("background-position","0px "+position+"px");
	//$.alert("hha");
	function a(){
		var currentissue = $('.no_old').html();

	// a() 方法请求后台，获取开奖数据
	$.ajax({
		type: 'POST',
		//url : './?controller=game&action=play&curmid=50',
		url : '../test/getData',
		data: "lotteryid=1&flag=gethistory&currentissue="+currentissue,
		success: function(data){
			if( data == 'empty' ){
				return;
			}
			eval("data="+data);
		//	alert(data[0].iscurent)
			processCode(data[0].issue,data[0].code,data.iscurent);
		}
	});
		setTimeout(a,30000);
	}a();
});
})(jQuery);
var lotterytype=0;
function processCode(issue,code,iscurent){
	$('.no_old').html(issue);
	if( issue.length>=12 ){
	    $('.no_old').css("left","-6px");
	    $('.no_old').css("right","0px");
	}
	if( issue.length == 11 ){
	    $('.no_old').css("left","-4px");
	    $('.no_old').css("right","0px");
	}
	if( issue.length ==7 ){
	    $('.no_old').css("left","15px");
	}
	if( issue.length ==8 ){
	    $('.no_old').css("left","12px");
	}
	var cStr = '';
	var aTmp = new Array();
	//处理中奖号码
	if(code.indexOf(' ') == -1){
		//无空格
		aTmp = code.split('');
	}else{
		//有空格
		aTmp = code.split(' ');
	}
	if(iscurent == 2){//增加动态抓取sean
		var latestlot = "<li class=\"qihao1\">"+issue+"<\/li><li class=\"haoma1\">";
		var sCode= "";
		for(var ci=0;ci<aTmp.length;ci++){
			 sCode += "<span>"+aTmp[ci]+"<\/span>";
		}
		var sInsertHtml = latestlot+sCode+"</li>";
		$(".biaotou").eq(1).after(sInsertHtml);
		$("li[class=qihao1]:last").remove();
		$("li[class=haoma1]:last").remove();
	}
	var num_single=0,num_double=0;
	var num_codesort=aTmp;//排序
	for(var ci=0;ci<aTmp.length;ci++){
		var curNum=aTmp[ci];
		//curNum=parseInt(curNum,10);
		$('#last_code_num'+ci).html(curNum);
		
		var code_word='';
		if(curNum>=5){
			code_word += '大';
		}else{
			code_word += '小';
		}
		if(curNum%2 == 0){
			code_word += '双';num_double++;
		}else{
			code_word += '单';num_single++;
		}
		//$('#last_code_word'+ci).html(code_word);
	}
	if(lotterytype==0){
		var last_code_desc1="组三";
		if(aTmp[0]==aTmp[1]&&aTmp[0]==aTmp[2]){
			last_code_desc1="豹子";
		}else if(aTmp[0]!=aTmp[1]&&aTmp[0]!=aTmp[2]&&aTmp[1]!=aTmp[2]){
			last_code_desc1="组六";
		}
		$("#last_code_desc1").html(last_code_desc1);
		var last_code_desc2="组三";
		if(aTmp[2]==aTmp[3]&&aTmp[2]==aTmp[4]){
			last_code_desc2="豹子";
		}else if(aTmp[2]!=aTmp[3]&&aTmp[2]!=aTmp[4]&&aTmp[3]!=aTmp[4]){
			last_code_desc2="组六";
		}
		$("#last_code_desc2").html(last_code_desc2);
	}else if(lotterytype==2){
		num_codesort=num_codesort.sort();
		var last_code_desc1=num_single+"单"+num_double+"双";
		$("#last_code_desc1").html(last_code_desc1);
		var last_code_desc2=num_codesort[2];
		$("#last_code_desc2").html(last_code_desc2);
	}else if(lotterytype==3){
		//cStr += '<div class="bonusnumber"><div>';
		var total = ups = downs = odds = evens = 0;
		for(var ci=0;ci<aTmp.length;ci++){
			total += intval(aTmp[ci]);
			if( intval(aTmp[ci]) < 41 )	{
				ups += 1;
			}else{
				downs += 1;
			}
			if( intval(aTmp[ci]) % 2 == 0 ){
				evens += 1;
			}else{
				odds += 1;
			}
			//cStr += '<span class="ball">'+aTmp[ci]+'</span>';
		}
		var cheziStr = '和值：'+total+'(';
		if(total > 810){
			cheziStr += '大';
		}else if(total < 810){
			cheziStr += '小';
		}else{
			cheziStr += '和';
		}
		cheziStr += ','+(total%2==0 ? '双' : '单')+')';
		var cpanStr = '盘面：(';
		if( ups > downs ){
			cpanStr += '上';
		}else if( ups == downs ){
			cpanStr += '中';
		}else{
			cpanStr += '下';
		}
		cpanStr += ',';
		if( odds > evens ){
			cpanStr += '奇';
		}else if( odds == evens ){
			cpanStr += '和';
		}else{
			cpanStr += '偶';
		}
		cpanStr += ')';
		$('#last_code_desc1').html(cheziStr);
		$('#last_code_desc2').html(cpanStr);
	}
}
//清空追号方案
var cleanTraceIssue =function(){
	$("input[name^='lt_trace_issues']",$($.lt_id_data.id_tra_issues)).attr("checked",false);
	$("input[name^='lt_trace_times_']",$($.lt_id_data.id_tra_issues)).val(0).attr("disabled",true);
	$("span[id^='lt_trace_money_']",$($.lt_id_data.id_tra_issues)).html('0.00');                
	$("td",$($.lt_id_data.id_tra_issues)).removeClass("selected");
	$('#lt_trace_hmoney').html(0);
	$('#lt_trace_money').val(0);
	$('#lt_trace_count').html(0);
	$.lt_trace_issue = 0;
	$.lt_trace_money = 0;
};
function div_slow_show(showslow_id){
	$("#div_slow_id_"+showslow_id).show("slow");
}
function div_slow_hide(showslow_id){
	$("#div_slow_id_"+showslow_id).hide("slow");
}
var setCookie=function(name,value,expire,path){
	//expire=expire||30*24*60*60*1000;
	var curdate=new Date();
	var cookie=name+"="+encodeURIComponent(value)+"; ";
	if(expire!=undefined||expire==0){
		if(expire==-1){
			expire=366*86400*1000;//保存一年
		}else{
			expire=parseInt(expire);
		}
		curdate.setTime(curdate.getTime()+expire);
		cookie+="expires="+curdate.toUTCString()+"; ";
	}
	path=path||"/";
	cookie+="path="+path;
	//document.cookie=cookie;
};
var getCookie=function(name) {
	var re = "(?:; )?" + encodeURIComponent(name) + "=([^;]*);?";
	re = new RegExp(re);
	if (re.test(document.cookie)) {
		return decodeURIComponent(RegExp.$1);
	}
	return '';
};
setCookie('last_lottery_url',top.location.href);
$(function(){
	var _wrap=$('#zjtgul');
	var _interval=2000;
	var _moving;
	_wrap.hover(function(){
		clearInterval(_moving);
	},function(){
		_moving=setInterval(function(){
			var _field=_wrap.find('li:first');
			var _h=_field.height();
			_field.animate({marginTop:-_h+'px'},600,function(){
				_field.css('marginTop',0).appendTo(_wrap);
			});
		},_interval);
	}).trigger('mouseleave');
});

</script>

<div class="lottery_frame">
	<div class="lottery_area">
    	<div class="lottery_table">
          <div class="lottery_num">
          		<div class="lo_title">
                	<ul>
                    	<li>
                                            
                           								重庆时时彩
                            							   
                        	
   				 </li>
                    	<li class="lo_date">第 <span style="left: -6px; right: 0px;" class="no_old yellow">20140401-066</span> 期开奖结果</li>
                    	<li><a href="http://www.luckyssc.net/?controller=game&amp;action=bonuscode&amp;lotteryid=1&amp;issuecount=30" target="_blank">漏号分析</a></li>
                    </ul>                
                </div>
          		<div class="num_open">
                    <ul>
                        <li><span class="each"><span id="last_code_num0">2</span></span></li>
                        <li><span class="each"><span id="last_code_num1">3</span></span></li>
                        <li><span class="each"><span id="last_code_num2">2</span></span></li>
                        <li><span class="each"><span id="last_code_num3">5</span></span></li>
                        <li><span class="each"><span id="last_code_num4">8</span></span></li>  
                    </ul>
                </div>
          </div>
        	
           <div class="lottery_next">
           		<ul>
                	<li class="lo_txt bold"><label>当前销售</label> 第 <span class="yellow" id="current_issue"></span> 期</li>
                	<li class="lo_txt bold"><label>截止时间</label><span id="current_endtime"></span></li>
                    <li class="countdown"><label>倒计时</label> <span id="count_down"><div class="hour"></div><div class="min"></div><div class="sec"></div></span></li>
                </ul>           
           </div>
        
        </div>    
    </div>
    </div>
<script language="javascript" src="../index_files/a_data/jquery_002.js"></script>
<script language="javascript" src="../index_files/a_data/jquery_003.js"></script>
<script language="javascript" src="../index_files/a_data/jquery_006.js"></script>
<div id="subContent_bet">
<!--投注页面头部可视代码开始-->
<div class="bg clearfix">
<!--投注页面头部可视代码结束-->

<div class="box">
  <div class="Menubox title clearfix">
    <ul id="lotteryType">
    	<!-- <li class="hover" value="0" id="two1"><span class="m">五星</span></li>
    	<li value="1" id="two2"><span class="m">四星</span></li>
    	<li value="2" id="two3" class=""><span class="m">后三码</span></li>
    	<li value="3" id="two4"><span class="m">前三码</span></li>
    	<li value="4" id="two5"><span class="m">中三码</span></li>
    	<li value="5" id="two6"><span class="m">二码</span></li>
    	<li value="6" id="two7"><span class="m">定位胆</span></li>
    	<li value="7" id="two8"><span class="m">不定胆</span></li>
    	<li value="8" id="two9"><span class="m">大小单双</span></li>
    	<li value="9" id="two10"><span class="m">趣味</span></li> -->
   	</ul>

  </div>
  <div class="Contentbox" id="lotteryDetail">
    <div id="wrapshow" style="float: right; font-size: 14px; margin: 10px 5px 5px 0px; display: block;">
		<span id="nfdprize">
			<select name="pmode" id="pmode" style="height:20px; line-height:20px; font-size:12px; border: 1px double #57114f;color:#760795;">
				<option value="1">奖金180000-6%</option>
				<option value="2" selected="selected">奖金192000-0%</option>
			</select>
		</span>
	</div>
    <div class="minitype" id="lt_samll_label"><div><div><span class="methodgroupname"><font color="e9bc4b">五星直选</font></span>：<label for="smalllabel_0_0"><input id="smalllabel_0_0" name="smalllabel" value="0-0" checked="checked" type="radio">复式</label>&nbsp;<label for="smalllabel_0_1"><input id="smalllabel_0_1" name="smalllabel" value="0-1" type="radio">单式</label>&nbsp;<label for="smalllabel_0_2"><input id="smalllabel_0_2" name="smalllabel" value="0-2" type="radio">组合</label>&nbsp;&nbsp;&nbsp;&nbsp;<div><span class="methodgroupname"><font color="e9bc4b">五星组选</font></span>：<label for="smalllabel_1_0"><input id="smalllabel_1_0" name="smalllabel" value="1-0" type="radio">组选120</label>&nbsp;<label for="smalllabel_1_1"><input id="smalllabel_1_1" name="smalllabel" value="1-1" type="radio">组选60 </label>&nbsp;<label for="smalllabel_1_2"><input id="smalllabel_1_2" name="smalllabel" value="1-2" type="radio">组选30</label>&nbsp;<label for="smalllabel_1_3"><input id="smalllabel_1_3" name="smalllabel" value="1-3" type="radio">组选20</label>&nbsp;<label for="smalllabel_1_4"><input id="smalllabel_1_4" name="smalllabel" value="1-4" type="radio">组选10</label>&nbsp;<label for="smalllabel_1_5"><input id="smalllabel_1_5" name="smalllabel" value="1-5" type="radio">组选5</label>&nbsp;&nbsp;&nbsp;&nbsp;</div><input type="hidden"></div></div></div>
    <div class="minitype" style="margin-top: -10px;">
        <span style="color:#ff4364; font-weight:bold;">玩法说明：</span><span id="lt_desc" class="help_con">从个、十、百、千、万位各选一个号码组成一注。</span>&nbsp;<span id="lt_example" class="help_exp">【!】示例</span><div id="lt_example_div" style="display:none;">投注方案：23456；<br>开奖号码：23456，<br>即中五星直选</div>&nbsp;&nbsp;<span id="lt_help" class="help_help">【?】帮助</span><div id="lt_help_div" style="display:none;">从万位、千位、百位、十位、个位中选择一个5位数号码组成一注，所选号码与开奖号码全部相同，且顺序一致，即为中奖。</div>
    </div>      
    <!--<div id="right_03" class="grayTop">
		<div class="right_02_05"></div>
		<div class="right_02_06"></div>
		</div>-->
    <!--选号区 -->
    <div id="lt_selector"><div class="grayContent" id="right_05"><div class="each clearfix"><h3 class="name">万位</h3><ul class="numList floatL"><li name="lt_place_0" class="button1">0</li><li name="lt_place_0" class="button1">1</li><li name="lt_place_0" class="button1">2</li><li name="lt_place_0" class="button1">3</li><li name="lt_place_0" class="button1">4</li><li name="lt_place_0" class="button1">5</li><li name="lt_place_0" class="button1">6</li><li name="lt_place_0" class="button1">7</li><li name="lt_place_0" class="button1">8</li><li name="lt_place_0" class="button1">9</li></ul><ul class="btnList"><li name="all" class="selectType">全</li><li class="selectType" name="big">大</li><li class="selectType" name="small">小</li><li class="selectType" name="odd">奇</li><li class="selectType" name="even">偶</li><li class="selectType" name="clean"><font color="6d6d6d">清</font></li></ul></div><div class="each clearfix"><h3 class="name">千位</h3><ul class="numList floatL"><li name="lt_place_1" class="button1">0</li><li name="lt_place_1" class="button1">1</li><li name="lt_place_1" class="button1">2</li><li name="lt_place_1" class="button1">3</li><li name="lt_place_1" class="button1">4</li><li name="lt_place_1" class="button1">5</li><li name="lt_place_1" class="button1">6</li><li name="lt_place_1" class="button1">7</li><li name="lt_place_1" class="button1">8</li><li name="lt_place_1" class="button1">9</li></ul><ul class="btnList"><li name="all" class="selectType">全</li><li class="selectType" name="big">大</li><li class="selectType" name="small">小</li><li class="selectType" name="odd">奇</li><li class="selectType" name="even">偶</li><li class="selectType" name="clean"><font color="6d6d6d">清</font></li></ul></div><div class="each clearfix"><h3 class="name">百位</h3><ul class="numList floatL"><li name="lt_place_2" class="button1">0</li><li name="lt_place_2" class="button1">1</li><li name="lt_place_2" class="button1">2</li><li name="lt_place_2" class="button1">3</li><li name="lt_place_2" class="button1">4</li><li name="lt_place_2" class="button1">5</li><li name="lt_place_2" class="button1">6</li><li name="lt_place_2" class="button1">7</li><li name="lt_place_2" class="button1">8</li><li name="lt_place_2" class="button1">9</li></ul><ul class="btnList"><li name="all" class="selectType">全</li><li class="selectType" name="big">大</li><li class="selectType" name="small">小</li><li class="selectType" name="odd">奇</li><li class="selectType" name="even">偶</li><li class="selectType" name="clean"><font color="6d6d6d">清</font></li></ul></div><div class="each clearfix"><h3 class="name">十位</h3><ul class="numList floatL"><li name="lt_place_3" class="button1">0</li><li name="lt_place_3" class="button1">1</li><li name="lt_place_3" class="button1">2</li><li name="lt_place_3" class="button1">3</li><li name="lt_place_3" class="button1">4</li><li name="lt_place_3" class="button1">5</li><li name="lt_place_3" class="button1">6</li><li name="lt_place_3" class="button1">7</li><li name="lt_place_3" class="button1">8</li><li name="lt_place_3" class="button1">9</li></ul><ul class="btnList"><li name="all" class="selectType">全</li><li class="selectType" name="big">大</li><li class="selectType" name="small">小</li><li class="selectType" name="odd">奇</li><li class="selectType" name="even">偶</li><li class="selectType" name="clean"><font color="6d6d6d">清</font></li></ul></div><div class="each clearfix"><h3 class="name">个位</h3><ul class="numList floatL"><li name="lt_place_4" class="button1">0</li><li name="lt_place_4" class="button1">1</li><li name="lt_place_4" class="button1">2</li><li name="lt_place_4" class="button1">3</li><li name="lt_place_4" class="button1">4</li><li name="lt_place_4" class="button1">5</li><li name="lt_place_4" class="button1">6</li><li name="lt_place_4" class="button1">7</li><li name="lt_place_4" class="button1">8</li><li name="lt_place_4" class="button1">9</li></ul><ul class="btnList"><li name="all" class="selectType">全</li><li class="selectType" name="big">大</li><li class="selectType" name="small">小</li><li class="selectType" name="odd">奇</li><li class="selectType" name="even">偶</li><li class="selectType" name="clean"><font color="6d6d6d">清</font></li></ul></div></div></div>
    <!--选号区结束 -->
    <div style="display: block;" id="right_04" class="grayBottom">
      <div class="right_02_07"></div>
      <div class="right_02_08"></div>
    </div>
    <form method="post" name="buyform" action="">
      <input name="lotteryid" id="lotteryid" value="1" type="hidden">
      <input name="curmid" id="curmid" value="50" type="hidden">
      <input name="flag" id="flag" value="save" type="hidden">
      <div class="clearfix grayBet" style="clear:both;">
        <div class="floatL">您选择了 <span class="red1" id="lt_sel_nums">0</span> 注，共 <span class="yellow" id="lt_sel_money">0</span> 元，请输入倍数：
          <input id="lt_sel_times" class="num_input" value="1" border="0" type="text">
          倍
          <label>
          <input name="lt_project_modes" value="1" checked="checked" type="radio">
          元模式</label>
          <label>
          <input name="lt_project_modes" value="2" type="radio">
          角模式</label>
          <label>
          <input name="lt_project_modes" value="3" type="radio">
          分模式</label>
        </div>
        <span class="floatR">
        <input id="lt_sel_insert" value="选好了" class="formOk" type="button">
        </span> </div>
      <div class="lottery_list">
        <div class="whiteDetail">
          <table id="lt_cf_content" cellpadding="0" cellspacing="1">
          </table>
        </div>
      </div>
      <div class="tjBox clearfix">
        <div>
          <div class="floatL">
          	<span class="choose">已选择[ <span id="lt_cf_count" style="color:#FFFFFF">0</span> ]单</span> 总注数 <span class="red1" id="lt_cf_nums">0</span> 注，总金额 <span class="yellow2" id="lt_cf_money">0</span> 元 
	          	<span style="display:none;">， 起始期：
	          		<span id="lt_issues">
		          	</span>
	          	</span> &nbsp;&nbsp;&nbsp;&nbsp;

	            <label>     
	            <input name="lt_trace_if" id="lt_trace_if_button" value="no" type="checkbox">
	            <span class="red">发起追号</span></label>
	            <label>
	            <input name="lt_trace_stop" value="yes" id="lt_trace_stop" disabled="disabled" type="checkbox">
	            <span class="red">中奖后停止追号</span></label>
  
            
          </div>
          <span class="floatR"><a href="#_" class="tjBt" onclick="return(false);" id="lt_sendok">提交</a></span> </div>
      </div>
      <!--我要追号-->
      <div id="lt_trace_box1" class="wyzhContent" style="display:none;">
          <div id="lt_trace_label" style="height:40px;background-color:#202020;padding-left:5px;">
          </div>
        <div class="head clearfix">
          <div class="headContent">
            <p>追号期数：
              <select class="select3" id="lt_trace_qissueno">
                <option selected="selected" value="">请选择</option>
                <option value="5">5期</option>
                <option value="10">10期</option>
                <option value="15">15期</option>
                <option value="20">20期</option>
                <option value="25">25期</option>
                <option value="all">全部</option>
              </select>
              总期数： <span class="red" id="lt_trace_count">0</span> 期 	追号总金额： <span class="red" id="lt_trace_hmoney">0.00</span> 元
            </p><p>
              <!--<p>追号计划： 起始倍数 <input name="" type="text" value="1" size="3" /> 最低收益率  <input name="" type="text" value="50" size="3" />% 追号期数: <input name="" type="text" value="10" size="3" /></p>-->
              <span id="lt_trace_labelhtml">
              	<span id="lt_margin_html">起始倍数&nbsp;<input size="3" class="input02" name="lt_trace_times_margin" id="lt_trace_times_margin" value="1" type="text">&nbsp;最低收益率&nbsp;<input size="3" class="input02" name="lt_trace_margin" id="lt_trace_margin" value="50" type="text">&nbsp;%&nbsp;</span><span id="lt_sametime_html" style="display:none;">起始倍数&nbsp;<input size="3" name="lt_trace_times_same" class="input022" id="lt_trace_times_same" value="1" type="text"></span><span id="lt_difftime_html" style="display:none;">隔&nbsp;<input size="3" name="lt_trace_diff" value="1" class="input02" id="lt_trace_diff" type="text">&nbsp;期　倍× <input size="3" name="lt_trace_times_diff" id="lt_trace_times_diff" value="2" class="input02" type="text"></span>追号期数:&nbsp;<input size="3" name="lt_trace_count_input" id="lt_trace_count_input" style="width:24px" value="10" type="text"><input size="3" id="lt_trace_money" name="lt_trace_money" value="0" type="hidden">
              </span>
              <span class="red" id="lt_trace_alcount" style="display:none;">120</span>
              <input name="" value="生成" class="formSC" id="lt_trace_ok" type="button">
          </p></div>
        </div>
        <div class="zhlist" id="lt_trace_issues"></div>
      </div>
    </form>
  </div>
</div>
</div></div>
    <!-- bet -->
    
     
 <div id="footer">
    	<p>桌面最佳分辨率为(1366×768)，浏览器请使用IE9.0以上或务必使用谷歌Chrome或者火狐Firefox以达到最佳游戏效果</p>
        <p>Copyright©2012-2014 SinCai 版权所有 好彩娱乐 <a href="http://www.baidu.com">关于我们</a></p>
        <!-- <div id="quickLink"> <a target=_blank href="#" onclick="" class="online">在线客服</a> | <a href="">常见问题</a> | <a href="">玩法介绍</a></div>
       <!-- <div id="quickLinkDark">在线客服 | 常见问题 | 玩法介绍</div>-->
 </div>



<script>
   /* 
    $(document).ready(function(){
        if(!getC('popupad'))
            {
                $("#popupad").show();
            }
        
        
    })

    function getC(c_name)
    {
    if (document.cookie.length>0)
      {
      c_start=document.cookie.indexOf(c_name + "=")
      if (c_start!=-1)
        { 
        c_start=c_start + c_name.length+1 
        c_end=document.cookie.indexOf(";",c_start)
        if (c_end==-1) c_end=document.cookie.length
        return unescape(document.cookie.substring(c_start,c_end))
        } 
      }
    return ""
    }
    
    
    function setC(c_name,value,expiredays)
    {
    var exdate=new Date()
    exdate.setDate(exdate.getDate()+expiredays)
    document.cookie=c_name+ "=" +escape(value)+
    ((expiredays==null) ? "" : ";expires="+exdate.toGMTString())
    }    

    function opoupad()
    {
        $("#popupad").hide();
        setC('popupad', '1', 3600);
    }
    
 //   autoAlertPrize();
 */
</script>
  <!--
<div style="width:100%; position: absolute;top:100px;">
<div id="popupad" style="display: none; width:570px; height:290px; text-align:center;margin:0px auto; ">
    
    <img src="images/common/close.jpg" style="position:absolute; margin-left:520px;"  onclick="opoupad();">
    <img src="images/common/popupad.jpg" style="">
</div>
</div>
-->
<div style="display:none;"><a href="http://www.live800.com/">客服</a></div>
<div style="display:none;"><a href="http://en.live800.com/">live chat</a></div>



</body></html>