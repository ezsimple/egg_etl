package newegg.breeding.service;

import java.util.Date;

import org.apache.http.util.EntityUtils;
import org.elasticsearch.client.Request;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.mkeasy.resolver.CommandMap;
import io.mkeasy.utils.DateUtil;
import lombok.extern.slf4j.Slf4j;
import newegg.common.service.EtlService;

@Slf4j
@Service
public class BreedingBulkService implements EtlService {

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

	@Autowired
	RestClient restClient;
	
    private String method = "POST";
    private String endpoint = "_bulk";

	@Override
	public String post(CommandMap commandMap) throws Exception {

		Date start = new Date();

		// Basic
		breeding1MainService.post(commandMap);
		breeding2EgtService.post(commandMap);
		breeding3HatcheryRecvService.post(commandMap);
		breeding4GradingService.post(commandMap);
		breeding5SettingService.post(commandMap);
		breeding6HatchingService.post(commandMap);

		// Standard
		breeding7Std1Service.post(commandMap);
		breeding7Std2Service.post(commandMap);
		breeding7Std3Service.post(commandMap);
		breeding7Std4Service.post(commandMap);
		breeding7Std5Service.post(commandMap);
		breeding7Std6Service.post(commandMap);
		breeding7Std7Service.post(commandMap);
		breeding7Std8Service.post(commandMap);
		breeding7Std9Service.post(commandMap);
		breeding7Std10Service.post(commandMap);
		breeding7Std11Service.post(commandMap);
		breeding7Std12Service.post(commandMap);
		breeding7Std13Service.post(commandMap);
		breeding7Std14Service.post(commandMap);

		Date end = new Date();
		long dur = DateUtil.getDurTime(start, end, "sec");
		return "breeding finished: "+dur+"s";
	}
	


}
