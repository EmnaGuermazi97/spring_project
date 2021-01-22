package tn.enis.tool.controller;

import java.util.List;

import javax.ws.rs.core.Application;

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

	@PostMapping(value = "/add")
	public Tool addTool(@RequestBody Tool tool) {
		return toolService.add(tool);
	}
	@PutMapping(value = "/update/{id}")
	public Tool updateTool(@RequestBody Tool tool) {
		return toolService.update(tool);

	}
	@DeleteMapping(value = "delete/{id}")
	public void DeleteTool(@PathVariable Long id) {
		toolService.delete(id);

	}
	@GetMapping()
	public List<Tool> findAllTools() {
		return toolService.findAll();
	}
	
	@GetMapping(value = "/{id}")
	public Tool findToolById(@PathVariable Long id) {

		return toolService.getById(id);

	}
	
	@GetMapping(value = "/find/{source}")
	public Tool findToolBySource(@PathVariable String source) {

		return toolService.getBySource(source);

	}

	

}
