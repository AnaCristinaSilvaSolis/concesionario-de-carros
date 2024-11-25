package com.conce_carros.controller;

import com.conce_carros.domain.pojo.MarcaCarroPojo;
import com.conce_carros.domain.service.IMarcaCarroService;
import com.conce_carros.persistence.entity.MarcaCarroEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * Controlador rest de marca carro
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/marcas-carros")
public class MarcaCarroController {

    /**
     * Servicio de marca carro
     */
    private final IMarcaCarroService iMarcaCarroService;

    @GetMapping()
    public ResponseEntity<List<MarcaCarroPojo>> getAll() {
        List<MarcaCarroPojo> marcaCarroPojoList = iMarcaCarroService.getAll()
                .stream()
                .map(marca -> MarcaCarroPojo.builder()
                        .id(marca.getId())
                        .description(marca.getDescription())
                        .build())
                .toList();
        return ResponseEntity.ok(marcaCarroPojoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MarcaCarroPojo> getMarcaCarro(@PathVariable Integer id) {
        Optional<MarcaCarroPojo> marcaCarroPojoOptional = iMarcaCarroService.getMarcaCarro(id);

        if (marcaCarroPojoOptional.isPresent()) {
            MarcaCarroPojo marcaCarroPojo = marcaCarroPojoOptional.get();

            MarcaCarroPojo responsePojo = MarcaCarroPojo.builder()
                    .id(marcaCarroPojo.getId())
                    .description(marcaCarroPojo.getDescription())
                    .build();

            return ResponseEntity.ok(responsePojo);
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping("")
    public ResponseEntity<MarcaCarroPojo> save (@RequestBody MarcaCarroPojo marcaCarroPojonew){
        try{
            return ResponseEntity.status(HttpStatus.CREATED).body(iMarcaCarroService.save(marcaCarroPojonew));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }



}
