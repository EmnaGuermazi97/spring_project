package tn.enis.event.service;

import java.util.List;
import org.springframework.stereotype.Service;


import tn.enis.event.entity.Event;
import tn.enis.event.repository.EventRepository;

@Service
public class EventServiceImpl implements IEventService {
	private final EventRepository eventRepository;

	public EventServiceImpl(EventRepository eventRepository) {
		super();
		this.eventRepository = eventRepository;
	}

	@Override
	public List<Event> findAll() {
		return eventRepository.findAll();
	}

	@Override
	public Event getById(Long id) {
		return eventRepository.findById(id).get();
	}

	@Override
	public Event add(Event event) {
		return eventRepository.save(event);
	}

	@Override
	public void delete(Long id) {
		eventRepository.deleteById(id);
	}

	@Override
	public Event update(Event event) {

		return eventRepository.save(event);
	}

	@Override
	public Event getByTitle(String title) {
		return eventRepository.findByTitle(title);
	}

}
