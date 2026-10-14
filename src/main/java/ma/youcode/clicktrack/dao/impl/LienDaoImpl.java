package ma.youcode.clicktrack.dao.impl;

import java.util.ArrayList;
import java.util.List;
import ma.youcode.clicktrack.dao.LienDao;
import ma.youcode.clicktrack.model.Lien;

public class LienDaoImpl implements LienDao {
    private final List<Lien> liens = new ArrayList<>();
    private long nextId = 1;

    @Override
    public synchronized Lien create(long publisherId,
            String offre, String urlDestination) {
        Lien lien = new Lien(nextId++, offre,
                urlDestination, 0, publisherId);
        liens.add(lien);
        return lien;
    }
    @Override
    public synchronized List<Lien> findByPublisherId(long publisherId) {
        List<Lien> result = new ArrayList<>();
        for (Lien lien : liens) {
            if (lien.getPublisherId() == publisherId) {
                result.add(lien);
            }
        }
        return result;
    }
    @Override
    public synchronized Optional<Lien> incrementAndGet(long id) {
        for (int i = 0; i < liens.size(); i++) {
            Lien old = liens.get(i);
            if (old.getId() == id) {
                Lien updated = new Lien(old.getId(), old.getOffre(),
                        old.getUrlDestination(), old.getClicks() + 1,
                        old.getPublisherId());
                liens.set(i, updated);
                return Optional.of(updated);
            }
        }
        return Optional.empty();
    }
}