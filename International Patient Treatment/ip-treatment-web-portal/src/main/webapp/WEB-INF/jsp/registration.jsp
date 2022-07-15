<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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

		<div class="row">
			<div class="offset-md-4 col-md-4 offset-lg-4 col-lg-4 text-center">
				<form id="contact" action="/registerSubmit" model="patient"  method="post">
					<h3>Patient Registration Form</h3>
					<h4>(Register to get the treatment schedule)</h4>
					<fieldset>
						<div class="form-group">
						<input class="form-control" pattern="[A-Za-z ]+" placeholder="Your name" name="name" type="text" tabindex="1" required
							>
							</div>
					</fieldset>
					<fieldset>
						<div class="form-group">
						<input class="form-control" min="0" max="150"  name="age" placeholder="Age" type="number" tabindex="2"
							required>
						</div>
					</fieldset>
					<fieldset>
						
						<div class="form-row">
							<div class="col">
								
								<label for="treatmentPackageName">Package Name:</label>
							</div>
							<div class="col">
								<div class="form-group">
								<input class="form-control" placeholder="Your name" value="${ pack }" name="treatmentPackageName" type="text" tabindex="1" required="true" readonly>
								</div>
							</div>
						</div>
					</fieldset>
					<fieldset>
						<div class="form-row">
							<div class="col">
								<label for="treatmentPackageName">Ailment:</label>
							</div>
							<div class="col">
								<div class="form-group">
						
								<input class="form-control" placeholder="Your name" value="${ ailment }" name="ailment" type="text" tabindex="1" required="true" readonly>
								 </div>
							</div>
						</div>
						
					</fieldset>
					<div class="form-row">
						<div class="col">
								<label for="treatmentPackageName">Cost:</label>
						</div>
						<div class="col">
							<div class="form-group">
						 		<input class="form control" type="text" id="cost" name="cost" value="${cost}" readonly>
						 	</div>
						 </div>
					 </div>
					
					<fieldset>
						<button name="submit" type="submit" id="contact-submit"
							data-submit="...Sending">Submit</button>
					</fieldset>
					
				</form>
			</div>
		</div>
	</div>

	
</body>
</html>