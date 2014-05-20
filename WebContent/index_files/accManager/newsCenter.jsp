<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <div class="page_name">
            <div class="page_adress">您的位置：
                <a href="index">首頁</a>
                <span class="gt">&gt;</span>
                <span>宝胜新闻</span>
            </div>
        </div>
        <div class="other_con">
            <div class="left_menu">
                <h2>宝胜新闻</h2>
                <ul class="left_menu_da">
                  
                </ul>
            </div>
            <div class="right_con">
            	<div class="news_search">
            	<input type="hidden" id="contentType" value=""/>
            	    <span class="txt_a">日期：</span>
                    <input class="date" type="text" name="applyStartDate" placeholder="<spring:message code="portal.txt.beginDate" />"/>
                	<span class="txt_a"><spring:message code="portal.txt.to" /></span>
                    <input class="date" type="text" name="applyEndDate" placeholder="<spring:message code="portal.txt.endDate" />"/>
                	<select id="querySelect">
                    	<option value="0">题标</option>
                    	<option value="1">简述</option>
                    </select>
                    <input class="input_b"  id="queryText"/>
                    <a class="btn_search" onclick="deskSearch()">查询</a>
                 
                </div>
                <div class="news_ul">
					<ul class="news_uldetail">
                    	
                    </ul>
                </div>
                
                <div class="pages_o" id="pageDiv">
                	
                </div>  
            </div>
        </div>
    <script type="text/javascript" src="${basePath}/js/module/portal/newsCenter.js"></script>
  
