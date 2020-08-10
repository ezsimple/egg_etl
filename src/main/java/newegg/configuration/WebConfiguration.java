package newegg.configuration;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import io.mkeasy.resolver.CommandMapArgumentResolver;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@SuppressWarnings("deprecation")
public class WebConfiguration extends WebMvcConfigurerAdapter {
	
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(new CommandMapArgumentResolver());
    }
    
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new LoginInterceptor())
//            .addPathPatterns("/**")
//            .excludePathPatterns("/","/sign*.do","/error/*.do");
//    }

}
