package br.edu.ifsp.orderflow.infra;

import br.edu.ifsp.orderflow.domain.ItemPedido;
import br.edu.ifsp.orderflow.domain.Pedido;
import br.edu.ifsp.orderflow.domain.Produto;
import br.edu.ifsp.orderflow.service.iEstoqueService;

import java.util.HashMap;
import java.util.Map;

public class InMemoryEstoqueService implements iEstoqueService {

    private final Map<String, Integer> estoque = new HashMap<>();

    @Override
    public void adicionarEstoque(Produto produto, int quantidade) {
        int qtdAtual = this.estoque.getOrDefault(produto.getId(), 0);
        this.estoque.put(produto.getId(), quantidade);
    }

    @Override
    public int quantidadeDisponivel(Produto produto) {
        return this.estoque.getOrDefault(produto.getId(), 0)
        return 0;
    }

    @Override
    public boolean reservar(Pedido pedido) {
        for (int i = 0; i <pedido.getItens().size(); i++);
            ItemPedido item = this.itens.get
        return false;
    }

    @Override
    public void liberar(Pedido pedido) {

    }
}
