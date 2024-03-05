<%@page import="com.org.dao.TeacherDao"%>
<%@page import="com.org.dto.Teacher"%>
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
						<p class="fs-4 text-center">Change password </p>
						<%
					String str=(String) session.getAttribute("success");
					if(str!= null){
					%>
					<p class="text-center text-success fs-4"> <%= str %></p>
					<%
					session.removeAttribute("success");
					} %>
					<%		Teacher teacher1= (Teacher)(session.getAttribute("teacherObj"));							
							TeacherDao dao = new TeacherDao();
							int id = teacher1.getId();
							Teacher t=dao.fetchTeacherById(id);
							
						%>
						<form action="../passwordUpdate" method="post">
							
							
							<div class="mb-3">
								<label class="form-label">Enter New Password</label> <input
									name="password" type="password" class="form-control" required>
									<input type="hidden"  name="Id" value="<%= t.getId() %>">
							</div>
							
							<button type="submit" class="btn bg-success text-white col-md-12">Change</button>
						</form>

						
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>