<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	            <h1 class="m-0 text-dark">Profile</h1>
	          </div><!-- /.col -->
	          <div class="col-sm-6">
	            <ol class="breadcrumb float-sm-right">
	              <li class="breadcrumb-item"><a href="#">Profile</a></li>
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
                <h3 class="card-title">About Me</h3>
              </div>
              <!-- /.card-header -->
              <div class="card-body">
                <strong><i class="fa fa-birthday-cake mr-1" aria-hidden="true"></i>Sinh Nhật</strong>					
                <p class="text-muted">
                 <c:choose>
						<c:when test="${member.getBirthDayMember()!=null}">
							<c:out value="${member.getBirthDayMember()}"/>
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
                  
                  <li class="nav-item"><a class="nav-link" href="#settings" data-toggle="tab">Cập nhật thông tin</a></li>
                  <li class="nav-item"><a class="nav-link" href="#updateAvatar" data-toggle="tab">Cập nhật ảnh</a></li>
                  <li class="nav-item"><a class="nav-link" href="#chagePassWord" data-toggle="tab">Thay đổi mật khẩu</a></li>
                </ul>
              </div><!-- /.card-header -->
              <div class="card-body">
                <div class="tab-content">
                  
                  
                  <div class="active tab-pane" id="settings">
                    <form class="form-horizontal">
                      <div class="form-group row">
                        <label for="nameMember" class="col-md-3 col-sm-2 control-label">Họ và Tên</label>
                        <div class="col-md-9 col-sm-10">
                          <input type="text" class="form-control"  name = "nameMember" id="nameMember" placeholder="Nhập Họ và Tên">
                        </div>
                      </div>
                      <div class="form-group row">
                        <label for="isSexMember" class="col-md-3 col-sm-2 control-label">Giới tính</label>
                        <div class="col-sm-10 col-md-9">
                          <label class="mr-2">
		                    <input type="radio" name="isSexMember" class="minimal">Nam
		                  </label>
		                  <label>
		                    <input type="radio" name="isSexMember" class="minimal">Nữ
		                  </label>
                        </div>
                      </div>
                      <div class="form-group row">
                        <label for="birthDayMember" class="col-sm-2 col-md-3 control-label">Sinh Nhật</label>
                        <div class="col-sm-10 col-md-9">
                          <input type="text" class="form-control datepicker" name="birthDayMember" id="birthDayMember" placeholder="Ngày tháng năm sinh">
                        </div>
                      </div>
                      <div class="form-group row">
                        <label for="phoneNumerMember" class="col-sm-2 col-md-3 control-label">Số Điện Thoại</label>
                        <div class="col-sm-10 col-md-9">
                          <input type="text" class="form-control" name="phoneNumerMember" id="phoneNumerMember" placeholder="Số điện thoại">
                        </div>
                      </div>
                      <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                          <button type="submit" class="btn btn-success">Cập Nhật</button>
                           <button type="submit" class="btn btn-primary">Lưu lại</button>
                        </div>
                      </div>
                    </form>
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
                  </div>
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
	</body>
</html>