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
	            <h1 class="m-0 text-dark">Xác nhận thưởng</h1>
	          </div><!-- /.col -->
	          <div class="col-sm-6">
	            <!-- <ol class="breadcrumb float-sm-right">
	              <li class="breadcrumb-item"><a href="#">Danh sách</a></li>
	              <li class="breadcrumb-item active">Bảng Điểm</li>
	            </ol> -->
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
									<th>Nội Dung</th>
					                <th>Xác Nhận Gửi</th>	
					                <th>Đã Nhận</th>                
				                </tr>
				                </thead>
				                <tbody>
			                          <c:forEach var="sum" items="${sums}">
						                  <tr>
						                  	<td>${sum.getMember().getNameMember()}</td>
						                    <td>${sum.getScoreBranch()}</td>
						                    <td align="center">
						                    	<input readonly="readonly"  id="txt-${sum.getIdSumBranch()}" value="${sum.getContainDonate()}" class="form-control" type="text"/></td>
						                    <td  align="center">
						                    	<c:choose>
						                    		<c:when test="${sum.isConfirmDonate()==false }">
						                    			<button type="button" class="btn btn-outline-info btn-sm update" id="${sum.getIdSumBranch()}" data-id="${sum.getIdSumBranch()}">
						                    				<i class="fa fa-check" aria-hidden="true"></i>
						                    			</button>
						                   			 </c:when>
						                   			 <c:when test="${sum.isConfirmDonate()==true }">
						                    			<label class="btn btn-primary btn-sm disabled">
								                    		<i class="fa fa-check" aria-hidden="true"></i>
								                    	</label>	
						                   			 </c:when>
						                    	</c:choose>			                    	
						                    </td>	
						                    <td  align="center">
						                    	<c:choose>
						                    		<c:when test="${sum.isConfirm()==false }">
						                    			<label class="btn btn-outline-primary btn-sm disabled">
								                    		<i class="fa fa-check" aria-hidden="true"></i>
								                    	</label>	
						                   			 </c:when>
						                   			 <c:when test="${sum.isConfirm()==true }">
						                    			<label class="btn btn-primary btn-sm active disabled">
								                    		<i class="fa fa-check" aria-hidden="true"></i>
								                    	</label>	
						                   			 </c:when>
						                    	</c:choose>			                    	
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
    	
    </div>
	</section>
   	 </div>
   	 <jsp:include page="_shareLayout/_footer.jsp"></jsp:include>
    </div>
    <jsp:include page="_shareLayout/footer.jsp"></jsp:include>
     <script>
    	$(document).ready(function(){
    		    		
    		$(".update").click(function(){ 
    			var id = $(this).attr('data-id');
    			    			
    			$.ajax({
    				url:"/Club-IVS/to-grade/confirmDonate",
    				type:"POST",
    				data:{
    					id:id    						
    				},
    				success:function(data){
    					if(data.status==200){
    						$("#"+id).removeClass("btn-outline-primary");
    						$("#"+id).addClass("btn-primary active");
    					}
    				}	
    			})
    		});
    	});
    </script>
</body>
</html>