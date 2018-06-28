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
				<div class="container-fluid">
					<div class="row">
						<!-- left column -->
						<div class="col-md-5">
							<!-- general form elements -->
							<div class="card card-primary">
								<div class="card-header">
									<h3 class="card-title">Thêm Thành Viên</h3>
								</div>
								<!-- /.card-header -->
								<!-- form start -->
								<form:form method="POST" modelAttribute="member" action="${pageContext.request.contextPath}/member/create">
									<div class="card-body">		
									<c:choose>
					                	<c:when test="${status!=null}">		                		
					                		<c:choose>
							                	<c:when test="${status==200}">
							                		<div class="alert alert-success alert-dismissible">
									                  <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
									                  <h5><i class="icon fa fa-check"></i> Thành Công!</h5>					                 
									                </div>
							                	</c:when>
							                	<c:when test="${status==400}">		                		
									                <div class="alert alert-danger alert-dismissible">
									                  <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
									                  <h5><i class="icon fa fa-ban"></i> Thất Bại!</h5>					                 
									                </div>
							                	</c:when>
							                </c:choose>
					                	</c:when>
					                </c:choose>	
									<div class="form-group row">
										<label for="nameMember" class="col-sm-4 col-form-label">Họ Tên:</label>
										 <div class="col-sm-8">
											<form:input type="text" path="nameMember" class="form-control" id="nameMember" placeholder="Nhập Tên Nhân Viên" />
										</div>
									</div>
									<div class="form-group row">
										<label class="col-sm-4 col-form-label" for="sexMember">Giới tính:</label>
										<div class="col-sm-8">
											<form:radiobutton class="flat-red" path="sexMember" value="1"/>Nam 
											<form:radiobutton class="flat-red" path="sexMember" value="0"/>Nữ 
										</div>											
									</div>										
									<div class="form-group row">
										<label class="col-sm-4 col-form-label" for="userNameMember">Tên Đăng Nhập:</label>
										<div class="col-sm-8">
											<form:input type="text" path="userNameMember"
													class="form-control" id="userNameMember"
													placeholder=""  readonly="true"/>
										</div>										
										<div class="nameMemberErro text-danger"></div>																					
									</div>										
									<div class="form-group row">
										<label  class="col-sm-4 col-form-label" for="passWord">Mật Khẩu:</label>
										<div class="col-sm-8">
											<form:input type="text" path="passWordMember"
											class="form-control" id="passWordMember"
											placeholder=""  readonly="true"/>
										</div>											
									</div>
									
									<div class="form-group row">
										<label class="col-sm-4 col-form-label" for="branch">Chi Nhánh:</label>
										<div class="col-sm-8">
											<form:select path="branch.idBranch" class="form-control">												
												<form:options items="${listBranch}" itemValue="idBranch"
													itemLabel="nameBranch" />
											</form:select>
										</div>											
									</div>
									
									<div class="form-group row">										
										<label   class="col-sm-4 col-form-label" for="roles" >Chức Vụ: </label>
										<div class="col-sm-8">
											<form:checkboxes element="li" class="flat-red" id="roles" path="roles" items="${listRole}" itemValue="idRole"
												itemLabel="nameRole" />
										</div>
									</div>																	
								</div><!-- /.card-body -->
									
								<div class="card-footer">
									<input type="submit" class="btn btn-primary float-right" value="Thêm" />
								</div>
							</form:form>
						</div><!-- /.card -->
						</div>
						<div class="col-md-7">
							<div class="card">
								<div class="card-header">
									<h3 class="card-title">Danh Sách Thành viên</h3>
								</div><!-- /.card-header -->
								<div class="card-body p-0">
									<table class="table">
										<tr>
											<th style="width: 10px">#</th>
											<th>Tên Chức Vụ</th>
											<th>Chức vụ</th>
											<th style="width: 150px">Tuỳ Chỉnh</th>
										</tr>
										<c:forEach var="member" items="${listMember}">
											<tr>
												<td>${member.getIdMember()}</td>
												<td>${member.getNameMember()}</td>
												<td><c:forEach var="role" items="${member.getRoles()}">
														<c:out value="${role.getNameRole()}"></c:out></br>
													</c:forEach></td>
												<td><span class="deleteRole" data-id=""><i
														class="fa fa-times delete"></i></span> <span class="editRole"
													data-id=""> <i class="fa fa-pencil edit"
														aria-hidden="true" data-toggle="modal"
														data-target="#editRole"></i></span></td>
											</tr>
										</c:forEach>
									</table>
								</div>
								<!-- /.card-body -->
							</div>
						</div>
					</div>
				</div>
			</section>
			<!-- /.content -->
			<!-- modal -->
			<!-- <div id="editRole" class="modal fade" role="dialog">
				<div class="modal-dialog">

					Modal content
					<div class="modal-content">
						<div class="modal-header">
							<h4 class="modal-title">Chỉnh sửa Role</h4>
							<button type="button" class="close" data-dismiss="modal">&times;</button>

						</div>
						<div class="modal-body">
							<input name="idEditRole" type="hidden" id="idEditRole">
							<div class="form-group">
								<label for="exampleInputEmail1">Tên Chức Vụ</label> <input
									type="text" name="nameEditRole" class="form-control"
									id="nameEditRole" placeholder="Nhập Tên Chức Vụ">
							</div>
						</div>
						<div class="modal-footer">
							<button type="button" id="saveChangeRole" class="btn btn-primary">Lưu</button>
							<button type="button" class="btn btn-default"
								data-dismiss="modal">Close</button>
						</div>
					</div>
				</div>
			</div> -->
			<!--/.modal -->
		</div>
		<jsp:include page="_shareLayout/_footer.jsp"></jsp:include>
	</div>
	<jsp:include page="_shareLayout/footer.jsp"></jsp:include>
</body>
</html>