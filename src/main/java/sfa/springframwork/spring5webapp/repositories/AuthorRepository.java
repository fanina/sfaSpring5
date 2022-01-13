package sfa.springframwork.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import sfa.springframwork.spring5webapp.domain.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
