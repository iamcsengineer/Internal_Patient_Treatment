<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ include file="headlink.jsp"%>
		
		<script src="js/basic.js"></script>
<title>ERROR</title>
</head>
<style>
body{background-image: url('/images/error.jpg');
background-repeat: no-repeat;
background-color: #f2f2f2;
background-size:cover;
}
</style>
<body>
<div style="margin:10px 0px 0px 20px">
<!-- <h1 >Something went wrong! </h1>
<h4>Looks like this page is missing. Don't worry though. Our Best man is on the case.</h4>  -->
<a href="/admindashboard"><button type="button" class="btn btn-success">GO HOME</button></a>
</div>


</body>
</html>