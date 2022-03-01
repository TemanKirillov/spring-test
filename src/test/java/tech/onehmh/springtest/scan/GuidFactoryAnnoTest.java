package tech.onehmh.springtest.scan;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * Тесты для {@link GuidFactoryAnno}
 *
 * @author Kirillov-AS
 * @since 16.02.2022
 */
public class GuidFactoryAnnoTest
{
    @Test
    public void createNewGuid()
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("configScan.xml");

        UserInfoGuidAnno guid1 = context.getBean(UserInfoGuidAnno.class);
        UserInfoGuidAnno guid2 = context.getBean(UserInfoGuidAnno.class);

        assertNotEquals(guid1.asString(), guid2.asString());
    }
}