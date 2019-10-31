package com.sample.sample;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Map;

public class SampleApplication {

    private static ApplicationContext app;
    private static EntityManager manager;

    public static void main(String[] args) {
        app = new ClassPathXmlApplicationContext("bean.xml");
        LocalContainerEntityManagerFactoryBean factory = app.getBean(LocalContainerEntityManagerFactoryBean.class);
        manager = factory.getNativeEntityManagerFactory().createEntityManager();

        MyPersonData data = manager.find(MyPersonData.class, 1L);
        System.out.println(data);
    }

}
