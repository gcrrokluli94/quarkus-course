package org.agoncal.quarkus.panache.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Book extends Item {
    @Column(length = 15)
    public String isbn;

    @Column(name ="number_of_pages")
    public int nbOfPages;

    @Column(name ="publication_date")
    public LocalDate publicationDate;

    @Column(length = 20)
    @Enumerated(EnumType.STRING)
    public Language language;

    @ManyToOne
    @JoinColumn(name = "publisher_fk")
    public Publisher publisher;
}
