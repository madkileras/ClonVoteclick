package cl.voteclick.controller;

import cl.voteclick.model.Vote;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface VoteController extends CrudRepository<Vote,Long>{

}
