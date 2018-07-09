<%@ page language="java" contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8" session="false"%>
<%@ page import="com.vn.ivs.ctu.utils.SecurityUtils"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

 <!-- Navbar -->
  <nav class="main-header navbar navbar-expand bg-white navbar-light border-bottom">
    <!-- Left navbar links -->
    <ul class="navbar-nav">
      <li class="nav-item d-none d-sm-inline-block">
        <c:choose>
		    <c:when test="${status==403}">
				<h5 class="text-danger text-center"><i class="icon fa fa-check"></i> ${message}</h5>
		    </c:when>
	    </c:choose>
	    </li>
      <li class="nav-item">
        <a class="nav-link" data-widget="pushmenu" href="#"><i class="fa fa-bars"></i></a>
      </li>
    </ul>
    <ul class="navbar-nav ml-auto">
    <c:if test="${SecurityUtils.getMyUserDetail().getClubs().size()>1}">
    	<li class="nav-item">
        <a class="nav-link" href='<c:url value="/chooseClub"/>'>       
        	<i class="fa fa-refresh" aria-hidden="true"></i>
        	 Thay đổi
        </a>
     </li>   
    </c:if>      
     <li class="nav-item">
        <a class="nav-link" href='<c:url value="/logout"/>'>       
        	<i class="fa fa-sign-out" aria-hidden="true"></i>
        	 Thoát
        </a>
     </li>
    </ul>
  </nav>