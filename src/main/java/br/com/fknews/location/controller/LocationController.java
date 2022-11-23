package br.com.fknews.location.controller;

import br.com.fknews.location.model.dto.LocationDTO;
import br.com.fknews.location.service.LocationCrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/location")
public class LocationController {

    private final LocationCrudService service;

    @GetMapping
    public ResponseEntity<List<LocationDTO>> listAll(@RequestParam(defaultValue = "0") Integer page,
                                                     @RequestParam(defaultValue = "10") Integer pageSize){
        List<LocationDTO> response = service.listAll(page, pageSize);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LocationDTO> searchId(@PathVariable Long id){
        LocationDTO response = service.searchId(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
