<%-- 
    Document   : employeeform
    Created on : Jan 23, 2017, 8:33:47 PM
    Author     : awood
--%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

<%@ include file="theme/header.jsp" %>

<header class="w3-container" style="padding-top:22px">
    <h5><b><i class="fa fa-dashboard"></i> Manage Employees > Add Employee</b></h5>
</header>

<div class="w3-row-padding w3-half w3-margin-bottom">

    <div class="w3-card-4">
        <div class="w3-container w3-blue">
            <h2>Employee Information</h2>
        </div>

        <form:form method="post" action="/arwcrm/employee/save" cssClass="w3-container">
            <div class="w3-padding-8">
                <label><b>Title</b></label>
                <form:input path="title" cssClass="w3-input w3-border"  />
            </div>

            <c:choose>
                <c:when test="${not empty command.employee}">
                    <form:hidden path="employeeid" />
                    <div class="w3-padding-8">
                        <label><b>Employee</b></label>
                        <div class="w3-panel w3-border">
                            <p><b>${command.employee.name}</b></p>
                        </div>
                    </div>
                </c:when>

                <c:otherwise>
                    <div class="w3-padding-8">
                        <label><b>Employee</b></label>
                        <form:select path="employeeid" cssClass="w3-select w3-border">
                            <form:option value="-1">Select Employee</form:option>
                            <form:options items="${command.employees}"  />
                        </form:select>
                    </div>
                </c:otherwise>
            </c:choose>

            <div class="w3-padding-8">
                <button type="submit" class="w3-btn w3-padding w3-blue" style="width:120px">Save</button>
            </div>
        </form:form>
    </div>

</div>

<%@ include file="theme/footer.jsp" %>
