package tech.onehmh.springtest.scan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import tech.onehmh.springtest.common.DatabaseName;
import tech.onehmh.springtest.common.DatabaseService;

@Component("databaseLogAnno")
public class LogDatabaseServiceAnno implements DatabaseService
{
    private final DatabaseName name;

    @Autowired
    public LogDatabaseServiceAnno(@Qualifier("logName") DatabaseName name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name.asString();
    }

    @Override
    public String getUserInfoById(Long id)
    {
        return "UserInfo from " + getName();
    }
}
