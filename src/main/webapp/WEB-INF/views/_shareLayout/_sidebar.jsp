<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8" session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.vn.ivs.ctu.utils.SecurityUtils"%>
<%@ page isELIgnored="false" %>  
<aside class="main-sidebar sidebar-dark-primary elevation-4">
	<!-- Brand Logo -->
	<a href="index3.html" class="brand-link"> <span
		class="brand-text font-weight-light">Club - IVS</span>
	</a>
	<!-- Sidebar -->
	<div class="sidebar">
		<!-- Sidebar user panel (optional) -->
		<div class="user-panel mt-3 pb-3 mb-3 d-flex">
			<div class="image">
				<img src="<c:url value="../resources/dist/img/user2-160x160.jpg"/>"
					class="img-circle elevation-2" alt="User Image">
			</div>
			<div class="info">
				<a href="#" class="d-block">
					<%-- <c:choose>
						<c:when test="${SecurityUtils.getMyUserDetail()!=null}">
							<%=SecurityUtils.getMyUserDetail().getNameMember()%>
						</c:when>
					</c:choose> --%>
				</a>
			</div>
		</div>
		<!-- Sidebar Menu -->
		<nav class="mt-2">
			<ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
				<li	class="nav-item has-treeview ${action1 eq  'dasboard' ? 'menu-open' : ''}">
					<a href="#"	class="nav-link ${action1 eq  'dasboard' ? 'active' : ''}"> <i
						class="nav-icon fa fa-dashboard"></i>
						<p>
							Dashboard <i class="right fa fa-angle-left"></i>
						</p>
					</a>
				</li>
				<!--  admin  menu role -->
				<li	class="nav-item ${action1 eq  'role' ? 'menu-open' : ''}">
					<a href="<c:url value="/role/index"/>" class="nav-link ${action1 eq  'role' ? 'active' : ''}">
						<!-- <i class="nav-icon fa fa-edit"></i> -->
						<p>
							Chức Vụ  <img/>
						</p>
					</a>					
				</li><!--  ./admin menu role -->			
				<!-- admin menu branch -->				
				<li class="nav-item has-treeview ${action1 eq  'branch' ? 'menu-open' : ''}">
		            <a href="#" class="nav-link ${action1 eq  'branch' ? 'active' : ''}">
		            <i class="fa fa-code-fork" aria-hidden="true"></i>
		              <p>
		                Chi Nhánh
		                <i class="fa fa-angle-left right"></i>
		              </p>
		            </a>
		            <ul class="nav nav-treeview">
		              <li class="nav-item">
		                <a href='<c:url value="/branch/index"/>' class="nav-link ${action2 eq  'indexbranch' ? 'active' : ''}">
		                  <i class="fa fa-circle-o nav-icon"></i>
		                  <p>Index</p>
		                </a>
		              </li>
		              <li class="nav-item">
		                <a href="pages/forms/advanced.html" class="nav-link">
		                  <i class="fa fa-circle-o nav-icon"></i>
		                  <p>Advanced Elements</p>
		                </a>
		              </li><!--./admin menu branch  -->
					</ul>
				</li>
				<!-- menu member -->
				<li class="nav-item has-treeview ${action1 eq  'member' ? 'menu-open' : ''}">
		            <a href="#" class="nav-link ${action1 eq  'member' ? 'active' : ''}">
		             <i class="fa fa-users" aria-hidden="true"></i>
		              <p>
		                Thành Viên
		                <i class="fa fa-angle-left right"></i>
		              </p>
		            </a>
		            <ul class="nav nav-treeview">
		              <li class="nav-item">
		                <a href='<c:url value="/member/create"/>' class="nav-link ${action2 eq  'indexmember' ? 'active' : ''}">
		                  <i class="fa fa-circle-o nav-icon"></i>
		                  <p>Thêm thành viên</p>
		                </a>
		              </li>
		              <li class="nav-item">
		                <a href='<c:url value="/member/joinclub"/>' class="nav-link ${action2 eq  'joinclub' ? 'active' : ''}">
		                  <i class="fa fa-circle-o nav-icon"></i>
		                  <p>Thêm vào CLB</p>
		                </a>
		              </li>
		              <li class="nav-item">
		                <a href="pages/forms/editors.html" class="nav-link">
		                  <i class="fa fa-circle-o nav-icon"></i>
		                  <p>Editors</p>
		                </a>
		              </li>
		            </ul>            
		          </li><!-- .// menu member -->
				<!-- menu role -->
				<li class="nav-item has-treeview">
					<a href="#" class="nav-link">
						<!-- <i class="nav-icon fa fa-edit"></i> -->
						<p>
							Date Of Week <i class="fa fa-angle-left right"></i>
						</p>
					</a>
					<ul class="nav nav-treeview">
						<li class="nav-item">
							<a href='<c:url value="/dow/"/>' class="nav-link ${action2 eq  'index' ? 'active' : ''}"> 
							<i class="fa fa-circle-o nav-icon"></i>
								<p>Index</p>
							</a>
						</li>
					</ul>
				</li><!-- ./menu role -->
				<!-- menu schedule -->
				<li class="nav-item has-treeview">
					<a href="#" class="nav-link">
						<!-- <i class="nav-icon fa fa-edit"></i> -->
						<p>Schedule <i class="fa fa-angle-left right"></i></p>
					</a>
					<ul class="nav nav-treeview">
						<li class="nav-item">
							<a href='<c:url value="/schedule/"/>'
							class="nav-link ${action2 eq  'index' ? 'active' : ''}"> <i
								class="fa fa-circle-o nav-icon"></i>
								<p>Index</p>
							</a>
						</li>
						
					</ul>
				</li><!--  -->
				<!-- menu club -->
				<li class="nav-item has-treeview">
					<a href="#" class="nav-link">
						<!-- <i class="nav-icon fa fa-edit"></i> -->
						<p>Club <i class="fa fa-angle-left right"></i></p>
					</a>
					<ul class="nav nav-treeview">
						<li class="nav-item">
							<a href='<c:url value="/club/index"/>'
							class="nav-link ${action2 eq  'index' ? 'active' : ''}"> <i
								class="fa fa-circle-o nav-icon"></i>
								<p>Index</p>
							</a>
						</li>
						<li class="nav-item">
							<a href='<c:url value="/club/joinClub"/>'
							class="nav-link ${action2 eq  'joinClub' ? 'active' : ''}"> <i
								class="fa fa-circle-o nav-icon"></i>
								<p>Thành Viên Câu Lạc Bộ</p>
							</a>
						</li>
					</ul>
				</li><!-- ./menu club -->
				<!-- menu score -->
				<li class="nav-item has-treeview">
					<a href="<c:url value="/to-grade/index"/>" class="nav-link">
						<!-- <i class="nav-icon fa fa-edit"></i> -->
						<p>Bản Điểm<i class="fa fa-angle-left right"></i></p>
					</a>					
				</li><!-- ./menu score -->
				<!-- menu profile -->
				<li class="nav-item has-treeview">
					<a href="#" class="nav-link">
						<!-- <i class="nav-icon fa fa-edit"></i> -->
						<p>Profile <i class="fa fa-angle-left right"></i></p>
					</a>
					<ul class="nav nav-treeview">
						<li class="nav-item">
							<a href='<c:url value="/member/profile"/>'
							class="nav-link ${action2 eq  'index' ? 'active' : ''}"> <i
								class="fa fa-circle-o nav-icon"></i>
								<p>Index</p>
							</a>
						</li>
					</ul>
				</li><!-- ./menu club -->
				<!--  menu dow -->
	            <li class="nav-item has-treeview">
	            <a href="#" class="nav-link">
	              <!-- <i class="nav-icon fa fa-edit"></i> -->
	              <p>
	                Date Of Week
	                <i class="fa fa-angle-left right"></i>
	              </p>
	            </a>
	            <ul class="nav nav-treeview">
	              <li class="nav-item">
	                <a href='<c:url value="/dow/index"/>' class="nav-link ${action2 eq  'dow' ? 'active' : ''}">
	                  <i class="fa fa-circle-o nav-icon"></i>
	                  <p>Index</p>
	                </a>
	              </li>
	              
	            </ul>            
	          </li>
	          
	          
	          <!-- .//menu schedule -->
	          <li class="nav-item has-treeview">
	            <a href="#" class="nav-link">
	              <!-- <i class="nav-icon fa fa-edit"></i> -->
	              <p>
	                Schedule
	                <i class="fa fa-angle-left right"></i>
	              </p>
	            </a>
	            <ul class="nav nav-treeview">
	              <li class="nav-item">
	                <a href='<c:url value="/schedule/index"/>' class="nav-link ${action2 eq  'schedule' ? 'active' : ''}">
	                  <i class="fa fa-circle-o nav-icon"></i>
	                  <p>Index</p>
	                </a>
	              </li>
	              
	            </ul>
	            
	          </li>
	          
	          <!-- .//menu schedule -->
	          <li class="nav-item has-treeview">
	            <a href="#" class="nav-link">
	              <!-- <i class="nav-icon fa fa-edit"></i> -->
	              <p>
	                Train
	                <i class="fa fa-angle-left right"></i>
	              </p>
	            </a>
	            <ul class="nav nav-treeview">
	              <li class="nav-item">
	                <a href='<c:url value="/train/index"/>' class="nav-link ${action2 eq  'train' ? 'active' : ''}">
	                  <i class="fa fa-circle-o nav-icon"></i>
	                  <p>Lịch thủ công</p>
	                </a>
	              </li>
	              <li class="nav-item">
	                <a href='<c:url value="/train/trainauto"/>' class="nav-link ${action2 eq  'trainauto' ? 'active' : ''}">
	                  <i class="fa fa-circle-o nav-icon"></i>
	                  <p>Lịch tự động</p>
	                </a>
	              </li>	              
	            </ul>
	          </li>
	          <!--  menu dow -->
	          <li class="nav-item has-treeview">
	            <a href="#" class="nav-link">
	              <!-- <i class="nav-icon fa fa-edit"></i> -->
	              <p>
	                Điểm Danh
	                <i class="fa fa-angle-left right"></i>
	              </p>
	            </a>
	            <ul class="nav nav-treeview">
	              <li class="nav-item">
	                <a href='<c:url value="/attendance/index"/>' class="nav-link ${action2 eq  'attendance' ? 'active' : ''}">
	                  <i class="fa fa-circle-o nav-icon"></i>
	                  <p>Index</p>
	                </a>
	            </li>
			</ul>			
		</nav>
		<!-- /.sidebar-menu -->
	</div>
	<!-- /.sidebar -->
</aside>
