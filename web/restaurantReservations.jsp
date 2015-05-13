<%-- 
    Document   : restaurantReservations
    Created on : 12-mai-2015, 12:11:53
    Author     : mirkoella
--%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.List"%>
<%@page import="domain.*"%>

<%@include file="_header.jsp" %>
						
<%@include file="_navBar.jsp" %>

<%! List<Reservation> reservations; %>
<jsp:useBean id="changes" scope="request" class="java.lang.String"></jsp:useBean>

<% reservations = (List<Reservation>) session.getAttribute("reservations"); %>

<div class="Success">
    <p class="text-success" > <%= changes %></p>
</div>

<%@include file="_errors.jsp" %>

<form role="form" method="POST" action="<%= request.getContextPath()%>/RestaurantReservations?action=saveChanges" >
    <table class="table table-hover">
        <thead>
            <tr>
                <th>Id</th>
                <th>Mail</th>
                <th>Phone</th>
                <th>Date</th>
                <th>Service</th>
                <th>Seats</th>
                <th>Confirmed</th>
                <th>Rejected</th>
                <th>Confirmation Date</th>
                <th>Comments</th>
            </tr>
        </thead>
        <tbody class="table table-striped">
            <% for(Reservation r : reservations){ %>
            <tr class="<%= r.getColorCodeName() %>">
                <td><%= r.getId() %></td>
                <td><%= r.getCustomerMail() %></td>
                <td><%= r.getCustomerPhone() %></td>
                <td><%= r.getReservationDateSimple() %></td>
                <td><%= r.getService() %></td>
                <td><%= r.getPlaceQuantity() %></td>
                <td><input value="checked" type="checkbox" <%= r.getRestoConfirmationChecked() %> name="restaurantConfirmed<%= r.getId() %>" /></td>
                <td><input value="checked" type="checkbox" <%= r.getRestoRejectedChecked()%> name="restaurantRejected<%= r.getId() %>" /></td>
                <td><%= r.getRestoConfirmationDateSimple() %></td>
                <td><%= r.getRestoComments() %></td>
            </tr>
            <% } %>
    <!--        <tr>
                <td>1</td>
                <td>Jean-Louis</td>
                <td>Jean-Louis</td>
                <td>11/08/2015</td>
                <td>Soir</td>
                <td>5</td>
                <td><input type="checkbox" checked/></td>
                <td>10/05/2015</td>
                <td>Blah blah blah</td>
            </tr>
            <tr>
                <td>2</td>
                <td>Mirko</td>
                <td>Mirko</td>
                <td>25/06/2015</td>
                <td>Soir</td>
                <td>2</td>
                <td><input type="checkbox"/></td>
                <td></td>
                <td>Blah Blah Blah Blah</td>
            </tr>
            <tr>
                <td>3</td>
                <td>Thibaut</td>
                <td>Thibaut</td>
                <td>18/05/2015</td>
                <td>Midi</td>
                <td>4</td>
                <td><input type="checkbox"/></td>
                <td></td>
                <td>Aha Aha Aha</td>
            </tr>
            <tr>
                <td>4</td>
                <td>Mirko</td>
                <td>Mirko</td>
                <td>25/06/2015</td>
                <td>Soir</td>
                <td>2</td>
                <td><input type="checkbox" checked/></td>
                <td></td>
                <td>Blah Blah Blah Blah</td>
            </tr>
            <tr class="active">
                <td>5</td>
                <td>active</td>
                <td>active</td>
                <td>18/05/2015</td>
                <td>Midi</td>
                <td>4</td>
                <td><input type="checkbox"/></td>
                <td></td>
                <td>Aha Aha Aha</td>
            </tr>
            <tr class="success">
                <td>6</td>
                <td>success</td>
                <td>success</td>
                <td>18/05/2015</td>
                <td>Midi</td>
                <td>4</td>
                <td><input type="checkbox" checked/></td>
                <td></td>
                <td>Aha Aha Aha</td>
            </tr>
            <tr class="info">
                <td>7</td>
                <td>info</td>
                <td>info</td>
                <td>25/06/2015</td>
                <td>Soir</td>
                <td>2</td>
                <td><input type="checkbox"/></td>
                <td></td>
                <td>Blah Blah Blah Blah</td>
            </tr>
            <tr class="warning">
                <td>8</td>
                <td>warning</td>
                <td>warning</td>
                <td>18/05/2015</td>
                <td>Midi</td>
                <td>4</td>
                <td><input type="checkbox"/></td>
                <td></td>
                <td>Aha Aha Aha</td>
            </tr>
            <tr class="danger">
                <td>9</td>
                <td>danger</td>
                <td>danger</td>
                <td>18/05/2015</td>
                <td>Midi</td>
                <td>4</td>
                <td><input type="checkbox"/></td>
                <td></td>
                <td>Aha Aha Aha</td>
            </tr>-->
        </tbody>
    </table>

    <div class="input-group">
        <button type="submit" class="btn btn-default">
            <span class="glyphicon glyphicon-book"></span>
            <span>Save changes</span>
        </button>
        <input type="hidden" name="action" value="saveChanges" />
    </div>
</form>


<%@include file="_footer.jsp" %>