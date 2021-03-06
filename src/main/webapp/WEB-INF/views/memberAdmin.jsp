<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tag" uri="/WEB-INF/taglibs/customTaglib.tld" %>
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
	            <h1 class="m-0 text-dark">Thêm Thành Viên</h1>
	          </div><!-- /.col -->
	          <div class="col-sm-6">
	            <ol class="breadcrumb float-sm-right">
	              <li class="breadcrumb-item"><a href='<c:url value="/member/admin"/>'>Trang Chủ</a></li>
	              <li class="breadcrumb-item active">Thêm Thành Viên Admin</li>
	            </ol>
	          </div><!-- /.col -->
				</div>	<!-- /.row -->
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
								<form:form method="POST" modelAttribute="member" action="${pageContext.request.contextPath}/member/admin">
									<div class="card-body">	
									<div id="message"></div>	
									<c:choose>
					                	<c:when test="${status!=null}">		                		
					                		<c:choose>
							                	<c:when test="${status==200}">							                		
									                  <h5 class="text-success text-center"><i class="icon fa fa-check"></i> Thành Công!</h5>	
							                	</c:when>
							                	<c:when test="${status==400}">	
									                  <h5 class="text-danger text-center"><i class="icon fa fa-ban"></i> Thất Bại!</h5>
							                	</c:when>
							                </c:choose>
					                	</c:when>
					                </c:choose>	
									<div class="form-group row">
										<label for="nameMember" class="col-sm-4 col-form-label">Họ Tên:</label>
										 <div class="col-sm-8">
											<form:input required="required" type="text" path="nameMember" class="form-control" id="nameMember" placeholder="Nhập Tên Nhân Viên" />
										</div>
									</div>
									<div class="form-group row">
										<label class="col-sm-4 col-form-label" for="sexMember">Giới tính:</label>
										<div class="col-sm-8">
											<form:radiobutton class="minimal" path="sexMember" value="1"/>Nam 
											<form:radiobutton class="minimal" path="sexMember" value="0"/>Nữ 
										</div>											
									</div>										
									<div class="form-group row">
										<label class="col-sm-4 col-form-label" for="userNameMember">Tên Đăng Nhập:</label>
										<div class="col-sm-8">
											<form:input type="text" path="userNameMember"
													class="form-control" id="userNameMember"
													placeholder="" required="required"/>
										</div>										
										<div class="nameMemberErro text-danger"></div>																					
									</div>										
									<div class="form-group row">
										<label  class="col-sm-4 col-form-label" for="passWord">Mật Khẩu:</label>
										<div class="col-sm-8">
											<form:input type="text" path="passWordMember"
											class="form-control" id="passWordMember" readonly="true"/>
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
											<form:checkboxes element="li" class="minimal" id="roles" path="roles" items="${listRole}" itemValue="idRole"
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
									<div class="card-tools">
					                  <div class="input-group input-group-sm" style="width: 150px;">
					                    <input type="text" id="searchMember" name="table_search" class="form-control float-right" placeholder="Search">
					                    <div class="input-group-append">
					                      <button type="submit" class="btn btn-default"><i class="fa fa-search"></i></button>
					                    </div>
					                  </div>
					                </div>
								</div><!-- /.card-header -->
								<div class="card-body p-0">
									<table class="table">
										<tr>
											<th style="width: 10px">#</th>
											<th>Tên Chức Vụ</th>
											<th>Chức vụ</th>
											<th align="center">TTHĐ</th>
											<th align="center">Tuỳ Chỉnh</th>
										</tr>
										<tbody id="listMember">
											<c:forEach var="member" items="${listMember}">
												<tr>
													<td>${member.getIdMember()}</td>
													<td>${member.getNameMember()}</td>
													<td><c:forEach var="role" items="${member.getRoles()}">
															<c:out value="${role.getNameRole()}"></c:out><br/>
														</c:forEach>
													</td>
													<td align="center">
														<c:choose>
															<c:when test="${member.isStatus()==true}">
																 <label class="btn btn-success btn-sm"><i class="fa fa-check" aria-hidden="true"></i></label>
															</c:when>
															<c:when test="${member.isStatus()==false}">
																 <label class="btn btn-secondary btn-sm"><i class="fa fa-circle-o" aria-hidden="true"></i></label>
															</c:when>
														</c:choose>
													</td>
													<td align="center">
														<a href="${pageContext.request.contextPath}/member/editAdminMember/${member.getIdMember()}"> <i class="fa fa-pencil edit"></i></a>
														<span class="deleteMember" data-id='${member.getIdMember()}'><i class="fa fa-times delete"></i></span> 
													</td>	
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
								<c:set value="${pageContext.request.contextPath}/member/admin" var="url"/>
								<div class="card-footer clearfix" >
					              <tag:paginate max="5" offset="${offset}" count="${count}" uri="${url}" next="&raquo;" previous="&laquo;"/>
				              	</div>
								<!-- /.card-body -->
							</div>
						</div>
					</div>
				</div>
			</section>
			<!-- /.content -->			
		</div>
		<jsp:include page="_shareLayout/_footer.jsp"></jsp:include>
	</div>
	<jsp:include page="_shareLayout/footer.jsp"></jsp:include>
	<script>
		$(document).ready(function(){			
			$(".deleteMember").click(function(){
				var id = $(this).attr('data-id');
				$("#message").empty();
				var view="";
				$.ajax({
					url:"/Club-IVS/member/deleteMember",
					type:"POST",
					data:{
						idMember:id
					},
					success:function(data){		
						if(data.status==200){
							view+="<h5 class='text-success text-center'><i class='icon fa fa-check'></i> Xóa Thành Công!</h5>";
							location.reload();
						}else{
							view+="<h5 class='text-danger text-center'><i class='icon fa fa-ban'></i>Xóa Thất Bại!</h5>";
						}
						$("#message").append(view);
						view="";
					}
				})
			})
		})
	</script>
</body>
</html>