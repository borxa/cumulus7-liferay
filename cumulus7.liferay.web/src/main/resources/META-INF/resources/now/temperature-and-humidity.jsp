<%@ include file="/init.jsp" %>

<div class="container-fluid" data-json-uri="">
    <div class="row-fluid">
        <div class="col-md-4 col-xs-6"><liferay-ui:message key="temperature"/></div>
        <div class="col-md-4 col-xs-6" data-json="temp"><small><liferay-ui:message key="loading"/></small></div>
        <div class="col-md-4 col-xs-6"><liferay-ui:message key="humidity"/></div>
        <div class="col-md-4 col-xs-6" data-json="hum"><small><liferay-ui:message key="loading"/></small></div>
    </div>
    <div class="row-fluid">
        <div class="col-md-4 col-xs-6"><liferay-ui:message key="apparent-temperature"/></div>
        <div class="col-md-4 col-xs-6" data-json="aptemp"><small><liferay-ui:message key="loading"/></small></div>
        <div class="col-md-4 col-xs-6"><liferay-ui:message key="temperature-trend"/></div>
        <div class="col-md-4 col-xs-6" data-json="trend"><small><liferay-ui:message key="loading"/></small></div>
    </div>
</div>