package newegg.breeding.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import io.mkeasy.resolver.CommandMap;
import lombok.extern.slf4j.Slf4j;

import newegg.breeding.service.Breeding1MainServiceImpl;
import newegg.breeding.service.Breeding2EgtServiceImpl;
import newegg.breeding.service.Breeding3HatcheryRecvServiceImpl;
import newegg.breeding.service.Breeding4GradingServiceImpl;
import newegg.breeding.service.Breeding5SettingServiceImpl;
import newegg.breeding.service.Breeding6HatchingServiceImpl;
import newegg.breeding.service.Breeding7Std10ServiceImpl;
import newegg.breeding.service.Breeding7Std11ServiceImpl;
import newegg.breeding.service.Breeding7Std12ServiceImpl;
import newegg.breeding.service.Breeding7Std13ServiceImpl;
import newegg.breeding.service.Breeding7Std14ServiceImpl;
import newegg.breeding.service.Breeding7Std1ServiceImpl;
import newegg.breeding.service.Breeding7Std2ServiceImpl;
import newegg.breeding.service.Breeding7Std3ServiceImpl;
import newegg.breeding.service.Breeding7Std4ServiceImpl;
import newegg.breeding.service.Breeding7Std5ServiceImpl;
import newegg.breeding.service.Breeding7Std6ServiceImpl;
import newegg.breeding.service.Breeding7Std7ServiceImpl;
import newegg.breeding.service.Breeding7Std8ServiceImpl;
import newegg.breeding.service.Breeding7Std9ServiceImpl;

@Slf4j
@Controller
public class BreedingController {

	@Autowired
	Breeding1MainServiceImpl breeding1MainService;

	@Autowired
	Breeding2EgtServiceImpl breeding2EgtService;

	@Autowired
	Breeding3HatcheryRecvServiceImpl breeding3HatcheryRecvService;

	@Autowired
	Breeding4GradingServiceImpl breeding4GradingService;

	@Autowired
	Breeding5SettingServiceImpl breeding5SettingService;

	@Autowired
	Breeding6HatchingServiceImpl breeding6HatchingService;

	@Autowired
	Breeding7Std1ServiceImpl breeding7Std1Service;

	@Autowired
	Breeding7Std2ServiceImpl breeding7Std2Service;

	@Autowired
	Breeding7Std3ServiceImpl breeding7Std3Service;

	@Autowired
	Breeding7Std4ServiceImpl breeding7Std4Service;

	@Autowired
	Breeding7Std5ServiceImpl breeding7Std5Service;

	@Autowired
	Breeding7Std6ServiceImpl breeding7Std6Service;

	@Autowired
	Breeding7Std7ServiceImpl breeding7Std7Service;

	@Autowired
	Breeding7Std8ServiceImpl breeding7Std8Service;

	@Autowired
	Breeding7Std9ServiceImpl breeding7Std9Service;

	@Autowired
	Breeding7Std10ServiceImpl breeding7Std10Service;

	@Autowired
	Breeding7Std11ServiceImpl breeding7Std11Service;

	@Autowired
	Breeding7Std12ServiceImpl breeding7Std12Service;

	@Autowired
	Breeding7Std13ServiceImpl breeding7Std13Service;

	@Autowired
	Breeding7Std14ServiceImpl breeding7Std14Service;

	@ResponseBody
	@RequestMapping(value= {"/breeding.do"})
	public Object hello(ModelMap model, CommandMap commandMap) throws Exception {
		Object res = breeding1MainService.post(commandMap);
		return res;
	}

}
