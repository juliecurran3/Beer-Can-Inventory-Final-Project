package com.promineotech.beer.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import com.promineotech.beer.models.BeerInputModel;
import com.promineotech.beer.models.BeerModel;
//import com.promineotech.beer.models.BeerUpdateModel;
import com.promineotech.beer.services.BeerService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@OpenAPIDefinition(info = @Info(title = "Beer Can Inventory"))
@Tag(name = "Beer Can Inventory")

public class BeerController {
  private BeerService service; // constructor injection

  public BeerController(BeerService service) {
    this.service = service;
  }

  /** 
   * returns beer name for specific id
   *
   * @param beer_id unique id 
   * @return the beer if found, otherwise null. 
   */
  @GetMapping(value = "{beer_id}")
  public BeerModel get(@PathVariable String beer_id) {
    BeerModel beer = service.getBeer(beer_id);
    if (beer != null) {
      return beer;
    }
    throw new ResponseStatusException(HttpStatus.NOT_FOUND, 
        "The requested beer can was not found");

  }
  /**
   * creates a new beer/
   * input the new beer to create.
   * @return the created beer if successful, otherwise returns null. 
   */
 

  @PostMapping(value = "{beer_name}")
  public BeerModel create(@RequestBody BeerInputModel input){ // creates more flexible code "separation of concerns"
    if (input != null) {
      //if(input.getBeer_name() == null) || (input.getBeer_name().isEmpty()) {
      if(! input.isValid()) {
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The name is required for a beer.");
      }
     BeerModel result = service.createBeer(input);
     if (result != null) {
       return result;
     }
     throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Oops, your beer spilled");
    }
    
    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The input was empty or null.");  
  }
  //@DeleteMapping(value = "{beer_id}")
  @RequestMapping(value = "{beer_id}", method = RequestMethod.DELETE)
  public BeerModel delete(@PathVariable String beer_id) {
    if((beer_id != null) && (! beer_id.isEmpty())) {
      BeerModel exisiting = service.getBeer(beer_id);
      if (exisiting != null) {
        return service.deleteBeer(beer_id);        
      }
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Requested beer not found.");
    }
    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No valid id provided."); 
  }
   
 /*   @PutMapping(value = "{beer_name}")
    public BeerModel update(@RequestBody BeerUpdateModel update){ // creates more flexible code "separation of concerns"
      if (update != null) {
        //if(input.getBeer_name() == null) || (input.getBeer_name().isEmpty()) {
        if(! update.isValid()) {
          throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The name is required for a beer.");
        }
       BeerModel result = service.updateBeer(update);
       if (result != null) {
         return result;
       }
       throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Somthing went wrong.");
      }
      
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The input was empty or null.");  
    
  }

  
*/}
