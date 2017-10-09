<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String user = (String)session.getAttribute("user");
		if (user == null || "".equals(user)) {
			//回到登录界面
			session.setAttribute("user", "张三") ;//这里为了测试
		}
	%>
	<jsp:forward page="salchance?flag=query"></jsp:forward>

</body>
</html>