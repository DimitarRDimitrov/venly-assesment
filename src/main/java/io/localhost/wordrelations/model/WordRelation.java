package io.localhost.wordrelations.model;


import jakarta.persistence.*;

@Entity
@Table(name = "word_relations")
public class WordRelation {

    @Id
    @SequenceGenerator(name= "WORD_RELATIONS_SEQUENCE", sequenceName = "WORD_RELATIONS_SEQ", initialValue=1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "WORD_RELATIONS_SEQUENCE")
    private long id;
    @Column(nullable = false)
    private String firstWord;
    @Column(nullable = false)
    private String secondWord;
    @Column(nullable = false)
    private String relation;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstWord() {
        return firstWord;
    }

    public void setFirstWord(String firstWord) {
        this.firstWord = firstWord;
    }

    public String getSecondWord() {
        return secondWord;
    }

    public void setSecondWord(String secondWord) {
        this.secondWord = secondWord;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }
}
