$(document).ready(function(){
//	deskSearch();
//	loadContentType('');
//	$(".left_menu_da").on("click","li",function(){  
//		 $(".left_menu_da").find('li.on').removeClass('on');
//		  $(this).addClass('on');
//		  
//		 });
	
});



function initPage(pIndex,fun){
	if(fun != undefined)
		eval(fun+"("+pIndex+")");
	var pageDiv = document.getElementById("pageDiv");
	var pCount = parseInt($(pageDiv).attr("pCount"));
	pageDiv.innerHTML = "";
	var inHtml = "<a href='javascript:initPage(1,deskSearch(1,1));'>&nbsp;首页&nbsp;</a><a href='javascript:goLast()'>&nbsp;上一页&nbsp;</a>";
	if(pIndex == 1 || pIndex == undefined){
		inHtml += "<span id='selected'><span id='p1'>[1]</span></span>";	
		//不超过5页全显示
		var i=5;
		if(pCount <5)
			i=pCount;		

		for(var m=1; m<i; m++)
			inHtml += "<span><a id='p"+(m+1)+"' href='"+"javascript:goPage("+(m+1)+")"+"'>["+(m+1)+"]</a></span>";
		
		$(pageDiv).attr("mix",1);
		$(pageDiv).attr("max",i);
	}
	
	else if(pIndex == pCount){
		var i= pCount-5;
		if(i<0)
			i=0;
		for(var m=i; m<pCount-1; m++){
			inHtml += "<span><a id='p"+(m+1)+"' href='"+"javascript:goPage("+(m+1)+")"+"'>["+(m+1)+"]</a></span>";
		}
		inHtml += "<span id='selected'><span id='p"+pCount+"'>["+pCount+"]</span></span>";
		
		$(pageDiv).attr("mix",i+1);
		$(pageDiv).attr("max",pCount);
	}
	else{
		var i=pIndex -2;
		if(i<1)
			i=1;
		var j=pIndex +2;
		if(j>pCount)
			j=pCount;
		
		for(var m=i; m<pIndex; m++){
			inHtml += "<span><a id='p"+(m)+"' href='"+"javascript:goPage("+(m)+")"+"'>["+(m)+"]</a></span>";
		}			
		inHtml += "<span id='selected'><span id='p"+pIndex+"'>["+pIndex+"]</span></span>";

		for(var n=pIndex+1; n<=j; n++){
			inHtml += "<span><a id='p"+(n)+"' href='"+"javascript:goPage("+(n)+")"+"'>["+(n)+"]</a></span>";
		}

		$(pageDiv).attr("mix",i);
		$(pageDiv).attr("max",j);
	}

	inHtml += "<span><a href='javascript:goNext()'>下一页</a></span><span><a href='"+"javascript:initPage("+pCount+",deskSearch("+pCount+",1))"+"'>尾页</a></span>";
		
	
	pageDiv.innerHTML = inHtml;
}

function goPage(pIndex){
	deskSearch(pIndex,'pTag');
	
	var thisObj = document.getElementById("p"+pIndex).parentNode;
	thisObj.innerHTML = "<span id='p"+pIndex+"'>["+(pIndex)+"]</span>";
	
	var oldObj = document.getElementById("selected");	
	var oSel = parseInt(oldObj.childNodes[0].id.substring(1));
	oldObj.innerHTML = "<a id='p"+(oSel)+"' href='"+"javascript:goPage("+oSel+")"+"'>["+(oSel)+"]</a>";
	oldObj.id = "";
	

	$(thisObj).attr("id", "selected");
	
}

function goLast(){
	var oldObj = document.getElementById("selected");	
	var oSel = parseInt(oldObj.childNodes[0].id.substring(1));
	var mix = parseInt($(pageDiv).attr("mix"));
	
	if(oSel == 1)
		return;
	else if(oSel == mix){
		deskSearch(oSel-1,'pTag');
		initPage(oSel-1);
	}
	else
		goPage(oSel-1);
}

function goNext(){
	var pCount = parseInt($("#pageDiv").attr("pCount"));
	var oldObj = document.getElementById("selected");	
	var oSel = parseInt(oldObj.childNodes[0].id.substring(1));
	var max = parseInt($(pageDiv).attr("max"));
	if(oSel == pCount)
		return;
	else if(oSel == max){
		deskSearch(oSel+1,'pTag');
		initPage(oSel+1);
	}
	else
		goPage(oSel+1);
}


