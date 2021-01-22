package tn.enis.tool.service;

import java.util.List;
import org.springframework.stereotype.Service;
import tn.enis.tool.entity.Tool;
import tn.enis.tool.repository.ToolRepository;

@Service
public class ToolServiceImpl implements IToolService {
	private final ToolRepository toolRepository;

	public ToolServiceImpl(ToolRepository toolRepository) {
		super();
		this.toolRepository = toolRepository;
	}

	@Override
	public List<Tool> findAll() {
		return toolRepository.findAll();
	}

	@Override
	public Tool getById(Long id) {

		return toolRepository.findById(id).get();
	}

	@Override
	public Tool add(Tool tool) {

		return toolRepository.save(tool);
	}

	@Override
	public void delete(Long id) {
		toolRepository.deleteById(id);
	}

	@Override
	public Tool update(Tool tool) {

		return toolRepository.save(tool);
	}

	@Override
	public Tool getBySource(String source) {
		return toolRepository.findBySource(source);
	}

}
