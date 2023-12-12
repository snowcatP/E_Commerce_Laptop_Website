<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="components/head.jsp"></c:import>
  
<c:import url="components/header.jsp"></c:import>  

<c:import url="components/sidebar.jsp"></c:import>

  <main id="main" class="main">

    <div class="pagetitle">
      <h1>Quản lý khách hàng</h1>
    </div><!-- End Page Title -->

    <section class="section">
      <div class="row">
      	<div class="col-lg-3"></div>
        <div class="col-lg-6">
          <div class="card">
            <div class="card-body">
            
              <h5 class="card-title">Sửa thông tin khách hàng</h5>

			<%-- <c:set var="employee" value="${requestScope.employee }"/> --%>
			
			

              <!-- General Form Elements -->
              <form action="modify_user" method="post">
              	<input type="hidden" name="action" value="modify">
              	<input type="hidden" class="form-control" name="adminId" value="${user.userId}" >
              
                <div class="row mb-3">
                  <label for="inputText" class="col-sm-3 col-form-label">Họ</label>
                  <div class="col-sm-9">
                    <input type="text" class="form-control" name="firstName" value="${user.firstName}" required>
                  </div>
                </div>
                
                <div class="row mb-3">
                  <label for="inputEmail" class="col-sm-3 col-form-label">Tên</label>
                  <div class="col-sm-9">
                    <input type="text" class="form-control" name="lastName" value="${user.lastName }" required>
                  </div>
                </div>
                
                <div class="row mb-3">
                  <label for="inputEmail" class="col-sm-3 col-form-label">Email</label>
                  <div class="col-sm-9">
                    <input type="email" class="form-control" name="email" value="${user.email }" required>
                  </div>
                </div>
                
                <div class="row mb-3">
                  <label for="inputEmail" class="col-sm-3 col-form-label">Địa chỉ</label>
                  <div class="col-sm-9">
                    <input type="text" class="form-control" name="address" value="${user.address }" required>
                  </div>
                </div>
                
                <div class="row mb-3">
                  <label for="inputNumber" class="col-sm-3 col-form-label">Số điện thoại</label>
                  <div class="col-sm-9">
                    <input type="text" class="form-control" name="phone" value="${user.phone }" required>
                  </div>
                </div>   
                           
                <div class="row mb-3">
                  <label class="col-sm-3 col-form-label"></label>
                  <div class="col-sm-9">
                    <button type="submit" class="btn btn-primary">Lưu</button>
                  </div>
                </div>

              </form><!-- End General Form Elements -->
            </div>
          </div>
          </div>
          <div class="col-lg-3"></div>
        </div>
    </section>

  </main><!-- End #main -->

<c:import url="components/footer.jsp"></c:import>