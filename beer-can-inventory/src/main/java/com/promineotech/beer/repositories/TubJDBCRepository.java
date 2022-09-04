package com.promineotech.beer.repositories;


import java.util.List;
import java.util.Optional;
import java.util.Random;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import com.promineotech.beer.models.TubInputModel;
import com.promineotech.beer.models.TubModel;

@Repository
public class TubJDBCRepository implements TubRepository {
  private NamedParameterJdbcTemplate provider;
  private Random random = new Random(); 



  public TubJDBCRepository(NamedParameterJdbcTemplate provider) {
    this.provider = provider;
  }

  @Override
  public Optional<TubModel> get(String tub_id) {
    String sql = "SELECT beer_id, brewery_id, tub_id, " + "tub_name, can_quantity "
        + "FROM tub WHERE tub_id = :tub_id;";
    MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue("tub_id", tub_id);
    List<TubModel> tubs = provider.query(sql, parameters, (rs, rowNum) -> {
      return new TubModel(rs.getString("tub_id"), rs.getString("tub_name"));
    });
    if (tubs.isEmpty()) {
      return Optional.empty();

    }
    return Optional.of(tubs.get(0));
  }
  @Override
  public Optional<TubModel> create(TubInputModel input, String can_quantity, String brewery_id,
      String beer_id) {
    if ((input == null) || (!input.isValid())) {
      return Optional.empty();
    }
    
    String sql = "INSERT INTO tub (beer_id, brewery_id, tub_id, " 
               + "tub_name, can_quantity) "
               + "VALUES (:beer_id, :brewery_id, :tub_id, " 
               + ":tub_name, :can_quantity)";
    MapSqlParameterSource parameters = new MapSqlParameterSource();
    String tub_id = String.format("t%02d", random.nextInt(999));
 
    parameters.addValue("beer_id", beer_id);
    parameters.addValue("brewery_id", brewery_id);
    parameters.addValue("tub_id", tub_id);
    parameters.addValue("tub_name", input.getTub_name());
    parameters.addValue("can_quantity", can_quantity);

    int rows = provider.update(sql, parameters);
    if (rows > 0) {
      return get(tub_id);
    }

    return Optional.empty();

  }


  @Override
  public Optional<TubModel> update(String tub_id, String can_quantity) {
    if ((tub_id == null) || (tub_id.isEmpty())) {
      return Optional.empty();  
    }
    String sql = "UPDATE tub "
        + "SET can_quantity = :can_quantity "
        + "WHERE tub_id = :tub_id;";
    MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue("tub_id", tub_id);
    parameters.addValue("can_quantity", can_quantity);

    int rows = provider.update(sql, parameters);
    if (rows > 0) {
      return get(tub_id);
    }
    return Optional.empty();
  }

  @Override
  public Optional<TubModel> delete(String tub_id) {
    if ((tub_id == null) || (tub_id.isEmpty())) {
      return Optional.empty();
    }
    Optional<TubModel> existing = get(tub_id); // display thing you want to delete
    if (existing.isPresent()) { // capture the thing you want to delete
      String sql = "DELETE FROM tub WHERE tub_id = :tub_id;";// delete it
      MapSqlParameterSource parameters = new MapSqlParameterSource();
      parameters.addValue("tub_id", tub_id);

      int rows = provider.update(sql, parameters);
      if (rows > 0) {
        return existing; 
      }
    }
    return Optional.empty();
  }
}
//This is something that I would like to implement in the future. 
  /*
   @Override
   public Optional<TubModel> getAll() {
   String sql = "SELECT beer.beer_name, brewery.brewery_name, tub.tub_name "
   + "FROM ((tub "
   + "INNER JOIN beer ON tub.beer_id = beer.beer_id) "
   + "INNER JOIN brewery ON tub.brewery_id = brewery.brewery_id)";
   MapSqlParameterSource parameters = new MapSqlParameterSource();
   parameters.addValue("beer_id", beer_id);
   List<TubModel> beers = provider.query(sql, parameters,(rs, rowNum) -> {
   return new TubModel(rs.getString("beer_id"), rs.getString("brewery_id")); // I want a list
   });
   }
   if(tub.isEmpty()) {
   return Optional.empty();

   }
   return Optional.of(beers.get());
} */
