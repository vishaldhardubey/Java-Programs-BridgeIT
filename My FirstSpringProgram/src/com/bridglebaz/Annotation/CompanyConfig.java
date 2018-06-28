package com.bridglebaz.Annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CompanyConfig {
   
   @Bean
   public SiemensCompany company2() {
	   return new SiemensCompany(company());
   }
   
   @Bean 
   public Company company(){
      return new Company();
   }
}