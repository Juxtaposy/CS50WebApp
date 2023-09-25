package cs50.bracket.repository;

import cs50.bracket.domain.Bracket;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class BracketRepository {

    protected final Map<Long, Bracket> map = new HashMap<>();
    protected long counter = 1;

    public Bracket save(Bracket entity){
        setData(entity);
        return entity;
    }

    private Bracket setData(Bracket entity){
        if(entity.getId() != null){
            map.put(entity.getId(), entity);
        }
        else {
            entity.setId(counter);
            map.put(counter, entity);
            counter++;
        }
        return entity;
    }

    public Optional<Bracket> findById(Long id){
        return Optional.ofNullable(map.get(id));
    }
}
