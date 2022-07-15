


<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<head>
<title>Insurer Page</title>
<%@ include file="headlink.jsp"%>
<link href="css/basic.css" rel="stylesheet" type="text/css">
<script src="js/basic.js"></script>

</head>
<body>
	<div class="container-fluid ">
		<%@ include file="header.jsp"%>


		<!-- Start Your code from here   -->

		<hr></hr>
		<h1 style="background-color: #002080; color: #ffffff;"
			class="text-center">Specialist Details</h1>
		<hr></hr>
		<div class="row  mx-auto-4">


			<c:forEach items="${specialist}" var="spec">
				<c:set var="count" value="${count + 1}" scope="page" />

				<div class="col-sm-3">
					<div class="card " style="width: 18rem;">
						<div class="card-header">${count}</div>
						<ul class="list-group list-group-flush">
							<li class="list-group-item">Name: ${spec.name}</li>
							<li class="list-group-item">Area of Expertise:
								${spec.areaOfExpertise}</li>
							<li class="list-group-item">Experience:
								${spec.experienceInYears}</li>
							<li class="list-group-item">Contact: ${spec.contactNumber}</li>
						</ul>
					</div>
				</div>



			</c:forEach>
		</div>

	</div>


</body>
</html>