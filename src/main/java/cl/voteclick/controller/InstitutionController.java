package cl.voteclick.controller;

import cl.voteclick.model.Institution;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface InstitutionController extends CrudRepository<Institution,Long>{

}
