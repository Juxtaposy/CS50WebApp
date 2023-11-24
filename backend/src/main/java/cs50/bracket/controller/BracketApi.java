package cs50.bracket.controller;


import cs50.bracket.controller.request.BracketRequest;
import cs50.bracket.controller.request.BracketUpdateRequest;
import cs50.bracket.controller.response.BracketResponse;
import cs50.bracket.service.BracketService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/brackets")
@CrossOrigin(origins = "http://localhost:3000")
public class BracketApi {

    private final BracketService bracketService;

    BracketApi(BracketService bracketService){
        this.bracketService = bracketService;
    }

    @PostMapping
    public ResponseEntity<BracketResponse> create(@RequestBody BracketRequest bracketRequest){
        BracketResponse bracketResponse = bracketService.create(bracketRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(bracketResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BracketResponse> find(@PathVariable Long id){
        BracketResponse bracketResponse = bracketService.find(id);
        return ResponseEntity.status(HttpStatus.OK).body(bracketResponse);
    }

    @PutMapping
    public ResponseEntity<BracketResponse> update(@RequestBody BracketUpdateRequest updateBracketRequest){
        BracketResponse bracketResponse = bracketService.update(updateBracketRequest);
        return ResponseEntity.status(HttpStatus.OK).body(bracketResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BracketResponse> update(@PathVariable Long id, @RequestBody BracketUpdateRequest updateBracketRequest){
        BracketResponse bracketResponse = bracketService.updateById(id, updateBracketRequest);
        return ResponseEntity.status(HttpStatus.OK).body(bracketResponse);
    }

    @GetMapping
    public ResponseEntity<List<BracketResponse>> findAll() {
        List<BracketResponse> bracketResponses = bracketService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(bracketResponses);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        bracketService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
