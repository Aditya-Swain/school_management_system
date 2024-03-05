<%@page import="com.org.dto.Teacher"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../components/allcss.jsp" %>
</head>
<body>
<%@ include file="../components/teacher_navbar.jsp" %>

<% Teacher teacher1  = (Teacher)session.getAttribute("teacherObj");
String status = teacher1.getStatus();
if(status.equalsIgnoreCase("inactive")){
	response.sendRedirect("../components/blocked.jsp");
} else{
%>


		<h1>Welcome To Home Page</h1>
		<% }%><img src="../img/teacher.jpeg" style="height:100%;width:100%">
</body>
</html>