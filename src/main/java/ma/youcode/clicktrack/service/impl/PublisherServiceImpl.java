package ma.youcode.clicktrack.service.impl;

import java.util.List;

import ma.youcode.clicktrack.dao.PublisherDAO;
import ma.youcode.clicktrack.exception.ApiException;
import ma.youcode.clicktrack.model.Publisher;
import ma.youcode.clicktrack.service.PublisherService;

public class PublisherServiceImpl implements PublisherService {
    private final PublisherDAO publisherDao;

    public PublisherServiceImpl(PublisherDAO publisherDao) {
        this.publisherDao = publisherDao;
    }
    @Override
    public List<Publisher> findAll() {
        return publisherDao.findAll();
    }
    @Override
    public Publisher requirePublisher(long id) {
        return publisherDao.findById(id).orElseThrow(
                () -> new ApiException(404, "Publisher introuvable"));
    }
}