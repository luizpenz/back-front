package com.backend.api.pessoa;

import com.backend.api.core.response.ModelResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService service;

    @CrossOrigin
    @GetMapping
    public ResponseEntity<Page<Pessoa>> findAll(Pageable pageable){
        return ResponseEntity.ok(service.findAll(pageable));
    }

    @CrossOrigin
    @PostMapping
    public ResponseEntity<ModelResponse> store(@Valid @RequestBody Pessoa pessoa){
        return ResponseEntity.ok(ModelResponse.withData(service.save(pessoa)));
    }

    @CrossOrigin
    @PutMapping
    public ResponseEntity<ModelResponse> update(@RequestBody @Valid Pessoa p) {
        return ResponseEntity.ok(ModelResponse.withData(service.update(p)));
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public void remove(@PathVariable Integer id) {
        service.deleteById(id);
    }
}
