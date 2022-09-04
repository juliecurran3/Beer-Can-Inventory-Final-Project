/**
 * 
 */
package com.promineotech.beer.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author jlcur
 *
 */
public class BreweryInputModel {
  private String brewery_name;



/**
 * @return the beer_name
 */
public String getBrewery_name() {
  return brewery_name;
}
/**
 * @param beer_name the beer_name to set
 */
public BreweryInputModel setBrewery_name(String brewery_name) {
  this.brewery_name = brewery_name;
  return this;
}
/**
 * checks to make sure the date is valid 
 * @return true if valid, false if otherwise.
 */
@JsonIgnore
public boolean isValid() {
  return (getBrewery_name() !=null) && (! getBrewery_name().isEmpty());
}







}
