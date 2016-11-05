<%@ include file="/init.jsp" %>

<liferay-ui:error key="JSONDataNotFound" message="json-data-not-found" />

<liferay-ui:panel title="temperature-and-humidity" state="close">
    <div class="container-fluid">
        <div class="row-fluid">
            <div class="col-md-6"><liferay-ui:message key="high-temperature"/></div>
            <div class="col-md-3 text-right">${tempth} ºC</div>
            <div class="col-md-3 text-right">${ttempth}</div>
        </div>
        <div class="row-fluid">
            <div class="col-md-6"><liferay-ui:message key="low-temperature"/></div>
            <div class="col-md-3 text-right">${temptl} ºC</div>
            <div class="col-md-3 text-right">${ttemptl}</div>
        </div>
        <div class="row-fluid">
            <div class="col-md-6"><liferay-ui:message key="average-temperature"/></div>
            <div class="col-md-3 text-right">${avgtemp} ºC</div>
        </div>
        <div class="row-fluid">
            <div class="col-md-6"><liferay-ui:message key="temperature-range"/></div>
            <div class="col-md-3 text-right">${temprange} ºC</div>
        </div>
        <div class="row-fluid">
            <div class="col-md-6"><liferay-ui:message key="high-apparent-temperature"/></div>
            <div class="col-md-3 text-right">${apptempth} ºC</div>
            <div class="col-md-3 text-right">${tapptempth}</div>
        </div>
        <div class="row-fluid">
            <div class="col-md-6"><liferay-ui:message key="low-apparent-temperature"/></div>
            <div class="col-md-3 text-right">${apptemptl} ºC</div>
            <div class="col-md-3 text-right">${tapptemptl}</div>
        </div>
        <div class="row-fluid">
            <div class="col-md-6"><liferay-ui:message key="high-heat-index"/></div>
            <div class="col-md-3 text-right">${heatindexth} ºC</div>
            <div class="col-md-3 text-right">${theatindexth}</div>
        </div>
        <div class="row-fluid">
            <div class="col-md-6"><liferay-ui:message key="low-wind-chill"/></div>
            <div class="col-md-3 text-right">${wchilltl} ºC</div>
            <div class="col-md-3 text-right">${twchilltl}</div>
        </div>
        <div class="row-fluid">
            <div class="col-md-6"><liferay-ui:message key="maximum-dew-point"/></div>
            <div class="col-md-3 text-right">${dewpointth} ºC</div>
            <div class="col-md-3 text-right">${tdewpointth}</div>
        </div>
        <div class="row-fluid">
            <div class="col-md-6"><liferay-ui:message key="minimum-dew-point"/></div>
            <div class="col-md-3 text-right">${dewpointtl} ºC</div>
            <div class="col-md-3 text-right">${tdewpointtl}</div>
        </div>
        <div class="row-fluid">
            <div class="col-md-6"><liferay-ui:message key="high-humidity"/></div>
            <div class="col-md-3 text-right">${humth} %</div>
            <div class="col-md-3 text-right">${thumth}</div>
        </div>
        <div class="row-fluid">
            <div class="col-md-6"><liferay-ui:message key="low-humidity"/></div>
            <div class="col-md-3 text-right">${humtl} %</div>
            <div class="col-md-3 text-right">${thumtl}</div>
        </div>
        <div class="row-fluid">
            <div class="col-md-6"><liferay-ui:message key="heat-degree-days"/></div>
            <div class="col-md-3 text-right">${heatdegdays} ºC</div>
        </div>
        <div class="row-fluid">
            <div class="col-md-6"><liferay-ui:message key="cool-degreee-days"/></div>
            <div class="col-md-3 text-right">${cooldegdays} ºC</div>
        </div>
    </div>
</liferay-ui:panel>

<liferay-ui:panel title="rainfall" state="close">
    <div class="container-fluid">
        <div class="row-fluid">
            <div class="col-md-6"><liferay-ui:message key="rainfall-today"/></div>
            <div class="col-md-3 text-right">${rfall} l/m2</div>
        </div>
        <div class="row-fluid">
            <div class="col-md-6"><liferay-ui:message key="rainfall-rate-max"/></div>
            <div class="col-md-3 text-right">${rratetm} l/m2</div>
            <div class="col-md-3 text-right">${trratetm}</div>
        </div>
        <div class="row-fluid">
            <div class="col-md-6"><liferay-ui:message key="high-hourly-rainfall"/></div>
            <div class="col-md-3 text-right">${hourlyrainth} l/m2</div>
            <div class="col-md-3 text-right">${thourlyrainth}</div>
        </div> 
        <div class="row-fluid">
            <div class="col-md-6"><liferay-ui:message key="current-wet-spell"/></div>
            <div class="col-md-3 text-right">${consecutiveraindays}</div>
        </div>  
        <div class="row-fluid">
            <div class="col-md-6"><liferay-ui:message key="current-dry-spell"/></div>
            <div class="col-md-3 text-right">${consecutivedrydays}</div>
        </div>
    </div>
</liferay-ui:panel>

<liferay-ui:panel title="wind" state="close">
    <div class="container-fluid">
        <div class="row-fluid">
            <div class="col-md-6"><liferay-ui:message key="highest-gust"/></div>
            <div class="col-md-3 text-right">${wgusttm} km/h</div>
            <div class="col-md-3 text-right">${twgusttm}</div>
        </div> 
        <div class="row-fluid">
            <div class="col-md-6"><liferay-ui:message key="highest-speed"/></div>
            <div class="col-md-3 text-right">${windtm} km/h</div>
            <div class="col-md-3 text-right">${twindtm}</div>
        </div>
        <div class="row-fluid">
            <div class="col-md-6"><liferay-ui:message key="wind-bearing"/></div>
            <div class="col-md-3 text-right">${bearingtm}º</div>
            <div class="col-md-3 text-right">${twgusttm}</div>
        </div> 
        <div class="row-fluid">
            <div class="col-md-6"><liferay-ui:message key="dominat-direction"/></div>
            <div class="col-md-3 text-right">${domwinddir}</div>
        </div>  
        <div class="row-fluid">
            <div class="col-md-6"><liferay-ui:message key="wind-run"/></div>
            <div class="col-md-3 text-right">${windrun} km</div>
        </div>    
        <div class="row-fluid">
            <div class="col-md-6"><liferay-ui:message key="beaufort-scale"/></div>
            <div class="col-md-3 text-right">${tbeaufort}</div>
            <div class="col-md-3 text-right">${tbeaudesc}</div>
        </div>  
    </div>
</liferay-ui:panel>

<liferay-ui:panel title="pressure-sea-level" state="close">
    <div class="container-fluid">
        <div class="row-fluid">
            <div class="col-md-6"><liferay-ui:message key="high-pressure"/></div>
            <div class="col-md-3 text-right">${pressth} hpa</div>
            <div class="col-md-3 text-right">${tpressth}</div>
        </div>
        <div class="row-fluid">
            <div class="col-md-6"><liferay-ui:message key="low-pressure"/></div>
            <div class="col-md-3 text-right">${presstl} hpa</div>
            <div class="col-md-3 text-right">${tpresstl}</div>
        </div>
    </div>
</liferay-ui:panel>