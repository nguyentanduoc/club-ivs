<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true"%>
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
	            <h1 class="m-0 text-dark">Câu lạc bộ</h1>
	          </div><!-- /.col -->
	          <div class="col-sm-6">
	            <ol class="breadcrumb float-sm-right">
	              <li class="breadcrumb-item"><a href="#">Thêm thành viên</a></li>
	              <li class="breadcrumb-item active">Thành Viên</li>
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
	          <div class="col-md-7">
	            <!-- general form elements -->
	            <div class="card">
	              <div class="card-header">
	                <h3 class="card-title">Danh sách hoạt động</h3>
	                <div class="card-tools">
	                  <div class="input-group input-group-sm" style="width: 200px;">
	                    <select class="form-control" id="club">
	                     	<option>---Chọn CLB---</option>
		                     <c:forEach var="club" items="${clubs}">
		                     	<option value="${club.getIdClub()}">${club.getNameClub()}</option>
		                    </c:forEach>
	                    </select>	                    
	                  </div>
	                </div>
	              </div>
	              <!-- /.card-header -->
	              <div class="card-body">
	              	<div id="message"></div>
	                <table class="table table-bordered">
	                  <tr>	                    
	                    <th>Tên nhân viên</th>
	                    <th>Ngày tham gia</th>	                    
	                  </tr>
	                  <tbody id="member">
	                  </tbody>      
	                </table>
	              </div>
	              <!-- /.card-body -->
	              <div class="card-footer clearfix">
	               	Tổng thành viên tham gia: <label id="total" class="pl-3 text-danger"></label>
	              </div>
	            </div>
	            <!-- /.card -->
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
	<script>
		$(document).ready(function(){
			$("#club").change(function(){
				$("#message").empty();
				$("#member").empty();
				$("#total").empty();
				var total=0;
				var view="";
				var idClub =  $("#club").val();
				$.ajax({
					url:"/Club-IVS/club/getMemberJoinClub",
					type:"POST",
					data:{
						"idClub":idClub
					},
					success:function(data){
						if(data.status==200){
							$.each(data.member,function (index, row){
								view +="<tr><td>"+row.member.nameMember+"</td><td>"+date(row.dateJoin)+"</td></tr>";
								total+=1;
							});
							$("#total").append(total);
							$("#member").append(view);
						}else{
							$("#message").append("Xảy ra lỗi!");
						}
						
					}
				})
			});
		});
	</script>
</html>