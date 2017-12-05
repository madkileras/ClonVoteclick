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


    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Iterable<Census> getAllCensus(){
        return censusRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Iterable<Census> getCensus(@PathVariable("id") long id){
        return censusRepository.findByInstitutionId(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Census create(@RequestBody Census resource){
        return censusRepository.save(resource);
    }
}
