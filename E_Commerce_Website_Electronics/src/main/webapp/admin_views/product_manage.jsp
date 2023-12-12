<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="components/head.jsp"></c:import>
  
<c:import url="components/header.jsp"></c:import>  

<c:import url="components/sidebar.jsp"></c:import>

  <main id="main" class="main">

    <div class="pagetitle">
      <h1>Quản lý sản phẩm</h1>
    </div><!-- End Page Title -->

    <section class="section">
      <div class="row">
        <form action="productManage" method="post" enctype="multipart/form-data">
			<div class="row">	
	          <!-- General Form Elements -->
	          <div class="col-lg-6">
	            <div class="card">
	              <div class="card-body">
	                  <h5 class="card-title">Nhập sản phẩm</h5>
	                  <c:if test="${message != null}">
	                        	<h5><span style="color:green"><c:out value="${message}"/></span></h5>
	                  </c:if>
	                  <input type="hidden" name="action" value="add">
	                  <div class="row mb-3">
	                    <label class="col-sm-2 col-form-label">Tên sản phẩm</label>
	                    <div class="col-sm-10">
	                      <input type="text" class="form-control" name="productName">
	                    </div>
	                  </div>
	                  <div class="row mb-3">
	                    <label class="col-sm-2 col-form-label">Giá</label>
	                    <div class="col-sm-10">
	                      <input type="number" class="form-control" name="productPrice">
	                    </div>
	                  </div>
	                 <!-- <div class="row mb-3">
	                    <label class="col-sm-2 col-form-label">Loại sản phẩm</label>
	                    <div class="col-sm-10">
	                      <input type="text" class="form-control" value="Laptop" name="category">
	                    </div>
	                  </div> -->
	                  
	                  <div class="row mb-3">
	                    <label class="col-sm-2 col-form-label">Thông tin sản phẩm</label>
	                    <div class="col-sm-10">
	                      <textarea class="form-control" name="productDescription"  style="height: 100px"></textarea>
	                    </div>
	                  </div>
	                  <div class="row mb-3">
	                    <label class="col-sm-2 col-form-label">Số lượng</label>
	                    <div class="col-sm-10">
	                      <input type="number" class="form-control" name="quantity">
	                    </div>
	                  </div>
	                  <div class="row mb-3">
	                    <label class="col-sm-2 col-form-label">Loại</label>
	                    <div class="col-sm-10">
	                      <select class="form-select" aria-label="Default select example" name="category">
	                        <option value="Gaming" selected>Gaming</option>
	                        <option value="Office">Office</option>
	                      </select>
	                    </div>
	                  </div>
	                  <div class="row mb-3">
	                    <label class="col-sm-2 col-form-label">Ảnh 1</label>
	                    <div class="col-sm-10">
	                      <input class="form-control" type="file" name="pic1">
	                    </div>
	                  </div>
	                  <div class="row mb-3">
	                    <label class="col-sm-2 col-form-label">Ảnh 2</label>
	                    <div class="col-sm-10">
	                      <input class="form-control" type="file" name="pic2">
	                    </div>
	                  </div>
	                  <div class="row mb-3">
	                    <label class="col-sm-2 col-form-label">Ảnh 3</label>
	                    <div class="col-sm-10">
	                      <input class="form-control" type="file" name="pic3">
	                    </div>
	                  </div>
	                  <div class="row mb-3">
	                    <label class="col-sm-2 col-form-label">Ảnh 4</label>
	                    <div class="col-sm-10">
	                      <input class="form-control" type="file" name="pic4">
	                    </div>
	                  </div>
	            
	                  <div class="row mb-3">
	                    <label class="col-sm-2 col-form-label">Hãng</label>
	                    <div class="col-sm-10">
	                      <select class="form-select" aria-label="Default select example" name="productBrand">
	                        <option value="" selected>Bấm để chọn hãng</option>
	                        <option value="HP">HP</option>
	                        <option value="Asus">Asus</option>
	                        <option value="Lenovo">Lenovo</option>
	                        <option value="Dell">Dell</option>
	                        <option value="MSI">MSI</option>
	                        <option value="Macbook">Macbook</option>
	                        <option value="Gigabyte">Gigabyte</option>
	                      </select>
	                    </div>
	                  </div>
	                  <div class="row mb-3">
	                    <label class="col-sm-2 col-form-label">Nhập</label>
	                    <div class="col-sm-10">
	                      <button type="submit" class="btn btn-primary">Nhập hàng</button>
	                    </div>
	                  </div>
	              </div>
	            </div>
	          </div>
	
	            <div class="col-lg-6">
	              <div class="card">
	                <div class="card-body">
	                  <h5 class="card-title">Thông số kỹ thuật</h5>
	                  <div class="row mb-3">
	                    <label class="col-sm-2 col-form-label">Vi sử lý</label>
	                    <div class="col-sm-10">
	                      <input type="text" class="form-control" name="processor">
	                    </div>
	                  </div>
	                  <div class="row mb-3">
	                    <label class="col-sm-2 col-form-label">Màn hình</label>
	                    <div class="col-sm-10">
	                      <input type="number" class="form-control" name="screen">
	                    </div>
	                  </div>
	                  
	                  <div class="row mb-3">
	                    <label class="col-sm-2 col-form-label">Dung lượng RAM</label>
	                    <div class="col-sm-10">
	                      <input type="number" class="form-control" name="ram">
	                    </div>
	                  </div>
	                  <div class="row mb-3">
	                    <label class="col-sm-2 col-form-label">Bộ nhớ</label>
	                    <div class="col-sm-10">
	                      <input type="number" class="form-control" name="memory">
	                    </div>
	                  </div>
	                  <div class="row mb-3">
	                    <label class="col-sm-2 col-form-label">Card đồ hoạ</label>
	                    <div class="col-sm-10">
	                      <input type="text" class="form-control" name="graphicCard">
	                    </div>
	                  </div>
	                <div class="row mb-3">
	                    <label class="col-sm-2 col-form-label">Âm thanh</label>
	                    <div class="col-sm-10">
	                      <input type="text" class="form-control" name="audioCard">
	                    </div>
	                  </div>
	                  
	                </div>
	              </div>
	            </div>
	        </div>
        </form>
       </div>
    </section>

  </main><!-- End #main -->

<c:import url="components/footer.jsp"></c:import>