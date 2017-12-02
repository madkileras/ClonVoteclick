package cl.voteclick.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "voters")
public class Voter {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String name;
    private String rut;
    private String email;
    private String phone;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "institutions_voters",
            joinColumns = @JoinColumn(name = "voter_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "institution_id", referencedColumnName = "id"))
    @JsonIgnore
    private Set<Institution> institutions;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "votations_voters",
            joinColumns = @JoinColumn(name = "voter_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "votation_id", referencedColumnName = "id"))
    @JsonIgnore
    private Set<Votation> votations;

    public Voter() {}

    public Voter(String name,
                 String rut,
                 String email,
                 String phone) {
        this.name = name;
        this.rut = rut;
        this.email = email;
        this.phone = phone;
        this.institutions = new HashSet<>();
        this.votations = new HashSet<>();
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRut() {
        return rut;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public Set<Institution> getInstitutions() {
        return institutions;
    }

    public void addInstitution(Institution institution) {
        this.institutions.add(institution);
    }

    public Set<Votation> getVotations() {
        return votations;
    }

    public void addVotation(Votation votation) {
        this.votations.add(votation);
    }
}
