package cs50.bracket.controller.response;

public class BracketResponse {

    private final Long id;
    private final String name;

    public BracketResponse(Long id, String name){
        this.id = id;
        this.name = name;
    }

    public Long getId(){
        return id;
    }

    public String getName(){
        return name;
    }
}
