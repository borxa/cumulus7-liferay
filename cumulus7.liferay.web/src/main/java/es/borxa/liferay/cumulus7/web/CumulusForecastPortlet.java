package es.borxa.liferay.cumulus7.web;

import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import es.borxa.liferay.cumulus7.web.constants.CumulusPortletKeys;
import es.borxa.liferay.cumulus7.web.service.CumulusService;
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
            "com.liferay.portlet.css-class-wrapper=portlet-cumulus-forecast",
            "com.liferay.portlet.display-category=category.cumulus",
            "com.liferay.portlet.header-portlet-css=/css/main.css",
            "com.liferay.portlet.instanceable=true",
            "javax.portlet.display-name=" + CumulusPortletKeys.FORECAST, 
            "javax.portlet.init-param.template-path=/",
            "javax.portlet.init-param.view-template=/forecast/view.jsp",
            "javax.portlet.resource-bundle=content.Language",
            "javax.portlet.security-role-ref=power-user,user"
        },
        service = Portlet.class
)
public class CumulusForecastPortlet extends MVCPortlet {

    @Override
    public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
            throws IOException, PortletException {

        System.out.println("doView");
        CumulusService service = new CumulusService();
        JSONObject json = service.getJSON("", 0);
        System.out.println("JSON: " + json.toString());
        super.doView(renderRequest, renderResponse);
    }
}