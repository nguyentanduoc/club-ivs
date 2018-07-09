<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false"%>
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
	            <h1 class="m-0 text-dark">Điểm danh</h1>
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
	   <!-- Small Box (Stat card) -->
        
            <div class="card card-default">
              <div class="card-header">
                <h3 class="card-title">
                  
                  Tất cả sự kiện
                </h3>
              </div>
              <div class="card-body">
        <div class="row p-2">
         <c:forEach var="train" items="${listAllTrainOnWeek}">
          <div class="col-lg-3 col-6">
            <!-- small card -->
            <div class="small-box bg-info">
              <div class="inner">
                <h3>${train.getSchedule().getClub().getNameClub()}</h3>
                <p>${train.getSchedule().getNameSchedule()}<br/><fmt:formatDate var="fmtDate" value="${train.getDateTrain()}" pattern="dd/MM/yyyy"/>
                <strong>${fmtDate}</strong></p>
                
              </div>
              <div class="icon">
                <i class="fa fa-bug"></i>
              </div>
              <a class="small-box-footer" href='<c:url value="/attendance/diemdanh/${train.getIdTrain()}"/>' class="nav-link ${action1 eq  'diemdanh' ? 'active' : ''}">
		            Điểm danh <i class="fa fa-arrow-circle-right"></i>
		            </a>
            </div>
          </div>
          </c:forEach>
          </div></div>
         
        </div>
        <!-- /.row -->
	    
  	</div>    	
    	<jsp:include page="_shareLayout/_footer.jsp"></jsp:include>
    </div>
	<jsp:include page="_shareLayout/footer.jsp"></jsp:include>
	</body>
</html>
