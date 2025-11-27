package dev.andreyrsy.mspedidos.service;

import dev.andreyrsy.mspedidos.client.ProdutoClient;
import dev.andreyrsy.mspedidos.dto.ProdutoResponse;
import dev.andreyrsy.mspedidos.model.Pedido;
import dev.andreyrsy.mspedidos.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final ProdutoClient produtoClient;

    public PedidoService(PedidoRepository pedidoRepository, ProdutoClient produtoClient){
        this.pedidoRepository = pedidoRepository;
        this.produtoClient = produtoClient;
    }

    public Pedido criarPedido(Long produtoId, Integer quantidade){
        ProdutoResponse produtoResponse = produtoClient.buscarPorId(produtoId);
        Pedido pedido = new Pedido();
        pedido.setProdutoId(produtoId);
        pedido.setQuantidade(quantidade);
        pedido.setValorTotal(produtoResponse.preco().multiply(new BigDecimal(quantidade)));
        return pedidoRepository.save(pedido);
    }


}
