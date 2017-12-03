package cl.voteclick.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "institutions")
public class Institution {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String name;
    private String rut;
    private String description;
    private String email;
    private String phone;

    @OneToMany(mappedBy = "institution", fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<Votation> votations;

    //RECIENTE: one to may a census
    @OneToMany(mappedBy = "institution", fetch=FetchType.EAGER)
    @JsonIgnore
    private Set<Census> censuses;

    @ManyToMany(mappedBy = "institutions")
    @JsonIgnore
    private Set<Voter> voters;

    private boolean blocked;

    @PrePersist
    public void onCreate() {
        this.blocked = true;
    }

    public Institution() {}

    public Institution(String name,
                       String rut,
                       String email,
                       String phone) {
        this.name = name;
        this.rut = rut;
        this.email = email;
        this.phone = phone;
        this.voters = new HashSet<>();
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

    public String getDescription() {
        return description;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }
    @JsonIgnoreProperties("votation")
    public Set<Votation> getVotations() {
        return votations;
    }

    public void addVotation(Votation votation) {
        this.votations.add(votation);
    }

    public Set<Voter> getVoters() {
        return voters;
    }

    public void addVoter(Voter voter) {
        this.voters.add(voter);
    }

    public boolean isBlocked() {
        return blocked;
    }
}
