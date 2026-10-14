package ma.youcode.clicktrack.service;

import java.util.List;

import ma.youcode.clicktrack.dto.*;
import ma.youcode.clicktrack.model.Lien;

public interface LienService {
    Lien create(long publisherId, CreateLienRequest request);
    List<Lien> findByPublisherId(long publisherId);
    TrackingResponse track(long id);
}