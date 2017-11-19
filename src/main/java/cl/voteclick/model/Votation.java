package cl.voteclick.model;

import cl.voteclick.utils.VotationType;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="votations")
public class Votation {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String title;

    @Enumerated(EnumType.STRING)
    private VotationType type;

    @OneToMany(mappedBy= "votation", fetch=FetchType.EAGER)
    @JsonIgnore
    private Set<Vote> votes;

    @OneToMany(mappedBy= "votation", fetch=FetchType.EAGER)
    private Set<Option> options;

    @ManyToOne
    @JoinColumn(name="Institution_id")
    private Institution institution;

    @ManyToMany(mappedBy = "votations")
    @JsonIgnore
    private Set<Voter> voters;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "dd/MM/yyyy' a las 'HH:mm")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date initDate;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "dd/MM/yyyy' a las 'HH:mm")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date endDate;

    private boolean secondRound;

    public Votation() {}

    public Votation(String title,
                    VotationType type,
                    Set<Option> options,
                    Institution institution,
                    Set<Voter> voters,
                    Date initDate,
                    Date endDate,
                    boolean secondRound) {
        this.title = title;
        this.type = type;
        this.options = options;
        this.institution = institution;
        this.voters = voters;
        this.initDate = initDate;
        this.endDate = endDate;
        this.secondRound = secondRound;
        this.votes = new HashSet<>();
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public VotationType getType() {
        return type;
    }

    public Set<Vote> getVotes() {
        return this.votes;
    }

    public Set<Option> getOptions() {
        return options;
    }

    public Institution getInstitution() {
        return institution;
    }

    public void addVoter(Voter voter) {
        this.voters.add(voter);
    }

    public Date getInitDate(){
        return initDate;
    }

    public Date getEndDate(){
        return endDate;
    }

    public boolean isSecondRound() {
        return secondRound;
    }
}
