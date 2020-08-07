package newegg.controller;

import javax.annotation.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import io.mkeasy.resolver.CommandMap;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
class HelloController {
	
	@Resource 
	ApplicationContext ctx;
	
	@ResponseBody
	@RequestMapping(value= {"/", "/hello.do"})
	public String hello(ModelMap model, CommandMap commandMap) throws Exception {
		String message = "{'message' : '안녕! 꼬꼬 ETL'}";
		log.debug("{}", message);
		return message;
	}
	
}
