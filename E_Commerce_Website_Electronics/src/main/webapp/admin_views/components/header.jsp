<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>

<body>
  <!-- ======= Header ======= -->
  <header id="header" class="header fixed-top d-flex align-items-center">

    <div class="d-flex align-items-center justify-content-between">
      <a href="admin_home" class="logo d-flex align-items-center">
        <img src="assets/img/logo.png" alt="">
        <span class="d-none d-lg-block">Admin</span>
      </a>
      <i class="bi bi-list toggle-sidebar-btn"></i>
    </div><!-- End Logo -->

    <div class="search-bar">
      <form class="search-form d-flex align-items-center" method="POST" action="#">
        <input type="text" name="query" placeholder="Tìm kiếm" title="Enter search keyword">
        <button type="submit" title="Search"><i class="bi bi-search"></i></button>
      </form>
    </div><!-- End Search Bar -->
	
    <nav class="header-nav ms-auto">
      <ul class="d-flex align-items-center">

        <li class="nav-item d-block d-lg-none">
          <a class="nav-link nav-icon search-bar-toggle " href="#">
            <i class="bi bi-search"></i>
          </a>
        </li><!-- End Search Icon-->


        <li class="nav-item dropdown pe-3">
			
		
		<c:set var="admin_acc" value="${sessionScope.admin_acc }"/>
		
	          <a class="nav-link nav-profile d-flex align-items-center pe-0" href="#" data-bs-toggle="dropdown">
	            <i class="bi bi-person" style="font-size:20px"></i>
	            
	            <span class="d-none d-md-block dropdown-toggle ps-2"><c:out value="${admin_acc.admin.firstName }"/> <c:out value="${admin_acc.admin.lastName }"/></span>
	          </a><!-- End Profile Iamge Icon -->
	
	          <ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow profile">
	            <li class="dropdown-header">
	              <h6><c:out value="${admin_acc.admin.firstName }"/> <c:out value="${admin_acc.admin.lastName }"/></h6>
	              <span>Quản lý</span>
	            </li>
	            <li>
	              <hr class="dropdown-divider">
	            </li>
	
	            <li>
	              <a class="dropdown-item d-flex align-items-center" href="users_profile.jsp">
	                <i class="bi bi-box-arrow-right"></i>
	                <span>Tài khoản của tôi</span>
	              </a>
	            </li>
	            <li>
	              <hr class="dropdown-divider">
	            </li>
	
	            <li>
	              <a class="dropdown-item d-flex align-items-center" href="admin_logout?action=admin_logout">
	                <i class="bi bi-box-arrow-right"></i>
	                <span>Đăng xuất</span>
	              </a>
	            </li>
	          </ul><!-- End Profile Dropdown Items -->
			
			
        </li><!-- End Profile Nav -->

      </ul>
    </nav><!-- End Icons Navigation -->

  </header><!-- End Header -->