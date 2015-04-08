
<%@page import="domain.*"%>
<%@include file="_header.jsp" %>

						<li><a href="index.jsp">Home</a></li>
						<li><a href="<%= request.getContextPath()%>/RestoWeb?action=displayResto">I Feel Lucky</a></li>

<%@include file="_navBar.jsp" %>

			<%! Restaurant[] restaurants; %>
                        
                        <% restaurants = (Restaurant[]) request.getAttribute("restaurants"); %>
                        
                        <% for (Restaurant restaurant: restaurants) { %>
                            <a href="<%= request.getContextPath()%>/RestoWeb?action=displayResto&id=<%= restaurant.getId()%>" class="Index">
                                 <div class="Lign">
                                    <div class="PictureResults">
                                        <img class="Index" title="<%= restaurant.getName()%>" src="pictures/default.jpg">
                                    </div>
                                    <div class="TechResults">
                                        <b><%= restaurant.getName()%></b>
                                        <ul>
                                            <li><%= restaurant.getFoodType().getName() %></li>
                                            <li>*City*</li>
                                            <li><%= restaurant.getDescription()%></li>
                                        </ul>
                                    </div>
                                </div>
                            </a>
			
                        <% } %>
			
<%@include file="_footer.jsp" %>
