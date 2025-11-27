package dev.andreyrsy.mspedidos.controller;

import dev.andreyrsy.mspedidos.model.Pedido;
import dev.andreyrsy.mspedidos.service.PedidoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService){
        this.pedidoService = pedidoService;
    }

    @PostMapping
    public Pedido criar(@RequestParam Long produtoId, @RequestParam Integer quantidade){
        return pedidoService.criarPedido(produtoId, quantidade);
    }
}










