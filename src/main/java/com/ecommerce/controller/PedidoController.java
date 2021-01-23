package com.ecommerce.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.db.PedidoRepository;
import com.ecommerce.model.Pedido;
import com.ecommerce.security.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "pedidos")
public class PedidoController {

	@Autowired
    UserService userService;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@GetMapping("/get")
	public List<Pedido> getPedidos() {
		return pedidoRepository.findAll();
	}
	
	@GetMapping("/get/{idPedido}")
	public Pedido getPedido(@PathVariable("idPedido") int idPedido) {
		return pedidoRepository.getOne(idPedido);
	}
	
	@PostMapping("/add")
	public void createPedido(@RequestBody Pedido pedido) throws IOException {
		long id = pedido.getIdUser();
		pedido.setUser(userService.getById(id));
		pedidoRepository.save(pedido);
	}
	
	@DeleteMapping(path = { "/{id}" })
	public Pedido deletePedido(@PathVariable("id") int id) {
		Pedido pedido = pedidoRepository.getOne(id);
		pedidoRepository.deleteById(id);
		return pedido;
	}
}
