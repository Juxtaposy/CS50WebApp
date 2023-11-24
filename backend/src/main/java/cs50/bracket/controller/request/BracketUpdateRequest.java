package cs50.bracket.controller.request;

import com.fasterxml.jackson.annotation.JsonCreator;

public class BracketUpdateRequest extends BracketRequest{

    private final Long id;

    @JsonCreator
    public BracketUpdateRequest(String name, Long id){
        super(name);
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
