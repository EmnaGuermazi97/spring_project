package com.example.demo.proxies;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.Bean.EventBean;

@FeignClient("evenement-service")
public interface EventProxy {
	@PostMapping(value = "events/add")
	EntityModel<EventBean> addEvent(@RequestBody EventBean event);
	
	@PutMapping(value = "events/update/{id}")
	EntityModel<EventBean>updateEvent(@RequestBody EventBean event);
	
	@DeleteMapping(value = "events/delete/{id}")
	 void deleteEvent(@PathVariable Long id);
	
	@GetMapping("/events/{id}")
	EntityModel<EventBean>findEventById(@PathVariable("id") Long id);
	
	@GetMapping("/events")
	CollectionModel<EventBean>findAllEvents();

}






