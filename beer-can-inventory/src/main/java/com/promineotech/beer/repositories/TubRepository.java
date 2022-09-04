package com.promineotech.beer.repositories;

import java.util.Optional;
import com.promineotech.beer.models.TubInputModel;
import com.promineotech.beer.models.TubModel;




public interface TubRepository {
   /* 
    * Gets a beer by its unique identifier.
    * @param beer_id the unique identifier.
    * @return return beer if found or an empty optional
    */
   Optional<TubModel> get(String tub_id);

   /**
    * Create a new tub
    * @param input the new tub
    * @return Returns the new tub if successful, otherwise an empty optional. 
    */
   Optional<TubModel> create(TubInputModel input,String can_quantity, String brewery_id, String beer_id);
   /* *
    * Deletes a tub.
    * @param tub_id The unique id of the title.
    * @return The deleted tub if successful, otherwise an empty optional.
    * 
    */
  
   Optional<TubModel> delete(String tub_id);

   /**
    * Updates a tub
    * @param Inputs the new tub 
    * @return Returns an updated tub if successful, otherwise an empty optional. 
    */

  
  Optional<TubModel> update(String can_quantity, String tub_id);


}
