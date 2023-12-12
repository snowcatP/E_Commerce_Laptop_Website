<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="web_components/head.jsp"></c:import>
<c:import url="web_components/header.jsp"></c:import>

<main id="main" class="main"  style="background-color:#F9F9F9">

	<div class="section">
		<div class="container">
			<div class="row">
				

				<!-- SIDEBAR -->
				<c:import url="web_components/sidebar_user.jsp"></c:import>
				<!-- /SIDEBAR -->

				<div class="col-md-9" style="min-height:65vh; background-color:white">
					
					<div class="" style="margin:2em">
						<h3>Hồ sơ của tôi</h3>
						<p>Quản lý thông tin hồ sơ để bảo mật tài khoản</p>
					
						<hr>
					</div>
					
					<form action="change_user_profile" method="post">
						<input type="hidden" name="action" value="change_password">
						<input type="hidden" name="email" value="${sessionScope.user.email }"/>
						
						<div class="col-sm-1"> </div>
						<div class="col-sm-11">
						
							<c:set var="message" value="${requestScope.message }"/>
							<h3 style="color:red"><c:out value="${message }"/></h3>
							
							<div class="row mb-3" style="padding-bottom:1em">
			                    <label class="col-sm-4 col-form-label">Mật khẩu</label>
			                    <div class="col-sm-7">
			                      <input type="password" class="form-control" name="currentPassword" id="currentPassword">
			                    </div>
			                    <div class="col-sm-1"></div>
			                </div>
							
							<div class="row mb-3" style="padding-bottom:1em">
			                    <label class="col-sm-4 col-form-label">Mật khẩu mới</label>
			                    <div class="col-sm-7">
			                      <input type="password" class="form-control" name="newPassword" id="newPassword">
			                    </div>
			                    <div class="col-sm-1"></div>
			                </div>
							
							<div class="row mb-3" style="padding-bottom:1em">
			                    <label class="col-sm-4 col-form-label">Nhập lại mật khẩu mới</label>
			                    <div class="col-sm-7">
			                      <input type="password" class="form-control" name="renewPassword" id="renewPassword" oninput="checkPassword()">
			                    </div>
			                    <div class="col-sm-1"></div>
			                </div>
							
							<p id="errorMessage" style="color:red"></p>
							
							<div class="row mb-3">
			                    <label class="col-sm-4 col-form-label"></label>
			                    <div class="col-sm-7">
			                      <button type="submit" class="btn btn btn-dark btn-lg" id="changePassButton" disabled>Đổi mật khẩu</button>
			                    </div>
			                  </div>
							
						</div>
						
					</form>
						
					<script>
				        function checkPassword() {
				            var newPassword = document.getElementById("newPassword").value;
				            var renewPassword = document.getElementById("renewPassword").value;
				            var currentPassword = document.getElementById("currentPassword").value;
				            
				            var errorMessageElement = document.getElementById("errorMessage");
							var submitButton = document.getElementById("changePassButton");
				            if (newPassword === renewPassword && renewPassword.textContent !== "" && currentPassword.textContent !== "") {
				                // Passwords match
				                errorMessageElement.textContent = ""; // Clear any previous error message
				                // You can add additional logic here, like submitting the form
				                submitButton.disabled = false;
				                
				            } else {
				                // Passwords do not match
				                errorMessageElement.textContent = "Passwords do not match. Please try again.";
				                
				                // You can add additional logic here, like clearing the password fields
				            }
				        }
				    </script>
					
					
				</div>
				
			</div>
		</div>
	</div>
</main>
<!-- End #main -->
<c:import url="web_components/footer.jsp"></c:import>