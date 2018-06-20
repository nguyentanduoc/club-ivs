<%@ page language="java" contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8" session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<aside class="main-sidebar sidebar-dark-primary elevation-4">
    <!-- Brand Logo -->
    <a href="index3.html" class="brand-link">     
      <span class="brand-text font-weight-light">Club - IVS</span>
    </a>

    <!-- Sidebar -->
    <div class="sidebar">
      <!-- Sidebar user panel (optional) -->
      <div class="user-panel mt-3 pb-3 mb-3 d-flex">
        <div class="image">
          <img src="<c:url value="../resources/dist/img/user2-160x160.jpg"/>" class="img-circle elevation-2" alt="User Image">
        </div>
        <div class="info">
          <a href="#" class="d-block">Nguyễn Tấn Được</a>
        </div>
      </div>

      <!-- Sidebar Menu -->
      <nav class="mt-2">
        <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
          <!-- Add icons to the links using the .nav-icon class
               with font-awesome or any other icon font library -->
          <li class="nav-item has-treeview ${action1 eq  'dasboard' ? 'menu-open' : ''}">
            <a href="#" class="nav-link ${action1 eq  'dasboard' ? 'active' : ''}">
              <i class="nav-icon fa fa-dashboard"></i>
              <p>
                Dashboard
               <i class="right fa fa-angle-left"></i>
              </p>
            </a>            
          </li>
          
          
          
          <!--  menu role -->
           <li class="nav-item has-treeview ${action1 eq  'role' ? 'menu-open' : ''}">
            <a href="#" class="nav-link ${action1 eq  'role' ? 'active' : ''}">
              <!-- <i class="nav-icon fa fa-edit"></i> -->
              <p>
                Chức Vụ
                <i class="fa fa-angle-left right"></i>
              </p>
            </a>
            <ul class="nav nav-treeview">
	              <li class="nav-item">
	                <a href='<c:url value="/role/"/>' class="nav-link ${action2 eq  'index' ? 'active' : ''}">
	                  <i class="fa fa-circle-o nav-icon"></i>
	                  <p>Index</p>
	                </a>
            	</li>
            </ul>
          </li>
              
              
              <!--  menu role -->
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
                <a href='<c:url value="/dow/"/>' class="nav-link ${action2 eq  'index' ? 'active' : ''}">
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
                <a href='<c:url value="/schedule/"/>' class="nav-link ${action2 eq  'index' ? 'active' : ''}">
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
                <a href='<c:url value="/train/"/>' class="nav-link ${action2 eq  'index' ? 'active' : ''}">
                  <i class="fa fa-circle-o nav-icon"></i>
                  <p>Index</p>
                </a>
              </li>
              
            </ul>
            
          </li>
          
        </ul>
      </nav>
      <!-- /.sidebar-menu -->
    </div>
    <!-- /.sidebar -->
  </aside>