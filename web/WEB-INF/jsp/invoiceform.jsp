<%-- 
    Document   : invoiceform
    Created on : Feb 9, 2017, 12:40:32 PM
    Author     : awood
--%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

<%@ include file="theme/header.jsp" %>

<header class="w3-container" style="padding-top:22px">
    <h5><b><i class="fa fa-dashboard"></i> Manage Invoices > Add Invoice</b></h5>
</header>

<div class="w3-row-padding w3-half w3-margin-bottom">

    <div class="w3-card-4">
        <div class="w3-container w3-blue">
            <h2>Invoice Information</h2>
        </div>

        <form:form method="post" action="save" cssClass="w3-container" commandName="invoice">
            <div class="w3-padding-8">
                <label><b>InvoiceID</b></label>
                <form:input path="InvoiceID" cssClass="w3-input w3-border" placeholder="InvoiceID"  />
                <form:errors path="InvoiceID" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />

                <div class="w3-padding-8">
                    <label><b>CustomerID</b></label>
                    <form:input path="customerId" cssClass="w3-input w3-border" placeholder="CustomerID"  />
                    <form:errors path="customerId" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />

                    <div class="w3-padding-8">
                        <label><b>InvoiceDate</b></label>
                        <form:input path="invoiceDate" cssClass="w3-input w3-border" placeholder="Invoice Date"  />
                        <form:errors path="invoiceDate" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />

                        <div class="w3-padding-8">
                            <label><b>BillingAddress</b></label>
                            <form:input path="billingAddress" cssClass="w3-input w3-border" placeholder="Billing Address"  />
                            <form:errors path="billingAddress" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />

                            <div class="w3-padding-8">
                                <label><b>BillingCity</b></label>
                                <form:input path="billingCity" cssClass="w3-input w3-border" placeholder="Billing City"  />
                                <form:errors path="billingCity" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />

                                <div class="w3-padding-8">
                                    <label><b>BillingState</b></label>
                                    <form:input path="billingState" cssClass="w3-input w3-border" placeholder="Billing State"  />
                                    <form:errors path="billingState" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />

                                    <div class="w3-padding-8">
                                        <label><b>BillingCountry</b></label>
                                        <form:input path="billingCountry" cssClass="w3-input w3-border" placeholder="Billing Country"  />
                                        <form:errors path="billingCountry" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />

                                        <div class="w3-padding-8">
                                            <label><b>BillingPostalCode</b></label>
                                            <form:input path="billingPostalCode" cssClass="w3-input w3-border" placeholder="Billing Postal Code"  />
                                            <form:errors path="billingPostalCode" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />

                                            <div class="w3-padding-8">
                                                <label><b>BillingPhone</b></label>
                                                <form:input path="billingPhone" cssClass="w3-input w3-border" placeholder="Billing Phone"  />
                                                <form:errors path="billingPhone" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />

                                                <div class="w3-padding-8">
                                                    <label><b>Fax</b></label>
                                                    <form:input path="fax" cssClass="w3-input w3-border" placeholder="Fax Number"  />
                                                    <form:errors path="fax" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />

                                                    <div class="w3-padding-8">
                                                        <label><b>Total</b></label>
                                                        <form:input path="total" cssClass="w3-input w3-border" placeholder="Invoice Total"  />
                                                        <form:errors path="total" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />
                                                    </div>

                                                    <div class="w3-padding-8">
                                                        <button type="submit" class="w3-btn w3-padding w3-blue" style="width:120px">Save</button>
                                                    </div>
                                                </form:form>
                                            </div>

                                        </div>

                                        <%@ include file="theme/footer.jsp" %>

