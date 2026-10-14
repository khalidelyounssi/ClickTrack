package ma.youcode.clicktrack.dao;


import java.util.List;

import ma.youcode.clicktrack.model.Lien;

public interface LienDao {
    Lien create(long publisherId, String offre, String urlDestination);
     List<Lien> findByPublisherId(long publisherId);
}