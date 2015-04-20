<%-- 
    Document   : displayConfirmation
    Created on : 18-avr.-2015, 20:34:44
    Author     : Jean-Louis
--%>
<%@page import="domain.*"%>
<%@include file="_header.jsp" %>

<li><a href="index.jsp">Home</a></li>
<li><a href="<%= request.getContextPath()%>/RestoWeb?action=displayResto">I Feel Lucky</a></li>

<%@include file="_navBar.jsp" %>
<jsp:useBean id="customer" scope="session" class="domain.Customer"></jsp:useBean>
<jsp:useBean id="restaurant" scope="session" class="domain.Restaurant"></jsp:useBean>

<div>
    <fieldset>
        Reservation sent to RestoBook<br>
        Thanks a lot !<br><br>
        You'll receive confirmation from <jsp:getProperty name="restaurant" property="name" ></jsp:getProperty><br>
        at your mail address: <jsp:getProperty name="customer" property="mail"></jsp:getProperty><br>
        See you soon.
    </fieldset>
</div>
       
<%@include file="_footer.jsp" %>