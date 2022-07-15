


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Dashboard</title>
<%@ include file="headlink.jsp"%>
<link href="css/basic.css" rel="stylesheet" type="text/css">
<script src="js/basic.js"></script>

</head>
<body>
	<!-- <header> -->
	<!-- 		<nav class="navbar navbar-expand-lg navbar-light bg-light"> -->
	<!--   <a class="navbar-brand" href="#"><img -->
	<!-- 			src="https://media.istockphoto.com/vectors/medical-hospital-plus-sign-map-pointer-icon-vector-id1277216918?k=6&m=1277216918&s=170667a&w=0&h=_CQyN-gVkTFv6pYkm_5-QRgW0qyq8l-dWVZsQ1R-dOo=" -->
	<!-- 			height="50px" width="50px">IPTMS</a> -->
	<!--   <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation"> -->
	<!--     <span class="navbar-toggler-icon"></span> -->
	<!--   </button> -->
	<!-- <!-- 		<div class="collapse navbar-collapse" id="navbarResponsive"> -->
	-->
	<!-- <div class="collapse navbar-collapse" id="navbarNav"> -->
	<!-- 			<ul class="navbar-nav ml-auto"> -->
	<!-- 			<li class="nav-item"><a class="nav-link js-scroll-trigger" -->
	<!-- 					href="/logout">Logout</a></li> -->
	<!-- 			</ul> -->
	<!-- 		</div> -->

	<!-- 	</nav> -->
	<!-- </header> -->

	<header>
		<!-- <nav class="navbar navbar-expand-lg navbar-dark bg-dark"
		id="mainNav">
		<a class="navbar-brand js-scroll-trigger" href="/">IPTMS</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarResponsive" aria-controls="navbarResponsive"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button> -->
		<!-- 		<nav class="navbar navbar-expand-lg navbar-light bg-light"> -->
		<!--   <a class="navbar-brand" href="#"><img -->
		<!-- 			src="https://media.istockphoto.com/vectors/medical-hospital-plus-sign-map-pointer-icon-vector-id1277216918?k=6&m=1277216918&s=170667a&w=0&h=_CQyN-gVkTFv6pYkm_5-QRgW0qyq8l-dWVZsQ1R-dOo=" -->
		<!-- 			height="50px" width="50px">IPTMS</a> -->
		<!--   <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation"> -->
		<!--     <span class="navbar-toggler-icon"></span> -->
		<!--   </button> -->
		<!-- 		<div class="collapse navbar-collapse" id="navbarResponsive"> -->


		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<a class="navbar-brand" href="#"><img
				src="https://image.shutterstock.com/image-vector/hands-cross-vector-illustration-logo-260nw-612463019.jpg"
				height="70px" width="70px"><strong>International
					Patient Management System</strong></a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarNav" aria-controls="navbarNav"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<!-- 		<div class="collapse navbar-collapse" id="navbarResponsive"> -->

			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item"><a class="nav-link js-scroll-trigger"
						href="/logout">Logout</a></li>
				</ul>
			</div>
		</nav>
	</header>
	<div style="background-color: #002080; color: #ffffff;">
		<h1 style="text-align: center; font-family: serif;">
			<b>WELCOME</b>
		</h1>
	</div>
	<br>
	<br>


	<div
		class="row row-cols-1 row-cols-sm-2 row-cols-lg-3 d-flex align-items-center card-align-center">
		<div class="col mb-3">
			<a href="/specialist">
				<div class="card">
					<div class="card-body">
						<img class="card-img-top" src="/images/specialist.png">
						<div class="card-title">
							<h6>
								<b>View Specialists</b>
							</h6>
						</div>
					</div>
				</div>
			</a>
		</div>
		<div class="col mb-3">
			<a href="/packages">
				<div class="card">
					<div class="card-body">
						<img class="card-img-top" src="/images/treatments.png">
						<div class="card-title">
							<h6>
								<b>View Treatments</b>
							</h6>
						</div>
					</div>
				</div>
			</a>
		</div>

		<div class="col mb-3">
			<a href="/patients">
				<div class="card">
					<div class="card-body">
						<img class="card-img-top" src="/images/patient-care.png">
						<div class="card-title">
							<h6>
								<b>View Patients</b>
							</h6>
						</div>
					</div>
				</div>
			</a>
		</div>

		<div class="col mb-3">
			<a href="/insurer">
				<div class="card">
					<div class="card-body">
						<img class="card-img-top" src="/images/insurance.png">
						<div class="card-title">
							<h6>
								<b>View Insurance Providers</b>
							</h6>
						</div>
					</div>
				</div>
			</a>
		</div>


		<div class="col mb-3">
			<a href="/ongoingTreatments">
				<div class="card">
					<div class="card-body">
						<img class="card-img-top" src="/images/edit-treatment.png">
						<div class="card-title">
							<h6>
								<b>Edit Treatment Plan</b>
							</h6>
						</div>
					</div>
				</div>
			</a>
		</div>
		<div class="col mb-3">
			<a href="/ongoingTreatmentsnew">
				<div class="card">
					<div class="card-body">
						<img class="card-img-top" src="/images/plan.jpg">
						<div class="card-title">
							<h6>
								<b>View All Plans</b>
							</h6>
						</div>
					</div>
				</div>
			</a>
		</div>
	</div>


</body>
</html>