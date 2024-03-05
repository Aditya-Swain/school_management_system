<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../components/allcss.jsp"  %>
</head>
<body >
<% School school  = (School)session.getAttribute("schoolObj");

if(school==null){
	response.sendRedirect("school_login.jsp");
} else{
%>

<%@include file="../components/school_navbar.jsp" %>
		<h1>Welcome To Home Page</h1>
		
		<%} %>
		
		<img src="../img/school_home.jpeg" style="height:100%;width:100%">
		
</body>
</html>