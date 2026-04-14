package com.kanban.kanban.dto;

import com.kanban.kanban.model.StatusCard;

import java.time.LocalDateTime;

public class CardResponse {

    private Long id;

    private String titulo;

    private String descricao;

    private StatusCard status;

    private Integer prioridade;

    private LocalDateTime dataCriacao;

    public CardResponse() {
    }

    public CardResponse(Long id, String titulo, String descricao, StatusCard status, Integer prioridade, LocalDateTime dataCriacao) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.status = status;
        this.prioridade = prioridade;
        this.dataCriacao = dataCriacao;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public StatusCard getStatus() {
        return status;
    }

    public Integer getPrioridade() {
        return prioridade;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }
}