package cl.voteclick.repositories;

import cl.voteclick.model.Census;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface CensusRepository extends CrudRepository<Census,Long>{
    List<Census> findByInstitutionId(Long id);
}
