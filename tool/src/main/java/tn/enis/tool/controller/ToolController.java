package tn.enis.tool.controller;

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
import tn.enis.tool.entity.Tool;
import tn.enis.tool.service.IToolService;

@RestController
@RequestMapping("/tools")

public class ToolController {
	
	@Autowired
	IToolService toolService;

	@PostMapping()
	public Tool addTool(@RequestBody Tool tool) {
		return toolService.add(tool);
	}

	@GetMapping()
	public List<Tool> findAllTools() {
		return toolService.findAll();
	}
	@PutMapping()
	public Tool updateTool(@RequestBody Tool tool) {
		return toolService.update(tool);

	}
	@GetMapping(value = "/{id}")
	public Tool findToolById(@PathVariable Long id) {

		return toolService.getById(id);

	}

	@DeleteMapping(value = "/{id}")
	public void DeleteTool(@RequestBody Long id) {
		toolService.delete(id);

	}

}
