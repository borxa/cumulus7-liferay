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
            "com.liferay.portlet.css-class-wrapper=portlet-cumulus-now",
            "com.liferay.portlet.display-category=category.cumulus",
            "com.liferay.portlet.header-portlet-css=/css/main.css",
            "com.liferay.portlet.footer-portlet-javascript=/js/main.js",
            "com.liferay.portlet.instanceable=true",
            "javax.portlet.name=" + CumulusPortletKeys.NOW,
            "javax.portlet.display-name=" + CumulusPortletKeys.NOW,
            "javax.portlet.init-param.template-path=/",
            "javax.portlet.init-param.view-template=/now/view.jsp",
            "javax.portlet.resource-bundle=content.Language",
            "javax.portlet.security-role-ref=power-user,user"
        },
        service = Portlet.class
)
public class CumulusNowPortlet extends MVCPortlet {

    private static final Log LOG = LogFactoryUtil.getLog(CumulusNowPortlet.class);
    private Cumulus service;

    @Override
    public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
            throws IOException, PortletException {

        JSONObject json = getCumulus().getJSON("http://revoltadosdices.es/meteo/cumulus7.json", 30);
        LOG.debug(json.toString());
        
        renderRequest.setAttribute("location", json.get("location"));
        renderRequest.setAttribute("forecastenc", json.get("forecastenc"));
        renderRequest.setAttribute("latitude", json.get("latitude"));
        renderRequest.setAttribute("longitude", json.get("longitude"));
        renderRequest.setAttribute("altitude", json.get("altitude"));
        renderRequest.setAttribute("issunup", json.get("issunup"));
        renderRequest.setAttribute("bearingrangefrom10", json.get("bearingrangefrom10"));
        renderRequest.setAttribute("bearingrangefrom", json.get("bearingrangefrom"));
        renderRequest.setAttribute("bearingrangeto10", json.get("bearingrangeto10"));
        renderRequest.setAttribute("bearingrangeto", json.get("bearingrangeto"));
        
        
        super.doView(renderRequest, renderResponse);
    }

    public Cumulus getCumulus() {
        return service;
    }

    @Reference
    protected void setCumulus(Cumulus cumulus) {
        service = cumulus;
    }

    protected void unsetCumulus(Cumulus cumulus) {
        service = null;
    }
}
