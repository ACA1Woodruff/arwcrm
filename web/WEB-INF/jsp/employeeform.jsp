<%-- 
   Document   : employeeform
   Created on : Jan 23, 2017, 8:33:47 PM
   Author     : awood
--%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

<%@ include file="theme/header.jsp" %>

<header class="w3-container" style="padding-top:22px">
    <h5><b><i class="fa fa-dashboard"></i> Manage Employee > Add Employee</b></h5>
</header>

<div class="w3-row-padding w3-half w3-margin-bottom">

    <div class="w3-card-4">
        <div class="w3-container w3-blue">
            <h2>Employee Information</h2>
        </div>

        <form:form method="post" action="save" cssClass="w3-container" commandName="employee">
            <div class="w3-padding-8">
                <!--<label><b>Title</b></label>-->


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

                <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
                <link rel="stylesheet" href="/resources/demos/style.css">
                <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
                <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
                <script>
                    $(function () {
                        $("#startDate").datepicker();
                    });
                </script>


                <form:input path="startDate" cssClass="w3-input w3-border" placeholder="Start Date"/>
                <form:errors path="startDate" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />
            </div>

            <!--<div class="w3-padding-8">
                <label><b>File Number</b></label>
            
        </div>
        <div class="w3-padding-8">
            <button type="submit" class="w3-btn w3-padding w3-blue" style="width:120px">Save</button>
        </div>-->

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
            <form:select path="EmployeeID" cssClass="w3-select w3-border">
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

<%@ include file="theme/footer.jsp" %>
