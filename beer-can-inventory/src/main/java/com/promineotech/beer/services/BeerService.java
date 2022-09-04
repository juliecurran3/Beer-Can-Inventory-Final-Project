
package com.promineotech.beer.services;

import com.promineotech.beer.models.BeerInputModel;
import com.promineotech.beer.models.BeerModel;
//import com.promineotech.beer.models.BeerUpdateModel;

/**
 * The minimal implementation for getting or setting beer information.
 * @author jlcur
 *
 */
public interface BeerService {
  /**
   * gets a beer by it's unique id 
   * @param beer_id The unique id.
   * @return The movie if found, otherwise null.  
   */
  BeerModel getBeer(String beer_id);
  /**
   * creates a beer by creating a unique beer_id and inputing a new beer_name 
   * @param beer_id The unique id is created and then a new  beer_name is added
   * @return The beer is added displays new beer_name and beer_id, otherwise null.  
   */
  
  BeerModel createBeer(BeerInputModel input);
  /**
   * Deletes or removes a beer
   * @param beer_id The unique id of the beer. 
   * @return The deleted beer if successful, otherwise returns null. 
   */
  BeerModel deleteBeer(String beer_id);
  /**
   * Updates a beer
   * @param beer_id The unique beer id is called and the beer_name is changed.
   * @return The beer is updated and displays changed beer_name otherwise null. 
   */
 // BeerModel updateBeer(BeerUpdateModel update);

}
