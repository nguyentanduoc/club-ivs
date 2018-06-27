<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="false"%>
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
	            <h1 class="m-0 text-dark">Schedule Booking</h1>
	          </div><!-- /.col -->
	          <div class="col-sm-6">
	            <ol class="breadcrumb float-sm-right">
	              <li class="breadcrumb-item"><a href="#">Schedule</a></li>
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
	                <h3 class="card-title">Thêm Lịch</h3>
	              </div>
	              <!-- /.card-header -->
	              <!-- form start -->
	              <form:form method="post" action="" modelAttribute="dow">
	                <div class="card-body">
	                  <div class="form-group">
	                    <label for="nameDow">Thứ</label>	                   
	                  	<form:input type="text" path="nameDow" class="form-control" id="nameDow" placeholder="Nhập thứ"/>
	                    <label for="variableDow">Giá trị</label>
	                    <form:input type="text" path="variableDow" class="form-control" id="variableDow" placeholder="Nhập giá trị"/>
	                  </div>
	                </div>
	                <!-- /.card-body -->	
	                <div class="card-footer">
	                  <input type="submit" class="btn btn-primary" value="Thêm"/>
	                </div>
	              </form:form>
	            </div>
	            <!-- /.card -->
		    	</div>
		    	<div class="col-md-6">
		            <div class="card">
		              <div class="card-header">
		                <h3 class="card-title">Danh Sách lịch</h3>	
		                
		              </div>
		              <!-- /.card-header -->
		              <div class="card-body p-0">
		                <table class="table">
		                  <tr>		                   
		                    <th style="width: 10px">#</th>
		                    <th>Thứ</th>
		                    <th>Giá trị</th>	                  
		                    <th style="width:150px">Tuỳ Chỉnh</th>	                 	 
		                  </tr>
		                     <c:forEach var="dow" items="${listDow}">
				                  <tr>
				                  	<td>${dow.getIdDow()}</td>
				                    <td>${dow.getNameDow()}</td>
				                    <td>${dow.getVariableDow()}</td>		                    
				                    <td>
				                    	<span class="deleteDow" data-id = "${dow.getIdDow()}"><i class="fa fa-times delete"></i></span>		                    	
				                    	<span class="editDow" data-id = "${dow.getIdDow()}"> <i class="fa fa-pencil edit" aria-hidden="true"></i></span>
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