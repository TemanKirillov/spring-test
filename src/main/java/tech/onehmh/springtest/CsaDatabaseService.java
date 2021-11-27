package tech.onehmh.springtest;

public class CsaDatabaseService implements DatabaseService
{
    private final DatabaseName name;
    private String userInfoTableName;

    public CsaDatabaseService(DatabaseName name)
    {
        this.name = name;
    }

    @Override
    public String getName()
    {
        return name.asString();
    }

    @Override
    public String getUserInfoById(Long id)
    {
        return String.format("UserInfo(id=%d) from %s (%s)", id, getUserInfoTableName(), getName());
    }

    public String getUserInfoTableName()
    {
        return userInfoTableName;
    }

    public void setUserInfoTableName(String userInfoTableName)
    {
        this.userInfoTableName = userInfoTableName;
    }
}
