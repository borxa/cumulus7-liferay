package es.borxa.liferay.cumulus7.service.api;

import aQute.bnd.annotation.ProviderType;
import com.liferay.portal.kernel.json.JSONObject;

/**
 * Cumulus service as client for JSON file with wheater data
 * 
 * @author Borxa Varela Bouzas <borxa@varelabouzas.net>
 */
@ProviderType
public interface Cumulus {
    
    /**
     * Get JSON file and caching
     * @param url URL to JSON file
     * @param timeToLive seconds in cache
     * @return Object to encapsulate JSON file
     */
    public JSONObject getJSON(String url, int timeToLive);
    
    /**
     * Clear object saved in cache
     */
    public void clearCache();
    
    /**
     * Set identificator for cache object
     * @param cacheKey Unique identificator for cache object
     */
    public void setCacheKey(String cacheKey);
    
    /**
     * Get identificator of cache object
     * @return String Identificator for cache object
     */
    public String getCacheKey();
}
