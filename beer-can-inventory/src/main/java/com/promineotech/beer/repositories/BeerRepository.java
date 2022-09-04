
package com.promineotech.beer.repositories;

import java.util.Optional;
import org.springframework.stereotype.Repository;
import com.promineotech.beer.models.BeerInputModel;
import com.promineotech.beer.models.BeerModel;
//import com.promineotech.beer.models.BeerUpdateModel;
@Repository // TODO  do I need this? 
/**
 * Serializes and deserializes beer information.
 *
 * 
 */
public interface BeerRepository {
  /* 
   * Gets a beer by its unique identifier.
   * @param beer_id the unique identifier.
   * @return return title if found or an empty optional
   */
  Optional<BeerModel> get(String beer_id);

  /**
   * Create a new title
   * @param input the new title
   * @return Returns the new title if successful, otherwise an empty optional. 
   */
  Optional<BeerModel> create(BeerInputModel input);
  /* *
   * Deletes a beer.
   * @param beer_id The unique id of the title.
   * @return The deleted beer if successful, otherwise an empty optional.
   * 
   */
 
  Optional<BeerModel> delete(String beer_id);

  /**
   * Updates a beer
   * @param Inputs the new title 
   * @return Returns an updated beer if successful, otherwise an empty optional. 
   */

 
//  Optional<BeerModel> update(BeerUpdateModel update, String beer_id);

  /**
   * @param Gets all of the beer names.  
   * @return
   */
 // Optional<BeerModel> getAll(String beer_name);
  
  

}
