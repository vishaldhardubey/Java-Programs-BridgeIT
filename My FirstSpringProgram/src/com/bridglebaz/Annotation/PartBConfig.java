package com.bridglebaz.Annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

@Import(PartConfig.class)
public class PartBConfig {
	@Bean
	public PartB partB() {
		return new PartB();
	}
}
