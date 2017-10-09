<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title></title>
		<link rel="stylesheet" href="../css/bootstrap.css">
		<link rel="stylesheet" href="../css/bootstrap-theme.min.css">
		<link rel="stylesheet" href="../css/bootstrap-treeview.css">
		<script src="../js/bootstrap.min.js"></script>
		<script src="../js/bootstrap-treeview.js"></script>
    <script type="text/javascript">
		$(function() {
			$('#treeview1').treeview({
				data: $("#treeviewVal").html(),
				levels: 1,
				enableLinks:true,
				backColor:'#7A8B8B!important',
				borderColor:'#7A8B8B!important',
				color:'#FFFFFF',
				collapseIcon:'glyphicon  glyphicon-th-list',//点击之后的图标
				expandIcon:'glyphicon glyphicon-plus-sign',
				emptyIcon:'glyphicon glyphicon-file',
				onNodeChecked: function(event, data) {
					//选中父节点，则自动选择子节点
					if(data.nodes != null) {
						var arrayInfo = data.nodes;
						for(var i = 0; i < arrayInfo.length; i++) {
							$('#treeview1').treeview('toggleNodeChecked', [arrayInfo[i].nodeId, {
								silent: true
							}]);
						}
					}
				},
				onNodeUnchecked: function(event, data) {
					//取消选中父节点，则自动取消选择子节点
					if(data.nodes != null) {
						var arrayInfo = data.nodes;
						for(var i = 0; i < arrayInfo.length; i++) {
							$('#treeview1').treeview('toggleNodeChecked', [arrayInfo[i].nodeId, {
								silent: true
							}]);
						}
					}
				}
			});
		});
	</script>
</head>
<body>
<div id = "treeview1"></div>
 <div style="display: none;" id="treeviewVal">
	[{"id":1,"text":"营销管理","level":0,"tag":0,"nodes":[
	{"id":11,"text":"销售机会管理","level":0,"tag":0,"href":"../sal/salchance?flag=query"},
	{"id":12,"text":"客户开发计划","level":0,"tag":0,"href":"../sal/salchance?flag=queryPlan"}],
	"href":"../sal/sal_index.jsp"}, 
	{"id":2,"text":"客户管理","level":0,"tag":0,"nodes":[
	{"id":21,"text":"客户信息管理","level":0,"tag":0,"href":"../cst/customer?flag=query"},
	{"id":22,"text":"客户流失管理","level":0,"tag":0,"href":"../cst/customer?flag=queryLost"}],
	"href":"../cst/cst_index.jsp"}, 
	{"id":3,"text":"服务管理","level":0,"tag":0,"nodes":
	[{"id":31,"text":"服务创建","level":0,"tag":0,"href":"../ser_count/SerCreateServelet?flag=customer"},
	{"id":32,"text":"服务分配","level":0,"tag":0,"href":"../ser_count/ser_allot.jsp"},
	{"id":33,"text":"服务处理","level":0,"tag":0,"href":"tdyhRecord!patBarcodeRecordList.html"},
	{"id":34,"text":"服务反馈","level":0,"tag":0,"href":"tdyhRecord!patBarcodeRecordList.html"},
	{"id":35,"text":"服务归档","level":0,"tag":0,"href":"tdyhRecord!patBarcodeRecordList.html"}],
	"href":"../ser_count/ser_allot.jsp"},
	{"id":4,"text":"统计报表","level":0,"tag":0,"nodes":
	[{"id":41,"text":"客户贡献分析","level":0,"tag":0,"href":"hotelChange!list.html"},
	{"id":42,"text":"客户构成分析","level":0,"tag":0,"href":"../count/CountDevote?flag=consist"},
	{"id":43,"text":"客户服务分析","level":0,"tag":0,"href":"../count/CountDevote?flag=countserve"},
	{"id":44,"text":"客户流失分析","level":0,"tag":0,"href":"../count/CountDevote?flag=countWastage"}],
	"href":"../count/CountDevote?flag=consist"},
	{"id":4,"text":"基础数据","level":0,"tag":0,"nodes":
	[{"id":41,"text":"数据字典管理","level":0,"tag":0,"href":"hotelChange!list.html"},
	{"id":42,"text":"查询产品数据","level":0,"tag":0,"href":"tdyhRecord!patBarcodeRecordList.html"},
	{"id":43,"text":"查询库存","level":0,"tag":0,"href":"tdyhRecord!patBarcodeRecordList.html"}],
	"href":""}
	]
</div>
</body>
</html>