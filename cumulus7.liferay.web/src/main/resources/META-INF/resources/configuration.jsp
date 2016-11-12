<%@ include file="/init.jsp" %>

<liferay-portlet:actionURL portletConfiguration="true" var="configurationURL" />

<aui:form action="${configurationURL}" method="post" name="fm">
    <aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
    <aui:input name="preferences--dataUrl--" type="text" 
               value="${portletPreferences.getValue('dataUrl','http://meteo.a-revolta.es/data.json')}" />
    <aui:select name="preferences--currentWebTags--">
        <c:forEach var="webTag" items="${['system','now','forecast','moonphase','observations','today','yesterday']}">
            <aui:option label="${webTag}" value="${webTag}" selected="${webTag == portletPreferences.getValue('currentWebTags','system')}" />
        </c:forEach>
    </aui:select>
    <aui:input name="preferences--cacheTime--" type="text" 
               value="${portletPreferences.getValue('cacheTime','0')}" />
    <aui:button-row cssClass="button-row-center">
        <aui:button type="submit" value="save" />
    </aui:button-row>
    
</aui:form>