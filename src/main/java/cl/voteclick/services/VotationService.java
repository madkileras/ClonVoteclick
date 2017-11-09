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
import java.util.HashMap;
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
    public HashMap<String, Object> getVotations(@PathVariable("id") Long id){

        HashMap<String, Object> listaFinal = new HashMap<>();
        List<Integer> listaVotos = new ArrayList<>();
        List<String> listaOpciones = new ArrayList<>();
        //List<Long> listaIds = new ArrayList<>();

        List<Vote> votos = voteRepository.findAllByVotationsId(id);
        /////////obtener candidatos y sus votos///////////
        Set<Option> options = votationRepository.findOne(id).getOptions();
        for (Option opcion: options) {
            Integer cantidadVot = 0;
            for (Vote v : votos){
                Set<Integer> opcionesVotos = v.getOptions();
                for (Integer o: opcionesVotos){
                    String x = o.toString();
                    if ( x.equals(opcion.getOptionId().toString())){
                        cantidadVot++;
                    }
                }
            }
            listaVotos.add(cantidadVot);
            //listaIds.add(opcion.getOptionId());
            listaOpciones.add(opcion.getText());
        }
        /////////////////////////////////////

        //CONTAR Y AGREGAR Nulos y blancos//
        Integer voteNull = 0;
        Integer voteWhite = 0;
        for (Vote v : votos) {
            Set<Integer> opcionesVotos = v.getOptions();
            if (v.getIsNull() && opcionesVotos.size() == 0) {
                voteNull++;
            }
            if (!v.getIsNull() && opcionesVotos.size() == 0) {
                voteWhite++;
            }
        }
        listaOpciones.add("Nulo");
        listaOpciones.add("Blanco");

        listaVotos.add(voteNull);
        listaVotos.add(voteWhite);
        /////////////////////////////////////

        //////Obtener Ganador///////////////
        HashMap<String, Object> ganador = new HashMap<>();
        Integer pos = 0;
        Integer posAux = 0;
        Integer max = listaVotos.get(0);

        for (Integer num: listaVotos){
            if (num > max){
                max = num;
                posAux = pos;
            }
            pos++;
        }
        ganador.put("nombre",listaOpciones.get(posAux));
        ganador.put("imagen","../../img/opcion.png");
        /////////////////////////////////////
        listaFinal.put("nombre",votationRepository.findOne(id).getTitle());
        listaFinal.put("resultados", listaVotos);
        //listaFinal.add(listaIds);
        listaFinal.put("candidatos", listaOpciones);
        listaFinal.put("ganador", ganador);
        return listaFinal;
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
