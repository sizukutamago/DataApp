package com.sample.sample;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public class SampleApplication {

    private static JdbcTemplate jdbcTemplate;
    private static ApplicationContext app;

    public static void main(String[] args) {
        app = new ClassPathXmlApplicationContext("classpath:/bean.xml");
        jdbcTemplate = app.getBean(JdbcTemplate.class);

        jdbcTemplate.execute("insert into mypersondata (name, mail, age) values ('tayano', 'syoda@tuyano.com', 123)");
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from mypersondata");

        for (Map<String, Object> objectMap: list) {
            System.out.println(objectMap);
        }
    }

}
