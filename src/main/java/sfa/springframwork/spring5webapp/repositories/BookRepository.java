package sfa.springframwork.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import sfa.springframwork.spring5webapp.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
}
