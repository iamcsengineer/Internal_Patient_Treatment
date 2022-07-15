<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
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
		<hr/>
		<h1 style="background-color: #002080;color:#ffffff;" class="text-center">Summary</h1>
		<hr/>
	
    
    <div class="row">
        <div class="col-md-12">
            <div class="card mx-auto final">
                <div class="card-header">
                    <h3 class="text-xs-center"><strong>Order summary</strong></h3>
                </div>
                <div class="card-block">
                    <div class="table-responsive">
                        <table class="table table-sm">
                            <thead>
                                <tr>
                                    <td></td>
                                    <td class="text-xs-center"><strong>Pricing</strong></td>
                                   
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td >Total Cost</td>
                              
                                    <td class="text-xs-center">₹${total}</td>
      
                                </tr>
                                <tr>
                                    <td>Insurance</td>
                                   
                                    <td class="text-xs-right">₹${InsurAmt }</td>
                                </tr>
                                
                                <tr>
                                
                                    <td class="highrow">To be Paid</td>
                                    <td class="highrow text-xs-right">₹${Outstanding}</td> -->
                                </tr>
                               
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>


<style>
.height {
    min-height: 200px;
}

.icon {
    font-size: 47px;
    color: #5CB85C;
}

.iconbig {
    font-size: 77px;
    color: #5CB85C;
}
.final{
width:500px;
height:300px;
}
.table > tbody > tr > .emptyrow {
    border-top: none;
}

.table > thead > tr > .emptyrow {
    border-bottom: none;
}

.table > tbody > tr > .highrow {
    border-top: 3px solid;
}
</style>
		</div>
	</body>
</html>