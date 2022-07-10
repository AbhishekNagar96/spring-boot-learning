package com.ancompany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class MysqlDemoConnectApplication implements CommandLineRunner{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public static void main(String[] args) {
		SpringApplication.run(MysqlDemoConnectApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception{
		
		String sql="CREATE TABLE abc(id INT NOT NULL, name VARCHAR(20), PRIMARY KEY(id))";
		jdbcTemplate.execute(sql);
		jdbcTemplate.execute("INSERT INTO abc (id, name) values (1, 'A')");
	}
}
