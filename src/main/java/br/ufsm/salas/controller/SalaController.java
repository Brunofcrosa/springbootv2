package br.ufsm.salas.controller;

import br.ufsm.salas.model.Sala;
import br.ufsm.salas.service.SalaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/salas")
@RequiredArgsConstructor
@Tag(name = "Salas", description = "Cadastro e manutenção das salas de aula da UFSM")
public class SalaController {

    private final SalaService salaService;

    @PostMapping
    @Operation(summary = "Cadastrar sala")
    public ResponseEntity<Sala> cadastrarSala(@RequestBody @Valid final Sala sala) {
        final Sala salaCadastrada = salaService.cadastrarSala(sala);
        return ResponseEntity.status(HttpStatus.CREATED).body(salaCadastrada);
    }

    @GetMapping
    @Operation(summary = "Buscar todas as salas")
    public ResponseEntity<List<Sala>> buscarTodasSalas() {
        return ResponseEntity.ok(salaService.buscarTodasSalas());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar sala por id")
    public ResponseEntity<Sala> buscarSalaPorId(@PathVariable final Long id) {
        return ResponseEntity.ok(salaService.buscarSalaPorId(id));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar sala")
    public ResponseEntity<Sala> atualizarSala(@PathVariable final Long id, @RequestBody @Valid final Sala sala) {
        return ResponseEntity.ok(salaService.atualizarSala(id, sala));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir sala")
    public ResponseEntity<Void> excluirSala(@PathVariable final Long id) {
        salaService.excluirSala(id);
        return ResponseEntity.noContent().build();
    }
}
