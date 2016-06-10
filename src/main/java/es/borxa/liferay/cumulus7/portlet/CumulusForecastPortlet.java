package es.borxa.liferay.cumulus7.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import es.borxa.liferay.cumulus7.constants.CumulusPortletKeys;
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
            "com.liferay.portlet.instanceable=true",
            "com.liferay.portlet.preferences-owned-by-group=true",
            "com.liferay.portlet.private-request-attributes=false",
            "com.liferay.portlet.private-session-attributes=false",
            "com.liferay.portlet.render-weight=50",
            "com.liferay.portlet.use-default-template=true",
            "javax.portlet.display-name=cumulus-forecast", "javax.portlet.expiration-cache=0",
            "javax.portlet.init-param.template-path=/",
            "javax.portlet.init-param.view-template=/forecast/view.jsp",
            "javax.portlet.name=" + CumulusPortletKeys.FORECAST,
            "javax.portlet.resource-bundle=content.forecast.Language",
            "javax.portlet.security-role-ref=power-user,user"
        },
        service = Portlet.class
)
public class CumulusForecastPortlet extends MVCPortlet {

    @Override
    public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
            throws IOException, PortletException {

        System.out.println("doView");
        super.doView(renderRequest, renderResponse);
    }
}
