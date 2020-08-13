package newegg.snap.service;

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
public class SnapBulkService implements EtlService {

	@Autowired
	Snap1MainServiceImpl snap1MainService;

	@Autowired
	Snap2EggTransferServiceImpl snap2EggTransferService;

	@Autowired
	Snap3HatcheryRecvServiceImpl snap3HatcheryRecvService;

	@Autowired
	Snap4GradingServiceImpl snap4GradingService;

	@Autowired
	Snap5SettingServiceImpl snap5SettingService;

	@Autowired
	Snap6HatchingServiceImpl snap6HatchingService;

	@Autowired
	RestClient restClient;
	
    private String method = "POST";
    private String endpoint = "_bulk";

	public String post(CommandMap commandMap) throws Exception {

		Date start = new Date();

		snap1MainService.post(commandMap);
		snap2EggTransferService.post(commandMap);
		snap3HatcheryRecvService.post(commandMap);
		snap4GradingService.post(commandMap);
		snap5SettingService.post(commandMap);
		snap6HatchingService.post(commandMap);

		Date end = new Date();
		long dur = DateUtil.getDurTime(start, end, "sec");
		return "snap finished: "+dur+"s";
	}

}
