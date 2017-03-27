<%-- 
    Document   : interactionseditform
    Created on : Mar 8, 2017, 3:38:17 PM
    Author     : awood
--%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

<%@ include file="theme/header.jsp" %>

<header class="w3-container" style="padding-top:22px">
    <h5><b><i class="fa fa-dashboard"></i> Manage Interactions > Add Interactions</b></h5>
</header>

<div class="w3-row-padding w3-half w3-margin-bottom">

    <div class="w3-card-4">
        <div class="w3-container w3-blue">
            <h2>Interactions Information</h2>
        </div>

        <form:form method="post" action="/arwcrm/interactions/editsave" cssClass="w3-container" commandName="interactions">
            <div class="w3-padding-8">
               <label><b>Interactions ID</b></label>

                <form:input path="first_name" cssClass="w3-input w3-border" placeholder="First Name" />
                <form:errors path="first_name" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />
                <form:input path="last_name" cssClass="w3-input w3-border" placeholder="Last Name"  />
                <form:errors path="last_name" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />
                <form:input path="status" cssClass="w3-input w3-border" placeholder="Status"  />
                <form:errors path="status" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />
                <form:input path="method_of_contact" cssClass="w3-input w3-border" placeholder="Method of Conduct"  />
                <form:errors path="method_of_contact" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />
                <form:input path="email" cssClass="w3-input w3-border" placeholder="Email"  />
                <form:errors path="email" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />
                <form:input path="phone" cssClass="w3-input w3-border" cssStyle="w3-select w3-border" placeholder="Phone" />                    
                <form:errors path="phone" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />
                <form:input path="notes" cssClass="w3-input w3-border" placeholder="Notes"  />
                <form:errors path="notes" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />
                <!--<form:input path="contact_type" cssClass="w3-input w3-border" placeholder="Contact Type"  />
                <form:errors path="contact_type" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />-->

                <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
                <link rel="stylesheet" href="/resources/demos/style.css">
                <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
                <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
                <script>
                    $(function () {
                        $("#contact_date").datepicker();
                    });
                </script>

                <form:input path="contact_date" cssClass="w3-input w3-border" placeholder="Contact Date"  />
                <form:errors path="contact_date" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />
                <form:input path="CustomerID" cssClass="w3-input w3-border" placeholder="CustomerID"  />
                <form:errors path="CustomerID" cssClass="w3-red w3-padding-8 w3-panel" cssStyle="display: block; width: 100%; font-weight:bold;" />
            </div>

            <div class="w3-padding-8">
                <button type="submit" class="w3-btn w3-padding w3-blue" style="width:120px">Save</button>
            </div>
        </form:form>
    </div>

</div>

<%@ include file="theme/footer.jsp" %>
