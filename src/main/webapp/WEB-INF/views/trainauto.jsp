<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
	            <h1 class="m-0 text-dark">Create an automatic calendar</h1>
	          </div><!-- /.col -->
	          <div class="col-sm-6">
	            <ol class="breadcrumb float-sm-right">
	              <li class="breadcrumb-item"><a href="#">Tạo lịch tự động</a></li>
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
	          
		    	
		    	<div class="col-md-12">
		            <div class="card">
		              <div class="card-header">
		                <h3 class="card-title">Sự kiện được tạo tự động</h3>
		                
		              </div>
		              <!-- /.card-header -->
		              <div class="card-body p-0">
		                <table class="table">
		                  <tr>		                   
		                    
		                    <th>Tên Sự kiện</th>
		                    <th>Ngày</th>
		                    <th>Thời gian</th>      
		                    <th>Địa điểm</th>
		                    <th>Sắp lịch</th>
		                                 
		                    <th style="width:150px">Tuỳ Chỉnh</th>	                 	 
		                  </tr>
	                      	   <c:forEach var="train" items="${listTrain}">
				                       <tr>
				                  	
				                    <td>${train.getSchedule().getNameSchedule()}</td>
				                    <td>
				                    <fmt:formatDate value="${train.getDateTrain()}" pattern="dd-MM-yyyy"/>
				                    </td>	 
				                      
				                    <td>${train.getSchedule().getTimeSchedule()}</td>
				                    <td>${train.getSchedule().getLocationSchedule()}</td>	                    
				                    <td>
				                    <c:choose>
					                    <c:when test ="${train.getSchedule().getAutoSchedule()==true}">
								            tự động
								         </c:when>
								         
								         <c:when test ="${train.getSchedule().getAutoSchedule()==false}">
								            thủ công
								         </c:when>
							         </c:choose>
				                    </td>
				                    <td>
				                    	<span class="deleteSchedule" data-id = "${train.getSchedule().getIdSchedule()}"><i class="fa fa-times delete"></i></span>		                    	
				                    	<span class="editSchedule" data-id = "${train.getSchedule().getIdSchedule()}"> <i class="fa fa-pencil edit" aria-hidden="true" data-toggle="modal" data-target="#editSchedule"></i></span>
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