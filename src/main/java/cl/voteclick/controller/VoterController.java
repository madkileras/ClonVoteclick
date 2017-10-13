package cl.voteclick.controller;

import cl.voteclick.model.Voter;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface VoterController extends CrudRepository<Voter,Long>{

}
