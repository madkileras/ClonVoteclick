package cl.voteclick.repositories;

import cl.voteclick.model.Institution;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface InstitutionRepository extends CrudRepository<Institution,Long>{

}
