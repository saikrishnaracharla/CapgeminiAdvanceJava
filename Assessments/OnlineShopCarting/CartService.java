package com.cg.ShopCart.service;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.cg.ShopCart.model.CartItem;
import com.cg.ShopCart.model.Product;

@Service
public class CartService {
	HashMap<Integer,CartItem> cart=new HashMap<>();
	
	public void addToCart(Product product,int quantity) {
		cart.computeIfPresent(product.getProductId(),(id,item)->{
			item.setQuantity(item.getQuantity()+quantity);
			return item;
		});
		cart.putIfAbsent(product.getProductId(),new CartItem(product,quantity));
	}
	public HashMap<Integer, CartItem> getCart() {
		return cart;
	}
	public double getTotalAmt() {
		return cart.values().stream().mapToDouble(CartItem::getTotalPrice).sum();
	}
	public void clearCart() {
		cart.clear();
	}
}
