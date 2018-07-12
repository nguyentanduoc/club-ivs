<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8" session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.vn.ivs.ctu.utils.SecurityUtils"%>
<%@ page isELIgnored="false" %>  
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<aside class="main-sidebar sidebar-dark-primary elevation-4">
	<!-- Brand Logo -->
	<a href="<c:url value="/"/>" class="brand-link">
	<span class="brand-text font-weight-light">Club - IVS
	</span>
	</a>
	
	<!-- Sidebar -->
	<div class="sidebar">
		<!-- Sidebar user panel (optional) -->
		<div class="user-panel mt-3 pb-3 mb-3 d-flex">
			<div class="image">
				<img src="${pageContext.request.contextPath}/<c:url value="resources/dist/img/user2-160x160.jpg"/>"
					class="img-circle elevation-2" alt="User Image">
			</div>
			<div class="info">
				<a href="#" class="d-block">
					<c:choose>
						<c:when test="${SecurityUtils.getMyUserDetail()!=null}">
							<%=SecurityUtils.getMyUserDetail().getNameMember()%>
						</c:when>
					</c:choose>
				</a>
			</div>
		</div>
		<!-- Sidebar Menu -->
		<nav class="mt-2">
			<ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu">			
				<!--  admin  menu role -->
				<li	class="nav-item ${action1 eq  'dashboard' ? 'menu-open' : ''}">
					<a href="#" class="nav-link ${action1 eq  'dashboard' ? 'active' : ''}">
						<!-- <i class="nav-icon fa fa-edit"></i> -->
						<p>
							Dashboard
						</p>
					</a>
				</li>				
				<sec:authorize access="hasAuthority('ADMIN')">
				<!--  admin  menu role -->
				<li	class="nav-item ${action1 eq  'role' ? 'menu-open' : ''}">
					<a href="<c:url value="/role/index"/>" class="nav-link ${action1 eq  'role' ? 'active' : ''}">
						<img alt="icon_role" width="21px" src="${pageContext.request.contextPath}/<c:url value="resources/dist/img/icon_role.png"/>">						
						<p>
							Chức Vụ
						</p>
					</a>					
				</li><!--  ./admin menu role -->					
				<!-- admin menu branch -->				
				<li class="nav-item has-treeview ${action1 eq  'branch' ? 'menu-open' : ''}">
		            <a href='<c:url value="/branch/index"/>' class="nav-link ${action1 eq  'branch' ? 'active' : ''}">
		            <i class="fa fa-code-fork" aria-hidden="true"></i>
		              <p>
		                Chi Nhánh
		              </p>
		            </a>		            
				</li><!-- ./admin menu branch -->
				</sec:authorize>
				<!-- menu member -->
				<sec:authorize access="hasAnyAuthority('LEADER','ADMIN')">
				<li class="nav-item has-treeview ${action1 eq  'member' ? 'menu-open' : ''}">		            
		            <a href="#" class="nav-link ${action1 eq  'member' ? 'active' : ''}">
		             <i class="fa fa-users" aria-hidden="true"></i>
		              <p>
		                Thành Viên
		                <i class="fa fa-angle-left right"></i>
		              </p>
		            </a>
		            <ul class="nav nav-treeview">
		            <sec:authorize access="hasAuthority('ADMIN')">
		              <li class="nav-item">
		                <a href='<c:url value="/member/admin"/>' class="nav-link ${action2 eq  'adminMember' ? 'active' : ''}">
		                  <i class="fa fa-circle-o nav-icon"></i>
		                  <p>Thêm thành viên Admin</p>
		                </a>
		              </li>		              
		              </sec:authorize>
		              <sec:authorize access="hasAuthority('LEADER')">
		              <li class="nav-item">
		                <a href='<c:url value="/member/create"/>' class="nav-link ${action2 eq  'indexMember' ? 'active' : ''}">
		                  <i class="fa fa-circle-o nav-icon"></i>
		                  <p>Thêm thành viên</p>
		                </a>
		              </li>
		              </sec:authorize>
		            </ul>
		                      
		          </li><!-- .// menu member -->
				</sec:authorize>
				  <sec:authorize access="hasAuthority('LEADER')">
				<li class="nav-item has-treeview ${action1 eq  'club' ? 'menu-open' : ''}">
					<a href="#" class="nav-link ${action1 eq  'club' ? 'active' : ''}">
					<i class="fa fa-star" aria-hidden="true"></i>
						<!-- <i class="nav-icon fa fa-edit"></i> -->
						<p>CLB<i class="fa fa-angle-left right"></i></p>
					</a>
					<ul class="nav nav-treeview">
						<li class="nav-item">
							<a href='<c:url value="/club/index"/>'
							class="nav-link ${action2 eq  'create' ? 'active' : ''}"> <i
								class="fa fa-circle-o nav-icon"></i>
								<p>Danh sách CLB</p>
							</a>
						</li>
						<li class="nav-item">
							<a href='<c:url value="/club/joinClub"/>'
							class="nav-link ${action2 eq  'joinClub' ? 'active' : ''}"> <i
								class="fa fa-circle-o nav-icon"></i>
								<p>Thêm thành viên</p>
							</a>
						</li>
						<li class="nav-item">
							<a href='<c:url value="/club/listJoinClub"/>'
							class="nav-link ${action2 eq  'listJoinClub' ? 'active' : ''}"> <i
								class="fa fa-circle-o nav-icon"></i>
								<p>DS hoạt động</p>
							</a>
						</li>
					</ul>
				</li><!-- ./menu club -->
				</sec:authorize>
				<!-- menu score -->
				<sec:authorize access="hasAnyAuthority('LEADER','LEADER_CLUB')">
				<li class="nav-item has-treeview">
					<a href="#" class="nav-link">
					<i class="fa fa-list-ol" aria-hidden="true"></i>
						<!-- <i class="nav-icon fa fa-edit"></i> -->
						<p>Bản Điểm</p>
					</a>						
					<ul class="nav nav-treeview">
					<sec:authorize access="hasAnyAuthority('LEADER_CLUB')">
						<li class="nav-item">
							<a href='<c:url value="/to-grade/index"/>'
							class="nav-link ${action2 eq  'create' ? 'active' : ''}"> <i
								class="fa fa-circle-o nav-icon"></i>
								<p>Điểm CLB</p>
							</a>
						</li>
						</sec:authorize>
						<sec:authorize access="hasAnyAuthority('LEADER')">
						<li class="nav-item">
							<a href='<c:url value="/to-grade/scoreTotalBrach"/>'
							class="nav-link ${action2 eq  'joinClub' ? 'active' : ''}"> <i
								class="fa fa-circle-o nav-icon"></i>
								<p>Điểm Chi Nhánh</p>
							</a>
						</li>	
						</sec:authorize>					
					</ul>				
				</li><!-- ./menu score -->
				</sec:authorize>
				<!-- menu profile -->
				<sec:authorize access="hasAuthority('MEMBER')">
				<li class="nav-item has-treeview">
					<a href="<c:url value="/member/profile"/>" class="nav-link">
					<i class="fa fa-user" aria-hidden="true"></i>
						<!-- <i class="nav-icon fa fa-edit"></i> -->
						<p>Trang cá nhân</p>
					</a>					
				</li><!-- ./menu profile -->
				</sec:authorize>
				<!-- menu profile -->
				<sec:authorize access="hasAuthority('LEADER')">
				<li class="nav-item has-treeview">
					<a href="<c:url value="/train/getAllTrain"/>" class="nav-link ${action1 eq  'getAllTrain' ? 'active' : ''}">
					<i class="fa fa-user" aria-hidden="true"></i>
						<!-- <i class="nav-icon fa fa-edit"></i> -->
						<p>Tất cả lịch tuần</p>
					</a>					
				</li><!-- ./menu profile -->
				</sec:authorize>
				<sec:authorize access="hasAuthority('ADMIN')">
				<!-- menu date of week -->
				<li class="nav-item has-treeview">
					<a href="<c:url value="/dow/index"/>" class="nav-link">
					<i class="fa fa-calendar" aria-hidden="true"></i>
						<!-- <i class="nav-icon fa fa-edit"></i> -->
						<p>Ngày trong tuần</p>
					</a>					
				</li><!-- ./menu date of week -->
	          </sec:authorize>
	          <sec:authorize access="hasAuthority('LEADER_CLUB')">
	          <!-- menu schedule -->
	          <li class="nav-item has-treeview">
	            <a href="#" class="nav-link">
	            <i class="fa fa-calendar-o" aria-hidden="true"></i>
	              <!-- <i class="nav-icon fa fa-edit"></i> -->
	              <p>
	                Lên lịch
	                <i class="fa fa-angle-left right"></i>
	              </p>
	            </a>
	            <ul class="nav nav-treeview">
	              <li class="nav-item">
	                <a href='<c:url value="/schedule/index"/>' class="nav-link ${action2 eq  'schedule' ? 'active' : ''}">
	                  <i class="fa fa-circle-o nav-icon"></i>
	                  <p>Thêm lịch tự động</p>
	                </a>
	              </li>
	              <li class="nav-item">
	                <a href='<c:url value="/train/index"/>' class="nav-link ${action2 eq  'train' ? 'active' : ''}">
	                  <i class="fa fa-circle-o nav-icon"></i>
	                  <p>Thêm lịch thủ công</p>
	                </a>
	              </li>
	              <li class="nav-item">
	                <a href='<c:url value="/schedule/scheduletotal"/>' class="nav-link ${action2 eq  'schedule' ? 'active' : ''}">
	                  <i class="fa fa-circle-o nav-icon"></i>
	                  <p>Tất cả các lịch</p>
	                </a>
	              </li>
	              
	            </ul>
	            
	          <!-- menu train -->
				<li class="nav-item has-treeview">
					<a href="<c:url value="/train/trainauto"/>" class="nav-link">
					<i class="fa fa-calendar-check-o" aria-hidden="true"></i>
						<!-- <i class="nav-icon fa fa-edit"></i> -->
						<p>Lịch tự động</p>
					</a>					
				</li><!-- ./menu train -->
	          <!-- menu attendance -->
				<li class="nav-item has-treeview">
					<a href="<c:url value="/attendance/index"/>" class="nav-link">
					<i class="fa fa-check-square-o" aria-hidden="true"></i>
						<!-- <i class="nav-icon fa fa-edit"></i> -->
						<p>Điểm danh</p>
					</a>					
				</li><!-- ./menu attendance -->
				</sec:authorize>
			</ul>			
	          <!-- .//menu schedule -->
		</nav>
		<!-- /.sidebar-menu -->
	</div>
	<!-- /.sidebar -->
</aside>
