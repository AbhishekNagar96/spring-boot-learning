package com.ancompany.item;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	// get mappings  usually indicate 200 OK
	@RequestMapping("/item")
	public List<Item> getAllItems() {
		return itemService.getAllItems();
	}
	
	@RequestMapping("/item/{itemtyp}")
	public List<Item> getItems(@PathVariable String itemtyp){
		return itemService.getItems(itemtyp);
	}
	
	@RequestMapping("/item/{l}/{h}")
	public List<Item> getItemsBasedOnPrice(@PathVariable int l, @PathVariable int h){
		return itemService.getItemsBasedOnPrice(l,h);
	}
	
	@RequestMapping("/item/{itemtyp}/{l}/{h}")
	public List<Item> getItemsBasedOnPriceAndType(@PathVariable String itemtyp,@PathVariable int l, @PathVariable int h){
		return itemService.getItemsBasedOnPriceAndtype(itemtyp,l,h);
	}
	
	//post mappings
    @RequestMapping(method=RequestMethod.POST, value="/item")
    public ResponseEntity<Item> addItem(@RequestBody Item item) {
    	if(item.name.length()==0)
    	{
    		return new ResponseEntity<Item>(item,HttpStatus.BAD_REQUEST);   //400
    	}
    	
    	if(itemService.checkexisting(item))
    	{
    		return new ResponseEntity<Item>(item,HttpStatus.SEE_OTHER);  //303
    	}
    	
    	if(item.price<0)
    	{
    		return new ResponseEntity<Item>(item,HttpStatus.BAD_REQUEST); //400
    	}
    	
    	itemService.addItem(item);
    	return new ResponseEntity<Item>(item,HttpStatus.CREATED);  //201
    	
    }
    
    // put mappings
    @RequestMapping(method=RequestMethod.PUT,value="/item/{name}")
    public ResponseEntity<String> updateItem(@RequestBody Item item, @PathVariable String name){
    	
    	itemService.updateItem(item, name);
    	return new ResponseEntity<String>("Successfully updated",HttpStatus.OK);  // 200
    }
    
    //delete mappings
    @RequestMapping(method=RequestMethod.DELETE,value="/item/{name}")
    public ResponseEntity<String> deleteItem(@PathVariable String name){
    	
    	itemService.deleteItem(name);
    	return new ResponseEntity<String>("Successfully deleted the item",HttpStatus.OK); // OK
    }
    
    @RequestMapping(method=RequestMethod.DELETE,value="/item")
    public ResponseEntity<String> deleteAllItems(){
    	
    	itemService.deleteAllItems();
    	return new ResponseEntity<String>("Successfully deleted the entire menu",HttpStatus.OK); // OK
    }
}
