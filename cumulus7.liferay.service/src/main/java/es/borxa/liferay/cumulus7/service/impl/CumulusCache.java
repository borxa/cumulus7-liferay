package es.borxa.liferay.cumulus7.service.impl;

import com.liferay.portal.kernel.cache.PortalCache;
import com.liferay.portal.kernel.cache.SingleVMPoolUtil;
import com.liferay.portal.kernel.json.JSONObject;

/**
 *
 * @author borxa
 */
public class CumulusCache {

    private final PortalCache<String, JSONObject> cache;
    private String cacheKey = "cumulus-default";
    private static final CumulusCache INSTANCE = new CumulusCache();

    private CumulusCache() {
        cache = SingleVMPoolUtil.getPortalCache(CumulusCache.class.getName());
    }

    static CumulusCache getInstance() {
        return INSTANCE;
    }

    JSONObject get() {
        return cache.get(cacheKey);
    }

    void put(JSONObject json, int timeToLive) {
        cache.put(cacheKey, json, timeToLive);
    }

    void clear() {
        cache.remove(cacheKey);
    }

    void setCacheKey(String cacheKey) {
        this.cacheKey = cacheKey;
    }
    
    String getCacheKey() {
        return this.cacheKey;
    }

}
