package cl.voteclick.services;

import cl.voteclick.model.Institution;
import cl.voteclick.model.Votation;
import cl.voteclick.model.Voter;
import cl.voteclick.repositories.InstitutionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@CrossOrigin
@RestController
@RequestMapping("/institutions")
public class InstitutionService {
    @Autowired
    InstitutionRepository institutionRepository;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Iterable<Institution> getAllInstitutions(){
        return institutionRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Institution getOne(@PathVariable("id") Long id){
        return institutionRepository.findOne(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Institution create(@RequestBody Institution resource){
        return institutionRepository.save(resource);
    }

    @RequestMapping(value = "/{id}/voters", method = RequestMethod.GET)
    @ResponseBody
    public Set<Voter> getVotersInstitution(@PathVariable("id") Long id){
        Institution institution = institutionRepository.findOne(id);
        return institution.getVoters();
    }

}
