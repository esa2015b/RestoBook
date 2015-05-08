<%@page import="domain.*"%>

<%@include file="_header.jsp" %>

						<li><a href="<%= request.getContextPath()%>/Home">Home</a></li>
						<li class="active"><a href="<%= request.getContextPath()%>/RestoWeb?action=displayResto">I Feel Lucky</a></li>
						
<%@include file="_navBar.jsp" %>

                                <%! DisplayRestaurant restaurant; %>
                                <% restaurant = (DisplayRestaurant) request.getAttribute("restaurant"); %>
                                
				<!-- Restaurant picture -->
				<div class="Picture">
					<img class="Detail"  title="<%= restaurant.getName()%>" src="pictures/default.jpg"><br>
				<a href="#">Map Link</a>
				</div>
				<!-- End Restaurant picture -->
				<!-- Restaurant Spec -->
				<div class="Tech">
				<div class="Lign">
                                    <%= restaurant.getName()%>
				</div>
				<div class="Lign">
                                    <%= restaurant.getFoodTypeName() %>
				</div>
				<div class="Lign">
                                    <%= restaurant.getDescription()%>
				</div>
				<div class="Lign">
                                    Available seats : <%= restaurant.getPlaceQuantity()%>
				</div>
				<div class="Lign">
                                    Contact :
                                    <ul>
					<li><%= restaurant.getMail()%></li>
					<li>*Address*</li>
					<li><%= restaurant.getPhone()%></li>
                                    </ul>
				</div>
				<div class="Space">
                                    Closed : <%= restaurant.getDayOfClosing()%>
				</div>
				
                                <Form action='<%= request.getContextPath()%>/Display' method='POST'>
                                    <div style="float: right;">
                                        <button type="submit" class="btn btn-default">
                                            <span class="glyphicon glyphicon-book"></span>
                                            <span>Book</span>
                                        </button>
                                        <input type="hidden" name="action" value="newReservation"/>
                                    </div>
                                </form>
				</div>
				<!-- End Restaurant Spec -->
				
<%@include file="_footer.jsp" %>