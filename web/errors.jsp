<%-- 
    Document   : userserrors
    Created on : 19-avr.-2015, 11:47:50
    Author     : Jean-Louis
--%>
<%@page import="domain.*"%>
<%@page import="controller.*"%>

<%@include file="_header.jsp" %>

<li><a href="index.jsp">Home</a></li>
<li><a href="<%= request.getContextPath()%>/RestoWeb?action=displayResto">I Feel Lucky</a></li>

<%@include file="_navBar.jsp" %>

<div>
    <h1>
        Sorry an error has occurred.
    </h1>
</div>

<div>
    <h2>
        <%! ControllerException error; %><br>
        <% error = (ControllerException)request.getAttribute("error"); %><br>
        Error : <%= error.getMessage()%>
    </h2>
</div>
    