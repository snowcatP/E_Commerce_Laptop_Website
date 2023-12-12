<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<c:import url="web_components/head.jsp"></c:import>
<c:import url="web_components/header.jsp"></c:import>

<body>
        <div id="wrapper">
            <div class="container">
                <div class="row justify-content-around">
                    <form action="" class="col-lg-5 bg-light m-auto rounded-top rounded-bottom">
                        <h1 class="text-center h3 py-3">Đặt lại mật khẩu</h1>
                        <div class="input-group mb-3">
                            <span class="input-group-text"><i class="fa fa-user"></i></span>
                            <input type="text" name="email" id="email" class="form-control" placeholder="Email">
                        </div>
                        <div class="d-grid">
                            <input type="submit" value="Gửi mật khẩu đến email của bạn" class="btn-primary btn btn-block">
                            <p class="text-center">
                                
                            </p>
                        </div>
                        <p class="text-center"> <a href="login.jsp">Đăng nhập</a>
                        </p>
                    </form>
                    
                </div>
            </div>
        </div>

<c:import url="web_components/footer.jsp"></c:import>