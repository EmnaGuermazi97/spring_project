package tn.enis.tool.service;

import java.util.List;
import tn.enis.tool.entity.Tool;

public interface IToolService {
	List<Tool> findAll();

	Tool getById(Long id);

	Tool add(Tool tool);

	void delete(Long id);

	Tool update(Tool member);
}
