package com.ancompany.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
@EnableRedisRepositories
public class RedisConfig {
	
	@Bean(name = "factory")
	JedisConnectionFactory connectionFactory(){
		RedisStandaloneConfiguration configuration= new RedisStandaloneConfiguration();
		configuration.setHostName("localhost");
		configuration.setPort(6379);
		
		return new JedisConnectionFactory(configuration);
	}

    @Bean(name = "common")
    @Autowired
	public RedisTemplate<String,Object> redisTemplate(@Qualifier("factory") JedisConnectionFactory jedisConnectionFactory){
		RedisTemplate<String,Object> template= new RedisTemplate<String,Object>();
		template.setConnectionFactory(connectionFactory());
		template.setKeySerializer(new StringRedisSerializer());
		template.setHashKeySerializer(new StringRedisSerializer());
		template.setHashKeySerializer(new JdkSerializationRedisSerializer());
		template.setHashValueSerializer(new JdkSerializationRedisSerializer());
		template.setEnableTransactionSupport(true);
		template.afterPropertiesSet();
		
		return template;	
	}
}
