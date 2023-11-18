package com.atharva.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="cart_items",schema="cart")
public class Cart {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long prodId;
	
	@Column(name="prodName")
	private String prodName;
	
	@Column(name="prodQty")
	private int prodQty;
	
	@Column(name="prodPrice")
	private int prodPrice;
	

}
