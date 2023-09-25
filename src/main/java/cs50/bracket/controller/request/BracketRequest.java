package cs50.bracket.controller.request;

import com.fasterxml.jackson.annotation.JsonCreator;

public class BracketRequest {

    private final String name;

    @JsonCreator
    public BracketRequest(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
