<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="web_components/head.jsp"></c:import>
<c:import url="web_components/header.jsp"></c:import>

<main id="main" class="main"  style="background-color:#F9F9F9">

	<div class="section">
		<div class="container">
			<div class="row">
				

				<div class="col-md-2"></div>

				<div class="col-md-8" style="min-height:65vh; background-color:white">
					
					<div class="" style="margin:2em">
						<h3>Cảm ơn bạn đã mua hàng của chúng tôi!</h3>
						<p>Đơn hàng sẽ được giao đến bạn sớm nhất.</p>
					
						<hr>
					</div>
					<div class="" style="padding-top: 1em">
						<div class="col-md-2"></div>
						<div class="col-md-8">
							<a href="home" class="btn btn-lg btn-danger md-btn-flat"
								style="margin-right: 2em">Tiếp tục mua hàng</a> 
							<a href="user_detail?action=user_detail"
								class="btn btn-lg btn-danger">Trang cá nhân</a>
						</div>
					</div>

				</div>
				
			</div>
		</div>
	</div>
</main>
<!-- End #main -->
<c:import url="web_components/footer.jsp"></c:import>