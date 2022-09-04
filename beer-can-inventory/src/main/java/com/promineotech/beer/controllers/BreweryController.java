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
import com.promineotech.beer.models.BreweryInputModel;
import com.promineotech.beer.models.BreweryModel;
import com.promineotech.beer.services.BreweryService;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * @author jlcur
 *
 */

  @RestController
  @Tag(name = "Beer Can Inventory")
  @RequestMapping("/brewery")
  public class BreweryController  {
    private BreweryService service; // constructor injection
   

    public BreweryController(BreweryService service) {
      this.service = service;
    }

    /** 
     * returns brewery name for specific id
     *
     * @param brewer_id unique id 
     * @return the beer if found, otherwise null. 
     */
    @GetMapping(value = "{brewery_id}")
    public BreweryModel get(@PathVariable String brewery_id) {
      BreweryModel brewery = service.getBrewery(brewery_id);
      if (brewery != null) {
        return brewery;
      }
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, 
          "The requested brewery was not found");

    }


    /**
     * creates a new brewery/
     * input the new brewery to create.
     * @return the created brewery if successful, otherwise returns null. 
     */
   

    @PostMapping(value = "{brewery_name}")
    public BreweryModel create(@RequestBody BreweryInputModel input, String beer_id){ // creates more flexible code "separation of concerns"
      if (input != null) {
        //if(input.getBrewery_name() == null) || (input.getBrewery_name().isEmpty()) {
        if(! input.isValid()) {
          throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The name is required for a tub.");
        }
       BreweryModel result = service.createBrewery(input, beer_id);
       if (result != null) {
         return result;
       }
       throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Oops, your beer spilled");
      }
      
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The input was empty or null.");  
    }
    //@DeleteMapping(value = "{brewery_id}")
    @RequestMapping(value = "{brewery_id}", method = RequestMethod.DELETE)
    public BreweryModel delete(@PathVariable String brewery_id) {
      if((brewery_id != null) && (! brewery_id.isEmpty())) {
        BreweryModel exisiting = service.getBrewery(brewery_id);
        if (exisiting != null) {
          return service.deleteBrewery(brewery_id);        
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Requested brewery not found.");
      }
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No valid id provided."); 
    }
  }
     
  /**    @PutMapping()
      public BreweryModel update(@PathVariable String brewery_name, String brewery_id){ // creates more flexible code "separation of concerns"
        if (brewery_name != null) {
          //if(update.getBrewery_name() == null) || (update.getBrewery_name().isEmpty()) {
          if(! brewery_name.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The name is required for a brewery.");
          }
        }
      }
  }
       BreweryModel result = service.updateBrewery(brewery_name, brewery_id);
         if (result != null) {
           return result;
         }
  //       throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Something went wrong.");
        }
        
  //      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The input was empty or null.");  
      
    }
  }
*/

