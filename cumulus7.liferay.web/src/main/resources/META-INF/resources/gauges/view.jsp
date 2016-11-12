<%@ include file="/init.jsp" %>

<liferay-portlet:resourceURL id="/json/cumulus" var="resourceURL"/>

<div class="gauges-json-block-url" data-href="${resourceURL}">
    <h4 class="well well-small"><liferay-ui:message key="now"/></h4>
    <p data-json="temp" data-unit="&#8451;" data-break1="15" data-break2="28" data-break3="35" data-min="-5" data-max="40">
        <liferay-ui:message key="ext-temperature"/>
    </p>
    <p data-json="intemp" data-unit="&#8451;" data-break1="17" data-break2="24" data-break3="30" data-min="5" data-max="40">
        <liferay-ui:message key="int-temperature"/>
    </p>
    <p data-json="hum" data-unit="%" data-break1="25" data-break2="60" data-break3="95" data-min="0" data-max="100">
        <liferay-ui:message key="ext-humidity"/>
    </p>
    <p data-json="inhum" data-unit="%" data-break1="25" data-break2="60" data-break3="95" data-min="0" data-max="100">
        <liferay-ui:message key="int-humidity"/>
    </p>
    <p data-json="press" data-unit="hpa" data-break1="1000" data-break2="1020" data-break3="1030" data-min="980" data-max="1040">
        <liferay-ui:message key="pressure-sea-level"/>
    </p>
    <p data-json="wgust" data-unit="km/h" data-break1="5" data-break2="15" data-break3="30" data-min="0" data-max="40">
        <liferay-ui:message key="wind-gust"/>
    </p>
    <p data-json="rhour" data-unit="l/m<sup>2</sup>" data-break1="5" data-break2="15" data-break3="25" data-min="0" data-max="30">
        <liferay-ui:message key="rfall-last-hour"/>
    </p>
</div>
