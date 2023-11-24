package cs50.bracket.mapper;

import cs50.bracket.controller.request.BracketRequest;
import cs50.bracket.controller.request.BracketUpdateRequest;
import cs50.bracket.controller.response.BracketResponse;
import cs50.bracket.domain.Bracket;
import org.springframework.stereotype.Component;

@Component
public class BracketMapper {

    public Bracket toBracket(BracketRequest bracketRequest){
        return new Bracket(bracketRequest.getName());
    }

    public Bracket toBracket(Bracket bracket, BracketUpdateRequest bracketUpdateRequest){
        bracket.setName(bracketUpdateRequest.getName());
        return bracket;
    }

    public Bracket toBracket(Bracket bracket, BracketRequest bracketRequest){
        bracket.setName(bracketRequest.getName());
        return bracket;
    }

    public BracketResponse toBracketResponse(Bracket bracket){
        return new BracketResponse(bracket.getId(), bracket.getName());
    }
}
