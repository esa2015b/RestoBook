<%-- 
    Document   : displayNewReservation
    Created on : 18-avr.-2015, 19:33:31
    Author     : Jean-Louis
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="domain.*"%>
<%@include file="_header.jsp" %>

<li><a href="index.jsp">Home</a></li>
<li><a href="<%= request.getContextPath()%>/RestoWeb?action=displayResto">I Feel Lucky</a></li>

<%@include file="_navBar.jsp" %>
<div>
    <h1>
        New reservation
    </h1>
</div>
    
<div class="container-fluid">
    <jsp:useBean id="restaurant" scope="session" class="domain.DisplayRestaurant"></jsp:useBean>
    <jsp:useBean id="customer" scope="session" class="domain.Customer"></jsp:useBean>
    <jsp:useBean id="reservation" scope="session" class="domain.Reservation"></jsp:useBean>
    
    <form class="form-horizontal" role="form" method="POST" action="<%= request.getContextPath()%>/DisplayNewReservation">
        
        <div class="form-group">
            <label class="control-label col-sm-2" for="customerName">Name *</label>
            <div class="col-sm-10 input-group">
                <span class="input-group-addon">
                    <span class="glyphicon glyphicon-user"></span>
                </span>
                <input type="text" class="form-control" id="customerName" 
                       name="customerName" placeholder="Your name (required)" value="<%= customer.getName() %>"/>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="customerEmail">Email *</label>
            <div class="col-sm-10 input-group">
                <span class="input-group-addon">
                    <span class="glyphicon glyphicon-envelope"></span>
                </span>
                <input type="email" class="form-control" id="customerEmail" 
                       name="customerEmail" placeholder="example@restobook.com (required)" value="<%= customer.getMail() %>" />
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="customerPhone">Phone *</label>
            <div class="col-sm-10 input-group">
                <span class="input-group-addon">
                    <span class="glyphicon glyphicon-phone"></span>
                </span>
                <input type="tel" class="form-control" id="customerPhone" 
                       name="customerPhone" placeholder="(+32)466/12.34.55 (required)" value="<%= customer.getPhone() %>" />
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="reservationPlaceQuantity">Reservation for *</label>
            <div class="col-sm-10 input-group">
                <span class="input-group-addon">
                    <span class="glyphicon glyphicon-cutlery"></span>
                </span>
                <input type="number" class="form-control" id="reservationPlaceQuantity" 
                       name="reservationPlaceQuantity" placeholder="2" value="<%= reservation.getPlaceQuantity() %>"/>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="reservationDate">Date *</label>
            <div class="col-sm-10 input-group">
                <span class="input-group-addon">
                    <span class="glyphicon glyphicon-calendar"></span>
                </span>
                <input type="date" class="form-control" id="reservationDate" 
                       name="reservationDate" placeholder="1/1/2015 (required)" value="<%= reservation.getReservationDateSimple()%>"/>
            </div>
        </div>        
        <div class="form-group">
            <label class="control-label col-sm-2" for="reservationService">Service </label>
            <div class="col-sm-10 input-group">
                <span class="input-group-addon">
                    <span class="glyphicon glyphicon-time"></span>
                </span>
                <input type="time" class="form-control" id="reservationService"
                       name="reservationService" placeholder="18:30 (required)" value="<%= reservation.getService() %>" />
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="reservationComments">Reservation details </label>
            <div class="col-sm-10 input-group">
                <span class="input-group-addon">
                    <span class="glyphicon glyphicon-edit"></span>
                </span>
                <textarea cols="10" rows="4" class="form-control" id="reservationComments"
                          name="reservationComments" placeholder="additional information here"><%= reservation.getReservationComments()%>
                </textarea>
            </div>
        </div>
        
        <div class="form-group input-group">
            <div class="input-group col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default">
                    <span class="glyphicon glyphicon-book"></span>
                    <span>Book reservation</span>
                </button>
                <input type="hidden" name="action" value="confirmReservation" />
            </div>
        </div>
    </form>
</div>

<%@include file="_footer.jsp" %>