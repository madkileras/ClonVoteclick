
package cl.voteclick.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "votes")
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @ManyToOne
    private Votation votation;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "options_votes",
            joinColumns = @JoinColumn(name = "option_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "vote_id", referencedColumnName = "id"))
    private Set<Option> options;

    public Vote() {}

    public long getId() {
        return this.id;
    }

    public Set<Option> getOptions() {
        return options;
    }

    public void setOptions(Set<Option> options) {
        this.options = options;
    }

    public Votation getVotation() {
        return votation;
    }
}

