package cl.voteclick.repositories;

import cl.voteclick.model.Vote;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface VoteRepository extends CrudRepository<Vote,Long> {
}
