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
    }
}
