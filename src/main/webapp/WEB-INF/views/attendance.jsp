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
	            <h1 class="m-0 text-dark">Điểm danh</h1>
	          </div><!-- /.col -->
	          <div class="col-sm-6">
	            <ol class="breadcrumb float-sm-right">
	              <li class="breadcrumb-item"><a href="#">Điểm danh</a></li>
	              <li class="breadcrumb-item active">Index</li>
	            </ol>
	          </div><!-- /.col -->
	        </div><!-- /.row -->
	      </div><!-- /.container-fluid -->
	    </div><!-- /.content-header -->
	   <!-- Small Box (Stat card) -->
        
        <div class="row p-2">
         <c:forEach var="train" items="${listAllTrainOnWeek}">
          <div class="col-lg-3 col-6">
            <!-- small card -->
            <div class="small-box bg-info">
              <div class="inner">
                <h3>${train.getSchedule().getClub().getNameClub()}</h3>
                <p>${train.getSchedule().getNameSchedule()}</p>
              </div>
              <div class="icon">
                <i class="fa fa-star"></i>
              </div>
              <a href="#" class="small-box-footer diemdanh" data-toggle="modal" data-target="#attendance" data-id="${train.getIdTrain()}">
                Điểm danh <i class="fa fa-arrow-circle-right"></i>
              </a>
            </div>
          </div>
          </c:forEach>
          <div class="modal fade" id="attendance" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
			  <div class="modal-dialog" role="document">
			    <div class="modal-content">
			      <div class="modal-header">
			        <h5 class="modal-title" id="attendance">Điểm danh</h5>
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
			          <span aria-hidden="true">&times;</span>
			        </button>
			      </div>
			      <div class="modal-body">
			        <div class="col-md-12">
		            <div class="card">
		              
		              <div class="card-body p-1">
		                <table class="table">
		                  <tr>
		                    
		                    <th>Họ tên</th>
		                    <th>Giới tính</th>      
		                    <th>Có mặt</th>
		                    <th>Điểm danh</th>
		                   
		                    </tr> 
		                    <tbody id="ListAttendace">
		                    
		                    </tbody>   
		                </table>
		                
		              </div>
		              <!-- /.card-body -->
		            </div>
		    	</div>
			      </div>
			      <div class="modal-footer">
			        <button type="button" class="btn btn-primary" data-dismiss="modal">Xong</button>
			        
			      </div>
			    </div>
			  </div>
			</div>
         
        </div>
        <!-- /.row -->
	    
  	</div>    	
    	<jsp:include page="_shareLayout/_footer.jsp"></jsp:include>
    </div>
	<jsp:include page="_shareLayout/footer.jsp"></jsp:include>
	</body>
</html>