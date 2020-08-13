package newegg.sched;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import io.mkeasy.resolver.CommandMap;
import lombok.extern.slf4j.Slf4j;
import newegg.breeding.service.BreedingBulkService;
import newegg.broiler.service.BroilerBulkService;
import newegg.snap.service.SnapBulkService;

@Slf4j
@Component
public class EggScheduleTask {

	@Autowired
	BreedingBulkService breedingBulkService;

	@Autowired
	BroilerBulkService broilerBulkService;

	@Autowired
	SnapBulkService snapBulkService;

	// cron = "* * * * * *" 초 분 시 일 월 요일
	@Scheduled(initialDelay = 5000, fixedDelay = 1000 * 60 * 30, zone = "Asia/Seoul")
	public void etlTask() throws Exception {

		CommandMap commandMap = new CommandMap();

		breedingBulkService.post(commandMap);
		broilerBulkService.post(commandMap);
		snapBulkService.post(commandMap);

	}
}
