package com.conce_carros.controller;


import com.conce_carros.domain.dto.CarroDTO;
import com.conce_carros.domain.service.useCase.ICarroUseCase;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/carros")
@Tag(name = "Carro", description = "Controller for Carro")
public class CarroController {

    private final ICarroUseCase iCarroUseCase;

    @GetMapping()
    public ResponseEntity<List<CarroDTO>> getAll() {
        return ResponseEntity.ok(iCarroUseCase.getAll());
    }

    @GetMapping("/marca-carro/{marcaCarroId}")
    public ResponseEntity<List<CarroDTO>> getByIdMarcaCarro(@PathVariable Integer marcaCarroId) {
        return ResponseEntity.ok(iCarroUseCase.getByIdMarcaCarro(marcaCarroId));
    }

    @GetMapping("/precio/{precio}")
    public ResponseEntity<List<CarroDTO>> getCarrosByLessThan(@PathVariable Double precio) {
        return ResponseEntity.ok(iCarroUseCase.getCarrosByLessThan(precio));
    }

    @GetMapping("/{codigoCarro}")
    public ResponseEntity<CarroDTO> getCarro(@PathVariable Integer codigoCarro) {
        return ResponseEntity.of(iCarroUseCase.getCarro(codigoCarro));
    }

    @PatchMapping
    public ResponseEntity<CarroDTO> update(@RequestBody CarroDTO carroUpdate){

        return ResponseEntity.of(iCarroUseCase.update(carroUpdate));
    }

    @PostMapping()
    public ResponseEntity<CarroDTO> save (@RequestBody CarroDTO newCarro){
        try{
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(iCarroUseCase.save(newCarro));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @DeleteMapping("/{codigoCarro}")
    public ResponseEntity<Boolean> delete(@PathVariable Integer codigoCarro){
        return new ResponseEntity<>(this.iCarroUseCase.delete(codigoCarro) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}
