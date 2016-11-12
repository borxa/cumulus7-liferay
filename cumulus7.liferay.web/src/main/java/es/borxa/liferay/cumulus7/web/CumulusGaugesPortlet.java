package es.borxa.liferay.cumulus7.web;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import es.borxa.liferay.cumulus7.web.constants.CumulusPortletKeys;
import javax.portlet.Portlet;
import org.osgi.service.component.annotations.Component;

/**
 *
 * @author Borxa Varela Bouzas <borxa@varelabouzas.net>
 */
@Component(
        immediate = true,
        property = {
            "com.liferay.portlet.css-class-wrapper=portlet-cumulus-gauges",
            "com.liferay.portlet.display-category=category.cumulus",
            "com.liferay.portlet.header-portlet-css=/css/main.css",
            "com.liferay.portlet.footer-portlet-javascript=/js/main.js",
            "com.liferay.portlet.instanceable=true",
            "javax.portlet.name=" + CumulusPortletKeys.GAUGES,
            "javax.portlet.display-name=" + CumulusPortletKeys.GAUGES,
            "javax.portlet.init-param.template-path=/",
            "javax.portlet.init-param.view-template=/gauges/view.jsp",
            "javax.portlet.resource-bundle=content.Language",
            "javax.portlet.security-role-ref=power-user,user"
        },
        service = Portlet.class
)
public class CumulusGaugesPortlet extends MVCPortlet {}
