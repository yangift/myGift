<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<%@ page import="java.util.List,com.yml.crm.domain.*" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Creative - Bootstrap 3 Responsive Admin Template">
    <meta name="author" content="GeeksLabs">
    <meta name="keyword" content="Creative, Dashboard, Admin, Template, Theme, Bootstrap, Responsive, Retina, Minimal">
    <link rel="shortcut icon" href="img/favicon.png">

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
    <link href="../assets/jquery-easy-pie-chart/jquery.easy-pie-chart.css" rel="stylesheet" type="text/css" media="screen"/>
    <!-- owl carousel -->
    <link rel="stylesheet" href="../css/owl.carousel.css" type="text/css">
	<link href="../css/jquery-jvectormap-1.2.2.css" rel="stylesheet">
    <!-- Custom styles -->
	<link rel="../stylesheet" href="css/fullcalendar.css">
	<link href="../css/widgets.css" rel="stylesheet">
    <link href="../css/style.css" rel="stylesheet">
    <link href="../css/style-responsive.css" rel="stylesheet" />
	<link href="../css/xcharts.min.css" rel=" stylesheet">	
	<link href="../css/jquery-ui-1.10.4.min.css" rel="stylesheet">
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 -->
    <!--[if lt IE 9]>
      <script src="js/html5shiv.js"></script>
      <script src="js/respond.min.js"></script>
      <script src="js/lte-ie7.js"></script>
    <![endif]-->
  </head>

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
                                <img alt="" src="../img/avatar1_small.jpg">
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
          <div id="sidebar"  class="nav-collapse ">
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
			  <div class="row">
				<div class="col-lg-12">
					<h3 class="page-header"><i class="fa fa-laptop"></i>统计报表</h3>
					<ol class="breadcrumb">
						<li><i class="fa fa-home"></i><a href="index.html">首页</a></li>		
						<li><i class="icon_document_alt"></i>统计报表</li>
						<li><i class="fa fa-files-o"></i>客户流失分析</li>
					</ol>
				</div>				
			</div>
		<div class="row">
			<div class="col-md-12 text-right">
						<input type="button" value="帮助" class="btn btn-default" /> <input
							type="button" value="查询" onclick="query()" class="btn btn-info" />
					</div>
					<div class="col-md-12">
					<form name="form1" action="CountDevote?flag=countWastage" method="post">
						<div class="col-sm-3 text-right">
							<label class="control-label" for="cstname">客户名称：</label>
						</div>
						<div class="col-sm-3 ">
							<input type="text" name="cstname" id="cstname" class="form-control" />
						</div>
						<div class="col-sm-2 text-right">
							<label class="control-label" for="cstmanager">客户经理：</label>
						</div>
						<div class="col-sm-3">
							<input type="text" name="cstmanager" id="cstmanager" class="form-control" />
						</div>
					</form>
					</div>
					<br />
					<br />
					<br />
					<div class="container col-md-12">
						<table class="table table-bordered table-hover table-striped">
							<thead>
								<tr>
									<th >编号</th>
									<th >年份</th>
									<th >客户</th>
									<th >客户经理</th>
									<th >流失原因</th>
								</tr>
							</thead>
							<tbody>
							<%
								List<Lost> list = (List<Lost>)request.getAttribute("list");
								if(list!=null){
									for(int i=0;i<list.size();i++){
										Lost lost = new Lost();
										lost = list.get(i);
								
							%>
								<tr>
									<td ><%=lost.getLosId() %></td>
									<td ><%=lost.getLosDate() %></td>
									<td ><%=lost.getLosCustomer() %></td>
									<td ><%=lost.getLosManager() %></td>
									<td ><%=lost.getLosReason() %></td>
								</tr>
								<%
									}
								}%>
							</tbody>
						</table>
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
  <script type="text/javascript">
  	function query(){
  		document.form1.submit();
  	}
  </script>
</html>
<jsp:include page="../right.jsp"></jsp:include>
