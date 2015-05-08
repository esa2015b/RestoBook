
					  </ul>
					  <!-- Search Form -->
					  <form class="navbar-form navbar-left" role="search" action="<%= request.getContextPath()%>/RestoWeb" method="post">
						<div class="form-group">
                                                    <input type="hidden" name="action" value="searchResto" />
                                                    <div class="input-group">
                                                        <span class="input-group-addon">
                                                            <span class="glyphicon glyphicon-search"></span>
                                                        </span>
                                                        <input type="text" class="form-control" name="name" placeholder="Search by name" />
                                                    </div>
						</div>
						<button type="submit" class="btn btn-default">
                                                    <span class="glyphicon glyphicon-play"></span>
                                                    <span>Search</span>
                                                </button>
					  </form>
					  <!-- End Search Form -->
                                          
                                          <!-- Advanced Search Form and Dropdown -->
					  <ul class="nav navbar-nav navbar-right">
						<li class="dropdown">
						  <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
                                                      <span class="glyphicon glyphicon-list"></span>
                                                      <span>Advanced search</span>
                                                      <span class="caret"></span>
                                                  </a>
						    <div class="dropdown-menu" style="padding: 15px; width: 250px;">
							  <form action="<%= request.getContextPath()%>/RestoWeb" method="post" role="search">
                                                            <input type="hidden" name="action" value="advancedSearch">
                                                            
                                                            <label>Restaurant name</label> 
                                                            <div class="input-group">
                                                                <span class="input-group-addon">
                                                                    <span class="glyphicon glyphicon-cutlery"></span>
                                                                </span>
                                                                <input type="text" class="form-control" name="name" placeholder="Search by name" />
                                                            </div><br>
                                                            
							    <label>Food type</label>
                                                            
                                                            <div class="input-group">
                                                                <span class="input-group-addon">
                                                                    <span class="glyphicon glyphicon-heart"></span>
                                                                </span>
                                                                <select name="type" class="form-control">
                                                                  <option value="">All</option>
                                                                  <option value="chinois">Chinesse</option>
                                                                  <option value="fran">French</option>
                                                                  <option value="italienne">Italian</option>
                                                                  <option value="turque">Turkish</option>
                                                                </select>
                                                            </div><br>
                                                                  
                                                            <label>City</label>
                                                            <div class="input-group">
                                                                <span class="input-group-addon">
                                                                    <span class="glyphicon glyphicon-globe"></span>
                                                                </span>
                                                                <input type="text" class="form-control" name="city" placeholder="Search by city"/>
                                                            </div><br>

                                                            <div align="right">
                                                                <button type="submit" class="btn btn-default">
                                                                    <span class="glyphicon glyphicon-play"></span>
                                                                    <span>Search</span>
                                                                </button>
                                                            </div>
							  </form>
                                                        
                                                    </div>
						</li>
					  </ul>
					  <!-- End Advanced Search -->
                                          
                                          <!-- Login Form and Dropdown -->
					  <ul class="nav navbar-nav navbar-right">
                                                <li class="dropdown">
						  <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
                                                      <span class="glyphicon glyphicon-log-in"></span>
                                                      Login <span class="caret"></span>
                                                  </a>
						    <div class="dropdown-menu login" style="padding: 15px; width: 250px;">
                                                        
							  <form  enctype="multipart/form-data" method="post" action="#">
							    <label>Login</label>
                                                            <div class="input-group">
                                                                <span class="input-group-addon">
                                                                    <span class="glyphicon glyphicon-user"></span>
                                                                </span>
                                                                <input type="text" name="login" class="form-control"/>
                                                            </div>
                                                            <br>
                                                            
							    <label>Password</label>
                                                            <div class="input-group">
                                                                <span class="input-group-addon">
                                                                    <span class="glyphicon glyphicon-qrcode"></span>
                                                                </span>
                                                                <input type="text" name="password" class="form-control"/>
                                                            </div><br>
                                                            
                                                            <div align="right">
                                                                
                                                                <button type="submit" class="btn btn-default">
                                                                    <span class="glyphicon glyphicon-log-in"></span>
                                                                    <span>Login</span>
                                                                </button>
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