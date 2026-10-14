package ma.youcode.clicktrack.service.impl;

import java.net.URI;
import java.util.*;
import ma.youcode.clicktrack.dao.LienDao;
import ma.youcode.clicktrack.dto.*;
import ma.youcode.clicktrack.exception.ApiException;
import ma.youcode.clicktrack.model.*;
import ma.youcode.clicktrack.service.*;

public class LienServiceImpl implements LienService {
    private final LienDao lienDao;
    private final PublisherService publisherService;

    public LienServiceImpl(LienDao lienDao,
                          PublisherService publisherService) {
        this.lienDao = lienDao;
        this.publisherService = publisherService;
    }
    @Override
    public Lien create(long publisherId, CreateLienRequest request) {
        publisherService.requirePublisher(publisherId);
        if (request == null || request.offre() == null
                || request.offre().isBlank()) {
            throw new ApiException(400, "Offre obligatoire");
        }
        String url = request.urlDestination();
        if (url == null || url.isBlank()) {
            throw new ApiException(400, "URL obligatoire");
        }
        url = url.trim();
        try {
            URI uri = URI.create(url);
            if (uri.getHost() == null
                    || !("https".equalsIgnoreCase(uri.getScheme())
                    || "http".equalsIgnoreCase(uri.getScheme()))) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            throw new ApiException(400, "URL HTTP ou HTTPS invalide");
        }
        return lienDao.create(publisherId, request.offre().trim(), url);
    }
    @Override
    public List<Lien> findByPublisherId(long publisherId) {
        publisherService.requirePublisher(publisherId);
        return lienDao.findByPublisherId(publisherId);
    }
    @Override
    public TrackingResponse track(long id) {
        Lien lien = lienDao.incrementAndGet(id).orElseThrow(
                () -> new ApiException(404, "Lien introuvable"));
        Publisher publisher = publisherService.requirePublisher(
                lien.getPublisherId());
        return new TrackingResponse(lien.getUrlDestination(),
                publisher.getPrenom() + " " + publisher.getNom(),
                lien.getOffre(), lien.getClicks());
    }
}