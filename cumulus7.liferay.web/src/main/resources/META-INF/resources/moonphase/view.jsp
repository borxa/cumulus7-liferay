<%@ include file="/init.jsp" %>

<liferay-ui:error key="JSONDataNotFound" message="json-data-not-found" />

<h4>${moonphase}</h4>

<div class="text-center" style="background-color: black; max-width: 400px;">
    <img src="${renderRequest.contextPath}/moonphase/moon/${moonAge}.png" 
         alt="moon" />
</div>

<liferay-ui:message key="visible-percent" />: ${moonPercentAbs}%
(<liferay-ui:message key="age" /> ${moonAge} <liferay-ui:message key="days" />)