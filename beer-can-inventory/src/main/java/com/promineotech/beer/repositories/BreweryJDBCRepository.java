package com.promineotech.beer.repositories;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import com.promineotech.beer.models.BreweryInputModel;
import com.promineotech.beer.models.BreweryModel;

@Repository

public class BreweryJDBCRepository implements BreweryRepository {

  private NamedParameterJdbcTemplate provider;
  private Random random = new Random(); 
  
  public BreweryJDBCRepository(NamedParameterJdbcTemplate provider) {
    this.provider = provider;
    
  }
  @Override
  public Optional<BreweryModel> get(String brewery_id) {
     String sql = "SELECT beer_id, brewery_name "
                + "FROM brewery "
                + "WHERE brewery_id = :brewery_id";
     MapSqlParameterSource parameters = new MapSqlParameterSource();
     parameters.addValue("brewery_id", brewery_id);
     List<BreweryModel> brewery = provider.query(sql, parameters,(rs, rowNum) -> {
       return new BreweryModel(rs.getString("beer_id"), rs.getString("brewery_name"));
           
     });
     if(brewery.isEmpty()) {
       return Optional.empty();
       
     }
      return Optional.of(brewery.get(0));  
    } 
  

  @Override
  public Optional<BreweryModel> create(BreweryInputModel input, String beer_id) {
    if ((input == null) || (! input.isValid())) {
      return Optional.empty();
    }
    String sql = "INSERT INTO brewery (brewery_id, brewery_name, beer_id) "
               + "VALUES (:brewery_id,:brewery_name, :beer_id)";
    MapSqlParameterSource parameters = new MapSqlParameterSource();
    String brewery_id = String.format("br%01d", random.nextInt(999));   
    parameters.addValue("brewery_id", brewery_id);
    parameters.addValue("brewery_name", input.getBrewery_name());
    parameters.addValue("beer_id", beer_id);    
 
    
    int rows = provider.update(sql, parameters);
    if (rows > 0) {
      return get(brewery_id);
    }
    
    return Optional.empty();
  }
  @Override
  public Optional<BreweryModel> delete(String brewery_id) {
    if ((brewery_id == null) || (brewery_id.isEmpty())) {
      return Optional.empty();
    }
    Optional<BreweryModel> existing = get(brewery_id); // display thing you want to delete
    if(existing.isPresent()) {   //capture the thing you want to delete                
      String sql = "DELETE FROM brewery WHERE brewery_id = :brewery_id;";// delete it
      MapSqlParameterSource parameters = new MapSqlParameterSource();
      parameters.addValue("brewery_id", brewery_id);
      
      int rows = provider.update(sql, parameters);
      if (rows > 0) {// if something other than 0 is deleted
        return existing; // displays what was deleted. or you can use a boolean t/f       
      }
    }
    return Optional.empty();
  }
  /**
   * @param brewery_id
   * @return
   */
 

  }

 
