<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
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

				<div class="col-md-9"
					style="min-height: 75vh; background-color: white">
					<div class="card-body" style="color: black;margin-top:1em">
						<div class="table-responsive">
							<table class="table table-bordered m-0">
								<thead>
									<tr>
										<th class="text-center py-3 px-4" style="width: 100px;">Mã đơn</th>
										<th class="text-center py-3 px-4" style="min-width: 250px;">Chi tiết</th>
										<th class="text-center py-3 px-4" style="width: 150px;">Đơn giá</th>
										<th class="text-center py-3 px-4" style="width: 120px;">Ngày mua</th>
										<th class="text-center py-3 px-4" style="width: 120px;">Trạng thái</th>
									</tr>
								</thead>
								<tbody>
								
								<c:set var="invoices" value="${requestScope.invoices }"/>
								<c:forEach var="invoice" items="${ invoices}">
										<tr>
											<td class="text-center font-weight-semibold align-middle p-4"><c:out value="${invoice.invoiceId }"/></td>
											<td class="p-4">
												<div class="media align-items-center">
												
												<c:set var="lineProducts" value="${invoice.lineProducts }"/>
													<c:forEach var="lineProduct" items="${lineProducts}">
													
														<div class="row">
															<div class="col-md-8">
																<p><c:out value="${lineProduct.product.nameProd }"/></p>
															</div>
															<div class="media-body">
																<p>x<c:out value="${lineProduct.quantity}"/></p>
															</div>
														</div>
													</c:forEach>
												</div>
											</td>
											<td class="text-center font-weight-semibold align-middle p-4"><c:out
													value="${invoice.totalPrice }" /> VND</td>
											<td class="align-midle p-4 align-middle">
												<fmt:formatDate type = "date" value = "${invoice.invoiceDate}" />
											</td>
											<td class="text-center font-weight-semibold align-middle p-4">
												<c:if test="${invoice.status == true }">
													<c:if test="${invoice.shipped == false}">
														<p>Đang vận chuyển</p>
													</c:if>
												</c:if>
												<c:if test="${invoice.shipped == true and invoice.status == false}">
														<p>Hoàn thành</p>
												</c:if>
												
												<c:if test="${invoice.status == false and invoice.shipped == false}">
													<p>Đang xử lý</p>
												</c:if>
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</main><!-- End #main -->
<c:import url="web_components/footer.jsp"></c:import>