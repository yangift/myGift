<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="java.util.*,com.yml.crm.domain.*,java.text.*"%>
<!DOCTYPE  html	>
<html lang="en">
<head>
<style type="text/css">
th,td {
	text-align: center !important;
}
</style>
<title>交往记录</title>

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
</head>
<%
Customer cus = (Customer)request.getAttribute("cus");
%>
<script type="text/javascript">
	function page(pageNum, pageCount) {
		if (pageNum <= 0) {
			pageNum == 1;
		}
		if (pageNum > pageCount) {
			pageNum = pageCount;
		}
		document.form1.action = "assort?flag=query&cusId=<%=cus.getCusId()%>&page=" + pageNum;
		document.form1.submit();
	}
</script>
<body>
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
					<li class="active"><a class="" href="index.html"> <i
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
							<li><i class="icon_document_alt"></i>客户信息</li>
							<li><i class="fa fa-files-o"></i>交往记录</li>
						</ol>
					</div>
				</div>
				<div class="col-md-12">
				<div class = "row">
				<div class="col-md-5 col-md-offset-8 text-center ">
					<a href="javascript:history.go(-1);"><button class="btn btn-info" type = "button" >返回</button></a>
					<a href = "cst_assortAdd.jsp?cusId=<%=cus.getCusId()%>"><button class="btn btn-info" type = "button" >新建</button></a>
				</div>
				</div>
				<form class="form-horizontal" 
						action="linkman?flag=query" method="post" name="form1">
						<div class="row">
							<div class="col-md-2 col-md-offset-1">
								<label class="control-label">&nbsp;客户编号:</label>
							</div>
							<div class="col-md-3">
								<input type="text" name="cusNumber" class="form-control" value = "<%=cus.getCusNumber() %>" />
							</div>
							<div class="col-md-2 text-right">
								<label class="control-label">客户名称:</label>
							</div>
							<div class="col-md-3">
								<input type="text" name="cusName" class="form-control" value = "<%=cus.getCusName() %>" />
							</div>
							</div>
							</form>
					<div class="row">
						<div class="col-md-10 col-md-offset-1">
							<table class="table">
								<thead>
									<tr>
										<th width="10%">时间</th>
										<th width="20%">地点</th>
										<th width="20%">概要</th>
										<th width="10%">详细信息</th>
										<th width="20%">备注</th>
										<th>操作</th>
									</tr>
								</thead>
								<tbody >
									<%
									SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
										List<Assort> list = (List<Assort>) request
												.getAttribute("assList");
										//System.out.print("12"+list.get(0).getChcId());
										if (list != null && !list.isEmpty()) {
											for (int i = 0; i < list.size(); i++) {
												Assort ass = new Assort();
												ass = list.get(i);
									%>
									<%
									
									%>
									<tr>
										<td><%=sdf.format(ass.getAssDate())%></td>
										<td><%=ass.getAssPalce()%></td>
										<td><%=ass.getAssResume()%></td>
										<td><%=ass.getAssDetail()%></td>
										<td><%=ass.getAssMemo()%></td>
										<td><a
											href="assort?flag=initEdit&assId=<%=ass.getAssId()%>&cusId=<%=cus.getCusId()%>"
											title="编辑交往记录"> <span class="glyphicon glyphicon-pencil">&nbsp;</span>
										</a> <a href="assort?flag=del&assId=<%=ass.getAssId()%>&cusId=<%=cus.getCusId()%>" title="删除"> <span
												class="glyphicon glyphicon-trash"></span>
										</a></td>
									</tr>
									<%
										}
										}
									%>
								</tbody>
							</table>
							<%
								int showPage = ((Integer) (request.getAttribute("showPage")))
										.intValue();
								int pageCount = ((Integer) (request.getAttribute("pageCount")))
										.intValue();
								int page1 = showPage - 1;
								int page2 = showPage + 1;
								int lastPage = pageCount;
							%>

							<div style="text-align: right;">
								<ul class="pager">
									<li><a href="javascript:page(1,<%=pageCount%>)">&laquo;</a></li>
									<li><a href="javascript:page(<%=page1%>,<%=pageCount%>)">上一页</a></li>
									<li><a href="javascript:page(<%=page2%>,<%=pageCount%>)">下一页</a></li>
									<li><a
										href="javascript:page(<%=lastPage%>,<%=pageCount%>)">&raquo;</a></li>
								</ul>
							</div>
						</div>
					</div>
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
