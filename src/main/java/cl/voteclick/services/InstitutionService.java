package cl.voteclick.services;

import cl.voteclick.model.Institution;
import cl.voteclick.model.Votation;
import cl.voteclick.repositories.InstitutionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins="http://localhost:9090/services")
@RestController
@RequestMapping("/institution")
public class InstitutionService {
    @Autowired
    InstitutionRepository institutionRepository;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Iterable<Institution> getAllInstitutions(){
        return institutionRepository.findAll();
    }



    @RequestMapping( method = RequestMethod.POST)
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Institution create(@RequestBody Institution resource){
        return institutionRepository.save(resource);
    }


}
