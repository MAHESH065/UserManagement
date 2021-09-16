<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html lang="en">
<head>

<!-- Required meta tags -->
<meta charset="ISO-8859-1">
<!-- <meta charset="utf-8"> -->
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
<script type="text/javascript"
	src="https://cdn.jsdelivr.net/jquery/latest/jquery.min.js"></script>
<script type="text/javascript"
	src="https://cdn.jsdelivr.net/momentjs/latest/moment.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>

<!-- Special version of Bootstrap that only affects content wrapped in .bootstrap-iso -->
<link rel="stylesheet"
	href="https://formden.com/static/cdn/bootstrap-iso.css" />

<!--Font Awesome (added because you use icons in your prepend/append)-->
<link rel="stylesheet"
	href="https://formden.com/static/cdn/font-awesome/4.4.0/css/font-awesome.min.css" />

<!-- Inline CSS based on choices in "Settings" tab -->
<style>
.bootstrap-iso .formden_header h2, .bootstrap-iso .formden_header p,
	.bootstrap-iso form {
	font-family: Arial, Helvetica, sans-serif;
	color: black
}

.bootstrap-iso form button, .bootstrap-iso form button:hover {
	color: white !important;
}

.asteriskField {
	color: red;
}
</style>

<!-- Extra JavaScript/CSS added manually in "Settings" tab -->
<script type="text/javascript"
	src="https://code.jquery.com/jquery-1.11.3.min.js"></script>


<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css" />

<script>
    $(document).ready(function(){
      var date_input=$('input[name="date"]'); 
      var container=$('.bootstrap-iso form').length>0 ? $('.bootstrap-iso form').parent() : "body";
      date_input.datepicker({
        format: 'dd/mm/yyyy',
        container: container,
        todayHighlight: true,
        autoclose: true,
      })
      
    })
</script>
<script type="text/javascript">
	function country_change()
	{
		var country = $("#country").val();
		alert("country"+country);
		$.ajax({
			type: "POST",
			url:"getAllState",
			data: "countryId="+country,
			cache: false,
			success: function(response)
			{
				
			}
		});
	}		
</script>

<title>Registration Form</title>
</head>
<body>
	<form:form action="#" method="POST" modelAttribute="user">
		<section class="vh-300" style="background-color: #2779e2;">
			<div class="container">
				<div
					class="row d-flex justify-content-center align-items-center h-100">
					<div class="col-xl-9">

						<h2 class="text-white mb-4 text-center">Registration Form</h2>

						<div class="card" style="border-radius: 10px;">
							<div class="card-body">

								<div class="row align-items-center pt-2 pb-2">
									<div class="col-md-3 ps-5">

										<h6 class="mb-0">First Name</h6>

									</div>
									<div class="col-md-9 pe-5">

										<input type="text" class="form-control form-control-lg"
											placeholder="Enter First Name" />

									</div>
								</div>

								<div class="row align-items-center pt-2 pb-2">
									<div class="col-md-3 ps-5">

										<h6 class="mb-0">Last Name</h6>

									</div>
									<div class="col-md-9 pe-5">

										<input type="text" class="form-control form-control-lg"
											placeholder="Enter Last Name" />

									</div>
								</div>

								<div class="row align-items-center py-2">
									<div class="col-md-3 ps-5">

										<h6 class="mb-0">Email address</h6>

									</div>
									<div class="col-md-9 pe-5">

										<input type="email" class="form-control form-control-lg"
											placeholder="example@example.com" />

									</div>
								</div>

								<div class="row align-items-center pt-2 pb-2">
									<div class="col-md-3 ps-5">

										<h6 class="mb-0">Phone No</h6>

									</div>
									<div class="col-md-9 pe-5">

										<input type="text" class="form-control form-control-lg"
											placeholder="Enter Phone No" />

									</div>
								</div>

								<div class="row align-items-center pt-2 pb-2">

									<div class="col-md-3 ps-5">
										<h6 class="mb-0">Date</h6>
									</div>

									<div class="col-md-9 pe-5">
										<input type="text" class="form-control form-control-lg"
											id="date" name="date" placeholder="DD/MM/YYYY" />

									</div>

								</div>

								<div class="row align-items-center pt-2 pb-2">

									<div class="col-md-3 ps-5">
										<h6 class="mb-0">Gender</h6>
									</div>
									<div class="col-md-9 pe-5">
										<div class="form-check form-check-inline">
											<input class="form-check-input" type="radio"
												name="inlineRadioOptions" id="male" value="option1" checked />
											<label class="form-check-label" for="male">Male</label>
										</div>

										<div class="form-check form-check-inline">
											<input class="form-check-input" type="radio"
												name="inlineRadioOptions" id="female" value="option2" /> <label
												class="form-check-label" for="female">Female</label>
										</div>
									</div>

								</div>

								<div class="row align-items-center pt-2 pb-2">
									<div class="col-md-3 ps-5">
										<h6 class="mb-0">Country</h6>
									</div>
									<div class="form-control-lg col-md-9 pe-5">
										<select class="select" >
											<option value="" selected="selected" id="country" onchange="country_change()">-Select Country-</option>
											<c:forEach var="country" items="${countryObjs}">
												<option value="${country.key}">${country.value}</option>
											</c:forEach>
										</select>
									</div>
								</div>

								<div class="row align-items-center pt-2 pb-2">
									<div class="col-md-3 ps-5">
										<h6 class="mb-0">State</h6>
									</div>
									<div class="form-control-lg col-md-9 pe-5">
										<select class="select">
											<option value="1">-Select State-</option>
											<option value="2">Option 1</option>
											<option value="3">Option 2</option>
											<option value="4">Option 3</option>
										</select>
									</div>
								</div>

								<div class="row align-items-center pt-2 pb-2">
									<div class="col-md-3 ps-5">
										<h6 class="mb-0">City</h6>
									</div>
									<div class="form-control-lg col-md-9 pe-5">
										<select class="select">
											<option value="1">-Select City-</option>
											<option value="2">Option 1</option>
											<option value="3">Option 2</option>
											<option value="4">Option 3</option>
										</select>
									</div>
								</div>


								<div class="px-5 py-4 text-center">
									<button type="button" class="btn btn-warning btn-lg">Reset
									</button>
									<button type="submit" class="btn btn-primary btn-lg ms-2">Register</button>
								</div>



							</div>
						</div>

					</div>
				</div>
			</div>
		</section>

	</form:form>
	<script>
    $(document).ready(function(){
      var date_input=$('input[name="date"]'); 
      var container=$('.bootstrap-iso form').length>0 ? $('.bootstrap-iso form').parent() : "body";
      var options={
        format: 'dd/mm/yyyy',
        container: container,
        todayHighlight: true,
        autoclose: true,
      };
      date_input.datepicker(options);
    })
</script>
</body>
</html>


