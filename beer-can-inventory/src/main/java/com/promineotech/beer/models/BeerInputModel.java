package com.promineotech.beer.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author jlcur
 *
 */
public class BeerInputModel {
  private String beer_name;


  
  /**
   * @return the beer_name
   */
  public String getBeer_name() {
    return beer_name;
  }
  /**
   * @param beer_name the beer_name to set
   */
  public BeerInputModel setBeer_name(String beer_name) {
    this.beer_name = beer_name;
    return this;
  }
  /**
   * checks to make sure the date is valid 
   * @return true if valid, false if otherwise.
   */
  @JsonIgnore
  public boolean isValid() {
    return (getBeer_name() !=null) && (! getBeer_name().isEmpty());
  }
}

  


