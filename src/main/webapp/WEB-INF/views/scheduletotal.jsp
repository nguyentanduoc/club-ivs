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
					<li class="breadcrumb-item"><a href="<c:url value="/train/index"/>">Thêm lịch thủ công</a></li>
					<li class="breadcrumb-item active"><a>Tất cả các lịch</a></li>
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
		            <h5 class="text-danger text-center" id="changeerror"></h5>
		              <div class="card-header">
		                <h3 class="card-title">Tất cả các lịch</h3>
		              </div>
		              <!-- /.card-header -->
		              <div class="card-body p-0">
		                <table class="table table-hover table-sm table-info">
		                <thead align="center">
		                  <tr>
		                    <th>Tên Sự kiện</th>
		                    <th>Thứ</th>
		                    <th>Thời gian</th>
		                    <th>Địa điểm</th>
		                    <th>Sắp lịch</th>      
		                    <th>Tuỳ Chỉnh</th>
		                    </tr> 
		                    </thead>
	                      <c:forEach var="schedule" items="${listSchedule}">
	                      	<tbody>
								<tr>
									<td>${schedule.getNameSchedule()}</td>
									<td align="center">${schedule.getDateOfWeek().getNameDow()}</td>
									<td align="center">${schedule.getTimeSchedule()}</td>
									<td>${schedule.getLocationSchedule()}</td>
									<td align="center"><div class="btn-group btn-group-toggle" data-toggle="buttons">
										<c:choose>
											<c:when test="${schedule.getAutoSchedule()==true}">
												<label class="btn btn-outline-primary active btn-sm onSchedule" data-id="${schedule.getIdSchedule()}">
													<input type="radio" name="options" id="option1" autocomplete="off" checked> Auto
												</label>
												<label class="btn btn-outline-primary btn-sm offSchedule" data-id="${schedule.getIdSchedule()}">
													<input type="radio" name="options" id="option3" autocomplete="off"> Manual
												</label>
								         	</c:when>
											<c:when test="${schedule.getAutoSchedule()==false}">
												<label class="btn btn-outline-primary btn-sm onSchedule" data-id="${schedule.getIdSchedule()}">
													<input type="radio" name="options" id="option1" autocomplete="off"> Auto
												</label>
												<label class="btn btn-outline-primary btn-sm offSchedule active" data-id="${schedule.getIdSchedule()}">
													<input type="radio" name="options" id="option3" autocomplete="off" checked> Manual
												</label>
								         	</c:when>
										</c:choose></div></td>
									<td align="center"><span class="deleteSchedule" data-id="${schedule.getIdSchedule()}"><i class="fa fa-times delete"></i></span>
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
	<script>
	$(document).ready(function(){
		$(".offSchedule").click(function(){
			var id = $(this).attr('data-id');
			$.ajax({
				url:"/Club-IVS/schedule/change",
				type:"POST",
				data:{
					idSchedule:id,
					autoSchedule:false
				},
				success:function(data){
					if(data.status==200){					
						location.reload();
					}else{
						$("#changeerror").append("Xảy ra lỗi chuyển đổi!");
					}
					}	
				})
			})
		$(".onSchedule").click(function(){
			var id = $(this).attr('data-id');
			$.ajax({
				url:"/Club-IVS/schedule/change",
				type:"POST",
				data:{
					idSchedule:id,
					autoSchedule:true
				},
				success:function(data){
					if(data.status==200){					
						location.reload();
					}else{
						$("#changeerror").append("Xảy ra lỗi chuyển đổi!");
					}
				}	
				})
			})
		});
	</script>
	</body>
</html>