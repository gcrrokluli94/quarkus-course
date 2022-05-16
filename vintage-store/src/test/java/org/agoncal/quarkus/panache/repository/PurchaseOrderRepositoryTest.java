package org.agoncal.quarkus.panache.repository;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import org.agoncal.quarkus.jdbc.Artist;
import org.agoncal.quarkus.jpa.Customer;
import org.agoncal.quarkus.panache.model.*;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.math.BigDecimal;
@QuarkusTest
public class PurchaseOrderRepositoryTest {
    @Inject
    CustomerRepository customerRepository;
    @Test
    @TestTransaction
    public void shouldCreateAndFindAPurchaseOrder(){
        Artist artist = new Artist("artist name" , "artist bio");
        Publisher publisher = new Publisher("publisher name");
        Book book = new Book();
        book.title = "title of the Book";
        book.price = new BigDecimal(10);
        book.isbn = "isbn";
        book.nbOfPages = 500;
        book.language = Language.ENGLISH;
        book.publisher = publisher;
        book.artist = artist;
        Book.persist(book);

        Customer customer = new Customer("customer first name", "customer last name", "customer@gmail.com");
        customerRepository.persist(customer);

        OrderLine orderLine = new OrderLine();
        orderLine.item = book;
        orderLine.quantity = 2;

        PurchaseOrder purchaseOrder = new PurchaseOrder();
        purchaseOrder.customer = customer;

        purchaseOrder.addOrderLine(orderLine);
        PurchaseOrder.persist(purchaseOrder);
    }
}
