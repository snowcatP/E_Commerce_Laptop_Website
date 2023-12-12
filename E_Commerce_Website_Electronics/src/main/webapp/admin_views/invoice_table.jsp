<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="components/head.jsp"></c:import>

<c:import url="components/header.jsp"></c:import>

<c:import url="components/sidebar.jsp"></c:import>

<main id="main" class="main">

	<div class="pagetitle">
		<h1>Quản lý hoá đơn</h1>
	</div>
	<!-- End Page Title -->

	<section class="section">
		<div class="row">
			<div class="col-lg-1"></div>
			<div class="col-lg-10">

				<div class="card">
					<div class="card-body">
						<h5 class="card-title">Danh sách hoá đơn</h5>
						
						<c:set var="invoices" value="${requestScope.invoices }" />
						
						<!-- Table with stripped rows -->
								<table id="example" class="table table-striped ">
									<thead>
										<tr>
											<th><b>ID</b></th>
											<th>Tài khoản</th>
											<th>Tổng hoá đơn</th>
											<th>Ngày xuất</th>
											<th>Trạng thái</th>
											<th></th>
											<th></th>
										</tr>
									</thead>
									<tbody>
									
									<c:forEach var="invoice" items="${invoices }">
										<tr>
											<th scope="row"><c:out value="${invoice.invoiceId}" /></th>
											<td><c:out value="${invoice.user.email}" /></td>
											<td><c:out value="${invoice.totalPrice}" /> VND</td>
											<td><fmt:formatDate type = "date" value = "${invoice.invoiceDate}" /></td>
											<form action="update_invoice" method="post">
											
												<input type="hidden" name="invoiceId" value="<c:out value="${invoice.invoiceId}" />" />
												<td>
													<select class="form-select" aria-label="Default select example" name="status">
														<c:if test="${invoice.status == true }">
															<c:if test="${invoice.shipped == false}">
																<option value="Đang vận chuyển" selected>Đang vận chuyển</option>
																<option value="Đang sử lý">Đang sử lý</option>
																<option value="Hoàn thành">Hoàn thành</option>
															</c:if>
															
															
														</c:if>
														<c:if test="${invoice.shipped == true and invoice.status == false}">
																<option value="Hoàn thành" selected>Hoàn thành</option>
																<option value="Đang sử lý">Đang sử lý</option>
								                        		<option value="Đang vận chuyển">Đang vận chuyển</option>
															</c:if>
														
														<c:if test="${invoice.status == false and invoice.shipped == false}">
															<option value="Đang sử lý" selected>Đang sử lý</option>
															<option value="Đang vận chuyển">Đang vận chuyển</option>
								                        	<option value="Hoàn thành">Hoàn thành</option>
														</c:if>
								                      </select>
												</td>
												<td>
														<input type="submit" class="btn btn-outline-dark btn-sm" value="Cập nhật" />
												</td>
											</form>
											<td><a href="loadInvoice?invoiceId=<c:out value="${invoice.invoiceId}" />" class="btn btn-outline-dark btn-sm">Chi tiết</a></td>
										</tr>
									</c:forEach>
									
									</tbody>
								</table>
								<!-- End Table with stripped rows -->
					</div>
				</div>

			</div>
			<div class="col-lg-1"></div>
		</div>
	</section>

</main>
<!-- End #main -->

<c:import url="components/footer.jsp"></c:import>