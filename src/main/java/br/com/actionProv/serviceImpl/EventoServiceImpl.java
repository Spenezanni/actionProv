package br.com.actionProv.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.actionProv.error.ResourceNotFoundException;
import br.com.actionProv.model.Evento;
import br.com.actionProv.repository.EventoRepository;
import br.com.actionProv.service.EventoService;

@Service
public class EventoServiceImpl implements EventoService {
	
	@Autowired
	private EventoRepository eventorepository;

	@Override
	public Evento salvar(Evento usuario) {
		return eventorepository.save(usuario);
	}

	@Override
	public List<Evento> buscarListaDeEventos() {
		return eventorepository.findAll();
	}

	@Override
	public void verificarIdEvento(Long id) {
		if (this.eventorepository.findById(id) == null) {
			throw new ResourceNotFoundException("Usuário não encontrado" + " " + id);
		}

	}

	@Override
	public void deletarEvento(Long id) {
		this.eventorepository.deleteById(id);
	}


}
