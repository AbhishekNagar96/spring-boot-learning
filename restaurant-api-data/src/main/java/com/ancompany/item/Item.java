package com.ancompany.item;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Item {
	
	@Id
	@GenericGenerator(name="system-uuid", strategy="uuid")
	String name;
	
	String itemTyp;
	int price;
	
	//constructors;
	public Item() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getItemTyp() {
		return itemTyp;
	}

	public void setItemTyp(String itemTyp) {
		this.itemTyp = itemTyp;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Item(String name, String itemTyp, int price) {
		super();
		this.name = name;
		this.itemTyp = itemTyp;
		this.price = price;
	}
	
	
}
