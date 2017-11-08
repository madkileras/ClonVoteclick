package cl.voteclick.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Votes")
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long voteId;
    @ElementCollection(targetClass=Integer.class)
    private Set<Integer> options;
    @ManyToOne
    @JoinColumn(name = "votations_id")
    private Votation votations;

    private Boolean isNull;

    private Integer option;

    public Vote(){
    }

    public Boolean getIsNull() {
        return isNull;
    }

    public void setIsNull(Boolean isNull){ this.isNull=isNull; }


    public Integer getOption(){
        return option;
    }

    public void setOption(Integer option){
        this.option=option;
    }

    public Long getVoteId() {
        return voteId;
    }

    public void setVoteId(Long voteId) {
        this.voteId = voteId;
    }

    public Set<Integer> getOptions() {
        return options;
    }

    public void setOptions(Set<Integer> options) {
        this.options = options;
    }

    @JsonIgnore
    public Votation getVotations() {
        return votations;
    }

    public void setVotations(Votation votations) {
        this.votations = votations;
    }
}
