package cl.voteclick.repositories;

import cl.voteclick.model.Census;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface CensusRepository extends CrudRepository<Census,Long>{

}
