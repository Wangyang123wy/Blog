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
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">    
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!-- the part of css -->
		<link rel="stylesheet" href="dist/css/bootstrap.min.css">
		<link rel="stylesheet" href="css/home.css">
	</head>

	<body>
		<div id="wrap">
			<!-- the header -->
			<div id="hd">
				<span><div align="center"><img src="image/sina.png" style="width: 83.5px;height: 115px;"></div></span>
				<ul id="sidenav">
					<li>
						<span class="listname"><span class="glyphicon glyphicon-user"></span>用户信息<span class="triggle"></span></span>
						<ul>
							<li><a href="user/changePassword.jsp">修改密码</a></li>
							<li><a href="#">我的关注</a>
							<li><a href="user!subscribe">订阅查看</a></li>
						</ul>
					</li>
					<li style="display:${sessionScope.level==1?"none":''}">
						<span class="listname"><span class="glyphicon glyphicon-book"></span>建立知识库<span class="triggle"></span></span>
						<ul>
							<li><a href="model/importdata.jsp">上传数据</a></li>
							<li><a href="model/runFP.jsp">数据分析</a></li>
						</ul>
					</li>
					<li>
						<span class="listname"><span class="glyphicon glyphicon-bold"></span>博客管理<span class="triggle"></span></span>
						<ul>
							<li><a href="blog/orderCancelBlog.jsp">博客订购与退订</a></li>
							<li><a href="blog/blogRecommend.jsp">微博推荐</a></li>
							<li><a href="#">用户推荐</a></li>
						</ul>
					</li>
				</ul>
			</div>

			<!-- the body -->
			<div id="bd">
				<div id="infonav">
					<h2 id="title"><a href="home.jsp">基于Hadoop的微博推荐系统</a></h2>
				</div>

				<!-- content -->
				<div id="maincontent">
					<p id="crumbs"><span id="firstcrumbs">欢迎界面</span><span>></span><span id="seccrumbs"></span></p>
					<iframe src="welcom.jsp" frameborder="0"></iframe>
				</div>
			</div>
		</div>

	<!-- the part of script -->
	<script type="text/javascript" src="dist/js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="dist/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/home.js"></script>
	</body>
</html>
