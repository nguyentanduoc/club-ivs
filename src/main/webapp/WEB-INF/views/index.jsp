<%@ page language="java" contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8" session="TRUE"%>
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
	            <h1 class="m-0 text-dark">Thống kê</h1>
	          </div><!-- /.col -->
	          <div class="col-sm-6">
	            
	          </div><!-- /.col -->
	        </div><!-- /.row -->
	      </div><!-- /.container-fluid -->
	    </div><!-- /.content-header -->
	    <!-- Main content -->
	     <section class="content">
     	 	<div class="container-fluid">
     	 		<div class="row">
     	 		<c:forEach items="${club}" var="c">
	     	 		<div class="col-lg-3 col-6">
			            <!-- small box -->
			            <div class="small-box bg-warning">
			              <div class="inner">
			                <h4><i class="fa fa-arrow-up" aria-hidden="true"></i>${c.getPlus()}</h4>		
			                <h4><i class="fa fa-arrow-down" aria-hidden="true"></i>${c.getDeduct()}</h4>		
			                <p>${c.getNameClub()}</p>
			              </div>
			              <div class="icon">
			              <i class="fa fa-user-plus" aria-hidden="true"></i>
			              </div>
			              <!-- <a href="#" class="small-box-footer">More info <i class="fa fa-arrow-circle-right"></i></a> -->
			            </div>
		          </div>
     	 		</c:forEach>		          
	         	</div>
     	 	</div>
     	 </section>
	    <!-- /.content -->
  	</div>    	
    	<jsp:include page="_shareLayout/_footer.jsp"></jsp:include>
    </div>
    <jsp:include page="_shareLayout/footer.jsp"></jsp:include>
</body>
</html>