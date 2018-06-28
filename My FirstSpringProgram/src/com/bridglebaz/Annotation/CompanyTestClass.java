package com.bridglebaz.Annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CompanyTestClass {
   public static void main(String[] args) {
      ApplicationContext ctx = 
         new AnnotationConfigApplicationContext(CompanyConfig.class);
      SiemensCompany company2=ctx.getBean(SiemensCompany.class);
      company2.reception();
   }
}