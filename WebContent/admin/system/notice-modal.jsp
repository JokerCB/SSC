<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="module_content">
<form action="../system/addNotice" method="post" target="ajax" call="sysReloadNotice">
    <fieldset>
		<input type="radio" value="1" name="enable" checked="checked"/>显示
		<input type="radio" value="0" name="enable"/>隐藏
    	<label>发布内容</label>
        <textarea rows="5" name="content" style="width:94%"></textarea>
    </fieldset>
</form>
</div>