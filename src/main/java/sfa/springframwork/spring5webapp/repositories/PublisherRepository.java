package sfa.springframwork.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import sfa.springframwork.spring5webapp.domain.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
