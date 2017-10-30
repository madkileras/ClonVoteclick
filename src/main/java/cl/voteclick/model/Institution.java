package cl.voteclick.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name="institutions")
public class Institution {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @OneToMany(mappedBy= "id", fetch=FetchType.EAGER)
    @JsonIgnore
    private List<Votation> votations;
    @ManyToMany(mappedBy = "institutions")
    private List<Voter> voters;
    public Institution(){

    }

    public Institution(String name){

        this.name=name;

    }
    public Long getInstitutionId() {
        return id;
    }

    public void setInstitutionId(Long institutionId) {
        this.id = institutionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Votation> getVotations() {
        return votations;
    }

    public void setVotations(List<Votation> votations) {
        this.votations = votations;
    }

    public List<Voter> getVoters() {
        return voters;
    }

    public void setVoters(List<Voter> voters) {
        this.voters = voters;
    }
}
