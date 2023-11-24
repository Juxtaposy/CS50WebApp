package cs50.bracket.repository;

import cs50.bracket.domain.Bracket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface BracketRepository extends JpaRepository<Bracket, Long> {

}
