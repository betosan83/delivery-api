package com.boscolo.deliveryapi.domain.service;

import java.time.LocalDateTime;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.boscolo.deliveryapi.domain.model.Entrega;
import com.boscolo.deliveryapi.domain.model.StatusEntrega;
import com.boscolo.deliveryapi.domain.repository.EntregaRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class SolicitacaoEntregaService {

	private EntregaRepository entregaRepository;
	
	@Transactional
	public Entrega solicitarEntrega(Entrega entrega) {
		entrega.setStatus(StatusEntrega.PENDENTE);
		entrega.setDataPedido(LocalDateTime.now());
		
		return entregaRepository.save(entrega);
	}
}
