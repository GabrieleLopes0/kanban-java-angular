package com.kanban.kanban.repository;

import com.kanban.kanban.model.Card;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class CardRepository {

    private Map<Long, Card> banco = new HashMap<>();

    private AtomicLong contador = new AtomicLong(1);

    public Card salvar(Card card) {
        Long id = contador.getAndIncrement();
        card.setId(id);
        banco.put(id, card);
        return card;
    }

    public List<Card> listarTodos() {
        return new ArrayList<>(banco.values());
    }

    public Optional<Card> buscarPorId(Long id) {
        return Optional.ofNullable(banco.get(id));
    }

    public void deletar(Long id) {
        banco.remove(id);
    }

    public Card atualizar(Card card) {
        banco.put(card.getId(), card);
        return card;
    }
}