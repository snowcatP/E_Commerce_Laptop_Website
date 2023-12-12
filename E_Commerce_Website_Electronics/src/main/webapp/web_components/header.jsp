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
								<a href="home" class="logo">
									<img src="./img/logo.png" alt="">
								</a>
							</div>
						</div>
						<!-- /LOGO -->

						<!-- SEARCH BAR -->
						<div class="col-md-6">
							<div class="header-search">
								<form action="search_by_name" method="post">
									<select class="input-select">
										<option value="0">Tất cả</option>
									</select>
									<input class="input" name="namesearch" placeholder="Nhập từ khoá">
									<button type="submit" class="search-btn">Tìm kiếm</button>
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
										
										<%@ page import="model.*, java.util.*" %>
										<%
											Cart cart = (Cart)session.getAttribute("cart");
											List<LineProduct> products = null;
											int numOfLineProd = 0;
											
											if(cart != null){
												products = cart.getProducts();
												numOfLineProd = products.size();
											}
										%>
										
										<% if (numOfLineProd > 0) {%>
											<div class="qty"><%= numOfLineProd %></div>
										
										<%} %>
										
										
									</a>
									<div class="cart-dropdown">
										<div class="cart-list">
										<c:set var="cart" value="${sessionScope.cart }"/>
										<c:set var="products" value="${cart.products }"/>
										
										<c:forEach var="lineProduct" items="${products }">
											<c:set var="product" value="${lineProduct.product }"/>
											<c:set var="quantity" value="${lineProduct.quantity }"/>
											<div class="product-widget">
												<div class="product-img">
													<img src="./images/<c:out value="${product.productId }"/>" alt="" style="width:50px">
												</div>
												<div class="product-body">
													<h3 class="product-name"><a href="view_detail?pid=<c:out value="${product.productId }"/>"><c:out value="${product.nameProd }"/></a></h3>
													<h4 class="product-price"><span class="qty"><c:out value="${quantity}"/>x</span><c:out value="${product.price }"/> VND</h4>
												</div>
												
											</div>

										</c:forEach>
										</div>
										<div class="cart-btns">
											<a href="user_detail?action=cart">Xem giỏ hàng</a>
											<a href="user_invoice">Thanh toán  <i class="fa fa-arrow-circle-right"></i></a>
										</div>
									</div>
								</div>
								<!-- /Cart -->
								
								<div class="dropdown">
									
									<%
										User user = (User)session.getAttribute("user");
									%>
									
									<%if (user != null){ %>
										<a class="dropdown-toggle pe-auto" href="#" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
											<i class="fa fa-user-o"></i>
											<span ><%= user.getFirstName()%> <%= user.getLastName() %></span>
										</a>
										<ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow">
								            <li>
								              <a class="dropdown-item align-items-center" href="user_detail?action=user_detail" style="padding-top:1em; padding-bottom:1em">
								                <i class="bi bi-person"></i>
								                <span>Tài khoản của tôi</span>
								              </a>
								            </li>
								
								            <li>
								              <a class="dropdown-item align-items-center" href="logout?action=logout" style="padding-top:1em; padding-bottom:1em">
								                <i class="bi bi-box-arrow-right"></i>
								                <span>Đăng xuất</span>
								              </a>
								            </li>
								
								        </ul><!-- End Profile Dropdown Items -->
									<%} else { %>										
										<a href="login.jsp">
											<i class="fa fa-user-o"></i>
											<span>Tài khoản</span>
										</a>
									<%} %>
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
