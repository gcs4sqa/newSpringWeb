package com.gcs4sqa.bootstrap;

import com.gcs4sqa.domain.Author;
import com.gcs4sqa.domain.Book;
import com.gcs4sqa.domain.Publisher;
import com.gcs4sqa.repositories.AuthorsRepository;
import com.gcs4sqa.repositories.BookRepository;
import com.gcs4sqa.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorsRepository authorsRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorsRepository authorsRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorsRepository = authorsRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) {

        Publisher penguin = new Publisher("Penguin", "1 Sibsey Court", "Grimsby", "NELincs", "DN37 9FD");
        publisherRepository.save(penguin);

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Drive Design", "123123");

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        penguin.getBook().add(ddd);
        ddd.setPublisher(penguin);

        authorsRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(penguin);


        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "987987");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        penguin.getBook().add(noEJB);
        noEJB.setPublisher(penguin);


        authorsRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(penguin);



        System.out.println("Starting BootStrap");
        System.out.println("Number of Books = " + bookRepository.count());
        System.out.println("Here's the details of a publisher " + publisherRepository.findAll() );
        System.out.println("number of books for publisher = " + penguin.getBook().size());



    }


}
