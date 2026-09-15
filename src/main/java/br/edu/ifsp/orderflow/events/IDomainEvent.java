package br.edu.ifsp.orderflow.events;

import java.time.Instant;

/**
 * Representa um fato, algo que aconteceu no domínio
 */
public interface IDomainEvent {
    Instant ocorridoEm();

}
