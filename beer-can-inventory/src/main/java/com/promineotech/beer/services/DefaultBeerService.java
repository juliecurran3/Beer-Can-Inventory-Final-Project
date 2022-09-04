
package com.promineotech.beer.services;

import java.util.Optional;
import org.springframework.stereotype.Service;
import com.promineotech.beer.models.BeerInputModel;
import com.promineotech.beer.models.BeerModel;
//import com.promineotech.beer.models.BeerUpdateModel;
import com.promineotech.beer.repositories.BeerRepository;

@Service
public class DefaultBeerService implements BeerService {
  private BeerRepository repository;

  public DefaultBeerService(BeerRepository repository) {
    this.repository = repository;
  }
  
  @Override
  public BeerModel getBeer(String beer_id) {
    if (beer_id == null || (beer_id.isEmpty())) { //check for appropriate input
    return null;
  }
  Optional<BeerModel> beer = repository.get(beer_id);
  if(beer.isEmpty()) { 
    return null;
  }
  return beer.get();
}

  @Override
  public BeerModel createBeer(BeerInputModel input) {
    if ((input != null)  && (input.isValid())) {
      Optional <BeerModel> result = repository.create(input);
      if(result.isPresent()) {
      return result.get();
      } //return respository.create(input) results in one line of code.  Business logic goes here.  
    }  //This is where you would set
      //up an email to be sent or additional verification etc. 
    return null;
  }

  @Override
  public BeerModel deleteBeer(String beer_id) {
    if((beer_id == null) || (beer_id.isEmpty())) {
      return null;
    }  
      Optional<BeerModel> deleted = repository.delete(beer_id);
      if (deleted.isPresent()) {
        return deleted.get();
        
    }
    return null;
  }

   
 

/**  @Override
  public BeerModel updateBeer(BeerUpdateModel update) {
    if ((update != null)  && (update.isValid())) {
      Optional <BeerModel> result = repository.update(update, null);
      if(result.isPresent()) {
      return result.get();
   
      }
      }
    return null;
  }
**/}  
  
