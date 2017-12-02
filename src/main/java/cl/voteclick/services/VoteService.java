package cl.voteclick.services;


import cl.voteclick.model.Option;
import cl.voteclick.model.Vote;
import cl.voteclick.repositories.OptionRepository;
import cl.voteclick.repositories.VotationRepository;
import cl.voteclick.repositories.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@CrossOrigin
@RestController
@RequestMapping("/votes")
public class VoteService {
    @Autowired
    VoteRepository voteRepository;
    @Autowired
    VotationRepository votationRepository;
    @Autowired
    OptionRepository optionRepository;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Iterable<Vote> getAllVotes(){
        return voteRepository.findAll();
    }


    @RequestMapping( method = RequestMethod.POST)
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Vote create(@RequestBody Vote resource){
        Set<Option> options = new HashSet<>();
        for(Option option: resource.getOptions()) {
            System.out.println("ID: " + option.getId());
            options.add(optionRepository.findOne(option.getId()));
        }

        resource.setOptions(options);
        return voteRepository.save(resource);
    }

}
