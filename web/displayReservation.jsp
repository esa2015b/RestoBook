<%-- 
    Document   : displayReservation
    Created on : 18-avr.-2015, 19:33:31
    Author     : Jean-Louis
--%>

<%@page import="domain.*"%>
<%@include file="_header.jsp" %>

<li><a href="index.jsp">Home</a></li>
<li><a href="<%= request.getContextPath()%>/RestoWeb?action=displayResto">I Feel Lucky</a></li>

<%@include file="_navBar.jsp" %>
<jsp:useBean id="customer" scope="request" class="domain.Customer"></jsp:useBean>
<jsp:useBean id="reservation" scope="request" class="domain.Reservation"></jsp:useBean>
    
<div>
    <fieldset style="float:left">
        <legend>Restaurant</legend>   
    </fieldset>

    <fieldset style="float:right">
        <legend>Your reservation</legend>
            Mail address : <jsp:getProperty name="customer" property="mail"></jsp:getProperty><br>
            Phone number: <jsp:getProperty name="customer" property="phone"></jsp:getProperty><br>
            <!-- an integer in class reservation to be parsed-->
            Number of place reserved: <%= reservation.getPlaceQuantity() %><br>
            Service: <jsp:getProperty name="reservation" property="service"></jsp:getProperty><br><br>
            <form method="POST" action="<%= request.getContextPath()%>/RestoWeb">
                <input type="submit" value="Send">
                <input type="hidden" name="action" value="confirmReservation">
            </form>
    </fieldset>
</div>
