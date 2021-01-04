package com.example.demo.proxies;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.Bean.ToolBean;
@FeignClient("outil-service")
public interface ToolProxy {
	@GetMapping(value="/tools/{id}")
	EntityModel<ToolBean> findToolById(@PathVariable Long id);
	
	@GetMapping(value = "/tools")
	CollectionModel<ToolBean> findAllTools();

}
