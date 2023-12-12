<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
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
					
					
					<c:set var="user" value="${sessionScope.user }"/>
					
					
					<form action="change_user_profile" method="post">
						<input type="hidden" name="action" value="update_profile">
						
						<div class="col-sm-1"> </div>
						<div class="col-sm-11">
						
							<c:set var="message" value="${requestScope.message }"/>
							
							<h3 style="color:red"><c:out value="${message }"/></h3>
							<div class="row mb-3" style="padding-bottom:1em">
			                    <label class="col-sm-2 col-form-label">Tài khoản</label>
			                    
			                    <%-- <input type="hidden" name="email" value="${user.email }"> --%>
			                    
			                    <div class="col-sm-9">
			                      <input type="text" class="form-control" name="email" value="${user.email }" readonly>
			                    </div>
			                </div>
							
							<div class="row mb-3" style="padding-bottom:1em">
			                    <label class="col-sm-2 col-form-label">Họ</label>
			                    <div class="col-sm-9">
			                      <input type="text" class="form-control" name="firstName" value="${user.firstName }" >
			                    </div>
			                </div>
							
							<div class="row mb-3" style="padding-bottom:1em">
			                    <label class="col-sm-2 col-form-label">Tên</label>
			                    <div class="col-sm-9">
			                      <input type="text" class="form-control" name="lastName" value="${user.lastName }">
			                    </div>
			                </div>
			                
			                <div class="row mb-3" style="padding-bottom:1em">
			                    <label class="col-sm-2 col-form-label">Địa chỉ</label>
			                    <div class="col-sm-9">
			                      <input type="text" class="form-control" name="address" value="${user.address }">
			                    </div>
			                </div>
			                
			                <div class="row mb-3"  style="padding-bottom:1em">
			                    <label class="col-sm-2 col-form-label">Số điện thoại</label>
			                    <div class="col-sm-9">
			                      <input type="text" class="form-control" name="phone" value="${user.phone }">
			                    </div>
			                </div>
							
							<div class="row mb-3">
			                    <label class="col-sm-2 col-form-label"></label>
			                    <div class="col-sm-10">
			                      <button type="submit" class="btn btn btn-dark btn-lg">Lưu thông tin</button>
			                    </div>
			                  </div>
							
						</div>
						
					</form>
					
				
					
				</div>
				
			</div>
		</div>
	</div>
</main>
<!-- End #main -->
<c:import url="web_components/footer.jsp"></c:import>