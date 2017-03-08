<%-- 
    Document   : employeeeditform
    Created on : Jan 23, 2017, 8:17:14 PM
    Author     : awood
--%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    

<%@ include file="theme/header.jsp" %>

<header class="w3-container" style="padding-top:22px">
    <h5><b><i class="fa fa-dashboard"></i> Manage Employees > Edit Employee</b></h5>
</header>

<div class="w3-row-padding w3-half w3-margin-bottom">

    <div class="w3-card-4">
        <div class="w3-container w3-blue">
            <h2>Employee Information</h2>
        </div>

        <form:form method="POST" action="/arwcrm/employee/editsave" cssClass="w3-container" commandName="employee">
            <form:hidden path="employeeID"  />

            <div class="w3-padding-8">
                <form:input path="employeeID" cssClass="w3-input w3-border" placeholder="Employee ID" />
                <form:errors path="employeeID" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />
                <form:input path="employeeLastName" cssClass="w3-input w3-border" placeholder="Employee Last Name" />
                <form:errors path="employeeLastName" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />                              
                <form:input path="employeeFirstName" cssClass="w3-input w3-border" placeholder="Employee First Name" />
                <form:errors path="employeeFirstName" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />
                <form:input path="address" cssClass="w3-input w3-border" placeholder="Address" />
                <form:errors path="address" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />
                <form:input path="homePhone" cssClass="w3-input w3-border" placeholder="Home Phone" />
                <form:errors path="homePhone" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />
                <form:input path="extension" cssClass="w3-input w3-border" placeholder="Extension" />
                <form:errors path="extension" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />
                <form:input path="email" cssClass="w3-input w3-border" placeholder="Email" />
                <form:errors path="email" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />
                <form:input path="deptNumber" cssClass="w3-input w3-border" placeholder="Department Number" />
                <form:errors path="deptNumber" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />
                <form:input path="title" cssClass="w3-input w3-border" placeholder="Title" />
                <form:errors path="title" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />
                <form:input path="startDate" cssClass="w3-input w3-border" placeholder="Start Date"/>
                <form:errors path="startDate" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />
            </div>

            <div class="w3-padding-8">
                <button type="submit" class="w3-btn w3-padding w3-blue" style="width:120px">Save</button>
            </div>
        </form:form>

    </div>
</div>

<%@ include file="theme/footer.jsp" %>