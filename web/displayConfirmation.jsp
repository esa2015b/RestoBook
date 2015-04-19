<%-- 
    Document   : displayConfirmation
    Created on : 18-avr.-2015, 20:34:44
    Author     : Jean-Louis
--%>
<%@page import="domain.*"%>
<%@include file="_header.jsp" %>

<li><a href="index.jsp">Home</a></li>
<li><a href="<%= request.getContextPath()%>/RestoWeb?action=displayResto">I Feel Lucky</a></li>
    <jsp:useBean name="customer" scope="request" class="domain.Customer">

<%@include file="_navBar.jsp" %>
<div>
    <h1>
        Reservation confirmed
        Thanks a lot
        You'll receive confirmation on mail address: <jsp:getProperty name="customer" property="mail"></jsp:getProperty>
    </h1> 
</div>