<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>${todo != null ? "Edit Task" : "Create Task"}</title>
<link href="./css/mdb.min.css" rel="stylesheet">
<link href="./css/login-style.css" rel="stylesheet">
</head>

<body>
	<section class="vh-100">
		<div class="container-fluid h-custom">
			<div
				class="row d-flex justify-content-center align-items-center h-100">
				<div class="col-md-9 col-lg-6 col-xl-5">
					<img
						src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/draw2.webp"
						class="img-fluid" alt="Sample image">
				</div>
				<div class="col-md-8 col-lg-6 col-xl-4 offset-xl-1">
					<form method="post" action="./todo-form">
						<div class="d-flex align-items-center mb-3 pb-1">
							<i class="fas fa-cubes fa-2x me-3" style="color: #ff6219;"></i> <span
								class="h1 fw-bold mb-0">TODO Application</span>
						</div>
						<h5 class="fw-normal mb-3 pb-3" style="letter-spacing: 1px;">
							${todo != null ? "Edit Task" : "Create Task"}</h5>
						<c:if test="${todo != null}">
							<input type="hidden" name="id" value="${todo.id}" />
						</c:if>
						<div class="form-outline mb-4">
							<input id="name" class="form-control form-control-lg"
								placeholder="Enter a valid name" name="name"
								value="${todo.name}" /> <label class="form-label" for="name">Task
								name</label>
						</div>
						<div class="form-outline mb-4">
							<input id="planStart" class="form-control form-control-lg"
								placeholder="YYYY-MM-dd" name="planStart"
								value="${todo.planEnd}" /> <label class="form-label"
								for="planEnd">Plan Start</label>
						</div>
						<div class="form-outline mb-4">
							<input id="planEnd" class="form-control form-control-lg"
								placeholder="YYYY-MM-dd" name="planEnd" value="${todo.planEnd}" />
							<label class="form-label" for="planEnd">Plan End</label>
						</div>
						<div class="form-group mb-4">
							<label class="form-label" for="status">Status</label> <select
								id="status" class="form-select" name="status">
								<option value="-1">Choose a status...</option>
								<option value="0" ${todo.status eq 0 ? "selected" : ""}>Reject
								</option>
								<option value="1" ${todo.status eq 1 ? "selected" : ""}>To
									Do</option>
								<option value="2" ${todo.status eq 2 ? "selected" : ""}>In
									Progress</option>
								<option value="3" ${todo.status eq 3 ? "selected" : ""}>Done</option>
							</select> <span class="form-message" style="color: red"></span>
						</div>
						<div class="form-outline mb-3">
							<div class="form-outline">
								<textarea id="description" class="form-control"
									name="description" rows="4">${todo.description}</textarea>
								<label class="form-label" for="description">Description</label>
							</div>
						</div>
						<div class="text-center text-lg-start mt-4 pt-2">
							<button type="submit" class="btn btn-primary btn-lg"
								style="padding-left: 2.5rem; padding-right: 2.5rem;">Submit</button>
						</div>
					</form>
				</div>
			</div>
		</div>
		<div
			class="d-flex flex-column flex-md-row text-center text-md-start justify-content-between py-4 px-4 px-xl-5 bg-primary">
			<!-- Copyright -->
			<div class="text-white mb-3 mb-md-0">Copyright © FE4F7.PRJ301</div>
			<!-- Copyright -->

			<!-- Right -->
			<div>
				<a href="#!" class="text-white me-4"> <i
					class="fab fa-facebook-f"></i>
				</a> <a href="#!" class="text-white me-4"> <i class="fab fa-twitter"></i>
				</a> <a href="#!" class="text-white me-4"> <i class="fab fa-google"></i>
				</a> <a href="#!" class="text-white"> <i class="fab fa-linkedin-in"></i>
				</a>
			</div>
			<!-- Right -->
		</div>
	</section>
	<script type="text/javascript" src="./js/mdb.min.js"></script>
	<script type="text/javascript">
		$(function() {
			$('#datepicker').datepicker();
		});
	</script>
</body>

</html>