package com.immoc.util;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class DataSourceTest {
    private ApplicationContext ctx=null;
    @Before
    public void before(){
        ctx=new ClassPathXmlApplicationContext("beans.xml");
        System.out.println("setup");

    }
    @After
    public void tearDown(){
        ctx=null;
        System.out.println("tearDown");
    }
    @Test
    public void testDtaSource(){
        System.out.println("testDataSource");
        DataSource dataSource =(DataSource) ctx.getBean("dataSource");
        Assert.assertNotNull(dataSource);

    }
    @Test
    public void testJcTemplate(){
        System.out.println("testJdbcTemplate");
        JdbcTemplate jdbcTemplate =(JdbcTemplate) ctx.getBean("jdbcTemplate");
        Assert.assertNotNull(jdbcTemplate);

    }

}
