package com.promineotech.beer.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author jlcur
 *
 */
public class TubInputModel {
  private String tub_name;

  /**
   * 
   * @return the  tub_name
   */
  public String getTub_name() {
    return tub_name;
  }
  /**
   * @param tub_name the tub_name to set
   */
  public TubInputModel setTub_name(String tub_name) {
    this.tub_name = tub_name;
    return this;
  }
  /**
   * checks to make sure the date is valid 
   * @return true if valid, false if otherwise.
   */
  @JsonIgnore
  public boolean isValid() {
    return (getTub_name() !=null) && (! getTub_name().isEmpty());
  }


}
