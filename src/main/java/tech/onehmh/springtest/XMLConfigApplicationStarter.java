package tech.onehmh.springtest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Проверка формирования контекста Spring из xml-конфигурации
 */
public class XMLConfigApplicationStarter
{
    public static void main(String[] args)
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        DatabaseService databaseCsa = context.getBean("databaseCsa", DatabaseService.class);
        System.out.println(databaseCsa.getName());

        DatabaseService databaseLog = context.getBean("databaseLog", DatabaseService.class);
        System.out.println(databaseLog.getName());

        DatabaseService databaseDefault = context.getBean("databaseDefault", DatabaseService.class);
        System.out.println(databaseDefault.getName());

        UserInfoService userInfoService = context.getBean(UserInfoService.class);
        System.out.println(userInfoService.getUserInfo(1L));

        UserInfoGuid guid1 = context.getBean(UserInfoGuid.class);
        UserInfoGuid guid2 = context.getBean(UserInfoGuid.class);

        System.out.println("guid 1: " + guid1.asString());
        System.out.println("guid 2: " + guid2.asString());

    }
}
