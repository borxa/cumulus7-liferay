package es.borxa.liferay.cumulus7.web;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import es.borxa.liferay.cumulus7.web.constants.CumulusPortletKeys;
import java.io.IOException;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import org.osgi.service.component.annotations.Component;

/**
 *
 * @author Borxa Varela Bouzas <borxa@varelabouzas.net>
 */
@Component(
        immediate = true,
        property = {
            "com.liferay.portlet.css-class-wrapper=portlet-cumulus-charts",
            "com.liferay.portlet.display-category=category.cumulus",
            "com.liferay.portlet.header-portlet-css=/css/main.css",
            "com.liferay.portlet.footer-portlet-javascript=/js/main.js",
            "com.liferay.portlet.instanceable=true",
            "javax.portlet.name=" + CumulusPortletKeys.CHARTS,
            "javax.portlet.display-name=" + CumulusPortletKeys.CHARTS,
            "javax.portlet.init-param.template-path=/",
            "javax.portlet.init-param.view-template=/charts/view.jsp",
            "javax.portlet.resource-bundle=content.Language",
            "javax.portlet.security-role-ref=power-user,user"
        },
        service = Portlet.class
)
public class CumulusChartsPortlet extends MVCPortlet {
    
    private static final Log LOG = LogFactoryUtil.getLog(CumulusChartsPortlet.class);

    @Override
    public void doView(RenderRequest renderRequest, RenderResponse renderResponse) 
            throws IOException, PortletException {
        
        String baseUrl = "http://meteo.a-revolta.es/images/";
        renderRequest.setAttribute("dataUrl", baseUrl);
        LOG.debug("URL base for images: " + baseUrl);
        
        super.doView(renderRequest, renderResponse);
    }
    
}
