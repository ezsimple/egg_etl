package newegg.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.mkeasy.utils.WebUtil;
import io.mkeasy.webapp.processor.EsFactory;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class ElasticConfiguration {
	
	@Bean
	public WebUtil webUtil() {
		return new WebUtil();
	}

	@Bean
	public EsFactory esFactory() {
		return new EsFactory();
	}

}
