package net.borxa.liferay.cumulus7.web;

import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import net.borxa.liferay.cumulus7.service.api.Cumulus;
import net.borxa.liferay.cumulus7.web.constants.CumulusPortletKeys;
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
            "com.liferay.portlet.css-class-wrapper=portlet-cumulus-today",
            "com.liferay.portlet.display-category=category.cumulus",
            "com.liferay.portlet.header-portlet-css=/css/main.css",
            "com.liferay.portlet.instanceable=true",
            "javax.portlet.name=" + CumulusPortletKeys.TODAY,
            "javax.portlet.display-name=" + CumulusPortletKeys.TODAY,
            "javax.portlet.init-param.template-path=/",
            "javax.portlet.init-param.view-template=/today/view.jsp",
            "javax.portlet.resource-bundle=content.Language",
            "javax.portlet.security-role-ref=power-user,user"
        },
        service = Portlet.class
)
public class CumulusTodayPortlet extends MVCPortlet {

    private static final Log LOG = LogFactoryUtil.getLog(CumulusTodayPortlet.class);
    private Cumulus service;

    @Override
    public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
            throws IOException, PortletException {

        JSONObject json = getCumulus().getJSON("http://revoltadosdices.es/meteo/cumulus7.json", 30);
        LOG.debug(json.toString());
        
        renderRequest.setAttribute("tempth", json.get("tempth"));
        renderRequest.setAttribute("ttempth", json.get("ttempth"));
        renderRequest.setAttribute("temptl", json.get("temptl"));
        renderRequest.setAttribute("ttemptl", json.get("ttemptl"));
        renderRequest.setAttribute("avgtemp", json.get("avgtemp"));
        renderRequest.setAttribute("temprange", json.get("temprange"));
        renderRequest.setAttribute("apptempth", json.get("apptempth"));
        renderRequest.setAttribute("tapptempth", json.get("tapptempth"));
        renderRequest.setAttribute("apptemptl", json.get("apptemptl"));
        renderRequest.setAttribute("tapptemptl", json.get("tapptemptl"));
        renderRequest.setAttribute("ttempth", json.get("ttempth"));
        renderRequest.setAttribute("heatindexth", json.get("heatindexth"));
        renderRequest.setAttribute("theatindexth", json.get("theatindexth"));
        renderRequest.setAttribute("wchilltl", json.get("wchilltl"));
        renderRequest.setAttribute("twchilltl", json.get("twchilltl"));
        renderRequest.setAttribute("ttempth", json.get("ttempth"));
        renderRequest.setAttribute("dewpointth", json.get("dewpointth"));
        renderRequest.setAttribute("tdewpointth", json.get("tdewpointth"));
        renderRequest.setAttribute("dewpointtl", json.get("dewpointtl"));
        renderRequest.setAttribute("tdewpointtl", json.get("tdewpointtl"));
        renderRequest.setAttribute("tempth", json.get("tempth"));
        renderRequest.setAttribute("humth", json.get("humth"));
        renderRequest.setAttribute("thumth", json.get("thumth"));
        renderRequest.setAttribute("humtl", json.get("humtl"));
        renderRequest.setAttribute("thumtl", json.get("thumtl"));
        renderRequest.setAttribute("tdewpointth", json.get("tdewpointth"));
        renderRequest.setAttribute("heatdegdays", json.get("heatdegdays"));
        renderRequest.setAttribute("cooldegdays", json.get("cooldegdays"));
        
        renderRequest.setAttribute("rfall", json.get("rfall"));
        renderRequest.setAttribute("rratetm", json.get("rratetm"));
        renderRequest.setAttribute("trratetm", json.get("trratetm"));
        renderRequest.setAttribute("hourlyrainth", json.get("hourlyrainth"));
        renderRequest.setAttribute("thourlyrainth", json.get("thourlyrainth"));
        renderRequest.setAttribute("consecutiveraindays", json.get("consecutiveraindays"));
        renderRequest.setAttribute("consecutivedrydays", json.get("consecutivedrydays"));
        
        renderRequest.setAttribute("wgusttm", json.get("wgusttm"));
        renderRequest.setAttribute("twgusttm", json.get("twgusttm"));
        renderRequest.setAttribute("windtm", json.get("windtm"));
        renderRequest.setAttribute("twindtm", json.get("twindtm"));
        renderRequest.setAttribute("bearingtm", json.get("bearingtm"));
        renderRequest.setAttribute("twgusttm", json.get("twgusttm"));
        renderRequest.setAttribute("domwinddir", json.get("domwinddir"));
        renderRequest.setAttribute("windrun", json.get("windrun"));
        renderRequest.setAttribute("tbeaufort", json.get("tbeaufort"));
        renderRequest.setAttribute("tbeaudesc", json.get("tbeaudesc"));
        
        renderRequest.setAttribute("pressth", json.get("pressth"));
        renderRequest.setAttribute("tpressth", json.get("tpressth"));
        renderRequest.setAttribute("presstl", json.get("presstl"));
        renderRequest.setAttribute("tpresstl", json.get("tpresstl"));
        
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
