<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
							<h1 class="m-0 text-dark">Câu Lạc Bộ</h1>
						</div>
						<div class="col-sm-6">
							<ol class="breadcrumb float-sm-right">
								<li class="breadcrumb-item"><a  href="<c:url value="/club/index"/>">Danh sách Câu lạc bộ</a></li>
								<li class="breadcrumb-item"><a href="<c:url value="/club/joinClub"/>">Thêm thành viên</a></li>
								<li class="breadcrumb-item"><a href="<c:url value="/club/listJoinClub"/>">Danh sách hoạt động</a></li>
							</ol>
						</div>
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
							<!-- general card -->
							<div class="card card-primary">
								<div class="card-header">
									<h3 class="card-title">Chỉnh Sửa Câu Lạc Bộ</h3>
								</div>
								<!-- /.card-header -->
								<!-- form start -->
								<form:form method="POST" modelAttribute="club"
									action="${pageContext.request.contextPath}/club/edit">
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
										<div class="form-group row">
											<label for="nameBranch" class="col-md-4">Tên Câu Lạc Bộ</label>
											<form:input type="text" path="nameClub" class="form-control col-md-7"
												id="nameClub" placeholder="Nhập Tên Câu Lạc Bộ" />
										</div>										
										<div class="form-group row">
											<label for="members" class="col-md-4">Quản Lý</label>
											<form:select path="members"  cssClass="col-md-7 form-control select2" 
												multiple="multiple" data-placeholder="Chọn quản lý">
												<c:forEach items="${members}" var="member">
													<c:forEach items="${club.getMembers()}" var="m">
														<c:choose>
															<c:when test="${m.getIdMember()==member.getIdMember()}">
																  <option selected="selected" value="${member.getIdMember()}">${member.getNameMember()}</option>
															</c:when>
															<c:when test="${m.getIdMember()!=member.getIdMember()}">
															  	<option value="${member.getIdMember()}">${member.getNameMember()}</option>
															</c:when>
														</c:choose>
													</c:forEach>
									            </c:forEach>
											</form:select>
											<form:hidden path="idClub"/>
										</div>
									</div>
									<!-- ./card-body -->
									<div class="card-footer">
										<input type="submit" class="btn btn-primary float-right" value="Thêm" />
									</div>
								</form:form>
								<!-- end form -->
							</div>
							<!-- ./card -->
						</div>					
					</div>
				</div>
			</section>
			<!-- /.content -->
		</div>
		<jsp:include page="_shareLayout/_footer.jsp"></jsp:include>
	</div>
	<jsp:include page="_shareLayout/footer.jsp"></jsp:include>
</body>
</html>