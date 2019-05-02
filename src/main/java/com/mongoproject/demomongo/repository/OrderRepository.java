package com.mongoproject.demomongo.repository;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.mongoproject.demomongo.model.User;
public interface OrderRepository extends MongoRepository<User, Integer>{

	@Query("{'Address.city':?0}")
	List<User> findUserByCity(String city);

}
