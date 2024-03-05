<%@page import="com.org.dto.Principal"%>
<%@page import="com.org.dto.Teacher"%>
<%@page import="java.util.List"%>
<%@page import="com.org.dao.TeacherDao"%>
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
						<p class="fs-4 text-center">Student Register </p>
						<%
					String str=(String) session.getAttribute("success");
					if(str!= null){
					%>
					<p class="text-center text-success fs-4"> <%= str %></p>
					<%
					session.removeAttribute("success");
					} %>
						<form action="../student_register" method="post">
							<div class="mb-3">
								<label class="form-label">Name</label> <input name="name"
									type="text" class="form-control" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Age</label> <input name="age"
									type="text" class="form-control" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Mobile</label> <input
									name="mobile" type="text" class="form-control" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Email Address</label> <input
									name="email" type="email" class="form-control" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Password</label> <input
									name="password" type="password" class="form-control" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Course</label>
								
								<select name="course" class="form-control">
								
								
								<%
										TeacherDao dao = new TeacherDao();							
										List<Teacher> list = dao.fetchAllTeacher();
										
										for(Teacher t : list){%>
											<option value="<%=t.getId() %>"><%=t.getSubject() %></option>
										<% }
								%>
								
								
								
								</select>
								
							</div>
							<div class="mb-3">
								<label class="form-label">Address</label> <input
									name="address" type="text" class="form-control" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Status</label> <input
									name="status" type="text" class="form-control" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Mark</label> <input
									name="mark" type="text" class="form-control" required>
							</div>
							<%Principal principal=(Principal)session.getAttribute("principalObj"); %>
							<input type="hidden" name="pId" value="<%= principal.getId()%>">
							<button type="submit" class="btn bg-success text-white col-md-12">Register</button>
						</form>

						<p class ="fs-4">
							Already have an account ?<a href="student_login.jsp" class="text-decoration-none text-success">Login</a>
						</p>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>