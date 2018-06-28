package com.bridglebaz.Annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PartConfig {
	@Bean
	public PartA partA() {
		return new PartA();
	}
}
