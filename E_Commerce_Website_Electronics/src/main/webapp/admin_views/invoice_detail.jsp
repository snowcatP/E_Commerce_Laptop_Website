<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="components/head.jsp"></c:import>
  
<c:import url="components/header.jsp"></c:import>  

<c:import url="components/sidebar.jsp"></c:import>

  <main id="main" class="main">

    <div class="pagetitle">
      <h1>Quản lý đơn hàng</h1>
    </div><!-- End Page Title -->

    <section class="section">
      <div class="row">
      	<div class="col-lg-3"></div>
        <div class="col-lg-6">
          <div class="card">
            <div class="card-body">
            	<div class="col-lg-2"></div>
            	<div class="col-lg-10">
            	
            	<c:set var="invoice" value="${requestScope.invoice }"/>
            	
	              	<h3 class="card-title">Chi tiết đơn hàng</h3>	
	              
	                <div class="row mb-3">
	                  <label for="inputText" class="col-sm-4 col-form-label">Tên khách hàng:</label>
	                   <p class="col-sm-8 col-form-label"><c:out value="${invoice.user.firstName }"/> <c:out value="${invoice.user.lastName }"/></p>
	                </div>
	                <div class="row mb-3">
	                  <label for="inputText" class="col-sm-4 col-form-label">Tài khoản:</label>
	                   <p class="col-sm-8 col-form-label"><c:out value="${invoice.user.email }"/></p>
	                </div>
	                <div class="row mb-3">
	                  <label for="inputText" class="col-sm-4 col-form-label">Địa chỉ:</label>
	                   <p class="col-sm-8 col-form-label"><c:out value="${invoice.user.address }"/></p>
	                </div>
	                 <div class="row mb-3">
	                  <label for="inputText" class="col-sm-4 col-form-label">Sản phẩm:</label><p class="col-sm-8 col-form-label">-------------------------------------------------</p>
	                   <c:set var="lineProducts" value="${invoice.lineProducts }"/>
	                   
	                   <c:forEach var="lineProduct" items="${lineProducts }">
	                   		<div class="col-sm-4"></div>
	                   		<p class="col-sm-8 col-form-label"><c:out value="${lineProduct.quantity }"/>x <c:out value="${lineProduct.product.nameProd }"/></p>
	                   </c:forEach>
	                </div>
	                <div class="row mb-3">
	                  <label for="inputText" class="col-sm-4 col-form-label">Ngày xuất:</label>
	                   <p class="col-sm-8 col-form-label"><fmt:formatDate type = "date" value = "${invoice.invoiceDate}" /></p>
	                </div> 
	                <div class="row mb-3">
	                  <label for="inputText" class="col-sm-4 col-form-label">Tổng hoá đơn:</label>
	                   <p class="col-sm-8 col-form-label"><c:out value="${invoice.totalPrice }"/> VND</p>
	                </div>   
	                <div class="row mb-3">
	                  <label class="col-sm-3 col-form-label"></label>
	                  <div class="col-sm-9">
	                    <a href="get_invoices_data" class="btn btn-primary">Quay lại</a>
	                  </div>
	                </div>
	        	</div>
            </div>
            
          </div>
          </div>
          <div class="col-lg-3"></div>
        </div>
    </section>

  </main><!-- End #main -->

<c:import url="components/footer.jsp"></c:import>