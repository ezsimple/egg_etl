package newegg.snap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import io.mkeasy.resolver.CommandMap;
import lombok.extern.slf4j.Slf4j;
import newegg.snap.service.Snap1MainServiceImpl;
import newegg.snap.service.Snap2EggTransferServiceImpl;
import newegg.snap.service.Snap3HatcheryRecvServiceImpl;
import newegg.snap.service.Snap4GradingServiceImpl;
import newegg.snap.service.Snap5SettingServiceImpl;
import newegg.snap.service.Snap6HatchingServiceImpl;

@Slf4j
@Controller
public class SnapController {
	
	@Autowired
	Snap1MainServiceImpl snap1MainService;

	@Autowired
	Snap2EggTransferServiceImpl snap2EggTransferService;

	@Autowired
	Snap3HatcheryRecvServiceImpl snap3HatcheryRecvService;

	@Autowired
	Snap4GradingServiceImpl snap4GradingService;

	@Autowired
	Snap5SettingServiceImpl snap5SettingService;

	@Autowired
	Snap6HatchingServiceImpl snap6HatchingService;

	@ResponseBody
	@RequestMapping(value= {"/breeding.do"})
	public Object hello(ModelMap model, CommandMap commandMap) throws Exception {
		Object res = snap1MainService.post(commandMap);
		return res;
	}

}
