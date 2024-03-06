package com.lbg.cczone.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
@JsonIgnoreProperties("inspection")
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String buyer;
	// @JsonProperty("cartItemQuantity")
//	private Integer cartItemQuantity;

	@JsonManagedReference
	@OneToMany(mappedBy = ("cart"))
	private List<Item> items;

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cart(Integer id, String buyer, List<Item> items) {
//		super();
		this.id = id;
		this.buyer = buyer;
		this.items = items;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public String getBuyer() {
		return buyer;
	}

	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}

}
