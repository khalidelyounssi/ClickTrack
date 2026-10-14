package ma.youcode.clicktrack.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import ma.youcode.clicktrack.dao.PublisherDAO;
import ma.youcode.clicktrack.model.Publisher;

public class PublisherDaoImpl implements PublisherDAO {
    private final List<Publisher> publishers = new ArrayList<>();

    public List<Publisher> findAll(){
        return new ArrayList<>(publishers);
    }

    @Override
    public Optional<Publisher> findById(long id) {

        Optional<Publisher> publisher = publishers.stream().filter(p->p.getId()==id).findFirst();
       
        return publisher;
    }

    @Override
    public void save(Publisher pablisher) {

        publishers.add(pablisher);
       
        
    }

   
    
    
   
   
}