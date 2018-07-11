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
												id="nameClub" placeholder="Nhập Tên Câu Lạc Bộ" />
										</div>										
										<div class="form-group row">
											<label for="members" class="col-md-4">Quản Lý</label>
											<form:select path="members" items="${members}" cssClass="col-md-7 form-control select2" itemLabel="nameMember" itemValue="idMember" multiple="multiple" data-placeholder="Chọn quản lý">
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
			//club
			$(".editClub").click(function(){
				var id = $(this).attr('data-id');
				$("#memberEditClub").empty();
				$("#branchEditClub").empty();
				var viewMember, viewBranch;
				$.ajax({
					type : "POST",
					url : "/Club-IVS/api/getClubById",
					data : {
						id:id
					},
					success : function(data) {
						if(data.status==200){
							$("#idEditClub").val(data.club.idClub);
							$("#nameEditClub").val(data.club.nameClub);
							$.each(data.members, function (index, row) {
								if(row.idMember==data.club.member.idMember){
									viewMember += "<option value='" + row.idMember + "' selected>" + row.nameMember + " - " + row.userNameMember + "</option>";
								}else{
									viewMember += "<option value='" + row.idMember + "'>" + row.nameMember + "-" + row.userNameMember + "</option>";
								}                        
		                    })
		                    $("#memberEditClub").append(viewMember);
							$.each(data.branchs, function (index, row) {
								if(row.idBranch==data.club.branch.idBranch){
									viewBranch += "<option value='" + row.idBranch + "' selected>" + row.nameBranch + "</option>";
								}else{
									viewBranch += "<option value='" + row.idBranch + "'>" + row.nameBranch + "</option>";
								}                        
		                    })
		                    $("#branchEditClub").append(viewBranch);
						}else{
							
						}
					}
				});
			});
			$("#saveChangeClub").click(function(){
				$("#errorEditClub").empty();
				var id = $("#idEditClub").val();
				var name = $("#nameEditClub").val();
				var idMember = $("#memberEditClub").val();
				var idBranch = $("#branchEditClub").val();
				$.ajax({
					url:"/Club-IVS/api/saveChangeClub",
					type:"POST",
					data:{
						"idClub":id,
						"nameClub":name,
						"member.idMember":idMember,
						"branch.idBranch":idBranch
					},
					success:function(data){
						if(data.status==200){					
							location.reload();
						}else{
							$("#errorEditClub").append("Xãy ra lỗi khi lưu!");
						}
						
					}
				});		
			});
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