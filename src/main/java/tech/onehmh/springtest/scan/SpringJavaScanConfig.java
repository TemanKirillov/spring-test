package tech.onehmh.springtest.scan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import tech.onehmh.springtest.common.DatabaseName;
import tech.onehmh.springtest.common.DatabaseService;

/**
 * Конфигурация Spring на чистой Java без XML
 *     Аналог XML-конфигурации configScan.xml
 *
 * @author Kirillov-AS
 * @since 16.02.2022
 */
@Configuration
@ComponentScan("tech.onehmh.springtest.scan")
@PropertySource("classpath:database.properties")
public class SpringJavaScanConfig
{
    @Bean(name = "csaName")
    public DatabaseName getCsaName()
    {
        return new DatabaseName("CSA");
    }

    @Bean(name = "logName")
    public DatabaseName getLogName()
    {
        return new DatabaseName("LOG");
    }

    @Bean(name = "databaseDefaultAnno")
    @Autowired
    public DatabaseService getDatabaseDefaultAnno(@Qualifier("databaseCsaAnno") DatabaseService service)
    {
        return service;
    }

}
