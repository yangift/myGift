<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="java.util.*,com.yml.crm.domain.*"%>
<!DOCTYPE  html	>
<html lang="en">
<head>
<style type="text/css">
th,td {
	text-align: center !important;
}
</style>
<title>编辑交往记录</title>

<!-- Bootstrap CSS -->
<link href="../css/bootstrap.min.css" rel="stylesheet">
<!-- bootstrap theme -->
<link href="../css/bootstrap-theme.css" rel="stylesheet">
<!--external css-->
<!-- font icon -->
<link href="../css/elegant-icons-style.css" rel="stylesheet" />
<link href="../css/font-awesome.min.css" rel="stylesheet" />
<!-- full calendar css-->
<link
	href="../assets/fullcalendar/fullcalendar/bootstrap-fullcalendar.css"
	rel="stylesheet" />
<link href="../assets/fullcalendar/fullcalendar/fullcalendar.css"
	rel="stylesheet" />
<!-- easy pie chart-->
<link href="../assets/jquery-easy-pie-chart/jquery.easy-pie-chart.css"
	rel="stylesheet" type="text/css" media="screen" />
<!-- owl carousel -->
<link rel="stylesheet" href="../css/owl.carousel.css" type="text/css">
<link href="../css/jquery-jvectormap-1.2.2.css" rel="stylesheet">
<link href="../css/widgets.css" rel="stylesheet">
<link href="../css/style.css" rel="stylesheet">
<link href="../css/style-responsive.css" rel="stylesheet" />
<link href="../css/xcharts.min.css" rel=" stylesheet">
<link rel="stylesheet" href="../css/bootstrap.css">
<!-- 工具js -->
	<script src="js/util.js"></script>
</head>
<%
	String cusId = request.getParameter("cusId");
	Assort ass = (Assort)request.getAttribute("ass");
%>
<body onload = "systemTime()">
	<!-- container section start -->
	<section id="container" class="">
		<header class="header dark-bg">
			<div class="toggle-nav">
				<div class="icon-reorder tooltips"
					data-original-title="Toggle Navigation" data-placement="bottom"></div>
			</div>

			<!--logo start-->
			<a href="index.html" class="logo">Customer <span class="lite">System</span></a>
			<!--logo end-->

			<div class="nav search-row" id="top_menu">
				<!--  search form start -->
				<ul class="nav top-menu">
					<li>
						<form class="navbar-form">
							<input class="form-control" placeholder="Search" type="text">
						</form>
					</li>
				</ul>
				<!--  search form end -->
			</div>

			<div class="top-nav notification-row">
				<!-- notificatoin dropdown start-->
				<ul class="nav pull-right top-menu">

					<li id="task_notificatoin_bar" class="dropdown">
					<li class="dropdown">
						<!-- 用户信息 --> <a data-toggle="dropdown" class="dropdown-toggle"
						href="#"> <span class="profile-ava"> <img alt=""
								src="../img/avatar1_small.jpg">
						</span> <span class="username"><%=session.getAttribute("user") %></span> <b class="caret"></b>
					</a>
						<ul class="dropdown-menu extended logout">
							<div class="log-arrow-up"></div>
							<li class="eborder-top"><a href="#"><i
									class="icon_profile"></i>修改密码</a></li>
							<li><a href="#"><i class="icon_clock_alt"></i>注销</a></li>
						</ul>
					</li>
					<!-- user login dropdown end -->
				</ul>
			</div>
		</header>
		<aside>
			<div id="sidebar" class="nav-collapse ">
				<!-- sidebar menu start-->
				<ul class="sidebar-menu">
					<li class="active"><a class="" href="sal_idnex.jsp"> <i
							class="icon_house_alt"></i> <span>客户关系管理系统</span>
					</a></li>
				</ul>
				<div id="treeview1"></div>
				<!-- sidebar menu end-->
			</div>
		</aside>
		<!--sidebar end-->
		<!--main content start-->
		<section id="main-content">
			<section class="wrapper">
				<!--overview start-->
				<div class="row">
					<div class="col-lg-12">
						<h3 class="page-header">
							<i class="fa fa-laptop"></i>客户管理
						</h3>
						<ol class="breadcrumb">
							<li><i class="fa fa-home"></i><a href="cst_index.jsp">首页</a></li>
							<li><i class="icon_document_alt"></i>客户管理</li>
							<li><i class="fa fa-files-o"></i>客户信息管理</li>
							<li><i class="fa fa-files-o"></i>交往记录</li>
							<li><i class="fa fa-files-o"></i>新增交往记录</li>
						</ol>
					</div>
				</div>
				<div class="col-md-12">
				<form  class = "form-horizontal" method = "post" action="assort?flag=update&cusId=<%=cusId%>&assId=<%=ass.getAssId()%>">
					<div class="row">
					<div class="col-md-5 col-md-offset-7 text-center ">
					<a href = ""><button class="btn btn-info" type = "button" >帮助</button></a>
					<a href="javascript:history.go(-1);"><button class="btn btn-info" type = "button" >返回</button></a>
					<button class="btn btn-info" type="submit">保存</button>
						</div>					
						<div class="col-md-10 col-md-offset-1">
							<table class="table">
							
								<tr>
									<td><label class="control-label"><span style ="color:red">*</span>&nbsp;时间:</label></td>
									<td>
									<input type="text" name="assDate" class="form-control" value = "<%=ass.getAssDate() %>"  /></td>
									<td><label class="control-label">地点:</label></td>
									<td>
									<input type="text" name="assPalce" class = "form-control" value = "<%=ass.getAssPalce() %>" />
									</td>
								</tr>
								<tr>
									<td><label class="control-label"><span style ="color:red">*</span>&nbsp;概要:</label></td>
									<td><input type="text" name="assResume" class="form-control" value = "<%=ass.getAssResume() %>"  /></td>
									<td><label class="control-label">备注:</label></td>
									<td><input type="text" name="assMemo" class="form-control" value = "<%=ass.getAssMemo()%>"/></td>
								</tr>
								<tr>
									<td><label class="control-label">详细信息:</label></td>
									<td colspan="3">
									<textarea class = "form-control" name ="assDetal" ><%=ass.getAssDetail() %></textarea>
									</td>
								</tr>						
							</table>
						</div>						
					</div>
					</form>
				</div>
			</section>
		</section>
		<!--main content end-->
	</section>
	<!-- container section start -->

	<!-- javascripts -->
	<script src="../js/jquery.js"></script>
	<script src="../js/bootstrap.min.js"></script>
	<!-- nice scroll -->
	<script src="../js/jquery.scrollTo.min.js"></script>
	<script src="../js/jquery.nicescroll.js" type="text/javascript"></script>
	<!-- jquery validate js -->
	<script type="text/javascript" src="../js/jquery.validate.min.js"></script>

	<!-- custom form validation script for this page-->
	<script src="../js/form-validation-script.js"></script>
	<!--custome script for all page-->
	<script src="../js/scripts.js"></script>
</body>
</html>
<jsp:include page="../right.jsp"></jsp:include>
