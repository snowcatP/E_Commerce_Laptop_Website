<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- Head -->
<c:import url="web_components/head.jsp"></c:import>
<!-- /Head -->

<c:import url="web_components/header.jsp"></c:import>

		<!-- BREADCRUMB -->
		
		<!-- /BREADCRUMB -->

		<!-- SECTION -->
		<div class="section">
			<!-- container -->
			<div class="container">
				<!-- row -->
				<div class="row">
					<!-- Product main img -->
					<div class="col-md-5 col-md-push-2">
						<div id="product-main-img">
							<div class="product-preview">
								<img src="https://laptopwebsite.s3.ap-southeast-2.amazonaws.com/<c:out value="${detailProduct.image1}"/>" alt="">
							</div>

							<div class="product-preview">
								<img src="https://laptopwebsite.s3.ap-southeast-2.amazonaws.com/<c:out value="${detailProduct.image2}"/>" alt="">
							</div>

							<div class="product-preview">
								<img src="https://laptopwebsite.s3.ap-southeast-2.amazonaws.com/<c:out value="${detailProduct.image3}"/>" alt="">
							</div>
							
							<div class="product-preview">
								<img src="https://laptopwebsite.s3.ap-southeast-2.amazonaws.com/<c:out value="${detailProduct.image4}"/>" alt="">
							</div>
						</div>
					</div>
					<!-- /Product main img -->

					<!-- Product thumb imgs -->
					<div class="col-md-2  col-md-pull-5">
						<div id="product-imgs">
							<div class="product-preview">
								<img src="https://laptopwebsite.s3.ap-southeast-2.amazonaws.com/<c:out value="${detailProduct.image1}"/>" alt="">
							</div>

							<div class="product-preview">
								<img src="https://laptopwebsite.s3.ap-southeast-2.amazonaws.com/<c:out value="${detailProduct.image2}"/>" alt="">
							</div>

							<div class="product-preview">
								<img src="https://laptopwebsite.s3.ap-southeast-2.amazonaws.com/<c:out value="${detailProduct.image3}"/>" alt="">
							</div>
							
							<div class="product-preview">
								<img src="https://laptopwebsite.s3.ap-southeast-2.amazonaws.com/<c:out value="${detailProduct.image4}"/>" alt="">
							</div>
						</div>
					</div>
					<!-- /Product thumb imgs -->

					<!-- Product details -->
					<div class="col-md-5">
						<div class="product-details">
							<h2 class="product-name">${detailProduct.nameProd}</h2>
							<div>
								<h3 class="product-price">${detailProduct.price}</h3>
								<span class="product-available">Còn hàng</span>
							</div>
							<p>${detailProduct.description}</p>


							<div class="add-to-cart">
								<form action="add_product_to_cart" method="post">
									<div class="qty-label">
										Số lượng
										<div class="input-number">
											<c:set var="user" value="${sessionScope.user }"/>
											<input type="hidden" name="user" value="<c:out value="${user }"/>"/>
											<input type="hidden" name="productId" value="${detailProduct.productId }"/>
											<input type="number" name="productQuantity" value="1">
											<span class="qty-up">+</span>
											<span class="qty-down">-</span>
										</div>
									</div>
									<input type="submit" class="add-to-cart-btn" value="Thêm vào giỏ hàng" />
								</form>
							</div>


							<ul class="product-links">
								<li>Loại:</li>
								<li><a href="#">${detailProduct.category}</a></li>
							</ul>
							<ul class="product-links">
								<li>Hãng:</li>
								<li><a href="#">${detailProduct.brand}</a></li>
							</ul>


						</div>
					</div>
					<!-- /Product details -->

					<!-- Product tab -->
					<div class="col-md-12">
						<div id="product-tab">
							<!-- product tab nav -->
							<ul class="tab-nav">
								<li class="active"><a data-toggle="tab" href="#tab1">Thông tin</a></li>
								<li><a data-toggle="tab" href="#tab2">Cấu hình</a></li>
							</ul>
							<!-- /product tab nav -->

							<!-- product tab content -->
							<div class="tab-content">
								<!-- tab1  -->
								<div id="tab1" class="tab-pane fade in active">
									<div class="row">
										<div class="col-md-12">
											<p>${detailProduct.description }</p>
										</div>
									</div>
								</div>
								<!-- /tab1  -->

								<!-- tab2  -->
								<div id="tab2" class="tab-pane fade in">
									<div class="row">
										<div class="col-md-12">
											<p>CPU: ${detailProduct.configuration.processor}</p>
											<p>RAM: ${detailProduct.configuration.ram}</p>
											<p>Dung lượng: ${detailProduct.configuration.memory}</p>
											<p>Màn hình: ${detailProduct.configuration.screen} inch</p>
											<p>Card màn hình: ${detailProduct.configuration.graphicCard}</p>
											<p>Loa: ${detailProduct.configuration.audioCard} loa</p>
										</div>
									</div>
								</div>
								<!-- /tab2  -->

								
							</div>
							<!-- /product tab content  -->
						</div>
					</div>
					<!-- /product tab -->
				</div>
				<!-- /row -->
			</div>
			<!-- /container -->
		</div>
		<!-- /SECTION -->

		<!-- Section -->
		<div class="section">
			<!-- container -->
			<div class="container">
				<!-- row -->
				<div class="row">

					<div class="col-md-12">
						<div class="section-title text-center">
							<h3 class="title">Sản phẩm liên quan</h3>
						</div>
					</div>

					<!-- product -->
					<c:forEach items="${listRelatedProduct}" var="related">
						<a href="view_detail?pid=${related.productId}">
							<div class="col-md-3 col-xs-6">
								<div class="product">
									<div class="product-img">
										<img src="https://laptopwebsite.s3.ap-southeast-2.amazonaws.com/<c:out value="${related.image1}"/>" alt="" style="width: 100%; height: 100%;">
									</div>
									<div class="product-body">
										<p class="product-category"><c:out value="${related.brand}"/></p>
										<h3 class="product-name"><c:out value="${related.nameProd}"/></h3>
										<h4 class="product-price"><c:out value="${related.price}"/></h4>
									</div>
								</div>
							</div>
						</a>
					</c:forEach>
					<!-- /product -->


					<div class="clearfix visible-sm visible-xs"></div>


				</div>
				<!-- /row -->
			</div>
			<!-- /container -->
		</div>
		<!-- /Section -->

<c:import url="web_components/footer.jsp"></c:import>