<%-- 
    Document   : userserrors
    Created on : 19-avr.-2015, 11:47:50
    Author     : Jean-Louis
--%>
<%@page import="domain.*"%>
<%@page import="controller.*"%>

<%@include file="_header.jsp" %>

<%@include file="_navBar.jsp" %>

<div>
    <h2 class="text-danger">
        Sorry an error has occurred.
    </h2>
</div>

<div class="error">
    <h2 class="text-danger" >
        <%! ControllerException error; %><br>
        <% error = (ControllerException)request.getAttribute("error"); %><br>
        Error : <%= error.getMessage()%>
    </h2>
</div>
    
<%@include file="_footer.jsp" %>
    