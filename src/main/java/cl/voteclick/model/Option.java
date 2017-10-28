package cl.voteclick.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
@Entity
@Table(name="options")
public class Option {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long optionId;
    private String text;
    @ManyToOne
    @JoinColumn(name = "votation_id")
    private Votation votations;

    public Option(){

    }

    public Long getOptionId() {
        return optionId;
    }

    public void setOptionId(Long optionId) {
        this.optionId = optionId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    @JsonIgnore
    public Votation getVotations() {
        return votations;
    }

    public void setVotations(Votation votations) {
        this.votations = votations;
    }
}
