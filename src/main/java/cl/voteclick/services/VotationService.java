package cl.voteclick.services;

import cl.voteclick.model.Option;
import cl.voteclick.model.Votation;
import cl.voteclick.model.Vote;
import cl.voteclick.repositories.OptionRepository;
import cl.voteclick.repositories.VotationRepository;
import cl.voteclick.repositories.VoteRepository;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Null;


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
    public List getVotations(@PathVariable("id") Long id){

        List<Integer> lista = new ArrayList<Integer>();
        Integer voteNull = 0;
        Integer voteWhite = 0;
        List<Vote> votos = voteRepository.findAllByVotationsId(id);
        for (Vote v : votos){
            if (v.getOption() == null && v.getIsNull()){
                voteNull++;
            }
            if (v.getOption() == null && !v.getIsNull()){
                voteWhite++;
            }
        }
        lista.add(voteNull);
        lista.add(voteWhite);

        List<String> listaOpciones = new ArrayList();
        Set<Option> options = votationRepository.findOne(id).getOptions();
        for (Option opcion: options) {
           listaOpciones.add(opcion.getText());
        }
        listaOpciones.add("Blanco");
        listaOpciones.add("Nulo");
        return listaOpciones;
    }

    @RequestMapping(value = "/institution/{id}", method = RequestMethod.GET)
    @ResponseBody
    public List<Votation> getVotationsInstitution(@PathVariable("id") Long id){
        return votationRepository.findAllByInstitutionsId (id);
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
