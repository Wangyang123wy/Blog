<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
	<head>
		<base href="<%=basePath%>">
		<title>导入数据</title>
		<meta charset="utf-8">
		<link rel="stylesheet" href="css/model.css">
	</head>
<body>
	<div id="wrap">
		<%-- <form id="importdata" action="modelAction!upload">
		<div>
			<label>服务器文件路径:</label><input type="text" name="ftpPath" />
			<select name="uploadDeltaOrAll" id="upId">
				<option value="all">全量</option>
				<option value="delta">增量</option>
			</select>
		</div>
		
		<div id="btn-group">
		
			<button type="reset">重置</button>
			<button type="submit">导入</button>
		</div>

		<span id="alarm">
		<!-- 显示导入数据返回信息 -->
			<s:if test='%{info!=null||info!=""}'>
				<s:property value="%{info}"/>
			 </s:if>
		</span>
			
		</form> --%>
		
		<form id="importdata" action="model!uploadFF">
			<div>
				<span>用户粉丝-用户关注数据</span><br /><br />
				<label>文件路径:</label><input type="file" name="FFPath" />
				<select name="uploadDeltaOrAll_FF" id="upId_FF">
					<option value="all">全量</option>
					<option value="delta">增量</option>
				</select>
				<button type="reset" style="margin-left: 20px;">重置</button>
				<button type="submit">导入</button>
			</div>
			<span id="alarm">
				<!-- 显示导入数据返回信息 -->
				<s:if test='%{info!=null||info!=""}'>
					<s:property value="%{info}"/>
				</s:if>
			</span>
		</form>
		
		<form id="importdata" action="model!uploadPost">
			<div>
				<span>微博数据</span><br /><br />
				<label>文件路径:</label><input type="file" name="PostPath" />
				<select name="uploadDeltaOrAll_Post" id="upId_Post">
					<option value="all">全量</option>
					<option value="delta">增量</option>
				</select>
				<button type="reset" style="margin-left: 20px;">重置</button>
				<button type="submit">导入</button>
			</div>
			<span id="alarm">
				<!-- 显示导入数据返回信息 -->
				<s:if test='%{info!=null||info!=""}'>
					<s:property value="%{info}"/>
				</s:if>
			</span>
		</form>
		
		<form id="importdata" action="model!uploadWU">
			<div>
				<span>微博用户数据</span><br /><br />
				<label>文件路径:</label><input type="file" name="WUPath" />
				<select name="uploadDeltaOrAll_WU" id="upId_WU">
					<option value="all">全量</option>
					<option value="delta">增量</option>
				</select>
				<button type="reset" style="margin-left: 20px;">重置</button>
				<button type="submit">导入</button>
			</div>
			<span id="alarm">
				<!-- 显示导入数据返回信息 -->
				<s:if test='%{info!=null||info!=""}'>
					<s:property value="%{info}"/>
				</s:if>
			</span>
		</form>
	</div>
	<script type="text/javascript" src="dist/js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="js/importdata.js"></script>
</body>
</html>