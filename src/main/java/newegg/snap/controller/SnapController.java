package newegg.snap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import io.mkeasy.resolver.CommandMap;
import lombok.extern.slf4j.Slf4j;
import newegg.snap.service.SnapBulkService;

@Slf4j
@Controller
public class SnapController {
	
	@Autowired
	SnapBulkService snapBulkService;

	@ResponseBody
	@RequestMapping(value= {"/snap.do"})
	public Object hello(ModelMap model, CommandMap commandMap) throws Exception {
		Object res = snapBulkService.post(commandMap);
		return res;
	}

}
