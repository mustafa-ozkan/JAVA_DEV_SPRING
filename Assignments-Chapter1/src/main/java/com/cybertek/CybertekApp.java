package com.cybertek;

import com.cybertek.configs.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CybertekApp {
    AnnotationConfigApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class);

}
