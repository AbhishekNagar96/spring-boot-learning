package com.ancompany.item;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item,String>{
		public List<Item> findByItemTyp(String itemTyp);
		public List<Item> findByPriceBetween(int low, int high);
		public List<Item> findByItemTypAndPriceBetween(String itemTyp, int low, int high);
		
}
