package com.avaliacao.avaliacao.services;

import com.avaliacao.avaliacao.models.Trabalho;
import com.avaliacao.avaliacao.repositories.TrabalhoReppository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

@Service
public class TrabalhoService {

    final private TrabalhoReppository trabalhoReppository;


    public TrabalhoService(TrabalhoReppository trabalhoReppository) {
        this.trabalhoReppository = trabalhoReppository;
    }


    @Transactional
    public Trabalho criar(Trabalho trabalho) {
        LocalDate dataAtual = LocalDate.now();
        trabalho.setData_entrega(dataAtual.atStartOfDay());

        if(     trabalho == null ||
                trabalho.getTitulo() == null ||
                trabalho.getTitulo().isBlank() ||
                trabalho.getDescricao() == null ||
                trabalho.getDescricao().isBlank() ||
                trabalho.getGrupo() == null ||
                trabalho.getGrupo().isBlank() ||
                trabalho.getNota() == null ||
                trabalho.getJustificativa() == null ||
                trabalho.getJustificativa().isBlank()){
            throw new IllegalArgumentException("Trabalho com atributos inválidos!");
        }
        return trabalhoReppository.save(trabalho);
    }

    public List<Trabalho> findAll() {
        return trabalhoReppository.findAll();
    }

    public Trabalho findByIdTrabalho(Long idtrabalho){
        return trabalhoReppository.findByIdTrabalho(idtrabalho);

    }

//    public List<Trabalho> findByTituloAndNota (String titulo, Integer nota){
//        List<Trabalho> listaTodos = trabalhoReppository.findByTituloAndNota(titulo, nota);
//        List<Trabalho> listaSelecionado = new LinkedList<Trabalho>();
//        for(Trabalho trabalho:listaTodos){
//            if(lenght(trabalho.getTitulo() > 1 && trabalho.getNota() > 1){
//
//            }
//        }
//
//    }

    public List<Trabalho> buscarTrabalhosPorPalavraChaveENota(String palavraChave, Integer nota) {
        return trabalhoReppository.findByTituloContainingAndNotaGreaterThan(palavraChave, nota);
    }



}
