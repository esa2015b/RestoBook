<%@page import="domain.*"%>

<%@include file="_header.jsp" %>

						
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
                                        <b>Name</b> <%= restaurant.getName()%>
                                    </div>
                                    <div class="Lign">
                                        <b>Food Type</b> <%= restaurant.getFoodTypeName() %>
                                    </div>
                                    <div class="Lign">
                                        <b>Information</b><br /> <%= restaurant.getDescription()%>
                                    </div>
                                    <div class="Lign">
                                        <b>Available Seats</b> <%= restaurant.getPlaceQuantity()%>
                                    </div>
                                    <div class="Lign">
                                        <b>Contact</b>
                                        <ul>
                                            <li>Mail : 
                                                <a href="mailto:<%= restaurant.getMail()%>?Subject=Mail%20from%20Restobook" >
                                                    <%= restaurant.getMail() %>
                                                </a>
                                            </li>
                                            <li>Address : 
                                                <address><%= restaurant.getAddress().getStreet() %>, <%= restaurant.getAddress().getNumber() %><br />
                                                    <%= restaurant.getAddress().getZipCode() %> <%= restaurant.getAddress().getCity() %><br />
                                                    <%= restaurant.getAddress().getCountry() %>
                                                </address>
                                            </li>
                                            <li>Tel : <%= restaurant.getPhone()%></li>
                                        </ul>
                                    </div>
                                    <div class="Lign">
                                        <b>Opening hours</b>
                                        <ul>
                                            <% for(Service s : restaurant.getServices()){ %>
                                                <li>
                                                    <%= s.getDayOfWeek() %> :  <%= s.getTypeService() %> (<%= s.getBeginShift() %> - <%= s.getEndShift() %>)
                                                </li>
                                            <% } %>
                                        </ul>
                                    </div>
                                    <div class="Space">
                                        <b>Closed</b> <%= restaurant.getDayOfClosing()%>
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