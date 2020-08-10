package newegg.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import io.mkeasy.resolver.CommandMap;
import io.mkeasy.webapp.processor.QueryFactory;
import lombok.extern.slf4j.Slf4j;
import newegg.utils.QueryMap;

@Slf4j
@Controller
class HelloController {
	
	@Resource 
	ApplicationContext ctx;
	
	@ResponseBody
	@RequestMapping(value= {"/", "/hello.do"})
	public Object hello(ModelMap model, CommandMap commandMap) throws Exception {
		
		commandMap.debugParams();

		String message = "{'message' : '안녕! 꼬꼬 ETL'}";
		log.debug("{}", message);
		
		String ns = "newegg.hello.test";
		String nsId = "selectFromDual";
		QueryMap queryMap = new QueryMap();

		Object result = QueryFactory.execute(ns, nsId, queryMap);
		result = QueryFactory.getResult(ns, nsId, result);
		Map<String, Object> rts = QueryFactory.toMap(result);
		
		return rts;
	}
	
}
