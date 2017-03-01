<%-- 
    Document   : customerform1
    Created on : Feb 27, 2017, 9:59:14 PM
    Author     : awood
--%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

<%@ include file="theme/header.jsp" %>

<header class="w3-container" style="padding-top:22px">
    <h5><b><i class="fa fa-dashboard"></i> Manage Customers > Add Customer</b></h5>
</header>

<div class="w3-row-padding w3-half w3-margin-bottom">

    <div class="w3-card-4">
        <div class="w3-container w3-blue">
            Customer Information
        </div>

        <form:form method="post" action="save" cssClass="w3-container" commandName="customer">


            <div class="w3-padding-8">
                <label><b>Last Name</b></label>
                <form:input path="last_name" cssClass="w3-input w3-border"  />
                <form:errors path="last_name" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />

                <div class="w3-padding-8">
                    <label><b>First Name</b></label>
                    <form:input path="first_name" cssClass="w3-input w3-border"  />
                    <form:errors path="first_name" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />
                </div>    

                <div class="w3-padding-8">
                    <label><b>Address 1</b></label>
                    <form:input path="address_1" cssClass="w3-input w3-border"  />
                    <form:errors path="address_1" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />
                </div>

                <div class="w3-padding-8">
                    <label><b>Address 2</b></label>
                    <form:input path="address_2" cssClass="w3-input w3-border"  />
                    <form:errors path="address_2" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />
                </div>

                <div class="w3-padding-8">
                    <label><b>Address 3</b></label>
                    <form:input path="address_3" cssClass="w3-input w3-border"  />
                    <form:errors path="address_3" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />
                </div>

                <div class="w3-padding-8">
                    <label><b>Phone</b></label>
                    <form:input path="phone" cssClass="w3-input w3-border"  />
                    <form:errors path="phone" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />
                </div>

                <div class="w3-padding-8">
                    <label><b>Email</b></label>
                    <form:input path="email" cssClass="w3-input w3-border"  />
                    <form:errors path="email" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />
                </div>

                <div class="w3-padding-8">
                    <label><b>City</b></label>
                    <form:input path="city" cssClass="w3-input w3-border"  />
                    <form:errors path="city" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />
                </div>

                <div class="w3-padding-8">
                    <label><b>State</b></label>
                    <form:input path="state" cssClass="w3-input w3-border"  />
                    <form:errors path="state" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />
                </div>

                <div class="w3-padding-8">
                    <label><b>PostalCode</b></label>
                    <form:input path="postalCode" cssClass="w3-input w3-border"  />
                    <form:errors path="postalCode" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />
                </div>

                <div class="w3-padding-8">
                    <label><b>Country</b></label>
                    <form:input path="country" cssClass="w3-input w3-border"  />
                    <form:errors path="country" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />
                </div>

                <div class="w3-padding-8">
                    <label><b>CreditLimit</b></label>
                    <form:input path="creditLimit" cssClass="w3-input w3-border"  />
                    <form:errors path="creditLimit" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />
                </div>

                <div class="w3-padding-8">
                    <lab
                        <div class="w3-padding-8">
                            <label><b>Status</b></label>
                            <form:input path="status" cssClass="w3-input w3-border"  />
                            <form:errors path="status" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />
                        </div>
                        <div class="w3-padding-8">
                            <button type="submit" class="w3-btn w3-padding w3-blue" style="width:120px">Save</button>
                        </div>

                </div>

            </div>

            <c:choose>
                <c:when test="${not empty command.customer}">
                    <form:hidden path="employeeID" />
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
                        <form:select path="employeeID" cssClass="w3-select w3-border">
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



