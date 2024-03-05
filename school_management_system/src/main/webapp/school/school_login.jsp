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
							<% String str = (String)session.getAttribute("invalid"); 
					if(str!=null){%>
						<p class="text-center text-success fs-4"><%=str %></p>
					<%session.removeAttribute("invalid");
					}
					%>
					<%
					String str1=(String) session.getAttribute("valid");
					if(str1!= null){
					%>
					<p class="text-center text-success fs-3"> <%= str1 %></p>
					<%
					session.removeAttribute("valid");
					} %>
					
						<form action="../school_login" method="post">
							
							<div class="mb-3">
								<label class="form-label">Email Address</label> <input
									name="email" type="email" class="form-control" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Password</label> <input
									name="password" type="password" class="form-control" required>
							</div>
							
							<button type="submit" class="btn bg-success text-white col-md-12">Login</button>
						</form>

						<p class ="fs-4">
							<a href="verify_email.jsp" class="text-decoration-none text-success">Forgot Password ?</a>
						</p>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>