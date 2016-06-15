package es.borxa.liferay.cumulus7.web.service;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import es.borxa.liferay.cumulus7.service.api.Cumulus;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
/**
 *
 * @author Borxa Varela Bouzas <borxa@varelabouzas.net>
 */
@Component(
    immediate = true,
    property = {
        "osgi.command.scope=getJSON",
        "osgi.command.function=getJSON"
    },
    service = Object.class
)
public class CumulusService {
    
    public JSONObject getJSON(String url, int timeToLive) {
        
        JSONObject json = JSONFactoryUtil.createJSONObject();
        
        Cumulus cumulus = getCumulus();
        if(cumulus != null) {
            json = cumulus.json(url, timeToLive);
        } else {
            System.out.println("Bean not initialized");
        }
        
        return json;
    }

    public Cumulus getCumulus() {
        return _cumulus;
    }

    @Reference
    public void setCumulus(Cumulus cumulus) {
        _cumulus = cumulus;
    }

    private Cumulus _cumulus;
}
