<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="hello.servlet.domain.member.Member" %>
<html>
<head>
	<meta charset="UTF-8">
</head>
<body>
성공
<ul>
	<!-- 
	<li>id=<%=((Member)request.getAttribute("member")).getId()%></li>
	<li>age=<%=((Member)request.getAttribute("member")).getAge()%></li>
	<li>username=<%=((Member)request.getAttribute("member")).getUsername()%></li>
	-->
	<li>id=${member.id}</li>
	<li>age=${member.age}</li>
	<li>username=${member.username}</li>
</ul>
<a href="/index.html">메인</a>
</body>
</html>
