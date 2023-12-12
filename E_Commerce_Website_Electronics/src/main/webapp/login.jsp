<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="web_components/head.jsp"></c:import>

<c:import url="web_components/header.jsp"></c:import>		
		
        <div id="wrapper">
            <div class="container">
                <c:if test="${user.firstName != null and user.lastName != null}">
                  	<h3 class="row justify-content-center">Cảm ơn bạn đã đăng ký,  <span style="color:white">.</span>
                  		<span style="color:red"><c:out value="${user.firstName}"/> <c:out value="${user.lastName}"/></span>.
                  	</h3>
               	</c:if>
				
				<c:set var="message" value="${requestScope.message }"/>
				
				<c:if test="${message != null}">
					<h4 style="color:red; text-align:center"><c:out value="${message }"/></h4>
				
				</c:if>
				<c:set var="cookie" value="${pageContext.request.cookies}"/>
				
                <div class="row justify-content-around">
                    <form action="login_account" class="col-lg-5 bg-light m-auto rounded-top rounded-bottom" method = "post">
                        <h1 class="text-center h3 py-3">Đăng nhập</h1>
                        <input type="hidden" name="action" value="login">
                        <div class="input-group mb-3">
                            <span><i class="fa fa-user"></i> Tài khoản</span>
                            <input type="text" name="username" class="form-control" placeholder="Nhập tài khoản" value="${cookie.userEmailCookie.value }" required>
                        </div>
                        <div class="input-group mb-3">
                            <span><i class="fa fa-lock"></i> Mật khẩu</span>
                            <input type="password" name="password" class="form-control" placeholder="Nhập mật khẩu" value="${cookie.userPwCookie.value }" required>
                        </div>
                        
                        <div class="py-3">
	                        <h5><input type="checkbox" name="remember" ${(cookie.userEmailCookie != null ? 'checked':'')}>Nhớ thông tin đăng nhập.</h5>
                        </div>
                        
                        <c:if test="${loginMessage != null}">
                        	<h5><span style="color:red"><c:out value="${loginMessage}"/></span></h5>
                        </c:if>
                        
                        <div class="d-grid">
                            <input type="submit" value="Đăng nhập" class="btn-primary btn btn-block">
                            <p class="text-center">
                                <a href="forgot_password.jsp">Quên mật khẩu?</a>
                            </p>
                        </div>
                    </form>
                    
                    <form action ="signup_account" class ="col-lg-5 bg-light m-auto rounded-top rounded-bottom" method ="post">
                        <h1 class="text-center h3 py-3">Tạo tài khoản mới</h1>
                        <input type="hidden" name="action" value="add">
                        <div class="input-group mb-3">
                            <span><i class="fa fa-user"></i> Họ</span>
                            <input type="text" name="firstnameCreate" class="form-control" required>
                        </div>
                        <div class="input-group mb-3">
                            <span><i class="fa fa-user"></i> Tên</span>
                            <input type="text" name="lastnameCreate" class="form-control" required>
                        </div>
                        <div class="input-group mb-3">
                            <span><i class="fa fa-envelope"></i> Email/ Tài khoản</span>
                            <input type="text" name="emailCreate" class="form-control" required>
                        </div>
                        <div class="input-group mb-3">
                            <span><i class="fa fa-lock"></i> Mật khẩu</span>
                            <input type="password" name="passwordCreate" class="form-control" required>
                        </div>
                        <div class="input-group mb-3">
                            <span><i class="fa fa-location-dot"></i> Địa chỉ</span>
                            <input type="text" name="addressCreate" class="form-control" required>
                        </div>
                        <div class="input-group mb-3">
                            <span><i class="fa fa-phone"></i> Số điện thoại</span>
                            <input type="text" name="phoneCreate" class="form-control" required>
                        </div>
                        
                        <c:if test="${messageRegister != null }">
		               		<h5 class="row justify-content-center"><span style="color:red"><c:out value="${messageRegister}"/></span></h5>
		               	</c:if>
                        
                        <div class="d-grid">
                            <input type="submit" value="Đăng ký" class="btn-primary btn btn-block">
                            <p class="text-center text-muted mt-2">
                                Khi bạn nhấp vào nút đăng ký bạn đã đồng ý các
                                <a href="#">quyền</a> và <a href="#">chính sách</a>  của chúng tôi.
                            </p>
                            
                        </div>
                    </form>
                </div>
            </div>
        </div>
        
<c:import url="web_components/footer.jsp"></c:import>