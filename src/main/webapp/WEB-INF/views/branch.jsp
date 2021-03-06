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
	            <h1 class="m-0 text-dark">Chi Nhánh</h1>
	          </div><!-- /.col -->
	          <div class="col-sm-6">
	            <ol class="breadcrumb float-sm-right">
	              <li class="breadcrumb-item"><a href='<c:url value="/branch/index"/>'>Trang Chủ</a></li>
	              <li class="breadcrumb-item active">Chi Nhánh</li>
	            </ol>
	          </div><!-- /.col -->
	        </div><!-- /.row -->
	      </div><!-- /.container-fluid -->
	    </div><!-- /.content-header -->
	    <!-- Main content -->
	    <section class="content">
	      <div class="container-fluid">
	      	<div class="row">
	          <!-- left column -->
	          <div class="col-md-5">
	            <!-- general form elements -->
	            <div class="card card-primary">
	              <div class="card-header">
	                <h3 class="card-title">Thêm Chi Nhánh</h3>
	              </div><!-- /.card-header -->
	              <!-- form start -->
	              <form:form method="POST" modelAttribute="branch" action="${pageContext.request.contextPath}/branch/insert">	          
	                <div class="card-body">	              
		               <div class="m-3">
		               		<c:if test="${status!=null}">
		               			<c:choose>
				                	<c:when test="${status==200}">
						                 <h5 class="text-center text-success"><i class="icon fa fa-check"></i> Thành Công!</h5>
				                	</c:when>
				                	<c:when test="${status==400}">
						                 <h5 class="text-center text-danger"><i class="icon fa fa-ban"></i> Thất Bại!</h5>
				                	</c:when>
				                </c:choose>
		            		</c:if>	
	               		</div> 
		                  <div class="form-group">
		                    <label for="nameBranch">Tên Chi Nhánh</label>		                   
		                  	<form:input type="text" path="nameBranch" class="form-control" id="nameBranch" placeholder="Nhập Tên Chi Nhánh" required="required"/>
		                  </div>		                   
		                  <div class="form-group">
		                    <label for="addressBranch">Địa chỉ</label>
		                    <form:textarea path="addressBranch" class="form-control"  id="addressBranch" placeholder="Nhập Địa chỉ chi nhánh" rows="3" required="required"/>
		                  </div>
		               </div>
	                <!-- /.card-body -->	
		                <div class="card-footer">
		                  <input type="submit" class="btn btn-primary float-right" value="Thêm"/>
		                </div>	             
	              </form:form><!-- end form -->
	            </div>
	            <!-- /.card -->
		    	</div>
		    	<div class="col-md-7">
		            <div class="card">
		              <div class="card-header">
		                <h3 class="card-title">Danh Sách Chi Nhánh</h3>		                
		              </div>
		              <!-- /.card-header -->
		              <div class="card-body p-0">
		                <table class="table">
		                  <tr>
		                    <th style="width: 150px">Tên Chi Nhánh</th>		      
		                     <th>Địa Chỉ</th>	            
		                    <th style="width:150px">Tuỳ Chỉnh</th>	                 	 
		                  </tr>
	                     <c:forEach var="branch" items="${listBranch}">
			                  <tr>			                  
			                    <td>${branch.getNameBranch()}</td>		   
			                    <td>${branch.getAddressBranch()}</td>                           
			                    <td>
				                    <span class="editBranch" data-id = "${branch.getIdBranch()}"> <i class="fa fa-pencil edit" aria-hidden="true" data-toggle="modal" data-target="#editBranch"></i></span>
				                    <span class="deleteBranch" data-id = "${branch.getIdBranch()}"><i class="fa fa-times delete"></i></span>
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
	    <div id="editBranch" class="modal fade" role="dialog">
		  <div class="modal-dialog">
   			 <!-- Modal content-->
		    <div class="modal-content">
		      <div class="modal-header">
		      <h4 class="modal-title">Chỉnh sửa Chi Nhánh</h4>
		        <button type="button" class="close" data-dismiss="modal">&times;</button>		        
		      </div>
		      <div class="modal-body">
		      <input name="idEditBranch" type="hidden" id="idEditBranch">
		       	<div class="form-group">
                    <label for="nameEditBranch">Tên Chi Nhánh</label>		                   
                  	<input type="text" class="form-control" id="nameEditBranch" placeholder="Nhập Tên Chi Nhánh"/>
                  	 <div  class="text-danger" id="errNameEditBranch"></div>    
                  </div>
                   <div class="form-group">
                    <label for="memberEditBranch">Nhân viên quản lý Club tại Chi nhánh</label>
   		            <select id="memberEditBranch" name="memberEditBranch" class="form-control"/></select> 		  
   		            <div class="text-warning" id="message"></div>                 
                  </div>
                  <div class="form-group">
                    <label for="addressEditBranch">Địa chỉ</label>
                    <textarea class="form-control" id="addressEditBranch" placeholder="Nhập Địa chỉ chi nhánh" rows="3"></textarea>
                  	<div class="text-danger" id="errAddressEditBranch"></div>    
                  </div>
		      </div>
		      <div class="modal-footer">
		      	<button type="button" id="saveChangeBranch" class="btn btn-primary">Lưu</button>
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
	</body>
	<script>
		$(document).ready(function(){
			$("#memberEditBranch").change(function(){
				var idMember = $("#memberEditBranch").val();
				$("#message").empty();
				$.ajax({
					url:"/Club-IVS/branch/checkMember",
					type:"POST",
					data:{
						idMember:idMember
					},
					success:function(data){
						console.log(data);
						if(data.status==200){
							$("#message").append("Bạn có muốn người này quản lý thêm chi nhánh!");
							$("#message").addClass("text-warning text-center");
						}								
					}					
				});
			});
			$(".editBranch").click(function(){
				$("#memberEditBranch").empty();
				$("#message").empty();
				var id = $(this).attr('data-id');
				$.ajax({
					url:"/Club-IVS/api/getBranchById",
					type:"POST",
					data:{
						id:id
					},
					success:function(data){
						if(data.status==200){
							var view="";
							$("#idEditBranch").val(data.branch.idBranch);
							$("#nameEditBranch").val(data.branch.nameBranch);
							$("#addressEditBranch").val(data.branch.addressBranch);					
							if(data.branch.member!=null){								
								$.each(data.members, function (index, row) {						
									if(row.idMember==data.branch.member.idMember){
										 view += "<option value='" + row.idMember + "' selected>" + row.nameMember + " - " + row.userNameMember + "</option>";
									}else{
										view += "<option value='" + row.idMember + "'>" + row.nameMember + "-" + row.userNameMember + "</option>";
									}                       
			                    })
							}else{
								view += "<option value='0'>---Chọn Nhân Viên---</option>";   
								$.each(data.members, function (index, row) {
									view += "<option value='" + row.idMember + "'>" + row.nameMember + "-" + row.userNameMember + "</option>";             
			                    })
							}					
		                    $("#memberEditBranch").append(view);
						}else{
							$("errorGetRole").append("Xảy ra lỗi khi lấy dữ liệu!");
						}
					}
				})	
			})	
			$("#saveChangeBranch").click(function(){		
				var err=false;
				var id = $("#idEditBranch").val();
				var nameBranch =$("#nameEditBranch").val();
				var addressBranch= $("#addressEditBranch").val();
				var member= $("#memberEditBranch").val();
				
				$("#errMemberEditBranch").empty();
				$("#errNameEditBranch").empty();
				$("#errAddressEditBranch").empty();
				if(member==0){			
					err = true;
					$("#errMemberEditBranch").append("Chọn nhân viên!");
				}
				if(nameBranch==""){			
					err = true;
					$("#errNameEditBranch").append("Nhập tên chi nhánh");
				}
				if(addressBranch==""){
					err = true;
					$("#errAddressEditBranch").append("Nhập tên chi nhánh");
				}	
				if(err==false){
					$.ajax({
						url:"/Club-IVS/api/saveChangeBranch",
						type:"POST",
						data:{
							"idBranch":id,
							"nameBranch":nameBranch,
							"addressBranch":addressBranch,
							"member.IdMember":member
						},
						success:function(data){
							if(data.status==200){					
								location.reload();
							}else{
								$("errorGetRole").append("Xảy ra lỗi khi lưu!");
							}					
						}
					});
				}
			});
			//delete Branch
			$(".deleteBranch").click(function(){
				var r = confirm("Bạn thật sự muốn xoá?");
				if(r){
					var self = $(this);
					var id = $(this).attr('data-id');
					$.ajax({
						url:"/Club-IVS/branch/deleteBranch",
						type:"POST",
						data:{
							idBranch:id
						},
						success:function(data){
							if(data.status==200){
								self.closest("tr").remove();
							}else{
								alert("Xảy ra lỗi!");
							}							
						}
					})	
				}	
			})// end delete Branh
		});
	</script>
</html>