<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>     
<!doctype html>
<html lang="en">
	<head>
		<title></title>
		<%@ include file="headlink.jsp"%>
		<link href="css/basic.css" rel="stylesheet" type="text/css">
		<script src="js/basic.js"></script>
		
	</head>
	<body>
	<div class="container-fluid">
		<%@ include file="header.jsp"%>
				<hr></hr>
		<h1 style="background-color: #002080;color:#ffffff;" class="text-center">All Patients</h1>
		<hr></hr>
			<div>
				<c:set var="count" value="0" scope="page" />
				
				<table class="table table-hover table-bordered">
				  <thead>
				    <tr>
				      <th scope="col">S.No.</th>
				      <th scope="col">Name</th>
				      <th scope="col">Test Details</th>
				      <th scope="col">Package</th>
				       <th scope="col">Specialist</th>
				      <th scope="col">Cost</th>
				      <th scope="col">Start date</th>
				      <th scope="col">End date</th>
				       <th scope="col">Status</th>
				    </tr>
				  </thead>
				  <tbody>
				  <c:forEach items="${patient}" var="plan">
				  <c:set var="count" value="${count + 1}" scope="page" />				
				  
				    <tr>
				      <th scope="row">${count}</th>
				      <td>${plan.ptDetail.name}</td>
				      <td>${plan.testDetails}</td>
				      <td>${plan.packageName}</td>
				      <td>${plan.specialist}</td>
				      <td>${plan.cost}</td>
				      <td>${plan.treatmentCommencementDate}</td>
				      <td>${plan.treatmentEndDate}</td>
				      <td>${plan.status}</td>
				     
				    </tr>
				   </c:forEach>
				
				  </tbody>
				</table>
			</div>
	</div>
	</body>
</html>