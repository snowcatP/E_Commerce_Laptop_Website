<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- ASIDE -->
					<div id="aside" class="col-md-3">
						<h2 class="d-inline-flex pb-3">Trang Cá Nhân</h2>
					
						<!-- aside Widget -->
						<div class="aside">
							<h3 class="aside-title" style="padding-top:1em"><a href="user_detail.jsp">Tài khoản của tôi</a></h3>
							<div class="checkbox-filter">

								<div class="input-checkbox">
									<label for="category-1">
										<a href="user_detail?action=user_detail">Hồ sơ</a>
									</label>
								</div>

								<div class="input-checkbox">
									<label for="category-2">
										<a href="user_detail?action=change_password">Đổi mật khẩu</a>
									</label>
								</div>

							</div>
						</div>
						<!-- /aside Widget -->

						<!-- aside Widget -->
						<div class="aside">
							<h3 class="aside-title"><a href="user_detail?action=cart">Giỏ hàng</a></h3>
							
						</div>
						<!-- /aside Widget -->
						
						<!-- aside Widget -->
						<div class="aside">
							<h3 class="aside-title"><a href="user_detail?action=order_status">Đơn mua</a></h3>
							
						</div>
						<!-- /aside Widget -->
					</div>
					<!-- /ASIDE -->
