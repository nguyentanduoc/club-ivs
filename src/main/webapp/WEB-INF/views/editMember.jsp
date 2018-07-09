<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
			<div class="content-header">
				<div class="container-fluid">
					<div class="row mb-2">
						<div class="col-sm-6">
							<h1 class="m-0 text-dark">Thành Viên</h1>
						</div>
						<!-- /.col -->
						<div class="col-sm-6">
							<ol class="breadcrumb float-sm-right">
								<li class="breadcrumb-item"><a href="#">Thành Viên</a></li>
								<li class="breadcrumb-item active">Index</li>
							</ol>
						</div>
						<!-- /.col -->
					</div>
					<!-- /.row -->
				</div>
				<!-- /.container-fluid -->
			</div>
			<!-- /.content-header -->
			<!-- Main content -->
			<section class="content">
				<c:choose>
					<c:when test="${status==403}">
						<h5 class="text-success text-danger">
							<i class="icon fa fa-ban"></i>
							<c:out value="${message}" />
						</h5>
					</c:when>
					<c:otherwise>
						<div class="container-fluid">
							<div class="row">
								<!-- left column -->
								<div class="col-md-5">
									<!-- general form elements -->
									<div class="card card-primary">
										<div class="card-header">
											<h3 class="card-title">Sửa Thành Viên</h3>
										</div>
										<!-- /.card-header -->
										<!-- form start -->
										<form method="POST"
											action="${pageContext.request.contextPath}/member/update">
											<div class="card-body">
												<div id="message"></div>
												<input type="hidden" id="idMember" name="idMember" value="${member.getIdMember()}">
												<div class="form-group row">
													<label for="nameMember" class="col-sm-4 col-form-label">Họ Tên:</label>
													<div class="col-sm-8">
														<input type="text" value="${member.getNameMember()}"
															name="nameMember" class="form-control"
															placeholder="Nhập Tên Nhân Viên" readonly />
													</div>
												</div>
												<div class="form-group row">
													<label class="col-sm-4 col-form-label" for="roles">Chức
														Vụ: </label>
													<div class="col-sm-8">
														<c:set var="check" value="" />
														<c:forEach var="role" items="${listRole}">
															<c:choose>
																<c:when test="${member.getRoles().size()>0}">
																	<c:forEach var="roleMember"
																		items="${member.getRoles()}">
																		<c:choose>
																			<c:when
																				test="${roleMember.getIdRole()==role.getIdRole()}">
																				<c:set var="check" value="checked" />
																			</c:when>
																		</c:choose>
																	</c:forEach>
																</c:when>
															</c:choose>
															<input type="checkbox" class="minimal" name="roles"
																value="${role.getIdRole()}" ${check}>${role.getNameRole()}<br />
															<c:set var="check" value="" />
														</c:forEach>
													</div>
													<br /> <a id="resetPassWord" href="#">Đặt lại mật khẩu</a> <input
														type="hidden" name="${_csrf.parameterName}"
														value="${_csrf.token}" />
												</div>
											</div>
											<!-- /.card-body -->
											<div class="card-footer">
												<input type="submit" class="btn btn-primary float-right"
													value="Lưu" />

											</div>
										</form>
									</div>
									<!-- /.card -->
								</div>
							</div>
						</div>
					</c:otherwise>
				</c:choose>
			</section>
			<!-- /.content -->
		</div>
		<jsp:include page="_shareLayout/_footer.jsp"></jsp:include>
	</div>
	<jsp:include page="_shareLayout/footer.jsp"></jsp:include>
	<script>
		$(document).ready(function(){
			var view="";
			$("#resetPassWord").click(function(){
				$("#message").empty();				
				var id=$("#idMember").val();
				$.ajax({
					url:"/Club-IVS/member/resetPassWord",
					type:"POST",
					data:{
						idMember:id						
					},
					success:function(data){
						if(data.status==200){
							view+="<h5 class='text-success text-center'><i class='icon fa fa-check'></i>"+data.message+"</h5>";
							$("#message").append(view);											
						}else{
							view+="<h5 class='text-success text-danger' id='errors'><i class='icon fa fa-ban'></i><c:out value="+data.message+"/></h5>";
							$("#message").append(view);
						}
						view="";
					}
				})
			})
		})
	</script>
</body>
</html>