package ma.youcode.clicktrack.service;

import java.util.List;
import ma.youcode.clicktrack.model.Publisher;

public interface PublisherService {
    List<Publisher> findAll();
    Publisher requirePublisher(long id);
}