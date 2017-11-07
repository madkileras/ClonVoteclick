package cl.voteclick.services;

import cl.voteclick.model.Option;
import cl.voteclick.model.Votation;
import cl.voteclick.model.Vote;
import cl.voteclick.repositories.OptionRepository;
import cl.voteclick.repositories.VotationRepository;
import cl.voteclick.repositories.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Set;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
@RequestMapping("/votations")
public class VotationService {

    @Autowired
    VotationRepository votationRepository;
    @Autowired
    OptionRepository optionRepository;
    @Autowired
    VoteRepository voteRepository;


    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Iterable<Votation> getAllVotations(){
        return votationRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Integer getVotations(@PathVariable("id") Long id){
        List<Vote> votos = voteRepository.findAllByVotationsId(id);
        return votos.size();
    }



    @RequestMapping( method = RequestMethod.POST)
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Votation create(@RequestBody Votation resource){
        Votation votation= votationRepository.save(resource);
        Set<Option> options = votation.getOptions();
        for (Option s : options){
            s.setVotations(votation);
        }
        optionRepository.save(options);
        return votation;
    }



}
