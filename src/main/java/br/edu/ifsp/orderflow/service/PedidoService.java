package br.edu.ifsp.orderflow.service;

import br.edu.ifsp.orderflow.domain.Pedido;
import br.edu.ifsp.orderflow.domain.ResultadoPagamento;

public class PedidoService {

    private final iEstoqueService estoqueService;
    private final iPedidoRepository pedidoRepository;
    private final iPagamentoGateway pagamentoGateway;
    private final iNotificacaoService notificacaoService;

    public PedidoService(
            iEstoqueService estoqueService,
            iPedidoRepository pedidoRepository,
            iPagamentoGateway pagamentoGateway,
            iNotificacaoService notificacaoService
    ) {
        this.estoqueService = estoqueService;
        this.pedidoRepository = pedidoRepository;
        this.pagamentoGateway = pagamentoGateway;
        this.notificacaoService = notificacaoService;
    }

    public Pedido processar(Pedido pedido) {

        boolean foiReservado = this.estoqueService.reservar(pedido);

        if(!foiReservado){
            pedido.cancelar();
            this.pedidoRepository.save(pedido);
            return pedido;
        }

        ResultadoPagamento resultado = this.pagamentoGateway.pagar(pedido);
        boolean naoAprovado = !resultado.isAprovado();

        if (naoAprovado) {
            this.estoqueService.liberar(pedido);
            pedido.cancelar();
            this.pedidoRepository.save(pedido);
            return pedido;
        }

        pedido.marcarComoPago();
        this.pedidoRepository.save(pedido);

        this.notificacaoService.notificar(
                pedido.getCliente(),
                "Pagamento aprovado! Pedido" + pedido.getIdCurto() + " confirmado"
        );

        return pedido;
    }
}