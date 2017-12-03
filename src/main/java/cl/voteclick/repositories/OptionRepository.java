package cl.voteclick.repositories;

import cl.voteclick.model.Option;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface OptionRepository extends CrudRepository<Option,Long>{
}
