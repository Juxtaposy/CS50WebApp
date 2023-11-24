package cs50.bracket.service;

import cs50.bracket.controller.request.BracketRequest;
import cs50.bracket.controller.request.BracketUpdateRequest;
import cs50.bracket.controller.response.BracketResponse;
import cs50.bracket.domain.Bracket;
import cs50.bracket.exception.BracketExceptionSupplier;
import cs50.bracket.mapper.BracketMapper;
import cs50.bracket.repository.BracketRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BracketService {

    private final BracketRepository bracketRepository;
    private final BracketMapper bracketMapper;

    public BracketService(BracketRepository bracketRepository, BracketMapper bracketMapper){
        this.bracketRepository = bracketRepository;
        this.bracketMapper = bracketMapper;
    }

    public BracketResponse create(BracketRequest bracketRequest){
        Bracket bracket = bracketRepository.save(bracketMapper.toBracket(bracketRequest));
        return bracketMapper.toBracketResponse(bracket);
    }

    public BracketResponse find(Long id) {
        Bracket bracket = bracketRepository.findById(id).orElseThrow(BracketExceptionSupplier.bracketNotFound(id));
        return bracketMapper.toBracketResponse(bracket);
    }

    public List<BracketResponse> findAll(){
        return bracketRepository.findAll().stream().map(bracketMapper::toBracketResponse).collect(Collectors.toList());
    }

    public BracketResponse update(BracketUpdateRequest bracketUpdateRequest) {
        Bracket bracket = bracketRepository.findById(bracketUpdateRequest.getId())
                .orElseThrow(BracketExceptionSupplier.bracketNotFound(bracketUpdateRequest.getId()));

        bracketRepository.save(bracketMapper.toBracket(bracket, bracketUpdateRequest));
        return bracketMapper.toBracketResponse(bracket);

    }

    public BracketResponse updateById(Long id, BracketUpdateRequest bracketUpdateRequest) {
        Bracket bracket = bracketRepository.findById(id)
                .orElseThrow(BracketExceptionSupplier.bracketNotFound(bracketUpdateRequest.getId()));

        bracketRepository.save(bracketMapper.toBracket(bracket, bracketUpdateRequest));
        return bracketMapper.toBracketResponse(bracket);

    }

    public void delete(Long id){
        Bracket bracket = bracketRepository.findById(id).orElseThrow(BracketExceptionSupplier.bracketNotFound(id));
        bracketRepository.deleteById(bracket.getId());
    }

}
