<%@page import="com.org.dto.Teacher"%>
<%@page import="com.org.dto.Student"%>
<%@page import="com.org.dto.Principal"%>
<%@page import="com.org.dto.School"%>
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
<%@ include file="../components/navbar.jsp" %>
<div class="container p-5">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-4 text-center">Teacher Login </p>
							
					
						<form action="../update_teacher_password" >
							
							<div class="mb-3">
								<label class="form-label">Enter New Password</label> <input
									name="newPwd" type="text" class="form-control" required>
							</div>
							<%Teacher teacher =(Teacher) session.getAttribute("teacherEmail"); %>
							<input type="hidden" name="sid" value="<%= teacher.getId()%>">
							
							
							<button type="submit" class="btn bg-success text-white col-md-12">Submit</button>
						</form>
						
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>