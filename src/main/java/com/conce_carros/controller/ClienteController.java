package com.conce_carros.controller;

import com.conce_carros.domain.dto.ClienteDTO;
import com.conce_carros.domain.dto.ResponseClienteDTO;
import com.conce_carros.domain.service.IClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final IClienteService iClienteService;


    @GetMapping()
    public ResponseEntity<List<ClienteDTO>> getAll() {
        return ResponseEntity.ok(iClienteService.getAll());
    }

    @GetMapping("/{cedula}")
    public ResponseEntity<ClienteDTO> getClienteByCedula(@PathVariable String cedula) {
        return ResponseEntity.of(iClienteService.getClienteByCedula(cedula));
    }

    @GetMapping("/correo/{correo}")
    public ResponseEntity<ClienteDTO> getClienteByCorreo(@PathVariable String correo) {
        return ResponseEntity.of(iClienteService.getClienteByCorreo(correo));
    }


    @PostMapping()
    public ResponseEntity<ResponseClienteDTO> save(@RequestBody ClienteDTO clienteDTOnew) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(iClienteService.save(clienteDTOnew));
    }

    @PatchMapping
    public ResponseEntity<ClienteDTO> update(@RequestBody ClienteDTO clienteDTOupdate) {
        return ResponseEntity.of(iClienteService.update(clienteDTOupdate));
    }

    @DeleteMapping("/{cedula}")
    public ResponseEntity<Boolean> delete(@PathVariable String cedula) {
        return new ResponseEntity<>(this.iClienteService.delete(cedula) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}
