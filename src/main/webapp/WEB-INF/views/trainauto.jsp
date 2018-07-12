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
	            
	          </div><!-- /.col -->
	          <div class="col-sm-6">
	            <ol class="breadcrumb float-sm-right">
	              <li class="breadcrumb-item"><a href='<c:url value="/train/trainauto"/>'>Trang chủ</a></li>
	              <li class="breadcrumb-item active">Lịch tạo tự động</li>
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
		            <div class="card-primary">
		              <div class="card-header">
		              
		                <h3 class="card-title">Lịch tự động tạo</h3>
		                
		              </div>
		              <!-- /.card-header -->
		              <div class="card-body p-0">
		                <table class="table table-hover table-sm table-info">
		                <thead align="center">
		                  <tr>
		                    <th>Tên Sự kiện</th>
		                    <th>Ngày</th>
		                    <th>Thời gian</th>
		                    <th>Tuần</th>     
		                    <th>Địa điểm</th>
		                    <th>Sắp lịch</th>          
		                    <th>Tuỳ Chỉnh</th>	                 	 
		                  </tr>
		                 </thead>
	                     <c:forEach var="train" items="${listTrainAuto}">
	                     <tbody>
				             <tr>
				             	<td>${train.getSchedule().getNameSchedule()}</td>
				                <td align="center"><fmt:formatDate value="${train.getDateTrain()}" pattern="dd-MM-yyyy"/></td>	 
				                <td align="center">${train.getSchedule().getTimeSchedule()}</td>
				                <td align="center">${train.getWeekend()}</td>
				                <td>${train.getSchedule().getLocationSchedule()}</td>
				                <td align="center">
					                <c:choose>
							            <c:when test ="${train.getSchedule().getAutoSchedule()==true}">
											tự động
										</c:when>    
										<c:when test ="${train.getSchedule().getAutoSchedule()==false}">
											thủ công
										</c:when>
								    </c:choose>
				                </td>
				                <td align="center">
				                	<span class="deleteTrain" data-id = "${train.getIdTrain()}"><i class="fa fa-times delete"></i></span>
				                </td>                          
			                  </tr>
			                  </tbody>
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