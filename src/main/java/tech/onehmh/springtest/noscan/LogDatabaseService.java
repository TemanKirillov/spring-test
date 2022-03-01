package tech.onehmh.springtest.noscan;

import tech.onehmh.springtest.common.DatabaseName;
import tech.onehmh.springtest.common.DatabaseService;

public class LogDatabaseService implements DatabaseService
{
    private final DatabaseName name;

    public LogDatabaseService(DatabaseName name)
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
