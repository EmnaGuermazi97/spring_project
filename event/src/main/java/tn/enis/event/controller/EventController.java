package tn.enis.event.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.enis.event.entity.Event;
import tn.enis.event.service.IEventService;

@RestController
@RequestMapping("/events")

public class EventController {
	@Autowired
	IEventService eventService;

	@PostMapping(value = "/add")
	public Event addEvent(@RequestBody Event event) {
		return eventService.add(event);
	}
	@PutMapping(value = "/update/{id}")
	public Event updateEvent(@RequestBody Event event) {
		return eventService.update(event);

	}

	@DeleteMapping(value = "delete/{id}")
	public void deleteEvent(@PathVariable Long id) {
		eventService.delete(id);

	}
	@GetMapping()
	public List<Event> findAllEvents() {
		return eventService.findAll();
	}

	@GetMapping(value = "/{id}")
	public Event findEventById(@PathVariable Long id) {

		return eventService.getById(id);

	}

	

}
