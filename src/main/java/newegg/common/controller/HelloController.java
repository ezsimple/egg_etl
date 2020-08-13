package newegg.common.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.http.util.EntityUtils;
import org.elasticsearch.client.Request;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import io.mkeasy.resolver.CommandMap;
import io.mkeasy.utils.QueryMap;
import io.mkeasy.webapp.processor.QueryFactory;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
class HelloController {
	
	@Resource 
	ApplicationContext ctx;

	@Autowired
	RestClient restClient;
	
	@ResponseBody
	@RequestMapping(value= {"/", "/hello.do"})
	public Object hello(ModelMap model, CommandMap commandMap) throws Exception {
		
		commandMap.debugParams();

		String ns = "newegg.hello.test";
		String nsId = "selectFromDual";
		QueryMap queryMap = new QueryMap();

		Object result = QueryFactory.execute(ns, nsId, queryMap);
		result = QueryFactory.getResult(ns, nsId, result);
		Map<String, Object> rts = QueryFactory.toMap(result);

		log.debug("{}", rts);
		
		return rts;
	}

}
