package cs50.bracket.domain;

public class Bracket {

    private Long id;
    private final String name;

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
}
