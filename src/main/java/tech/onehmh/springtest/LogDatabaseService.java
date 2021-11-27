package tech.onehmh.springtest;

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
