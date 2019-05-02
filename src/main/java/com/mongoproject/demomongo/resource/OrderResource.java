package com.mongoproject.demomongo.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mongoproject.demomongo.model.User;
import com.mongoproject.demomongo.repository.OrderRepository;

@RestController
public class OrderResource {

	@Autowired
	public OrderRepository orderRepository;
	
	@PostMapping("/addOrder")
	public boolean placeOrder(@RequestBody User user){
		orderRepository.save(user);
		return true;
	}
	
	@GetMapping("/getallOrder")
	public List<User> findAllOrder() {
		return orderRepository.findAll();
	}
	
	@GetMapping("/getUserByCityName/{city}")
	public List<User> findUserByCity(@PathVariable("city") String city) {
		
		return orderRepository.findUserByCity(city);
	}
}
