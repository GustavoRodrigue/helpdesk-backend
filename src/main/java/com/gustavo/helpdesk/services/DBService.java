package com.gustavo.helpdesk.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gustavo.helpdesk.domain.Chamado;
import com.gustavo.helpdesk.domain.Cliente;
import com.gustavo.helpdesk.domain.Tecnico;
import com.gustavo.helpdesk.domain.enuns.Perfil;
import com.gustavo.helpdesk.domain.enuns.Prioridade;
import com.gustavo.helpdesk.domain.enuns.Status;
import com.gustavo.helpdesk.repositories.ChamadoRepository;
import com.gustavo.helpdesk.repositories.ClienteRepository;
import com.gustavo.helpdesk.repositories.TecnicoRepository;

@Service
public class DBService {
	
	@Autowired
	private TecnicoRepository tecnicoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private ChamadoRepository chamadoRepository;
	
	public void instanciaBD() {
		Tecnico tec1 = new Tecnico(null, "Gustavo", "91379421403", "gustavo@gmail.com", "123");
		tec1.addPerfil(Perfil.ADMIN);
		
		Cliente cli1 = new Cliente(null, "João", "13588439102", "joao@gmail.com", "123");
		
		
		Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 01", "Primeiro chamado", tec1, cli1);
		
		tecnicoRepository.saveAll(Arrays.asList(tec1));
		clienteRepository.saveAll(Arrays.asList(cli1));
		chamadoRepository.saveAll(Arrays.asList(c1));
	}

}
