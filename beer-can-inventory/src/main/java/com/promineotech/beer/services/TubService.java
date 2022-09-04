/**
 * 
 */
package com.promineotech.beer.services;

import com.promineotech.beer.models.TubModel;
import com.promineotech.beer.models.TubInputModel;

/**
 * @author jlcur
 *
 */
public interface TubService {
 
    /**
     * gets a tub by it's unique id 
     * @param tub_id The unique id.
     * @return The tub if found, otherwise null.  
     */
    TubModel getTub(String tub_id);
    /**
     * creates a beer by creating a unique beer_id and inputing a new beer_name 
     * @param beer_id The unique id is created and then a new  beer_name is added
     * @return The beer is added displays new beer_name and beer_id, otherwise null.  
     */
    
    TubModel createTub(TubInputModel input, String can_quantity, String brewery_id, String beer_id);
    /**
     * Deletes or removes a brewery
     * @param beer_id The unique id of the beer. 
     * @return The deleted beer if successful, otherwise returns null. 
     */
    TubModel deleteTub(String tub_id);
    /**
     * Updates a brewery
     * @param brewery_id The unique beer id is called and the beer_name is changed.
     * @return The brewery is updated and displays changed beer_name otherwise null. 
     */
    TubModel updateTub(String can_quantity, String tub_id);


}
