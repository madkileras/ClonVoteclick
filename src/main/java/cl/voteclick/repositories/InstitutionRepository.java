package cl.voteclick.repositories;

import cl.voteclick.model.Institution;
import cl.voteclick.model.Voter;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface InstitutionRepository extends CrudRepository<Institution,Long>{

}
