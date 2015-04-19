<%-- 
    Document   : displayResults
    Created on : 17-avr.-2015, 20:10:44
    Author     : Jean-Louis
--%>
<%@page import="domain.*"%>
<%@include file="_header.jsp" %>

<li><a href="index.jsp">Home</a></li>
<li><a href="<%= request.getContextPath()%>/RestoWeb?action=displayResto">I Feel Lucky</a></li>

<%@include file="_navBar.jsp" %>
<div>
    <h1>
        Search results
        <jsp:useBean id="restaurant" scope="request" class="domain.Restaurant" />
        <jsp:useBean id="pricelist" scope="request" class="domain.PriceList" ></jsp:useBean>
    </h1> 
</div>

<div>
    <fieldset style="float:left">
        <legend>Restaurant</legend>
            Name: <jsp:getProperty name="restaurant" property="name" /><br>
            Description <jsp:getProperty name="restaurant" property="description" /><br>
            Food type: <jsp:getProperty name="restaurant" property="foodType" /><br>
            Place quantity: <jsp:getProperty name="restaurant" property="placeQuantity" /><br>
            Phone: <jsp:getProperty name="restaurant" property="phone" /><br>
            Mail: <jsp:getProperty name="restaurant" property="phone" /><br>
            Day of closing: <jsp:getProperty name="restaurant" property="dayOfClosing" /><br>
            Employee: <jsp:getProperty name="restaurant" property="employee" /><br>
            Price list: <jsp:getProperty name="pricelist" property="description" /><br>
            PictureLocation: <br>
            IsEnable: <jsp:getProperty name="restaurant" property="isEnable" /><br>
            IsPremium: <jsp:getProperty name="restaurant" property="isPremium" /><br> 
    </fieldset>
</div>
    
<div>
    <fieldset style="float: right">
        <legend>Reservation</legend>
            <form method="POST" action="<%= request.getContextPath()%>/RestoWeb">
                
                Reservation date:<input type="date" name="reservationdate"><br>
                Service: <input type="text" name="service" value="Midi"><br>
                Number of place: <input type="number" name="placequantity" value=5><br>
                Customer phone: <input type="tel" name="customerphone" value="0473/629.626."><br>
                Customer mail: <input type="text" name="customermail" value="jlmoiny@gmail.com"><br>
                <br>
                <input type="submit" value="Book">
                <input type="hidden" name="action" value="sendReservation">
                
            </form>
    </fieldset>   
</div>
    
<%@include file="_footer.jsp" %>