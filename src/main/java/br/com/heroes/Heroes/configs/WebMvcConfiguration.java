package br.com.heroes.Heroes.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebMvcConfiguration implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
				.allowedOrigins("http://localhost:4200")
				// Adicionei o localhost (sem porta) aqui para conseguir acessar o backend pelo docker
				.allowedOrigins("http://localhost")
				.allowedMethods("*").maxAge(3600L)
				.allowedHeaders("*")
				.exposedHeaders("Authorization")
				.allowCredentials(true);
	}

}
