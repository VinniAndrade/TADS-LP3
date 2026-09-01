package br.edu.ifsp.orderflow.service;

import br.edu.ifsp.orderflow.domain.Pedido;

import java.util.List;
import java.util.Optional;

public interface iPedidoRepository {

    void save(Pedido pedido);

    Optional<Pedido> findById(String id );

    Optional<Pedido> findById();

    List<Pedido> findAll();
}
