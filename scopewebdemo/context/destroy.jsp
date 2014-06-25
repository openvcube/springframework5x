<%@ page  pageEncoding="GBK"  import="java.util.Enumeration"
	contentType="text/html; charset=GBK"%>

<%
		if(request.getParameter("destroy") != null)	{
			session.invalidate();					
		}
%>
		
<html>
<meta http-equiv="Content-Type" content="text/html;charset=gbk" />
<head>
<title>演练request、session作用范围的使用</title>
</head>
<body>
<a href="index.jsp">回到首页</a>
</body>
</html>
