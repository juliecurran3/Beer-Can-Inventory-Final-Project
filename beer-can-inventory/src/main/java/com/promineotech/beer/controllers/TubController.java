
package com.promineotech.beer.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import com.promineotech.beer.models.TubInputModel;
import com.promineotech.beer.models.TubModel;
import com.promineotech.beer.services.TubService;
import io.swagger.v3.oas.annotations.tags.Tag;


  @RestController
 
  @Tag(name = "Beer Can Inventory")
  @RequestMapping("/tub")
  public class TubController {
    private TubService service; // constructor injection

    public TubController(TubService service) {
      this.service = service;
    }

    /** 
     * returns tub name for specific id
     *
     * @param tub_id unique id 
     * @return the tub if found, otherwise null. 
     */
    @GetMapping(value = "{tub_id}")
    public TubModel get(@PathVariable String tub_id) {
      TubModel tub = service.getTub(tub_id);
      if (tub != null) {
        return tub;
      }
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, 
          "The requested tub was not found");

    }
    /**
     * creates a new tub/
     * input the new tub to create.
     * @return the created tub if successful, otherwise returns null. 
     */
   

    @PostMapping(value = "{tub_id}")
    public TubModel create(@RequestBody TubInputModel input, String can_quantity, String brewery_id, String beer_id){ // creates more flexible code "separation of concerns"
      if (input != null) {
       
        if(! input.isValid()) {
          throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The name is required for a tub.");
        }
       TubModel result = service.createTub(input, can_quantity, brewery_id, beer_id);
       if (result != null) {
         return result;
       }
       throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "There is no connection");
      }
      
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The input was empty or null.");  
    }
   
    /**
     * deletes a new tub/
     * input the tub_id to delete
     * @return the deleted tub if successful, otherwise returns null. 
     */
    @RequestMapping(value = "{tub_id}", method = RequestMethod.DELETE)
    public TubModel delete(@PathVariable String tub_id) {
      if((tub_id != null) && (! tub_id.isEmpty())) {
        TubModel exisiting = service.getTub(tub_id);
        if (exisiting != null) {
          return service.deleteTub(tub_id);        
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Requested tub not found.");
      }
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No valid id provided."); 
    }
    /**
     * updates a can quantity/
     * input the tub id to change
     * @return the tub id and the quantity if successful, otherwise returns null. 
     */
      @PutMapping (value = "{tub_id}")
      public TubModel update(@PathVariable String tub_id, String can_quantity){ 
        if (tub_id == null) {
          
        }
          if(tub_id.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The valid tub id is required .");
          }
         TubModel result = service.updateTub(tub_id, can_quantity); 
         if (result != null) {
           return result;
         }
         throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Not connecting");
      
  
      }      
 
  }  
  
