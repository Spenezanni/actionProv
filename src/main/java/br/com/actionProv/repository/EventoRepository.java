package br.com.actionProv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.actionProv.model.Evento;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long> {

}
