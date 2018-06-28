package com.bridgelabz.annotationlifecycleCallBack;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LifeCycleConfig {
	@Bean(initMethod="initialization", destroyMethod="destroy")
	public LifeCycle lifeCycle() {
		return new LifeCycle();
	}
}
