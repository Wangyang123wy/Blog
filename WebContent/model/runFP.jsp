<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
	<head>
		<base href="<%=basePath%>">
		<title>基于Hadoop的微博推荐系统</title>
		<meta charset="utf-8">
		<link rel="stylesheet" href="css/model.css">
	</head>
<body>
	<div id="wrap">
		<form id="createmodel" action="modelAction!train" method="post">
			<div><label for="">最小支持度:</label><input type="text" name="minSupport" class="required" value="1000"></div>
			<div><label for="">最大堆内存值:</label><input type="text" name="maxHeap" id="" class="required" value="50"></div>
			<div><label for="">原始数据分组个数:</label><input type="text" name="numGroups" id="" class="required" value="100"></div>
			<div><label for="">FP树缓存条目个数:</label><input type="text" name="treeCache" class="required" value="5"></div>
			<div><label for="">原始数据事务分隔符:</label><input type="text" name="splitter" class="required" value=" "></div>
			<div><label for="">Reducer个数:</label><input type="text" name="numReducer" class="required" value="2"></div>
			<div id="btn-group">
				<button type="reset">重置</button>
				<button type="submit">确认</button>
			</div>
			<p id="alarm"></p>
		</form>
	</div>
	<script type="text/javascript" src="dist/js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="js/createmodel.js"></script>
</body>
</html>