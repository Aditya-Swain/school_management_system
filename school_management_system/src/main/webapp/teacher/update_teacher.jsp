<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@page import="com.org.dto.Teacher"%>
<%@page import="com.org.dao.TeacherDao"%>
<%@page import="com.org.dto.Principal"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../components/allcss.jsp" %>
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
<div class="container p-5">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-4 text-center">Teacher Update</p>
						<%
							int id = Integer.parseInt((request.getParameter("id")));
							TeacherDao dao = new TeacherDao();
							Teacher	teacher =  dao.fetchTeacherById(id);
						%>
						<form action="../teacher_Update" method="post">
							<div class="mb-3">
								<label class="form-label">Name</label> <input name="name"
									type="text" value="<%=teacher.getName()%>" class="form-control" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Age</label> <input name="age"
									type="text" value="<%=teacher.getAge()%>" class="form-control" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Mobile</label> <input
									name="mobile" value="<%=teacher.getMobile()%>" type="text" class="form-control" required>
							</div>
							
							<div class="mb-3">
								<label class="form-label">Email Address</label> <input
									name="email" type="email" value="<%=teacher.getEmail()%>" class="form-control" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Password</label> <input
									name="password" type="password" value="<%=teacher.getPassword()%>" readonly="readonly" class="form-control" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Subject</label> <input
									name="subject" type="text" value="<%=teacher.getSubject()%>" readonly="readonly" class="form-control" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Salary</label> <input
									name="salary" type="text" value="<%=teacher.getSalary()%>" class="form-control" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Status</label> <input
									name="status" type="text" value="<%=teacher.getStatus()%>" class="form-control" required>
							</div>
							<input type="hidden" name="teacherId" value="<%=teacher.getId()%>">
						
							<button type="submit" class="btn bg-success text-white col-md-12">Update</button>
						</form>

						
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>