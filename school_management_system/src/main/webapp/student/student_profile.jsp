<%@page import="com.org.dto.Teacher"%>
<%@page import="java.util.List"%>
<%@page import="com.org.dao.TeacherDao"%>
<%@page import="com.org.dto.Student"%>
<%@page import="com.org.dao.StudentDao"%>
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
<%@ include file="../components/student_navbar.jsp" %>
<div class="container p-5">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card paint-card">
					<div class="card-body">
					<%
				Student s =	new StudentDao().fetchStudentById(((Student)session.getAttribute("studentObj")).getId());
				
					%>
						<p class="fs-4 text-center"><%= s.getName() %>'s Profile</p>
						<%
					String str=(String) session.getAttribute("success");
					if(str!= null){
					%>
					<p class="text-center text-success fs-4"> <%= str %></p>
					<%
					session.removeAttribute("success");
					} %>
						<form action="../student_profile" method="post">
							<div class="mb-3">
								<label class="form-label">Name</label> <input name="name"
									type="text" value="<%=s.getName()%>" class="form-control" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Age</label> <input name="age"
									type="text" value="<%=s.getAge()%>" class="form-control" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Mobile</label> <input
									name="mobile" value="<%=s.getMobile()%>" type="text" class="form-control" required>
							</div>
							
							<div class="mb-3">
								<label class="form-label">Email Address</label> <input
									name="email" type="email" value="<%=s.getEmail()%>" class="form-control" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Password</label> <input
									name="password" type="password" value="<%=s.getPassword()%>" class="form-control" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Course</label>
								 <input
									name="address" type="text" value="<%=s.getCourse()%>" readonly="readonly" class="form-control" required>

							</div>
							<div class="mb-3">
								<label class="form-label">Address</label> <input
									name="address" type="text" value="<%=s.getAddress()%>" class="form-control" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Status</label> <input
									name="status" type="text" value="<%=s.getStatus()%>" readonly="readonly" class="form-control" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Mark</label> <input
									name="mark" type="text" value="<%=s.getMarks()%>" readonly="readonly" class="form-control" required>
							</div>
							
							<input type="hidden" name="studentId" value="<%=s.getId()%>">
							
							<button type="submit" class="btn bg-success text-white col-md-12">Update</button>
						</form>

						
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>