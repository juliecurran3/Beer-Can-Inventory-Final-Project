
package com.promineotech.beer.repositories;

import java.util.Optional;
import org.springframework.stereotype.Repository;
import com.promineotech.beer.models.BreweryInputModel;
import com.promineotech.beer.models.BreweryModel;

 @Repository  //TODO do I need this? 
/**
 * Serializes and deserializes beer information.
 *
 */
public interface BreweryRepository {
  /* 
   * Gets a beer by its unique identifier.
   * @param beer_id the unique identifier.
   * @return return title if found or an empty optional
   */
  Optional<BreweryModel> get(String brewery_id);

  /**
   * Create a new brewery
   * @param input the new brewery
   * @return Returns the new brewery if successful, otherwise an empty optional. 
   */
  Optional<BreweryModel> create(BreweryInputModel input, String beer_id);
  /* *
   * Deletes a brewery.
   * @param brewery_id The unique id of the brewery.
   * @return The deleted brewery if successful, otherwise an empty optional.
   * 
   */
 
  Optional<BreweryModel> delete(String brewery_id);

  /**
   * Updates a brewery
   * @param Inputs the new title 
   * @return Returns an updated brewery if successful, otherwise an empty optional. 
   */

 
  //Optional<BreweryModel> update(String brewery_name, String brewery_id);

  /**
   * @param brewery_id
   * @return
   */

  
  


}
