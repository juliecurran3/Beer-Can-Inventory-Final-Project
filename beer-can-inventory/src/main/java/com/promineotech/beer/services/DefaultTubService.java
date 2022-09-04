package com.promineotech.beer.services;

import java.util.Optional;
import org.springframework.stereotype.Service;
import com.promineotech.beer.models.TubInputModel;
import com.promineotech.beer.models.TubModel;
import com.promineotech.beer.repositories.TubRepository;



@Service
public class DefaultTubService implements TubService {
  private TubRepository repository;

  public DefaultTubService(TubRepository repository) {
    this.repository = repository;
  }

  @Override
  public TubModel getTub(String tub_id) {
    if (tub_id == null || (tub_id.isEmpty())) { 
      return null;
    }
    Optional<TubModel> tub = repository.get(tub_id);
    if (tub.isEmpty()) {
      return null;
    }
    return tub.get();
  }

  @Override 
  public TubModel createTub(TubInputModel input, String can_quantity, String brewery_id,
      String beer_id) {
    if ((input != null) && (input.isValid())) {
      Optional<TubModel> result = repository.create(input, can_quantity, brewery_id, beer_id);
      if (result.isPresent()) {
        return result.get();
      } // return respository.create(input) results in one line of code. Business logic goes here.
    } // This is where you would set
      // up an email to be sent or additional verification etc.
    return null;
  }

  @Override
  public TubModel deleteTub(String tub_id) {
    if ((tub_id == null) || (tub_id.isEmpty())) {
      return null;
    }
    Optional<TubModel> deleted = repository.delete(tub_id);
    if (deleted.isPresent()) {
      return deleted.get();

    }
    return null;
  }

  @Override
  public TubModel updateTub(String can_quantity, String tub_id) {
    if ((tub_id != null) && (!tub_id.isEmpty())) {
      Optional<TubModel> result = repository.update(can_quantity, tub_id);
      if (result.isPresent()) {
        return result.get();
      }
    }
    return null;
  }
}


