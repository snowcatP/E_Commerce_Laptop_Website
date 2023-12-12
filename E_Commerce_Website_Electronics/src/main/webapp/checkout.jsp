<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="web_components/head.jsp"></c:import>

<c:import url="web_components/header.jsp"></c:import>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- SECTION -->
		<div class="section">
			<!-- container -->
			<div class="container">
				<!-- row -->
				<div class="row">

					<div class="col-md-7">
						<!-- Billing Details -->
						<div class="billing-details">
							<div class="section-title">
								<h3 class="title">Thông tin khách hàng</h3>
							</div>
							
							<c:set var="user" value="${sessionScope.user}"/>
							<div class="form-group">
								<label for="firstName">First Name</label>
								<input class="input" type="text" name="firstName" id="firstName" value="<c:out value="${user.firstName }"/>">
							</div>
							<div class="form-group">
								<label for="firstName">Last Name</label>
								<input class="input" type="text" name="lastName" id="lastName" value="<c:out value="${user.lastName }"/>">
							</div>
							<div class="form-group">
								<label for="firstName">Email</label>
								<input class="input" type="email" name="email" id="email" value="<c:out value="${user.email }"/>">
							</div>
							<div class="form-group">
								<label for="firstName">Address</label>
								<input class="input" type="text" name="address" id="address" value="<c:out value="${user.address }"/>">
							</div>
							<div class="form-group">
								<label for="firstName">Phone</label>
								<input class="input" type=text name="phone" id="phone" value="<c:out value="${user.phone }"/>">
							</div>
						</div>
						<!-- /Billing Details -->

					</div>

					<!-- Order Details -->
					<div class="col-md-5 order-details">
						<div class="section-title text-center">
							<h3 class="title">Đơn hàng của bạn</h3>
						</div>
						
						<c:set var="cart" value="${sessionScope.cart }"/>
						<c:set var="products" value="${cart.products }"/>
						
						<div class="order-summary">
							<div class="order-col">
								<div><strong>Sản phẩm</strong></div>
								<div><strong>Giá tiền</strong></div>
							</div>
							
							<c:set var="totalPrice" value= "0"/>
							
							<c:forEach var="lineItem" items="${products }">
								<div class="order-products">
									<div class="order-col">
										<div><c:out value="${lineItem.quantity }"/>x <c:out value="${lineItem.product.nameProd }"/></div>
										<div><c:out value="${lineItem.product.price }"/> VND</div>
										<c:set var="totalPrice" value="${lineItem.quantity * lineItem.product.price + totalPrice}"/>
									</div>
								</div>
							</c:forEach>
							
							<div class="order-col">
								<div>Vận chuyển</div>
								<div><strong>Miễn phí</strong></div>
							</div>
							<div class="order-col">
								<div><strong>Tổng giá tiền</strong></div>
								<div><strong class="order-total"><c:out value="${totalPrice }"/> VND</strong></div>
							</div>
						</div>
						<div class="payment-method">
							<div class="input-radio">
								<input type="radio" name="payment" id="payment-1" checked>
								<label for="payment-1">
									<span></span>
									Vận chuyển COD
								</label>
							</div>
						</div>
						<div class="input-checkbox">
							<input type="checkbox" id="terms" oninput="checkCheckbox()">
							<label for="terms">
								<span></span>
								Tôi đã đọc và xác nhận <a href="#">các điều khoản.</a>
							</label>
							<p id="warning" style="color: red">Bạn phải tích vào nút xác nhận các điều khoản</p>
						</div>
						<form action="complete_invoice" method="post">
							<input type="hidden" name="totalPrice" value="<c:out value="${totalPrice }"/>"/>
							<input type="submit" class="primary-btn order-submit" id="order-submit" value="Mua" style="width:100%" disabled/>
						</form>
					</div>
					<!-- /Order Details -->
				</div>
				<!-- /row -->
			</div>
			<!-- /container -->
		</div>
		<!-- /SECTION -->
		
		
<script>

	function checkCheckbox() {
	    var checkbox = document.getElementById("terms");
	    var warningMessage = document.getElementById("warning");
	    const submit = document.getElementById("order-submit");
	    // Check if the checkbox is checked
	    if (checkbox.checked) {
	        // Checkbox is checked, set the warning message to empty
	        warningMessage.textContent = "";
	        submit.disabled = false;
	    } else {
	        // Checkbox is not checked, set the warning message
	        warningMessage.textContent = "Bạn phải tích vào nút xác nhận các điều khoản";
	    }
	}
</script>


<c:import url="web_components/footer.jsp"></c:import>