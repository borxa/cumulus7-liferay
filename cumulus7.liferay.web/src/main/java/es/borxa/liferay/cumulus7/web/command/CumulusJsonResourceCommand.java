package es.borxa.liferay.cumulus7.web.command;

import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletResponseUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.PortalUtil;
import es.borxa.liferay.cumulus7.service.api.Cumulus;
import es.borxa.liferay.cumulus7.web.constants.CumulusPortletKeys;
import java.io.IOException;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 *
 * @author borxa
 */
@Component(
    immediate = true,
    property = {
        "javax.portlet.name=" + CumulusPortletKeys.NOW,
        "javax.portlet.name=" + CumulusPortletKeys.OBSERVATIONS,
        "mvc.command.name=/json/cumulus"
    },
    service = MVCResourceCommand.class
)
public class CumulusJsonResourceCommand implements MVCResourceCommand {
    
    private static final Log LOG = LogFactoryUtil.getLog(CumulusJsonResourceCommand.class);
    private Cumulus service;

    @Override
    public boolean serveResource(ResourceRequest request, ResourceResponse response) 
            throws PortletException {
        boolean result = false;
        
        JSONObject json = getCumulus().getJSON("http://meteo.a-revolta.es/cumulus7.json", 30);
        LOG.debug(json.toString());
        
        response.setContentType(ContentTypes.APPLICATION_JSON);
        response.addProperty(
                HttpHeaders.CACHE_CONTROL, HttpHeaders.CACHE_CONTROL_PUBLIC_VALUE);

        try {
            PortletResponseUtil.write(response, json.toString());
            result = true;
        } catch (IOException ex) {      
            SessionErrors.add(PortalUtil.getHttpServletRequest(request).getSession(), "JSONDataNotFound");
            LOG.warn(ex.getMessage());
        }
        
        return result;
    }
    
    public Cumulus getCumulus() {
        return service;
    }

    @Reference
    public void setCumulus(Cumulus cumulus) {
        service = cumulus;
    }
}
