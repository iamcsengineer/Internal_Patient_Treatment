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
		<title>Insurer Page</title>
		<%@ include file="headlink.jsp"%>
		<link href="css/basic.css" rel="stylesheet" type="text/css">
		<script src="js/basic.js"></script>
		
	</head>
	<body>
		<div class="container-fluid">
		<%@ include file="header.jsp"%>
		
		
		<!-- Start Your code from here   -->
		
		<hr></hr>
		<h1 style="background-color: #002080;color:#ffffff;" class="text-center">Available Insurers</h1>
		<hr></hr>
			<div>
				<table class="table table-hover table-bordered">
				  <thead>
				    <tr>
				      <th scope="col">Sr No.</th>
				      <th scope="col">Insurance Provider Name</th>
				      <th scope="col">Insurance Package</th>
				      <th scope="col">Insurance Claim Amount</th>
				    </tr>
				  </thead>
				  <tbody>
				  <c:forEach items="${insurer}" var="plan">
				  <c:set var="count" value="${count + 1}" scope="page" />
				    <tr>
				      <th scope="row">${count}</th>
				      <td>${plan.insurerName}</td>
				      <td>${plan.insurerPackageName}</td>
				      <td>${plan.insuranceAmountLimit}</td>
				    </tr>
				   </c:forEach>
				  </tbody>
				</table>
			</div>
		
		</div>
	</body>
</html>