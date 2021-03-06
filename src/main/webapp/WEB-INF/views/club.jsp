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
								<%-- <a href="<c:url value="/club/listJoinClub"/>" class="nav-link ${action1 eq  'role' ? 'active' : ''}"> --%>
								<li class="breadcrumb-item active"><a>Danh sách Câu lạc bộ</a></li>
								<li class="breadcrumb-item"><a href="<c:url value="/club/joinClub"/>">Thêm thành viên</a></li>
								<li class="breadcrumb-item"><a href="<c:url value="/club/listJoinClub"/>">Danh sách hoạt động</a></li>
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
										<div class="form-group row">
											<label for="nameBranch" class="col-md-4">Tên Câu Lạc Bộ</label>
											<form:input type="text" path="nameClub" class="form-control col-md-7"
												id="nameClub" placeholder="Nhập Tên Câu Lạc Bộ" required="required"/>
										</div>										
										<div class="form-group row">
											<label for="members" class="col-md-4">Quản Lý</label>
											<form:select required="required" path="members" items="${members}" cssClass="col-md-7 form-control select2" itemLabel="nameMember" itemValue="idMember" multiple="multiple" data-placeholder="Chọn quản lý">
											</form:select>
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
		              <div class="text-danger text-center" id="messageDeleteClub"></div>
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
			                    <td>
			                    	<c:forEach var="member" items="${club.getMembers()}">
			                    		${member.getNameMember()}<br/>
			                    	</c:forEach>
			                    </td>                           
			                    <td>
			                    	<a href='<c:url value="/club/edit/?id=${club.getIdClub()}"/>' class="editClub"><i class="fa fa-pencil edit"></i></a>
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
		</div>
		<jsp:include page="_shareLayout/_footer.jsp"></jsp:include>
	</div>
	<jsp:include page="_shareLayout/footer.jsp"></jsp:include>
	<script>
		$(document).ready(function(){
			//club			
			$(".deleteClub").click(function(){
				$("#messageDeleteClub").empty();
				var id = $(this).attr('data-id');
				var r = confirm("Bạn thật sự muốn xoá?");
				if(r){
					$.ajax({
						url:"/Club-IVS/api/deleteClub",
						type:"POST",
						data:{
							"idClub":id,				
						},
						success:function(data){
							if(data.status==200){					
								location.reload();
							}else{
								$("#messageDeleteClub").append("Đã có thành viên trong CLB này");
							}
							
						}
					});		
				}		
			})//end club
		})
	</script>
</body>
</html>