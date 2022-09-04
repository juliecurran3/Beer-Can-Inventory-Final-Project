
package com.promineotech.beer.repositories;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import com.promineotech.beer.models.BeerInputModel;
import com.promineotech.beer.models.BeerModel;
//import com.promineotech.beer.models.BeerUpdateModel;

@Repository


public class BeerJDBCRepository implements BeerRepository {
  private NamedParameterJdbcTemplate provider;
  private Random random = new Random(); //creates random numbers for id
  
  public BeerJDBCRepository(NamedParameterJdbcTemplate provider) {
    this.provider = provider;
    
  }
  @Override
  public Optional<BeerModel> get(String beer_id) {
   String sql = "SELECT beer_id, beer_name "
              + "FROM beer WHERE beer_id = :beer_id";
   MapSqlParameterSource parameters = new MapSqlParameterSource();
   parameters.addValue("beer_id", beer_id);
   List<BeerModel> beers = provider.query(sql, parameters,(rs, rowNum) -> {
     return new BeerModel(rs.getString("beer_id"), rs.getString("beer_name"));
   });
   if(beers.isEmpty()) {
     return Optional.empty();
     
   }
    return Optional.of(beers.get(0));   
  }
  @Override
  public Optional<BeerModel> create(BeerInputModel input) {
    if ((input == null) || (! input.isValid())) {
      return Optional.empty();
    }
    String sql = "INSERT INTO beer (beer_id,beer_name) "
               + "VALUES (:beer_id,:beer_name)";
    MapSqlParameterSource parameters = new MapSqlParameterSource();
    String beer_id = String.format("b%01d", random.nextInt(999));  // TODO replace random number generator 
    parameters.addValue("beer_id", beer_id);
    parameters.addValue("beer_name", input.getBeer_name());
    
    int rows = provider.update(sql, parameters);
    if (rows > 0) {
      return get(beer_id);
    }
    
    return Optional.empty();
  }
  @Override
  public Optional<BeerModel> delete(String beer_id) {
    if ((beer_id == null) || (beer_id.isEmpty())) {
      return Optional.empty();
    }
    Optional<BeerModel> existing = get(beer_id); // display thing you want to delete
    if(existing.isPresent()) {   //capture the thing you want to delete                
      String sql = "DELETE FROM beer WHERE beer_id = :beer_id";// delete it
      MapSqlParameterSource parameters = new MapSqlParameterSource();
      parameters.addValue("beer_id", beer_id);
      
      int rows = provider.update(sql, parameters);
      if (rows > 0) {// if something other than 0 is deleted
        return existing; // displays what was deleted. or you can use a boolean t/f       
      }
    }
    return Optional.empty();
  }

  

  


/**   @Override
 
//  public Optional<BeerModel> getAll(String beer_name) {
   String sql = "SELECT beer_name"
              + "FROM beer";
   MapSqlParameterSource parameters = new MapSqlParameterSource();
   parameters.addValue("beer_name", beer_name);
   List<BeerModel> beers = provider.query(sql, parameters,(rs, rowNum) -> {
     return new BeerModel(rs.getString("beer_name"));
   });
   if(beers.isEmpty()) {
     return Optional.empty();
     
  // }
    return Optional.of(beers.getAll());  //could you use this to return a list of all beers? 
  }
**/

  
 
  }