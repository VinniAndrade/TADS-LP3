package br.edu.ifsp.orderflow.service;

import br.edu.ifsp.orderflow.domain.Cliente;

public interface iNotificacaoService {
    void notificar(Cliente cliente, String mensagem);
}