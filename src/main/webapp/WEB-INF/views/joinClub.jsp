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
	            <h1 class="m-0 text-dark">Thêm thành viên vào câu lạc bộ</h1>
	          </div><!-- /.col -->
	          <div class="col-sm-6">
	            <ol class="breadcrumb float-sm-right">
	              <li class="breadcrumb-item"><a href="#">Thêm thành viên</a></li>
	              <li class="breadcrumb-item active">Câu lạc bộ</li>
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
	                <h3 class="card-title">Thêm Thành Viên Vào Nhóm</h3>
	              </div>
	              <!-- /.card-header -->
	              <!-- form -->
	              	<form method="POST" action="${pageContext.request.contextPath}/club/joinClub">	          
		                <div class="card-body">
		                	<c:choose>
							    <c:when test="${status==403}">
							        <div class="text-danger text-center">
							        	<h4><c:out value="${message}"/></h4>
							        </div>
							    </c:when>    
							    <c:otherwise>
							      <div class="form-group">
							      	<c:choose>
							      		<c:when test="${status==200}">
									        <div class="text-success text-center">
									        	<h4><c:out value="${message}"/></h4>
									        </div>
								   		</c:when> 
								   		<c:otherwise>								   			
									        <div class="text-success text-center">
									        	<h4><c:out value="${message}"/></h4>
									        </div>								   		
								   		</c:otherwise>
							      	</c:choose>
					                 <label for="idMember">Chọn Thành Viên</label>					              
					                  <select id="idMember" name="idMember"  class="form-control select2" style="width: 100%;">
					                    <option value="0">--- Chọn Nhân Viên ---</option>
					                      <c:forEach var="member" items="${members}">									
											  <option value="${member.getIdMember()}">${member.getNameMember()}</option>
										</c:forEach>
					                  </select>
									</div>  
									<div class="form-group">
					                 	<label for="clubs">Chọn câu lạc bộ</label>		
						                 <ul id="clubs">
						                 	<c:forEach var="club" items="${clubs}">				                
												<li>
													<input class="flat-red" type="checkbox" name="clubs" value="${club.getIdClub()}"/>${club.getNameClub()}											
												</li>
											</c:forEach>
						                 </ul>                   
									</div> 
							    </c:otherwise>
							</c:choose>
			             </div><!-- /.card-body -->	
			            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		                <div class="card-footer">
		                  <input type="submit" class="btn btn-primary float-right" value="Thêm"/>
		                </div>	             
	              </form>
	               <!-- ./form -->
	            </div>
	            <!-- /.card -->
		    	</div>	
		    	<div class="col-md-8"> 
		    		<div class="card">
						<div class="card-header">
							<h3 class="card-title">Danh sách Tham gia Câu Lạc Bộ</h3>
						</div><!-- /.card-header -->
						<div class="card-body p-0">
							<div class="text-danger text-center" id="messageJoinClub"></div>
							<table class="table" id="tableJoinClub">
			                  <tr>		                   
			                    <th>Tên CLB</th>
			                    <th>Ngày tham gia</th>
			                    <th>Ngày ngưng hoạt động</th>		      
			                    <th>Tình hiện tại</th>  
			                  </tr>
			                   <tbody id="listJoinClub">
			                        
		                  	  </tbody>	                  
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
		$("#tableJoinClub").hide();
		$("#idMember").change(function(){
			
			$("#messageJoinClub").empty();
			$("#listJoinClub").empty();
			var idMember = $("#idMember").val();
			$.ajax({
				url:"/Club-IVS/api/getJoinClub",
				type:"POST",
				data:{
					"idMember":idMember,				
				},
				success:function(data){
					if(data.status==200){	
						$("#tableJoinClub").show();	
						var view;
						$.each(data.joinClubs, function (index, row) {
							var dateLeave  ="";
							if(row.dateLeave!=null){
								dateLeave  = date(row.dateLeave);
							}
							var dateJoin =  date(row.dateJoin);
							view +=  "<tr>" ;
							view += "<td>"+row.club.nameClub+"</td>";
							view += "<td>"+dateJoin+"</td>";
							view += "<td>"+dateLeave+"</td>";
						
							if(row.status==true){
								view +="<td><div class='btn-group btn-group-toggle' data-toggle='buttons'>"
								  	+"<label class='btn btn-outline-primary active btn-sm'>"
							    	+"<input type='radio' autocomplete='off' checked> On </label>"
								 	+"<label class='btn btn-outline-primary btn-sm' onclick='offActive("+row.idJoinClub+")'> <input type='radio' autocomplete='off'>Off</label></div></td>";
							}else{
								view +="<td><div class='btn-group btn-group-toggle disabled' data-toggle='dispose'>"
								  	+"<label class='btn btn-outline-primary btn-sm '>"
							    	+"<input type='radio' autocomplete='off'> On </label>"
								 	+"<label class='btn btn-outline-primary active btn-sm'> <input type='radio' autocomplete='off' checked>Off</label></div></td>";
							}
								
							view += "</tr>"; 
							 /*$("#clubs").each(function(index1,element){
							        console.log(element);
							    });*/
	                    })
						$("#listJoinClub").append(view);
					}else{
						if(data.status==404){
							$("#messageJoinClub").append("Thành viên này chưa tham gia câu lạc bộ nào!");
						}else{
							$("#messageJoinClub").append("Đã xảy ra lỗi!");
						}
					}
					
				}
			});	
		});		
		
	})
	function offActive(idJoinClub){
		$("#messageJoinClub").empty();
		$.ajax({
			url:"/Club-IVS/club/active",
			type:"POST",
			data:{
				"idJoinClub":idJoinClub,	
				"status":0
			},
			success:function(data){
				if(data.status==200){
					$("#messageJoinClub").append("Thành công!");
					$("#messageJoinClub").removeClass("text-danger");
					$("#messageJoinClub").addClass("text-success");
				}else{
					$("#messageJoinClub").append("Thất bại!");
				}
			}
		});
	}
	</script>
	</body>
</html>