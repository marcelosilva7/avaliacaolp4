package com.avaliacao.avaliacao.repositories;

import com.avaliacao.avaliacao.models.Trabalho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrabalhoReppository extends JpaRepository <Trabalho, Long> {

    Trabalho findByIdTrabalho(Long idtrabalho);

//    List<Trabalho> findByTituloAndNota(String titulo, Integer nota);

    List<Trabalho> findByTituloContainingAndNotaGreaterThan(String palavraChave, Integer nota);

}
