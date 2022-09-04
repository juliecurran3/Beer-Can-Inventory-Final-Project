/**
 * 
 */
package com.promineotech.beer.models;

/**
 * @author jlcur
 *
 */
public class TubModel extends Model {
    private String tub_id;
    private String tub_name;
    
    public TubModel(String tub_id, String tub_name) {
      setTub_id(tub_id);
      setTub_name(tub_name);
      
    }
    /**
     * @return the tub_id
     */
    public String getTub_id() {
      return tub_id;
    }
    /**
     * @param tub_id the tub_id to set
     */
    public TubModel setTub_id(String tub_id) {
      this.tub_id = tub_id;
      return this;
    }
    /**
     * @return the tub_name
     */
    public String getTub_name() {
      return tub_name;
    }
    /**
     * @param tub_name the tub_name to set
     */
    public TubModel setTub_name(String tub_name) {
      this.tub_name = tub_name;
      return this;
    }
}
