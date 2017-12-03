package cl.voteclick.services;

import cl.voteclick.model.Census;
import cl.voteclick.repositories.CensusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/census")
public class CensusService {
    @Autowired
    CensusRepository censusRepository;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Census create(@RequestBody Census resource){
        return censusRepository.save(resource);
    }
}
