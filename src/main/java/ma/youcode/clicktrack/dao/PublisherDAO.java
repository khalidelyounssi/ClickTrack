package ma.youcode.clicktrack.dao;

import java.util.List;
import java.util.Optional;

import ma.youcode.clicktrack.model.Publisher;



public interface PublisherDAO {

    
  List<Publisher> findAll();
  Optional<Publisher> findById(long id);
  void save(Publisher pablisher);


}