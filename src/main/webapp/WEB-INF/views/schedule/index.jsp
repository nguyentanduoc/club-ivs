<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
	<head>		
		<jsp:include page="../_shareLayout/header.jsp"></jsp:include>
	</head>
	<body class="hold-transition sidebar-mini">
	 <div class="wrapper">
    	<jsp:include page="../_shareLayout/_navbar.jsp"></jsp:include>
    	<jsp:include page="../_shareLayout/_sidebar.jsp"></jsp:include>	
    	
    	<div class="content-wrapper">
	    <!-- Content Header (Page header) -->
	    <div class="content-header">
	      <div class="container-fluid">
	        <div class="row mb-2">
	          <div class="col-sm-6">
	            <h1 class="m-0 text-dark">Sự kiện</h1>
	          </div><!-- /.col -->
	          <div class="col-sm-6">
	            <ol class="breadcrumb float-sm-right">
	              <li class="breadcrumb-item"><a href="#">Tạo sự kiện</a></li>
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
	                <h3 class="card-title">Thêm Event</h3>
	              </div>
	              <!-- /.card-header -->
	              <!-- form start -->
	              <form:form method="POST" modelAttribute="schedule" action="/Club-IVS/schedule/">	          
	                <div class="card-body">
		                <c:if test="${status}">
		                	<div class="alert alert-danger">
							  <c:out value="${status}"></c:out>
							</div>
		                </c:if>
		                  <div class="form-group">
		                    <label for="nameSchedule">Tên Event</label>
		                    <!-- <input type="text" name=nameSchedule class="form-control" id="nameSchedule" placeholder="Nhập Tên Evnet"> -->
		                  	<form:input type="text" path="nameSchedule" class="form-control" id="nameSchedule" placeholder="Nhập Tên Event"/>
		                  </div>
		                   <div class="form-group">
		                    <label for="exampleInputEmail1">Chọn lịch</label>
		                    
 		                    <form:select path="DateOfWeek.idDow" class="form-control">
 		                    	<form:option value="0" label="--- Chọn một ngày ---" />					  			 
		                    	<form:options items="${listDow}" itemValue="idDow" itemLabel="nameDow" /> 
		                    </form:select> 		                   
		                  </div>
		                   <div class="bootstrap-timepicker">
                  <div class="form-group">
                    <label>Time picker:</label>
                    <div class="input-group">
                    <form:input type="text" path="timeSchedule" class="form-control timepicker" id="timeSchedule"/>
                     <!--  <input type="text" class="form-control"> -->
                      <div class="input-group-append">
                        <span class="input-group-text"><i class="fa fa-clock-o"></i></span>
                      </div>
                    </div>
                    <!-- /.input group -->
                  </div>
                  <!-- /.form group -->
                </div>
		                  <div class="form-group">
		                    <label for="exampleInputEmail1">Địa điểm</label>
		                   
		                    <form:textarea path="locationSchedule" class="form-control"  id="locationSchedule" placeholder="Nhập địa điểm" rows="3"/>
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
		                <h3 class="card-title">Danh Sách Sự kiện</h3>
		                
		              </div>
		              <!-- /.card-header -->
		              <div class="card-body p-0">
		                <table class="table">
		                  <tr>		                   
		                    <th>#</th>
		                    <th>Tên Sự kiện</th>
		                    <th>Ngày</th>
		                    <th>Thời gian</th>      
		                     <th>Địa điểm</th>
		                                 
		                    <th style="width:150px">Tuỳ Chỉnh</th>	                 	 
		                  </tr>
	                      	   <c:forEach var="schedule" items="${listSchedule}">
				                       <tr>
				                  	<td>${schedule.getIdSchedule()}</td>
				                    <td>${schedule.getNameSchedule()}</td>
				                    <td>${schedule.getDateOfWeek().getNameDow()}</td>	   
				                    <td>${schedule.getTimeSchedule()}</td>
				                    <td>${schedule.getLocationSchedule()}</td>	                    
				                    <td>
				                    	<span class="deleteSchedule" data-id = "${schedule.getIdSchedule()}"><i class="fa fa-times delete"></i></span>		                    	
				                    	<span class="editSchedule" data-id = "${schedule.getIdSchedule()}"> <i class="fa fa-pencil edit" aria-hidden="true" data-toggle="modal" data-target="#editSchedule"></i></span>
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
		      <input name="idEditRole" type="hidden" id="idEditRole">
		       	<div class="form-group">
                   <label for="exampleInputEmail1">Tên Chức Vụ</label>
                   <input type="text" name="nameEditRole" class="form-control" id="nameEditRole" placeholder="Nhập Tên Chức Vụ">
                 </div>
		      </div>
		      <div class="modal-footer">
		      	<button type="button" id="saveChangeRole" class="btn btn-primary">Lưu</button>
		        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
		      </div>
		    </div>		
		  </div>
		</div>
		   <!--/.modal -->
  	</div>    	
    	<jsp:include page="../_shareLayout/_footer.jsp"></jsp:include>
    </div>
	<jsp:include page="../_shareLayout/footer.jsp"></jsp:include>
	</body>
</html>