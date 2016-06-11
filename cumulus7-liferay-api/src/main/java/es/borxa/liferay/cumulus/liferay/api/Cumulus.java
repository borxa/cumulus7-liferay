package es.borxa.liferay.cumulus.liferay.api;

import aQute.bnd.annotation.ProviderType;
import com.liferay.portal.kernel.json.JSONObject;

/**
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
    public JSONObject json(String url, int timeToLive);
}
