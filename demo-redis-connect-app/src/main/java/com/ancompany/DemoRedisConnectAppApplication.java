package com.ancompany;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ancompany.entity.Product;
import com.ancompany.repository.ProductDao;

@RestController
@SpringBootApplication
@RequestMapping("/product")
public class DemoRedisConnectAppApplication {

	@Autowired
	private ProductDao dao;
	
	@PostMapping
	public Product save(@RequestBody Product product) {
		return dao.save(product);
	}
	
	@GetMapping
	public List<Product> getAllProducts(){
		return dao.findAll();
	}
	
	@GetMapping("/{id}")
	public Product findProduct(@PathVariable int id) {
		return dao.findProductById(id);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(DemoRedisConnectAppApplication.class, args);
	}
	
	@DeleteMapping("/{id}")
	public String deleteProduct(@PathVariable int id) {
		return dao.deleteProduct(id);
	}
}
