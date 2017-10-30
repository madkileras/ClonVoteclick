package cl.voteclick.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "voters")
public class Voter {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String rut;
    @ManyToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    @JoinTable(name = "voter_vinculated", joinColumns = @JoinColumn(name = "voter_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "institution_id", referencedColumnName = "id"))
    private List<Institution> institutions;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "votation_voter", joinColumns = @JoinColumn(name = "voter_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "votation_id", referencedColumnName = "id"))
    private List<Votation> votations;
    public Voter(){

    }

    public Long getVoterId() {
        return id;
    }

    public void setVoterId(Long voterId) {
        this.id = voterId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public List<Institution> getInstitutions() {
        return institutions;
    }

    public void setInstitutions(List<Institution> institutions) {
        this.institutions = institutions;
    }

    public List<Votation> getVotations() {
        return votations;
    }

    public void setVotations(List<Votation> votations) {
        this.votations = votations;
    }
}
