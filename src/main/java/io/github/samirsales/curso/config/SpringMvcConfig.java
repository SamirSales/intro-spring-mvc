package io.github.samirsales.curso.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import io.github.samirsales.curso.web.conversor.GenderConverter;

@Configuration
public class SpringMvcConfig implements WebMvcConfigurer{

	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		resolver.setViewClass(JstlView.class);
		return resolver;
	}
	
	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addConverter(new GenderConverter());
	}
}
