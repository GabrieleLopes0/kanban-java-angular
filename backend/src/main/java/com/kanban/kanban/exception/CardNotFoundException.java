package com.kanban.kanban.exception;

public class CardNotFoundException extends RuntimeException {

    public CardNotFoundException(Long id) {
        super("Card não encontrado com id: " + id);
    }
}