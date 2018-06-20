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
		    	<div class="col-md-6">
		            <div class="card">
		              <div class="card-header">
		                <h3 class="card-title">Lịch Train</h3>
		                
		              </div>
		              <!-- /.card-header -->
		              <div class="card-body p-0">
		                <table class="table">
		                  <tr>		                   
		                    <th>#</th>
		                    <th>tên sự kiện</th>
		                    <th>tên câu lạc bộ</th>
		                    <th>Lịch</th>      
		                                 
		                    <th style="width:150px">Tuỳ Chỉnh</th>	                 	 
		                  </tr>
	                      	   <c:forEach var="schedule" items="${listTrain}">
				                       <tr>
				                  	<td>${train.getIdTrain()}</td>
				                    <td>${train.getSchedule().getNameSchedule()}</td>	   
				                    <td>${train.getClub().getNameClub}</td>
				                    <td>${train.getDateTrain()}</td>	                    
				                    <td>
				                    
				                    	<span class="deleteTrain" data-id = "${train.getIdTrain()}"><i class="fa fa-times delete"></i></span>		                    	
				                    	<span class="editTrain" data-id = "${train.getIdTrain()}"> <i class="fa fa-pencil edit" aria-hidden="true" data-toggle="modal" data-target="#editSchedule"></i></span>
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
    	<jsp:include page="../_shareLayout/_footer.jsp"></jsp:include>
    </div>
	<jsp:include page="../_shareLayout/footer.jsp"></jsp:include>
	</body>
</html>