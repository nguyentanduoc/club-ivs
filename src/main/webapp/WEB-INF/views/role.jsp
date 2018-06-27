<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true"%>
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
	          <div class="col-md-6">
	            <!-- general form elements -->
	            <div class="card card-primary">
	              <div class="card-header">
	                <h3 class="card-title">Thêm Chức Vụ</h3>
	              </div>
	              <!-- /.card-header -->
	              <!-- form start -->
	              <form method="post" action="${pageContext.request.contextPath}/role/create">
	                <div class="card-body">
	                  <div class="form-group">
	                    <label for="nameRole">Tên Chức Vụ</label>
	                    <input type="text" name="nameRole" class="form-control" id="nameRole" placeholder="Nhập Tên Chức Vụ">
	                  </div>
	                </div>
	                 <input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
	                <!-- /.card-body -->	
	                <div class="card-footer">
	                  <input type="submit" class="btn btn-primary" value="Thêm"/>
	                </div>
	              </form>
	            </div>
	            <!-- /.card -->
		    	</div>
		    	<div class="col-md-6">
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
		                    <th style="width:150px">Tuỳ Chỉnh</th>	          	       	 
		                  </tr>
		                     <c:forEach var="role" items="${listRole}">
				                  <tr>
				                  	<td>${role.getIdRole()}</td>
				                    <td>${role.getNameRole()}</td>		                    
				                    <td>
				                    	<span class="deleteRole" data-id = "${role.getIdRole()}"><i class="fa fa-times delete"></i></span>		                    	
				                    	<span class="editRole" data-id = "${role.getIdRole()}"> <i class="fa fa-pencil edit" aria-hidden="true"></i></span>
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
	</body>
</html>