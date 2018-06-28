<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="_shareLayout/header.jsp"></jsp:include>
</head>
<body class="hold-transition sidebar-mini">
	<div class="wrapper">
		<jsp:include page="_shareLayout/_navbar.jsp"></jsp:include>
		<jsp:include page="_shareLayout/_sidebar.jsp"></jsp:include>
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<div class="container-fluid">
					<div class="row mb-2">
						<div class="col-sm-6">
							<h1>404 Error Page</h1>
						</div>
						<div class="col-sm-6">
							<ol class="breadcrumb float-sm-right">
								<li class="breadcrumb-item"><a href="#">Home</a></li>
								<li class="breadcrumb-item active">404 Error Page</li>
							</ol>
						</div>
					</div>
				</div>
				<!-- /.container-fluid -->
			</section>

			<!-- Main content -->
			<section class="content">
				<div class="error-page">
					<h2 class="headline text-warning">404</h2>

					<div class="error-content">
						<h3>
							<i class="fa fa-warning text-warning"></i> Oops! Page not found.
						</h3>

						<p>
							We could not find the page you were looking for. Meanwhile, you
							may <a href="../../index.html">return to dashboard</a> or try
							using the search form.
						</p>

						<form class="search-form">
							<div class="input-group">
								<input type="text" name="search" class="form-control"
									placeholder="Search">

								<div class="input-group-append">
									<button type="submit" name="submit" class="btn btn-warning">
										<i class="fa fa-search"></i>
									</button>
								</div>
							</div>
							<!-- /.input-group -->
						</form>
					</div>
					<!-- /.error-content -->
				</div>
				<!-- /.error-page -->
			</section>
			<!-- /.content -->
		</div><jsp:include page="_shareLayout/_footer.jsp"></jsp:include>
	</div>
	<jsp:include page="_shareLayout/footer.jsp"></jsp:include>
</body>
</html>