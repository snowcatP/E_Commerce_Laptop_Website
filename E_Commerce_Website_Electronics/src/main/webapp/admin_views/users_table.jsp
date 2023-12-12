<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="components/head.jsp"></c:import>

<c:import url="components/header.jsp"></c:import>

<c:import url="components/sidebar.jsp"></c:import>

<main id="main" class="main">

	<div class="pagetitle">
		<h1>Quản lý khách hàng</h1>
	</div>
	<!-- End Page Title -->

	<section class="section">
		<div class="row">
			<div class="col-lg-1"></div>
			<div class="col-lg-10">

				<div class="card">
					<div class="card-body">
						<h5 class="card-title">Bảng khách hàng</h5>
						<!-- Table with stripped rows -->

						<c:set var="users" value="${requestScope.users }" />
						
						<c:if test="${users == null}">
							<a href="get_users_data" class="btn btn-primary col-2"
								style="margin-bottom: 2em">Lấy dữ liệu</a>
						</c:if>
						<c:if test="${requestScope.message != null}">
							<p style='color:red'><c:out value="${requestScope.message }"/></p>
						</c:if>

						<form action="get_users_data" method="get">
							<table id="example" class="table table-striped">
								<thead>
									<tr>
										<th><b>Họ và tên</b></th>
										<th>Email</th>
										<th>Số điện thoại</th>
										<th>Địa chỉ</th>
										<th></th>
										<th></th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="user" items="${users }">
											<tr>
												<td><c:out value="${user.firstName }" /> <c:out value="${user.lastName }" /></td>
												<td><c:out value="${user.email }" /></td>
												<td><c:out value="${user.phone }" /></td>
												<td><c:out value="${user.address }" /></td>
												
												<td><a class="btn btn-outline-dark btn-sm"
													href="modify_user?action=modify&amp;email=${user.email }">Sửa</a></td>
												<td><a class="btn btn-outline-dark btn-sm"
													href="modify_user?action=delete&amp;email=${user.email }">Xoá</a></td>
											</tr>
										</c:forEach>

								</tbody>
							</table>
							<!-- End Table with stripped rows -->
						</form>
					</div>
				</div>

			</div>
			<div class="col-lg-1"></div>
		</div>
	</section>

</main>
<!-- End #main -->

<c:import url="components/footer.jsp"></c:import>