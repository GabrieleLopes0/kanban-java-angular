package com.kanban.kanban.controller;

import com.kanban.kanban.dto.CardRequest;
import com.kanban.kanban.model.Card;
import com.kanban.kanban.model.StatusCard;
import com.kanban.kanban.service.CardService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cards")
@CrossOrigin
public class CardController {

    private final CardService service;

    public CardController(CardService service) {
        this.service = service;
    }

    @PostMapping
    public Card criar(@RequestBody CardRequest request) {
        return service.criarCard(request);
    }

    @GetMapping
    public List<Card> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Card buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }

    @PutMapping("/{id}")
    public Card atualizar(
            @PathVariable Long id,
            @RequestBody CardRequest request
    ) {
        return service.atualizar(id, request);
    }

    @PatchMapping("/{id}/status")
    public Card mudarStatus(
            @PathVariable Long id,
            @RequestParam StatusCard status
    ) {
        return service.mudarStatus(id, status);
    }

    @GetMapping("/status/{status}")
    public List<Card> listarPorStatus(@PathVariable StatusCard status) {
        return service.listarPorStatus(status);
    }
}