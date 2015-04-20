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
<div>
    <h1>
        Display reservation
        <jsp:useBean id="restaurant" scope="session" class="domain.Restaurant"></jsp:useBean>
        <jsp:useBean id="customer" scope="session" class="domain.Customer"></jsp:useBean>
        <jsp:useBean id="reservation" scope="session" class="domain.Reservation"></jsp:useBean>
    </h1>
</div>
    
<div>
    <fieldset style="float:left">
        <legend>Restaurant</legend>   
        Name: <jsp:getProperty name="restaurant" property="name"></jsp:getProperty><br>
        Address: 
        Phone: <jsp:getProperty name="restaurant" property="phone"></jsp:getProperty><br>
        
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

<%@include file="_footer.jsp" %>