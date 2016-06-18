package es.borxa.liferay.cumulus7.web;

import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletResponseUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.util.ContentTypes;
import es.borxa.liferay.cumulus7.service.api.Cumulus;
import es.borxa.liferay.cumulus7.web.constants.CumulusPortletKeys;
import java.io.IOException;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 *
 * @author Borxa Varela Bouzas <borxa@varelabouzas.net>
 */
@Component(
        immediate = true,
        property = {
            "com.liferay.portlet.css-class-wrapper=portlet-cumulus-observations",
            "com.liferay.portlet.display-category=category.cumulus",
            "com.liferay.portlet.header-portlet-css=/css/main.css",
            "com.liferay.portlet.footer-portlet-javascript=/observations/js/main.js",
            "com.liferay.portlet.instanceable=true",
            "javax.portlet.display-name=" + CumulusPortletKeys.OBSERVATIONS,
            "javax.portlet.init-param.template-path=/",
            "javax.portlet.init-param.view-template=/observations/view.jsp",
            "javax.portlet.resource-bundle=content.Language",
            "javax.portlet.security-role-ref=power-user,user"
        },
        service = Portlet.class
)
public class CumulusObservationsPortlet extends MVCPortlet {
    
    private static final Log LOG = LogFactoryUtil.getLog(CumulusObservationsPortlet.class);
    private Cumulus service;
    
    @Override
    public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
            throws IOException, PortletException {

        JSONObject json = getCumulus().getJSON("http://meteo.a-revolta.es/cumulus7.json", 30);
        LOG.debug(json.toString());
        
        resourceResponse.setContentType(ContentTypes.APPLICATION_JSON);
        resourceResponse.addProperty(
                HttpHeaders.CACHE_CONTROL, HttpHeaders.CACHE_CONTROL_PUBLIC_VALUE);

        PortletResponseUtil.write(resourceResponse, json.toString());
    }

    public Cumulus getCumulus() {
        return service;
    }

    @Reference
    public void setCumulus(Cumulus cumulus) {
        service = cumulus;
    }
}
