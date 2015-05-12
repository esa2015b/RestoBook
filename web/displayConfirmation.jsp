<%-- 
    Document   : displayConfirmation
    Created on : 18-avr.-2015, 20:34:44
    Author     : Jean-Louis
--%>
<%@page import="domain.*"%>
<%@include file="_header.jsp" %>

<%@include file="_navBar.jsp" %>

<jsp:useBean id="customer" scope="session" class="domain.Customer"></jsp:useBean>
<jsp:useBean id="restaurant" scope="session" class="domain.DisplayRestaurant"></jsp:useBean>

<div>
    <p>
        <a href="<%= request.getContextPath()%>/RestoWeb?action=displayResto&id=<%= restaurant.getId() %>">
            Return to <%= restaurant.getName() %> info page
        </a>
    </p>
    <fieldset class="text-success">
        <p class="text-success">Reservation submitted to 
            <a href="<%= request.getContextPath()%>/RestoWeb?action=displayResto&id=<%= restaurant.getId() %>"><b><%= restaurant.getName() %></b></a></p><br />
        <p class="text-success">We thank you for using Restobook, <em><%= customer.getName() %></em></p>
        
        <p class="text-success">You will shortly receive a confirmation from <%= restaurant.getName() %>
        at your mail address: <em><%= customer.getMail() %></em></p>
        
        <p class="text-success">See you soon, and don't forget to book your future dinners at 
            <a href="<%= request.getContextPath()%>/Home" ><b>Restobook</b></a> !</p><br />
        
        <p class="text-success">Best regards from the Restobook crew.</p>
    </fieldset>
</div>
       
<%@include file="_footer.jsp" %>