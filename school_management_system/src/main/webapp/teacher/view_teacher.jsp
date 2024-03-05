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
<%@ include file="../components/teacher_navbar.jsp" %>
<div class="container p-5">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card paint-card">
					<div class="card-body">
					<%
						/* Teacher teacher1 = (Teacher)session.getAttribute("teacherObj");
					int id = teacher1.getId();
					new TeacherDao().fetchTeacherById(id); */
					
					Teacher teacher1 = new TeacherDao().fetchTeacherById(((Teacher)session.getAttribute("teacherObj")).getId());
						%>
						<p class="fs-4 text-center"><%=teacher1.getName() %>'s Profile</p>
						<%
					String str=(String) session.getAttribute("success");
					if(str!= null){
					%>
					<p class="text-center text-success fs-4"> <%= str %></p>
					<%
					session.removeAttribute("success");
					} %>
						<form action="../teacherUpdate" method="post">
							<div class="mb-3">
								<label class="form-label">Name</label> <input name="name"
									type="text" value="<%=teacher1.getName()%>" class="form-control" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Age</label> <input name="age"
									type="text" value="<%=teacher1.getAge()%>" class="form-control" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Mobile</label> <input
									name="mobile" value="<%=teacher1.getMobile()%>" type="text" class="form-control" required>
							</div>
							
							<div class="mb-3">
								<label class="form-label">Email Address</label> <input
									name="email" type="email" value="<%=teacher1.getEmail()%>" class="form-control" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Password</label> <input
									name="password" type="password" value="<%=teacher1.getPassword()%>" readonly="readonly" class="form-control" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Subject</label> <input
									name="subject" type="text" value="<%=teacher1.getSubject()%>" readonly="readonly" class="form-control" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Salary</label> <input
									name="salary" type="text" value="<%=teacher1.getSalary()%>" readonly="readonly" class="form-control" required>
							</div>
							<input type="hidden" name="teacherId" value="<%= teacher1.getId()%>">
								<button type="submit" class="btn bg-success text-white col-md-12">Update</button>
							
						</form>

						
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>