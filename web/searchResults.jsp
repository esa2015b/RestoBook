
<%@page import="java.util.*"%>
<%@page import="domain.*"%>
<%@include file="_header.jsp" %>

<%@include file="_navBar.jsp" %>

			<%! List<LightRestaurant> restaurants; %>
                        
                        <% restaurants = (List<LightRestaurant>) request.getAttribute("restaurants"); %>
                        
                        <% for (LightRestaurant restaurant: restaurants) { %>
                            <a href="<%= request.getContextPath()%>/RestoWeb?action=displayResto&id=<%= restaurant.getId()%>" class="Index">
                                 <div class="Lign">
                                    <div class="PictureResults">
                                        <img class="Index" title="<%= restaurant.getName()%>" src="pictures/default.jpg">
                                    </div>
                                    <div class="TechResults">
                                        <b><%= restaurant.getName()%></b>
                                        <ul>
                                            <li><%= restaurant.getFoodTypeName()%></li>
                                            <li><%= restaurant.getCity() %></li>
                                            <li><%= restaurant.getDescription()%></li>
                                        </ul>
                                    </div>
                                </div>
                            </a>
			
                        <% } %>
			
<%@include file="_footer.jsp" %>
