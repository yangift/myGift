<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ page
	import="java.util.List,java.util.Date,java.text.SimpleDateFormat,com.yml.crm.domain.Customer,com.yml.crm.servlet.SerAllotServlet"%>
<!DOCTYPE html>
<html lang="en">

	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta name="description" content="Creative - Bootstrap 3 Responsive Admin Template">
		<meta name="author" content="GeeksLabs">
		<meta name="keyword" content="Creative, Dashboard, Admin, Template, Theme, Bootstrap, Responsive, Retina, Minimal">
		<link rel="shortcut icon" href="../img/favicon.png">

		<title>Creative - Bootstrap Admin Template</title>

		<!-- Bootstrap CSS -->
		<link href="../css/bootstrap.min.css" rel="stylesheet">
		<!-- bootstrap theme -->
		<link href="../css/bootstrap-theme.css" rel="stylesheet">
		<!--external css-->
		<!-- font icon -->
		<link href="../css/elegant-icons-style.css" rel="stylesheet" />
		<link href="../css/font-awesome.min.css" rel="stylesheet" />
		<!-- full calendar css-->
		<link href="../assets/fullcalendar/fullcalendar/bootstrap-fullcalendar.css" rel="stylesheet" />
		<link href="../assets/fullcalendar/fullcalendar/fullcalendar.css" rel="stylesheet" />
		<!-- easy pie chart-->
		<link href="../assets/jquery-easy-pie-chart/jquery.easy-pie-chart.css" rel="stylesheet" type="text/css" media="screen" />
		<!-- owl carousel -->
		<link rel="stylesheet" href="../css/owl.carousel.css" type="text/css">
		<link href="../css/jquery-jvectormap-1.2.2.css" rel="stylesheet">
		<!-- Custom styles -->
		<link rel="stylesheet" href="../css/fullcalendar.css">
		<link href="../css/widgets.css" rel="stylesheet">
		<link href="../css/style.css" rel="stylesheet">
		<link href="../css/style-responsive.css" rel="stylesheet" />
		<link href="../css/xcharts.min.css" rel=" stylesheet">
		<link href="../css/jquery-ui-1.10.4.min.css" rel="stylesheet">
		
	</head>
<script>
	function formInput() {
		document.form1.submit();
	}
</script>
	<body>
		<!-- container section start -->
		<section id="container" class="">

			<header class="header dark-bg">
				<div class="toggle-nav">
					<div class="icon-reorder tooltips" data-original-title="Toggle Navigation" data-placement="bottom"></div>
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
								<!-- 用户信息 -->
								<a data-toggle="dropdown" class="dropdown-toggle" href="#">
									<span class="profile-ava">
                                <img alt="" src="img/avatar1_small.jpg">
                            </span>
									<span class="username">Jenifer Smith</span>
									<b class="caret"></b>
								</a>
								<ul class="dropdown-menu extended logout">
									<div class="log-arrow-up"></div>
									<li class="eborder-top">
										<a href="#"><i class="icon_profile"></i>修改密码</a>
									</li>
									<li>
										<a href="#"><i class="icon_clock_alt"></i>注销</a>
									</li>
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
						<li class="active">
							<a class="" href="index.html">
								<i class="icon_house_alt"></i>
								<span>客户关系管理系统</span>
							</a>
						</li>
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
					<div class="row one">
						<div class="col-lg-12">
							<h3 class="page-header"><i class="fa fa-laptop"></i>营销管理</h3>
							<ol class="breadcrumb">
								<li><i class="fa fa-home"></i>
									<a href="../index.html">首页</a>
								</li>
								<li><i class="icon_document_alt"></i>营销管理</li>
								<li><i class="fa fa-files-o"></i>销售机会管理</li>
							</ol>
						</div>
					</div>
					<form class="form-horizontal" role="form" name="form1" action="SerCreateServelet?flag=input" method="post">
						<div class="row">
							<div class="col-md-12 pull-right">
								<div class="form-group">
									<div class="col-sm-11 column">
										<button type="button" class="btn btn-default pull-right">帮助</button>
									</div>
									<div class="col-sm-1 column">
										<button type="button" class="btn btn-default" onclick="formInput()">保存</button>
									</div>
								</div>
							</div>
						</div>

						<div class="row one">
							<div class="form-group">
								<label for="sertype" class="col-sm-2 control-label">服务类型：</label>
								<div class="col-sm-2">
									<select class="form-control" name="sertype" id="sertype">
										<option class="select" value="1">咨询</option>
										<option value="2">中意</option>
										<option value="3">可爱</option>
									</select>
								</div>
							</div>
						</div>
						<div class="row one">
							<div class="form-group">								
								<label for="title" class="col-sm-2 control-label">概要：</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" id="title" name="title" placeholder="200字以内...."/>
								</div>

							</div>
						</div>
						<div class="row one">
							<div class="form-group">								
								<label for="customer" class="col-sm-2 control-label">客户：</label>
								<div class="col-sm-3">
									<select class="form-control" name="customer" id="customer">
									<%List<Customer> list = (List<Customer>)request.getAttribute("cuslist");
										if(list!=null){
											for(int i= 0;i<list.size();i++){
												Customer customer = new Customer();
												customer = list.get(i);												
										
										%>
										<option class="select" value="<%=customer.getCusId() %>"><%=customer.getCusName() %></option>
										<%
											}
										}
										%>
																			
									</select>
								</div>
								<label for="state" class="col-sm-2 control-label">状态：</label>
								<div class="col-sm-3">
									<select class="form-control" name="state" id="state">
										<option class="select" value="1">未分配</option>
										<option value="2">已分配</option>										
									</select>
								</div>
							</div>
						</div>
						<div class="row one">
							<div class="form-group">								
								<label for="serrequest" class="col-sm-2 control-label">服务请求：</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" id="serrequest" name="serrequest" />
								</div>								
							</div>
						</div>
						<div class="row one">
							<div class="form-group">								
								<label for="crename" class="col-sm-2 control-label">创建人：</label>
								<div class="col-sm-3">
									<input type="text" class="form-control" id="crename" name="crename" />
								</div>
								<label for="credate" class="col-sm-2 control-label">创建日期 ：</label>
								<div class="col-sm-3">
									
									<%Date date1 = new Date();
									SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
									String str = sdf.format(date1); %>
									<input type="hidden" class="form-control" id="credate" name="credate" value="<%=str %>"/>
								</div>
							</div>
						</div>
					</form>
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