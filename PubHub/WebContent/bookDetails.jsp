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
	
		<h1>PUBHUB <small>Book Details - ${book.isbn13 }</small></h1>
		<hr class="book-primary">
		
		<form action="UpdateBook" method="post" class="form-horizontal">
		  
		  <input type="hidden" class="form-control" id="isbn13" name="isbn13" required="required" value="${book.isbn13 }" />
		  
		  <div class="form-group">
		    <label for="title" class="col-sm-4 control-label">Title</label>
		    <div class="col-sm-5">
		      <input type="text" class="form-control" id="title" name="title" placeholder="Title" required="required" value="${book.title }" />
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="author" class="col-sm-4 control-label">Author</label>
		    <div class="col-sm-5">
		      <input type="text" class="form-control" id="author" name="author" placeholder="Author" required="required" value="${book.author }" />
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="price" class="col-sm-4 control-label">Price</label>
		    <div class="col-sm-5">
		      <input type="number" step="0.01" class="form-control" id="price" name="price" placeholder="Price" required="required" value="${book.price }" />
		    </div>
		  </div>
		  <div class="form-group">
		    <div class="col-sm-offset-4 col-sm-1">
		      <button type="submit" class="btn btn-info">Update</button>
		    </div>
		  </div>
		</form>
	  </div>
	</header>

	<section style="padding-bottom:0;">
	<table class="table table-striped table-hover table-responsive pubhub-datatable">
			<thead>
				<tr>
					<td style="display:flex; justify-content:space-between;">
					<div>Tag</div>
					<div>Delete Tag</div>
					</td>			
				</tr>
			</thead>
			<tbody>
				<c:forEach var="e" items="${tags}">
				
					<tr>
						
						<td><form action="DeleteTag" method="post" style="display:flex; justify-content:space-between;">
								<c:out value="${e.tag}" />
									<input type="hidden" name="isbn13" id="isbn13" value="${book.isbn13}">
									<input type="hidden" name="tag" id="tag" value="${e.tag}">
								
									<button type="submit" class="btn btn-primary">Delete</button>
							</form>
						</td>
					</tr>
				</c:forEach>				
			</tbody>
		</table>
	</section>
	
	<section style="padding:0">
		<h1 style="text-align:center"><small id="isbn13">Add New Tag - ${book.isbn13}</small></h1>
		<hr class="book-primary">
		<form action="AddTagRoute" method="post">
			<div style="display:flex; justify-content: center">
				<div class="form-group">
				    <div class="col-sm-5">
				      <input type="hidden" id="isbn13" name="isbn13" required="required" value="${book.isbn13 }" />
				      <input type="text" style="width:auto" class="form-control" id="tag" name="tag" value="${tag.tag }"
				      placeholder="Aenean lacinia bibendum nulla sed consectetur" required="required" />
				    </div>
				</div>
			  <div class="form-group">
			    <div class="col-sm-1">
			      <button type="submit" class="btn btn-info">Add</button>
			    </div>
			  </div>
			</div>
		</form>
	</section>

	<!-- Footer -->
	<jsp:include page="footer.jsp" />
