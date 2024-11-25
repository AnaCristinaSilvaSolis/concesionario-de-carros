package com.conce_carros.controller;

import com.conce_carros.domain.pojo.MarcaCarroPojo;
import com.conce_carros.domain.service.IMarcaCarroService;
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
    private final IMarcaCarroService iMarcaCarroService;

    /**
     * Devuelve lista de marcas carro
     * @return HttpCode OK con lista de marcas carro
     */
    @GetMapping()
    public ResponseEntity<List<MarcaCarroPojo>> getAll() {
        return ResponseEntity.ok(iMarcaCarroService.getAll());
    }

    /**
     * Devuelve una marca carro dado su id
     * @param id Id de la marca carro a buscar
     * @return HttpCode OK si la encuentra, Http Not Found de lo contrario
     */
    @GetMapping("/{id}")
    public ResponseEntity<MarcaCarroPojo> getMarcaCarro(@PathVariable Integer id) {
        return ResponseEntity.of(iMarcaCarroService.getMarcaCarro(id));
    }

    /**
     * Crea una nueva marca carro
     * @param marcaCarroPojonew Marca carro a crear
     * @return HttpCode Created si la guarda correctamente, HttpCode BadRequest de lo contrario
     */
    @PostMapping()
    public ResponseEntity<MarcaCarroPojo> save (@RequestBody MarcaCarroPojo marcaCarroPojonew){
        try{
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(iMarcaCarroService.save(marcaCarroPojonew));
        }catch (Exception e){
            //Todo: cambiar
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    /**
     * Actualiza una marca carro
     * @param marcaCarroPojoUpdate Marca carro actualizada
     * @return HttpCode OK si la actualiza correctamente
     */

    @PatchMapping
    public ResponseEntity<MarcaCarroPojo> update(@RequestBody MarcaCarroPojo marcaCarroPojoUpdate){

        return ResponseEntity.of(iMarcaCarroService.update(marcaCarroPojoUpdate));
    }

    /**
     * Elimina una marca carro dado su id
     * @param id Id marca carro a eliminar
     * @return HttpCode OK si la elimina, Http Not Found si no la encuentra
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Integer id){
        return new ResponseEntity<>(this.iMarcaCarroService.delete(id) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

}
