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

    //RECIENTE: many to many a census
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "census_voter",
            joinColumns = @JoinColumn(name = "voter_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "census_id", referencedColumnName = "id"))
    @JsonIgnore
    private Set<Census> censuses;
    public Set<Census> getCensuses() {
        return censuses;
    }

    public void setCensuses(Set<Census> censuses) {
        this.censuses = censuses;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setInstitutions(Set<Institution> institutions) {
        this.institutions = institutions;
    }

    public void setVotations(Set<Votation> votations) {
        this.votations = votations;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
}

