<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="java.util.*,com.yml.crm.domain.*"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>制定计划</title>
<style type="text/css">
th,td {
	text-align: center !important;
}
</style>
<title>销售机会管理</title>

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
<script type="text/javascript">
function addPlan(){
	var plan = {
			plaDate:$("[name='plaDate']").val(),
			plaPlan:$("[name='plaPlan']").val(),
			plaId:$("[name='plaId']").val(),
			plaChcId:$("[name='plaChcId']").val(),
			plaResult:$("[name='plaResult']").val()
		};
	$.ajax({
		url:"plan?flag=update",
		data:plan,
		type:'post',
		dataType:'text',
		success:function(msg){
				console.log('添加成功');
		}		
	});
};
function delPlan(id){
	var plan = {
			plaId:id
		};
	console.log(plan);
	$.ajax({
		url:"plan?flag=del",
		data:plan,
		type:'post',
		dataType:'text',
		success:function(msg){
				console.log('删除成功');
		}
		
	});
};
</script>
</head>
<%
	SalChance sal = (SalChance) request.getAttribute("sal");
%>
<body>
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
						</span> <span class="username"><%=session.getAttribute("user")%></span> <b
							class="caret"></b>
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
							<i class="fa fa-laptop"></i>营销管理
						</h3>
						<ol class="breadcrumb">
							<li><i class="fa fa-home"></i><a href="sal_index.jsp">首页</a></li>
							<li><i class="icon_document_alt"></i>营销管理</li>
							<li><i class="fa fa-files-o"></i>销售机会管理</li>
							<li><i class="fa fa-files-o"></i>制定计划</li>
						</ol>
					</div>
				</div>
				<div class="col-md-12">
					<div class="row">
						<div class="col-md-10 col-md-offset-1">
							<table class="table">

								<thead>
									<tr>
										<th width="20%">日期</th>
										<th colspan="2">计划项</th>
										<th>执行效果</th>
										<th width="10%">操作</th>
									</tr>
								</thead>
								<tbody>
									<%
										List<Plan> planList = (List<Plan>) request.getAttribute("planList");
										if (planList != null) {
											for (int i = 0; i < planList.size(); i++) {
												Plan plan = new Plan();
												plan = planList.get(i);
									%>
									<tr>
										<td><label class="control-label"><input  class="form-control"
											name="plaDate" value="<%=plan.getPlaDate()%>"/></label></td>
										<td colspan="2"><input  class="form-control"
											name="plaPlan" value="<%=plan.getPlaPlan()%>" />
											<input type = "hidden" class="form-control"
											name="plaId" value="<%=plan.getPlaId()%>" />
											<input  type = "hidden" class="form-control"
											name="plaChcId" value="<%=plan.getPlaChcId()%>" />
											</td>
											<td><input  class="form-control"
											name="plaResult" value="<%=plan.getPlaResult()%>" /></td>
										<td><a
											href="#"
											title="保存" onclick = "addPlan()"> <span class="glyphicon glyphicon-save">&nbsp;</span>
										</a> <a href="#"
											 title="删除" onclick = "delPlan(<%=plan.getPlaId()%>)"><span class="glyphicon glyphicon-trash"></span>
										</a></td>

									</tr>
									<%
										}
										}
									%>
								</tbody>
								<tfoot>
									<form class="form-horizontal" method="post"
										action="plan?flag=add">
										<tr>
											<td><label class="control-label">日期</label></td>
											<td width="20%"><input class="form-control" type="text"
												name="plaDate" /> <input type="hidden" name="plaChcId"
												value="<%=sal.getChcId()%>" /></td>
											<td width="10%"><label class="control-label">计划项</label></td>
											<td><input class="form-control" name="plaPlanAdd" /></td>
											<td><button class="control-label btn btn-info"
													type="submit">新建</button></td>
										</tr>
									</form>

								</tfoot>
							</table>
							<table class="table">
								<caption>客户信息</caption>
								<tr>
									<td><label class="control-label">编号:</label></td>
									<td><input type="text" name="chcId" class="form-control"
										value="<%=sal.getChcId()%>" readonly /></td>
									<td><label class="control-label">机会来源:</label></td>
									<td><input type="text" name="chcSource"
										class="form-control" value="<%=sal.getChcSource()%>" readonly /></td>
								</tr>
								<tr>
									<td><label class="control-label">客户名称:</label></td>
									<td><input type="text" name="chcCustName"
										class="form-control" value="<%=sal.getChcCustName()%>"
										readonly /></td>
									<td><label class="control-label">成功机率:</label></td>
									<td><input type="text" name="chcRate" class="form-control"
										value="<%=sal.getChcRate()%>" readonly /></td>
								</tr>
								<tr>
									<td><label class="control-label">概要:</label></td>
									<td colspan="3"><input type="text" name="chcTitle"
										class="form-control" value="<%=sal.getChcTitle()%>" readonly /></td>
								</tr>
								<tr>
									<td><label class="control-label">联系人:</label></td>
									<td><input type="text" name="chcLinkman"
										class="form-control" value="<%=sal.getChcLinkman()%>" readonly /></td>
									<td><label class="control-label">联系电话:</label></td>
									<td><input type="text" name="chcTel" class="form-control"
										value="<%=sal.getChcTel()%>" readonly /></td>
								</tr>
								<tr>
									<td><label class="control-label">机会描述:</label></td>
									<td colspan="3"><textarea name="chcDesc"
											class="form-control" readonly><%=sal.getChcDesc()%></textarea>
									</td>
								</tr>
								<tr>
									<td><label class="control-label">创建人:</label></td>
									<td><input type="text" name="chcCreateName"
										class="form-control" value="<%=sal.getChcCreateName()%>"
										readonly /></td>
									<td><label class="control-label">创建时间:</label></td>
									<td><input type="text" name="chcCreateDate"
										class="form-control" value="<%=sal.getChcCreateDate()%>"
										readonly /></td>
								</tr>
								<tr>

									<td><label class="control-label">指派给:</label></td>
									<td><input type="text" name="chcDueName"
										class="form-control" value="<%=sal.getChcDueName()%>" readonly /></td>
									<td><label class="control-label">指派时间:</label></td>
									<td>
										<%
											if (sal.getChcDueDate() != null) {
										%> <input type="text" name="chcDueDate" class="form-control"
										value="<%=sal.getChcDueDate()%>" readonly /> <%
 	} else {
 %> <input type="text" name="chcDueDate" class="form-control"
										id="showtime" /> <%
 	}
 %> <!-- 这里需要指明已经分配 --> <input type="hidden" value="已分配"
										name="chcStatus" />
									</td>
								</tr>
							</table>

						</div>
					</div>

				</div>
			</section>
		</section>
		<!--main content end-->
	</section>
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