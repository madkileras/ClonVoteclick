package cl.voteclick.services;


import cl.voteclick.model.Vote;
import cl.voteclick.repositories.VotationRepository;
import cl.voteclick.repositories.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/votes")
public class VoteService {
    @Autowired
    VoteRepository voteRepository;
    @Autowired
    VotationRepository votationRepository;

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
        return voteRepository.save(resource);
    }

}
