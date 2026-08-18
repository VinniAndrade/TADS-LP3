package br.edu.ifsp.orderflow.service;

import br.edu.ifsp.orderflow.domain.Produto;
import br.edu.ifsp.orderflow.domain.Pedido;

public interface iEstoqueService {

    /**
     * Repõe unidades de um produto no estoque
     *
     * @param produto
     * @param quantidade
     */
    public void adicionarEstoque(Produto produto, int quantidade);

    /**
     * Quantidade disponível para um produto
     *
     * @param produto
     * @return
     */

    public int quantidadeDisponivel(Produto produto);

    /**
     * Tenta reservar o estoque de todos os itens do pedido
     *
     * @param pedido
     * @return tur se conseguir reservar, false do contrário
     */

    public boolean reservar(Pedido pedido);

    /**
     * Devolve ao estoque os itens de um pedido (ex.:pagamento recusado)
     * @param pedido
     */

    void liberar(Pedido pedido);
}
