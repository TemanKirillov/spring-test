package tech.onehmh.springtest;

import org.apache.commons.lang3.RandomStringUtils;

/**
 * Уникальный id для UserInfo
 */
public class UserInfoGuid
{
    private final String guid;

    public UserInfoGuid()
    {
        this.guid = RandomStringUtils.randomAlphanumeric(10);
    }

    public String asString()
    {
        return guid;
    }
}
