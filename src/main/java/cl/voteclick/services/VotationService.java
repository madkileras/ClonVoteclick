package cl.voteclick.services;

import cl.voteclick.model.Option;
import cl.voteclick.model.Votation;
import cl.voteclick.model.Vote;
import cl.voteclick.repositories.OptionRepository;
import cl.voteclick.repositories.VotationRepository;
import cl.voteclick.repositories.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;


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

    @RequestMapping(
            value = "/{id}/result",
            method = RequestMethod.GET)
    @ResponseBody
    public HashMap<String, Object> getVotationResult(@PathVariable("id") long id){
        HashMap<String, Object> returnList = new HashMap<>();
        List<Integer> votesCountList = new ArrayList<>();
        List<String> optionsList = new ArrayList<>();

        int voteNull = 0, voteWhite = 0, max = 0;
        Votation votation = votationRepository.findOne(id);
        for (Option option: votation.getOptions()) {
            Integer votesCount = 0;
            for (Vote vote: option.getVotes()){
                Set<Option> voteOptions = vote.getOptions();
                if(voteOptions.isEmpty())
                    voteWhite++;
                else if(voteOptions.size() > 1)
                    voteNull++;
                else if (voteOptions.iterator().next().getId() == option.getId())
                    votesCount++;
            }

            votesCountList.add(votesCount);
            optionsList.add(option.getText());

            if(votesCount > max)
                max = votesCount;
        }

        optionsList.add("Nulo");
        votesCountList.add(voteNull);

        optionsList.add("Blanco");
        votesCountList.add(voteWhite);

        HashMap<String, Object> winner = new HashMap<>();
        winner.put("nombre", optionsList.get(max));

        returnList.put("nombre",votationRepository.findOne(id).getTitle());
        returnList.put("resultados", votesCountList);
        returnList.put("candidatos", optionsList);
        returnList.put("ganador", winner);
        return returnList;
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
