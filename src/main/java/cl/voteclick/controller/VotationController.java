package cl.voteclick.controller;

import cl.voteclick.model.Votation;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface VotationController extends CrudRepository<Votation,Long>{

}
