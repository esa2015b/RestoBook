<%-- 
    Document   : _errors
    Created on : 12-mai-2015, 9:26:58
    Author     : Mirko Manessi
--%>

    <jsp:useBean id="errors" scope="request" class="domain.ErrorView"></jsp:useBean>
    
    <div class="error">
        <% for(String e : errors.getErrors()){ %>
        <p class="text-danger" >* <%= e %></p>
        <% } %>
    </div>