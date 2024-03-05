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
						<p class="fs-4 text-center">School Login </p>
							<% String str = (String)session.getAttribute("wrongOTP"); 
					if(str!=null){%>
						<p class="text-center text-success fs-4"><%=str %></p>
					<%session.removeAttribute("wrongOTP");
					}
					%>
					
						<form action="../verify_school_otp" >
							
							<div class="mb-3">
								<label class="form-label">Enter OTP</label> <input
									name="typedOTP" type="text" class="form-control" required>
							</div>
							
							
							<button type="submit" class="btn bg-success text-white col-md-12">Submit</button>
						</form>
						<%School school = (School)session.getAttribute("emailObj"); %>
						<p class ="fs-4">
							<a href="../school_otp?email=<%= school.getEmail()%>" class="text-decoration-none text-success">Resend OTP</a>
						</p>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>