
<%@page import="com.org.dto.School"%>
<%@page import="com.org.dto.Teacher"%>
<%@page import="java.util.List"%>
<%@page import="com.org.dao.TeacherDao"%>
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
<% School school = (School)session.getAttribute("schoolObj"); 
	Principal principal = (Principal)session.getAttribute("principalObj");
	if(school!=null){%>
	<%@ include file = "../components/school_navbar.jsp" %>
	
	
<% }
else if(principal != null){%>
	<%@ include file = "../components/principal_navbar.jsp" %>

<%} %>

	<div class="container p-3">
		<div class="row">
			<div class="col-md-12">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-3 text-center">Teacher Details</p>

						<table class="table">
							<thead>
								<tr>
									<th>Full Name</th>
									<th>Age</th>
									<th>Email</th>
									<th>Mobile</th>
									<th>Status</th>
									<th>salary</th>
									<th>subject</th>
									<th>Action</th>
								</tr>
							</thead>
							<tbody>
								<%
									TeacherDao dao = new TeacherDao();
								List<Teacher> teachers = dao.fetchAllTeacher();
								
								for(Teacher t : teachers){%>
									<tr>
										<td><%= t.getName() %></td>	
										<td><%= t.getAge() %></td>		
										<td><%= t.getEmail() %></td>		
										<td><%= t.getMobile() %></td>		
										<td>
											<%
												String status = t.getStatus();
											if(status.equalsIgnoreCase("active")){%>
												<a class="btn btn-sm btn-danger" href="../update_teacher_status?id=<%= t.getId()%>"><i class="fa-solid fa-ban">Block</i></a>
										<% 	}
											else{%>
												<a class="btn btn-sm btn-success" href="../update_teacher_status?id=<%= t.getId()%>"><i class="fa-solid fa-circle-check">Unblock</i></a>
												
											<% }
											%>										
										
										</td>		
										<td><%= t.getSalary() %></td>		
										<td><%= t.getSubject() %></td>		
											<td> <a href="../teacher/update_teacher.jsp?id=<%= t.getId() %>" class="btn btn-sm btn-primary">update</a> 
									     <a href="../delete_teacher?id=<%= t.getId() %>"  class="btn btn-sm btn-danger">delete</a>
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