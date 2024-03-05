<%@page import="com.org.dto.Student"%>
<nav class="navbar navbar-expand-lg navbar-dark bg-success">
	<div class="container-fluid">
		<a class="navbar-brand" href="../main/index.jsp"><i class="fa-solid fa-school"></i>MoSchool</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav ms-auto mb-2 mb-lg-0">
			<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="student_home.jsp"><i class="fas fa-home"></i>Home</a></li>
			
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="student_profile.jsp"> View Profile</a></li>

				
			</ul>
			<div class="dropdown">
				<button class="btn btn-secondary dropdown-toggle" type="button"
					id="dropdownMenuButton1" data-bs-toggle="dropdown"
					aria-expanded="false"><%Student student = (Student)session.getAttribute("studentObj"); %><%= student.getName() %></button>
				<ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
					<li><a class="dropdown-item" href="../student_logout">Logout</a></li>
				</ul>
			</div>

		</div>
	</div>
</nav>