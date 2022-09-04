
package com.promineotech.beer.services;

import com.promineotech.beer.models.BreweryInputModel;
import com.promineotech.beer.models.BreweryModel;
//import com.promineotech.beer.models.BreweryUpdateModel;

/**
 * @author jlcur
 *
 */
public interface BreweryService {
  /**
   * gets a brewery by it's unique id 
   * @param brewery_id The unique id.
   * @param beer_id 
   * @param  
   * @return The brewery if found, otherwise null.  
   */
  BreweryModel getBrewery(String brewery_id);
  /**
   * creates a beer by creating a unique beer_id and inputing a new beer_name 
   * @param beer_id The unique id is created and then a new  beer_name is added
   * @return The beer is added displays new beer_name and beer_id, otherwise null.  
   */
  
  BreweryModel createBrewery(BreweryInputModel input, String beer_id);
  /**
   * Deletes or removes a brewery
   * @param beer_id The unique id of the beer. 
   * @return The deleted beer if successful, otherwise returns null. 
   */
  BreweryModel deleteBrewery(String brewery_id);
  /**
   * Updates a brewery
   * @param brewery_id The unique beer id is called and the beer_name is changed.
   * @return The brewery is updated and displays changed beer_name otherwise null. 
   */
  /**
   * @param brewery_id
   * @param beer_id
   * @return
   */
  
  

 // BreweryModel updateBrewery(String brewery_name, String brewery_id );


}
