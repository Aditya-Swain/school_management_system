
<%@page import="com.org.dto.Principal"%>
<%@page import="java.util.List"%>
<%@page import="com.org.dao.PrincipalDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ include file="../components/allcss.jsp"%>
<style type="text/css">
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}
</style>
</head>
<body>
<%@ include file = "../components/school_navbar.jsp" %>
	<div class="container p-3">
		<div class="row">
			<div class="col-md-12">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-3 text-center">Principal Details</p>

						<table class="table">
							<thead>
								<tr>
									<th>Full Name</th>
									<th>Age</th>
									<th>Email</th>
									<th>Mobile</th>
									<th>Qualification</th>
								</tr>
							</thead>
							<tbody>
								<%
									PrincipalDao dao = new PrincipalDao();
								List<Principal> Principals = dao.fetchAllPrincipal();
								
								for(Principal t : Principals){%>
									<tr>
										<td><%= t.getName() %></td>	
										<td><%= t.getAge() %></td>		
										<td><%= t.getEmail() %></td>		
										<td><%= t.getMobile() %></td>		
										<td><%= t.getQualification() %></td>		
										<td> <a href="#" class="btn btn-sm btn-primary">update</a> 
									     <a href="#"  class="btn btn-sm btn-danger">delete</a>
									</td>	
																		
									
									</tr>
								<% }
								%>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>