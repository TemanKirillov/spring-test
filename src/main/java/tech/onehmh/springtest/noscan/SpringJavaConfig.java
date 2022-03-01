package tech.onehmh.springtest.noscan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import tech.onehmh.springtest.common.DatabaseName;
import tech.onehmh.springtest.common.DatabaseService;

/**
 * Конфигурация Spring на чистой Java без XML
 *     Аналог XML-конфигурации applicationContext.xml
 *
 * @author Kirillov-AS
 * @since 16.02.2022
 */
@Configuration
@PropertySource("classpath:database.properties")
public class SpringJavaConfig
{
    private final Environment env;

    @Autowired
    public SpringJavaConfig(Environment env)
    {
        this.env = env;
    }

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

    @Bean(
            name = "databaseCsa",
            initMethod = "init",
            destroyMethod = "close"
    )
    public CsaDatabaseService getDatabaseCsa()
    {
        CsaDatabaseService service = new CsaDatabaseService(getCsaName());
        service.setUserInfoTableName(env.getProperty("csa.database.user.info.table.name"));
        return service;
    }

    @Bean(name = "databaseDefault")
    public DatabaseService getDatabaseDefault()
    {
        return getDatabaseCsa();
    }

    @Bean(name = "databaseLog")
    public LogDatabaseService getDatabaseLog()
    {
        return new LogDatabaseService(getLogName());
    }

    @Bean(name = "userInfoService")
    public UserInfoService getUserInfoService()
    {
        UserInfoService service = new UserInfoService();
        service.setDatabaseService(getDatabaseDefault());
        return service;
    }

    @Bean("guidFactory")
    public GuidFactory getGuidFactory()
    {
        return new GuidFactory();
    }

    @Bean("userInfoGuid")
    @Scope("prototype")
    public UserInfoGuid getUserInfoGuid()
    {
        return getGuidFactory().newUserInfoGuid();
    }

}
