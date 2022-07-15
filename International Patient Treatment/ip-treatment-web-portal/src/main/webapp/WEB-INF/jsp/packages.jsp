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
		<title>Package Page</title>
		<%@ include file="headlink.jsp"%>
		<link href="css/basic.css" rel="stylesheet" type="text/css">
		<script src="js/basic.js"></script>
		
	</head>
	<body>
		<div class="container-fluid">
		<%@ include file="header.jsp"%>
		
		
		<!-- Start Your code from here   -->
		<hr></hr>
		<h1 style="background-color: #002080;color:#ffffff;" class="text-center">Available Packages</h1>
		<hr></hr>
			<div>
				<table class="table table-hover table-bordered">
				  <thead>
				    
				      <th scope="col">Ailment</th>
				     <th scope="col">Package</th>
					   <th>Test Detail</th>
					   <th>Cost</th>
					   <th>Duration in weeks</th>
				   </tr> 
				   </tr>
				   </th>
				  </thead>
				  <tbody>
				    <tr>
				<c:forEach items="${package}" var="p">
				<tr>
				<td class="col-left"> <c:out value="${p.ailmentCategory}"/></td>
				<td class="col-right"> <c:out value="${p.packageDetail.treatmentPackageName}"/></td>
				<td class="col-right"> <c:out value="${p.packageDetail.testDetails}"/></td>
				<td class="col-right"> <c:out value="${p.packageDetail.cost}"/></td>
				<td class="col-right"> <c:out value="${p.packageDetail.treatmentDurationInWeeks}"/></td>
				<td class="col-right">
					<form method="post" action="/register">
									 <input type="hidden" id="packName" name="pName" value="${p.packageDetail.treatmentPackageName}">
									  <input type="hidden" id="ptId" name="pId" value="${pId}">
									   <input type="hidden" id="ailName" name="aName" value="${p.ailmentCategory}">
									   <input type="hidden" id="cost" name="cost" value="${p.packageDetail.cost}">
									 <button class="btn btn-info" name="submit" onclick="return view('cost${count}')" type="submit" id="submit">Register Patient</button>
					</form>
				
				</td>

				</tr>
				</c:forEach>
				    </tr>
				   
				  </tbody>
				</table>
			</div>
		
		</div>
		
		
	</body>
</html>