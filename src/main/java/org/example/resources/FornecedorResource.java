package org.example.resources;

import org.example.entities.Fornecedor;
import org.example.dto.FornecedorDTO;
import org.example.services.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/fornecedor")
public class FornecedorResource {

    @Autowired
    private FornecedorService service;

    @GetMapping
    public ResponseEntity<List<FornecedorDTO>> getAll(){
        List<Fornecedor> list = service.getAll();
        List<FornecedorDTO> listDto = list.stream().map(obj -> service.toNewDTO(obj))
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<FornecedorDTO> findById(@PathVariable Long id){
        Fornecedor obj = service.findById(id);
        FornecedorDTO dto = service.toNewDTO(obj);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    public ResponseEntity<Fornecedor> insert(@Valid @RequestBody FornecedorDTO objDto){

        Fornecedor createdFornecedor = service.insert(objDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdFornecedor);

    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@Valid @RequestBody FornecedorDTO objDTO, @PathVariable Long id) {

        service.update(id, objDTO);
        return ResponseEntity.noContent().build();

    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<Void> delete(@PathVariable Long id) {

        service.delete(id);
        return ResponseEntity.noContent().build();

    }

}