<%-- 
    Document   : customereditform
    Created on : Jan 23, 2017, 8:17:14 PM
    Author     : awood
--%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    

<%@ include file="theme/header.jsp" %>

<header class="w3-container" style="padding-top:22px">
    <h5><b><i class="fa fa-dashboard"></i> Manage Customers > Edit Customer</b></h5>
</header>

<div class="w3-row-padding w3-half w3-margin-bottom">

    <div class="w3-card-4">
        <div class="w3-container w3-blue">
            <h2>Customer Information</h2>
        </div>

        <form:form method="POST" action="/arwcrm/customer/editsave" cssClass="w3-container" commandName="customer">
            <form:hidden path="customerID"  />

            <div class="w3-padding-8">
                <form:input path="customerName" cssClass="w3-input w3-border" placeholder="Customer Name" />
                <form:errors path="customerName" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />
                <form:input path="customerContactLastName" cssClass="w3-input w3-border" placeholder="Contact Last Name" />
                <form:errors path="customerContactLastName" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />
                <form:input path="customerContactFirstName" cssClass="w3-input w3-border" placeholder="Contact First Name" />
                <form:errors path="customerContactFirstName" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />
                <form:input path="phone" cssClass="w3-input w3-border" placeholder="Phone" />
                <form:errors path="phone" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />
                <form:input path="email" cssClass="w3-input w3-border" placeholder="Email" />
                <form:errors path="email" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />
                <form:input path="addressLine1" cssClass="w3-input w3-border" placeholder="Address Line 1" />
                <form:errors path="addressLine1" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />
                <form:input path="addressLine2" cssClass="w3-input w3-border" placeholder="Address Line 2" />
                <form:errors path="addressLine2" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />
                <form:input path="addressLine3" cssClass="w3-input w3-border" placeholder="Address Line 3" />
                <form:errors path="addressLine3" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />
                <form:input path="city" cssClass="w3-input w3-border" placeholder="City" />
                <form:errors path="city" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />
                <form:select path="State" cssClass="w3-input w3-border" cssStyle="w3-select w3-border" placeholder="State" >                    
                    <form:options items="${customer.statesMap}" />
                </form:select>

                <form:errors path="state" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />

                <form:input path="postalCode" cssClass="w3-input w3-border" placeholder="Postal Code" />
                <form:errors path="postalCode" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />
                <!--<form:input path="country" cssClass="w3-input w3-border" placeholder="Country" />
                <form:errors path="country" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />-->
                <form:input path="creditLimit" cssClass="w3-input w3-border" placeholder="Credit Limit" />
                <form:errors path="creditLimit" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" /> 
            </div>

            <div class="w3-padding-8">
                <button type="submit" class="w3-btn w3-padding w3-blue" style="width:120px">Save</button>
            </div>
        </form:form>

    </div>
</div>

<%@ include file="theme/footer.jsp" %>