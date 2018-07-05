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
						<!-- /.col -->
						<div class="col-sm-6">
							<ol class="breadcrumb float-sm-right">
								<li class="breadcrumb-item"><a href="#">Danh sách Câu lạc bộ</a></li>
								<li class="breadcrumb-item active">Câu lạc bộ</li>
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
							<!-- general card -->
							<div class="card card-primary">
								<div class="card-header">
									<h3 class="card-title">Thêm Câu Lạc Bộ</h3>
								</div>
								<!-- /.card-header -->
								<!-- form start -->
								<form:form method="POST" modelAttribute="club"
									action="${pageContext.request.contextPath}/club/create">
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
										<c:choose>
											<c:when test="${members.size()==0}">
												<div class="text-danger text-center">Bạn hãy tạo người quản lý câu lạc bộ</div>
											</c:when>
											<c:when test="${members.size()>0}">
												<label for="member.idMember">Nhân viên quản lý câu lạc bộ</label>
											<form:select id="idMember" path="member.idMember" class="form-control">												
												<form:options items="${members}" itemValue="idMember"  itemLabel="nameMember" />
											</form:select>
											</c:when>
										</c:choose>											
											<div id="messageMember"></div>
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
					<div class="col-md-7">
		            <div class="card">
		              <div class="card-header">
		                <h3 class="card-title">Danh Sách Câu Lạc Bộ</h3>		                
		              </div>
		              <!-- /.card-header -->
		              <div class="card-body p-0">
		                <table class="table">
		                  <tr>
		                    <th style="width: 150px">Tên Câu Lạc Bộ</th>		      
		                     <th>Chi Nhánh</th>	    
		                      <th>Nhân Viên Quản Lý</th>	        
		                    <th style="width:150px">Tuỳ Chỉnh</th>	                 	 
		                  </tr>
	                     <c:forEach var="club" items="${clubs}">
			                  <tr>
			                  	<td>${club.getNameClub()}</td>
			                    <td>${club.getBranch().getNameBranch()}</td>		   
			                    <td>${club.getMember().getNameMember()}</td>                           
			                    <td>
			                    	<span class="editClub" data-id = "${club.getIdClub()}"> <i class="fa fa-pencil edit" aria-hidden="true" data-toggle="modal" data-target="#editClub"></i></span>
			                    	<span class="deleteClub" data-id = "${club.getIdClub()}"><i class="fa fa-times delete"></i></span>	
			                    </td>	                               
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
			<div id="editClub" class="modal fade" role="dialog">
				<div class="modal-dialog">
					<!-- Modal content-->
					<div class="modal-content">						
						<div class="modal-header">
							<h4 class="modal-title">Chỉnh sửa Câu lạc Bộ</h4>
							<button type="button" class="close" data-dismiss="modal">&times;</button>
						</div>
						<div class="modal-body">
							<input type="hidden" id="idEditClub"/>
							<div class="text-center text-danger" id="errorEditClub"></div>
							<div class="form-group">
								<label for="nameEditClub">Tên Câu Lạc Bộ</label>
								<input type="text" id="nameEditClub" id="nameEditClub" class="form-control"
									 placeholder="Nhập Tên Câu Lạc Bộ" />
							</div>
							<div class="form-group">
								<label for="branchEditClub">Thuộc chi nhánh</label>
								<select id="branchEditClub" name="branchEditClub" class="form-control">									
									
								</select>
							</div>
							<div class="form-group">
								<label for="memberEditClub">Nhân viên quản lý câu lạc bộ</label>
								<select id="memberEditClub" name ="memberEditClub" class="form-control">																
								</select>								
							</div>
							
						</div>
						<div class="modal-footer">
							<button type="button" id="saveChangeClub" class="btn btn-primary">Lưu</button>
							<button type="button" class="btn btn-default" data-dismiss="modal">Thoát</button>
						</div>
					</div>
				</div>
			</div>
			<!--/.modal -->
		</div>
		<jsp:include page="_shareLayout/_footer.jsp"></jsp:include>
	</div>
	<jsp:include page="_shareLayout/footer.jsp"></jsp:include>
	<script>
		$(document).ready(function(){
			var idMember = $("#idMember").val();
			$("#messageMember").empty();
			$.ajax({
				url:"/Club-IVS/club/checkMember",
				type:"POST",
				data:{
					idMember:idMember
				},
				success:function(data){
					if(data.status==200){
						$("#messageMember").append("Thành viên này đã quản lý CLB nào đó!");
						$("#messageMember").addClass("text-danger text-center");
					}								
				}					
			});
			$("#idMember").change(function(){
				$("#messageMember").empty();
				$.ajax({
					url:"/Club-IVS/club/checkMember",
					type:"POST",
					data:{
						idMember:idMember
					},
					success:function(data){
						if(data.status==200){
							$("#messageMember").append("Thành viên này đã quản lý CLB nào đó!");
							$("#messageMember").addClass("text-danger text-center");
						}								
					}					
				});
			})
		})
	</script>
</body>
</html>