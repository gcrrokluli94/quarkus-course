package repository;


import javax.enterprise.context.ApplicationScoped;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
@ApplicationScoped
public class ArtistRepository implements PanacheRepository<Artist> {

}
