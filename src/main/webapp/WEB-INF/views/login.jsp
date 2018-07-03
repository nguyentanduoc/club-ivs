<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>IVS | Log in</title>
<!-- Tell the browser to be responsive to screen width -->
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Font Awesome -->
<link rel="stylesheet"
	href="<c:url value="/resources/plugins/font-awesome/css/font-awesome.min.css"/>">
<!-- Ionicons -->

<link rel="stylesheet"
	href='<c:url value="/resources/plugins/ionicons/ionicons.min.css"/>'>
<!-- Theme style -->
<link rel="stylesheet"
	href="<c:url value="/resources/dist/css/adminlte.min.css"/>">
<!-- iCheck -->
<link rel="stylesheet"
	href="<c:url value="/resources/plugins/iCheck/square/blue.css"/>">
<!-- Google Font: Source Sans Pro -->
<link
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700"
	rel="stylesheet">
</head>
<body class="hold-transition login-page">
	<div class="login-box">
		<div class="login-logo">
			<b>IVS</b> &nbsp;-  &nbsp;CLUB
		</div>
		<!-- /.login-logo -->
		<div class="card">
			<div class="card-body login-card-body">
				<p class="login-box-msg">Sign in to start your session</p>
				<form action="<c:url value="j_spring_security_check" />"
					method="post">
					<c:if test="${param.error!=null}">
						<div class="alert alert-danger text-center" role="alert">
							Sai tên hoặc mật khẩu</div>
					</c:if>
					<c:if test="${param.accessDinied!=null}">
						<div class="alert alert-danger text-center" role="alert">Bạn
							không có quyền truy cập</div>
					</c:if>					
					<div class="input-group mb-3">
						<div class="input-group-prepend">
							<span class="input-group-text"><i class="fa fa-envelope"></i></span>
						</div>
						<input type="text" class="form-control" placeholder="Email"
							name="j_username">
					</div>
					<div class="input-group mb-3">
						<div class="input-group-prepend">
							<span class="input-group-text"><i class="fa fa-lock" style="font-size:25px;"></i></span>
						</div>
						<input type="password" class="form-control" placeholder="Password"	name="j_password"> 
					</div>
					
					<div class="row">
						<div class="col-8">
							<div class="checkbox icheck">
								<label> <input type="checkbox"  id="remember" name="remember-me"> Remember Me
								</label>
							</div>
						</div>
						<!-- /.col -->
						<div class="col-4">
							<button type="submit" class="btn btn-primary btn-block btn-flat">Sign
								In</button>
						</div>
						<!-- /.col -->
					</div>
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
				</form>
			</div>
			<!-- /.login-card-body -->
		</div>
	</div>
	<!-- /.login-box -->

	<!-- jQuery -->
	<script src="<c:url value ="/resources/plugins/jquery/jquery.min.js"/>"></script>
	<!-- Bootstrap 4 -->
	<script
		src="<c:url value ="/resources/plugins/bootstrap/js/bootstrap.bundle.min.js"/>"></script>
	<!-- iCheck -->
	<script src="<c:url value ="/resources/plugins/iCheck/icheck.min.js"/>"></script>

	<script>
		$(function() {
			$('input').iCheck({
				checkboxClass : 'icheckbox_square-blue',
				radioClass : 'iradio_square-blue',
				increaseArea : '20%' // optional
			})
		})
	</script>
</body>
</html>
