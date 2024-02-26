package com.lbg.cczone.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lbg.cczone.Repos.ItemRepo;
import com.lbg.cczone.domain.Item;

@Service
public class ItemService {
	private ItemRepo repo;

	public ItemService(ItemRepo repo) {
		super();
		this.repo = repo;
	}

	public List<Item> getItem() {
		return this.repo.findAll();
	}

	public ResponseEntity<Item> getItem(int id) {
		Optional<Item> found = this.repo.findById(id);
		if (found.isEmpty()) {
			return new ResponseEntity<Item>(HttpStatus.NOT_FOUND);
		}
		Item body = found.get();
		return ResponseEntity.ok(body);
	}

	public ResponseEntity<Item> createItem(Item item) {
		Item created = this.repo.save(item);
		return new ResponseEntity<Item>(created, HttpStatus.CREATED);
	}

	public ResponseEntity<Item> updateItem(int id, Item item) {
		Optional<Item> found = this.repo.findById(id);
		if (found.isEmpty()) {
			return new ResponseEntity<Item>(HttpStatus.NOT_FOUND);
		}
		Item existing = found.get();
		if (item.getItemName() != null) {
			existing.setItemName(item.getItemName());
		}
		if (item.getItemPrice() != null) {
			existing.setItemPrice(item.getItemPrice());
		}
		if (item.getItemQuantity() != null) {
			existing.setItemQuantity(item.getItemQuantity());
		}

		Item updated = this.repo.save(existing);
		return ResponseEntity.ok(updated);

	}

	public boolean deleteItem(int id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);

	}

}
