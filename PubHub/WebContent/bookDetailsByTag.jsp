	<!-- Header -->
	<jsp:include page="header.jsp" />
	
	<!-- JSTL includes -->
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
	
<!-- 	Just some stuff you need -->

	<header>
	  <div class="container">
		
	<c:choose>
	<c:when test="${not empty message }">
	  <p class="alert ${messageClass}">${message }</p>
	<%
	  session.setAttribute("message", null);
	  session.setAttribute("messageClass", null);
	%>
	</c:when>
	</c:choose>
	
		<h1>PUBHUB <small>Search for Books by Tag</small></h1>
		<hr class="book-primary">
		
		
	  </div>
	</header>

	<section style="padding-bottom:0;">
	<table class="table table-striped table-hover table-responsive pubhub-datatable">
			<thead>
				<tr>
					<td style="display:flex; justify-content:space-between;">
					<div>Book</div>
					<div>Tag</div>
					</td>			
				</tr>
			</thead>
			<tbody>
				<c:forEach var="e" items="${books}">
				
					<tr>
						<td style="display:flex; justify-content:space-between;">
							<div>
								<c:out value="${e.key}" />
							</div>
							<div>	
								<c:out value="${e.value}" />
							</div>
						</td>
					</tr>
				</c:forEach>				
			</tbody>
		</table>
	</section>
	
	<!-- Footer -->
	<jsp:include page="footer.jsp" />
