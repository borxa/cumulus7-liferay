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
            "com.liferay.portlet.css-class-wrapper=portlet-cumulus-moonphase",
            "com.liferay.portlet.display-category=category.cumulus",
            "com.liferay.portlet.header-portlet-css=/css/main.css",
            "com.liferay.portlet.instanceable=true",
            "javax.portlet.name=" + CumulusPortletKeys.MOONPHASE,
            "javax.portlet.display-name=" + CumulusPortletKeys.MOONPHASE,
            "javax.portlet.init-param.template-path=/",
            "javax.portlet.init-param.view-template=/moonphase/view.jsp",
            "javax.portlet.resource-bundle=content.Language",
            "javax.portlet.security-role-ref=power-user,user"
        },
        service = Portlet.class
)
public class CumulusMoonphasePortlet extends MVCPortlet {
    
    private static final Log LOG = LogFactoryUtil.getLog(CumulusMoonphasePortlet.class);
    private Cumulus service;
    
    @Override
    public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
            throws IOException, PortletException {

        JSONObject json = getCumulus().getJSON("http://revoltadosdices.es/meteo/cumulus7.json", 30);
        LOG.debug(json.toString());
        
        renderRequest.setAttribute("moonphase", json.get("moonphase"));
        renderRequest.setAttribute("moonPercentAbs", json.get("moonpercentabs"));
        renderRequest.setAttribute("moonAge", json.get("moonage"));
        
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
