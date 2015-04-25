
					  </ul>
					  <!-- Search Form -->
					  <form class="navbar-form navbar-left" role="search" action="<%= request.getContextPath()%>/RestoWeb" method="post">
						<div class="form-group">
                                                    <input type="hidden" name="action" value="searchResto">
                                                    <input type="text" class="form-control" name="name" placeholder="Search by name">
						</div>
						<button type="submit" class="btn btn-default">Search</button>
					  </form>
					  <!-- End Search Form -->
                                          
                                          <!-- Advanced Search Form and Dropdown -->
					  <ul class="nav navbar-nav navbar-right">
						<li class="dropdown">
						  <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Advanced search <span class="caret"></span></a>
						    <div class="dropdown-menu" style="padding: 15px; width: 250px;">
                                                        
							  <form action="<%= request.getContextPath()%>/RestoWeb" method="post" role="search">
                                                            <input type="hidden" name="action" value="advancedSearch">
                                                            <label>Restaurant name</label> <input type="text" class="form-control" name="name" placeholder="Search by name"/><br>
							    <label>Food type</label>
								  <select name="type" class="form-control">
								    <option value="">All</option>
								    <option value="chinois">Chinesse</option>
								    <option value="fran">French</option>
								    <option value="italienne">Italian</option>
								    <option value="turque">Turkish</option>
								  </select><br>
								<label>City</label> <input type="text" class="form-control" name="city" placeholder="Search by city"/><br>
								<div align="right">
								  <button type="submit" class="btn btn-default">Search</button>
								</div>
							  </form>
                                                        
                                                    </div>
						</li>
					  </ul>
					  <!-- End Advanced Search -->
                                          
                                          <!-- Login Form and Dropdown -->
					  <ul class="nav navbar-nav navbar-right">
						<li class="dropdown">
						  <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Login <span class="caret"></span></a>
						    <div class="dropdown-menu login" style="padding: 15px; width: 250px;">
                                                        
							  <form  enctype="multipart/form-data" method="post" action="#">
							    <label>Login</label> <input type="text" name="login" class="form-control"/><br>
							    <label>Password</label> <input type="text" name="password" class="form-control"/><br>
								<div align="right">
								  <button type="submit" class="btn btn-default">Login</button>
								</div>
							  </form>
                                                        
                                                    </div>
						</li>
					  </ul>
					  <!-- End Login -->
                                          
					</div><!-- /.navbar-collapse -->
				  </div><!-- /.container-fluid -->
				</nav>
				
			</div>
			<div class="Block">