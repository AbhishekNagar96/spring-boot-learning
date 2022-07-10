package com.ancompany.item;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
	
	@Autowired
	private ItemRepository itemRepository;

	//for get requests
	public List<Item> getAllItems() {
		
		List<Item>item= new ArrayList<>();
		itemRepository.findAll()
		.forEach(item::add);
		
		return item;
	}

	public List<Item> getItems(String itemtyp) {
		return itemRepository.findByItemTyp(itemtyp);
	}
	
	public List<Item> getItemsBasedOnPrice(int l, int h){
		return itemRepository.findByPriceBetween(l,h);
	}

	public List<Item> getItemsBasedOnPriceAndtype(String itemtyp, int l, int h) {
		return itemRepository.findByItemTypAndPriceBetween(itemtyp,l,h);
	}
	
	//for post requests
	public void addItem(Item item) {
		itemRepository.save(item);
	}
	
	public boolean checkexisting(Item item) {
		return itemRepository.existsById(item.name);
	}
	
	// for put requests
	public void updateItem(Item item, String name)
	{
		itemRepository.save(item);
	}
	
	// for delete requests
	public void deleteItem(String name)
	{
		itemRepository.deleteById(name);
	}
	
	public void deleteAllItems() {
		itemRepository.deleteAll();
	}

}
