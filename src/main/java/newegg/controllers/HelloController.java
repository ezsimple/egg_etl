package newegg.controllers;

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

		String message = "{'message' : '안녕! 꼬꼬 ETL'}";
		log.debug("{}", message);
		
		String ns = "newegg.hello.test";
		String nsId = "selectFromDual";
		QueryMap queryMap = new QueryMap();

		Object result = QueryFactory.execute(ns, nsId, queryMap);
		result = QueryFactory.getResult(ns, nsId, result);
		Map<String, Object> rts = QueryFactory.toMap(result);
		
		ns = "newegg.breeding.main";
		nsId = "etlQuery";
		result = QueryFactory.execute(ns, nsId, queryMap);
		result = QueryFactory.getResult(ns, nsId, result);
		List<QueryMap> list = QueryFactory.toList(result);
		
		StringBuffer bulkStr = new StringBuffer();
		for(QueryMap item : list) {
			String index = String.valueOf(item.get("index_meta"));
			String field = String.valueOf(item.get("cj_chickienfarm_ps_idx"));
			if(StringUtils.isEmpty(index)) continue;

			bulkStr.append(index+"\n");
			bulkStr.append(field+"\n");
			// log.debug("{}", index);
			// log.debug("{}", field);
		}
		// log.debug("{}",bulkStr.toString());

        final String method = "POST";
        final String endpoint = "_bulk";

		Request req = new Request(method, endpoint);
		req.setJsonEntity(bulkStr.toString());
		Response response = restClient.performRequest(req);
		String res = (EntityUtils.toString(response.getEntity()));
		JSONObject object = new JSONObject(res);
		log.debug("ES Result : {}", object.toString(2));
		
		String isOk = (boolean) object.get("errors") == false ? "success": "fail";
		return isOk;
	}

}
