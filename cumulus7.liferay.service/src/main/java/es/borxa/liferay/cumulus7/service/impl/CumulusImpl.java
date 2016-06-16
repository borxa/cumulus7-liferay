package es.borxa.liferay.cumulus7.service.impl;

import com.liferay.portal.kernel.cache.PortalCache;
import com.liferay.portal.kernel.cache.SingleVMPoolUtil;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.Validator;
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
        property = {},
        service = Cumulus.class
)
public class CumulusImpl implements Cumulus {

    private static final Log LOG = LogFactoryUtil.getLog(CumulusImpl.class);
    private static final PortalCache<String, JSONObject> CACHE
            = SingleVMPoolUtil.getPortalCache(CumulusImpl.class.getName());
    private String cacheKey = "cumulus-default";

    @Override
    public JSONObject json(String url, int timeToLive) {

        JSONObject json = CACHE.get(cacheKey);
        if (Validator.isNull(json)) {
            try {
                String jsonString = HttpUtil.URLtoString(new URL(url));
                json = JSONFactoryUtil.createJSONObject(jsonString);
                CACHE.put(cacheKey, json, timeToLive);
            } catch (IOException | JSONException ex) {
                LOG.warn(ex);
            }
        }
        return json;

    }

    @Override
    public void clearCache() {
        CACHE.remove(cacheKey);
    }
    
    @Override
    public void setCacheKey(String cacheKey) {
        this.cacheKey = cacheKey;
    }

    @Override
    public String getCacheKey() {
        return cacheKey;
    }

}
