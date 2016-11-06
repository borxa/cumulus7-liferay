<%@ include file="/init.jsp" %>

<liferay-ui:error key="JSONDataNotFound" message="json-data-not-found" />

<liferay-ui:panel title="temperature-and-humidity" state="close">
    <div class="container-fluid">
        <div class="row-fluid">
            <div class="col-md-6"><liferay-ui:message key="high-temperature"/></div>
            <div class="col-md-3 text-right">${tempyh} &#8451;</div>
            <div class="col-md-3 text-right">${ttempyh}</div>
        </div>
        <div class="row-fluid">
            <div class="col-md-6"><liferay-ui:message key="low-temperature"/></div>
            <div class="col-md-3 text-right">${tempyl} &#8451;</div>
            <div class="col-md-3 text-right">${ttempyl}</div>
        </div>
        <div class="row-fluid">
            <div class="col-md-6"><liferay-ui:message key="average-temperature"/></div>
            <div class="col-md-3 text-right">${avgtempy} &#8451;</div>
        </div>
        <div class="row-fluid">
            <div class="col-md-6"><liferay-ui:message key="temperature-range"/></div>
            <div class="col-md-3 text-right">${temprangey} &#8451;</div>
        </div>
        <div class="row-fluid">
            <div class="col-md-6"><liferay-ui:message key="high-apparent-temperature"/></div>
            <div class="col-md-3 text-right">${apptempyh} &#8451;</div>
            <div class="col-md-3 text-right">${tapptempyh}</div>
        </div>
        <div class="row-fluid">
            <div class="col-md-6"><liferay-ui:message key="low-apparent-temperature"/></div>
            <div class="col-md-3 text-right">${apptempyl} &#8451;</div>
            <div class="col-md-3 text-right">${tapptempyl}</div>
        </div>
        <div class="row-fluid">
            <div class="col-md-6"><liferay-ui:message key="high-heat-index"/></div>
            <div class="col-md-3 text-right">${heatindexyh} &#8451;</div>
            <div class="col-md-3 text-right">${theatindexyh}</div>
        </div>
        <div class="row-fluid">
            <div class="col-md-6"><liferay-ui:message key="low-wind-chill"/></div>
            <div class="col-md-3 text-right">${wchillyl} &#8451;</div>
            <div class="col-md-3 text-right">${twchillyl}</div>
        </div>
        <div class="row-fluid">
            <div class="col-md-6"><liferay-ui:message key="maximum-dew-point"/></div>
            <div class="col-md-3 text-right">${dewpointyh} &#8451;</div>
            <div class="col-md-3 text-right">${tdewpointyh}</div>
        </div>
        <div class="row-fluid">
            <div class="col-md-6"><liferay-ui:message key="minimum-dew-point"/></div>
            <div class="col-md-3 text-right">${dewpointyl} &#8451;</div>
            <div class="col-md-3 text-right">${tdewpointyl}</div>
        </div>
        <div class="row-fluid">
            <div class="col-md-6"><liferay-ui:message key="high-humidity"/></div>
            <div class="col-md-3 text-right">${humyh} %</div>
            <div class="col-md-3 text-right">${thumyh}</div>
        </div>
        <div class="row-fluid">
            <div class="col-md-6"><liferay-ui:message key="low-humidity"/></div>
            <div class="col-md-3 text-right">${humyl} %</div>
            <div class="col-md-3 text-right">${thumyl}</div>
        </div>
        <div class="row-fluid">
            <div class="col-md-6"><liferay-ui:message key="heat-degree-days"/></div>
            <div class="col-md-3 text-right">${heatdegdaysy} &#8451;</div>
        </div>
        <div class="row-fluid">
            <div class="col-md-6"><liferay-ui:message key="cool-degreee-days"/></div>
            <div class="col-md-3 text-right">${cooldegdaysy} &#8451;</div>
        </div>
    </div>
</liferay-ui:panel>

<liferay-ui:panel title="rainfall" state="close">
    <div class="container-fluid">
        <div class="row-fluid">
            <div class="col-md-6"><liferay-ui:message key="rainfall-today"/></div>
            <div class="col-md-3 text-right">${rfally} l/m<sup>2</sup></div>
        </div>
        <div class="row-fluid">
            <div class="col-md-6"><liferay-ui:message key="rainfall-rate-max"/></div>
            <div class="col-md-3 text-right">${rrateym} l/m<sup>2</sup></div>
            <div class="col-md-3 text-right">${trrateym}</div>
        </div>
        <div class="row-fluid">
            <div class="col-md-6"><liferay-ui:message key="high-hourly-rainfall"/></div>
            <div class="col-md-3 text-right">${hourlyrainyh} l/m<sup>2</sup></div>
            <div class="col-md-3 text-right">${thourlyrainyh}</div>
        </div>
    </div>
</liferay-ui:panel>

<liferay-ui:panel title="wind" state="close">
    <div class="container-fluid">
        <div class="row-fluid">
            <div class="col-md-6"><liferay-ui:message key="highest-gust"/></div>
            <div class="col-md-3 text-right">${wgustym} km/h</div>
            <div class="col-md-3 text-right">${twgustym}</div>
        </div> 
        <div class="row-fluid">
            <div class="col-md-6"><liferay-ui:message key="highest-speed"/></div>
            <div class="col-md-3 text-right">${windym} km/h</div>
            <div class="col-md-3 text-right">${twindym}</div>
        </div>
        <div class="row-fluid">
            <div class="col-md-6"><liferay-ui:message key="wind-bearing"/></div>
            <div class="col-md-3 text-right">${bearingym} &deg;</div>
            <div class="col-md-3 text-right">${twgustym}</div>
        </div> 
        <div class="row-fluid">
            <div class="col-md-6"><liferay-ui:message key="dominat-direction"/></div>
            <div class="col-md-3 text-right">${domwinddiry}</div>
        </div>  
        <div class="row-fluid">
            <div class="col-md-6"><liferay-ui:message key="wind-run"/></div>
            <div class="col-md-3 text-right">${windruny} km</div>
        </div>    
        <div class="row-fluid">
            <div class="col-md-6"><liferay-ui:message key="beaufort-scale"/></div>
            <div class="col-md-3 text-right">${ybeaufort}</div>
            <div class="col-md-3 text-right">${ybeaudesc}</div>
        </div>  
    </div>
</liferay-ui:panel>

<liferay-ui:panel title="pressure-sea-level" state="close">
    <div class="container-fluid">
        <div class="row-fluid">
            <div class="col-md-6"><liferay-ui:message key="high-pressure"/></div>
            <div class="col-md-3 text-right">${pressyh} hpa</div>
            <div class="col-md-3 text-right">${tpressyh}</div>
        </div>
        <div class="row-fluid">
            <div class="col-md-6"><liferay-ui:message key="low-pressure"/></div>
            <div class="col-md-3 text-right">${pressyl} hpa</div>
            <div class="col-md-3 text-right">${tpressyl}</div>
        </div>
    </div>
</liferay-ui:panel>