package com.servicehub.api.controller;

import com.servicehub.api.dto.ServicoRequestDTO;
import com.servicehub.api.dto.ServicoResponseDTO;
import com.servicehub.api.service.ServicoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/servicos")
@RequiredArgsConstructor
@Tag(name = "Serviços", description = "Operações de gerenciamento de serviços")
public class ServicoController {

    private final ServicoService servicoService;

    @PostMapping
    @Operation(summary = "Criar serviço", description = "Cria um novo serviço com os dados informados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Serviço criado com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ServicoResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = "Dados inválidos"),
            @ApiResponse(responseCode = "404", description = "Recurso não encontrado")
    })
    public ResponseEntity<ServicoResponseDTO> criarServico(@Valid @RequestBody ServicoRequestDTO request) {
        ServicoResponseDTO response = servicoService.criarServico(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    @Operation(summary = "Listar serviços", description = "Retorna a listagem completa de serviços cadastrados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ServicoResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = "Dados inválidos"),
            @ApiResponse(responseCode = "404", description = "Recurso não encontrado")
    })
    public ResponseEntity<List<ServicoResponseDTO>> listarServicos() {
        return ResponseEntity.ok(servicoService.listarServicos());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar serviço por ID", description = "Retorna um serviço específico com base no identificador informado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Serviço encontrado com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ServicoResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = "Dados inválidos"),
            @ApiResponse(responseCode = "404", description = "Serviço não encontrado")
    })
    public ResponseEntity<ServicoResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(servicoService.buscarPorId(id));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar serviço", description = "Atualiza os dados de um serviço existente com base no ID informado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Serviço atualizado com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ServicoResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = "Dados inválidos"),
            @ApiResponse(responseCode = "404", description = "Serviço não encontrado")
    })
    public ResponseEntity<ServicoResponseDTO> atualizarServico(@PathVariable Long id,
                                                             @Valid @RequestBody ServicoRequestDTO request) {
        return ResponseEntity.ok(servicoService.atualizarServico(id, request));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir serviço", description = "Remove um serviço com base no identificador informado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Serviço removido com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos"),
            @ApiResponse(responseCode = "404", description = "Serviço não encontrado")
    })
    public ResponseEntity<Void> deletarServico(@PathVariable Long id) {
        servicoService.deletarServico(id);
        return ResponseEntity.noContent().build();
    }
}
