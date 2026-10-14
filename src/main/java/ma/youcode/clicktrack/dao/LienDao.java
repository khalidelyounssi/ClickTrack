package ma.youcode.clicktrack.dao;


import java.util.List;
import java.util.Optional;

import ma.youcode.clicktrack.model.Lien;

public interface LienDao {
    Lien create(long publisherId, String offre, String urlDestination);
     List<Lien> findByPublisherId(long publisherId);
      Optional<Lien> incrementAndGet(long id);
}