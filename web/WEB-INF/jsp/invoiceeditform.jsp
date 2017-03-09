<%-- 
    Document   : invoiceeditform
    Created on : Feb 9, 2017, 12:39:19 PM
    Author     : awood
--%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    

<%@ include file="theme/header.jsp" %>

<header class="w3-container" style="padding-top:22px">
    <h5><b><i class="fa fa-dashboard"></i> Manage Invoice > Edit Invoice</b></h5>
</header>

<div class="w3-row-padding w3-half w3-margin-bottom">

    <div class="w3-card-4">
        <div class="w3-container w3-blue">
            <h2>Invoice Information</h2>
        </div>

        <form:form method="POST" action="/arwcrm/invoice/editsave" cssClass="w3-container" commandName="invoice">
            <form:hidden path="InvoiceID"  />

            <div class="w3-padding-8">
                <!--<label><b>InvoiceID</b></label>-->

                <!--<form:input path="invoice" cssClass="w3-input w3-border"  />
                <form:errors path="invoice" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />              
                <form:input path="InvoiceID" cssClass="w3-input w3-border" placeholder="InvoiceID"  />
                <form:errors path="InvoiceID" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />-->
                <form:input path="PurchaseOrder" cssClass="w3-input w3-border" placeholder="Purchase Order" />
                <form:errors path="PurchaseOrder" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />                               
                <form:input path="customerId" cssClass="w3-input w3-border" placeholder="CustomerID"  />
                <form:errors path="customerId" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />            
                 
                 <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
                <link rel="stylesheet" href="/resources/demos/style.css">
                <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
                <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
                <script>
                    $(function () {
                        $("#InvoiceDate").datepicker();
                    });
                </script>                           
                
                <form:input path="InvoiceDate" cssClass="w3-input w3-border" placeholder="Invoice Date"  />
                <form:errors path="InvoiceDate" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />
                <form:input path="BillingAddress" cssClass="w3-input w3-border" placeholder="Billing Address"  />
                <form:errors path="BillingAddress" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />
                <form:input path="BillingCity" cssClass="w3-input w3-border" placeholder="Billing City"  />
                <form:errors path="BillingCity" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />
                <form:select path="BillingState" cssClass="w3-input w3-border" cssStyle="w3-select w3-border" placeholder="Billing State" >                    
                    <form:options items="${invoice.statesMap}" />
                </form:select>

                <form:errors path="BillingState" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />
                <form:input path="BillingCountry" cssClass="w3-input w3-border" placeholder="Billing Country"  />
                <form:errors path="BillingCountry" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />
                <form:input path="BillingPostalCode" cssClass="w3-input w3-border" placeholder="Billing Postal Code"  />
                <form:errors path="BillingPostalCode" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />
                <form:input path="BillingPhone" cssClass="w3-input w3-border" placeholder="Billing Phone"  />
                <form:errors path="BillingPhone" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />
                <form:input path="Fax" cssClass="w3-input w3-border" placeholder="Fax"  />
                <form:errors path="Fax" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />
                <form:input path="Total" cssClass="w3-input w3-border" placeholder="Total"  />
                <form:errors path="Total" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />
            </div>

            <div class="w3-padding-8">
                <button type="submit" class="w3-btn w3-padding w3-blue" style="width:120px">Save</button>
            </div>
        </form:form>
    </div>
</div>

<%@ include file="theme/footer.jsp" %>