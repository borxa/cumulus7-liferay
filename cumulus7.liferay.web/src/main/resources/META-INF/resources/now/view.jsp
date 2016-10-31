<%@ include file="/init.jsp" %>

<liferay-ui:error key="JSONDataNotFound" message="json-data-not-found" />

<div class="well">
    <h4>${location}</h4>
    <h5><liferay-ui:message key="forecast"/>: ${forecastenc}</h5>
    <h6><liferay-ui:message key="date"/>: ${time}</h6>
</div>
<liferay-ui:tabs names="temperature-and-humidity,rainfall,wind,pressure-sea-level,astronomical-information" type="pills" refresh="false">
    <liferay-ui:section>
        <jsp:include page="/now/temperature-and-humidity.jsp"/>
    </liferay-ui:section> 
    <liferay-ui:section>
        <jsp:include page="/now/rainfall.jsp"/>
    </liferay-ui:section> 
    <liferay-ui:section>
        <jsp:include page="/now/wind.jsp"/>
    </liferay-ui:section> 
    <liferay-ui:section>
        <jsp:include page="/now/pressure-sea-level.jsp"/>
    </liferay-ui:section> 
    <liferay-ui:section>
        <jsp:include page="/now/astronomical-information.jsp"/>
    </liferay-ui:section> 
</liferay-ui:tabs>
<div class="container-fluid">
    <div class="row-fluid">
        <div class="col-md-8"><liferay-ui:message key="latitude"/></div>
        <div class="col-md-4 text-right">${latitude}</div>
    </div>
    <div class="row-fluid">
        <div class="col-md-8"><liferay-ui:message key="longitude"/></div>
        <div class="col-md-4 text-right">${longitude}</div>
    </div>
    <div class="row-fluid">
        <div class="col-md-8"><liferay-ui:message key="altitude"/></div>
        <div class="col-md-4 text-right">${altitude}</div>
    </div>
</div>