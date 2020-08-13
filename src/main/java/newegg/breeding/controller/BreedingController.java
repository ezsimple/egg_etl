package newegg.breeding.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import io.mkeasy.resolver.CommandMap;
import lombok.extern.slf4j.Slf4j;
import newegg.breeding.service.BreedingBulkService;

@Slf4j
@Controller
public class BreedingController {
	
	@Autowired
	BreedingBulkService breedingBulkService;

	@ResponseBody
	@RequestMapping(value= {"/breeding.do"})
	public Object hello(ModelMap model, CommandMap commandMap) throws Exception {
		Object res = breedingBulkService.post(commandMap);
		return res;
	}

}
