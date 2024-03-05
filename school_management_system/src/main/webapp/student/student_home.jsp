<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../components/allcss.jsp"  %>
</head>
<body>
<% Student std  = (Student)session.getAttribute("studentObj");
	String status =std.getStatus();
if(status.equalsIgnoreCase("inactive")){
	response.sendRedirect("../components/blocked.jsp");
} else{
%>

<%@include file="../components/student_navbar.jsp" %>
		<h1>Welcome To Home Page</h1>
		
		<%} %><img src="../img/student.jpg" style="height:100%;width:100%">
</body>
</html>