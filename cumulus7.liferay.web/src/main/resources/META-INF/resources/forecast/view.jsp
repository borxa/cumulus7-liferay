<%@ include file="/init.jsp" %>

<liferay-ui:error key="JSONDataNotFound" message="json-data-not-found" />

<div class="text-center">
    <img id="forecast-img" src="${renderRequest.contextPath}/forecast/img/forecast_${isdaylight}_${forecastnumber}.png" 
         alt="forecast" />
</div>

<liferay-ui:message key="forecast" />