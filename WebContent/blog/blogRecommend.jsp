<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>博客推荐</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" href="css/blog.css">
	
  </head>
  
  <body>
    <div id="wrap" class="list">
    	<form action ="blog!recommend" method="post">
	    	<div>	
	    	<label for="">选择推荐方式:</label>
				<select name="recommendType" id="upId">
						<option value="top">Top推荐</option>
						<option value="union">联合推荐</option>
						<option value="last">上次推荐</option>
				</select>
				<input type="submit" value="推荐" />
			</div>
		</form>
	
	<s:if test='%{info!=null}'>
		<s:if test='%{info=="null"}'>
	  		<h3>尊敬的用户您好，您还没有相关推荐博客，您可以选择使用Top推荐方式！</h3>
	  	</s:if>
	  	<s:else>
	  	
	  	<h3>尊敬的用户您好，为您推荐的博客信息如下：</h3>
	  	<table border="1">
			<thead>
				<tr>
					<td id="blogId">博客id</td>
					<td id="blogInfo">博客简要描述</td>
				</tr>
			</thead>
			
	    	<s:iterator value="recommendBlogs" id="array">  
	    	<tr>
	          <td><s:property value="array"/></td>
	          <td>******</td>
	           </tr>
	        </s:iterator>  
	       
	    </table>
	    </s:else>
	  </s:if>
	</div>
  </body>
</html>
