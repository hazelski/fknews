package br.com.fknews.location.controller;

import br.com.fknews.location.model.dto.LocationDTO;
import br.com.fknews.location.model.request.LocationRequest;
import br.com.fknews.location.service.LocationCrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/authenticated/location")
public class LocationAuthenticatedController {

    private final LocationCrudService service;

    @PostMapping
    public ResponseEntity<LocationDTO> create(@RequestBody @Validated LocationRequest request){
        LocationDTO response = service.create(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LocationDTO> update(@PathVariable  Long id,
                                            @RequestBody @Validated LocationRequest request) {
        LocationDTO response = service.update(request, id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id){
        service.remover(id);
        return ResponseEntity.accepted().build();
    }

}
