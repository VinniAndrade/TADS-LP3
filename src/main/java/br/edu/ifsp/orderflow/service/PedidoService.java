package br.edu.ifsp.orderflow.service;

import br.edu.ifsp.orderflow.domain.Pedido;

public class PedidoService {

    private iEstoqueService estoqueService;

    public PedidoService(iEstoqueService estoqueService) {
        this.estoqueService = estoqueService;
    }

    public Pedido processar(Pedido pedido) {

        boolean foiReservado = this.estoqueService.reservar(pedido);

        if(!foiReservado){
            pedido.cancelar();
            //Salvar o pedido
            return pedido;
        }

        //Processar o pagamento

        //Salvar se o pagamento ocorreu com sucesso

        //Notificar o cliente

        //Retorna o pedido
        return pedido;
    }
}
