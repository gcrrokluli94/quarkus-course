package org.agoncal.quarkus.panache.repository;


import javax.enterprise.context.ApplicationScoped;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Sort;
import org.agoncal.quarkus.jdbc.Artist;

import java.util.List;

@ApplicationScoped
public class ArtistRepository implements PanacheRepository<Artist> {
    public List<Artist> listAllArtistSorted() {
        return listAll(Sort.descending("name"));
    }
}
