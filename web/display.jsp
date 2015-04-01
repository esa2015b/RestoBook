<%@page import="domain.*"%>

<%@include file="_header.jsp" %>

						<li><a href="index.jsp">Home</a></li>
						<li class="active"><a href="<%= request.getContextPath()%>/RestoWeb?action=displayResto">I Feel Lucky</a></li>
						
<%@include file="_navBar.jsp" %>

                                <%! Restaurant restaurant; %>
                                <% restaurant = (Restaurant) request.getAttribute("restaurant"); %>
                                
				<!-- Restaurant picture -->
				<div class="Picture">
					<img class="Detail"  title="Restaurant Name" src="pictures/default.jpg"><br>
				<a href="#">Map Link</a>
				</div>
				<!-- End Restaurant picture -->
				<!-- Restaurant Spec -->
				<div class="Tech">
				<div class="Lign">
                                    <%= restaurant.getName()%>
				</div>
				<div class="Lign">
                                    *Food Type*
				</div>
				<div class="Lign">
                                    <%= restaurant.getDescription()%>
				</div>
				<div class="Lign">
                                    <%= restaurant.getPlaceQuantity()%>
				</div>
				<div class="Lign">
                                    Contact
                                    <ul>
					<li><%= restaurant.getMail()%></li>
					<li>*Address*</li>
					<li><%= restaurant.getPhone()%></li>
                                    </ul>
				</div>
				<div class="Space">
                                    Closed : <%= restaurant.getDayOfClosing()%>
				</div>
				
				<div style="float: right;">
                                    <button type="submit" class="btn btn-default">Book</button>
				</div>
				</div>
				<!-- End Restaurant Spec -->
				
<%@include file="_footer.jsp" %>