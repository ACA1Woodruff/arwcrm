<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    

<%@ include file="theme/header.jsp" %>

<header class="w3-container" style="padding-top:22px">
    <h5><b><i class="fa fa-dashboard"></i> Manage Customers</b></h5>
</header>

<div class="w3-row-padding w3-margin-bottom">

    <c:if test="${not empty message}">
        <c:choose>
            <c:when test="${message.type eq 'INFO'}">
                <div class="w3-panel w3-border w3-pale-yellow w3-border-yellow"><p>${message.message}</p></div>
                    </c:when>
                    <c:when test="${message.type eq 'ERROR'}">
                <div class="w3-panel w3-border w3-pale-red w3-border-red"><p>${message.message}</p></div>
                    </c:when>
                </c:choose>

    </c:if>

    <table class="w3-table w3-striped w3-bordered w3-border w3-hoverable w3-white">  
        <tr>
            <th>Customer ID</th>
            <th>Customer Name</th>
            <th>Action</th>
        </tr>  

        <c:forEach var="customer" items="${list}">   
            <tr>  
                <td>${customer.customerID}</td>  
                <td>${customer.customerName}</td>  
                <td>
                    <a href="<c:url value="/customer/editcustomer/${customer.customerID}" />"><button class="w3-btn w3-round w3-blue">Edit</button></a>
                    <a href="<c:url value="/customer/deletecustomer/${customer.customerID}" />"><button class="w3-btn w3-round w3-red" onclick="return confirm('Are you sure you want to delete this customer?');">Delete</button></a>
                    <a href="<c:url value="/customer/customerform/${employee.employeeID}" />"><button class="w3-btn w3-round w3-green">Add Employee</button></a>
                    <a href="<c:url value="/interactions/interactionsform/${customer.customerID}" />"><button class="w3-btn w3-round w3-green">Add Interaction</button></a>
                </td>  
            </tr>  
        </c:forEach>  
    </table> 

    <div class="w3-padding-8">
        <ul class="w3-pagination">
            <c:forEach begin="1" end="${pages}" varStatus="p">  
                <li><a class="<c:if test="${p.index eq page}">w3-green</c:if>" href="<c:url value="/customer/viewcustomer/${p.index}" />">${p.index}</a></li>
                </c:forEach>
        </ul>
    </div>

</div>

<%@ include file="theme/footer.jsp" %>
