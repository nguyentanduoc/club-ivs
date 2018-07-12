<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
	            <h1 class="m-0 text-dark">Trang cá nhân</h1>
	          </div><!-- /.col -->
	          <div class="col-sm-6">
	            <ol class="breadcrumb float-sm-right">
	              <li class="breadcrumb-item"><a href="#">Trang chủ</a></li>
	              <li class="breadcrumb-item active">Trang cá nhân</li>
	            </ol>
	          </div><!-- /.col -->
	        </div><!-- /.row -->
	      </div><!-- /.container-fluid -->
	    </div><!-- /.content-header -->
	    <!-- Main content -->
	    <section class="content">
      <div class="container-fluid">
        <div class="row">
          <div class="col-md-3">

            <!-- Profile Image -->
            <div class="card card-primary card-outline">
              <div class="card-body box-profile">
                <div class="text-center">
                <c:choose>
						<c:when test="${member.getAvartarMember()!=null}">
							 <img class="profile-user-img img-fluid img-circle"
		                       src='<c:url  value="${member.getAvartarMember()}"/>'
		                       alt="User profile picture">
						</c:when>
						<c:otherwise>
							 <img class="profile-user-img img-fluid img-circle"
		                       src='<c:url  value="../resources/dist/img/user-4.svg"/>'
		                       alt="User profile picture">
						</c:otherwise>
					</c:choose>                 
                </div>
                <h3 class="profile-username text-center"><c:out value="${member.getNameMember()}"/></h3>
                <p class="text-muted text-center">
                	<c:forEach items="${member.getRoles()}" var="role">
                		<c:out value="${role.getNameRole()}"/><br/>
                	</c:forEach>               	
                </p>                
              </div>
              <!-- /.card-body -->
            </div>
            <!-- /.card -->

            <!-- About Me Box -->
            <div class="card card-primary">
              <div class="card-header">
                <h3 class="card-title">Thông tin</h3>
              </div>
              <!-- /.card-header -->
              <div class="card-body">
                <strong><i class="fa fa-birthday-cake mr-1" aria-hidden="true"></i>Sinh Nhật</strong>					
                <p class="text-muted">
                 <c:choose>
						<c:when test="${member.getBirthDayMember()!=null}">
							<fmt:formatDate value="${member.getBirthDayMember()}" pattern="dd-MM-yyyy"/>
						</c:when>
						<c:otherwise>
							<i>Đang cập nhật</i>
						</c:otherwise>
					</c:choose>
                </p>
                <hr>
                <strong>Giới tính</strong>
                <p class="text-muted">
                	<c:choose>
						<c:when test="${member.isSexMember()==true}">
							Nam
						</c:when>
						<c:when test="${member.isSexMember()==false}">
							Nữ
						</c:when>
					</c:choose>
                </p>
                <hr>
                <strong><i class="fa fa-phone mr-1" aria-hidden="true"></i> Số Điện thoại</strong>
                <p class="text-muted">
                 <c:choose>
						<c:when test="${member.getPhoneNumberMember()!=null}">
							<c:out value="${member.getPhoneNumberMember()}"/>
						</c:when>
						<c:otherwise>
							<i>Đang cập nhật</i>
						</c:otherwise>
					</c:choose>
                </p>
                
              </div>
              <!-- /.card-body -->
            </div>
            <!-- /.card -->
          </div>
          <!-- /.col -->
          <div class="col-md-9">
            <div class="card">
              <div class="card-header p-2">
                <ul class="nav nav-pills">
                  <li class="nav-item"><a class="active nav-link" href="#settings" data-toggle="tab">Cập nhật thông tin</a></li>
                  <li class="nav-item"><a class="nav-link" href="#updateAvatar" data-toggle="tab">Cập nhật ảnh</a></li>
                  <li class="nav-item"><a class="nav-link" href="#chagePassWord" data-toggle="tab">Thay đổi mật khẩu</a></li>
                  <li class="nav-item"><a class="nav-link" href="#activity" data-toggle="tab">Điểm hàng tháng</a></li>
                  <li class="nav-item"><a class="nav-link" href="#timeline" data-toggle="tab">Nhật ký hoạt động</a></li>
                </ul>
              </div><!-- /.card-header -->
              <div class="card-body">
                <div class="tab-content">
                  <div class="active tab-pane" id="settings">
                    <form:form class="form-horizontal" path="member" modelAttribute="member" action="${pageContext.request.contextPath}/member/updateInfo">
                      <div class="form-group row">
                        <label for="nameMember" class="col-md-3 col-sm-2 control-label">Họ và Tên</label>
                        <div class="col-md-9 col-sm-10">
                          <form:input type="text" path="nameMember" class="form-control" placeholder="Nhập Họ và Tên"/>
                        </div>
                      </div>
                      <div class="form-group row">
                        <label for="isSexMember" class="col-md-3 col-sm-2 control-label">Giới tính</label>
                        <div class="col-sm-10 col-md-9">
                     
							<label class="mr-2">
			                	<form:radiobutton path="sexMember" value="true"/>Nam
			               	</label>
			                <label>
			                	<form:radiobutton path="sexMember" value="false"/>Nữ
			                </label>
                        </div>
                      </div>
                      <div class="form-group row">
                        <label for="birthDayMember" class="col-sm-2 col-md-3 control-label">Sinh Nhật</label>
                        <div class="col-sm-10 col-md-9">
						<fmt:formatDate var="fmtDate" value="${member.getBirthDayMember()}" pattern="dd/MM/yyyy"/>			
						<form:input class="form-control datepicker" path="birthDayMember" value="${fmtDate}" placeholder="Ngày tháng năm sinh"/>
						</div>
                      </div>
                      <div class="form-group row">
                        <label for="phoneNumerMember" class="col-sm-2 col-md-3 control-label">Số Điện Thoại</label>
                        <div class="col-sm-10 col-md-9">
							<form:input class="form-control" placeholder="Số điện thoại" path="phoneNumberMember"/>
                        </div>
                      </div>
                      <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                          <button type="submit" class="btn btn-success submit">Cập Nhật</button>
                        </div>
                      </div>
                    </form:form>
                  </div>
                  <!-- /.tab-pane -->
                  <div class="tab-pane" id="updateAvatar">
                  	<c:choose>
						<c:when test="${member.getAvartarMember()!=null}">
							 <img class="profile-user-img img-fluid img-circle"
		                       src='<c:url  value="${member.getAvartarMember()}"/>'
		                       alt="User profile picture">
						</c:when>
						<c:otherwise>
							 <img class="profile-user-img img-fluid"
		                       src='<c:url  value="../resources/dist/img/user-4.svg"/>'
		                       alt="User profile picture">
						</c:otherwise>
					</c:choose>                  
                    <form class="form-horizontal">
                      	<div class="form-group pt-2">
		                    <label for="exampleInputFile">Chọn Hình</label>
		                    <div class="input-group">
		                      <div class="custom-file">
		                        <input type="file" class="custom-file-input" id="exampleInputFile">
		                        <label class="custom-file-label" for="exampleInputFile">Choose file</label>
		                      </div>
		                      <div class="input-group-append">
		                        <span class="input-group-text" id="">Upload</span>
		                      </div>
		                    </div>
		                  </div>
		                  <div class="form-group row">
	                        <div class="col-sm-10 col-md-2">                          
	                          <button id="saveImage" type="submit" class="btn btn-primary">Lưu lại</button>
	                        </div>
	                      </div>
                    </form>
                  </div>
                  <div class="tab-pane" id="chagePassWord">
                  <form class="form-horizontal" action="${pageContext.request.contextPath}/member/updatePass" method="post">
                  	<div class="form-group row">
                        <label for="oldPassWord" class="col-md-3 col-sm-2 control-label">Mật khẩu cũ</label>
                        <div class="col-md-5 col-sm-10">
                          <input type="password" class="form-control" name="oldPassWord" id="oldPassWord" placeholder="Nhập mật khẩu cũ">
                          <span id="errorOldPassWord" class="text-danger"></span>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="newPassWord" class="col-md-3 col-sm-2 control-label">Mật khẩu mới</label>
                        <div class="col-md-5 col-sm-10">
                          <input type="password" class="form-control" name="newPassWord" id="newPassWord" placeholder="Nhập mật khẩu mới">
                        	 <span id="errorNewPassWord" class="text-danger"></span>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="reTypePassWord" class="col-md-3 col-sm-2 control-label">Nhập lại mật khẩu</label>
                        <div class="col-md-5 col-sm-10">
                          <input type="password" class="form-control" name="reTypePassWord" id="reTypePassWord" placeholder="Nhập nhập lại mật khẩu">
                        	 <span id="errorReTypePassWord" class="text-danger"></span>
                        </div>
                    </div>
                    <div class="form-group row">
                        <div class="col-sm-10 col-md-2">                          
                          <button id="savePassWord" type="submit" class="btn btn-primary">Lưu lại</button>
                        </div>
                      </div>
                      <input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
                      </form>
                  </div>
                  <!-- activity -->
                  <div class="tab-pane" id="activity">
                  <div class="col-md-12">
            <div class="card">
              <div class="card-header">
                <h3 class="card-title">Lịch sử chấm điểm</h3>

                <div class="card-tools">
                  <ul class="pagination pagination-sm m-0 float-right">
                    <li class="page-item"><a class="page-link" href="#">&laquo;</a></li>
                    <li class="page-item"><a class="page-link" href="#">1</a></li>
                    <li class="page-item"><a class="page-link" href="#">2</a></li>
                    <li class="page-item"><a class="page-link" href="#">3</a></li>
                    <li class="page-item"><a class="page-link" href="#">&raquo;</a></li>
                  </ul>
                </div>
              </div>
              <!-- /.card-header -->
              <div class="card-body p-0">
                <table class="table table-striped" id="example1">
                <thead align="center">
                  <tr>
                    <th>Tháng</th>
                    <th>Nhận xét</th>
                    <th>Thang điểm</th>
                    <th>Khen thưởng</th>
                  </tr>
                  </thead>
                  <c:forEach var="joinclub" items="${listJoinClubByIdMember}">
                  <tr>
                    <td align="center"><fmt:formatDate value="${joinclub.getDateJoin()}" pattern="MM/yyyy"/></td>
                    <td>Update software</td>
                    <td align="center"><span class="badge bg-danger">55%</span></td>	
                    <td align="center"><button class="btn btn-warning btn-sm"><i class="fa fa-gift"></i></button></td>
                  </tr>
                  </c:forEach>
                </table>
              </div>
              <!-- /.card-body -->
            </div>
            <!-- /.card -->
             </div>
            </div>
                  <!-- activity -->
                  
                  <div class="tab-pane direct-chat-messages" id="timeline">
                  <c:forEach var="date" items="${listDateSort}">
                    <!-- The timeline -->
                    <ul class="timeline timeline-inverse">
                      <!-- timeline time label -->
                      <li class="time-label">
                      <c:choose>
						<c:when test="${date.isStatus()==true}">
                        <span class="bg-primary">
                         <fmt:formatDate value="${date.getDateSort()}" pattern="dd/MM/yyyy"/>
                        </span>
                        </c:when>
                        <c:when test="${date.isStatus()==false}">
                        <span class="bg-danger" >
                         	<fmt:formatDate value="${date.getDateSort()}" pattern="dd/MM/yyyy"/>
                        </span>
						</c:when>
						</c:choose>
                      </li>
                      <!-- /.timeline-label -->
                      <!-- timeline item -->
                      <li>
                        
                        <c:choose>
                        <c:when test="${date.isStatus()==true}">
                        <i class="fa fa-clock-o bg-warning"></i>
                        <div class="timeline-item">
                          <h3 class="timeline-header"><a href="#">${date.getNameClub()}</a> tham gia Club</h3>
                          </div>
						</c:when>
						<c:when test="${date.isStatus()==false}">
						<i class="fa fa-clock-o bg-gray"></i>
                        <div class="timeline-item">
                          <h3 class="timeline-header"><a href="#">${date.getNameClub()}</a> rời khỏi Club</h3>
                          </div>
						</c:when>
					</c:choose>
                          
                          </li>	
                    </ul>
                    </c:forEach>
                  </div>
                  
                  <!-- /.tab-pane -->
                  
                </div>
                <!-- /.tab-content -->
              </div><!-- /.card-body -->
            </div>
            <!-- /.nav-tabs-custom -->
          </div>
          <!-- /.col -->
        </div>
        <!-- /.row -->
      </div><!-- /.container-fluid -->
    </section>
	    <!-- /.content -->
  	</div>
  	
    	<jsp:include page="_shareLayout/_footer.jsp"></jsp:include>
    </div>
	<jsp:include page="_shareLayout/footer.jsp"></jsp:include>
	<script>
  	$(document).ready(function(){
  	   
  	  $(function () {
  	    $("#example1").DataTable();
  	    $('#example2').DataTable({
  	      "paging": true,
  	      "lengthChange": false,
  	      "searching": false,
  	      "ordering": true,
  	      "info": true,
  	      "autoWidth": false
  	    });
  	});
  	  $("#oldPassWord").keyup(function(){
  		$.ajax({
			url:"/Club-IVS/member/checkPassWord",
			type:"POST",
			data:{
				password:$("#oldPassWord").val()
			},
			success:function(data){				
				if(data.status==200){
					console.log(data)
				}else{
					$("errorGetRole").append("Xảy ra lỗi khi lấy dữ liệu!");
				}
			}
		})
	    });
  	});
	</script>
	</body>
</html>