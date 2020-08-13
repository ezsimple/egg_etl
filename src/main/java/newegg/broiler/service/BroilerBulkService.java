package newegg.broiler.service;

import java.util.Date;

import org.elasticsearch.client.RestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.mkeasy.resolver.CommandMap;
import io.mkeasy.utils.DateUtil;
import lombok.extern.slf4j.Slf4j;
import newegg.common.service.EtlService;

@Slf4j
@Service
public class BroilerBulkService  implements EtlService {
	
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
	
	@Autowired
	RestClient restClient;
	
    private String method = "POST";
    private String endpoint = "_bulk";

	public String post(CommandMap commandMap) throws Exception {

		Date start = new Date();

		broilerMainService.post(commandMap);
		broilerStd1Service.post(commandMap);
		broilerStd2Service.post(commandMap);
		broilerStd3Service.post(commandMap);
		broilerStd4Service.post(commandMap);
		broilerStd5Service.post(commandMap);

		Date end = new Date();
		long dur = DateUtil.getDurTime(start, end, "sec");
		return "broiler finished: "+dur+"s";
	}

}
