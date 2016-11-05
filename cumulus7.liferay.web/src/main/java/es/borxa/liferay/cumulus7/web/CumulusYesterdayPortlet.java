package es.borxa.liferay.cumulus7.web;

import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import es.borxa.liferay.cumulus7.service.api.Cumulus;
import es.borxa.liferay.cumulus7.web.constants.CumulusPortletKeys;
import java.io.IOException;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 *
 * @author Borxa Varela Bouzas <borxa@varelabouzas.net>
 */
@Component(
        immediate = true,
        property = {
            "com.liferay.portlet.css-class-wrapper=portlet-cumulus-yesterday",
            "com.liferay.portlet.display-category=category.cumulus",
            "com.liferay.portlet.header-portlet-css=/css/main.css",
            "com.liferay.portlet.instanceable=true",
            "javax.portlet.name=" + CumulusPortletKeys.YESTERDAY,
            "javax.portlet.display-name=" + CumulusPortletKeys.YESTERDAY,
            "javax.portlet.init-param.template-path=/",
            "javax.portlet.init-param.view-template=/yesterday/view.jsp",
            "javax.portlet.resource-bundle=content.Language",
            "javax.portlet.security-role-ref=power-user,user"
        },
        service = Portlet.class
)
public class CumulusYesterdayPortlet extends MVCPortlet {

    private static final Log LOG = LogFactoryUtil.getLog(CumulusYesterdayPortlet.class);
    private Cumulus service;

    @Override
    public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
            throws IOException, PortletException {

        JSONObject json = getCumulus().getJSON("http://meteo.a-revolta.es/cumulus7.json", 30);
        LOG.debug(json.toString());

        renderRequest.setAttribute("tempyh", json.get("tempyh"));
        renderRequest.setAttribute("ttempyh", json.get("ttempyh"));
        renderRequest.setAttribute("tempyl", json.get("tempyl"));
        renderRequest.setAttribute("ttempyl", json.get("ttempyl"));
        renderRequest.setAttribute("avgtempy", json.get("avgtempy"));
        renderRequest.setAttribute("temprangey", json.get("temprangey"));
        renderRequest.setAttribute("apptempyh", json.get("apptempyh"));
        renderRequest.setAttribute("tapptempyh", json.get("tapptempyh"));
        renderRequest.setAttribute("apptempyl", json.get("apptempyl"));
        renderRequest.setAttribute("tapptempyl", json.get("tapptempyl"));
        renderRequest.setAttribute("ttempyh", json.get("ttempyh"));
        renderRequest.setAttribute("heatindexyh", json.get("heatindexyh"));
        renderRequest.setAttribute("theatindexyh", json.get("theatindexyh"));
        renderRequest.setAttribute("wchillyl", json.get("wchillyl"));
        renderRequest.setAttribute("twchillyl", json.get("twchillyl"));
        renderRequest.setAttribute("ttempyh", json.get("ttempyh"));
        renderRequest.setAttribute("dewpointyh", json.get("dewpointyh"));
        renderRequest.setAttribute("tdewpointyh", json.get("tdewpointyh"));
        renderRequest.setAttribute("dewpointyl", json.get("dewpointyl"));
        renderRequest.setAttribute("tdewpointyl", json.get("tdewpointyl"));
        renderRequest.setAttribute("tempyh", json.get("tempyh"));
        renderRequest.setAttribute("humyh", json.get("humyh"));
        renderRequest.setAttribute("thumyh", json.get("thumyh"));
        renderRequest.setAttribute("humyl", json.get("humyl"));
        renderRequest.setAttribute("thumyl", json.get("thumyl"));
        renderRequest.setAttribute("tdewpointyh", json.get("tdewpointyh"));
        renderRequest.setAttribute("heatdegdaysy", json.get("heatdegdaysy"));
        renderRequest.setAttribute("cooldegdaysy", json.get("cooldegdaysy"));

        renderRequest.setAttribute("rfally", json.get("rfally"));
        renderRequest.setAttribute("rrateym", json.get("rrateym"));
        renderRequest.setAttribute("trrateym", json.get("trrateym"));
        renderRequest.setAttribute("hourlyrainyh", json.get("hourlyrainyh"));
        renderRequest.setAttribute("thourlyrainyh", json.get("thourlyrainyh"));

        renderRequest.setAttribute("wgustym", json.get("wgustym"));
        renderRequest.setAttribute("twgustym", json.get("twgustym"));
        renderRequest.setAttribute("windym", json.get("windym"));
        renderRequest.setAttribute("twindym", json.get("twindym"));
        renderRequest.setAttribute("bearingym", json.get("bearingym"));
        renderRequest.setAttribute("twgustym", json.get("twgustym"));
        renderRequest.setAttribute("domwinddiry", json.get("domwinddiry"));
        renderRequest.setAttribute("windruny", json.get("windruny"));
        renderRequest.setAttribute("ybeaufort", json.get("ybeaufort"));
        renderRequest.setAttribute("ybeaudesc", json.get("ybeaudesc"));

        renderRequest.setAttribute("pressyh", json.get("pressyh"));
        renderRequest.setAttribute("tpressyh", json.get("tpressyh"));
        renderRequest.setAttribute("pressyl", json.get("pressyl"));
        renderRequest.setAttribute("tpressyl", json.get("tpressyl"));

        super.doView(renderRequest, renderResponse);
    }

    public Cumulus getCumulus() {
        return service;
    }

    @Reference
    public void setCumulus(Cumulus cumulus) {
        service = cumulus;
    }

}
