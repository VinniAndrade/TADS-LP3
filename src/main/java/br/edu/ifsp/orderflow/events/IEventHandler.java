package br.edu.ifsp.orderflow.events;

/**
 * Algo que irá consumir/reagir a um tipo especifico de evento
 * (uma class que implementa iDomainEvent).
 *
 * O parâmetro de tipo E garante, em TEMPO DE COMPILAÇÃO, que
 * um handler de PagamentoAprovado nunca receba um PagamentoRecusdo.
 */

public interface IEventHandler<E extends IDomainEvent> {

    void handle(E event);

    /**
     * Qual tipo de evento este handler trata/consome?
     *
     * Necessário por causa do apagamento de tipo do Java (type erasure)
     * @return
     */

    Class<E> eventType();
}
