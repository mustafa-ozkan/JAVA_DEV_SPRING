package com.cybertek;

import com.cybertek.interfaces.Course;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CybertekApp {
    public static void main(String[] args) {
        ApplicationContext container =  new ClassPathXmlApplicationContext("config.xml");
        Course course = container.getBean("java", Course.class);
        course.getTeachingHours();

        Course course1 = container.getBean("selenium", Course.class);
        course1.getTeachingHours();


        Course course2 = container.getBean("API", Course.class);
        course2.getTeachingHours();
    }
}