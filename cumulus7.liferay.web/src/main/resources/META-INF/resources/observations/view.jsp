<%@ include file="/init.jsp" %>

<liferay-ui:error key="JSONDataNotFound" message="json-data-not-found" />
<liferay-portlet:resourceURL var="resourceURL"/>

<table class="table table-hover">
    <tr>
        <td><liferay-ui:message key="temperature" /></td>
        <td class="temp text-right"><liferay-ui:message key="loading" />...</td>
    </tr>
    <tr>
        <td><liferay-ui:message key="int-temperature" /></td>
        <td class="intemp text-right"><liferay-ui:message key="loading" />...</td>
    </tr>
    <tr>
        <td><liferay-ui:message key="humidity" /></td>
        <td class="hum text-right"><liferay-ui:message key="loading" />...</td>
    </tr>
    <tr>
        <td><liferay-ui:message key="int-humidity" /></td>
        <td class="inhum text-right"><liferay-ui:message key="loading" />...</td>
    </tr>
    <tr>
        <td><liferay-ui:message key="wind-speed" /></td>
        <td class="wspeed text-right"><liferay-ui:message key="loading" />...</td>
    </tr>
    <tr>
        <td><liferay-ui:message key="current-wind-direction" /></td>
        <td class="currentwdir text-right"><liferay-ui:message key="loading" />...</td>
    </tr>
    <tr>
        <td><liferay-ui:message key="rfall-last-hour" /></td>
        <td class="rhour text-right"><liferay-ui:message key="loading" />...</td>
    </tr>
    <tr>
        <td><liferay-ui:message key="last-update" /></td>
        <td class="timehhmmss text-right"><liferay-ui:message key="loading" />...</td>
    </tr>
</table>
<aui:button cssClass="observations-json-link" data-href="${resourceURL}" value="refresh" />
