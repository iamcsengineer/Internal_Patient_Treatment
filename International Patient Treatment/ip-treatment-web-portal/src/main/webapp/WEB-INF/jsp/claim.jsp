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
		<script type="text/javascript"> 
        window.history.forward(); 
        function noBack() { 
            window.history.forward(); 
        } 
    </script>
		
	</head>
	<body>
		<div class="container-fluid">
		<%@ include file="header.jsp"%>

		<hr></hr>
		<h1 style="background-color: #002080;color:#ffffff;" class="text-center">Claim insurance</h1>
		<hr></hr>
		
			<div>
				 <c:set var="count" value="0" scope="page" />
				<table class="table table-hover table-bordered">
				  <thead>
				    	<th scope="col">S.No.</th>
				      <th scope="col">Insurer name</th>
				     <th scope="col">Package Name</th>
					   <th scope="col">Insurance Amount Limit</th>
					   <th scope="col">Disbursement Duration</th>
				  
				  </thead>
				  <tbody>
				    <tr>
				
				<c:forEach items="${insurers}" var="i">
					<c:set var="count" value="${count + 1}" scope="page" />				
			<tr>
				<td class="col-left"> ${count}</td>
				<td class="col-left"> <c:out value="${i.insurerName}"/></td>
				<td class="col-right"> <c:out value="${i.insurerPackageName}"/></td>
				<td class="col-right"> <c:out value="${i.insuranceAmountLimit}"/></td>
				<td class="col-right"> <c:out value="${i.disbursementDuration}"/></td>
				<td class="col-right">
								<form method="post" action="/initiateClaim">
									 <input type="hidden" id="pckgName" name="pckgName" value="${i.insurerPackageName}">
									  <input type="hidden" id="ptId" name="ptId" value="<%=request.getParameter("id")%>">
									 <button class="btn btn-info" name="submit"  type="submit" id="submit">Initiate Claim</button>
								</form> </td>

				</tr>
				</c:forEach>
				    </tr>
				   
				  </tbody>
				</table>
			</div>
	</div>
		
		
	</body>
</html>