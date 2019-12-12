<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Product</title>
<link rel="stylesheet"
	href="<c:url value="/resources/bootstrap/css/bootstrap.min.css"/>">
<script src="<c:url value="/resources/js/jquery.js"/>"></script>
<script src="<c:url value="/resources/bootstrap/js/bootstrap.min.js"/>"></script>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/register.css"/>">
<link rel="icon" type="image/x-icon" href="<c:url value="/resources/images/favicon1.png"/>" />
</head>
<body>
	<%@ include file="navbar.jsp"%>
	<div class="container" style="margin-bottom:19px">
		<h1 class="well">Add Product !</h1>
		<div class="col-lg-12 well">
			<div class="row">

				<!--  RegisterServlet  form -->
				<c:url value="/admin/product/addProduct" var="url"></c:url>
				<form:form method="post" action="${url}" commandName="product" enctype="multipart/form-data" modelAttribute="product">
					<div class="col-sm-12">
						<div class="row">
							<div class="col-sm-6 form-group">
								<form:label path="prodId">Product Id</form:label>
								 <form:input type="text" name="prodId"
									placeholder="Enter ProductId.." class="form-control"
									path="prodId" disabled="true"></form:input>
							</div>
							<div class="col-sm-6 form-group">
								<form:label path="prodName">Product Name</form:label>
								 <form:input type="text" name="prodName"
									placeholder="Enter Product Name.." class="form-control"
									path="prodName"></form:input>
								 <form:errors path="prodName"></form:errors>
							</div>
						</div>
						<div class="form-group">
						<form:label path="prodDescription">Product Description</form:label>
								 <form:textarea type="text" name="prodDescription"
									placeholder="Enter Product Description.." class="form-control"
									path="prodDescription"></form:textarea>
						</div>
						<div class="form-group">
						<form:label path="prodCategory" name="prodCategory">Product Category</form:label>
								 <form:radiobutton path="prodCategory" value="Android"/>Electronics
								 <form:radiobutton path="prodCategory" value="Windows"/>Household
								 <form:radiobutton path="prodCategory" value="Linux"/>Groceries
								 <form:radiobutton path="prodCategory" value="Mac"/>Others
						</div>
						<div class="row">
							<div class="col-sm-4 form-group">
								<form:label path="prodManufacturer">Product Manufacturer</form:label>
								 <form:input type="text" name="prodManufacturer"
									placeholder="Enter Product Manufacurer.." class="form-control"
									path="prodManufacturer"></form:input>
							</div>
							<div class="col-sm-4 form-group">
								<form:label path="productPrice">Product Price</form:label>
								 <form:input type="text" name="productPrice"
									placeholder="Enter Product Price.." class="form-control"
									path="productPrice"></form:input>
								 <form:errors path="productPrice"></form:errors>
							</div>
							<div class="col-sm-4 form-group">
								<form:label path="unitStock">Number of Products</form:label>
								 <form:input type="text" name="unitStock"
									placeholder="Number of Products.." class="form-control"
									path="unitStock"></form:input>
							</div>
						</div>
					 	<div class="form-group">
						<form:label path="productImage">Product Image</form:label>
							<form:input type="file" path="productImage" name="productImage"/>
						</div>  
						<div class="form-actions">
							<button type="submit" class="btn btn-lg btn-info">Submit</button>
						</div>
					</div>
				</form:form>
			</div>
		</div>
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>