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
	              <li class="breadcrumb-item"><a href="#">Chi Nhánh</a></li>
	              <li class="breadcrumb-item active">Index</li>
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
		                  <div class="form-group">
		                    <label for="nameBranch">Tên Chi Nhánh</label>		                   
		                  	<form:input type="text" path="nameBranch" class="form-control" id="nameBranch" placeholder="Nhập Tên Chi Nhánh"/>
		                  </div>
		                   <div class="form-group">
		                    <label for="member.idMember"">Nhân viên quản lý club tại chi nhánh</label>
		      		            <form:select path="member.idMember" class="form-control">
 		                    	<form:option value="0" label="--- Chọn nhân viên ---" />					  			 
		                    	<form:options items="${listMember}" itemValue="idMember" itemLabel="nameMember" /> 
		                    </form:select> 		                   
		                  </div>
		                  <div class="form-group">
		                    <label for="addressBranch">Địa chỉ</label>
		                    <form:textarea path="addressBranch" class="form-control"  id="addressBranch" placeholder="Nhập Địa chỉ chi nhánh" rows="3"/>
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
		                    <th style="width: 10px">#</th>
		                    <th style="width: 150px">Tên Chi Nhánh</th>		      
		                     <th>Địa Chỉ</th>	            
		                    <th style="width:150px">Tuỳ Chỉnh</th>	                 	 
		                  </tr>
	                     <c:forEach var="branch" items="${listBranch}">
			                  <tr>
			                  	<td>${branch.getIdBranch()}</td>
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
                  </div>
                   <div class="form-group">
                    <label for="memberEditBranch"">Nhân viên quản lý club tại chi nhánh</label>
   		            <select id="memberEditBranch" name="memberEditBranch" class="form-control">	  			 
                 	</select> 		                   
                  </div>
                  <div class="form-group">
                    <label for="addressEditBranch">Địa chỉ</label>
                    <textarea class="form-control" id="addressEditBranch" placeholder="Nhập Địa chỉ chi nhánh" rows="3"></textarea>
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
</html>