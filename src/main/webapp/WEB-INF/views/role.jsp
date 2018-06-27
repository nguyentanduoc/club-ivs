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
	            <h1 class="m-0 text-dark">Chức Vụ</h1>
	          </div><!-- /.col -->
	          <div class="col-sm-6">
	            <ol class="breadcrumb float-sm-right">
	              <li class="breadcrumb-item"><a href="#">Chức Vụ</a></li>
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
	                <h3 class="card-title">Thêm Chức Vụ</h3>
	              </div>
	              <!-- /.card-header -->
	              <!-- form start -->
	              <form:form role="form" modelAttribute="role" method="post" action="${pageContext.request.contextPath}/role/insert">	                                	
               		<div class="m-3">
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
               		</div>               		                	                	                
	                <div class="card-body">
		                <div class="form-group row">
						    <label for="nameRole" class="col-sm-4 col-form-label">Tên Chức Vụ:</label>
						    <div class="col-sm-8">
						    	<form:input path="nameRole" type="text" name="nameRole" class="form-control" id="nameRole" placeholder="Nhập Tên Chức Vụ"/>
						    </div>
						  </div>		                      
		                  <div class="form-group row">
		                    <label  class="col-sm-4 col-form-label" for="codeRole">Code Chức Vụ:</label>
		                    <div class="col-sm-8">
		                    	<form:input path="codeRole" type="text" name="codeRole" class="form-control" id="codeRole" placeholder="Nhập Code Chức Vụ"/>
		                  	</div>
		                  </div>
	                  </div><!-- /.card-body -->	
						<div class="card-footer ">
						  <input type="submit" class="btn btn-primary float-right" value="Thêm"/>
						</div>
	              </form:form>
	            </div><!-- /.card -->
		    	</div>
		    	<div class="col-md-7">
		            <div class="card">
		              <div class="card-header">
		                <h3 class="card-title">Danh Sách Chức Vụ</h3>		                
		              </div>
		              <!-- /.card-header -->
		              <div class="card-body p-0">
		                <table class="table">
		                  <tr>		                   
		                    <th style="width: 10px">#</th>
		                    <th>Tên Chức Vụ</th>	
		                     <th>Code</th>	                  
		                    <th style="width:150px">Tuỳ Chỉnh</th>	               
		                  </tr>
		                     <c:forEach var="role" items="${listRole}">
				                  <tr>
				                  	<td>${role.getIdRole()}</td>
				                    <td>${role.getNameRole()}</td>		
				                     <td>${role.getCodeRole()}</td>	                    
				                    <td>
				                    	<span class="editRole" data-id = "${role.getIdRole()}">
				                    		<i class="fa fa-pencil edit" aria-hidden="true" aria-hidden="true" data-toggle="modal" data-target="#editRole">
				                    		</i>
				                    	</span>
				                    	<span class="deleteRole" data-id = "${role.getIdRole()}"><i class="fa fa-times delete"></i></span>
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
		   <!-- modal -->
		    <div id="editRole" class="modal fade" role="dialog">
			  <div class="modal-dialog">
	   			 <!-- Modal content-->
			    <div class="modal-content">
			      <div class="modal-header">
			      <h4 class="modal-title">Chỉnh Chức Vụ</h4>
			        <button type="button" class="close" data-dismiss="modal">&times;</button>		        
			      </div>
			      <div class="modal-body">
			      	<div class="text-center text-danger" id="errorGetRole"></div><br/>			      	
				      <div class="form-group row">
					    <label for="nameEditRole" class="col-sm-3 col-form-label">Tên Chức Vụ</label>
					    <div class="col-sm-9">
					     <input type="text" name="nameEditRole" class="form-control" id="nameEditRole" placeholder="Nhập Tên Chức Vụ">
					    </div>
					  </div>
					  <div class="form-group row">
					    <label for="codeEditRole" class="col-sm-3 col-form-label">Tên Chức Vụ</label>
					    <div class="col-sm-9">
					     	<input type="text" readonly="readonly" name="codeEditRole" class="form-control" id="codeEditRole">
					    </div>
					  </div>
				      <input name="idEditRole" type="hidden" id="idEditRole">
			      </div>
			      <div class="modal-footer">
			      	<button type="button" id="saveChangeRole" class="btn btn-primary">Lưu</button>
			        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			      </div>
			    </div>		
			  </div>
			</div>
		   <!--/.modal -->
	    </section>
	    <!-- /.content -->
  	</div>    	
    	<jsp:include page="_shareLayout/_footer.jsp"></jsp:include>
    </div>
	<jsp:include page="_shareLayout/footer.jsp"></jsp:include>
	</body>
</html>