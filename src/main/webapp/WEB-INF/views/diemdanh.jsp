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
	              <li class="breadcrumb-item"><a href="#">Điểm danh</a></li>
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
		            <div class="card-primary">
		              <div class="card-header">
		                <h3 class="card-title">Danh sách thành viên</h3>
		              </div>
		              <!-- /.card-header -->
		              <div class="card-body p-0">
		                <table class="table table-hover table-sm table-info">
		                <thead align="center">
		                  <tr>
		                    <th>Họ tên</th>
		                    <th>Giới tính</th>
		                    <th>Sự kiện</th>
		                    <th>Điểm danh</th>
		                    <th>Lý do vắng</th>
		                    <th>Hoàn tất</th>            	 
		                  </tr>
		                 </thead>
	                     	<c:forEach var="attendance" items="${listAttendance}">
	                      	  <tbody>
				              	<tr>
					              <td>${attendance.getMember().getNameMember()}</td>
					              <td align="center">
					              <c:choose>
							          	<c:when test ="${attendance.getMember().isSexMember()==true}">
											nam
										</c:when>
										         
										<c:when test ="${attendance.getMember().isSexMember()==false}">
											nữ
										</c:when>
									</c:choose>
									</td>
							        <td>${attendance.getTrain().getSchedule().getNameSchedule()}</td>
				                    <td align="center"><div class="btn-group btn-group-toggle" data-toggle="buttons">
										<c:choose>
											<c:when test="${attendance.isAttendance()==true}">
												<label class="btn btn-outline-primary active btn-sm onAttendance" data-idMember="${attendance.getMember().getIdMember()}" data-idTrain="${attendance.getTrain().getIdTrain()}">
													<input type="radio" name="options" id="option1" autocomplete="off" checked> Present
												</label>
												<label class="btn btn-outline-primary btn-sm offAttendance" data-idMember="${attendance.getMember().getIdMember()}" data-idTrain="${attendance.getTrain().getIdTrain()}">
													<input type="radio" name="options" id="option3" autocomplete="off"> Absent
												</label>
											</c:when>
											<c:when test="${attendance.isAttendance()==false}">
												<label class="btn btn-outline-primary btn-sm onAttendance" data-idMember="${attendance.getMember().getIdMember()}" data-idTrain="${attendance.getTrain().getIdTrain()}">
													<input type="radio" name="options" id="option1" autocomplete="off"> Present
												</label>
												<label class="btn btn-outline-primary btn-sm active offAttendance" data-idMember="${attendance.getMember().getIdMember()}" data-idTrain="${attendance.getTrain().getIdTrain()}">
													<input type="radio" name="options" id="option3" autocomplete="off" checked> Absent
												</label>
										    </c:when>
										</c:choose>
									</div></td>
									<td><textarea class="form-control" id="${attendance.getMember().getIdMember()}-${attendance.getTrain().getIdTrain()}" readonly rows="1">${attendance.getReason()}</textarea></td>
									<td align="center"><input type="button" id="btn-${attendance.getMember().getIdMember()}-${attendance.getTrain().getIdTrain()}" data-idMember="${attendance.getMember().getIdMember()}" data-idTrain="${attendance.getTrain().getIdTrain()}" class="btn btn-light xong" value="Xong" disabled/></td>                        
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
		var attendance;
		var tae;
		$(".xong").click(function(){
			var idMember = $(this).attr('data-idMember');
			var idTrain = $(this).attr('data-idTrain');
			var reason = $("#"+idMember+"-"+idTrain).val();			
			var idMember = $(this).attr('data-idMember');
			var idTrain = $(this).attr('data-idTrain');
			var reason = $("#"+idMember+"-"+idTrain).val();
			$.ajax({
				url:"/Club-IVS/attendance/check",
				type:"POST",
				data:{
					idMember:idMember,
					idTrain:idTrain,
					isAttendance:attendance,
					reason:reason
				},
				success:function(data){
					if(data.status==200){
					
					}else{
						$("#checkerror").append("Xảy ra lỗi chuyển đổi!");
					}
				}	
				})			
		})
		$(".offAttendance").click(function(){
			var idMember = $(this).attr('data-idMember');
			var idTrain = $(this).attr('data-idTrain');
			tae = $("#"+idMember+"-"+idTrain);
			tae.removeAttr("readonly");
			attendance=false;
			$("#btn-"+idMember+"-"+idTrain).removeAttr("disabled");
		})
		$(".onAttendance").click(function(){
			var idMember = $(this).attr('data-idMember');
			var idTrain = $(this).attr('data-idTrain');
			var tae = $("#"+idMember+"-"+idTrain);
			tae.empty();
			attendance=true;
			$("#btn-"+idMember+"-"+idTrain).removeAttr("disabled");
			})
		});
	</script>
	</body>
</html>