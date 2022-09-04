/**
 * 
 */
package com.promineotech.beer.models;
public class BeerModel extends Model{
  private String beer_id;
  private String beer_name;

  public BeerModel(String beer_id, String beer_name) {
    setBeer_id(beer_id);
    setBeer_name(beer_name);
  }
  /**
   * @return the beer_id
   */
  public String getBeer_id() {
    return beer_id;
  }
  /**
   * @param beer_id the beer_id to set
   */
  public BeerModel setBeer_id(String beer_id) { // this allows us to daisy chain substituting the .builder from Lomboc
    this.beer_id = beer_id;
    return this;
  }
  /**
   * @return the beer_name
   */
  public String getBeer_name() {
    return beer_name;
  }
  /**
   * @param beer_name the beer_name to set
   */
  public BeerModel setBeer_name(String beer_name) {
    this.beer_name = beer_name;
    return this;
  }

}
