<%@ include file="/init.jsp" %>

<liferay-ui:error key="JSONDataNotFound" message="json-data-not-found" />
<liferay-portlet:resourceURL var="resourceURL"/>

<div class="portlet-cumulus-observations container-fluid">
    <div class="row-fluid">
        <div class="col-md-8"><liferay-ui:message key="temperature"/></div>
        <div class="temp col-md-4 text-right"><small><liferay-ui:message key="loading"/></small></div>
    </div>
    <div class="row-fluid">
        <div class="col-md-8"><liferay-ui:message key="int-temperature"/></div>
        <div class="intemp col-md-4 text-right"><small><liferay-ui:message key="loading"/></small></div>
    </div>
    <div class="row-fluid">
        <div class="col-md-8"><liferay-ui:message key="humidity"/></div>
        <div class="hum col-md-4 text-right"><small><liferay-ui:message key="loading"/></small></div>
    </div>
    <div class="row-fluid">
        <div class="col-md-8"><liferay-ui:message key="int-humidity"/></div>
        <div class="inhum col-md-4 text-right"><small><liferay-ui:message key="loading"/></small></div>
    </div>
    <div class="row-fluid">
        <div class="col-md-8"><liferay-ui:message key="wind-speed"/></div>
        <div class="wspeed col-md-4 text-right"><small><liferay-ui:message key="loading"/></small></div>
    </div>
    <div class="row-fluid">
        <div class="col-md-8"><liferay-ui:message key="current-wind-direction"/></div>
        <div class="currentwdir col-md-4 text-right"><small><liferay-ui:message key="loading"/></small></div>
    </div>
    <div class="row-fluid">
        <div class="col-md-8"><liferay-ui:message key="rfall-last-hour"/></div>
        <div class="rhour col-md-4 text-right"><small><liferay-ui:message key="loading"/></small></div>
    </div>
    <div class="row-fluid">
        <div class="col-md-8"><liferay-ui:message key="last-update"/></div>
        <div class="timehhmmss col-md-4 text-right"><small><liferay-ui:message key="loading"/></small></div>
    </div>
</div>
<aui:button cssClass="observations-json-link" data-href="${resourceURL}" value="refresh"/>
