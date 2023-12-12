<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>


<!-- HEAD -->
<c:import url="components/head.jsp"></c:import>
<!-- HEAD -->

<!-- HEADER -->
<c:import url="components/header.jsp"></c:import>	
<!-- HEADER -->

<!-- SIDEBAR -->
<c:import url="components/sidebar.jsp"></c:import>
<!-- /SIDEBAR -->

  <main id="main" class="main">

    <div class="pagetitle">
      <h1>Thông tin cá nhân</h1>
    </div><!-- End Page Title -->

    <section class="section profile">
      <div class="row">
        <div class="col-xl-4">


		<c:set var="admin_acc" value="${sessionScope.admin_acc }"/>
		

          <div class="card">
            <div class="card-body profile-card pt-4 d-flex flex-column align-items-center">

              <i class="bi bi-person" style="font-size:30px"></i>
              <h2><c:out value="${admin_acc.admin.firstName }"/> <c:out value="${admin_acc.admin.lastName }"/></h2>
              <h3>Quản lý</h3>
              <div class="social-links mt-2">
                <a href="#" class="twitter"><i class="bi bi-twitter"></i></a>
                <a href="#" class="facebook"><i class="bi bi-facebook"></i></a>
                <a href="#" class="instagram"><i class="bi bi-instagram"></i></a>
                <a href="#" class="linkedin"><i class="bi bi-linkedin"></i></a>
              </div>
            </div>
          </div>

        </div>

        <div class="col-xl-8">

          <div class="card">
            <div class="card-body pt-3">
              <!-- Bordered Tabs -->
              <ul class="nav nav-tabs nav-tabs-bordered">

                <li class="nav-item">
                  <button class="nav-link active" data-bs-toggle="tab" data-bs-target="#profile-overview">Tổng quan</button>
                </li>

                <li class="nav-item">
                  <button class="nav-link" data-bs-toggle="tab" data-bs-target="#profile-edit">Chỉnh sửa thông tin</button>
                </li>

                <li class="nav-item">
                  <button class="nav-link" data-bs-toggle="tab" data-bs-target="#profile-change-password">Đổi mật khẩu</button>
                </li>

              </ul>
              <div class="tab-content pt-2">
              
				<c:set var="message" value="${requestScope.message }"/>
					<c:if test="${message != null }" >
						<h3 style="color:red"><c:out value="${message }"/></h3>
					</c:if>
					
                <div class="tab-pane fade show active profile-overview" id="profile-overview">
                  <h5 class="card-title">Tổng quan</h5>
                  <p class="small fst-italic">Hello.</p>

                  <h5 class="card-title">Thông tin cá nhân</h5>

                  <div class="row">
                    <div class="col-lg-3 col-md-4 label ">Họ và tên</div>
                    <div class="col-lg-9 col-md-8"><c:out value="${admin_acc.admin.firstName }"/> <c:out value="${admin_acc.admin.lastName }"/></div>
                  </div>

                  <div class="row">
                    <div class="col-lg-3 col-md-4 label">Địa chỉ</div>
                    <div class="col-lg-9 col-md-8"><c:out value="${admin_acc.admin.address }"/></div>
                  </div>

                  <div class="row">
                    <div class="col-lg-3 col-md-4 label">Số điện thoại</div>
                    <div class="col-lg-9 col-md-8"><c:out value="${admin_acc.admin.phone }"/></div>
                  </div>

                  <div class="row">
                    <div class="col-lg-3 col-md-4 label">Email</div>
                    <div class="col-lg-9 col-md-8"><c:out value="${admin_acc.admin.email }"/></div>
                  </div>
                </div>

                <div class="tab-pane fade profile-edit pt-3" id="profile-edit">

                  <!-- Profile Edit Form -->
                  <form action="change_profile" method="post">
					
					
					
                    <div class="row mb-3">
                      <label for="fullName" class="col-md-4 col-lg-3 col-form-label">Họ</label>
                      <div class="col-md-8 col-lg-9">
                        <input name="firstName" type="text" class="form-control" value="<c:out value="${admin_acc.admin.firstName }"/>">
                      </div>
                    </div>

                    <div class="row mb-3">
                      <label for="fullName" class="col-md-4 col-lg-3 col-form-label">Tên</label>
                      <div class="col-md-8 col-lg-9">
                        <input name="lastName" type="text" class="form-control" value="<c:out value="${admin_acc.admin.lastName }"/>">
                      </div>
                    </div>

                    <div class="row mb-3">
                      <label for="Country" class="col-md-4 col-lg-3 col-form-label">Email</label>
                      <div class="col-md-8 col-lg-9">
                        <input name="email" type="text" class="form-control" value="<c:out value="${admin_acc.admin.email }"/>" disabled>
                      </div>
                    </div>
                    <div class="row mb-3">
                      <label for="company" class="col-md-4 col-lg-3 col-form-label">Địa chỉ</label>
                      <div class="col-md-8 col-lg-9">
                        <input name="address" type="text" class="form-control" value="<c:out value="${admin_acc.admin.address }"/>">
                      </div>
                    </div>

                    <div class="row mb-3">
                      <label for="Job" class="col-md-4 col-lg-3 col-form-label">Số điện thoại</label>
                      <div class="col-md-8 col-lg-9">
                        <input name="phone" type="text" class="form-control" value="<c:out value="${admin_acc.admin.phone }"/>">
                      </div>
                    </div>


                    <div class="text-center">
                      <button type="submit" class="btn btn-primary">Lưu thay đổi</button>
                    </div>
                  </form><!-- End Profile Edit Form -->

                </div>


                <div class="tab-pane fade pt-3" id="profile-change-password">
                  <!-- Change Password Form -->
                  <form action="change_password" method="post">

                    <div class="row mb-3">
                      <label for="currentPassword" class="col-md-4 col-lg-3 col-form-label">Mật khẩu hiện tại</label>
                      <div class="col-md-8 col-lg-9">
                        <input name="currentPassword" type="password" class="form-control">
                      </div>
                    </div>

                    <div class="row mb-3">
                      <label for="newPassword" class="col-md-4 col-lg-3 col-form-label">Mật khẩu mới</label>
                      <div class="col-md-8 col-lg-9">
                        <input name="newPassword" type="password" class="form-control" id="newPassword">
                      </div>
                    </div>

                    <div class="row mb-3">
                      <label for="renewPassword" class="col-md-4 col-lg-3 col-form-label">Nhập lại mật khẩu mới</label>
                      <div class="col-md-8 col-lg-9">
                        <input name="renewPassword" type="password" class="form-control" id="renewPassword" oninput="checkPassword()">
                      </div>
                    </div>
					
					<p id="errorMessage" style="color:red"></p>
					
					<script>
				        function checkPassword() {
				            var newPassword = document.getElementById("newPassword").value;
				            var renewPassword = document.getElementById("renewPassword").value;
				
				            var errorMessageElement = document.getElementById("errorMessage");
							var submitButton = document.getElementById("changePassButton");
				            if (newPassword === renewPassword && renewPassword.textContent !== "") {
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
					
                    <div class="text-center">
                      <button type="submit" class="btn btn-primary" id="changePassButton" disabled>Thay đổi mật khẩu</button>
                    </div>
                  </form><!-- End Change Password Form -->

                </div>

              </div><!-- End Bordered Tabs -->

            </div>
          </div>

        </div>
      </div>
    </section>

  </main><!-- End #main -->

<!-- FOOTER -->
<c:import url="components/footer.jsp"></c:import>
<!-- /FOOTER -->