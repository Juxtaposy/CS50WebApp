package cs50.bracket.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity(name = "brackets")
public class Bracket {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    public Bracket(){

    }
    public Bracket(String name){
        this.name = name;
    }

    public void setId(Long id){
        this.id = id;
    }

    public Long getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {this.name = name;}

}
