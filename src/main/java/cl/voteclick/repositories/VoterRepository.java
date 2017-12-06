package cl.voteclick.repositories;

import cl.voteclick.model.Voter;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface VoterRepository extends CrudRepository<Voter,Long>{
    Voter findByRut(String rut);
    Voter findByEmailAndPassword(String correo, String pass);
}

 