
<%@page import="domain.LightRestaurant"%>
<%@page import="java.util.List"%>
<%@include file="_header.jsp" %>

<%-- We write these menu link here so we can change active page --%>

<!--<li class="active">
    <a href="<%= request.getContextPath()%>/Home">
        <span class="glyphicon glyphicon-home"></span>
        Home
    </a>
</li>
<li>
    <a href="<%= request.getContextPath()%>/RestoWeb?action=displayResto">
        <span class="glyphicon glyphicon-question-sign"></span>
        I Feel Lucky
    </a>
</li>-->
						
<%@include file="_navBar.jsp" %>

                                    <!-- Carousel -->
					<div id="myCarousel" class="carousel slide" data-ride="carousel">
						<ol class="carousel-indicators">
							<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
							<li data-target="#myCarousel" data-slide-to="1"></li>
							<li data-target="#myCarousel" data-slide-to="2"></li>
						</ol>
						<!-- Slide Content -->
						<div class="carousel-inner" role="listbox">
                                                        <!-- First restaurant -->
							<div class="item active">
							
								<a href="<%= request.getContextPath()%>/RestoWeb?action=displayResto">
									<img src="pictures/default.jpg" style="margin: 0 auto;">
								</a>
								<div class="carousel-caption">
									<h4>Restaurant1 Name</h4>
									<p>Restaurant1 description</p>
								</div>
								
							</div>
                                                        <!-- Second restaurant -->
							<div class="item">
								
								<a href="<%= request.getContextPath()%>/RestoWeb?action=displayResto">
									<img src="pictures/default.jpg" style="margin: 0 auto;">
								</a>
								<div class="carousel-caption">
									<h4>Restaurant2 Name</h4>
									<p>Restaurant2 description</p>
								</div>
								
							</div>
                                                        <!-- Third restaurant -->
							<div class="item">
							
								<a href="<%= request.getContextPath()%>/RestoWeb?action=displayResto">
									<img src="pictures/default.jpg" style="margin: 0 auto;">
								</a>
								<div class="carousel-caption">
									<h4>Restaurant3 Name</h4>
									<p>Restaurant3 description</p>
								</div>
								
							</div>
						</div>
						<!-- End Slide Content -->
						<a class="carousel-control left" href="#myCarousel" data-slide="prev">&lsaquo;</a>
						<a class="carousel-control right" href="#myCarousel" data-slide="next">&rsaquo;</a>
					</div>
                                    <!-- End of carousel content -->
                                    
                                        <%! List<LightRestaurant> chinese; %>
                                        <%! List<LightRestaurant> french; %>
                                        <%! List<LightRestaurant> italian; %>
                                        <%! List<LightRestaurant> turkish; %>
        
                                        <% chinese = (List<LightRestaurant>) request.getAttribute("chineseRestaurants"); %>
                                        <% french = (List<LightRestaurant>) request.getAttribute("frenchRestaurants"); %>
                                        <% italian = (List<LightRestaurant>) request.getAttribute("italianRestaurants"); %>
                                        <% turkish = (List<LightRestaurant>) request.getAttribute("turkishRestaurants"); %>
                                    
					<div class="Category">
                                            <button class="btn btn-default form-inline pull-right" type="button" data-toggle="collapse" data-target="#chinesse" aria-expanded="true" aria-controls="chinesse">Hide</button>
                                            <h4 style="text-align: left;">Chinese</h4>
                                            <div class="collapse in" id="chinesse">
                                                <table>
                                                <% for(LightRestaurant ch : chinese){ %>
                                                    <td class="Cell">
                                                        <a href="<%= request.getContextPath()%>/RestoWeb?action=displayResto&id=<%= ch.getId() %>" class="Index">
                                                            <div>
                                                                <div class="PictureIndex">
                                                                    <img class="Index" src="<%= ch.getPictureLocation() %>" title="<%= ch.getName() %>">
                                                                </div>
                                                                <div class="Tech">
                                                                    <li><%= ch.getName() %></li>
                                                                    <li><%= ch.getDescription() %></li>
                                                                </div>
                                                            </div>
                                                        </a>
                                                    </td>
                                                <% } %>
                                                </table>
                                            </div>
					</div>
					<!-- -->
					<div class="Category">
                                            <button class="btn btn-default form-inline pull-right" type="button" data-toggle="collapse" data-target="#french" aria-expanded="true" aria-controls="french">Hide</button>
                                            <h4 style="text-align: left;">French</h4>
                                            <div class="collapse in" id="french">
                                                <table>
                                                <% for(LightRestaurant fr : french){ %>
                                                    <td class="Cell">
                                                        <a href="<%= request.getContextPath()%>/RestoWeb?action=displayResto&id=<%= fr.getId() %>" class="Index">
                                                            <div>
                                                                <div class="PictureIndex">
                                                                    <img class="Index" src="<%= fr.getPictureLocation() %>" title="<%= fr.getName() %>">
                                                                </div>
                                                                <div class="Tech">
                                                                    <li><%= fr.getName() %></li>
                                                                    <li><%= fr.getDescription() %></li>
                                                                </div>
                                                            </div>
                                                        </a>
                                                    </td>
                                                <% } %>
                                                </table>
                                            </div>
					</div>
					<!-- -->
					<div class="Category">
						<button class="btn btn-default form-inline pull-right" type="button" data-toggle="collapse" data-target="#italian" aria-expanded="true" aria-controls="italian">Hide</button>
						<h4 style="text-align: left;">Italian</h4>
						<div class="collapse in" id="italian">
                                                    <table>
                                                    <% for(LightRestaurant it : italian){ %>
                                                        <td class="Cell">
                                                            <a href="<%= request.getContextPath()%>/RestoWeb?action=displayResto&id=<%= it.getId() %>" class="Index">
                                                                <div>
                                                                    <div class="PictureIndex">
                                                                        <img class="Index" src="<%= it.getPictureLocation() %>" title="<%= it.getName() %>">
                                                                    </div>
                                                                    <div class="Tech">
                                                                        <li><%= it.getName() %></li>
                                                                        <li><%= it.getDescription() %></li>
                                                                    </div>
                                                                </div>
                                                            </a>
                                                        </td>
                                                    <% } %>
                                                    </table>
						</div>
					</div>
					<!-- -->
					<div class="Category">
                                            <button class="btn btn-default form-inline pull-right" type="button" data-toggle="collapse" data-target="#turkish" aria-expanded="true" aria-controls="japanesse">Hide</button>
                                            <h4 style="text-align: left;">Turkish</h4>
                                            <div class="collapse in" id="turkish">
                                                <table>
                                                    <% for(LightRestaurant tu : turkish){ %>
                                                        <td class="Cell">
                                                            <a href="<%= request.getContextPath()%>/RestoWeb?action=displayResto&id=<%= tu.getId() %>" class="Index">
                                                                <div>
                                                                    <div class="PictureIndex">
                                                                        <img class="Index" src="<%= tu.getPictureLocation() %>" title="<%= tu.getName() %>">
                                                                    </div>
                                                                    <div class="Tech">
                                                                        <li><%= tu.getName() %></li>
                                                                        <li><%= tu.getDescription() %></li>
                                                                    </div>
                                                                </div>
                                                            </a>
                                                        </td>
                                                    <% } %>
                                                </table>
                                            </div>
					</div>
		
		
<%@include file="_homeScript.jsp" %>
<%@include file="_footer.jsp" %>