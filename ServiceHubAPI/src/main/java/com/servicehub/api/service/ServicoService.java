package com.servicehub.api.service;

import com.servicehub.api.dto.ServicoRequestDTO;
import com.servicehub.api.dto.ServicoResponseDTO;
import com.servicehub.api.exception.ResourceNotFoundException;
import com.servicehub.api.model.Servico;
import com.servicehub.api.repository.ServicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServicoService {

    private final ServicoRepository servicoRepository;

    @Transactional
    public ServicoResponseDTO criarServico(ServicoRequestDTO request) {
        Servico servico = Servico.builder()
                .nome(request.nome())
                .descricao(request.descricao())
                .preco(request.preco())
                .categoria(request.categoria())
                .ativo(request.ativo())
                .build();

        Servico salvo = servicoRepository.save(servico);
        return toResponseDTO(salvo);
    }

    @Transactional(readOnly = true)
    public List<ServicoResponseDTO> listarServicos() {
        return servicoRepository.findAll().stream()
                .map(this::toResponseDTO)
                .toList();
    }

    @Transactional(readOnly = true)
    public ServicoResponseDTO buscarPorId(Long id) {
        Servico servico = servicoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Serviço não encontrado com ID: " + id));
        return toResponseDTO(servico);
    }

    @Transactional
    public ServicoResponseDTO atualizarServico(Long id, ServicoRequestDTO request) {
        Servico servico = servicoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Serviço não encontrado com ID: " + id));

        servico.setNome(request.nome());
        servico.setDescricao(request.descricao());
        servico.setPreco(request.preco());
        servico.setCategoria(request.categoria());
        servico.setAtivo(request.ativo());

        Servico atualizado = servicoRepository.save(servico);
        return toResponseDTO(atualizado);
    }

    @Transactional
    public void deletarServico(Long id) {
        if (!servicoRepository.existsById(id)) {
            throw new ResourceNotFoundException("Serviço não encontrado com ID: " + id);
        }
        servicoRepository.deleteById(id);
    }

    private ServicoResponseDTO toResponseDTO(Servico servico) {
        return new ServicoResponseDTO(
                servico.getId(),
                servico.getNome(),
                servico.getDescricao(),
                servico.getPreco(),
                servico.getCategoria(),
                servico.getAtivo(),
                servico.getDataCriacao()
        );
    }
}
