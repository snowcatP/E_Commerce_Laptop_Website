<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="components/head.jsp"></c:import>
  
<c:import url="components/header.jsp"></c:import>  

<c:import url="components/sidebar.jsp"></c:import>

  <main id="main" class="main">

    <div class="pagetitle">
      <h1>Chỉnh sửa thông tin sản phẩm</h1>
    </div><!-- End Page Title -->

    <section class="section">
      <div class="row">
      
        <form action="edit_product" method ="post" enctype="multipart/form-data">
        
        	<c:set var="detail" value="${requestScope.detail }"/>
        	
			<div class="row">	
	          <!-- General Form Elements -->
	          <div class="col-lg-6">
	            <div class="card">
	              <div class="card-body">
	                  <h5 class="card-title">Nhập thông tin sản phẩm</h5>
	                  <input type="hidden" name="action" value="action"/>
	                  <input type="hidden" name="productId" value="<c:out value="${detail.productId}"/>" />
	                  <div class="row mb-3">
	                    <label class="col-sm-2 col-form-label">Tên sản phẩm</label>
	                    <div class="col-sm-10">
	                      <input type="text" class="form-control" name="nameProd" value="<c:out value="${detail.nameProd }" />">
	                    </div>
	                  </div>
	                  <div class="row mb-3">
	                    <label class="col-sm-2 col-form-label">Giá</label>
	                    <div class="col-sm-10">
	                      <input type="text" class="form-control" name="price" value="<c:out value="${detail.price}"/>">
	                    </div>
	                  </div>
	                  <div class="row mb-3">
	                    <label class="col-sm-2 col-form-label">Loại sản phẩm</label>
	                    <div class="col-sm-10">
	                      <input type="text" class="form-control" value="<c:out value="${detail.category}"/>" name="category" readonly>
	                    </div>
	                  </div>
	                  <div class="row mb-3">
	                    <label class="col-sm-2 col-form-label">Thông tin sản phẩm</label>
	                    <div class="col-sm-10">
	                      <textarea class="form-control" name="description"  style="height: 100px"><c:out value="${detail.description}"/></textarea>
	                    </div>
	                  </div>
	                  <div class="row mb-3">
	                    <label class="col-sm-2 col-form-label">Số lượng</label>
	                    <div class="col-sm-10">
	                      <input type="number" class="form-control" name="quantity" value="<c:out value="${detail.quantity}"/>">
	                    </div>
	                  </div>
	                  <div class="row mb-3">
	                    <label class="col-sm-2 col-form-label">Ảnh 1</label>
	                    <div class="col-sm-10">
	                      <input class="form-control" type="file" name="image1" value="<c:out value="${detail.image1}"/>">
	                      <p>${detail.image1}</p>
	                    </div>
	                  </div>
	                  <div class="row mb-3">
	                    <label class="col-sm-2 col-form-label">Ảnh 2</label>
	                    <div class="col-sm-10">
	                      <input class="form-control" type="file" name="image2" value="<c:out value="${detail.image2}"/>">
	                      <p>${detail.image2}</p>
	                    </div>
	                  </div>
	                  <div class="row mb-3">
	                    <label class="col-sm-2 col-form-label">Ảnh 3</label>
	                    <div class="col-sm-10">
	                      <input class="form-control" type="file" name="image3" value="<c:out value="${detail.image3}"/>">
	                      <p>${detail.image3}</p>
	                    </div>
	                  </div>
	                  <div class="row mb-3">
	                    <label class="col-sm-2 col-form-label">Ảnh 4</label>
	                    <div class="col-sm-10">
	                      <input class="form-control" type="file" name="image4" value="<c:out value="${detail.image4}"/>">
	                      <p>${detail.image4}</p>
	                    </div>
	                  </div>
	            
	                  <div class="row mb-3">
	                    <label class="col-sm-2 col-form-label">Hãng</label>
	                    <div class="col-sm-10">
	                      <select class="form-select" aria-label="Default select example" name="brand">
	                        <option value="<c:out value="${detail.brand}"/>" selected><c:out value="${detail.brand}"/></option>
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
	                  <!-- <div class="row mb-3">
	                    <label class="col-sm-2 col-form-label">Sửa</label>
	                    <div class="col-sm-10">
	                      <button type="submit" class="btn btn-primary">Hoàn tất</button>
	                    </div>
	                  </div> -->
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
	                      <input type="text" class="form-control" name="processor" value="<c:out value="${detail.configuration.processor}"/>">
	                    </div>
	                  </div>
	                  <div class="row mb-3">
	                    <label class="col-sm-2 col-form-label">Màn hình</label>
	                    <div class="col-sm-10">
	                      <input type="text" class="form-control" name="screen" value="<c:out value="${detail.configuration.screen}"/>">
	                    </div>
	                  </div>
	                  
	                  <div class="row mb-3">
	                    <label class="col-sm-2 col-form-label">Dung lượng RAM</label>
	                    <div class="col-sm-10">
	                      <input type="number" class="form-control" name="ram" value="<c:out value="${detail.configuration.ram}"/>">
	                    </div>
	                  </div>
	                  <div class="row mb-3">
	                    <label class="col-sm-2 col-form-label">Bộ nhớ</label>
	                    <div class="col-sm-10">
	                      <input type="number" class="form-control" name="memory" value="<c:out value="${detail.configuration.memory}"/>">
	                    </div>
	                  </div>
	                  <div class="row mb-3">
	                    <label class="col-sm-2 col-form-label">Card đồ hoạ</label>
	                    <div class="col-sm-10">
	                      <input type="text" class="form-control" name="graphicCard" value="<c:out value="${detail.configuration.graphicCard}"/>">
	                    </div>
	                  </div>
	                <div class="row mb-3">
	                    <label class="col-sm-2 col-form-label">Âm thanh</label>
	                    <div class="col-sm-10">
	                      <input type="text" class="form-control" name="audioCard" value="<c:out value="${detail.configuration.audioCard}"/>">
	                    </div>
	                  </div>
	                  
		                <div class="row mb-3">
		                    <label class="col-sm-2 col-form-label">Sửa</label>
		                    <div class="col-sm-10">
		                      <button type="submit" class="btn btn-primary">Hoàn tất</button>
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