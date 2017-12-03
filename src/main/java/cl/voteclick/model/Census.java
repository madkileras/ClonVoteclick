package cl.voteclick.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="census")
public class Census {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    //RECIENTE: many to one a institutions
    @ManyToOne
    @JoinColumn(name="Institution_id")
    private Institution institution;

    //RECIENTE: many to many a voter
    @ManyToMany(mappedBy = "censuses")
    private Set<Voter> voters;



    public Set<Voter> getAssociates() {
        return voters;
    }

    public void setAssociates(Set<Voter> associates) {
        this.voters = associates;
    }

    public Institution getInstitution() {
        return institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
