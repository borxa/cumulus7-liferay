<%@ include file="/init.jsp" %>

<liferay-ui:error key="JSONDataNotFound" message="json-data-not-found" />
<liferay-portlet:resourceURL id="/json/cumulus" var="resourceURL"/>

<div class="json-block-url" data-href="${resourceURL}">
    <div class="well">
        <h4>${location}</h4>
        <h5><liferay-ui:message key="forecast"/>: ${forecastenc}</h5>
        <h6><liferay-ui:message key="date"/>: <span data-json="time"><small><liferay-ui:message key="loading"/></small></span></h6>
    </div>
    <liferay-ui:tabs names="temperature-and-humidity,rainfall,wind,pressure-sea-level,astronomical-information" type="pills" refresh="false">
        <liferay-ui:section>
            <%@ include file="/now/temperature-and-humidity.jspf" %>
        </liferay-ui:section> 
        <liferay-ui:section>
            <%@ include file="/now/rainfall.jspf" %>
        </liferay-ui:section> 
        <liferay-ui:section>
            <%@ include file="/now/wind.jspf" %>
        </liferay-ui:section> 
        <liferay-ui:section>
            <%@ include file="/now/pressure-sea-level.jspf" %>
        </liferay-ui:section> 
        <liferay-ui:section>
            <%@ include file="/now/astronomical-information.jspf" %>
        </liferay-ui:section> 
    </liferay-ui:tabs>
    <div class="container-fluid">
        <div class="row-fluid">
            <div class="col-md-8 col-xs-7"><liferay-ui:message key="latitude"/></div>
            <div class="col-md-4 col-xs-5 text-right">${latitude}</div>
        </div>
        <div class="row-fluid">
            <div class="col-md-8 col-xs-7"><liferay-ui:message key="longitude"/></div>
            <div class="col-md-4 col-xs-5 text-right">${longitude}</div>
        </div>
        <div class="row-fluid">
            <div class="col-md-8 col-xs-7"><liferay-ui:message key="altitude"/></div>
            <div class="col-md-4 col-xs-5 text-right">${altitude}</div>
        </div>
    </div>
</div>