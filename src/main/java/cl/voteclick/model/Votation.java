package cl.voteclick.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;


@Entity
@Table(name="votations")

public class Votation {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String title;
    private String votationType;
    @OneToMany(mappedBy= "votations", fetch=FetchType.EAGER)
    private Set<Vote> votes;
    @OneToMany(mappedBy= "votations", fetch=FetchType.EAGER)
    private Set<Option> options;
    @ManyToOne
    @JoinColumn(name="Institution_id")
    private Institution institutions;

    @ManyToMany(mappedBy = "votations")
    private Set<Voter> voters;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd/MM/yyyy hh:mm") //this is for display and parsing, not storage
    private Date initDate;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm") //this is for display and parsing, not storage
    private Date endDate;



    public Votation(){
    }

    public Long getVotationId() {
        return id;
    }

    public void setVotationId(Long votationId) {
        this.id = votationId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVotationType() {
        return votationType;
    }

    public void setVotationType(String votationType) {
        this.votationType = votationType;
    }


    public Set<Vote> getVotes(){
        return votes;
    }
    @JsonIgnore
    public void setVotes(Set<Vote> votes) {
        this.votes = votes;
    }

    public Set<Option> getOptions() {
        return options;
    }

    public void setOptions(Set<Option> options) {
        this.options = options;
    }


    public Institution getInstitutions() {

        return institutions;
    }

    public void setInstitutions(Institution institutions) {
        this.institutions = institutions;
    }

    @JsonIgnore
    public Set<Voter> getVoters() {
        return voters;
    }

    public void setVoters(Set<Voter> voters) {
        this.voters = voters;
    }

    public Date getInitDate(){
        return initDate;
    }

    public void setInitDate(Date date){
        this.initDate=date;
    }

    public Date getEndDate(){
        return endDate;
    }

    public void setEndDate(Date date){
        this.endDate=date;
    }
}
