<%@ page language="java" contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8" session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
	            <h1 class="m-0 text-dark">Danh sách Bản điểm</h1>
	          </div><!-- /.col -->
	          <div class="col-sm-6">
	            <ol class="breadcrumb float-sm-right">
	              <li class="breadcrumb-item"><a href="#">Home</a></li>
	              <li class="breadcrumb-item active">Bảng Điểm</li>
	            </ol>
	          </div><!-- /.col -->
	        </div><!-- /.row -->
	      </div><!-- /.container-fluid -->
	    </div><!-- /.content-header -->
	    <!-- Main content -->
	    <section class="content">
      <div class="row">
        <div class="col-12">
	    <div class="card">
            <div class="card-header">
            	<div class="row">
            		<div class="col-md-8">
            			 <h3 class="card-title">Điểm Số</h3>
            		</div>
            		<div class="col-md-4">
            			 <div class="form-group row">            			 	              
			             	<input name="month" id="month" type="text" class="month-piker form-control col-md-10" placeholder="Chọn Tháng"/>
			              	<div class="col-md-2">
			              		<button type="button" class="btn btn-outline-primary">Tìm</button>
			              	</div>
			              </div>
            		</div>
            	</div>          
            </div>
            <!-- /.card-header -->
            <div class="card-body">
            <c:choose>
               	<c:when test="${status!=null}">		                		
               		<c:choose>
	                	<c:when test="${status==200}">
	                		<table id="example1" class="table table-bordered table-striped">
				                <thead>
				                <tr>
				                  <th>Tên Thành Viên</th>
				                  <th>Điểm Số</th>
				                  <th>Yêu cầu thưởng</th>				                 
				                </tr>
				                </thead>
				                <tbody>
				                 <c:forEach var="score" items="${sums}">
					                  <tr>
					                  	<td>${score.getMember().getNameMember()}</td>
					                    <td>${score.getScoreClub()}</td>
					                    <td>
					                    	<span class="edit" data-id = "${score.getIdSum()}"> <i class="fa fa-check-square-o" aria-hidden="true"></i></span>	
					                    </td>	                               
					                  </tr>	
			                  	 </c:forEach>  
				                </tbody>
				                <tfoot>
				                <!-- <tr>
				                  <th>Tên Thành Viên</th>
				                  <th>Điểm Số</th>
				                  <th>Yêu cầu thưởng</th>
				                </tr>
				                </tfoot> -->
				           	</table>
	                	</c:when>
	                	<c:when test="${status==403}">		                		
			                <h5 class="text-danger text-center"><i class="icon fa fa-ban"></i>Bạn không có quyền truy cập!</h5>
	                	</c:when>
	                	<c:when test="${status==400}">		                		
			                <h5 class="text-danger text-center"><i class="icon fa fa-ban"></i>Xảy ra lỗi!</h5>
	                	</c:when>
	                </c:choose>
               	</c:when>
              </c:choose>              
            </div>
            <!-- /.card-body -->
          </div>
          <!-- /.card -->
	    <!-- /.content -->
  	</div>    	
    	<jsp:include page="_shareLayout/_footer.jsp"></jsp:include>
    </div>
	</section>
   	 </div>
    </div>
    <jsp:include page="_shareLayout/footer.jsp"></jsp:include>
</body>
</html>