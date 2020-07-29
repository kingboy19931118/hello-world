//package com.arbor.note.spring.springboot.beandefiened;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.beans.factory.support.DefaultListableBeanFactory;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.EnableAspectJAutoProxy;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.core.type.AnnotationMetadata;
//
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.util.Map;
//
//@Configuration
//@EnableAutoConfiguration
//@ComponentScan(basePackages = {"com.arbor.note.spring"})
//@EnableAspectJAutoProxy
//@Slf4j
//public class SimpleBootstrapApplication implements CommandLineRunner {
//	@Autowired
//	private static ApplicationContext applicationContext;
//
//	@Autowired
//	private static ClassPathXmlApplicationContext context;
//
//	// Simple example shows how a command li11ne spring application can execute an
//	// injected bean service. Also demonstrates how you can use @Value to inject
//	// command line args ('--name=whatever') or application properties
//
////	@Autowired
////	private HelloWorldService helloWorldService;
//
//	@Autowired
//	@Qualifier("helloWorldService")
//	private HelloWorldService helloWorldService1;
//
//
//	@Override
//	public void run(String... args) {
//		DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) applicationContext.getAutowireCapableBeanFactory();
//		AnnotatedBeanDefinition helloWorldService = (AnnotatedBeanDefinition) beanFactory.getBeanDefinition("helloWorldService");
//		AnnotationMetadata metadata1 = helloWorldService.getMetadata();
//		AnnotatedBeanDefinition annotatedBeanDefinition = (AnnotatedBeanDefinition) beanFactory.getBeanDefinition("helloWorldService");
//		AnnotationMetadata metadata = annotatedBeanDefinition.getMetadata();
//		Map<String, Object> annotationAttributes = metadata.getAnnotationAttributes("org.springframework.stereotype.Component");
//		log.info("annotationAttributes:{}",annotationAttributes);
////		System.out.println(this.helloWorldService.getHelloMessage());
//	}
//
//	public static void main(String[] args) throws Exception {
//		SpringApplication.run(SimpleBootstrapApplication.class, args);
//		// 这里设为true，不设也可以，默认就是true
//		context.setAllowBeanDefinitionOverriding(false);
//		context.refresh();
//
//	}
//}
