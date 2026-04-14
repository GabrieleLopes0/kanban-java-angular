package com.kanban.kanban.service;

import com.kanban.kanban.dto.CardRequest;
import com.kanban.kanban.model.Card;
import com.kanban.kanban.model.StatusCard;
import com.kanban.kanban.repository.CardRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CardService {

    private final CardRepository repository;

    public CardService(CardRepository repository) {
        this.repository = repository;
    }

    public Card criarCard(CardRequest request) {
        Card card = new Card();

        card.setTitulo(request.getTitulo());
        card.setDescricao(request.getDescricao());
        card.setPrioridade(request.getPrioridade());
        card.setStatus(StatusCard.TODO);
        card.setDataCriacao(LocalDateTime.now());

        return repository.salvar(card);
    }

    public List<Card> listarTodos() {
        return repository.listarTodos();
    }

    public Card buscarPorId(Long id) {
        return repository.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Card não encontrado"));
    }

    public void deletar(Long id) {
        repository.deletar(id);
    }

    public Card atualizar(Long id, CardRequest request) {

        Card card = buscarPorId(id);

        card.setTitulo(request.getTitulo());
        card.setDescricao(request.getDescricao());
        card.setPrioridade(request.getPrioridade());

        return repository.atualizar(card);
    }

    public Card mudarStatus(Long id, StatusCard status) {

        Card card = buscarPorId(id);

        card.setStatus(status);

        return repository.atualizar(card);
    }

    public List<Card> listarPorStatus(StatusCard status) {
        return repository.listarTodos()
                .stream()
                .filter(card -> card.getStatus() == status)
                .toList();
    }
}