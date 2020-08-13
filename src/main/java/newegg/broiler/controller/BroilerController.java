package newegg.broiler.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import io.mkeasy.resolver.CommandMap;
import lombok.extern.slf4j.Slf4j;
import newegg.broiler.service.BroilerMainServiceImpl;
import newegg.broiler.service.BroilerStd1ServiceImpl;
import newegg.broiler.service.BroilerStd2ServiceImpl;
import newegg.broiler.service.BroilerStd3ServiceImpl;
import newegg.broiler.service.BroilerStd4ServiceImpl;
import newegg.broiler.service.BroilerStd5ServiceImpl;

@Slf4j
@Controller
public class BroilerController {

	@Autowired
	BroilerMainServiceImpl broilerMainService;

	@Autowired
	BroilerStd1ServiceImpl broilerStd1Service;

	@Autowired
	BroilerStd2ServiceImpl broilerStd2Service;

	@Autowired
	BroilerStd3ServiceImpl broilerStd3Service;

	@Autowired
	BroilerStd4ServiceImpl broilerStd4Service;

	@Autowired
	BroilerStd5ServiceImpl broilerStd5Service;

	@ResponseBody
	@RequestMapping(value= {"/broiler.do"})
	public Object hello(ModelMap model, CommandMap commandMap) throws Exception {
		Object res = broilerMainService.post(commandMap);
		return res;
	}

}
