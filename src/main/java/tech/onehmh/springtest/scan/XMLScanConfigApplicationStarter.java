package tech.onehmh.springtest.scan;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import tech.onehmh.springtest.common.DatabaseService;

/**
 * Проверка формирования контекста Spring из xml-конфигурации + сканирования аннотаций
 */
public class XMLScanConfigApplicationStarter
{
    public static void main(String[] args)
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("configScan.xml");

        DatabaseService databaseCsa = context.getBean("databaseCsaAnno", DatabaseService.class);
        System.out.println(databaseCsa.getName());
        System.out.println(databaseCsa.getUserInfoById(1L));

        DatabaseService databaseLog = context.getBean("databaseLogAnno", DatabaseService.class);
        System.out.println(databaseLog.getName());

        DatabaseService databaseDefault = context.getBean("databaseDefaultAnno", DatabaseService.class);
        System.out.println(databaseDefault.getName());

        UserInfoServiceAnno userInfoService = context.getBean(UserInfoServiceAnno.class);
        System.out.println(userInfoService.getUserInfo(1L));

        UserInfoGuidAnno guid1 = context.getBean(UserInfoGuidAnno.class);
        UserInfoGuidAnno guid2 = context.getBean(UserInfoGuidAnno.class);

        System.out.println("guid 1: " + guid1.asString());
        System.out.println("guid 2: " + guid2.asString());

    }
}
