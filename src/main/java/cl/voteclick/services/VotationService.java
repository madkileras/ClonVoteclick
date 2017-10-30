package cl.voteclick.services;

import cl.voteclick.model.Votation;
import java.util.Set;
import cl.voteclick.repositories.VotationRepository;
import cl.voteclick.model.Option;
import cl.voteclick.repositories.OptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
@RequestMapping("/votations")
public class VotationService {

    @Autowired
    VotationRepository votationRepository;
    OptionRepository optionRepository;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Iterable<Votation> getAllVotations(){
        return votationRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Long create(@RequestBody Votation resource){

        Votation votation = votationRepository.save(resource);
        Long id = votation.getVotationId();
        Set <Option> options = votation.getOptions();

        for (Option i : options){
            i.setVotations(votation);
            optionRepository.save(i);

        }
        return id;


    }



}
