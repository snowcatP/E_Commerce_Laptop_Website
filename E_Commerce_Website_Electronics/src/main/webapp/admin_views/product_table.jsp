<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="components/head.jsp"></c:import>

<c:import url="components/header.jsp"></c:import>

<c:import url="components/sidebar.jsp"></c:import>

<main id="main" class="main">

	<div class="pagetitle">
		<h1>Quản lý sản phẩm</h1>
	</div>
	<!-- End Page Title -->

	<section class="section">
		<div class="row">
			<div class="col-lg-1"></div>
			<div class="col-lg-18">

				<div class="card">
					<div class="card-body">
						<h5 class="card-title">Danh sách sản phẩm</h5>
						<c:if test="${message != null}">
							<h5>
								<span style="color: green"><c:out value="${message}" /></span>
								</h5>
						</c:if>


						<!-- Table with stripped rows -->
						<table id="example" class="table table-striped">
							<thead>
								<tr>
									<th scope="col">ID</th>
									<th scope="col">Tên sản phẩm</th>
									<th scope="col">Ảnh</th>
									<th scope="col">Giá tiền</th>
									<th scope="col">Số lượng</th>
									<th scope="col">Sửa</th>
									<th scope="col">Xoá</th>
								</tr>
							</thead>
							<tbody>
							
								<c:forEach items="${allproductList}" var="o">
									<tr>
										<th scope="row"><c:out value="${o.productId}" /></th>
										<td><c:out value="${o.nameProd}" /></td>
										<td><img src="https://laptopwebsite.s3.ap-southeast-2.amazonaws.com/<c:out value="${o.image1}"/>"
											alt="" style="width: 100px;"></td>
										<td><c:out value="${o.price}" /></td>
										<td><c:out value="${o.quantity}" /></td>
										<td><a href="loadProduct?pid=${o.productId}" class="btn btn-outline-dark btn-sm">Sửa</a></td>
										<td><a href="delete?pid=${o.productId}" class="btn btn-outline-dark btn-sm">Xóa</a></td>
									</tr>
									
									
								</c:forEach>
							</tbody>
						</table>
						<!-- End Table with stripped rows -->

					</div>
				</div>
				<div class="col-lg-1"></div>
				</div>
			</div>
	</section>

</main>
<!-- End #main -->

<c:import url="components/footer.jsp"></c:import>