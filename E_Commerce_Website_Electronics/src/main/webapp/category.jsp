<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- Header -->
<c:import url="web_components/head.jsp"></c:import>
<!-- /Header -->

<c:import url="web_components/header.jsp"></c:import>

<!-- SECTION -->
			<c:import url="web_components/navigation.jsp"></c:import>
		<div class="section">
			<!-- container -->
			
			
			<div class="container">
				<!-- row -->
				<div class="row">
					
					<!-- SIDEBAR -->
					<c:import url="web_components/sidebar.jsp"></c:import>
					<!-- /SIDEBAR -->
					
					
					<!-- STORE -->
					<!-- STORE -->
					<div id="store" class="col-md-9">
						<!-- store top filter -->
						<div class="store-filter clearfix">
							<div class="store-sort">
								<label>
									Sort By:
									<!--  <select class="input-select">
										<option value="0"><a href="seachProductByDesc">Giá giảm dần</a></option>
										<option value="1">Giá tăng dần</option> 
									
									</select>
									-->
									<select class="input-select" onchange="window.location.href=this.value;">
									    <option value="">Thứ tự</option>
									    <option value="searchProductByAsc">Giá tăng dần</option>
									    <option value="searchProductByDesc">Giá giảm dần</option>
									</select>
								</label>

							</div>
							<ul class="store-grid">
								<li class="active"><i class="fa fa-th"></i></li>
								<li><a href="#"><i class="fa fa-th-list"></i></a></li>
							</ul>
						</div>
						<!-- /store top filter -->

						<!-- store products -->
						
							<div class="row">
							<c:forEach items="${allProduct}" var="p">
								<!-- product -->
								<div class="col-md-4 col-xs-6">
									<div class="product">
										<div class="product-img">
											<img src="https://laptopwebsite.s3.ap-southeast-2.amazonaws.com/<c:out value="${p.image1}"/>" alt="" style="width: 100%; height: 100%;">
										</div>
										<div class="product-body">
											<p class="product-category">${p.brand}</p>
											<h3 class="product-name"><a href="view_detail?pid=${p.productId}">${p.nameProd}</a></h3>
											<h4 class="product-price">${p.price}</h4>
										</div>
									</div>
								</div>
								</c:forEach>
								</div>
							
							<!-- /product -->

							
					
						<!-- /store products -->

						<!-- store bottom filter -->
						<div class="store-filter clearfix">
							<span class="store-qty">Showing 20-100 products</span>
							<ul class="store-pagination">
								
								
								<c:if test="${tag != 1}">
                    				<li class="active"><a href="store_view?index=${tag-1 }"></a></li>
                    			</c:if> 
                    			<c:forEach begin="1" end="${endPage }" var="i">
                    				<li class="active"><a href="store_view?index=${i }">${i }</a></li>
                    			</c:forEach>
                				<c:if test="${tag != endPage}">
                    				<li class="active"><a href="store_view?index=${tag+1 }"><i class="fa fa-angle-right"></i></a></li>
                     			</c:if> 
							</ul>
						</div>
						<!-- /store bottom filter -->
						</div>
					<!-- /STORE -->
				</div>
				<!-- /row -->
			</div>
			<!-- /container -->
		</div>
		<!-- /SECTION -->
		
		
<script>

function setInitialCheckboxes() {
    var checkboxes = document.querySelectorAll('input[type="checkbox"]');
    
    // Example: Set the checkbox with name="HP" as checked
    checkboxes.forEach(function (checkbox) {
        if (checkbox.name === 'HP') {
            checkbox.checked = true;
 
        }
        if (checkbox.name === 'ASUS') {
            checkbox.checked = true;

        }
        if (checkbox.name === 'LENOVO') {
            checkbox.checked = true;
       
        }
        if (checkbox.name === 'DELL') {
            checkbox.checked = true;

        }
        if (checkbox.name === 'MSI') {
            checkbox.checked = true;
 
        }
        if (checkbox.name === 'Macbook') {
            checkbox.checked = true;

        }
        if (checkbox.name === 'Gigabyte') {
            checkbox.checked = true;
        }
        // You can add similar conditions for other checkboxes
        
    });
}


	
	
    function searchByBrand() {
    	
        // Get all checkboxes
        var checkboxes = document.querySelectorAll('input[type="checkbox"]');
        
        // Initialize an empty array to store selected brands
        var selectedBrands = [];

        // Loop through checkboxes to find selected ones
        checkboxes.forEach(function (checkbox) {
            if (checkbox.checked) {
                // Add selected brand to the array
                selectedBrands.push(checkbox.name + "=" + checkbox.value);
            }
        });

        // Construct the search URL with selected brands
        var searchURL = "searchProductByBrand";
        if (selectedBrands.length > 0) {
            searchURL += "?" + selectedBrands.join("&");
        }
        

        // Redirect to the constructed search URL
        window.location.href = searchURL;
    }
    
	function searchByCategory() {
	    	
	        // Get all checkboxes
	        var checkboxes = document.querySelectorAll('input[type="checkbox"]');
	        
	        // Initialize an empty array to store selected brands
	        var selectedCategorys = [];
	
	        // Loop through checkboxes to find selected ones
	        checkboxes.forEach(function (checkbox) {
	            if (checkbox.checked) {
	                // Add selected brand to the array
	                selectedCategorys.push(checkbox.name + "=" + checkbox.value);
	            }
	        });
	
	        // Construct the search URL with selected brands
	        var searchURL = "searchProductByCategory";
	        if (selectedCategorys.length > 0) {
	            searchURL += "?" + selectedCategorys.join("&");
	        }
	        
	
	        // Redirect to the constructed search URL
	        window.location.href = searchURL;
	    }
	
	function searchByRangePrice() {
	    // Get the input values for price_min and price_max
	    var price_min = document.getElementById('price-min').value;
	    var price_max = document.getElementById('price-max').value;

	    // Add price_min and price_max to the search URL
	    var searchURL ="searchProductByRangePrice";
	    searchURL += "?PRICE_MIN=" + price_min + "&PRICE_MAX=" + price_max;

	    // Redirect to the constructed search URL
	    window.location.href = searchURL;
	}
</script>


<c:import url="web_components/footer.jsp"></c:import>
<!-- /Body -->