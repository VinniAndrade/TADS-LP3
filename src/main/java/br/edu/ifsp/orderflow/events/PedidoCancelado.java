package br.edu.ifsp.orderflow.events;

import br.edu.ifsp.orderflow.events.IDomainEvent;

import java.time.Instant;

public record PedidoCancelado (
        String pedidoId,
        String motivo,
        Instant ocorridoEm
) implements IDomainEvent{
}
