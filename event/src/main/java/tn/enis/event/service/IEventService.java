package tn.enis.event.service;

import java.util.List;

import tn.enis.event.entity.Event;

public interface IEventService {
	List<Event> findAll();

	Event getById(Long id);

	Event add(Event evenement);

	void delete(Long id);

	Event update(Event evenement);

}
