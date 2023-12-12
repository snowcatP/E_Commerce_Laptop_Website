<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<body>
<header>
			<!-- MAIN HEADER -->
			<div id="header">
				<!-- container -->
				<div class="container">
					<!-- row -->
					<div class="row">
						<!-- LOGO -->
						<div class="col-md-3">
							<div class="header-logo">
								<a href="index.jsp" class="logo">
									<img src="./img/logo.png" alt="">
								</a>
							</div>
						</div>
						<!-- /LOGO -->

						<!-- SEARCH BAR -->
						<div class="col-md-6">
							<div class="header-search">
								<form>
									<select class="input-select">
										<option value="0">Tất cả</option>
										<option value="1">Smart Phone</option>
										<option value="1">Laptop</option>
										<option value="1">Hearphone</option>
										<option value="1">Accessories</option>
									</select>
									<input class="input" placeholder="Nhập từ khoá">
									<button class="search-btn">Tìm kiếm</button>
								</form>
							</div>
						</div>
						
						<!-- /SEARCH BAR -->

						<!-- ACCOUNT -->
						<div class="col-md-3">
							<div class="header-ctn">
								<!-- Cart -->
								<div class="dropdown">
									<a class="dropdown-toggle pe-auto" href="#" data-toggle="dropdown" aria-expanded="true">
										<i class="fa fa-shopping-cart"></i>
										<span>Giỏ hàng</span>
										<div class="qty">3</div>
									</a>
									<div class="cart-dropdown">
										<div class="cart-list">
											<div class="product-widget">
												<div class="product-img">
													<img src="product.hstatic.net/200000420363/product/laptop-gigabyte-g5-mf-f2vn333sh_e870855e87e44ec19a23c5e8b949b85e_large.png" alt="">
												</div>
												<div class="product-body">
													<h3 class="product-name"><a href="#">product name goes here</a></h3>
													<h4 class="product-price"><span class="qty">1x</span>$980.00</h4>
												</div>
												<button class="delete"><i class="fa fa-close"></i></button>
											</div>

											<div class="product-widget">
												<div class="product-img">
													<img src="./img/product02.png" alt="">
												</div>
												<div class="product-body">
													<h3 class="product-name"><a href="#">product name goes here</a></h3>
													<h4 class="product-price"><span class="qty">3x</span>$980.00</h4>
												</div>
												<button class="delete"><i class="fa fa-close"></i></button>
											</div>
										</div>
										<div class="cart-summary">
											<small>3 Item(s) selected</small>
											<h5>SUBTOTAL: $2940.00</h5>
										</div>
										<div class="cart-btns">
											<a href="#">Xem giỏ hàng</a>
											<a href="checkout.jsp">Thanh toán  <i class="fa fa-arrow-circle-right"></i></a>
										</div>
									</div>
								</div>
								<!-- /Cart -->
								
								<div>
									<a href="login.jsp">
										<i class="fa fa-user-o"></i>
										<span>Tài khoản</span>
									</a>
								</div>

							</div>
						</div>
						<!-- /ACCOUNT -->
					</div>
					<!-- row -->
				</div>
				<!-- container -->
			</div>
			<!-- /MAIN HEADER -->
</header>
