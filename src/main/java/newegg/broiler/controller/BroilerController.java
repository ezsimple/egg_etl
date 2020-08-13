package newegg.broiler.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import io.mkeasy.resolver.CommandMap;
import lombok.extern.slf4j.Slf4j;
import newegg.broiler.service.BroilerBulkService;

@Slf4j
@Controller
public class BroilerController {

	@Autowired
	BroilerBulkService broilerBulkService;

	@ResponseBody
	@RequestMapping(value= {"/broiler.do"})
	public Object hello(ModelMap model, CommandMap commandMap) throws Exception {
		Object res = broilerBulkService.post(commandMap);
		return res;
	}

}
