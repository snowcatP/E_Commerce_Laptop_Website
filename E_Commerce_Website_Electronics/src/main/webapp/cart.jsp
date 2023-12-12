<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="web_components/head.jsp"></c:import>
<c:import url="web_components/header.jsp"></c:import>

<main id="main" class="main" style="background-color: #F9F9F9">

	<div class="section">
		<div class="container">
			<div class="row">

				<div id="cart" class="col-md-12 mt-4"
					style="min-height: 75vh; background-color: white">
					<div class="container" style="margin-top:2em;margin-bottom:2em">
						<div class="row">
							<!-- Loop through items in the cart -->
							<div class="col-md-1"></div>
							<div class="col-md-10">
								<div class="card">
								
								<c:set var="cart" value="${sessionScope.cart }"/>
								
									<div class="card-header">
										<h2>Giỏ hàng</h2>
										<c:if test="${cart.products == null }">
											<h3 style="color:green">Không có sản phẩm trong giỏ hàng!</h3>
										</c:if>
										
									</div>
									
									<c:if test="${cart.products != null }">
										<div class="card-body" style="color:black">
											<div class="table-responsive">
												<table class="table table-bordered m-0">
													<thead>
														<tr>
															<th class="text-center py-3 px-4"
																style="min-width: 400px;">Sản phẩm</th>
															<th class="text-center py-3 px-4" style="width: 100px;">Đơn giá</th>
															<th class="text-center py-3 px-4" style="width: 120px;">Số lượng</th>
															<th class="text-center py-3 px-4" style="width: 100px;">Tổng</th>
															<th class="text-center align-middle py-3 px-0"
																style="width: 40px;"><a href="#"
																class="shop-tooltip float-none " title=""
																data-original-title="Clear cart"><i
																	class="ino ion-md-trash"></i></a></th>
														</tr>
													</thead>
													<tbody>
														<c:set var="products" value="${cart.products }"/>
														<c:set var="totalPrice" value= "0"/>
														<c:forEach var="lineProduct" items="${products }">
															<tr>
																	<c:set var="product" value="${lineProduct.product }"/>
																	<c:set var="quantity" value="${lineProduct.quantity }"/>
																	<td class="p-4">
																		<input type="hidden" name="productId" value="<c:out value="${product.productId }" />"/>
																		<div class="media align-items-center">
																			<div class="row">
																				<div class="col-md-4">
																					<img src="https://laptopwebsite.s3.ap-southeast-2.amazonaws.com/<c:out value="${product.image1}"/>"
																						class="d-block ui-w-40 ui-bordered mr-4" alt=""
																						style="height: 100px">
																				</div>
																				<div class="media-body">
																					<a href="view_detail?pid=<c:out value="${product.productId }"/>" class="d-block text-dark"><c:out value="${product.nameProd }"/></a><br>
																					<small>
																						<span class="">Loại: <c:out value="${product.category }"/></span><br>
																						<span class="">Hãng: <c:out value="${product.brand }"/></span><br>
																					</small>
																				</div>
																			</div>
																		</div>
																	</td>
																	<td
																		class="text-center font-weight-semibold align-middle p-4"><c:out value="${product.price }"/> VND</td>
																	<td class="align-midle p-4 align-middle">
																		<form action="update_product_quantity" method="post">
																			<input type="text" name="quantity" class="form-control text-center" value="<c:out value="${quantity }"/>">
																			<input type="hidden" name="productId" value="<c:out value="${product.productId }"/>" />
																			<input type="submit" value="Cập nhật" style="margin-top:0.5em; margin-left:0.8em"/>
																		</form>
																	</td>
																	<td
																		class="text-center font-weight-semibold align-middle p-4"><c:out value="${quantity * product.price}"/> VND
																		<c:set var="totalPrice" value="${quantity * product.price + totalPrice}"/>
																	</td>
																		
																	<td class="text-center align-middle px-0 align-middle">
																		<form action="remove_product" method="post">
																			<input type="hidden" name="productId" value="<c:out value="${product.productId }" />">
																			<input class="shop-tooltip float-none text-center"
																				type="submit" value="Xoá" style="max-width:3em"/>
																			
																		</form>
																	</td>
																
															</tr>
														</c:forEach>
													</tbody>
												</table>
											</div>
											<div
												class="d-flex flex-wrap justify-content-between align-items-center pb-4">
	
												<div class="d-flex">
													<div class="text-right mt-4">
														<label class="text-muted font-weight-bold m-0">Tổng tiền</label>
														<div class="text-large">
															<strong><c:out value="${totalPrice }"/> VND</strong>
														</div>
													</div>
												</div>
											</div>
											<div class="float-right" style="padding-top:1em">
												<div class="col-md-8"></div>
												<div class="col-md-4">
													<a href="home" class="btn btn-lg btn-danger md-btn-flat" style="margin-right:2em">Quay lại</a>
													<a href="user_invoice" class="btn btn-lg btn-danger">Thanh toán</a>
												</div>
											</div>
										</div>
									</c:if>
								</div>
							</div>
							<div class="col-md-1" style=""></div>
							<!-- /Cart Items -->
							</div>
						</div>
					</div>
				</div>
		</div>
	</div>
</main><!-- End #main -->

<c:import url="web_components/footer.jsp"></c:import>
