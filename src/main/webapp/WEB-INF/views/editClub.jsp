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
							<ol class="breadcrumb float-md-right">
								<li class="breadcrumb-item"><a href='<c:url value='/member/create'/>'>Thành Viên</a></li>
								<li class="breadcrumb-item active">Cập Nhật</li>
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
										<form:form method="POST" modelAttribute="club"
									action="${pageContext.request.contextPath}/club/saveChangeClub">
									<div class="card-body">
										<c:choose>
						                	<c:when test="${status!=null}">		                		
						                		<c:choose>
								                	<c:when test="${status==200}">
									                  <h5 class="text-center text-success"><i class="icon fa fa-check"></i> Thành Công!</h5>		
								                	</c:when>
								                	<c:when test="${status==400}">		 
									                  <h5 class="text-center text-danger"><i class="icon fa fa-ban"></i> Thất Bại!</h5>	
								                	</c:when>
								                </c:choose>
						                	</c:when>
					                	</c:choose>	
										<div class="form-group">
											<label for="nameBranch">Tên Câu Lạc Bộ</label>
											<form:input type="text" path="nameClub" class="form-control"
												id="nameClub" placeholder="Nhập Tên Câu Lạc Bộ" />
										</div>										
										<div class="form-group">
											<form:select cssClass="select2 form-control" path="members" var="member" items="${members}" multiple="true" itemLabel="nameMember" itemValue="idMember" data-placeholder="Chọn người quản lý">
											</form:select>											
										</div>
									</div>
									<!-- ./card-body -->
									<div class="card-footer">
										<input type="submit" class="btn btn-primary float-right" value="Thêm" />
									</div>
								</form:form>
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
</body>
</html>