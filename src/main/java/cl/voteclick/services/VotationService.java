package cl.voteclick.services;

import cl.voteclick.model.Votation;
import cl.voteclick.repositories.VotationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins="http://localhost:9090/services")
@RestController
@RequestMapping("/votations")
public class VotationService {

    @Autowired
    VotationRepository votationRepository;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Iterable<Votation> getAllVotations(){
        return votationRepository.findAll();
    }



    @RequestMapping( method = RequestMethod.POST)
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Votation create(@RequestBody Votation resource){
        return votationRepository.save(resource);
    }



}
