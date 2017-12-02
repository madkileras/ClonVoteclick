package cl.voteclick.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="options")
public class Option {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String text;

    @ManyToOne
    @JoinColumn(name = "votation_id")
    @JsonIgnore
    private Votation votation;

    @ManyToMany(mappedBy = "options")
    private Set<Vote> votes;

    public Option() {}

    public Option(String text, Votation votation) {
        this.text = text;
        this.votation = votation;
        this.votes = new HashSet<>();
    }

    public long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public void setVotations(Votation votation){
        this.votation = votation;
    }
    @JsonIgnoreProperties("options")
    public Votation getVotation() {
        return votation;
    }

    public Set<Vote> getVotes() {
        return this.votes;
    }
}
