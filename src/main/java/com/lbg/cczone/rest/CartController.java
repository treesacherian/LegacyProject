package com.lbg.cczone.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lbg.cczone.domain.Cart;
import com.lbg.cczone.service.CartService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/cart")

public class CartController {

	private CartService service;

	public CartController(CartService service) {
		super();
		this.service = service;
	}

	@GetMapping("/get")
	public List<Cart> getCart() {
		return this.service.getCart();
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Cart> getCart(@PathVariable int id) {
		return this.service.getCart(id);
	}

	@PostMapping("/create")
	public ResponseEntity<Cart> createCart(@RequestBody Cart cart) {
		return this.service.createCart(cart);
	}

	@PatchMapping("/update/{id}")
	public ResponseEntity<Cart> updateCart(@PathVariable int id, @RequestBody Cart cart) {
		return this.service.updateCart(id, cart);
	}

	@DeleteMapping("/delete/{id}")
	public boolean deleteCart(@PathVariable int id) {

		return this.service.deleteCart(id);
	}

}
