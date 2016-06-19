package es.borxa.liferay.cumulus7.service.impl;

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
    private final CumulusCache cache = CumulusCache.getInstance();

    @Override
    public JSONObject getJSON(String url, int timeToLive) {

        JSONObject json = cache.get();
        if (Validator.isNull(json)) {
            try {
                json = JSONFactoryUtil.createJSONObject(HttpUtil.URLtoString(new URL(url)));
                cache.put(json, timeToLive);
            } catch (IOException | JSONException ex) {
                LOG.warn(ex);
                json = JSONFactoryUtil.createJSONObject();
            }
        }
        return json;

    }

    @Override
    public void clearCache() {
        cache.clear();
    }
    
    @Override
    public void setCacheKey(String cacheKey) {
        cache.setCacheKey(cacheKey);
    }

    @Override
    public String getCacheKey() {
        return cache.getCacheKey();
    }

}
