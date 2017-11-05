package cl.voteclick.repositories;

import cl.voteclick.model.Votation;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface VotationRepository extends CrudRepository<Votation,Long>{

}
