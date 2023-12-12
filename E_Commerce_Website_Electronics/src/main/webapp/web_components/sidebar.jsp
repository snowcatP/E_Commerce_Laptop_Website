<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- ASIDE -->
					<div id="aside" class="col-md-3">
						<!-- aside Widget -->
						<div class="aside">
							<h3 class="aside-title">Categories</h3>
							<div class="checkbox-filter">

								<div class="input-checkbox">
									<input type="checkbox" id="category-1" name="GAMING" value="Gaming" >
									<label for="category-1">
										<span></span>
										Gaming
										<small></small>
									</label>
								</div>

								<div class="input-checkbox">
									<input type="checkbox" id="category-2" name="OFFICE" value="Office">
									<label for="category-2">
										<span></span>
										Office
										<small></small>
									</label>
								</div>
								<a href="#" onclick="searchByCategory()" class="btn btn-primary">Search</a>
							</div>
						</div>
						<!-- /aside Widget -->

						<!-- aside Widget -->
						<div class="aside">
							<h3 class="aside-title">Price</h3>
							<div class="price-filter">
								<div id="price-slider"></div>
								<div class="input-number price-min">
									<input id="price-min" type="number" name="PRICE_MIN" >
									<span class="qty-up">+</span>
									<span class="qty-down">-</span>
								</div>
								<span>-</span>
								<div class="input-number price-max">
									<input id="price-max" type="number" name="PRICE_MAX">
									<span class="qty-up">+</span>
									<span class="qty-down">-</span>
								</div>
								<a href="#" onclick="searchByRangePrice()" class="btn btn-primary">Search</a>
							</div>
							
						</div>
						<!-- /aside Widget -->

						<!-- aside Widget -->
						<div class="aside">
							<h3 class="aside-title">Brand</h3>
							<div class="checkbox-filter">
								<div class="input-checkbox">
									<input  type="checkbox" name="HP" value="HP" id="brand-1" >
									<label for="brand-1">
									
										<span></span>
										HP
										<small></small>
									</label>
								</div>
								<div class="input-checkbox">
									<input type="checkbox" name="ASUS" value="Asus" id="brand-2" >
									<label for="brand-2">
										<span></span>
										ASUS
										<small></small>
									</label>
								</div>
			
								<div class="input-checkbox">
									<input type="checkbox" name="LENOVO" value="Lenovo" id="brand-3" >
									<label for="brand-3">
										<span></span>
										LENOVO
										<small></small>
									</label>
								</div>
								<div class="input-checkbox">
									<input type="checkbox" name="DELL" value="Dell" id="brand-4" >
									<label for="brand-4">
										<span></span>
										DELL
										<small></small>
									</label>
								</div>
								<div class="input-checkbox">
									<input type="checkbox" name="MSI" value="MSI" id="brand-5" >
									<label for="brand-5">
										<span></span>
										MSI
										<small></small>
									</label>
								</div>
								<div class="input-checkbox">
									<input type="checkbox" name="Macbook" value="Macbook" id="brand-6" >
									<label for="brand-6">
										<span></span>
										Macbook
										<small></small>
									</label>
								</div>
								<div class="input-checkbox">
									<input type="checkbox" name="Gigabyte" value="Gigabyte" id="brand-7" 	>
									<label for="brand-7">
										<span></span>
										Gigabyte
										<small></small>
									</label>
								</div>
								<a href="#" onclick="searchByBrand()" class="btn btn-primary">Search</a>
							</div>
						</div>
					
						<!-- /aside Widget -->

						<!-- aside Widget -->
						<div class="aside">
							<h3 class="aside-title">Top Product</h3>
							<c:forEach items="${topProduct}" var="tp">
								<div class="product-widget">
									<div class="product-img">
										<img src="./images/<c:out value="${tp.image1}"/>" alt="" style="width: 100%; height: 100%;">
									</div>
									<div class="product-body">
										<p class="product-category">${tp.brand}</p>
										<h3 class="product-name"><a href="view_detail?pid=${tp.productId}">${tp.nameProd}</a></h3>
										<h4 class="product-price">${tp.price}</h4>
									</div>
								</div>
							</c:forEach>
						</div>
						<!-- /aside Widget -->
					</div>
					<!-- /ASIDE -->
