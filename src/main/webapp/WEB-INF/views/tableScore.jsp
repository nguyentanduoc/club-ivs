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
	              <li class="breadcrumb-item"><a href="#">Trang chủ</a></li>
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
            		<div class="col-md-6">
            			 <h3 class="card-title">Điểm Số</h3>
            		</div>
            		<div class="col-md-6">
            			 <div class="form-group row">       			 	              
			             	<input name="month" id="month" type="text" class="month-piker form-control col-md-9" placeholder="Chọn Tháng"/>
			              	<div class="col-md-2 text-center">
			              		<button type="button" class="btn btn-outline-primary">Tìm</button>
			              	</div>
			              	 <div class="col-md-1">
	            				 <a class="btn btn-success float-right" href="<c:url value="/to-grade/exportExcel"/>" role="button"><i class="fa fa-file-excel-o" aria-hidden="true"></i></a>   	
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
				                  <th>Điểm phát sinh</th>	
				                  <th>Ghi chú</th>	
				                  <th>Yêu cầu thưởng</th>	
				                  <th>Hoàn tất</th>				                 
				                </tr>
				                </thead>
				                <tbody>
				                <c:if test="${sums!=null}">
				                 <c:forEach var="score" items="${sums}">
					                  <tr>
					                  	<td>${score.getMember().getNameMember()}</td>
					                    <td>${score.getScoreClub()}</td>
					                    <td><input class="form-control" type="number" min="-100" max="100" id="num-${score.getIdSum()}" value="${score.getToAriseScore()}"/></td>
					                    <td><input class="form-control" type="text" id="txt-${score.getIdSum()}" value="${score.getNote()}"/></td>
					                    <td >
					                   		<div class="btn-group btn-group-toggle" data-toggle="buttons">
						                    	<label class="btn btn-outline-primary ${score.isRequireDonate()==false ?'active':''} btn-sm offRequire" data-id="${score.getIdSum()}">
													<input type="radio" name="options" id="option1" autocomplete="off" checked><i class="fa fa-circle-thin" aria-hidden="true"></i>
												</label>
												<label class="btn btn-outline-primary btn-sm onRequire ${score.isRequireDonate()==true?'active':''}" data-id="${score.getIdSum()}" >
													<input type="radio" name="options" id="option3" autocomplete="off"><i class="fa fa-check" aria-hidden="true"></i>
												</label>
											</div>
					                    </td>	
					                    <td>
					                    	<button type="button" class="btn btn-info btn-sm update" id="${score.getIdSum()}" data-id="${score.getIdSum()}"><i class="fa fa-pencil-square-o" aria-hidden="true"></i></button>
					                    </td>	                               
					                  </tr>	
			                  	 </c:forEach>  
				                </c:if>
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
    		var check;
    		var status=false;
    		$(".onRequire").change(function(){
    			check = $(this).attr('data-id');
    			status = true;
    		});
    		$(".offRequire").change(function(){
    			check = $(this).attr('data-id');
    			status = false;
    		});    		
    		$(".update").click(function(){ 
    			var id = $(this).attr('data-id');
    			var note ="";
    			note = $("#txt-"+id).val();
    			var require=false;
    			var toArise = $("#num-"+id).val();
    			if(check==id){
    				require=status;
    			} 	
    			if(toArise==null||toArise==""){
    				toArise=0;
    			}
    			$.ajax({
    				url:"/Club-IVS/to-grade/updateScore",
    				type:"POST",
    				data:{
    					id:id, 
    					toArise:toArise,
    					note:note, 
    					require :require 					
    				},
    				success:function(data){
    					if(data.status==200){
    						$("#"+id).addClass("active disabled");
    					}else{
    						alert("Xảy ra lỗi!");
    					}
    				}	
    			})
    		});
    	});
    </script>
</body>
</html>