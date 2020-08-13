package newegg.snap.service;

import java.util.List;

import org.apache.http.util.EntityUtils;
import org.elasticsearch.client.Request;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import io.mkeasy.resolver.CommandMap;
import io.mkeasy.utils.QueryMap;
import io.mkeasy.webapp.processor.QueryFactory;
import lombok.extern.slf4j.Slf4j;
import newegg.common.service.AbstractEtlService;

@Slf4j
@Service("snap1MainService")
public class Snap1MainServiceImpl extends AbstractEtlService {

	@Autowired
	private Environment env;

	@Autowired
	RestClient restClient;

    private String method = "POST";
    private String endpoint = "_bulk";

	@Override
	public String post(CommandMap commandMap) throws Exception {

		// Mandatory - RDB 
		String ns = "newegg.snap.main";
		String nsId = "etlQuery";

		// Mandatory - ES Bulk 
		String index_meta = "index_meta";
		String field_name = "cj_chickienfarm_snap_idx";
		QueryMap queryMap = new QueryMap();

		// 1. Extract&Transfer From RDB
		Object result = QueryFactory.execute(ns, nsId, queryMap);
		result = QueryFactory.getResult(ns, nsId, result);
		List<QueryMap> list = QueryFactory.toList(result);

		// 2. Load to ES
		Request req = new Request(method, endpoint);
		String bulkStr = makeBulkParams(list, index_meta, field_name);
		req.setJsonEntity(bulkStr);
		Response response = restClient.performRequest(req);

		// 3. Check Response
		String res = (EntityUtils.toString(response.getEntity()));
		JSONObject object = new JSONObject(res);
		log.debug("ES Result : {}", getSuccess(object));
		
		return bulkStr;
	}

}
