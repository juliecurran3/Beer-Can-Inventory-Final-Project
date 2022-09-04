
package com.promineotech.beer.services;

import java.util.Optional;
import org.springframework.stereotype.Service;
import com.promineotech.beer.models.BreweryInputModel;
import com.promineotech.beer.models.BreweryModel;
import com.promineotech.beer.repositories.BreweryRepository;


  @Service
  public class DefaultBreweryService implements BreweryService {
    private BreweryRepository repository;
    
    public DefaultBreweryService(BreweryRepository repository) {
      this.repository = repository;
    }

  @Override
  public BreweryModel getBrewery(String brewery_id) {
    if (brewery_id == null || (brewery_id.isEmpty())) { //check for appropriate input
      return null;
    }
    Optional<BreweryModel> brewery = repository.get(brewery_id);
    if(brewery.isEmpty()) { 
      return null;
    }
    return brewery.get();
  }

  @Override
  public BreweryModel createBrewery(BreweryInputModel input, String beer_id) {
      if ((input != null)  && (input.isValid())) {
        Optional <BreweryModel> result = repository.create(input, beer_id);
        if(result.isPresent()) {
        return result.get();
        } //return respository.create(input) results in one line of code.  Business logic goes here.  
      }  //This is where you would set
        //up an email to be sent or additional verification etc. 
      return null;
 
  }

  @Override
  public BreweryModel deleteBrewery(String brewery_id) {
    if((brewery_id == null) || (brewery_id.isEmpty())) {
      return null;
    }  
      Optional<BreweryModel> deleted = repository.delete(brewery_id);
      if (deleted.isPresent()) {
        return deleted.get();
        
    }
    return null;
  
  }

/**  @Override
  public BreweryModel updateBrewery(String brewery_name, String brewery_id) {
    if ((brewery_id != null )  && (brewery_id.isEmpty())) {
      Optional <BreweryModel> result = repository.update(brewery_name, brewery_id);
      if(result.isPresent()) {
      return result.get();
      }
    }
    return null;
  }
 **/   }


 
  
