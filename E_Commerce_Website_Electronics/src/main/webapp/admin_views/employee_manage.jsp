<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="components/head.jsp"></c:import>
  
<c:import url="components/header.jsp"></c:import>  

<c:import url="components/sidebar.jsp"></c:import>

  <main id="main" class="main">

    <div class="pagetitle">
      <h1>Quản lý nhân viên</h1>
    </div><!-- End Page Title -->

    <section class="section">
      <div class="row">
      	<div class="col-lg-3"></div>
        <div class="col-lg-6">
          <div class="card">
            <div class="card-body">
            
              <h5 class="card-title">Thêm nhân viên</h5>

			<%@ page import="model.*" %>
			<%
				Admin admin = (Admin)request.getAttribute("admin");
				
			%>
			
			<% if(admin != null){ %>
				<h3>Nhân viên <span style="color:red"><%= admin.getFirstName()%> <%= admin.getLastName()%></span> đã được thêm!</h3>
			<%} %>

              <!-- General Form Elements -->
              <form action="add_employee" method="post">
              	<input type="hidden" name="action" value="add_em">
              
                <div class="row mb-3">
                  <label for="inputText" class="col-sm-3 col-form-label">Họ</label>
                  <div class="col-sm-9">
                    <input type="text" class="form-control" name="firstName" required>
                  </div>
                </div>
                
                <div class="row mb-3">
                  <label for="inputEmail" class="col-sm-3 col-form-label">Tên</label>
                  <div class="col-sm-9">
                    <input type="text" class="form-control" name="lastName" required>
                  </div>
                </div>
                
                <div class="row mb-3">
                  <label for="inputEmail" class="col-sm-3 col-form-label">Email</label>
                  <div class="col-sm-9">
                    <input type="email" class="form-control" name="email" required>
                  </div>
                </div>
                
                <div class="row mb-3">
                  <label for="inputEmail" class="col-sm-3 col-form-label">Địa chỉ</label>
                  <div class="col-sm-9">
                    <input type="text" class="form-control" name="address" required>
                  </div>
                </div>
                
                <div class="row mb-3">
                  <label for="inputNumber" class="col-sm-3 col-form-label">Số điện thoại</label>
                  <div class="col-sm-9">
                    <input type="text" class="form-control" name="phone" required>
                  </div>
                </div>
                
                <div class="row mb-3">
                  <label for="inputNumber" class="col-sm-3 col-form-label">Lương</label>
                  <div class="col-sm-9">
                    <input type="number" class="form-control" name="salary" required>
                  </div>
                </div>     
                           
                <div class="row mb-3">
                  <label class="col-sm-3 col-form-label">Thêm nhân viên</label>
                  <div class="col-sm-9">
                    <button type="submit" class="btn btn-primary">Thêm</button>
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