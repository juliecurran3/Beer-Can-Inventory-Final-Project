/**
 * 
 */
package com.promineotech.beer.models;

/**
 * @author jlcur
 *
 */
public class BreweryModel extends Model {
  private String brewery_id;
  private String brewery_name;
  
  public BreweryModel(String brewery_id, String brewery_name) {
    setBrewery_id(brewery_id);
    setBrewery_name(brewery_name);
  }
  /**
   * @return the brewery_id
   */
  public String getBrewery_id() {
    return brewery_id;
  }
  /**
   * @param brewery_id the brewery_id to set
   */
  public BreweryModel setBrewery_id(String brewery_id) {
    this.brewery_id = brewery_id;
    return this;
  }
  /**
   * @return the brewery_name
   */
  public String getBrewery_name() {
    return brewery_name;
  }
  /**
   * @param brewery_name the brewery_name to set
   */
  public BreweryModel setBrewery_name(String brewery_name) {
    this.brewery_name = brewery_name;
    return this;
  }

}
