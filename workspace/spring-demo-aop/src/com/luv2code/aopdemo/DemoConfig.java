package com.luv2code.aopdemo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration // Spring pure java Configuration
@EnableAspectJAutoProxy // Spring AOP proxy support | AOP: Aspect Oriented Programming
@ComponentScan("com.luv2code.aopdemo") // Components and aspeces, will recurse on this package 
public class DemoConfig {

	
}
