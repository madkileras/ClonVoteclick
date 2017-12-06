package cl.voteclick.services;

import cl.voteclick.model.Voter;
import cl.voteclick.repositories.VoterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/voters")
public class VoterService {
    @Autowired
    VoterRepository voterRepository;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Voter create(@RequestBody Voter resource){
        return voterRepository.save(resource);
    }
	
	@RequestMapping(method = RequestMethod.POST,value="/validate")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Voter validar(@RequestBody HashMap<String,String> resource){
    	String correo = resource.getElement("email");
    	String pass = resource.getElement("password");
    	Voter v = findByEmailAndPassword(correo,pass);
    	return v;
    }
    

    
}
