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
<%@ include file="../components/principal_navbar.jsp" %>
<div class="container p-5">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-4 text-center">student Update</p>
						<%
							int id = Integer.parseInt((request.getParameter("id")));
							StudentDao dao = new StudentDao();
							Student	student =  dao.fetchStudentById(id);
						%>
						<form action="../student_update" method="post">
							<div class="mb-3">
								<label class="form-label">Name</label> <input name="name"
									type="text" value="<%=student.getName()%>" class="form-control" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Age</label> <input name="age"
									type="text" value="<%=student.getAge()%>" class="form-control" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Mobile</label> <input
									name="mobile" value="<%=student.getMobile()%>" type="text" class="form-control" required>
							</div>
							
							<div class="mb-3">
								<label class="form-label">Email Address</label> <input
									name="email" type="email" value="<%=student.getEmail()%>" class="form-control" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Password</label> <input
									name="password" type="password" value="<%=student.getPassword()%>" class="form-control" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Course</label>
								
								<select name="course" class="form-control">
								
								
								<%
										TeacherDao dao1 = new TeacherDao();							
										List<Teacher> list = dao1.fetchAllTeacher();
										
										for(Teacher t : list){%>
											<option value="<%=t.getSubject() %>"><%=t.getSubject() %></option>
										<% }
								%>
								
								
								
								</select>
								
							</div>
							<div class="mb-3">
								<label class="form-label">Address</label> <input
									name="address" type="text" value="<%=student.getAddress()%>" class="form-control" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Status</label> <input
									name="status" type="text" value="<%=student.getStatus()%>" class="form-control" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Mark</label> <input
									name="mark" type="text" value="<%=student.getMarks()%>" class="form-control" required>
							</div>
							<%Principal principal = (Principal)session.getAttribute("principalObj"); %>
							<input type="hidden" name="pId" value="<%= principal.getId()%>">
							<input type="hidden" name="sId" value="<%=student.getId()%>">
							
							<button type="submit" class="btn bg-success text-white col-md-12">Update</button>
						</form>

						
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>