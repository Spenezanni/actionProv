package br.com.actionProv.service;

import java.util.List;

import br.com.actionProv.model.Evento;


public interface EventoService {
	
    public Evento salvar(Evento evento); 
    
    public List<Evento> buscarListaDeEventos();
    
    public void deletarEvento(Long id);
    
    public void verificarIdEvento(Long id);
}
