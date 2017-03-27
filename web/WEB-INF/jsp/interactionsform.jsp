<%-- 
    Document   : interactionsform
    Created on : Mar 8, 2017, 3:37:40 PM
    Author     : awood
--%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

<%@ include file="theme/header.jsp" %>

<header class="w3-container" style="padding-top:22px">
    <h5><b><i class="fa fa-dashboard"></i> Manage Interactions > Add Interaction</b></h5>
</header>

<div class="w3-row-padding w3-half w3-margin-bottom">

    <div class="w3-card-4">
        <div class="w3-container w3-blue">
            <h2>Interactions Information</h2>
        </div>

        <form:form method="post" action="/arwcrm/interactions/save" cssClass="w3-container" commandName="interactions">
            <div class="w3-padding-8">
                <c:choose>
                    <c:when test="${not empty interactions.customer}">
                        <form:hidden path="Customer_ID" />
                        <div class="w3-padding-8">
                            <label><b>Customer</b></label>
                            <div class="w3-panel w3-border">
                                <p><b>${interactions.customer}</b></p>
                            </div>
                        </div>
                    </c:when>

                    <c:otherwise>
                        <div class="w3-padding-8">
                            <label><b>Customer</b></label>
                            <form:select path="Customer_ID" cssClass="w3-select w3-border">
                                <form:option value="-1">Select Customer</form:option>
                                <form:options items="${interactions.customersMap}"  />
                            </form:select>
                        </div>
                    </c:otherwise>
                </c:choose> 

                <label><b>Contact Date</b></label>
                <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
                <link rel="stylesheet" href="/resources/demos/style.css">
                <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
                <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
                <script>
                    $(function () {
                        $("#contact_date").datepicker();
                    });
                </script>
                <form:input path="contact_date" cssClass="w3-input w3-border"  />
                <form:errors path="contact_date" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />
            </div>
            <div class="w3-padding-8">
                <label><b>Contact Person</b></label>
                <form:input path="first_name" cssClass="w3-input w3-border" placeholder="First Name" />
                <form:errors path="first_name" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />
                <form:input path="Last_name" cssClass="w3-input w3-border" placeholder="Last Name" />
                <form:errors path="Last_name" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />
            </div>
            <div class="w3-padding-8">
                <label><b>Contact Type</b></label>
                <form:select path="method_of_contact" cssClass="w3-select w3-border">
                    <form:option value="">Select Contact Method</form:option>
                    <form:options items="${interactions.method_of_contactMap}"  />
                </form:select>
            </div>
            <div class="w3-padding-8" >
                <label><b>Notes</b></label>
                <form:textarea path="notes" cssClass="w3-input w3-border" cssStyle="height: 100px"  />
                <form:errors path="notes" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />
            </div>

            <div class="w3-padding-8">
                <button type="submit" class="w3-btn w3-padding w3-blue" style="width:120px">Save</button>
            </div>
        </form:form>
    </div>

</div>

<%@ include file="theme/footer.jsp" %>






