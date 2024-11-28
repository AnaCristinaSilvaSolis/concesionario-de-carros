package com.conce_carros.controller;

import com.conce_carros.domain.dto.MarcaCarroDTO;
import com.conce_carros.domain.service.useCase.IMarcaCarroUseCase;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador rest de marca carro
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/marcas-carros")
@Tag(name = "Marca Carro", description = "Controller for Marca Carro")
public class MarcaCarroController {

    /**
     * Servicio de marca carro
     */
    private final IMarcaCarroUseCase iMarcaCarroUseCase;

    /**
     * Devuelve lista de marcas carro
     * @return HttpCode OK con lista de marcas carro
     */
    @GetMapping()
    public ResponseEntity<List<MarcaCarroDTO>> getAll() {
        return ResponseEntity.ok(iMarcaCarroUseCase.getAll());
    }

    /**
     * Devuelve una marca carro dado su id
     * @param id Id de la marca carro a buscar
     * @return HttpCode OK si la encuentra, Http Not Found de lo contrario
     */
    @GetMapping("/{id}")
    public ResponseEntity<MarcaCarroDTO> getMarcaCarro(@PathVariable Integer id) {
        return ResponseEntity.of(iMarcaCarroUseCase.getMarcaCarro(id));
    }

    /**
     * Crea una nueva marca carro
     * @param marcaCarroPojonew Marca carro a crear
     * @return HttpCode Created si la guarda correctamente, HttpCode BadRequest de lo contrario
     */
    @PostMapping()
    public ResponseEntity<MarcaCarroDTO> save (@RequestBody MarcaCarroDTO marcaCarroPojonew){
        try{
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(iMarcaCarroUseCase.save(marcaCarroPojonew));
        }catch (Exception e){
            //Todo: cambiar
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    /**
     * Actualiza una marca carro
     * @param marcaCarroDTOUpdate Marca carro actualizada
     * @return HttpCode OK si la actualiza correctamente
     */

    @PatchMapping
    public ResponseEntity<MarcaCarroDTO> update(@RequestBody MarcaCarroDTO marcaCarroDTOUpdate){

        return ResponseEntity.of(iMarcaCarroUseCase.update(marcaCarroDTOUpdate));
    }

    /**
     * Elimina una marca carro dado su id
     * @param id Id marca carro a eliminar
     * @return HttpCode OK si la elimina, Http Not Found si no la encuentra
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Integer id){
        return new ResponseEntity<>(this.iMarcaCarroUseCase.delete(id) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

}
