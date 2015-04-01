
<%@include file="_header.jsp" %>

<%-- We write these menu link here so we can change active page --%>

						<li class="active"><a href="index.jsp">Home</a></li>
						<li><a href="<%= request.getContextPath()%>/RestoWeb?action=displayResto">I Feel Lucky</a></li>
						
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
					<div class="Category">
					
						<button class="btn btn-default form-inline pull-right" type="button" data-toggle="collapse" data-target="#chinesse" aria-expanded="true" aria-controls="chinesse">Hide</button>
						<h4 style="text-align: left;">Chinesse</h4>
						<div class="collapse in" id="chinesse">
						
							<table>
								<td class="Cell">
									<a href="<%= request.getContextPath()%>/RestoWeb?action=displayResto&id=2" class="Index">
										<div>
											<div class="PictureIndex">
												<img class="Index" src="pictures/default.jpg" title="Restaurant Name">
											</div>
											<div class="Tech">
												<li>Restaurant Name</li>
												<li>
													Restaurant Description
												</li>
											</div>
										</div>
									</a>
								</td>
								
								<td class="Cell">
									<a href="<%= request.getContextPath()%>/RestoWeb?action=displayResto" class="Index">
										<div>
											<div class="PictureIndex">
												<img class="Index" src="pictures/default.jpg" title="Restaurant Name">
											</div>
											<div class="Tech">
												<li>Restaurant Name</li>
												<li>
													Restaurant Description
												</li>
											</div>
										</div>
									</a>
								</td>
								
								<td class="Cell">
									<a href="<%= request.getContextPath()%>/RestoWeb?action=displayResto" class="Index">
										<div>
											<div class="PictureIndex">
												<img class="Index" src="pictures/default.jpg" title="Restaurant Name">
											</div>
											<div class="Tech">
												<li>Restaurant Name</li>
												<li>
													Restaurant Description
												</li>
											</div>
										</div>
									</a>
								</td>

							</table>
						</div>
					</div>
					<!-- -->
					<div class="Category">
					
						<button class="btn btn-default form-inline pull-right" type="button" data-toggle="collapse" data-target="#french" aria-expanded="true" aria-controls="french">Hide</button>
						<h4 style="text-align: left;">French</h4>
						<div class="collapse in" id="french">
						
							<table>
								<td class="Cell">
									<a href="<%= request.getContextPath()%>/RestoWeb?action=displayResto" class="Index">
										<div>
											<div class="PictureIndex">
												<img class="Index" src="pictures/default.jpg" title="Restaurant Name">
											</div>
											<div class="Tech">
												<li>Restaurant Name</li>
												<li>
													Restaurant Description
												</li>
											</div>
										</div>
									</a>
								</td>
								
								<td class="Cell">
									<a href="<%= request.getContextPath()%>/RestoWeb?action=displayResto" class="Index">
										<div>
											<div class="PictureIndex">
												<img class="Index" src="pictures/default.jpg" title="Restaurant Name">
											</div>
											<div class="Tech">
												<li>Restaurant Name</li>
												<li>
													Restaurant Description
												</li>
											</div>
										</div>
									</a>
								</td>
								
								<td class="Cell">
									<a href="<%= request.getContextPath()%>/RestoWeb?action=displayResto" class="Index">
										<div>
											<div class="PictureIndex">
												<img class="Index" src="pictures/default.jpg" title="Restaurant Name">
											</div>
											<div class="Tech">
												<li>Restaurant Name</li>
												<li>
													Restaurant Description
												</li>
											</div>
										</div>
									</a>
								</td>
							</table>
						</div>
					</div>
					<!-- -->
					<div class="Category">
					
						<button class="btn btn-default form-inline pull-right" type="button" data-toggle="collapse" data-target="#italian" aria-expanded="true" aria-controls="italian">Hide</button>
						<h4 style="text-align: left;">Italian</h4>
						<div class="collapse in" id="italian">
						
							<table>
								<td class="Cell">
									<a href="<%= request.getContextPath()%>/RestoWeb?action=displayResto" class="Index">
										<div>
											<div class="PictureIndex">
												<img class="Index" src="pictures/default.jpg" title="Restaurant Name">
											</div>
											<div class="Tech">
												<li>Restaurant Name</li>
												<li>
													Restaurant Description
												</li>
											</div>
										</div>
									</a>
								</td>
								
								<td class="Cell">
									<a href="<%= request.getContextPath()%>/RestoWeb?action=displayResto" class="Index">
										<div>
											<div class="PictureIndex">
												<img class="Index" src="pictures/default.jpg" title="Restaurant Name">
											</div>
											<div class="Tech">
												<li>Restaurant Name</li>
												<li>
													Restaurant Description
												</li>
											</div>
										</div>
									</a>
								</td>
								
								<td class="Cell">
									<a href="<%= request.getContextPath()%>/RestoWeb?action=displayResto" class="Index">
										<div>
											<div class="PictureIndex">
												<img class="Index" src="pictures/default.jpg" title="Restaurant Name">
											</div>
											<div class="Tech">
												<li>Restaurant Name</li>
												<li>
													Restaurant Description
												</li>
											</div>
										</div>
									</a>
								</td>
							</table>
						</div>
					</div>
					<!-- -->
					<div class="Category">
					
						<button class="btn btn-default form-inline pull-right" type="button" data-toggle="collapse" data-target="#turkish" aria-expanded="true" aria-controls="japanesse">Hide</button>
						<h4 style="text-align: left;">Turkish</h4>
						<div class="collapse in" id="turkish">
						
							<table>
								<td class="Cell">
									<a href="<%= request.getContextPath()%>/RestoWeb?action=displayResto" class="Index">
										<div>
											<div class="PictureIndex">
												<img class="Index" src="pictures/default.jpg" title="Restaurant Name">
											</div>
											<div class="Tech">
												<li>Restaurant Name</li>
												<li>
													Restaurant Description
												</li>
											</div>
										</div>
									</a>
								</td>
								
								<td class="Cell">
									<a href="<%= request.getContextPath()%>/RestoWeb?action=displayResto" class="Index">
										<div>
											<div class="PictureIndex">
												<img class="Index" src="pictures/default.jpg" title="Restaurant Name">
											</div>
											<div class="Tech">
												<li>Restaurant Name</li>
												<li>
													Restaurant Description
												</li>
											</div>
										</div>
									</a>
								</td>
								
								<td class="Cell">
									<a href="<%= request.getContextPath()%>/RestoWeb?action=displayResto" class="Index">
										<div>
											<div class="PictureIndex">
												<img class="Index" src="pictures/default.jpg" title="Restaurant Name">
											</div>
											<div class="Tech">
												<li>Restaurant Name</li>
												<li>
													Restaurant Description
												</li>
											</div>
										</div>
									</a>
								</td>
							</table>
						</div>
						
					</div>
		
		
<%@include file="_homeScript.jsp" %>
<%@include file="_footer.jsp" %>