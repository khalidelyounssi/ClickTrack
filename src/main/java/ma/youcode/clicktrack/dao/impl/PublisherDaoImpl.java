package ma.youcode.clicktrack.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import ma.youcode.clicktrack.dao.PublisherDAO;
import ma.youcode.clicktrack.model.*;

public class PublisherDaoImpl implements PublisherDAO {
    private final List<Publisher> publishers = new ArrayList<>();
    

    
    @Override
    public synchronized List<Publisher> findAll() {
        return new ArrayList<>(publishers);
    }
    @Override
    public synchronized Optional<Publisher> findById(long id) {
        return publishers.stream()
                .filter(p -> p.getId() == id).findFirst();
    }
    @Override
    public synchronized void save(Publisher publisher) {
        if (findById(publisher.getId()).isPresent()) {
            throw new IllegalArgumentException("Publisher deja present");
        }
        publishers.add(publisher);
    }
}