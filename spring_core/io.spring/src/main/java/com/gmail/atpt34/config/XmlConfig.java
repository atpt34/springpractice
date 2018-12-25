package com.gmail.atpt34.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource({"classpath*:springContext.xml"})
@ComponentScan("epm.springtask")
public class XmlConfig {

}
