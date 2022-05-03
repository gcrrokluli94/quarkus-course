package org.agoncal.quarkus.panache.repository;


import javax.enterprise.context.ApplicationScoped;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.agoncal.quarkus.jdbc.Artist;

@ApplicationScoped
public class ArtistRepository implements PanacheRepository<Artist> {

}
