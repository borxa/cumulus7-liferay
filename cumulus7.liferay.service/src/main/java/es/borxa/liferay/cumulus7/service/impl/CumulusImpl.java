package es.borxa.liferay.cumulus7.service.impl;

import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.HttpUtil;
import es.borxa.liferay.cumulus7.service.api.Cumulus;
import java.io.IOException;
import java.net.URL;
import org.osgi.service.component.annotations.Component;

/**
 *
 * @author Borxa Varela Bouzas <borxa@varelabouzas.net>
 */
@Component(
    immediate = true,
    property = {
    },
    service = Cumulus.class
)
public class CumulusImpl implements Cumulus {
    
    private static final Log LOG = LogFactoryUtil.getLog(CumulusImpl.class);

    @Override
    public JSONObject json(String url, int timeToLive) {
        JSONObject json = JSONFactoryUtil.createJSONObject();
        try {
            String str = HttpUtil.URLtoString(new URL(url));
            json = JSONFactoryUtil.createJSONObject(str);
        } catch (IOException |JSONException ex) {
            LOG.warn(ex);
        }
        return json;
    }
    
}
