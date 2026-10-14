package ma.youcode.clicktrack.service;

import ma.youcode.clicktrack.dto.*;
import ma.youcode.clicktrack.model.Lien;

public interface LienService {
    Lien create(long publisherId, CreateLienRequest request);
}