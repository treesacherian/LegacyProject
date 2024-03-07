//package com.lbg.cczone.dtos;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import com.lbg.cczone.domain.Cart;
//import com.lbg.cczone.domain.Item;
//
//public class CartDTO {
//
//	private Integer id;
//
//	private Integer cartItemQuantity;
//
//	// private List<Integer> itemId;
//
//	private List<Item> items = new ArrayList<>();
//
//	public CartDTO(Cart cart) {
//		super();
//		this.setId(cart.getId());
//		this.setCartItemQuantity(cart.getCartItemQuantity());
//		for (Item item : items) {
//			items.add(item.getCart().getItems());
//		}
//
//	// private List<ItemDTO> itemsDTO = new ArrayList<ItemDTO>();
//
////	public CartDTO(Cart cart) {
////		super();
////		this.setId(cart.getId());
////		this.setCartItemQuantity(cart.getCartItemQuantity());
////		//this.setItemId(cart.getItems().getId());
////		
////		for (ItemDTO  item : itemsDTO()) {
////			this.itemsDTO.add(new ItemDTO(item));
////		}
//
////	}
//
//	public CartDTO() {
//
//	}
//
//	public List<Item> getItems() {
//		return items;
//	}
//
//	public void setItems(List<Item> items) {
//		this.items = items;
//	}
//
//	public Integer getId() {
//		return id;
//	}
//
//	public void setId(Integer id) {
//		this.id = id;
//	}
//
//	public Integer getCartItemQuantity() {
//		return cartItemQuantity;
//	}
//
//	public void setCartItemQuantity(Integer cartItemQuantity) {
//		this.cartItemQuantity = cartItemQuantity;
//	}
//
//	public List<Integer> getItemId() {
//		return itemId;
//	}
//
//	public void setItemId(List<Integer> itemId) {
//		this.itemId = itemId;
//	}
//
//}
