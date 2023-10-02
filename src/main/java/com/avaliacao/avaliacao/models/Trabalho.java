package com.avaliacao.avaliacao.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tra_trabalho")
public class Trabalho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tra_id")
    private Long idTrabalho;

    @Column(name = "tra_titulo")
    private String titulo;

    @Column(name = "tra_data_hora_entrega")
    private LocalDateTime dataEntrega;

    @Column(name = "tra_descricao")
    private String descricao;

    @Column(name = "tra_grupo")
    private String grupo;

    @Column(name = "tra_nota")
    private Integer nota;

    @Column(name = "tra_justificativa")
    private String justificativa;

    public Trabalho(Long idTrabalho, String titulo, LocalDateTime data_entrega, String descricao, String grupo, Integer nota, String justificativa) {
        this.idTrabalho = idTrabalho;
        this.titulo = titulo;
        this.dataEntrega = data_entrega;
        this.descricao = descricao;
        this.grupo = grupo;
        this.nota = nota;
        this.justificativa = justificativa;
    }

    public Trabalho (){

    }

    public Long getIdTrabalho() {
        return idTrabalho;
    }

    public void setIdTrabalho(Long idTrabalho) {
        this.idTrabalho = idTrabalho;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDateTime getDataEntrega() {
        return dataEntrega;
    }

    public void setData_entrega(LocalDateTime data_entrega) {
        this.dataEntrega = data_entrega;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    public String getJustificativa() {
        return justificativa;
    }

    public void setJustificativa(String justificativa) {
        this.justificativa = justificativa;
    }
}
