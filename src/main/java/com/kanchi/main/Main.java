package com.kanchi.main;


import com.kanchi.service.UserServiceImpl;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

        AbstractApplicationContext applicationContext=new FileSystemXmlApplicationContext("servlet-context.xml");
//        applicationContext.registerShutdownHook();
//        BeanFactory beanFactory=applicationContext;

        UserServiceImpl hibernateDao= applicationContext.getBean("UserServiceImpl", UserServiceImpl.class);

        System.out.println(hibernateDao.getUserCount());

    }
}
//F:\Learn\Java\GameKade\GameKadeWeb3\src\main\webapp\WEB-INF\spring\appServlet\servlet-context.xml

