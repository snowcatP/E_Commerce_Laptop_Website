<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- Head -->
<c:import url="web_components/head.jsp"></c:import>
<!-- /Head -->

<!-- Body -->	
<!-- HEADER -->
<c:import url="web_components/header.jsp"></c:import>
<!-- /HEADER -->

<c:import url="web_components/navigation.jsp"></c:import>

<!-- BODY SECTION -->
		<!-- SECTION -->
		<div class="section">
			<!-- container -->
			<div class="container">
				<!-- row -->
				<div class="row">

					<!-- section title -->
					<div class="col-md-12">
						<div class="section-title">
							<h3 class="title">Sản phẩm mới</h3>
							<div class="section-nav">
								<ul class="section-tab-nav tab-nav">
									<li class="active"><a data-toggle="tab" href="store_view">Laptops</a></li>
								</ul>
							</div>
						</div>
					</div>
					<!-- /section title -->

					<!-- Products tab & slick -->
					<div class="col-md-12">
						<div class="row">
							<div class="products-tabs">
								<!-- tab -->
								<div id="tab1" class="tab-pane active">
									<div class="products-slick" data-nav="#slick-nav-1">
										<!-- product -->
										<c:forEach items="${top6new}" var="top6">
											<a href="view_detail?pid=${top6.productId}">
												<div class="product">
													<div class="product-img">
														<img src="https://laptopwebsite.s3.ap-southeast-2.amazonaws.com/<c:out value="${top6.image1}"/>" alt="" style="width: 100%; height: 100%;">
														<div class="product-label">
															<span class="new">NEW</span>
														</div>
													</div>
													<div class="product-body">
														<p class="product-category">${top6.brand}</p>
														<h3 class="product-name">${top6.nameProd}</h3>
														<h4 class="product-price">${top6.price}₫ </h4>
													</div>
												</div>
											</a>
										</c:forEach>
										<!-- /product -->
										
									</div>
									<div id="slick-nav-1" class="products-slick-nav"></div>
								</div>
								<!-- /tab -->
							</div>
						</div>
					</div>
					<!-- Products tab & slick -->
				</div>
				<!-- /row -->
			</div>
			<!-- /container -->
		</div>
		<!-- /SECTION -->

		<!-- HOT DEAL SECTION -->
		<div class="block__banner">
                        
			<div class="">
					<div class="item_banner" data-href="https://www.thegioididong.com/laptop?g=laptop-gaming" style="background-color:#FFE726">
						<a data-cate="44" data-place="1694" rel="nofollow" href="javascript:;" ><img style="cursor:pointer" src="https://cdn.tgdd.vn/2023/11/banner/gaming-desk-1200x200.png" alt="Gaming B2S" width="800" height="200"></a>
					</div>
			</div>
		</div>
		<!-- /HOT DEAL SECTION -->

		<!-- SECTION -->
		<div class="section">
			<!-- container -->
			<div class="container">
				<!-- row -->
				<div class="row">

					<!-- section title -->
					<div class="col-md-12">
						<div class="section-title">
							<h3 class="title">Top Sản Phẩm</h3>
							<div class="section-nav">
								<ul class="section-tab-nav tab-nav">
									<li class="active"><a data-toggle="tab" href="#tab2">Laptops</a></li>
								</ul>
							</div>
						</div>
					</div>
					<!-- /section title -->

					<!-- Products tab & slick -->
					<div class="col-md-12">
						<div class="row">
							<div class="products-tabs">
									<c:forEach items="${productList}" var="o">
									  <a href="view_detail?pid=${o.productId}">
										<!-- product -->
										<div class="col-md-3">
											<div class="product">
												<div class="product-img" style="position: relative; overflow: hidden; width: 100%;">
													<img src="https://laptopwebsite.s3.ap-southeast-2.amazonaws.com/<c:out value="${o.image1}"/>" alt="" style="width: 100%; height: 100%;">
													<div class="product-label">
													</div>
												</div>
												<div class="product-body">
													<p class="product-category"><c:out value="${o.brand}"/></p>
													<h3 class="product-name"><c:out value="${o.nameProd}"/></h3>
													<h4 class="product-price"><c:out value="${o.price}"/>đ</h4>
												</div>
											</div>
											</div>
										<!-- /product -->
										</a>
									</c:forEach>
										
								</div>
								<!-- /tab -->
							</div>
						</div>
					</div>
					<!-- /Products tab & slick -->
				</div>
				<!-- /row -->
			</div>
			<!-- /container -->
		</div>
		<!-- /SECTION -->
<!-- /BODY SECTION -->
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"></script>

<c:import url="web_components/footer.jsp"></c:import>
<!-- /Body -->