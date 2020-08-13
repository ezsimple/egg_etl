package newegg.configuration;

import java.nio.charset.Charset;
import java.util.Arrays;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;
import newegg.utils.PropertiesUtil;

@Slf4j
@Configuration
public class RESTfulConfiguration {

	@Autowired
	PropertiesUtil propertiesUtil;

	@Bean
	public ObjectMapper objectMapper() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		mapper.configure(MapperFeature.DEFAULT_VIEW_INCLUSION, true);
		return mapper;
	}

	@Bean
	public RestTemplate restTemplate() {
		final RestTemplate restTemplate = new RestTemplate();
		restTemplate.setMessageConverters(Arrays.asList(
				new FormHttpMessageConverter()
				,new StringHttpMessageConverter(Charset.forName("UTF-8"))
				));
		return restTemplate;
	}
	
	@Bean
	public RestClient restClient() {
		String esHost = propertiesUtil.getProperty("elastic.url");
		int esPort = Integer.parseInt(propertiesUtil.getProperty("elastic.port"));
        log.debug("esHost : {}:{}",esHost, esPort);
		RestClient restClient = RestClient.builder(new HttpHost(esHost, esPort)).build();
		return restClient;
	}
}
