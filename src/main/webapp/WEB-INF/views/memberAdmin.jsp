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
								<li class="breadcrumb-item"><a href="#">Admin</a></li>
								<li class="breadcrumb-item active">Thành viên</li>
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
											<form:input type="text" path="nameMember" class="form-control" id="nameMember" placeholder="Nhập Tên Nhân Viên" />
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
													placeholder=""  readonly="true"/>
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
											<th style="width: 150px">Tuỳ Chỉnh</th>
										</tr>
										<tbody id="listMember">
											<c:forEach var="member" items="${listMember}">
												<tr>
													<td>${member.getIdMember()}</td>
													<td>${member.getNameMember()}</td>
													<td><c:forEach var="role" items="${member.getRoles()}">
															<c:out value="${role.getNameRole()}"></c:out><br/>
														</c:forEach></td>
													<td>
														<a href="${pageContext.request.contextPath}/member/editAdminMember/${member.getIdMember()}"> <i class="fa fa-pencil edit"></i></a>
														<span class="deleteMember" onclick="deleteMember(${member.getIdMember()})"><i class="fa fa-times delete"></i></span> 
														</td>	
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
								<c:set value="1" var="curentPage"/>
								<div class="card-footer clearfix" >
					                <ul class="pagination pagination-sm m-0 float-right" id="paginate">
					                </ul>
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
			var currentPage=1;
			$("#paginate").empty();
			var viewPage="";		
			var totalPage = ${totalPage};
			viewPage=" <li class='page-item' id='first'><a class='page-link pageClick' data-click='1' href='#'>&laquo;</a></li>";
			for(var i=1;i<=totalPage;i++){				
				if(currentPage==i){
					viewPage += "<li class='page-item active'><a class='page-link pageClick' data-click='"+i+"' href='#'>"+i+"</a></li>";
				}else{
					viewPage += "<li class='page-item'><a class='page-link pageClick' data-click='"+i+"' href='#'>"+i+"</a></li>";
				}				
			}
			viewPage+=" <li class='page-item'><a class='page-link pageClick' data-click='"+totalPage+"' href='#'>&raquo;</a></li>";
			$("#paginate").append(viewPage);
			
			$(".pageClick").click(function(){
				var view="";
				var page = $(this).attr('data-click');
				$("#listMember").empty();
				$(".page-item").each(function( index, element ) {
					if ( $(this).hasClass('active')) {
						$(this).removeClass('active');
					}
				})			
				$(this.parentNode).addClass("active");				
				$.ajax({
					url:"/Club-IVS/member/loadMember",
					type:"POST",
					data:{
						page:page
					},
					success:function(data){				
						if(data.status==200){
							$.each(data.listMember,function(index,row){
								view +="<tr>";
								view +="<td>"+row.idMember+"</td>";
								view +="<td>"+row.nameMember+"</td><td>";
								if(row.roles!=null){
									$.each(row.roles,function(index1,row1){									
										view += row1.nameRole +"<br/>";										
									})
								}								
								view+="</td>";
								view +="<td><a href='${pageContext.request.contextPath}/member/editAdminMember/"+row.idMember+"'> <i class='fa fa-pencil edit'></i></a>";
								view+="<span class='deleteMember' onclick ='deleteMember("+row.idMember+")'><i class='fa fa-times delete'></i></span></td></tr>";
								
							});
							$("#listMember").append(view);
							console.log(data)										
						}else{
							
						}
					}
				})
			})
			
		})
		function deleteMember(idMember){
			$("#message").empty();
			var view="";
			$.ajax({
				url:"/Club-IVS/member/deleteMember",
				type:"POST",
				data:{
					idMember:idMember
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
		}
	</script>
</body>
</html>