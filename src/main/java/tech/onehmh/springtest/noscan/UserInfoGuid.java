package tech.onehmh.springtest.noscan;

/**
 * Уникальный id для UserInfo
 */
public class UserInfoGuid
{
    private final String guid;

    public UserInfoGuid(String guid)
    {
        this.guid = guid;
    }

    public String asString()
    {
        return guid;
    }
}
