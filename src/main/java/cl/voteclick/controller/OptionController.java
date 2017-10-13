package cl.voteclick.controller;

import cl.voteclick.model.Option;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface OptionController extends CrudRepository<Option,Long>{

}
