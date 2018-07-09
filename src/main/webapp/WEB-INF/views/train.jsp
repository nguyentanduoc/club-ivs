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
	              	<li class="breadcrumb-item"><a href="<c:url value="/schedule/index"/>">Thêm lịch tự động</a></li>
					<li class="breadcrumb-item active"><a>Thêm lịch thủ công</a></li>
					<li class="breadcrumb-item"><a href="<c:url value="/schedule/scheduletotal"/>">Tất cả các lịch</a></li>
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
	          <div class="col-md-4">
	            <!-- general form elements -->
	            <div class="card card-primary">
	              <div class="card-header">
	                <h3 class="card-title">Thêm Sự kiện</h3>
	              </div>
	              <!-- /.card-header -->
	              <!-- form start -->
	              <form method="POST" action="${pageContext.request.contextPath}/train/create">	          
	                <div class="card-body">
		                  <div class="form-group">
		                    <label for="nameSchedule">Tên Event</label>
		                  	<input type="text" name="nameSchedule" class="form-control" id="nameSchedule" placeholder="Nhập Tên Event"/>
		                  </div>
		                   
		                  <!-- dateTrain -->
		                  <div class="form-group">
		                    <label for="dateTrain">Ngày cụ thể</label>
		                    <input type="text" class="form-control datepicker" name="dateTrain" id="dateTrain" placeholder="Ngày tháng năm"/>
		                    </div>
		                  <!-- /dateTrain -->
		                  
		                 <div class="bootstrap-timepicker">
	                  <div class="form-group">
	                    <label>Thời gian:</label>
	                    <div class="input-group">
	                    <input type="text"  name="timeSchedule" class="form-control timepicker" id="timeSchedule"/>
	                     
	                      <div class="input-group-append">
	                        <span class="input-group-text"><i class="fa fa-clock-o"></i></span>
	                      </div>
	                    </div>
	                    <!-- /.input group -->
	                  </div>
                  <!-- /.form group -->
                </div>
		                  <div class="form-group">
		                    <label for="locationSchedule">Địa điểm</label>
		                   
		                    <textarea  name="locationSchedule" class="form-control"  id="locationSchedule" placeholder="Nhập địa điểm" rows="3"></textarea>
		                  </div>
		                  <div class="form-group">
		                    <label>Sắp lịch</label>
		                  
						  <input type="radio" name="autoSchedule" value="0" checked/> Thủ công
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
		    	
		    	<div class="col-md-8">
		            <div class="card-primary">
		              <div class="card-header">
		                <h3 class="card-title">Sự kiện được tạo thủ công</h3>
		                
		              </div>
		              <!-- /.card-header -->
		              <div class="card-body p-0">
		                <table class="table table-hover table-sm table-info">
		                <thead align="center">
		                  <tr>
		                    <th>Tên Sự kiện</th>
		                    <th>Ngày</th>
		                    <th>Thời gian</th>      
		                    <th>Địa điểm</th>
		                    <th>Sắp lịch</th>   
		                    <th>Tuỳ Chỉnh</th>	                 	 
		                  </tr>
		                  </thead>
	                      	   <c:forEach var="train" items="${listTrainManual}">
	                      	   <tbody>
				                       <tr>
				                  	
				                    <td>${train.getSchedule().getNameSchedule()}</td>
				                    <td align="center">
				                    <fmt:formatDate value="${train.getDateTrain()}" pattern="dd-MM-yyyy"/>
				                    </td>	 
				                      
				                    <td align="center">${train.getSchedule().getTimeSchedule()}</td>
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