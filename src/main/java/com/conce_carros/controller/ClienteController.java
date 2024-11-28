package com.conce_carros.controller;

import com.conce_carros.domain.dto.ClienteDTO;
import com.conce_carros.domain.dto.ResponseClienteDTO;
import com.conce_carros.domain.service.useCase.IClienteUseCase;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/clientes")
@Tag(name = "Cliente", description = "Controller for Cliente")
public class ClienteController {

    private final IClienteUseCase iClienteUseCase;


    @GetMapping()
    public ResponseEntity<List<ClienteDTO>> getAll() {
        return ResponseEntity.ok(iClienteUseCase.getAll());
    }

    @GetMapping("/{cedula}")
    public ResponseEntity<ClienteDTO> getClienteByCedula(@PathVariable String cedula) {
        return ResponseEntity.of(iClienteUseCase.getClienteByCedula(cedula));
    }

    @GetMapping("/correo/{correo}")
    public ResponseEntity<ClienteDTO> getClienteByCorreo(@PathVariable String correo) {
        return ResponseEntity.of(iClienteUseCase.getClienteByCorreo(correo));
    }


    @PostMapping()
    public ResponseEntity<ResponseClienteDTO> save(@RequestBody ClienteDTO clienteDTOnew) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(iClienteUseCase.save(clienteDTOnew));
    }

    @PatchMapping
    public ResponseEntity<ClienteDTO> update(@RequestBody ClienteDTO clienteDTOupdate) {
        return ResponseEntity.of(iClienteUseCase.update(clienteDTOupdate));
    }

    @DeleteMapping("/{cedula}")
    public ResponseEntity<Boolean> delete(@PathVariable String cedula) {
        return new ResponseEntity<>(this.iClienteUseCase.delete(cedula) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}
