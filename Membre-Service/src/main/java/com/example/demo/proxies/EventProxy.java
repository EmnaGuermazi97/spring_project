package com.example.demo.proxies;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.Bean.EventBean;
import com.example.demo.Bean.PublicationBean;

@FeignClient("evenement-service")
public interface EventProxy {
	@GetMapping("/events/{id}")
	EntityModel<EventBean>findEventById(@PathVariable("id") Long id);
	@GetMapping("/events")
	CollectionModel<EventBean>findAllEvents();
}
