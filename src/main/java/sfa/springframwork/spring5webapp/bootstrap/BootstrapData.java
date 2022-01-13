package sfa.springframwork.spring5webapp.bootstrap;

import ch.qos.logback.core.CoreConstants;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import sfa.springframwork.spring5webapp.domain.Author;
import sfa.springframwork.spring5webapp.domain.Book;
import sfa.springframwork.spring5webapp.domain.Publisher;
import sfa.springframwork.spring5webapp.repositories.AuthorRepository;
import sfa.springframwork.spring5webapp.repositories.BookRepository;
import sfa.springframwork.spring5webapp.repositories.PublisherRepository;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher publisher = new Publisher();
        publisher.setAddress("Flori");
        publisher.setName("Fred");
        publisher.setZip("7000");

        publisherRepository.save(publisher);

        Author eric = new Author("eric","davis");
        Book tool = new Book("La vie", "12323");

        eric.getBooks().add(tool);
        tool.getAuthors().add(eric);
        tool.setPublisher(publisher);
        publisher.getBooks().add(tool);

        authorRepository.save(eric);
        bookRepository.save(tool);
        publisherRepository.save(publisher);

        Author jonson = new Author("jonson","rod");
        Book noEJB = new Book("JEE", "12325");

        jonson.getBooks().add(noEJB);
        noEJB.getAuthors().add(jonson);
        noEJB.setPublisher(publisher);
        publisher.getBooks().add(noEJB);



        authorRepository.save(jonson);
        bookRepository.save(noEJB);
        publisherRepository.save(publisher);

        System.out.println("Started in Bootstrap");
        System.out.println("NUMBER of Publisher : "+ publisherRepository.count());
        System.out.println("Number of book : " + bookRepository.count());
        System.out.println("Publisher Number of books : " + publisher.getBooks().size());
    }
}
