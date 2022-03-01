package tech.onehmh.springtest.noscan;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import tech.onehmh.springtest.common.DatabaseService;

/**
 * Проверка формирования контекста Spring из Java-конфигурации без сканирования аннотаций
 */
public class JavaConfigApplicationStarter
{
    public static void main(String[] args)
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringJavaConfig.class);

        DatabaseService databaseCsa = context.getBean("databaseCsa", DatabaseService.class);
        System.out.println(databaseCsa.getName());
        System.out.println(databaseCsa.getUserInfoById(1L));

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
