package br.ufsm.salas.service;

import br.ufsm.salas.infra.EntidadeNaoEncontradaException;
import br.ufsm.salas.infra.RegraNegocioException;
import br.ufsm.salas.model.Sala;
import br.ufsm.salas.model.SituacaoSala;
import br.ufsm.salas.repository.SalaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SalaService {

    private final SalaRepository salaRepository;

    @Transactional
    public Sala cadastrarSala(final Sala sala) {
        return salaRepository.save(sala);
    }

    @Transactional(readOnly = true)
    public List<Sala> buscarTodasSalas() {
        return salaRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Sala buscarSalaPorId(final Long id) {
        return buscarOuFalhar(id);
    }

    @Transactional
    public Sala atualizarSala(final Long id, final Sala salaAtualizada) {
        final Sala salaGerida = buscarOuFalhar(id);

        salaGerida.setNome(salaAtualizada.getNome());
        salaGerida.setCodigo(salaAtualizada.getCodigo());
        salaGerida.setCapacidadeAlunos(salaAtualizada.getCapacidadeAlunos());
        salaGerida.setQuantidadeComputadores(salaAtualizada.getQuantidadeComputadores());
        salaGerida.setAnoConstrucao(salaAtualizada.getAnoConstrucao());
        salaGerida.setArea(salaAtualizada.getArea());
        salaGerida.setSituacao(salaAtualizada.getSituacao());

        return salaRepository.save(salaGerida);
    }

    @Transactional
    public void excluirSala(final Long id) {
        final Sala salaExistente = buscarOuFalhar(id);

        if (salaExistente.getSituacao() == SituacaoSala.DISPONIVEL) {
            throw new RegraNegocioException("Salas com situação DISPONIVEL não podem ser excluídas.");
        }

        salaRepository.delete(salaExistente);
    }

    private Sala buscarOuFalhar(final Long id) {
        return salaRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Sala não encontrada"));
    }
}
