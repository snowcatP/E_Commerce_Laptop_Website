<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="components/head.jsp"></c:import>

<c:import url="components/header.jsp"></c:import>

<c:import url="components/sidebar.jsp"></c:import>

<main id="main" class="main">

	<div class="pagetitle">
		<h1>Quản lý nhân viên</h1>
	</div>
	<!-- End Page Title -->

	<section class="section">
		<div class="row">
			<div class="col-lg-1"></div>
			<div class="col-lg-10">

				<div class="card">
					<div class="card-body">
						<h5 class="card-title">Bảng nhân viên</h5>
						
						<c:set var="admins" value="${requestScope.admins }" />
						
						<c:if test="${admins == null}">
							<a href="get_employees_data" class="btn btn-primary col-2"
								style="margin-bottom: 2em">Lấy dữ liệu</a>
						</c:if>
						<c:if test="${requestScope.message != null}">
							<p style='color:red'><c:out value="${requestScope.message }"/></p>
						</c:if>

						<!-- Table with stripped rows -->
						<form action="get_employees_data" method="get">

							<c:if test="${admins != null}">

								<table id="example" class="table table-striped ">
									<thead>
										<tr>
											<th><b>Họ và tên</b></th>
											<th>Email</th>
											<th>Số điện thoại</th>
											<th>Địa chỉ</th>
											<th>Lương</th>
											<th></th>
											<th></th>
										</tr>
									</thead>
									<tbody>

										<c:forEach var="admin" items="${admins }">

											<tr>
												<td><c:out value="${admin.firstName }" /> 
													<c:out value="${admin.lastName }" /></td>
												<td><c:out value="${admin.email }" /></td>
												<td><c:out value="${admin.phone }" /></td>
												<td><c:out value="${admin.address }" /></td>
												<td><c:out value="${admin.salary }" /></td>
												
												<td><a class="btn btn-outline-dark btn-sm"
													href="modify_employee?action=modify&amp;email=${admin.email }">Sửa</a></td>
												<td><a class="btn btn-outline-dark btn-sm"
													href="modify_employee?action=delete&amp;email=${admin.email }">Xoá</a></td>
											</tr>
										</c:forEach>

									</tbody>
								</table>
								<!-- End Table with stripped rows -->

							</c:if>
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