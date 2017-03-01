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

        <form:form method="post" action="save" cssClass="w3-container" commandName="employee">
            <div class="w3-padding-8">
                <label><b>Title</b></label>
                <form:input path="title" cssClass="w3-input w3-border"/>
                <form:errors path="title" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />

                <div class="w3-padding-8">
                    <label><b>EmployeeID</b></label>
                    <form:input path="EmployeeID" cssClass="w3-input w3-border" placeholder="EmployeeID" />
                    <form:errors path="EmployeeID" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />

                    <div class="w3-padding-8">
                        <label><b>EmployeeLastName</b></label>
                        <form:input path="employeeLastName" cssClass="w3-input w3-border" placeholder="Employee First Name" />
                        <form:errors path="employeeLastName" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />

                        <div class="w3-padding-8">
                            <label><b>EmployeeFirstName</b></label>
                            <form:input path="employeeFirstName" cssClass="w3-input w3-border" placeholder="Employee Last Name" />
                            <form:errors path="employeeFirstName" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />

                            <div class="w3-padding-8">
                                <label><b>AddressLine1</b></label>
                                <form:input path="addressLine1" cssClass="w3-input w3-border" placeholder="Address Line 1" />
                                <form:errors path="addressLine1" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />

                                <div class="w3-padding-8">
                                    <label><b>AddressLine2</b></label>
                                    <form:input path="addressLine2" cssClass="w3-input w3-border" placeholder="Address Line 2" />
                                    <form:errors path="addressLine2" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />

                                    <div class="w3-padding-8">
                                        <label><b>Homephone</b></label>
                                        <form:input path="homephone" cssClass="w3-input w3-border" placeholder="Home Phone" />
                                        <form:errors path="homephone" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />

                                        <div class="w3-padding-8">
                                            <label><b>Extension</b></label>
                                            <form:input path="extension" cssClass="w3-input w3-border" placeholder="Extension" />
                                            <form:errors path="extension" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />

                                            <div class="w3-padding-8">
                                                <label><b>Email</b></label>
                                                <form:input path="email" cssClass="w3-input w3-border" placeholder="Email" />
                                                <form:errors path="email" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />

                                                <div class="w3-padding-8">
                                                    <label><b>DeptNumber</b></label>
                                                    <form:input path="deptNumber" cssClass="w3-input w3-border" placeholder="Department Number" />
                                                    <form:errors path="deptNumber" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />

                                                    <div class="w3-padding-8">
                                                        <label><b>Title</b></label>
                                                        <form:input path="title" cssClass="w3-input w3-border" placeholder="Title" />
                                                        <form:errors path="title" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />

                                                        <div class="w3-padding-8">
                                                            <label><b>Date Of Hire</b></label>
                                                            <form:input path="date_of_hire" cssClass="w3-input w3-border" placeholder="Date-of-Hire"/>
                                                            <form:errors path="date_of_hire" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />
                                                        </div>

                                                        <div class="w3-padding-8">
                                                            <label><b>File Number</b></label>
                                                            <form:input path="file_number" cssClass="w3-input w3-border" placeholder="File Number" />
                                                            <form:errors path="file_number" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />
                                                        </div>
                                                        <div class="w3-padding-8">
                                                            <button type="submit" class="w3-btn w3-padding w3-blue" style="width:120px">Save</button>
                                                        </div>

                                                    </div>

                                                </div>

                                                <%@ include file="theme/footer.jsp" %>

                                            </div>

                                            <c:choose>
                                                <c:when test="${not empty command.employee}">
                                                    <form:hidden path="EmployeeID" />
                                                    <div class="w3-padding-8">
                                                        <label><b>Employee</b></label>
                                                        <div class="w3-panel w3-border">
                                                            <p><b>${command.employee.last_name}</b></p>
                                                            <p><b>${command.employee.first_name}</b></p>
                                                        </div>
                                                    </div>
                                                </c:when>

                                                <c:otherwise>
                                                    <div class="w3-padding-8">
                                                        <label><b>Employee</b></label>
                                                        <form:select path="employeeid" cssClass="w3-select w3-border">
                                                            <form:option value="-1">Select Employee</form:option>
                                                            <form:options items="${command.employees}"/>
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

                                <!--<%@ include file="theme/footer.jsp" %>-->
